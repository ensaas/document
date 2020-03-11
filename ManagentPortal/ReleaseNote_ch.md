# EnSaaS-K8s-Service 4.0.2- (2020-03-10)

## Summary Update

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



# EnSaaS-K8s-Service 4.0.0- (2020-02-19)

## Summary Update

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

