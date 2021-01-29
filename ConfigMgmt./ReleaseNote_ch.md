### Config Mgmt. v-1.0.2- (2021-01-29)

#### Summary Update

#### Added:

- 添加global auditor权限
- 发布公有配置和私有配置时候检查tag name是否存在
- 公有云增加basic plan
- 应用组页面增加配置个数，点击配置个数跳转到配置管理页面
- 应用组页面增加服务个数，点击服务个数跳转到服务管理页面

#### Updated:

- 优化/healthz API，增加检查postgres状态
- MP crash的情况下，除了workload相关API都可正常工作

#### Fixed:

  - 修复控制面未更新服务后端实例地址的问题
  - 修复中文页面显示的错误
  - 修复默认账密操作workload相关API提示401的问题

#### Component

- API v-1.1.0.3
- Portal v-1.1.0.3
- ECM agent v-1.1.0.3
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1

### Config Mgmt. v-1.0.1- (2020-12-30)

#### Summary Update

#### Fixed:

  - 修复ecm agent crash的bug

#### Component

- API v-1.1.0.1
- Portal v-1.1.0.1
- ECM agent v-1.1.0.2
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1

### Config Mgmt. v-1.0.0- (2020-12-25)

#### Summary Update
#### Added

  - 应用组管理，每个应用组内可以创建多种配置和注册多个服务
  - 配置管理，公有配置和应用组内私有配置，包括配置发布，配置实时推送，配置回滚，历史版本管理，灰度发布，配置监听查询等功能
  - 服务管理，包括服务注册，服务删除，服务地址暴露，服务健康检查等功能

  - 用户管理，包括admin权限和group owner两种权限。admin为Config Mgmt.的最高权限，group owner为应用组权限，可以对应用组进行增删改查

#### Component

- API v-1.1.0.1
- Portal v-1.1.0.1
- ECM agent v-1.1.0.1
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1
