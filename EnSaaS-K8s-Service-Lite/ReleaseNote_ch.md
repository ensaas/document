### EnSaaS-K8s-Service Lite v-4.1.8- (2020-08-02)
#### Fixed
 - 支持4段license
 - 包入1.2.7版本的license chart
 - chart包支持--set mp-ui-lite.install=false
#### update
 - 加载Portal时添加加载动画

#### Component
 - kubeensaas-lite：v-4.1.6
 - clusteragent-lite：v-4.1.6
 - mp-ui-lite：v-4.1.8

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.7                       |
| Listingsystem              | 1.8.25        | listingsystem:1.8.0.27                   |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22.6        |
| DCCS                       | 1.0.11        | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21        | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |
| SSO                        | 4.0.24        |/ssov3/ssov3:v-4.0.24                     |
#### note：
     4.1.5版本后，mp-ui-lite的配置中dashboard的链接不用再加'/api',
                 kubeensaas-lite的配置中mp的链接需要添加'/v1'。

### EnSaaS-K8s-Service Lite v-4.1.7- (2020-05-13)
#### Fixed
 - 修复语言切换时bug


#### Component
 - kubeensaas-lite：v-4.1.4
 - clusteragent-lite：v-4.1.5
 - mp-ui-lite：v-4.1.7

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.7                       |
| Listingsystem              | 1.8.25        | listingsystem:1.8.0.25                   |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22          |
| DCCS                       | 1.0.11        | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21        | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |
| SSO                        | 4.0.24        |/ssov3/ssov3:v-4.0.24                     |


### EnSaaS-K8s-Service Lite v-4.1.6- (2020-03-25)
#### Fixed
 - 修正多订阅号时，有时切换订阅号service页面显示不正确的问题
 - 修正切换订阅号时，集群显示不正确的问题
 - 修正同一个订阅号下，切换不同集群，package列表显示不正确
 - 修正在cluster，ws或ns页面选择的集群信息会传给Application页面的问题
 - 修正切换shared和dedicate集群时，集群列表不正确的问题

#### Updated
 - 若cluster或ws或ns不存在，点击时，给出提示

#### Component
 - kubeensaas-lite：v-4.1.4
 - clusteragent-lite：v-4.1.5
 - mp-ui-lite：v-4.1.6

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.6                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.24                   |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22          |
| DCCS                       | 1.0.11        | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21        | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |
| SSO                        | 4.0.21        |/ssov3/ssov3:v-4.0.22                     |




### EnSaaS-K8s-Service Lite v-4.1.5- (2020-03-04)

#### Fixed
 - 当license失效后，invalid day计数问题
 - 修正namespace和workspace的GPU使用量不正确的问题
 - 修正注入request resource时，不正确的问题 
 - mp-ui-lite的配置中dashboard url不用配置/api

#### Updated
- 修改页面的样式，同时将订阅号下拉框下移到每个页面
- 当一个pod处于error的status，并且这个pod的restart policy是never的时候，这个pod使用量不计入quota统计量中

 
#### Component
- kubeensaas-lite：v-4.1.4
- clusteragent-lite：v-4.1.4
- mp-ui-lite：v-4.1.5

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22          |
| DCCS                       | 1.0.11         | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21         | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |




### EnSaaS-K8s-Service Lite v-4.1.4- (2020-02-04)

#### Fixed
 - Service页面显示的问题
 - 移除部署文件中的serviceaccount.yaml以及修改DCCS的地址
 
#### Component
- kubeensaas-lite：v-4.1.3
- clusteragent-lite：v-4.1.3
- mp-ui-lite：v-4.1.4

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |


### EnSaaS-K8s-Service Lite v-4.1.3- (2020-01-25)

#### Fixed
 - 整合WISE-PaaS/ESM的问题
 - 部署时环境变量不能写入workspace的问题
 
#### Component
- kubeensaas-lite：v-4.1.3
- clusteragent-lite：v-4.1.3
- mp-ui-lite：v-4.1.3

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |


### EnSaaS-K8s-Service Lite v-4.1.2- (2020-12-30)

#### Added
- 添加对Storage Class、PV以及PVC的支持，支持查看Storage Class、PV，支持新建PVC。

#### Updated
- application页面支持点击Cluster、workspace、namespace跳转到对应的资源overview页面
- 升级app时添加选择版本功能
- 更新获取已使用的request quota的逻辑
- 整合WISE-PaaS/ESM，支持从WISE-PaaS/ESM获取配置信息

#### Fixed
 - license的问题
 - 和Monitor页面配合的问题，修改配置中dashbord地址必须带/api的问题
 - 修改quota中limit必须配置的问题
 
#### Component
- kubeensaas-lite：v-4.1.2
- clusteragent-lite：v-4.1.2
- mp-ui-lite：v-4.1.2

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |


### EnSaaS-K8s-Service Lite v-4.1.1- (2020-11-18)

#### Added
- 添加对GPU的支持。支持Pod使用GPU资源，同时会对GPU的使用情况进行监控。
- 支持默认的工作空间配额可配置。可根据平台资源占比进行动态配置
- 支持配置不受webhook约束的命名空间，便于对集群升级

#### Updated
- application页面添加Web kubectl功能
- 修改application页面获status和instance的逻辑
- 优化serviceInstance页面。

#### Fixed
- Application页面instance个数和现实个数不符

#### Component
- kubeensaas-lite：v-4.1.1
- clusteragent-lite：v-4.1.1
- mp-ui-lite：v-4.1.1

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |




### EnSaaS-K8s-Service Lite v-4.1.0- (2020-11-04)

#### Added
- 合并Service instance相关功能，角色支持：globalAdmin、subscriptionAdmin和subscriptionUser
- API支持job相关的功能，方便派发job。
- API支持用户创建PV和PVC

#### Updated
- 将CRD的版本从v1beta1升级到v1（K8S 1.19版本之后v1beta1将会废弃）
- 修改CRD资源的group信息，v1版本的CRD不支持以k8s.io结尾的group，修改为edgecloud.ensaas.io
- 重构了metric获取的逻辑，添加查看ns,ws,node资源的API
- 加入Applications页面
- 取消application和service页面的工具箱；
- top_navbar添加Home 按钮

#### Fixed
- clusteragent和kubeensaas长时间运行会重启的问题
- 查看有两个container的pod会出错的问题
- 优化application/node绑定quotas的文字描述和翻译；
- 优化用户没有资源权限时的提示；
- 修改web kubectl刚打开时会闪现空白框的问题；
- overview页面，quota页面，scale quota页面的limitsDisk改为PVC Disk；
- 修改scale quota页面，pod和quota_usage table等的显示问题；
- 当集群权限是workspaceOwner时候，在quota页面没有权限删除quota, 将operation设为disabled；
- 在global页面，circle text当used是0, 数值显示问题；
- 新建user页面，对于已经存在的用户没有给以提示信息的问题；
- 新建cluster失败问题；
- 统计summary的样式问题；

#### Component
- kubeensaas-lite：v-4.1.0
- clusteragent-lite：v-4.1.0
- mp-ui-lite：v-4.1.0

#### Note
- 从EnSaaS-K8s-Service 4.0.11后，拆分出EnSaaS-K8s-Service Lite，用于IoTSuite Edge的场景
- EnSaaS-K8s-Service Lite新建了一个chart，chart包中包含了所需的服务
