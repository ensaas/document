## API 4.0.33(2023-3-20)
* 支持totp协议的多因素认证
* 取消saas client只能注册一个的限制
* 支持si portal 的myadvantech登录
* 修改desk的tree-relation/setting api,增加企业账号名称返回
* 修改desk的tree-relation api,增加企业账号名称返回

### Fix bugs
* 修改marketplace创建用户时提示login字段重复的bug
* 其余已知问题

## API 4.0.32(2022-9-28)
* sso读取env支持下划线格式
* 修改cart的client secret
* 多因素认证登录api,password需要加密传入
* 优化登录时，用户找不到情况的错误提示
* 新增支持pn=980GSSOOS00,user和subscription quota不限制数量
* 登录认证的邮件，同一个用户一分钟只能发送一封

## API 4.0.31(2022-8-30)
* login增加双因素认证登录的api(图片验证码)
* 整合审计中心，将日志发送到审计中心
* jwt-go 升级到v4版本
* login日志增加ip地址
* 支持通过系统配置设置token的有效期（不包括永久token）
* 多因素认证登录支持短信/邮件验证码
* client type新增一种类型 saas,saas类型得client既可以创建srpuser，又可以分配平台上api的权限。且saas client与operation client或者其他saas client的名称不能重复
* 新增client key管理api,目前可以在sso生成一个时效性或者永久性的key,这个key可以用来注册saas client，一经注册key会失效。
* 修改api post /clients/{clientid}/users,不在检查workspace owner权限
* 新增api get /clients/{clientid}/saas/users 提供给saas类型的client获取sso详细的用户信息
* policy数据表增加记录最后一次修改人字段
* 如果企业号下的订阅号为树形，那么在这个企业号下的订阅号之间，父级订阅号admin可以添加子订阅号admin
* 修改禁用订阅号时，订阅号下是否有资源的判断标准，由catalog获取订阅号资源 api返回空改为 api返回的数据列表总，为空或者全部都为License

### Fix bugs
* 修改账号第一次被锁是提示的锁定秒数不对的问题
* 修改订阅号用户添加功能，企业号管理员以及父级订阅号只能添加和移除订阅号admin,不可以添加和移除订阅号user

## API 4.0.30(2022-6-27)
* 新增支持订阅号创建子订阅号，即订阅号上下关系为树形，目前仅在公有云的料号下
* 兼容订阅号的树形结构以及平行结构，通过企业号是否有设置partner_type来决定
* 企业号初次设置partner_type时会自动将企业号下的非主订阅号都放在主订阅号下
* 修改禁用用户时，如果为对接光环云的场景，只有用户绑定过手机号才回去光环云同步用户状态
* /desk/subscriptions/{subId}查询时返回已分配已经已用的订阅号quota树
* subscription desk setting 移除字段NextChildSubscriptionQuota，订阅号可以使用自己分配过的剩余的quota
* 支持设置cookie的samesite属性（升级了golang版本以及基础镜像的版本）
* 添加Advantech employee zone LDAP

## API 4.0.29 (2022-5-6)
* 用户新增数据login，支持通过login+password登录。
* 新增参数SystemDisablePasswordPolicy，控制在非公有云场景下，不进行密码规则的检查
* 为了兼容SRP应用，在通过login字段创建用户时，username默认和login保持一致（保证username不为空）
* 用户名和login不允许重复，互相之间也不允许重复（新的login不等于任何已存在的login或者用户名。 新的用户名规则一致）
* 定时删除操作记录（7d）不再删除企业账号的memberType变更记录
* 在docker版本上（没有MP并且license不是公有云），订阅号用户拥有查看所有client的权限

## API 4.0.28 (2021-12-31)
* 新增企业账号，用户数据对伙伴光环云。
* 增加用户实名认证
* 增加企业实名认证
* 新增当前登陆人获取个人实名认证和发起的企业实名认证信息api
* 新增proxy api,转发发票相关的api到光环
* priceType 改为从配置读取，优先级 env>config>json
* 新增同步企业号实名认证结果的api
* 新增修改企业号member type的api
* 新增支持proxy工单管理的api 
* 新增获取企业号余额api
* 新增api /mail/sre/contact  发送邮件给SRE
* 新增配置 Email.sres 在环境变量中设置接受短信的sre数组
* 新的企业账号管理机制
* 系统启动时，统计出需要发信的企业号admin列表，依次告知企业号管理机制改变。
* 新增api /users/{username}/real-name-auth 查询其他人是否完成实名认证
* 给SRE发送通知邮件的api增加验证码检查
* 新增api /mail/verify/image 获取验证码


### Fix bugs 
* 修改操作记录，如果操作人为root账号时，操作人角色为空的问题


## Portal 4.0.29 (2021-8-12)
* 添加自激活功能。自动禁用的用户可以通过邮箱、手机接收验证码，激活账号

## API 4.0.25 (2021-8-12)
* 自动禁用用户的用户状态改为Inactive
* Inactive的用户不允许登录
* Inactive的用户支持用户通过email,sms接受验证码激活

## API 4.0.24-hotfix2 (2021-7-27)
* Catalog uri 后面添加 /login

## Portal 4.0.28-(2021-5-13)
### Requirement
* 登入后加入论坛广告弹窗
## API 4.0.24-(2021-5-12)
### Fix bugs
* env增加ldapPartners参数
## Portal 4.0.27-(2021-5-12)
### Fix bugs 
* 根据后台接口判断是否显示ldap中的中荣医院选项
## Portal 4.0.26-(2021-5-11)
### Fix bugs 
* 修复语言切换时bug
## Portal 4.0.25-(2021-4-29)
### New Features
* 批量删除订阅号用户。
* 加入LDAP登录和LDAP配置页面。
* 加入登陆配置页面
## API 4.0.23 (2021-4-29)
* 新增整合标准ldap
* 新增整合台中荣总ldap api
* 新增LDAP系统配置
* 新增更新系统配置api
* 禁用的sso账号不可以使用ldap登录
* 新增api /users/me/marketplace/sync. 从marketplace同步某个用户的订阅号权限数据。
* 新增api /subscriptions/{subscriptionId}/smtp-setting配置与获取订阅号的smtp服务器
* 新增配置HttpRequest.UseFastHttp 启用fasthttp发送http 请求。

### Fix bugs 
* 修改部分bug.
* 由于nginx特性，取消密码锁定判断中的ip检查.
* 修改邮件模板
* 修改密码旧密码验证失败由返回401改为403
## API 4.0.22 (2021-1-28)
* 新增系统配置项具体如下：
	SystemLoginErrorCountConfig ---- 设置系统的登录错误总数，初次更新默认值500
	SystemLoginErrorIntervalConfig ---- 设置系统登陆错误统计的间隔，初次更新默认值60（s）
	（在一个间隔内，如果登录错误数超过错误总数的设置，则会触发发送邮件的逻辑）
	SystemLoginErrorReceiverConfig ---- 频繁错误 邮件的接收者（数组）,初次更新默认值为空
	SystemPasswordChangeRemindIntervalConfig ---- 提示用户修改密码周期，初次更新默认值为60*60*24*90(s),即90天
	SystemAccountLockErrorCountConfig  ----  某个用户密码错误锁定账号设置的错误次数，初次更新默认值为3
	SystemAccountLockIntervalConfig ---- 用户账号锁定时长，初次更新默认值为300(s)
* 新增记录用户最近的三次密码功能。（更新后没有数据，只在每次修改密码时，对密码进行记录）
* 新增api GET /admin/config 获取1中配置的值
* 新增api PUT /admin/config body {"id":"1中的配置名","params":"配置的结果"} 修改某条配置
* 新增用户修改密码时检查最近三次密码是否重复。
* 新增用户登录密码输入错误时，会统计累计次数，达到1中设置的阈值则会发送邮件。
* 新增用户登陆时，如果长时间未改密码（长时间的标准以1中设置为准），则会返回提示。
* 新增用户超过6个月没有登录则会自动禁用。
* 新增订阅号创建时间超过6个月，并且订阅号下最近6个月没有用户登录，且没有资源，订阅号会自动禁用。
* 新增企业号创建时间超过6个月，并且最近6个月没有用户登录，并且其下的订阅号都在禁用状态，企业号会自动禁用
* 修改企业号自动跟marketplace同步时，日志记录不写入操作记录表，只是打印log。
* 企业号导出excel列表增加status字段返回。
* 修改用户修改密码的验证码可以在10分钟内重复使用的问题。
* 修改注册客户端scopes中带有空格则会导致生成clientToken报错的问题。
* 新增订阅号时如果limitPoint>0 则会默认生成一条quota变更记录。
* /v4.0/users/enterprises/subscriptions 默认只返回active的订阅号
* /v4.0/subscriptions/selector 默认只返回active的订阅号
* 添加创建用户，自己注册用户，mkp自动登录创建用户的操作记录
* 修改helm chart


## Portal 4.0.24-(2021-1-28)
### New Features
* 新增批量添加订阅号用户功能
* 添加sso logo
### Fix bugs 
* 修复订阅号页面刷新时所选订阅号改变的bug
* 修复license inactive时切换页面就告警的bug
* 修复修改手机时未发送验证码就提示 验证码格式不正确 错误的bug
* root用户可以在编辑自己信息的页面删除自己的订阅号权限
* 修复注册页面顶部导航栏出现文档按钮的bug
* 修复订阅号筛选状态时换页的bug


## Portal 4.0.23-(2020-12-31)
### Fix bugs 
* 修改其它portal使用sso登陆时的bug

## Portal 4.0.22-(2020-12-31)
### Fix bugs 
* 修复用旧路径登录时的bug

## API 4.0.21 (2020-12-30)
### New Features
* 新增订阅号禁用启用功能
* 新增企业号禁用启用功能
* 新增/v4.0/health 查看当前app,pg,redis的状态
* 增加/v4.0/license/info，查看当前license 信息。
* 增加/v4.0/license/check,重新检查license
* 新增用户自己注册api
* 新增批量添加订阅号user api

### Fix bugs 
* 修改active info


## Portal 4.0.21-(2020-12-30)
### New Features
* 企业号和订阅号增加禁用功能
* 登录页面加入用户自注册功能

## Portal 4.0.20-(2020-11-30)
### New Features
* 修改静态文件缓存机制

### Fix bugs 
* 修复企业号管理员托管订阅号时不能删除其他订阅号管理员BUG

## API 4.0.20 (2020-11-27)
### New Features
* 增加订阅号user变更操作记录
* 增加订阅号bill-discount变更操作记录
* 增加订阅号effective-bill-discount变更操作记录
* 提供api给订阅号用户查询以上操作记录


### Fix bugs 
* 订阅号user列表区分返回企业号托管得到的权限以及真实绑定的权限
* 订阅号修改时，如果需要变更limitPoint，则limitPoint不允许为负数。
* 修改企业号admin新建订阅号admin的bug（用户不存在时）
* 修改/users/{username} 返回交叉权限时，增加企业号的相关订阅号的判断。

## Portal 4.0.19-(2020-11-27)
### New Features
* 增加订阅号用户变更记录和订阅号折扣变更记录
* 订阅号用户列表分为成员列表和托管成员列表

## API 4.0.19- (2020-11-11)
### New Features
* 添加在初次更新时，会将所有的默认订阅号可用额度改成-1，非默认订阅号改成0.
* 初次启动时，会将所有企业号中memberType为Internal的 memberType改为WISELead,isInternal改为true,(mpdefault 会改为PremierVIP)
* 初次启动时，会扫描所有企业号，如果其下没有默认订阅号，则会创建出来，id默认为名称进行md5加密，如果重复则改为uuid.

### Fix bugs 
* 修改发信时notification返回状态判断错误的问题
* 修改查询剩余额度时小数点后位数不准确的问题(涉及所有返回剩余点数的api)
* 修改注册信和重置密码信添加datacenter 信息
* 修改非默认订阅号不能设置limit为-1(新建和修改)
* 修改剩余额度排序问题
* 修改第五点，初次启动，默认订阅号为-1，非默认订阅号保证 余额为0.
* 订阅号detail api增加校验marketplace返回的结果是否有效，不只是从状态码判断是否成功。

## Portal 4.0.18-(2020-11-11)
### New Features
* 子订阅号可用额度原来为无限制的调整为0，若需要调整，可以前往【订阅号】【编辑】【当前可用刻度】进行调整。
* 企业账号管理员收到的订阅号托管通知在登陆后的弹窗里以表格的形式呈现

## Portal 4.0.17-(2020-11-5)
### New Features
* 订阅号可用额度变更记录表格展示明细和余额

## Portal 4.0.16-(2020-11-4)
### New Features
* 企业账号创建订阅号时默认不再拥有订阅号admin权限
* 企业账号admin可以申请托管订阅号以获取订阅号下应用的访问权限
* 订阅号admin可以申请被托管，使得企业账号admin拥有订阅号下应用的访问权限
* 用户登录后如果有收到托管请求，则弹窗提示，引导其前往订阅号页面进行处理
* sso适配lite版本，去掉和企业账号相关的功能

## API 4.0.18- (2020-11-04)
### New Features
* 整合license
* 新增api /subscriptions/:notifyId/hosting-request/never-notify,设置当前消息不再提醒。
* 新增api /subscriptions/:subscriptionId/hosting-request,根据订阅号id获取订阅号notify.
* 调整订阅号通知提醒的机制，实现新的二房东机制。
* 调整api /subscriptions/hosting-requests 将只返回需要提醒的总个数，改为返回每条提醒得详细信息。
* 调整api /subscriptions/:subscriptionId/detail返回的参数字段

## API 4.0.17.0- (2020-09-30)
### New Features
* 添加 billRateUnit KRW

## API 4.0.16.0- (2020-09-29)
### New Features
* 新增订阅号配置项，共享会员身份、访问费用中心、消费配合、是否被企业号托管、费用账单汇率
* 企业号admin是否默认拥有订阅号admin的权限根据订阅号是否启用了被企业号管理来决定（目前主要体现在用户token已经/users/me等api）
* 是否被企业号托管 属性需要订阅号admin和企业号admin同时通过才能变更
* 创建企业账号会默认创建一个名称和crmid相同的订阅号
* 整合ECM
* 对订阅号quota limit，used的变更以及是否被企业号托管的状态变更做记录，提供api /subscriptions/records 来查询

## Portal 4.0.15.0-(2020-9-15)
### New Features
* 创建订阅号时默认使用企业账号的 memberType

## Portal 4.0.14.0-(2020-8-31)
### Fix bugs
* 修改顶部导航栏各服务描述

## Portal 4.0.13.0-(2020-8-28)
### New Features
* 头部导航栏使用公共组件
### Fix bugs
* 别的项目点击忘记密码访问sso的忘记密码页时，会跳转到sso的登录页面

## API 4.0.15.0- (2020-08-21)
### New Features
* 新增手机号绑定，通过手机号重置密码等功能，分别对应2，3，4中api
* 新增api /users/mobile-phone/{mobilePhone}/binding-code, 发送绑定手机号的验证码
* 新增api /users/mobile-phone/{mobilePhone}/binding，绑定或者更换绑定手机
* 新增api /users/{mobilePhone}/pwdresetsms ，发送忘记密码的验证码到对应手机号
* 新增配置项 ① Sms.Enabled (是否启用sms发信功能), ② Sms.LimitCount(同一个账号在一定时间段内可以发送绑定验证码的次数),③ Sms.LimitTime(②中的时间段，单位位秒)
* 新增api delete /auth/native 注销token,修改 api  delete /auth,登出后同时注销token
* 修改 /params 增加返回Sms.Enabled
* 企业账号admin可以修改订阅号memberType
* 默认订阅号不允许编辑信息
* 默认订阅号（指订阅号名称等于企业账号id的那个订阅号）的memberType会一直跟企业账号保持一致，不论是修改了企业账号的memberType还是调用detail刷新 

## Portal 4.0.12.0-(2020-8-21)
### New Features
* 个人主页中可以绑定手机号
* 登陆处忘记密码可以选择使用手机号或者邮箱接收验证码

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


