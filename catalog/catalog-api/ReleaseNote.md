## ReleaseNote

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
