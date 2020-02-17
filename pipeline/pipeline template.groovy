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
//smoke Test
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
		credentials(name:'git_credential',defaultValue:'',description: '')
		string(name:'Serviceinfo',defaultValue:'DataHub:Small:sundisecret',description: '')		
		string(name:'DatacenterCode',defaultValue:'',description: '')  
		string(name:'cluster',defaultValue:'',description: '')  
		string(name:'Workspaceid',defaultValue:'',description: '')  
		string(name:'namespace',defaultValue:'',description: '')  
		string(name:'internaldomain',defaultValue:'',description:'')
		string(name:'repo',defaultValue:'',description: '') 
		string(name:'ssousername',defaultValue:'',description: '') 
		password(name:'ssopassword',defaultValue:'',description: '') 
		string(name:'ssotoken',defaultValue:'',description: '')	
		string(name:'harborusername',defaultValue:'',description: '') 
		password(name:'harborpassword',defaultValue:'',description: '') 
		string(name:'imageusername',defaultValue:'',description: '') 
		password(name:'imagepassword',defaultValue:'',description: '')
		string(name:'ssourl',defaultValue:'',description: '')
		string(name:'mpurl',defaultValue:'',description: '')
		string(name:'routeurl',defaultValue:'',description: '')
		string(name:'appdepencysevice',defaultValue:'Dashboard:Advanced-Edition:sundidisecret',description: '')
		string(name:'externaldomain',defaultValue:'',description: '')
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
							if("${Serviceinfo}" != "")
							{
								service_info_list = Serviceinfo.split(':')
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
							else
							{
								error 'servicename is not exist'
							}
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
							sh "helm repo add --kubeconfig kubeconfig.txt --username ${harborusername} --password ${harborpassword} ${Chartname} ${repo}"
							sh "helm repo update --kubeconfig kubeconfig.txt"
							echo "====部署或更新helm chart"
							sh "helm ls -n ${namespace} --kubeconfig kubeconfig.txt"
							sh "helm upgrade --install ${Releasename} --kubeconfig kubeconfig.txt ${Chartname}/${Chartname} --version ${Chartversion}  --namespace ${namespace} -f ./values.yaml --set database.secretName=${mainservicesecretname} --set url.host=${hosts} --wait"
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
							}
						}	
						sh 'ls'
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
	 