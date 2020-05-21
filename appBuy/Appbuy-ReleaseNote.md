## Appbuy-api ReleaseNote

### version：v-1.3.1.18
####  Updated：
- 修改SSO /users/me 到 /users/me/info
- 修改SSO /users/me 到 /users/me/info

### version：v-1.3.1.17
####  Updated：
- 兼容既能从helm chart传入其他服务地址也能从listingsystem获取app地址
- 修改 GET /serviceInstances 接口 支持 globalAdmin。[Bug  #13691]
- 移除 对serviceCategory的校验，非空即可
####  Add：
-  增加 GET /helmReleases接口
-  增加 GET /helmReleases/:releaseName/status接口

### version：v-1.3.1.16
####  Updated：
- 修改权限校验 由于目前mp不支持dcAdmin，现买东西只能用订阅号admin。仓库相关接口权限为globalAdmin

### version：v-1.3.1.14
####  Updated：
- 支持service-hub dedicated DB创建binding的操作, 增加字段dbName

### version：v-1.3.1.13
#### Fixed:
- fix  bug #13106 
- fix  bug #13105

### version：v-1.3.1.12
#### Fixed:
- fix  Bug #13031 
- fix  POST subscriptions workspaceName 的校验问题

### version：v-1.3.1.11
#### Updated:
- 修改swagger错误
- 为service-hub Containerized Redis提供work around fix

### version：v-1.3.1.10
#### Updated:
- 修改部署 secretName，releaseName的命名规则，现在替换serviceName为chartname,
具体为：
       db        ${chartname}-$ns-secret
       Release   ${chartname}-$ns
- 增加部署时，从listingsystem读取values.yaml进行部署
- 修改sso account info接口
