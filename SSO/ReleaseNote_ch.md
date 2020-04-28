## API 4.0.4.0-(2020-04-28)
### New Features
* SSO和mp进行权限拆分，去掉SSO中的资源权限管理的节点，之后资源权限相关的分配和管理在ManagementPortal中操作, SSO负责用户管理和企业账号订阅号管理。
* SSO新增管理员权限为globalAdmin，去掉dataCenterAdmin是最高管理员的权限，目前支持的角色有globalAdmin，subscriptionAdmin,subscriptionUser,srpUser,unassigned.
* 重新开启appId的校验.
* 新增 api /clients/:clientId/users 获取某个client下的所有user.
* 新增 oauth整合myadvantech登录时，只要是研华的邮箱，如果在marktplace检查没有crmid也会放行登录.
* 为保证兼容，SSO /users/me，/srprole api 会实时去mp查询用户的资源权限信息。
* 用户列表中的sso_role字段为用户在sso各个权限的最高者，处理datacenterAdmin账号默认为globalAdmin,其余账号取各个权限的最高级作为初始值。
* 创建用户时指定订阅号，可以同时把用户加入订阅号中。
* 新增 api  DELETE /clients/unsubscribe,根据client位置以及serviceName删除client。
* 新增 api  DELETE /clients/resources,根据资源信息批量删除client。
* 新增 api /users/username/:userid  根据userid获取username.此接口没有权限要求。
* 新增 api /users/subscriptions 获取当前用户的所有订阅号信息，返回订阅号状态，是否试用等。供ui判断需要展示的菜单。
* 新增 api /admin/users 提供globalAdmin获取user list， 支持订阅号，client等各种查询模式。
* 发信方式改为notification on k8s 版本

### Fix bugs 
* client筛选的权限判断改为从mp实时查询资源权限。
* 试用订阅号相关功能的bug修改。
* 修改整合myadvantech 登录发出注册信中密码不对的问题。
* 修改apidoc

## Portal 4.0.3.0-(2020-4-28)
### New Features
* SSO和mp进行权限拆分，去掉SSO中的资源权限管理的节点，之后资源权限相关的分配和管理在ManagementPortal中操作, SSO负责用户管理和企业账号订阅号管理。
* 新增user列表用于管理用户订阅号权限，可在此列表新建用户，修改用户订阅号权限.
* 菜单修改，现在有：订阅号、用户、客户端、个人资料、角色介绍。
* 订阅号：列表中呈现订阅号和试用订阅号基本信息，支持按照订阅号名字、公司、订阅号ID筛选，支持按照订阅号、试用订阅号进行筛选，操作列加入订阅号详情功能。权限：globalAdmin和订阅号user、订阅号admin。
* 用户：展示用户列表，支持按照所有订阅号、所有试用订阅号、订阅号筛选用户。权限：globalAdmin和订阅号user、订阅号admin。
* 用户编辑：去掉资源权限信息，可分配订阅号权限，只有用户自己能修改自己的基本信息。

## Portal 4.0.2.2-(2020-4-9)
### New Features
* 创建订阅号时需要填入CRM ID

## Portal 4.0.2.1-(2020-4-7)
### New Features
* 新增试用订阅号菜单，提供增删改试用订阅号功能，支持查看使用订阅号账单信息，支持试用订阅号用户管理
* 订阅号和试用订阅号支持按照公司和ID查询

## API 4.0.3.0-(2020-03-24)
### New Features
* 新增 api /subscriptions/{idOrCrmId}/accountInfo 获取订阅号对应的accountInfo。
* 新增 api  /users/me/info 获取users信息（不含roles）。
* 新增 api  /clients/{clientId}/users/role  获取用户对于某个特定client的权限（类似于之前的srpRole,去掉了roles相关判断）。
* 新增 取消appId检测

### Fix bugs 
* refresh token在返回值中set cookie的问题。
* 修改apidoc。


## Portal 4.0.2.0-(2020-3-18)
### Fix bugs
* 屏蔽导航栏头部暂未实现功能的按钮


## API 4.0.2.0-(2020-03-06)
### New Features
* 新增 订阅号admin可以创建user。
* 新增 api /users/info 批量获取用户信息。
* 新增 订阅号下user的查询不区分大小写。

### Fix bugs 
* 修改 datacneter admin之间互相不可以被删除。
* 修改和marktplace 同步api,如果调不通返回默认值。
* 修正注册client时对appId的校验。
* 修改 oauth client不允许创建srpUser。
* 修改apidoc。


## Portal 4.0.1.0-(2020-3-6)
### New Features
* 所有页面上的资源权限控制改为调用mp的userme接口判断
* 订阅号管理界面，点击订阅号跳转至订阅号用户页面并默认选中当前订阅号
* dcAdmin可以删除别人，dcAdmin之间不能互删
* 已关联资源的订阅号Admin可以查看资源权限菜单，可以新增user并分配资源权限
* 用户选择资源时，如果选择了重复的资源权限，进行重复提示

### Fix bugs
* 在订阅号用户页面，筛选订阅号时，如果选中后面的页码，再次选择有更少用户的订阅号时页面是空的
* 在订阅号用户栏位点击清除删除搜索内容之后未实时查询订阅号用户


## API 4.0.1-(2020-02-25)
### New Features
* 增加 oauth 客户端模式的支持
* 增加 get users/me/info ,从mp实时获取数据。
* 增加整合marketplace api，登录时同步，提供接口判断是是否变化。
* 修改订阅号id生成规则，保证相同crmid可以生成出相同的订阅号Id。


## Portal 4.0.0-(2020-02-18)
### New Features
* SSO支持单点登录、忘记密码
* 订阅号：订阅号管理和订阅号成员管理。可访问的成员：datacenterAdmin、订阅号成员 
* 管理：订阅号新增、删除、修改。查看订阅号信息（名称、公司、成员、创建时间、ID）和订阅号模糊筛选。可访问的成员：datacenterAdmin、订阅号成员
* 订阅号用户：按照订阅号查看、添加、移除订阅号内的成员，支持datacenterAdmin给订阅号成员设置订阅号权限，支持订阅号成员模糊筛选。可访问的成员：datacenterAdmin、订阅号成员
* 资源权限：用户的资源权限管理以及用户的新增、删除、禁用、信息编辑，支持按照资源和角色筛选，支持用户名模糊筛选。可访问的成员：workspaceOwner及以上权限用户
* 用户编辑：编辑用户的基本信息和资源权限。可访问的成员：workspaceOwner及以上权限用户
* 客户端：客户端的管理。可访问的成员：所有用户
* 管理：展示客户端列表，提供客户端新增、编辑、删除功能，支持客户端名称模糊筛选。可访问的成员：workspaceOwner及以上权限用户
* 创建：需填写基本信息以创建一个客户端。创建成功后会提供一个秘钥和客户端ID，没有客户端管理权限的用户只会在此看到一次，需要妥善保存。可访问的成员：所有用户
* 我的个人资料：展示用户的基本信息、资源权限、订阅号权限、应用权限。提供个人信息编辑入口和密码修改入口。可访问的成员：所有用户
* 修改密码：用户根据旧密码修改新密码。可访问的成员：所有用户
* 角色介绍：分租户空间角色、订阅号角色、应用角色分别进行了角色说明。可访问的成员：所有用户


## API 4.0.0-(2020-02-19)
### New Features
* 增加 oauth 客户端模式的支持
* 增加 订阅号相关api /subscriptions/*,支持订阅号增删改查，以及订阅号下用户的增删改查
* token支持长短两种模式，解决v2时token长度超过浏览器限制的问题。
* srp user权限支持json模式格式，从而支持复杂的数据结构。
* 内置服务的client,支持通过api设置对sso 接口的权限。

### Fix bugs 
* 订阅号根据名称查询，不区分大小写的情况下，如果有名称中有大写字母的会查不出来。
* /patch /users/scopes 中action为remove时无法删掉的问题。
* 修改注册信中链接的地址
* 增加操作记录的日志


