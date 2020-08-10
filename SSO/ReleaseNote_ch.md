## API 4.0.14.0- (2020-08-10)
### New Features
* /users/enterprises/subscriptions 查询企业账号以及级联的订阅号


## Portal 4.0.11.0-(2020-8-4)
### New Features
* 去掉header中的tickets

## Portal 4.0.10.0-(2020-7-29)
### Fix bugs
* 修改企业账号crmid有特殊字符时查不出来所属订阅号的bug

## API 4.0.13.0-(2020-07-24)
### New Features
* 企业账号相关功能
* 企业账号以及订阅号的列表导出
* 企业账号admin角色，默认可以操作企业账号之下的订阅号
* 定时同步所有企业账号以及其下的订阅号，定时删除过期的操作记录，定时从billing同步订阅号消费点数功能
* 订阅号quota记录，并定时从billing同步，功能默认禁用
* 操作日志功能，目前仅记录了企业账号以及定时任务执行导致数据变更时的记录
* 创建订阅号时必须指定quota
* 改变订阅号detail接口，增加区分memberType,isPaid,isInternal返回，以及订阅号剩余quota的返回

## Portal 4.0.9.0-(2020-7-24)
### New Features
* 增加企业账号菜单和enterpriseAdmin角色，每个企业账号可以加多个enterpriseAdmin（由globalAdmin创建），并可以新建多个订阅号，enterpriseAdmin有权限管理其企业账号下的订阅号。
* 订阅号页面增加按照企业账号筛选功能，默认选项是所有企业账号，新增订阅号时必须指定企业账号，并且所选的memberType不能高于企业账号的memberType（PremierVIP > VIP > Regular > WISELead ）
* 针对globalAdmin增加订阅号导出和企业账号excel导出功能，导出的结果与页面筛选结果一致。增加系统设置菜单，可以查看一些关键的增删改操作的详细信息。

## API 4.0.12.0-(2020-06-24)
### Fix bugs 
* 修改/subscriptions/{subscriptionId}/users 分页不对的问题

## Portal 4.0.8.0-(2020-6-24)
### New Features
* 订阅号用户页面新增detail按钮，指向用户基本信息页面，从这里进入只有查看信息的权限
* 用户首次登陆时密码错误弹框提示
* 客户端管理列表中点击进入客户端用户页面，只展示用户
* 点击client页面中的某一个client，进入此client的用户列表，展示username clientRole status三列
* 增加myAdvantech账号登录功能
### Fix bugs
* 修改订阅号名称中含有特殊字符时的搜索BUG

## API 4.0.11.0-(2020-06-22)
### New Features
* 新增api  /clients/trust 支持托管服务注册client
### Fix bugs 
* 修改/clients/{clientId}/users 支持clientToken
* username crmid subName 去空格
* client部分权限由mp users/me的返回的roles作为判断依据
* internal用户以及研华邮箱不给分配到订阅号admin
* 去除现在已有的重复的订阅号下的用户，并且为订阅号-user-role表增加唯一约束，限制相同订阅号下只能某用户的一条权限
* 新增支持从sso portal使用myadvantech登录

## API 4.0.10.0-(2020-06-02)
### New Features
* 新增order对应的clien并增加datacenter信息在clienttoken中

## Portal 4.0.6.0-(2020-6-5)
### Fix bugs
* 订阅号用户页面中的订阅号列表只显示100条订阅号数据

## API 4.0.9.0-(2020-05-25)
### New Features
* 新增api /admin/subscriptions admin可以指定订阅号id创建订阅号
### Fix bugs 
* 修改删除订阅号之后ssoRole没有变化的问题

## Portal 4.0.5.0-(2020-5-19)
### Fix bugs
* 订阅号列表中新增CRM ID列；
* 去掉个人主页的资源权限；
* 修改编辑页面的下拉框样式问题
* 编辑页面添加订阅号权限时，globalAdmin默认不分配订阅号权限，subAdmin默认可添加的订阅号角色为user，且不可修改。


## API 4.0.8.0-(2020-05-12)
### New Features
* mkp创建user api 增加返回authcode 
* 新增api  /auth/authcode 通过authcode登录
* 新增api  /subscriptions/info 批量获取订阅号信息
### Fix bugs 
* 优化和mp整合的/users/me api


## API 4.0.7.0-(2020-05-10)
### Fix bugs 
* auth api 生成的token增加roles信息	

## API 4.0.6.0-(2020-05-09)
### New Features
* create user by mkp 增加set token到cookie
* admin账号可以删除任意订阅号和订阅号user
### Fix bugs 
* 获取长token时从mp查询role信息
* 修改订阅号同步的触发规则


## API 4.0.5.0-(2020-05-07)
### Fix bugs 
* 修改订阅号同步时某些情况下同步结果不对的问题
* 修改注册信格式

## API 4.0.4.0-(2020-04-28)
### New Features
* 新增 和mp权限拆分，sso以后不再有资源权限的概念。
* 新增 sso 角色修改为globalAdmin,subscriptionAdmin,subscriptionUser,srpUser,unassigned。
* 新增 user列表增加列 sso_role字段，用来记录用户在sso的权限。
* 新增 在第一次更新时，会做一次sso_role的数据填充，sso_role字段的值为用户在sso各个权限的最高者，datacenterAdmin账号默认为globalAdmin,其余账号取各个权限的最高级作为初始值。
* 新增 为暂时保证兼容，sso /users/me，/srprole api 会实时去mp查询。
* 新增 创建用户时指定订阅号，可以同时把用户加入订阅号中。
* 新增 api  DELETE /clients/unsubscribe,根据client位置以及serviceName删除client。
* 新增 api  DELETE /clients/resources,根据资源信息批量删除client。
* 新增 创建用户时指定订阅号，可以同时把用户加入订阅号中。
* 新增 api /users/username/:userid  根据userid获取username.此接口没有权限要求。
* 新增 api /users/subscriptions 获取当前用户的所有订阅号信息，返回订阅号状态，是否试用等。供ui判断需要展示的菜单。
* 新增 api /admin/users 提供globalAdmin获取user list， 支持订阅号，client等各种查询模式。
* 新增 重新开启appId的校验
* 新增 oauth整合myadvantech登录时，只要时研华的邮箱，则不去marktplace检查是否具有crmid.
* 新增 api /clients/:clientId/users 获取某个client下的所有user.


### Fix bugs 
* client筛选的权限判断改为从mp实时查询资源权限。
* 试用订阅号相关功能的bug修改。
* 修改 整合myadvantech 登录发出注册信中密码不对的问题。
* 修改发信方式为4.0 notification
* 修改apidoc


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


