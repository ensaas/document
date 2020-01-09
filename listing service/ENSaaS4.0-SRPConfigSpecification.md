## ENSaaS4.0 SRP部署需要提供的参数 ##
相较于ENSaaS3.0，SRP部署时，需要提供的参数发生了变化，以下针对各参数进行解释说明，并以SCADA为例给出了示例。  
### 1、参数说明 ###
##### 1.1 version #####

- 说明：即SRP的大版本号，同时也是chart的版本号，注意不是APP的版本号。
- 要求：SRP上架时，所提供的Chart版本号必须与SRP大版本号保持一致，且只能是3位。
- 示例：以SCADA为例，输入格式如下。
	    
	    version = 1.1.37

##### 1.2 extraParam #####

- 说明：即每个SRP部署完成后，外部访问入口的urlPrifx（list类型）。比如，SCADA的外部访问入口urlPrifx为portal-scada；VideoService有两个外部访问入口，urlPrifx分别为api-vcm和portal-vcm。
- 要求：urlPrifix key必须填写，value可以为空。
- 示例：以VideoService为例，VideoService有两个外部访问入口：urlPrefix分别为api-vcm和portal-vcm，输入格式如下：

		extraParam = 						
                      {  
                          "urlPrefix":
				[
				  "api-vcm",
				  "portal-vcm"
				]  
                      }

##### 1.3 dataServicesDependency #####

- 说明：即SRP所要绑定的服务。
- 示例：比如SCADA需要绑定MongoDB、Rabbitmq、Postgresql服务，输入格式如下：  


		dataServicesDependency = 
                                 [
                                      {  
                                        "name": "MongoDB", 
                                        "plan":
                                         [
                                            "Shared"
                                         ] 
                                        "version": "",  
                                        "discription": "" 
                                      },  
                                      {  
                                        "name": "Rabbitmq",
                                        "plan":
                                         [
                                            "standard"
                                         ]  
                                        "version": "",  
                                        "discription": ""
                                      },
                                      {  
                                        "name": "Postgresql", 
                                        "plan":
                                         [
                                            "Shared"
                                         ] 
                                        "version": "",  
                                        "discription": ""
                                      }
                                ]         

其中：  

- name：服务的名称；
- plan：service plan（list类型），value可以输入为空或多个。其中，输入为空，用户订阅时，则可以在DB所支持的plan里面任选一种；输入多个指定plan，用户订阅则只能在指定的plan里选择一种  
- version：服务的版本，如果没有，则输入为空；  
- discription：对该服务的描述，可以输入为空。

##### 1.4 apps #####

- 说明：即每个SRP中包括的APP，部署时需要提供每个APP的相应参数，参数说明如下：
  - name：APP的名字； 
  - version：APP的版本号，即为image tag号（注意：上架时，image tag只能为3位）； 
  - memory：APP所需要的运行内存，单位为GB； 
  - cpu： APP所需要的CPU，单位为Core；
  - dataServicesDependency：APP所要绑定的服务，其中Key为Service Name，Value为Service的一些参数； 
   - params：预留参数。 
- 示例：以SCADA为例，SCADA包括2个APP，2个APP部署时所需参数输入格式如下：   

		  apps =
                 [
                    {
                        "name": "scada-dataworker",
                        "version": "1.3.30",
                        "memory": "0.25",
                        "cpu":"1",
                        "dataServicesDependency": {
                            "influxdb": "",
                            "redis": "",
                            "mongodb": "",
                            "rabbitmq": "",
                            "postgresql": {
                                "postgresql_service_group": "g_scada"
                            }
                        },
                        "params": {}
                    },
                    {
                        "name": "portal-scada",
                        "version": "1.3.37",
                        "memory": "0.5",
                        "cpu":"1",
                        "dataServicesDependency": {
                            "influxdb": "",
                            "redis": "",
                            "mongodb": "",
                            "rabbitmq": "",
                            "postgresql": {
                                "postgresql_service_group": "g_scada"
                            }
                        },
                        "params": {}
                    }
                 ]  

##### 1.5 appServicesDependency #####

- 说明：即SRP所依赖的其他Common Apps。其中： 
  - name：所依赖Common Apps的名称；  
  - plan：Common Apps plan（list类型），value可以输入为空或多个。其中，输入为空，用户订阅时，则可以在Common Apps所支持的plan里面任选一种；输入多个指定plan，用户订阅则只能在指定的plan里选择一种；
  - version：所依赖SRP的版本号，若为空，则默认部署最新版本SRP，否则部署指定版SRP。
- 示例：比如，SCADA不依赖于其他SRP，所以这项为空。APM-CNC依赖于Dashboard、SCADA、APM等，因此APM-CNC这一项会填写Dashboard、SCADA、APM，APM-CNC的该项输入格式如下。  
		
		appServicesDependency = 
                                [
                                  {  
                                    "name": "Grafana",
                                    "plan": ""
                                    "version": ""  
                                  },
                                  {  
                                    "name": "SCADA",
                                    "plan":""
                                    "version": ""
                                  },
                                  {  
                                    "name": "APM",
                                    "plan":""
                                    "version": ""
                                  }
                                ]


##### 1.6 name #####

- 说明：即SRP的名称。
- 示例：以SCADA为例，name为SCADA，输入格式如下。
        
        name = SCADA

##### 1.7 catalog #####

- 说明：SRP归属类别。
- 示例：以SCADA为例，输入格式如下。
        
        catalog = SCADA 

##### 1.8 description #####

- 说明：即针对SRP用途所做的描述。
- 示例：以SCADA为例，description为Users can monitor and control their projects simply through a web browser，输入格式如下。
    
        description = Users can monitor and control their projects simply through a web browser

##### 1.9 releaseNote #####

- 说明：发布说明，输入格式如下。

		releaseNote = 
                      [Scada Portal v-1.3.37] Changelog
                      - Added
                        - 支援http/https兩種InfluxDB連線方式
                      - Updated
                        - scadaId維持32個字元(guid)
                        - real data 查詢tag數上限設為一萬筆 (real raw/real convert/simplejson real)
                      - Fixed
                         - [Bug #4271] [influxdb]实时数据的查询平均响应时间和并发数基本成正比，100并发超过12s
                        - [Bug #10168] [容错]/SimpleJsons/alarms请求参数错误（index为0）时，仍返回200
                        - [Bug #10342] 增加portal instance/pod数，websocket出错
                        - [Bug #10129] 由于地面端异常导致上对下同步失败时，红色error框“……contact the administrator”不易懂（可修改为黄色提示框：连接timeout），同时可以取消scada前的感叹号
                      [scada-dataworker v-1.3.30] Changelog
                      - Added
                        - 支援http/https兩種InfluxDB連線方式
                      - Updated
                        - 接收到config則視為地端對雲端強制同步config, 移除modified status
                      - Fixed
                        - [Bug #10129] 由于地面端异常导致上对下同步失败时，红色error框“……contact the administrator”不易懂（可修改为黄色提示框：连接timeout），同时可以取消scada前的感叹号

##### 1.10 type #####

- 说明：该项根据实际情况填写（目前有三种type类型：ENSaaS、Common Apps、Industry Apps），SCADA属于Common Apps，输入格式如下。
	
	    type = Common Apps

##### 1.11 plan #####

- 说明：即SRP支持哪一种plan（String类型），比如standard、advanced。
- 示例：以SCADA为例，若plan为standard时，输入格式如下。
	
	    plan = standard

##### 1.12 chartName #####

- 说明：即SRP的chartname。
- 示例：以SCADA为例，输入格式如下。
	
	    chartName = scada

##### 1.13 memory #####

- 说明：即为部署该SRP及依赖的SRP所需要的memory（单位为GB），输入格式如下。
- 示例：以SCADA为例，输入格式如下。
	
	    memory = 0.75

##### 1.14 cpu #####

- 说明：即为部署该SRP及依赖的SRP所需要的cpu（单位为Core），输入格式如下。
- 示例：以SCADA为例，输入格式如下。
	
	    cpu = 2

##### 1.15 manager #####

- 说明：即为SRP团队的相关负责人信息，包括PM、RD、QA，以防SRP部署出现问题，可以快速联系相关负责人排查。
- 示例：以SCADA为例，输入格式如下。
	
	    manager = 
                  {
                      "PM": 
                      [
                          {
                              "name": "",
                              "Email": ""
                          }
                      ],
                      "RD": 
                      [
                          {
                              "name": "StevenHY.Li",
                              "Email": "StevenHY.Li@advantech.com.tw"
                          }
                      ],
                      "AE": 
                      [
                          {
                              "name": "",
                              "Email": ""
                          }
                      ]
                  }

### 2、提供参数格式 ###
以SCADA为例，SRP上架时，请将第1节中的参数以下列形式提供给我们

<table class="tg">
 <tr>
      <th align="center">Key</th>
      <th align="center">Value</th>
    </tr>
    <tr>
      <td>version</td>
      <td>1.1.37</td>
    </tr>
    <tr>
      <td>memory</td>
      <td>0.75</td>
    </tr>
    <tr>
      <td>cpu</td>
      <td>2</td>
    </tr>
    <tr>
      <td>plan</td>
      <td>standard</td>
    </tr>
    <tr>
      <td>chartName</td>
      <td>scada</td>
    </tr>
    <tr>
      <td>extraParam</td>
      <td>{<br>　　"urlPrefix":<br>　　　[<br>　　　　　"portal-scada"<br>　　　]<br>}</td>
    </tr>
    <tr>
      <td>dataServicesDependency</td>
      <td>[<br>　　{<br>　　　　"name": "MongoDB",<br>　　　　"plan":<br>　　　　　[<br>　　　　　　"Shared"<br>　　　　　],<br>　　　　"version": "",<br>　　　　"discription": ""<br>　　},     <br>　　{<br>　　　　"name": "Rabbitmq",<br>　　　　"plan":<br>　　　　　[<br>　　　　　　"standard"<br>　　　　　],<br>　　　　"version": "",<br>　　　　"discription": ""<br>　　},<br>　　{<br>　　　　"name": "Postgresql",<br>　　　　"plan":<br>　　　　　[<br>　　　　　　"Shared"<br>　　　　　],<br>　　　　"version": "",<br>　　　　"discription": ""<br>　　}<br>]</td>
    </tr>
    <tr>
      <td>apps</td>
      <td>[<br>　　{<br>　　　　"name": "scada-dataworker",<br>　　　　"version": "1.3.30",<br>　　　　"memory": "0.25",<br>　　　　"cpu":"1",<br>　　　　"dataServicesDependency":<br>　　　　{<br>　　　　　　"mongodb": "",<br>　　　　　　"rabbitmq": "",<br>　　　　　　"inflxudb": "",<br>　　　　　　"redis": "",<br>　　　　　　"postgresql":<br>　　　　　　{<br>　　　　　　　　"postgresql_service_group": "g_rmm,g_ota,g_rw_public"<br>　　　　　　}<br>　　　　},<br>　　　　"params":<br>　　　　{<br>　　　　},<br>　　},<br>　　{<br>　　　　"name": "portal-scada",<br>　　　　"version": "1.3.37",<br>　　　　"memory": "0.5",<br>　　　　"cpu":"1",<br>　　　　"dataServicesDependency"<br>　　　　{<br>　　　　　　"mongodb": "",<br>　　　　　　"rabbitmq": "",<br>　　　　　　"influxdb: "",<br>　　　　　　"redis": "",<br>　　　　　　"postgresql":<br>　　　　　　{<br>　　　　　　　　"postgresql_service_group": "g_rmm,g_ota,g_rw_public"<br>　　　　　　}<br>　　　　},<br>　　　　"params"<br>　　　　{<br>　　　　}<br>　　}<br>]</td>
    </tr
    <tr>
      <td>appServicesDependency</td>     
	  <td>[<br>　　{<br>　　　　"name": "",<br>　　　　"plan": "",<br>　　　　"version": ""<br>　　},<br>　　{<br>　　　　"name": "",<br>　　　　"plan": "",<br>　　　　"version": ""<br>　　}<br>]</td>
    </tr>
	<tr>
      <td>name</td>
      <td>SCADA</td>
    </tr>
	<tr>
      <td>catalog</td>
      <td>SCADA</td>
    </tr>
	<tr>
      <td>description</td>
      <td>Users can monitor and control their projects simply through a web browser</td>
    </tr>
	<tr>
      <td>releaseNote</td>
      <td>[Scada Portal v-1.3.37] Changelog <br>- Added
		<br>　- 支援http/https兩種InfluxDB連線方式
		<br>- Updated
		   <br>　- scadaId維持32個字元(guid)
		  <br>　- real data 查詢tag數上限設為一萬筆 (real raw/real convert/simplejson real)
		<br>- Fixed
		   <br>　- [Bug #4271] [influxdb]实时数据的查询平均响应时间和并发数基本成正比，100并发超过12s
		 <br>　 - [Bug #10168] [容错]/SimpleJsons/alarms请求参数错误（index为0）时，仍返回200
		 <br>　 - [Bug #10342] 增加portal instance/pod数，websocket出错
		 <br>　 - [Bug #10129] 由于地面端异常导致上对下同步失败时，红色error框“……contact the administrator”不易懂（可修改为黄色提示框：连接timeout），同时可以取消scada前的感叹号
		<br>[scada-dataworker v-1.3.30] Changelog
		<br>- Added
		  <br>　- 支援http/https兩種InfluxDB連線方式
		<br>- Updated
		<br>　- 接收到config則視為地端對雲端強制同步config, 移除modified status
		<br>- Fixed
		<br>　- [Bug #10129] 由于地面端异常导致上对下同步失败时，红色error框“……contact the administrator”不易懂（可修改为黄色提示框：连接timeout），同时可以取消scada前的感叹号</td>
    </tr>
	<tr>
      <td>type</td>
      <td>Common Apps</td>
    </tr>
      <td>manager</td>
      <td>{<br><br>　　"PM": <br>　　　[<br>　　　　　{<br>　　　　　　　"name": "",<br>　　　　　　　"Email": ""<br>　　　　　}<br>　　　],<br>　　"RD": <br>　　　[     <br>　　　　　{<br>　　　　　　　"name": "Steven",<br>　　　　　　　"Email": "StevenHY.Li@advantech.com.tw"<br>　　　　　}<br>　　　],<br>　　"QA": <br>　　　[<br>　　　　　{<br>　　　　　　　"name": "",<br>　　　　　　　"Email": ""<br>　　　　　}<br>　　　]<br>}</td>
    </tr>
</table>





