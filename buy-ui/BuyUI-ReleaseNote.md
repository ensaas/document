## Buy-ui ReleaseNote

### version：v-1.0.4.8
#### Added:
- 包年买断业务
- 初始化进入buy页面，Pricing Plan在最下方显示，且默认选中接口查出chargeType类型的第一个
- 每个chargeType右上角有折扣标签，discount为1的不显示
- 只有chargeType为Monthly的时候保留 Listing Prorated Fee，其他type隐藏
- Discount计算：Monthly保持不变，其余使用 Monthly Fee -  Prorated Fee取反得出
- MonthlyFee以及每个应用table上的小结价格无论什么身份，都*spuNumber即可
- Pay.png中的价格算法用于Prorated Fee，内部package用户prorated Fee使用package价格计算
- 含有依赖的服务价格使用使用serviceWithPlan查出的价格
- 整合ECM，默认先从ECM获得数据，ENABLE_ESM为false就从listingsystem获取
#### Fixed
- Requirement #18059 订阅号user应根据memberType显示价格
- Requirement #17926 根据浏览器显示语言
- Bug #17868 planDescription显示，超过一定长度应折叠起来，鼠标放在上面在显示
- Bug #17867 底部discount显示为负数


### version：v-1.0.4.1
#### Added:
- 此版本依据接口返回数据结构及字段变化，对前端进行整合，涉及
界面的基础数据展示及功能，保证基本功能正常
  - 查询应用及其数据显示
  - 入门包的选择以及应用下plan选择正常
  - 价格以及用量计算
  - 所依赖服务数据显示以及选择
  - 可正常订阅
  
### version：v-1.0.4.0
#### Updated:
- 替换项目头部组件，和其他项目保持一致，功能无变化

### version：v-1.0.3.9
#### Fixed:
- Bug #15686：Data Service & EnSaaS K8s Service页面，当workspace下没有namespace，提示：Now you don't have namespaces Please go to MP to  create a new
- Bug#15687：Data Service & EnSaaS K8s Service页面，当选择EnSaaS-K8s-Service plan后，若没有Dedicated Cluster或General Workspace时，给出提示：Now you don't have Dedicated cluster or General workspace Please go to MP buy Purchase
- Bug #15688：订阅App Service时，点击左上角从新进入Data Service & EnSaaS K8s Service，修改为默认选中dedicated cluster，且选择workspace时，下拉列表不为空
- Bug #15682：修改为当所需资源大于剩余资源，选择ws后，若资源不足，ns为不可选择状态，按钮置灰，不可点击到下一页
- Bug #15719：Global Admin登录，订阅号ispaid=true，点数不足，增加判断，点数不足按钮置灰，ispaid=false，可不看点数

### version：v-1.0.3.8
#### Added:
- 已使用过的namespace校验
- 选择space之后，剩余用量和所需用量之间的判断，不足则给出提示
- 未选择cluster/workspace/namespace时，点击next非空校验，select框显示红色
####Fixed:
- 购买页底部按钮宽度适配不同屏幕大小
- 工单url修改为动态获取
- 无namespace时提示信息
- 从选择了cluster/workspace/namespace的应用跳到catalog，在进入需要选择space的应用，之前选择数据会携带过去初始化显示

### version：v-1.0.3.7
#### Added:
- 订阅页面添加预扣款提示
- Pricing plan卡片Monthly按钮更换名称为 Prepaid Monthly Subscription
- 添加Pay-As-You-Go按钮，鼠标移入显示提示信息，功能暂时不可使用
- 每个应用Deployment Configuration表格添加price(单价)列，若Property为PAYG则价格显示Postpaid usage
- 头部右侧显示商品价格小结，若有Postpaid usage则显示为数字 + Postpaid usage
- 底部去掉剩余天数的提示，添加上了现有点数的信息
- Prorated Price更名为Prorated Fee，添加提示为剩余天数,Total Price更名为Monthly Fee,添加提示为1号扣费，且更换位置
- next按钮添加权限限制，若为globaladmin可不看点数，非globaladmin时，若是付费用户需要查看点数是否足够支付，内部用户无需看点
- 付费用户点数不够时，鼠标移入next按钮提示没有足够的点数，并给出mp的跳转链接
#### Fixed:
- 界面颜色风格修改，和catalog保持一致
- 修复了summary界面表格的行之间没有对齐的问题
- 去掉M+的slider滑动条，保留input框
- 修改界面退出时打开新页面的问题
- 修改订阅权限，globaladmin无法订阅的问题
- 是否能购买规则修改：
  - globaladmin用户可直接购买
  - 非globaladmin用户时，为付费用户且点数够时可购买
  - 内部用户（ispaid为false，memberType时Internal）可购买无需看点
  - 其余用户不可购买，给出相应提示

### version：v-1.0.3.4
#### Added：
- 添加Additional quantity的input输入框：input框改变quantity的值，失去焦点时触发silder的变化和更新price，silder拖动或变化时，鼠标弹起触发input值变化
- I.App鼠标移入后完整提示，默认三行
- 从catalog点击某个plan，buyUI会自动定位到这个plan
#### Fixed：
- 修改I.App for trial的判断逻辑：根据url中serviceName去判断，如果serviceName包含For-Trial，则对应的应用为4个必选应用：'Dashboard','DataHub', 'Notification', 'SaaS Composer'

### version：v-1.0.3.3
#### Added:
- 第二步的db选择下拉框值会默认成非禁用的第一个，如果全部禁用了则显示请选择，点击行时会有加载效果
- 支持globalAdmin的订阅

### version：v-1.0.3.2
#### Added:
- payg的会默认勾选
- 去掉了instance name

### version：v-1.0.3.1
#### Added:
- 401跳转或点击header的portal时会清空instance name
#### Deleted:
- url去掉了交易id
- i.app for trial app去掉了Device on

### version：v-1.0.3.0
#### Updated:
- instance name输入框的值将被记录，不会清空
- 最后一步的所有价格都会保留两位小数
- i.app的页面将根据url是否携带planType为trial显示如果不携带则可以选择，携带的话将不能选择并且在最后订阅时的参数为固定参数

### version：v-1.0.2.9
#### Added:
- 添加get instances api
- 第二步选择了ws后如果该服务已经订阅过则部署的namespace会禁用
- 刚进到buy页面，如果订阅号在mkp没有，sso detail api会提示，并禁用next
- i.app全选时的性能优化,app里去掉了vpn
- k8s服务的instancename,如果在instances里存在，则next禁用输入框提示已存在请重试

### version：v-1.0.1.9
#### Updated:
- sso获取价格的接口改成detail

### version：v-1.0.1.8
#### Added:
- 第三页的unit Price 拆分成了三种
- 修改userEmail的值从sso中拿
- 任何角色都可以来到第三页，没有值的可以看过程
- 增加了order按钮无订阅号的则不会有该按钮
- hz的k8s delicate会自动选上addtional

### version：v-1.0.1.7
#### Added:
- 无订阅号和普通用户在最后一步的提示，分别为你没有订阅号，你是普通用户，现在不能订阅
- 第一步的站点提示修改为现在你不能更换站点

### version：v-1.0.1.5
#### Fixed:
- 选择space plan后再次选择该plan Ws无值问题
- 状态码500不提示，按钮为请求状态 
####  Added：
- space选择时，cluster，Ws,ns请求时会禁用选择
- 取消accountIno接口的提示

### version：v-1.0.1.3
##### Added:
- 第二步的space选择添加加载效果
- 第二步的space添加必选图标
#### Fixed:
- 去除第三步多余的-
- 第三步chargetype的显示
- app部署失败isFinished重置为0
