### EnSaaS-K8s-Service 4.0.19- (2021-07-20)

#### [Managment Portal UI]- 4.0.17

Added:
- 打开Portal时添加加载动画
Fixed:
- 登录的时候输错密码，登录按钮被disable，无法再次登录
- 从podevent界面跳回到workspace界面创建workspace的时候会跳出日志窗口


### EnSaaS-K8s-Service 4.0.18- (2021-05-14)

#### [Managment Portal API]- 4.0.17

Added:
- 提供pod restart event相关的API

#### [Cluster Agent]- 4.0.15

Added:
- 支持pod restart event的功能

#### [Managment Portal UI]- 4.0.17

Added:
- 查看Pod重启事件和事件详情 
Fixed:
- 修正某些环境下多语言切换不生效的问题；
- 修正某些环境下monitor不能正常显示的问题； 



### EnSaaS-K8s-Service 4.0.17- (2021-04-14)

#### [Managment Portal API]- 4.0.16

Added:
- 修正license的bug;
- 添加internal.domain环境变量,支持更灵活的internal域名；

#### [Cluster Agent]- 4.0.14

Added:
- 为clusteragent提供livenessprobe探针；



### EnSaaS-K8s-Service 4.0.16- (2021-02-05)

#### [Managment Portal UI]- 4.0.16

Added:
- 提供了为批量用户添加资源权限的功能
- 提供了为批量用户删除资源权限的功能；



### EnSaaS-K8s-Service 4.0.15- (2021-01-19)

#### [Managment Portal API]- 4.0.15

Added:
- 支持统一的License接口
- 支持统一的配置中心服务

#### [Cluster Agent]- 4.0.13

Added:
- namespace支持白名单机制，在白名单中的namespace不受Quota的限制，通过环境变量exclude_namespace即可配置。

#### [Managment Portal UI]- 4.0.15

Added:
- 支持新的License接口
- 支持统一的配置中心服务
- 对于globalAdmin，app console页面显示所有订阅号 
- 修改model弹窗的背景颜色为蓝色
Fixed:
- 首次跳到workspace页面后，左侧workspace菜单会闪一下
- token过期后，在user页面操作，UI没有跳转至登录页面



### EnSaaS-K8s-Service 4.0.14- (2020-12-31)

#### [Managment Portal API]- 4.0.14

Added:
- 操作日志功能支持多租户
Fixed: 
- 更新workspace会丢失type信息
- 完善企业号用户的users/me的返回内容
- rolebinding时看到的权限不正确

#### [Cluster Agent]- 4.0.12

Added:
- 对于开启autoscale的workspace,agent启动时上报workspace usage

#### [Managment Portal UI]- 4.0.14

Added:
- 支持和整合操作日志多租户功能
- 添加新功能引导界面
Fixed:
- 优化web kubectl偶尔白屏的问题
- token过期之后，左侧的菜单还能显示
- 修改rolebinding的bug
- 左侧的菜单在有些操作下会消失
- 每次展开或收起左侧的菜单，Resource Permission页面都会重新调用所有api 
- 当前用户没有资源权限的时候，不显示Service Usage菜单



### EnSaaS-K8s-Service 4.0.13- (2020-12-17)

#### [Managment Portal API]- 4.0.12

Added: 
- 支持操作日志，globalAdmin和datacenterAdmin可以查看和搜索所有的操作日志

#### [Cluster Agent]- 4.0.10

Added:
- 全面支持workspace的autoscale功能，订阅号Admin用户可开启

#### [Managment Portal UI]- 4.0.12

Added: 
- Service Portal合并到了Management Portal
- 订阅号选框从全局的页面上方移到了每个页面，控制更加灵活
- 添加了workspace 用量监控页面，随时掌握您的workspace用量
- 改善了UI整体样式，页面更加简洁  



### EnSaaS-K8s-Service 4.0.12- (2020-11-13)

#### [Managment Portal API]- 4.0.11-req2-hotfix1

Added: 
- 支持normal workspace的autoscale功能
- 支持license API
- 完善了cluster status功能

Fixed:
- 同时添加/删除权限导致的新增权限不生效的问题
- mp api /v1/datacenter/{dcName}/users/me返回值添加SsoSubscriptions字段保留sso原始订阅号以支持enterpriseAdmin
- clusterOwner不应该有权限、但事实上有权限创建loadballance的问题;
- workload的running pod统计不准确；
- workspace totalDisk和request.storages在ui上内容不统一的问题；
- 修改权限后，第一次执行kubectl会出错，第二次才ok的问题
- 修正clusteragent不定期重启的问题

#### [Managment Portal UI]- 4.0.11-req2-hotfix1

Added: 
- 添加App console功能
- 完善了cluster status功能

Fixed:
- 修正App console页面的状态刷新的问题
- 同时添加/删除权限导致的新增权限不生效的问题
- App console页面添加web kubectl图标且进去后直接切换到相应的namespace，更符合大家的使用习惯。
- 支持license的过期提示功能
- 修整和完善页面功能说明



### EnSaaS-K8s-Service 4.0.11- (2020-08-28)

#### [Managment Portal API]- 4.0.11

Added:
- 添加workload管理相关的API，包括deployment, daemonset, statefulset, job, cronjob等
- 为mpbuy增加了workspace权限相关的API接口
- 添加了可以对所有k8s资源操作的API，不用切换集群即可执行kubectl命令

Fixed:
- 用户拥有不同cluster下相同名字namespace的权限的时候，users/me API 只会返回其中某一个
- 当namespace下workload较多时，调用workload API返回504错误
- 修正cluster的controller一直处于运行状态的问题
- 修正kubeensaas服务不定期重启的问题
- 修正第一次添加cluster时，cluster的状态不会更新的问题 

#### [Cluster Agent]- 4.0.9

Added:
- 优化websocket的处理逻辑
- 支持自动注入sidecar

Fixed:
- 计算quota的时候不计算已经complete的pod的个数
- 修正clusteragent偶尔会重启的问题
- 修正当clusteragent运行时无法创建cronjob的问题

#### [Managment Portal UI]- 4.0.11

Added:
- workload管理，包括deployment, daemonset, statefulset, job, cronjob，支持yaml查看和在线编辑功能，支持workload的扩、缩容
- pod管理，列出pod下面的所有container以及container详细信息，支持yaml查看和在线编辑功能
- 支持查看某个container下的日志内容
- 给workload页面的创建时间添加排序功能

Fixed:
- workload没有按照name排序
- 切换单位后，Memory(Request/Quota)没有变
- console页面下方node, workspace, namespace将”Usage”改为”Usage/Quota”
- console页面下方workspace, namespace 添加CPU Request/Limit和Memory Request/Limit两列数据
- cpu request/limit和memory request/limit默认值显示不正确
- workspce页面cpu_usage/memory_usage totalValue 显示Unlimited
- application页面切换namespace出现empty



### EnSaaS-K8s-Service 4.0.10- (2020-07-10)

#### [Managment Portal API]- 4.0.10

Added:
- 支持定期删除被驱逐pod的功能
- workspaceOwner及以上权限可以修改当前workspace的label name
- 提供了安装和删除helm包的Rest API
- 提供了对dedicated route 的支持
- 支持对某个或所有的slave集群的clusteragent进行升级、降级

Fixed:
- 订阅号用户无法下载config文件 

#### [Cluster Agent]- 4.0.8

Added:
- 提供了HelmRelease crd,支持crd的方式安装helm包

#### [Managment Portal UI]- 4.0.10

Added:
- 提供toolbox悬窗，用户可随时使用web kubectl的功能
- 支持页面主题颜色选择，目前有三种主题颜色供使用者选择

Fixed:
- 修改user edit页面连续删除绑定的权限时页面空白问题
 


### EnSaaS-K8s-Service 4.0.9- (2020-06-16)

#### [Managment Portal API]- 4.0.9

Added:
- 认证方式采用更轻量的token方式，性能好、效率高且备份还原之后无需修改config文件
- 支持了datacenterAdmin role
- 对SSO请求做了缓存处理，API性能获得更大提升
- 优化了私有云代理和master的通信部分，通信链路更加可靠
- 去除了数据库保存订阅号权限，并把订阅号权限和资源权限做了合并，权限管理更加统一、高效和灵活
- 用户管理功能添加了全局搜索用户的功能
- 优化了和权限相关的API，性能更佳

Fixed:
- 解决了subscription类型的workspaceOwner和rolebinding类型的workspaceOwner的权限合并问题 
- 解决了资源权限偶尔无法更新的问题，比如添加权限、删除权限
- 优化了资源权限更新慢的问题，性能提升100倍

#### [Cluster Agent]- 4.0.7

Added:
- 添加代理功能，并负责token认证
- kubectl 查看workspace和workspacequota提供更详细信息
- 每个集群支持多个clusteragent的部署

#### [Managment Portal UI]- 4.0.9

Added:
- 支持datacenterAdmin
- dedicated cluster 和 general worksapce信息页添加active time

Fixed:
- workspace页面的部分选项无法正确排序
- ns-overview页面点击secret后页面不断跳动，无法正常显示，且最终导致网页崩溃
- Workspace/Namespaces Overview页面，最下方quota表格UI显示不完整
- 点击workspaces overview下方的namespace进入namespace列表，显示的cluster和workspace非用户当前选择的
- namespace overview页面，当namespace没有限制pod个数，pod总量显示NaN,使用率显示NaN%
- application页面多调用了获取config的api，当该api出错的时候后续api无法继续调用，导致无法获取app列表
- 修改用户权限后返回资源权限页面，上方选择的cluster/workspace与user列表不匹配
- 进入namespace-overview页面，再次选择worksapce后，namespace选择框消失，上方面包屑显示empty
- 当用户只有资源权限时，UI上无法显示订阅号公司名称
- namespace-developer权限的namesapce usage一栏pod数量不是整数



### EnSaaS-K8s-Service 4.0.8- (2020-05-21)

#### [Managment Portal API]- 4.0.8

Added:
- 支持Web Kubectl, 无需下载config文件即可直接在UI上执行kubectl操作

#### [Managment Portal UI]- 4.0.8

Added:
- 支持Web kubectl terminal

Fixed:
- User permission页面为用户分配权限后，type一栏为空
- 根据关键词搜索workspace后，随着搜索次数的增多匹配结果越来越多
- 偶现，用户登陆成功后进到namespace页面无法看到ns列表
- monitor页面，切换worksapce后，namespace选择框消失 



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

