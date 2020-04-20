## Appbuy-api ReleaseNote

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
- 增加部署时，从listingsystem读取values.yaml进行部署。
- 修改sso account info接口。
