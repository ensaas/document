
### Minisite Portal v4.0.0.18 (2021-02-09)
**Added:**
- 新增匿名访问
- 新增匿名访问时下载资料，需填写用户信息

### Minisite API v4.1.0.3 (2021-02-09)

**Added:**
- 新增匿名访问
- 新增填写用户信息接口



### Minisite API v4.0.1.8 (2021-02-08)

**Added:**
- 新增权限(admin,solution-privider,solution-user,viewer)
- 新增获取登录用户信息接口
- 新增修改用户权限接口

**Fixed:**
- 修改添加，删除，更新等用户相关的接口从而进行权限管理
- 修改添加，删除，更新service及app等相关接口从而进行权限管理
- 修改添加，删除，更新resource等相关接口从而进行权限管理
- 修改根据id更新，删除resource为根据uuid


### Minisite Portal v4.0.0.14 (2021-02-09)

**Added：**
- 新增用户权限管理功能

**Fixed：**
- Console > Service Portal 連結連至<MP_URL>/instance-list
-  Contact us 頁面最底下郵件 icon 更改为清晰度较高的 icon
- 點進Technical White Paper，英文版左側選項會超出邊界文字处理
- WISE-PaaS/IoTSuite 裡的WISE-PaaS/DB Services (InfluxDB)、WISE-PaaS/DB Services (MongoDB)、
WISE-PaaS/DB Services (PostgreSQL)、WISE-PaaS/Secure Tunnel 链接 TD頁面地址修正
- 头部“”联系我们“”繁体展示修正
- Top Navbar 展示高度调整

**Helm Update:**
- 维持 0.1.5 版本


### Minisite Portal v4.0.0.10 (2021-01-19)

**Fixed：**
- Package run.sh 中 ESM 路径获取方式修正

**Helm Update:**
- 更新至 0.1.5 版本，修正 ESM 路径获取方式

### Minisite Portal v4.0.0.6 (2021-01-06)

**Added:**

- 头部广告栏位与 Catalog 保持一致，并抽离为公共组件（包含试用活动、产品动态、新品发布、
  企业账号管理机制模块）
- 产品简报模块展示各产品相关介绍 PDF 文件
- 使用指南模块展示各产品相关使用手册，支持 PDF 、图片、文档、链接、视频等类型资源
- 技术白皮书展示各产品相关技术难题，支持PDF、文档形式
- WISE-PaaS/IoTSuite 模块展示各产品，点击可进入marketplace中相关详细介绍
- 发行说明模块展示各产品相关动态
- 每个模块中，点击卡片或文本按钮可进入相应模块数据资源详情展示界面
- 头部资源下拉选单中 FAQ 模块可浏览各产品使用过程中遇到的相关难题
- 头部资源下拉选单中 TroubleShooting 可浏览相关故障排查资料
- 联系我们模块用于用户反馈 IoTSuite 使用过程中遇到的问题

### Minisite API v4.0.1.3 (2021-01-06)

**Added:**

- 添加用户权限认证
- 添加获取service及app相关信息API
- 优化获取素材信息API
- 添加修改status及修改isshow接口
