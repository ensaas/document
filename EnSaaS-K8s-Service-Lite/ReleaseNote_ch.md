### EnSaaS-K8s-Service Lite 4.1.1- (2020-11-18)

#### Added:
- 添加对GPU的支持。支持Pod使用GPU资源，同时会对GPU的使用情况进行监控。
- 支持默认的工作空间配额可配置。可根据平台资源占比进行动态配置
- 支持配置不受webhook约束的命名空间，便于对集群升级

#### Updated：
- application页面添加Web kubectl功能
- 修改application页面获status和instance的逻辑
- 优化serviceInstance页面。

#### Fixed:
- Application页面instance个数和现实个数不符

#### Component：
- kubeensaas-lite：v-4.1.1
- clusteragent-lite：v-4.1.1
- mp-ui-lite：v-4.1.1

#### Dependent Service:

| Service                    | Version |
| -------------------------- | ------- |
| Serivce Hub                | 0.3.27  |
| Serivce Portal             | 0.1.2   |
| DCCS                       | 1.0.4   |
| MongoDB Service Manager    | 0.5.1   |
| PostgreSQL Service Manager | 0.2.7   |
| InfluxDB Service Manager   | 0.1.4   |
| RabbitMQ Service Manager   | 1.0.5   |
| Redis Service Manager      | 0.0.1   |
| Blobstore Service Manager  | 1.0.2   |




### EnSaaS-K8s-Service Lite 4.1.0- (2020-11-04)

#### Added:
- 合并Service instance相关功能，角色支持：globalAdmin、subscriptionAdmin和subscriptionUser
- API支持job相关的功能，方便派发job。
- API支持用户创建PV和PVC

#### Updated：
- 将CRD的版本从v1beta1升级到v1（K8S 1.19版本之后v1beta1将会废弃）
- 修改CRD资源的group信息，v1版本的CRD不支持以k8s.io结尾的group，修改为edgecloud.ensaas.io
- 重构了metric获取的逻辑，添加查看ns,ws,node资源的API
- 加入Applications页面
- 取消application和service页面的工具箱；
- top_navbar添加Home 按钮

#### Fixed:
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

#### Note:
- 从EnSaaS-K8s-Service 4.0.11后，拆分出EnSaaS-K8s-Service Lite，用于IoTSuite Edge的场景
- EnSaaS-K8s-Service Lite新建了一个chart，chart包中包含了所需的服务
