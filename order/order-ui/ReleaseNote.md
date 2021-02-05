## Order-UI ReleaseNote

### version：1.0.3.4
#### Updated:
- 修复了部署某些情况拿不到环境变量的问题
- 修复了bill页面刷新订阅号没记住的问题

### version：v-1.0.2.2
#### Added:
- 支持crmid为all.选择all后订阅号将是带all的所有订阅号,订阅号默认为all
- 给某些字段添加了多语言
- Bill overview 修改了样式
- Bill 的分页bug，修改为所有选择都会默认到第一页
- 401或者退出后来到登录页右下角不会显示版本号，catalog ui的则会有
- 添加bill下载加载效果，支持bill列表的下载，如果没有数据，会提示无数据

### version：v-1.0.2.1
#### Added:
- order和bill页面分别选择crmid和subscriptionId后，将互不影响，分别记录用户之前的选择，刷新也会记录
- bill页面也会记录之前的月份和服务名
- bill 的overview 提示的多语言
#### Fixed:
- bill overview的显示问题
- bill的分页问题
- header是旧的的问题

### version：v-1.0.2.0
#### Added:
- bill列表
- bills： crmid，订阅号，月份，服务名的查询，服务名默认为all,月份默认当月，时间为1号00:00:00到最后一天23:59:59
- crmid admin并且其订阅号个数大于一，订阅号下拉框会出现all,如果只有一个，会自动选择上
- pageSize为10，20,30，50，快速跳转某页的分页器功能
- 表头和汇总部分的多语言
- 支持下载，成csv格式。
- 401或者退出来到登录页面时，header的portal name会显示成Billing Portal
#### Updated:
- header部分的多语言
#### Fixed:
- crmid和订阅号选择请求有关all的问题

### version：v-1.0.1.9
#### Added:
- 整合header，取消了header的工单按钮,增加了console
- logo旁会显示portal name
- 退出或者401来到catalog ui 时，portal name会显示成Order Portal
- ui组件库升级到了最新版

### version：v-1.0.1.8
#### Added:
- 增加了企业号的选择
- 选择了admin企业号后，其订阅号不为1个时订阅号选择会出现All选项，并默认选择All,否则选择第一个订阅号
#### Fixed：
- 导出文件改成了csv格式
- 导出的价格不存在时改为了0
- 添加了导出加载效果,如果订单为空则会给出提示
- 修改导出订单的问题
- 订单状态Degrade 改成 Downgrade
- 隐藏了创建订单按钮
- 表格增加了订阅号名称列
- 更换了项目字体

### version：v-1.0.1.4
#### Added:
- orderId搜索对应的信息，高亮列表中的orderId
#### Fixed：
- 可用价格修改为pn相加
- 左侧菜单修改UIversion为动态获取
- 订单详情页面布局修改：现由Details和Order Details两部分组成
- Details中orderID和SubscriptionID数据可复制
- Details中订单来源相关数据若不存在则不显示此列表
- orderDetails列表中serviceName列包括两部分内容：serviceName及serviceInstanceId
- 料号一列中数据显示为多个pn:pnQuantity，鼠标移入提示价格信息

### version：v-1.0.1.3
#### Added
- 创建订单时必填的没填时会给出提示
- 创建订单时sso detail接口返回结果前创建按钮将禁用
- 可利用天数支持0
- 搜索orderid支持高亮提示由于目前ordeid还不支持模糊搜索，效果不明显
- 支持修改总价，如果修改了价格的某个参数，将以计算的价格显示
- 修改的总价如果大于两位小数将自动圆整
- 调整订阅号name的宽度
#### Fixed:
- 时间段搜索结束时间,加了.9999 
- 创建订单endat参数也加了.9999
- 创建订单的总价保留两位小数

### version：v-1.0.1.2
#### Added:
- 动态显示时区，在je站点表头是+9
- 增加订阅号接口参数maxResults
- 获取所有订阅号如果填入orderid,将不会携带其它查询参数只保留基础的
- 根据orderid查询点击按钮才会去查询
- 可以清空输入的orderid
- 选择时间段后点击ok才会关闭下拉框默认未选择不允许关闭
- 创建订单，不填写可利用天数和结束时间点击按钮也可以查询pn,并给出提示，创建按钮将禁用
- 创建订单的价格页面全部保留两位小数
#### Fixed：
- 选择时间类型后，之前的时间段将清空，
- 创建订单的显示问题

### version：v-1.0.1.1
#### Fixed:
- 创建订单回到列表再进到创建页面数据留存的问题
- 点击排序会有刷新效果的问题
- 订单列表页面出现滚动条后下拉列表脱离的问题
#### Added:
- 会记录用户之前的搜索条件
- 订单类型和状态，点击即可搜索不需要再点ok
- 增加时间段的宽度，点击可输入时间段，选择时间段后点击Ok即可搜索
- 创建订单填写pn点击查询会列出价格，如果该pn不存在会弹出重试提示，同时创建按钮会禁用
- 如果pn大于一个，左上角会列出个数
- 创建订单页面label全部居左显示

### version：v-1.0.0.8
#### Fixed:
- 选择订阅号后刷新会默认成
上一次选择的
#### Added:
- 首页才会有订阅号选择
- orders列表支持选择pageSize
- 创建订单的订阅号支持搜索
- 如果从catalog选择订阅号后,来到order会默认成catalog选择的
- total价格添加必填图标

### version：v-1.0.0.7
#### Fixed：
- 切换订阅号页码改为1
- 订单列表及详情价格栏不显示
- 订单详情无isPaidAcount
- 一键清空输入栏清空
- 时间的显示
- 创建订单参数的修改
- 火狐里orderDetails标题不居中
#### Added：
- 点击logo可打开catalog
- sso globalAdmin才会显示创建按钮
- 订单详情单独列出了pnInfos
- 创建订单wiseType,orderStatus增加了选项
- 创建订单除pninfos，price外参数改成了一行两列
- 取掉了pninfos里重复的值

### version：v-1.0.0.6
#### Added：
- order刷新
- 创建订单
- 订单搜索(此版本不支持时间搜索)
- 清空搜索
- 订单分页
- 订单详情
#### Updated：
- 取消点击行展开详情

### version：v-1.0.0.0
#### Added：
- 订单的查看
- 切换订阅号订单的改变
- 表格展开查看详情数据
