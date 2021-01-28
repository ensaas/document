### SecureTunnel v-1.0.6- (2020-01-29)

#### 新增功能

 - 新增白名单功能
 
#### 更新功能

 - 更改UI头部样式
 - 批量映射优化

#### 服务组件

- securetunnel：v-1.0.6
- securetunnel-ui：v-1.0.6
- securetunnel-client: v-1.0.5 and above


### SecureTunnel v-1.0.5- (2020-12-30)

#### 新增功能

 - 新增集群内服务批量映射功能

#### 服务组件

- securetunnel：v-1.0.5
- securetunnel-ui：v-1.0.5
- securetunnel-client: v-1.0.5

### SecureTunnel v-1.0.3- (2020-12-28)

#### 新增功能

 - 内网映射添加诊断功能

#### 更新功能

 - 更改集群类型映射，可使用工具自动获取内网地址和token填入
 - 内网映射的内部地址，支持HTTPS和HTTP下拉框切换


#### 服务组件

- securetunnel：v-1.0.3
- securetunnel-ui：v-1.0.3



### SecureTunnel v-1.0.2- (2020-12-02)

#### 新增功能

 - 创建集群类型映射时，添加获取token的工具以及指引
 - 支持从页面获取集群config，增加web kubectl
 - 客户端信息中添加客户端下存在的映射个数
 - 映射页面增加筛选功能，可根据客户端和映射类型进行筛选


#### 更新功能

 - TCP类型的映射，支持通过UI获取证书


#### 服务组件

- securetunnel：v-1.0.2
- securetunnel-ui：v-1.0.2



### SecureTunnel v-1.0.1- (2020-11-12)

#### 首版本发布

- 客户端管理：

  - 客户端可以位于一个集群，容器，虚拟机，或物理机，用于与映射服务端通信
  - 支持添加、删除客户端
  - 支持查看客户端详情
  - 提供部署文件和部署指南指引用户部署客户端

- 内网映射

  - 映射用于内网穿透，外网可以通过映射提供的域名，随时随地访问内网搭建的服务

  - 支持TCP、HTTP、Cluster类型的映射

  - 支持添加、删除、编辑映射

#### 服务组件

- securetunnel：v-1.0.1
- securetunnel-ui：v-1.0.1
