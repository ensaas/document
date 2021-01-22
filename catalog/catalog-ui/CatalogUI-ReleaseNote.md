## ReleaseNote

### version：v-1.0.5.2
#### Fixed：
- 添加修改了企业帐号申请单的多语言部分
- 协议部分云平台官网跳转重新打开页面
- 删掉catalog头部的订阅号选择框，购买时放在buyUI中选择

### version：v-1.0.5.1
#### Updated：
- 修改首页4个广告栏位；
    - 添加 WISE-PaaS/IoTSuite新品发布广告栏位，点击后链接到IotSuite产品介绍pdf；
    - 将quick-start添加至广告栏位；
    - 取消了具体产品的申请，改为广告页入口--“云产品免费试用”，点击后进入申请单页面；
    - 添加企业帐号申请，点击后进入企业帐号申请界面；
    
- 将原有的试用申请单中，servicesName下拉选择框修改为卡片形式展现在顶部，现在应用为固定的5个，展示在一页，如果多余5个，显示分页，点击卡片可以选择对应的应用，点击进入默认选择Iotsuite，其他逻辑不变；
#### Added:
- 添加了企业用户申请单页面，页面可参考附件：企业用户账号申请.png;
> 注：需求在开发中也有少许修改，具体显示以界面实现为准；

### version：v-1.0.4.9
#### Added：
- 增加当前地区推荐合适的portal功能。（hz:中国， sa：其它地区， je：日本）（如在中国区打开sa，则会提示去hz站点的portal，如果打开的是hz的则不会提示）。
- GO NOW鼠标放上去会有即将前往的portal地址。
- 关闭按钮鼠标放上去会提示下次不再显示，关闭后后面打开将不会再显示。
- 除以上站点，其余站点打开都不会有该提示。
- 申请单页下面添加了交付时间提示： The application will be answered and delivered within 3 working days.

### version：v-1.0.4.4
#### Added：
- Header增加了consoles,并有各portal的描述，点击可跳转，如果没有链接，则会提示无此链接，非首页才会显示
- sidebar和卡片里的列表，如果该服务isVisible为false，该服务将不显示
- 卡片如果有displayName,则排序规则会按照displayName走，否则按照serviceName
- 卡片名首字母取消了大写
- 取消了工单上线的公告

### version：v-1.0.3.5
#### Deleted：
- 跳转到buy的url去掉了交易id

### version：v-1.0.3.4
#### Updated：
- 服务详情页面url去掉了订阅号
#### Added：
- 点击i.app的for trial plan，url上将拼接？planType=trial,其它所有plan则没有

### version：v-1.0.3.3
#### Added：
- 服务详情页面服务描述，默认设置为5行，超过5行才会显示…
- 服务i.app不管是什么身份都会有两个Plan，一个是for trial，都可以点击,价格也会不同
- 换顶部的订阅号，如果该订阅号在mkp上没有，则redeem按钮会禁用掉
- 到服务详情页面会有loading的效果包括最低价，和价格详情页，并会清空，之前的服务的详情

### version：v-1.0.3.2
#### Added：
- 加order按钮
#### Updated：
- 整了购物车订阅号的宽度
- 择订阅号后打开order,Order会默认成catalog选择的订阅号
- 取订阅号增加了maxResults参数来获取所有订阅号

### version：v-1.0.3.1
#### Fixed：
- 购物车的创建时间显示
#### Added:
- 服务名含有特殊字符如M+,M.iFactory/Metalworks的详情显示
- 登录页面添加advantech登录logo，多语言，bm站点无此logo
- 增加order按钮，无订阅号则无该按钮

### version：v-1.0.2.9
#### Fixed：
- 隐藏order按钮 

### version：v-1.0.2.8
#### Fixed：
- 购物车页码高亮
- 购物车创建时间显示

### version：v-1.0.2.7
#### Updated：
- sso获取价格的接口改成detail
- 购物车的分页功能
#### Fixed：
- 购物车时间的显示

### version：v-1.0.2.6
#### Added：
- advantech账号登录后如果url有redirect，登录后会来到redirect地址
- header增加订单按钮 无订阅则没有该按钮

### version：v-1.0.2.5
####  Added：
- 普通用户也可以点击跳转
- 购物车删除全部换为了cartId,支持删除，右上角的总个数更新
- 订阅号的搜索支持公司名

### version：v-1.0.2.4
####  Added：
- 删除购物车成功后的提示
####  Updated：
- 取消灯泡的压缩
- 取消accountIno接口的提示

### version：v-1.0.2.2
##### Added:
- 整合my advantech账号登录
- 整合登录页面添加响应式
- 支持无订阅号用户登录及查看
- 非hz站点没有备案号
#### Updated:
- 更换信息提示样式
#### Fixed:
- 站点显示
- 服务列表搜索支持多空格
