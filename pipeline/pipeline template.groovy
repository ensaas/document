def getservice(serviceInfo)
{
	if (serviceInfo == "") 
	{
		error 'serviceInfo is not exist'
	} 
	else
	{
		service_info_list = serviceInfo.split(':')
		mainservicename = service_info_list[0]
		mainserviceplanname = service_info_list[1]
		mainservicesecretname = service_info_list[2] 
		if("${service_info_list.length}" == "3")
		{
			mainservicechartversion = ""
		}
		else
		{
			mainservicechartversion = service_info_list[3]
		}
	}
}

def Deploydependsrps(appinfo,appname)
{
		build job: "${appname}-Release", parameters: [
			[$class: 'StringParameterValue', name: 'serviceInfo', value: "${appinfo}"],
			[$class: 'StringParameterValue', name: 'datacenterCode', value: "${datacenterCode}"],
			[$class: 'StringParameterValue', name: 'cluster', value: "${cluster}"],
			[$class: 'StringParameterValue', name: 'workspaceId', value: "${workspaceId}"],
			[$class: 'StringParameterValue', name: 'namespace', value: "${namespace}"],
			[$class: 'StringParameterValue', name: 'internalDomain', value: "${internalDomain}"],
			[$class: 'StringParameterValue', name: 'externalDomain', value: "${externalDomain}"],
			[$class: 'StringParameterValue', name: 'ssoToken', value: "${ssoToken}"],
			[$class: 'StringParameterValue', name: 'ssoUsername', value: "${ssoUsername}"],
			[$class: 'PasswordParameterValue', name: 'ssoPassword', value: "${ssoPassword}"]]
}
//smoke Test,appName:要测试的app,在此场景中为：portal-scada
def smokeTest(url)
{
	if (url != "")
	{
		sh "curl -I -o /dev/null -s -w %{http_code} https://${url} >>ss.txt"
		stateCodeWithVersion=readFile('ss.txt')
		if(stateCodeWithVersion != "200")
		{
    		error 'smoke test failed'
    	}else
		{
    		echo "smoke test success"
    	}
		sh 'truncate -s 0 ss.txt'
	}
}
pipeline
{
	agent 
	{
		kubernetes {
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: jenkins-node-dashboard
    image: harbor.wise-paas.io/library/jenkins-alpinenode-helm:v9
    imagePullPolicy: Always
    securityContext:
        capabilities:
            add:
              - NET_ADMIN
    tty: true
"""
    }
	}
	parameters{
		credentials(name:'git_credential',defaultValue:'00994ab9-109c-4c94-8eb9-2b9c4bf141e6',description: '')
		string(name:'serviceInfo',defaultValue:'DataHub:Small:scadasecret',description: '')		
		string(name:'datacenterCode',defaultValue:'local',description: '')  
		string(name:'cluster',defaultValue:'master',description: '')  
		string(name:'workspaceId',defaultValue:'67bfac94-0607-45b1-bec5-704656e66b7c',description: '')  
		string(name:'namespace',defaultValue:'sundi',description: '')  
		string(name:'internalDomain',defaultValue:'master.internal',description:'')
		string(name:'repo',defaultValue:'http://core-harbor-devops-ali.wise-paas.com.cn/chartrepo/sunditest',description: '') 
		string(name:'ssoUsername',defaultValue:'1364886977@qq.com',description: '') 
		password(name:'ssoPassword',defaultValue:'Sd@13648',description: '') 
		string(name:'ssoToken',defaultValue:'',description: '')	
		string(name:'harborUsername',defaultValue:'sundi',description: '') 
		password(name:'harborPassword',defaultValue:'Sd18792744085',description: '') 
		string(name:'imageUsername',defaultValue:'sundi',description: '') 
		password(name:'imagePassword',defaultValue:'Sd18792744085',description: '')
		string(name:'appDepencySevice',defaultValue:'Dashboard:Advanced-Edition:sundidisecret',description: '')
		string(name:'externalDomain',defaultValue:'master.es.wise-paas.cn',description: '')
	}
	stages
	{
		stage('Prepare')
		{
			steps{
			    timeout(50)
			    {
					script
					{
						container('jenkins-node-dashboard')
						{
							echo "Prepare start"
							echo "=====拉取公共脚本"
							dir('cf_operation')
							{
								retry(2)
								{
									git credentialsId: "${git_credential}", url: 'http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS_SRP_Pipeline/DevPublic.git'
									sh "ls"
								}
								sh 'chmod 770 *.sh'
								sh 'chmod 770 *.py'
							}	
							echo "=====获取main servicename、planname、secretname"
							if("${serviceInfo}" != "")
							{
								getservice(serviceInfo)
							}
							echo "=====获取kubeconfig"
							dir('getconfig')
							{
								if ("${datacenterCode}" == "") 
								{
									error 'datacenterCode is not exist'
								} 
								else
								{
									retry(2)
									{
										sh "curl 'http://api-listingsystem-master.es.wise-paas.cn/v1/datacenter?datacenterCode=${datacenterCode}' -k > datacenterUrl.json"
									}
									if(fileExists("datacenterUrl.json"))
									{
										datacenterUrls = readJSON file: "datacenterUrl.json"
										urls = datacenterUrls["data"][0]["datacenterUrl"]
										echo "=====获取ssourl、mpurl、routeurl"
										ssourl=urls['api-sso']['externalUrl']
										mpurl=urls['api-mp']['externalUrl']
										routeurl=urls['api-router']['externalUrl']
									}
									else
									{
										error "Connot get datacenterUrl config"
									}								
								}	
								getdeploymenturl = "http://api-listingsystem-master.es.wise-paas.cn/v1/deployment/${mainservicename}/plan/${mainserviceplanname}?chartVersion=${mainservicechartversion}"
								echo "${getdeploymenturl}"
								if ("${ssoToken}" == ""){
									sh "python3 ../cf_operation/getkubeconfig.py 0 ${ssoUsername} ${ssoPassword} ${datacenterCode} ${cluster} ${ssourl} ${mpurl}"	
									sh "python3 ../cf_operation/deploymentjson.py 0 ${ssourl} ${ssoUsername} ${ssoPassword} ${getdeploymenturl}"									
								}else{
									sh "python3 ../cf_operation/getkubeconfig.py 1 ${ssoToken} ${datacenterCode} ${cluster} ${mpurl}"	
									sh "python3 ../cf_operation/deploymentjson.py 1 ${ssoToken} ${getdeploymenturl}"
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
							
							//echo "=====获取hosts"
							hosts = ".${namespace}.${internalDomain}"
							echo "${hosts}"
							echo "=====获取Chartname、Chartversion"
							Chartname=APPS['param']['chartname']
							Chartversion=APPS['param']['version']
							Values=APPS['values']
							echo "${Chartname}"
							//获取externaldomain
							dir('getexternaldomain')
							{
								if("${externalDomain}" == "")
								{
									sh " python3 ../cf_operation/getexternaldomian.py ${routeurl} ${internalDomain}"
									externalDomain=readFile("externaldomain.txt").trim()
									echo "${externalDomain}"
								}
							}
							servicename= "${mainservicename}".toLowerCase()
							Releasename = "${servicename}-${namespace}"
						}
					}
				}
			}
		}
		stage('deploy dependency service')
		{
			steps
			{
				script
				{
					container('jenkins-node-dashboard')
					{
						dir('getconfig'){
							if ("${appDepencySevice}" == "") 
							{
								echo 'no dependency app service'
							} 
							else
							{
								appdepencysevice_info_list = appDepencySevice.split(',')
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
					}
				}
			}		
		}
		stage('deploy service')
		{
			steps
			{
				script
				{
					container('jenkins-node-dashboard')
					{
						echo "=====添加chartrepo、部署helm chart"
						dir('getconfig')
						{
							echo "====添加chartrepo"
							sh "helm repo add --kubeconfig kubeconfig.txt --username ${harborUsername} --password ${harborPassword} ${Chartname} ${repo}"
							sh "helm repo update --kubeconfig kubeconfig.txt"
							echo "====部署或更新helm chart"
							sh "helm ls -n ${namespace} --kubeconfig kubeconfig.txt"
							sh "helm upgrade --install ${Releasename} --kubeconfig kubeconfig.txt ${Chartname}/${Chartname} --version ${Chartversion}  --namespace ${namespace} -f ./values.yaml --set database.secretName=${mainservicesecretname},url.host=${hosts} --wait"
							//smokestest
							/*if(APPS['urlprefix'] != "")
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
											url = "${Prefix[j]}-${namespace}-${externalDomain}"
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
							}*/
						}	
					}
				}
			}
		}
		stage('Importdashboard')
		{
			steps
			{
				script
				{
					container('jenkins-node-dashboard')
					{
						dashboard_resource = "http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS_SRP_Pipeline/Wisemplus.git"
						//利用route api 根据internal domain获取external domain
						dir('getexternaldomain')
						{
							if(externalDomain != "")
							{
								dashboard_url = "https://dashboard-${namespace}-${externalDomain}"
								echo "${dashboard_url}"
								retry(3)
								{
									smokeTest("dashboard-${namespace}-${externalDomain}")
								}
								
							}
						}
						//设置kubeconfig
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
						dir("importgrafana")
						{
							retry(2)
							{
								git credentialsId: "${git_credential}", url: 'http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS_SRP_Pipeline/DevPublic.git'
							}
						}
						dir("dashboardresource")
						{
							retry(2)
							{
								git branch: 'master',credentialsId: "${git_credential}",url:"http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS_SRP_Pipeline/OEE.git"
								//sh "git checkout master"  //下载develop分支的代码
								sh 'ls'
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
							}
						}	
						sh 'ls'
						dir("importgrafana")
						{
							sh 'ls'
							def srpframeReplace = "https://dashboard-ifactory-adviiot-ifactory-ifactory.wise-paas.com,https://dashboard-${namespace}-${externalDomain}"
							def OeeEnReplace = "https://api-srpalert.wise-paas.com/oeeen,https://api-srpAlert-${namespace}-${externalDomain}/oeeen"
							def OeeCnReplace = "https://api-srpalert.wise-paas.com/oeecn,https://api-srpAlert-${namespace}-${externalDomain}/oeecn"
							def OeeTwReplace = "https://api-srpalert.wise-paas.com/oeetw,https://api-srpAlert-${namespace}-${externalDomain}/oeetw"
							sh "python3 ImportDashboard_1_3_0.py -a ${dashboard_url} -t datasource -d ../dashboardresource/datasource"
							sh "python3 ImportDashboard_1_3_0.py -a ${dashboard_url} -t dashboard -d ../dashboardresource/dashboard"													
							sh "python3 ImportDashboard_1_3_0.py -a ${dashboard_url} -t srpframe -e ${srpframeReplace}***${OeeEnReplace}***${OeeCnReplace}***${OeeTwReplace} -d ../dashboardresource/srpframe"
						}
					}
				}	
			}
		}			
		
	}
	post 
	{	
		failure 
		{ 
			script 
			{
				container('jenkins-node-dashboard')
				{
					echo "FAILED"
				}	
			}
				
		}
		success{
			script{
				container('jenkins-node-dashboard')
				{
					echo "SUCCUSS"
				}
			}
		}
	}
}
