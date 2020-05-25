## Order-UI ReleaseNote

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
