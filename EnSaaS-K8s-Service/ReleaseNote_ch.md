### EnSaaS-K8s-Service 4.0.7- (2020-05-11)

#### [Managment Portal API]- 4.0.7

Added:
- 支持路由管理API

Fixed:
- 通过token导入的集群，获取admin config的时候config不完整 

#### [Managment Portal UI]- 4.0.7

Added:
- 添加路由管理界面，用户可查看ingress
- cluster页面添加node个数的显示
- rolebinding页面添加type字段，表明是rolebinding权限还是subscription权限
- 下拉菜单支持搜索功能

Fixed:
- 禁止用户编辑用户信息 



### EnSaaS-K8s-Service 4.0.6- (2020-04-28)

#### [Managment Portal UI]- 4.0.5

#### [Managment Portal API]- 4.0.6

Added:

自 SSO 移植用户管理和编辑用户功能，往后 SSO 不再提供此功能
- 用户管理 ：
    - 查看用户列表
    - 以 cluster/workspace/namespace 筛选用户
    - 由搜索栏查询用户
    - 新建用户
    - 邀请用户：分配自己资源权限给已存在用户
- 编辑用户 ：
    - 编辑用户基本数据（限用户本人帐号）
    - 修改/分配用户的资源权限
- 支持 SSO 的 globalAdmin 角色，以前的 datacenterAdmin 帐号全部提升为 globalAdmin

注：资源权限分配的操作限制：
- 对资源权限，只能分配比自己低一階及以下权限（如：clusterOwner只能分配给用户workspaceOwner权限）
- 对订阅号权限，可以分配同一级及以下权限
- 无法修改订阅号既有的资源权限

Fixed:

- 通过token导入的集群，获取admin config的时候config不完整
- 修正订阅号权限可以被修改的bug



### EnSaaS-K8s-Service 4.0.5- (2020-04-24)

#### [Cluster Agent]- 4.0.5

Fixed:

- 放开切换ensaas ws和logging，rms，ensaas-service这些ns的quota的权限
- 修复集群中没有logging或者rms 这两个namespace的时候，agent不能启动的问题
- 修正datacenterAdmin不能创建ns的问题



### EnSaaS-K8s-Service 4.0.4- (2020-04-01)

#### [Managment Portal UI]- 4.0.4

Added:

- 平台管理：
  - 提供用户config查看，拷贝和刷新的功能
  - 新增显示API版本号及cluster agent版本号
  - 新增导入cluster功能

Fixed:

- application页面偶发显示一片空白
- 从cluster、workspace、namespace进入monitor页面，UI上cluster下拉框无法正常显示或刷新的问题
- 进入Monitor页面后显示为空白，左侧的Kubernetes不是选中状态
- 在workload页面切换订阅号并刷新页面，UI没有内容显示empty
- application页面切换订阅号后，UI没有调用api


#### [Managment Portal API]- 4.0.5

Fixed:

- 修正了注入环境变量错误的问题

#### [Managment Portal API]- 4.0.4

Added:

- 添加API可以获得MP api的版本信息
- 添加API，支持通过API升级所有的Cluster Agent

Fixed:

- rolebinding之后出现private key和public not match的问题
- 修正了创建或者删除rolebinding出现的异步问题
- 修复clusterowner及以上权限用户无法修改workspace的问题
- 修正订阅号用户无法获得集群user个数信息


#### [Cluster Agent]- 4.0.4

Added:

- 将agent的版本加到了clusterInfo中

Updated:

- master集群和slave集群之间增加websocket通信

Fixed:

- 修正了workspaceowner的权限问题
- 修正了agent中权限的更新不及时的问题
- 限制用户不能操作ensaas workspace


- 修正了如果一个cluster中没有任何PV时，获取的clusterinfo没有totalDisk和usedDisk的问题



### EnSaaS-K8s-Service 4.0.3- (2020-03-21)

#### [Managment Portal UI]

Added:

- 平台管理：
  - 订阅号下拉框的样式：增加订阅号公司，增加订阅号搜索
    - 管理员UI上支持添加general workspace

Updated:

- 统一资源列表风格，都显示为百分比和进度条样式
- quota中memory的样式更改：memory下拉框最大支持32G；对于dedicate cluster，memory可以选择下拉框的值，也可以让用户输入

Fixed:

- scale namespace quota页面，更改namespace绑定的quota，页面出现一片空白

- 用户同时具有ws owner和ns developer权限，console页面显示有问题（用户权限、ns个数不正确），且无法查看ws列表

- console页面切换选择的ns，ns信息不更新，UI没有调用相应的api

- 从console页面跳转到workspace页面，刷新后页面显示空白

- 偶现ws、ns的新建按钮不显示，刷新也不显示

- 在ws页面刷新后，页面空白

- 多个页面在切换订阅号并刷新页面后，页面显示存在问题

  ​

### EnSaaS-K8s-Service 4.0.2- (2020-03-10)

#### Summary Update

Added:

- 平台管理：
  - 增加workload页面，可以查看namespace下的workload
  - 增加workload日志查看，可以查看workload的Pod的实时日志

Updated:

- 左侧菜单栏增加分类，区分dedicate cluster和shared cluster类别

Fixed:

- 修改按照订阅号查看资源的问题。
- 修改Application页面不能显示的问题。 


- 修复了创建ws没有成功，但是数据库中会存在这条记录的bug。Bug12493


- 修复获取ws的resource时，返回值为空的bug。Bug 12465

- 修复了Datacenteradmin的Users/me在默认订阅号下的权限问题。Bug12390,Bug12378

- 修正了clusteragent中ws owner的权限问题

- 修复传入错误的订阅号，仍能根据workspace id获取到workspace名称的bug。Bug 12459

- 修正返回的错误信息

- 在node页面切换订阅号，node list没有及时更新，依旧显示的是上次获取的node信息

- 修复General workspace切换到ns列表再回上一页会出现新建按钮的问题

  ​



### EnSaaS-K8s-Service 4.0.0- (2020-02-19)

#### Summary Update

Added:

- 订阅号和用户权限：
  - 最上方导航栏增加订阅号显示，增加按照订阅号展示资源。
  - 拥有订阅号权限的用户（订阅号admin/user），可看见及操作订阅号购买的资源。

- 监控：
  - 整合RMS实现不同层级监控展示



Fixed:

- 修改MP和SSO之间rolebindding的同步方式，创建rolebinding前增加订阅号校验。
- 在slave集群和master集群之间增加同步机制，修复不能立即更新info和metric的问题 
- 修复clusteragent向master集群同步资源时的端口错误 
- datacenter admin登录applications页面，UI上显示的应用个数不完整，最多只能显示20个 
- workspace overview页面，底部quota信息的limitMemory显示错误
- 从SSO UI点击console，无法自动登录MP的问题
- ws-owner和ns-developer权限进入在namespace页面，通过上方的面包屑切换集群后，workspace-overview页面全显示N/A，且刷新无效
- namespace-developer权限，首次进入namespace页面或者刷新页面后，workspace下拉框不支持点击
- namespace-developer权限进到application页面，workspace下拉框无法获取ws列表，且刷新页面后namespace列表显示为empty
- scale namespace quota页面，更改namespace绑定的quota，页面出现一片空白
- 调整部分缩放问题
- 当用户具有多种权限时，UI显示有问题

