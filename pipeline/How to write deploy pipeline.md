
# 如何改写EnSaaS4.0部署Service的pipeline #

本文档主要是介绍EnSaaS4.0 pipeline中各参数意义及部署流程

通过pipeline部署Service总共分为以下几步：

1.	参数介绍
----------
- git_credential：git凭证
- Serviceinfo：包括servicename、plan、secret、version。数据格式为servicename:serviceplan:servicesecretname(:chartversion)，若chartversion为空，则默认部署最新版本
- DatacenterCode：数据中心名称
- cluster：集群名称
- Workspaceid：workspace id
- namespace：namespace名称
- internaldomain：内部domain
- externaldomain：外部domain
- appdepencysevice：依赖的common apps信息。数据格式为servicename:serviceplan:servicesecretname(:chartversion)，如果依赖的common apps有多个，则以“，”隔开
- repo：chart地址
- harborusername、harborusername：harbor账密，用来获取chart的凭证
- imageusername、imagepassword：image账密，用来拉取image的凭证。由于目前chart和image都在harbor上，所以使用harbor凭证即可。该字段先保留
- ssousername、ssopassword：EnSaaS4.0 sso账密
- ssotoken：ssotoken。和ssousername、ssopassword输入其一即可
- ssourl：该DatacenterCode对应的ssourl。若要利用sso账密获取ssotoken，则必须输入ssourl
- mpurl：该DatacenterCode对应的mpurl，用来获取kubeconfig
- routeurl：EnSaaS route url。若externaldomain为空，则需要输入routeurl，根据internaldomain获取extrnaldomain进行smoketest验证

2.	部署流程
----------
（1）准备阶段  

- 根据Serviceinfo获取mainservicename、mainserviceplanname、mainservicesecretname（chartversion）

		echo "=====获取main servicename、planname、secretname"
		if("${Serviceinfo}" != "")
		{
			service_info_list = Serviceinfo.split(':')
			mainservicename = service_info_list[0]
			mainserviceplanname = service_info_list[1]
			mainservicesecretname = service_info_list[2] 
			if("${service_info_list.length}" <= "3")
			{
				mainservicechartversion = ""
			}
			else
			{
				mainservicechartversion = service_info_list[3]
			}
		}
		else
		{
			error 'servicename is not exist'
		}

- 获取kubeconfig and deployment info（kubeconfig利用mp api获取，deploymeny info利用listingsystem api获取）

		echo "=====获取kubeconfig and deployment info"
		dir('getconfig')
		{
			getdeploymenturl = "http://api-listingsystem-master.es.wise-paas.cn/v1/deployment/${mainservicename}/plan/${mainserviceplanname}?chartVersion=${mainservicechartversion}"
			echo "${getdeploymenturl}"
			if ("${ssotoken}" == ""){
				sh "python3 ../cf_operation/getkubeconfig.py 0 ${ssousername} ${ssopassword} ${DatacenterCode} ${cluster} ${ssourl} ${mpurl}"	
				sh "python3 ../cf_operation/deploymentjson.py 0 ${ssourl} ${ssousername} ${ssopassword} ${getdeploymenturl}"									
			}else{
				sh "python3 ../cf_operation/getkubeconfig.py 1 ${ssotoken} ${DatacenterCode} ${cluster} ${mpurl}"	
				sh "python3 ../cf_operation/deploymentjson.py 1 ${ssotoken} ${getdeploymenturl}"
			}
			sh "ls"
			sh "cat kubeconfig.txt"	
			
			if(fileExists("apollo.json"))
			{
				APPS = readJSON file: "apollo.json"
			}
			else
			{
				error "Connot get apollo config"
			}								
		}

- 拼接hosts，用于替换values.yaml中url字段对应的value；获取chartname、chartversion；若externaldomain为空，根据internaldomain获取externaldomain
	
		//echo "=====获取hosts"
		hosts = ".${namespace}.${internaldomain}"
		echo "${hosts}"
		echo "=====获取Chartname、Chartversion"
		Chartname=APPS['param']['chartname']
		Chartversion=APPS['param']['version']
		echo "${Chartname}"
		//获取externaldomain
		dir('getexternaldomain')
		{
			if("${externaldomain}" == "")
			{
				sh " python3 ../cf_operation/getexternaldomian.py ${routeurl} ${internaldomain}"
				externaldomain=readFile("externaldomain.txt").trim()
				echo "${externaldomain}"
			}
		}

（2）依赖的common apps阶段

- 并发部署依赖的common apps
 
		container('jenkins-node-dashboard')
		{
			if ("${appdepencysevice}" == "") 
			{
				echo 'no dependency app service'
			} 
			else
			{
				appdepencysevice_info_list = appdepencysevice.split(',')
				if(appdepencysevice_info_list[0]!="" || appdepencysevice_info_list[0]!=null)
				{
					def branches = [:]
					for(int j = 0;j<appdepencysevice_info_list.length;j++)
					{
						def appserviceinfo = appdepencysevice_info_list[j]
						echo "${appserviceinfo}"
						def appservice = appserviceinfo.split(':')
						def appservicename = appservice[0]
						echo "${appservicename}"
						branches["Build ${appservicename}"] = { Deploydependsrps(appserviceinfo,appservicename) }
					}
					parallel branches
				}	
			}
		}
- 部署依赖的common apps需要传入的参数，以dashboard为例：

		def Deploydependsrps(appinfo,appname)
		{
			build job: "${appname}-Release", parameters: [
				[$class: 'StringParameterValue', name: 'Serviceinfo', value: "${appinfo}"],
				[$class: 'StringParameterValue', name: 'DatacenterCode', value: "${DatacenterCode}"],
				[$class: 'StringParameterValue', name: 'cluster', value: "${cluster}"],
				[$class: 'StringParameterValue', name: 'Workspaceid', value: "${Workspaceid}"],
				[$class: 'StringParameterValue', name: 'namespace', value: "${namespace}"],
				[$class: 'StringParameterValue', name: 'internaldomain', value: "${internaldomain}"],
				[$class: 'StringParameterValue', name: 'externaldomain', value: "${externaldomain}"],
				[$class: 'StringParameterValue', name: 'ssourl', value: "${ssourl}"],
				[$class: 'StringParameterValue', name: 'mpurl', value: "${mpurl}"],
				[$class: 'StringParameterValue', name: 'routeurl', value: "${routeurl}"],
				[$class: 'StringParameterValue', name: 'ssotoken', value: "${ssotoken}"],
				[$class: 'StringParameterValue', name: 'ssousername', value: "${ssousername}"],
				[$class: 'PasswordParameterValue', name: 'ssopassword', value: "${ssopassword}"]]
		}

（3）主Service部署阶段

- 添加chart repo

		echo "====添加chartrepo"
		sh "helm repo add --kubeconfig kubeconfig.txt --username ${harborusername} --password ${harborpassword} ${Chartname} ${repo}"

- 部署helm chart
	
		echo "====部署或更新helm chart"
		sh "helm ls -n ${namespace} --kubeconfig kubeconfig.txt"
		sh "helm upgrade --install ${Releasename} --kubeconfig kubeconfig.txt ${Chartname}/${Chartname} --version ${Chartversion}  --namespace ${namespace} -f ./values.yaml --set database.secretName=${mainservicesecretname} --set url.host=${hosts} --wait"
	
- smoketest（根据deployment info中填写的urlprefix进行smoketest）

		//smokestest
		if(APPS['urlprefix'] != "")
		{
			urlPrefix = APPS['urlprefix']
			if(urlPrefix !=null && urlPrefix!="")
			{
				Prefix = urlPrefix.split(",")
				if(Prefix[0]!="" || Prefix[0]!=null)
				{
					url=""
					for(int j = 0;j<Prefix.length;j++)
					{
						url = "${Prefix[j]}-${namespace}-${externaldomain}"
						if(url != "")
						{
							echo "${url}"
							retry(5)
							{
								smokeTest(url)
							}
						}
					}
				}	
			}
		} 

（4）导入datasource、dashboard、srpframe（基本与3.0导入dashboard一致）

- 验证dashboard url是否可以正常访问，若正常访问，则导入，否则直接退出
	
		dir('getexternaldomain')
		{
			if(externaldomain != "")
			{
				dashboard_url = "https://dashboard-${namespace}-${externaldomain}"
				echo "${dashboard_url}"
				retry(3)
				{
					smokeTest("dashboard-${namespace}-${externaldomain}")
				}
				
			}
			else
			{
				error "dashboard url is not exist"
			}
		}

- 若导入PostgreSQL datasource，可获取secret中postgresql连接信息，然后修改datasource中的postgresql连接信息
	
		//获取postgresql连接信息
		dir('getconfig')
		{
			sh "mv kubeconfig.txt ~/.kube/config "
			sh "kubectl get secret '${mainservicesecretname}' -n ${namespace} -o json >> secretinfo.json"
			sh "python3 ../cf_operation/getpostgresqlsecretinfo.py secretinfo.json"
			sh "ls"
			sh "cat datasource.json"
			pgDatasouce = readJSON file: "datasource.json"				
			echo '================Read File==============='
			echo "PGHOST:${pgDatasouce['host']} "
			echo "PGusername:${pgDatasouce['username']} "
		}	
		//根据获取的postgresql连接信息，修改datasource文件中的postgresql连接信息
		dir("datasource")
		{
			sh 'ls'
			sh 'cat postgres.json'
			//修改datasource
			def sourcedata = readJSON file: "postgres.json"
			sourcedata['database'] = pgDatasouce['database']
			sourcedata['user'] = pgDatasouce['username']
			sourcedata['password'] = pgDatasouce['password']
			sourcedata.secureJsonData['password'] = pgDatasouce['password']
			sourcedata['url'] =  pgDatasouce['host'] 				
			echo "sourcedata:${sourcedata}"
			sh 'rm -rf *'
			echo '================output File==============='
			writeJSON file: 'postgres.json', json: sourcedata						
			sh 'ls'
			sh 'cat postgres.json'						
		}	

- 导入datasource、dashboard、srpframe
	
		dir("importgrafana")
		{
			sh 'ls'
			def srpframeReplace = "https://dashboard-ifactory-adviiot-ifactory-ifactory.wise-paas.com,https://dashboard-${namespace}-${externaldomain}"
			def OeeEnReplace = "https://api-srpalert.wise-paas.com/oeeen,https://api-srpAlert-${namespace}-${externaldomain}/oeeen"
			def OeeCnReplace = "https://api-srpalert.wise-paas.com/oeecn,https://api-srpAlert-${namespace}-${externaldomain}/oeecn"
			def OeeTwReplace = "https://api-srpalert.wise-paas.com/oeetw,https://api-srpAlert-${namespace}-${externaldomain}/oeetw"
			sh "python3 ImportDashboard_1_3_0.py -a ${dashboard_url} -t datasource -d ../dashboardresource/datasource"
			sh "python3 ImportDashboard_1_3_0.py -a ${dashboard_url} -t dashboard -d ../dashboardresource/dashboard"													
			sh "python3 ImportDashboard_1_3_0.py -a ${dashboard_url} -t srpframe -e ${srpframeReplace}***${OeeEnReplace}***${OeeCnReplace}***${OeeTwReplace} -d ../dashboardresource/srpframe"
		}

6. 异常处理（post机制）
----------

- failure：如果在以上各个阶段出现问题都会进入到这个failure代码块中，报出error信息
- success：当代码顺利执行完毕后就会进入该代码块中
