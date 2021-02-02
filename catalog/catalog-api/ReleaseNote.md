## ReleaseNote


### version：2.0.3.0
#### Added：
- 新增 包年服务购买模式
- 新增 永久性服务购买模式
- 新增 内部购买服务包的内部价计费模式
- 整合listingsystem折扣系统，支持服务在不同购买模式下的折扣计算
#### Updated:
- 修改 退订，恢复，删除 只能操作包月的服务
- 修改renew，只支持包月的服务
- 完善 整合ESM错误信息提示

### version：2.0.2.4
#### Added：
- 增加发信，当用户部署完成后，发信给该订阅号的所有admin用户，通知其服务地址信息
- 增加发信，当用户退订后，发信给该订阅号的所有admin用户，通知其已经退订
- 整合新版pipeline接口
- 为SSO调用GET /serviceInstances接口授权
- 整合CI
#### Updated：
- 修改退订流程，当延迟退订时，先建立订单再等到下月1号凌晨更新订单

### version：2.0.2.2
#### Added：
- 增加审计日志功能
#### Updated：
- 修改退订Inprogress状态下的实例时也同时发退订邮件给SRE.
- Chart有变动。
- 整合sso新接口 GET /subscriptions/:id/details
- 整合order接口，去除isPaid字段。

### version：2.0.1.9
#### Updated：
- 整合SSO剩余点数校验以及信用额度，修改提示信息。

### version：2.0.1.8
#### Added：
- 整合ListingSystem。主要修改packaged service 与 intergration service。
- 整合SSO GET /subscriptions/:id/detail接口，获取crmMemberType, isInternal, isPaid字段；原有的priceType字段逻辑不变。
- 整合 Order ,创建订单时传入isInternal字段。
- 整合 宋严正在开发的pluginbuy项目。
#### Updated：
- 修改Catalog发信格式，增加crm信息。
- 修改 Delete /serviceInstance/:id接口逻辑，为了不破坏既有流程，现只支持从Inprogress和Active到None。
- 修改退订逻辑，增加Inprogress时的逻辑。如果实例为Inprogress会将该实例的订单取消；如果是服务包并且有任何一条Inprogress的实例，则会将这个服务包下的订单全部取消。并调用各个buy删除实例。
- 修改独立购买的服务实例退订时，创建订单proratedPrice不为0的bug。
- 更新chart，增加pluginbuy的参数配置。
- RMQ消息方面，在DELETE /serviceInstances/:id 希望传入的operation为 delete_start与delete_end。

### version：2.0.0.13
#### Updated：
- 订阅时 去除 service instance name的限制 （填和不填都行，无校验）
- 修改license 回执消息无法修改消息状态的bug
- 为license提供的 GET /serviceInstances/license/{licenseInstanceId}接口多了1个参数，deleted ，默认为false。 此参数的目的是让license默认查询到 Active的实例，deleted为true即查询全部状态的实例

### version：2.0.0.12
#### Added：
- 在订阅、退订时发邮件给SRE

### version：2.0.0.10
#### Updated：
- 修改接口 POST  /serviceInstanceOnlyForData 增加字段 activedAtTimestamp

### version：2.0.0.9
#### Fixed：
- Fixbug  删除实例时，无法更新deployStatus字段与activedAt字段
- Fixbug  下游消息存库时，没有保存activedAt字段
- Fixbug  导入数据到catalog时，增加部分字段校验,如userId
- Fixbug  renew service instance 时，创建订单 总价计算错误，没有乘数量

### version：2.0.0.8
#### Added：
- 增加renew 5月所有service instance的接口。 POST / serviceInstanceRenewMayData

### version：2.0.0.7
#### Updated：
- 修改订阅时对db、mp instanceName的校验逻辑
- 修正在各时区中endedAt时间错误的问题
#### Added：
- 新增补录数据接口  POST  /serviceInstanceOnlyForData 。支持mpbuy，servicehub和appbuy的clientToken调用
