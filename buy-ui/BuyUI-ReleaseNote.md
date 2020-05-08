## Buy-ui ReleaseNote

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
