## Buy-ui ReleaseNote

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
