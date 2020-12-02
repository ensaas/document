
### SecureTunnel 1.0.2- (2020-12-02)

#### Added:

 - 创建集群类型映射时，添加获取token的工具以及指引
 - 支持从页面获取集群config，增加web kubectl
 - 客户端信息中添加客户端下存在的映射个数
 - 映射页面增加筛选功能，可更加客户端和映射类型进行筛选

#### Updated：

 - TCP类型的映射，支持通过UI获取证书


#### Component

- securetunnel：v-1.0.2
- securetunnel-ui：v-1.0.2



### SecureTunnel 1.0.1- (2020-11-12)

#### First Version:

- 客户端管理：

  - 客户端可以位于一个集群，容器，虚拟机，或物理机，用于与映射服务端通信
  - 支持添加、删除客户端
  - 支持查看客户端详情
  - 提供部署文件和部署指南指引用户部署客户端

- 内网映射

  - 映射用于内网穿透，外网可以通过映射提供的域名，随时随地访问内网搭建的服务

  - 支持TCP、HTTP、Cluster类型的映射

  - 支持添加、删除、编辑映射

#### Component

- securetunnel：v-1.0.1
- securetunnel-ui：v-1.0.1
