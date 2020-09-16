## Order-API ReleaseNote

### version：v-1.4.0.2
#### Updated:
- 整合了listing-1.7.0.8的servicePlan接口

### version：v-1.3.0.9
#### Updated:
- 创建的renew订单都会存放到renew_order表中，其他orderType的跟以前一样
- 创建的renew订单也会拆账，拆账之后的订单会存放到renew_order表中，其他orderType的跟以前一样
- 新增加接口会将renew_order表中的数据导入到order_service_instance,和order_pn中

### version：v-1.3.0.8
#### Updated:
- 查询订单
   - 如果是sso admin和client token查询所有的订单 
   - 如果传入了crmid，会判断是不是crmid admin，如果不是，则查询失败，如果是，则查询该crmid的订单 
   - 如果不传任何条件，则根据token中，查询所有crmid 为admin的订单 
   - 去掉对订阅号admin的默认查询 

### version：v-1.3.0.6
#### Add:
- 添加isInternal字段，之后扣点根据：isInternal=false&&isPaidAccount=true&&wiseType!=WISELead
- 扣点之后会将扣点的记录存入数据库，包括扣点的RequestId，所有扣点的order,所有扣点listingPrice总和，memberPrice总和，proratedPrice总和
- 添加API GET /deductionRecord?requestId= 根据requestId获取扣点的记录 注：requestId不为空
#### Updated：
- 创建订单会将orderType=Unsubscribe的所有价格更改为零
- 拆账的wiseType根据crimd 的memberType设置，并且价格也由对应的memberType计算

### version：v-1.3.0.5
#### Changed: 
- 添加退订订单时，更改所有价格为零

### version：v-1.3.0.3
#### Changed: 
- 更改扣点为：orderType不是internal和WISELead并且isPaidAccount=true才扣点 
- 更改拆账为：orderType是internal和WISELead不会创建拆账订单

### version：v-1.3.0.1
#### Updated:
- 所有wise_type=Internal的都不会创建内部订单，也不会拆账
- 取消对同一个订阅号下的不同instanceId的校验

### version：v-1.2.0.9
#### Updated:
- Put /orders/ordeInfo 支持同时更新多个order

### version：v-1.2.0.8
#### Updated:
- Put /orders/:id/ordeInfo 添加对serviceInstanceName的更新 
- 发送给bill的order中如果serviceInstanceName为空就发送serviceInstanceId

### version：v-1.2.0.7
#### Updated:
- 更改扣点逻辑： 之前:isPaidAccount=true&WiseType in ('Regular','VIP','PVIP') 现在：isPaidAccount=true&WiseType != 'Internal'

### version：v-1.2.0.6
#### Updated:
- 更新接口：put /order/{orderId}/orderInfo
- orderStatus:
   - Processing-->Available：根据之前的PnListingPrice和PnMemberPrice计算PnProratedPrice和TotalProratedPrice
   - Processing-->Canceled：会将所有价格置为零
   
### version：v-1.2.0.4
#### Updated:
- 更改添加订单为批量添加
#### Added:
- order添加packageId
- PUT /order/{orderId}/orderInfo 更新order

### version：v-1.2.0.2
#### Fixed:
- 修改排序问题

### version：v-1.2.0.1
#### Fixed:
- 修改分页查询数据重复的问题
- 修改clientToken同平台部署会失效的问题
- 修改order程序崩溃的问题

### version：v-1.1.0.19
#### Fixed:
- 修改分页查询数据重复的问题
- 修改clientToken同平台部署会失效的问题

### version：v-1.1.0.16
#### Updated:
- renew order手动调用api扣点
- 其他order Type的order通过定时器设置扣点（deductionTime）
- 拆账订单通过定时器设置拆账（payoutTime）

### version：v-1.1.0.13
#### Added:
- PnInfo中添加PnProperty,如果catalog没有发送该字段，则这个字段从listingsystem获取
- 扣点时会将这个字段发送给bill

### version：v-1.1.0.12
#### Added:
- Post /renewOrder/deduction添加流量限制，等上次的renewOrder处理完成之后才能再次调用
- 对内部拆账出现问题的order进行处理

### version：v-1.1.0.9
#### Added:
- POST /renewOrder/deduction 对renew的账单进行扣点和拆账
- GET /payout/abnormalOrders 获取拆账异常的订单
#### Fixed:
- 创建order的internalOrder中传入的pn为空，order仍然能够拆账成功，且拿到的pnMemberPrice不为空

### version：v-1.1.0.6
#### Fixed:
- ，拆出来的订单，totalProratedPrice计算方式不正确导致计算结果有误差。
- 对外部账单进行自动拆账，部分拆出来的订单订阅号信息为空（订阅号id\name\type\company\crmid）,且从listingsystem获取到的非空 比如测试WISE.M+,拆出来的订单内部订阅号信息就是空的，但是测试OEE是正常的
#### Updated:
- 内部拆账的order的memberPrice根据subscriptionId从listing获取

### version：v-1.1.0.4
#### Added:
- 添加环境变量datacenterCode,用于判断获取月初和月末用那个时间段
- 添加GET /version 获取order当前的版本
- pnInfo添加licenseInstanceId
#### Fixed:
- 调用api修改order的开通时间，api返回成功，但开通时间实际并未被修改
- 当订单的orderType是Unsubscribe,则规格上不对此类型的订单进行拆账

### version：v-1.1.0.3
#### Added:
- order_pn表添加id，唯一标识一条记录
- 添加 GET /abnormalOrders,返回异常order
> 注：异常order包括如下几种：
> 1.	在order_instance中存在但在order_pn中不存在的记录
> 2.	在order_pn中存在但在order_instance中不存在的记录
> 3.	order_pn表中的价格经过计算后与order_instance中的价格不相同的记录
> 4.	order_instance中的is_paid_account=true时，wise_type不是('PremierVIP','VIP','Regular')这其中的一个
> 5.	order_instance中的is_paid_account=false时，wise_type是('PremierVIP','VIP','Regular')这其中的一个
#### Fixed:
- 自动拆账订单的pn/totalProratedPrice计算结果不正确，部分订单的结果没有取小数点后两位并向上圆整
- 自动拆账订单的totalProratedPrice计算不正确，当pnQuantity不为1时，totalProratedPrice仍然按照1进行计算

### version：v-1.1.0.2
#### Fixed:
- 拆账订单只保存了order_service_instance数据库，没有保存order_pn数据库，即获取拆账的order时没有pninfo信息；
- 拆账订单的price相关信息没有按照拆账服务对应的price去计算，而是显示与source订单的price一样；
- 自动拆账后所有拆账订单的source_subscription_id均为空；
- 当一条订单中包含的拆账订单不止一条，拆出来只有第一条是有source订阅号信息的（source_crmid、source_company、source_subscription_name），其他拆单的相应字段都是空；
- 拆账订单的wise_type和is_paid_accout信息所有全部显示为PremierVIP和true，没有按照拆账订阅号相关信息显示；
- Swagger中部分字段和格式有误，导致无法创建order，建议修改；


### version：v-1.1.0.1
#### Changed:
- order_service_instance  
   - 删除: createtimestamp,activatedTimestamp,updatedTimeStamp,deletedTimestamp
   - 添加：isPayOut
- order_pn
   - 删除: subscriptionId
   - 添加：chargeType，serviceInstanceId（之前是与外面的相同）
- Create Order
   - 添加: internalOrder,isPayOut
#### Added:
- 扣点及拆账：
   - 从db中获取满足扣点条件的order，
   - 查看对应order内部价格与外部价格是否相同，如果不同就跳过，不会扣点，也不会更改状态
   - 满足以上条件，则调用bill 的api扣点
   - 扣点完成后，查看是否需要拆账
   - 如果需要拆账，则获取internal账单，进行拆账，拆账之后，删除internal订单 注：internal账单中只有listingPrice，其余价格都是通过该价格的pvip身份计算，保留两位向上取
   - 更改order状态 注：默认五分钟进行一次扣点，可通过env:deductionTime更改
- 增加orderId的模糊查询
- 添加对查询的结果按时间排序
- 增加刷新token，在token过期之前五分钟内调用接口就会刷新token，domain: (.bm.wise-paas.com.cn)
#### Updated:
- 更新所有的查询时间，之前查询时通过timestamp查询，现在是通过utc时间查询

### version：v-1.0.0.20
#### Updated:
- 修改order中availabledays为0-31天（之前是1-31天

### version：v-1.0.0.18
#### Added:
- order添加字段：crmid,company,subscriptionName,subscriptionType（这些在创建的时候从sso获取）ourceCrmid,sourceCompany,sourceSubscriptionName,sourceSubscriptionType

### version：v-1.0.0.17
#### Fixed:
- 修改updatedAt时间格式
- 修改subscriptionId查询出错问题
- 修改activitateTime查询出错的问题
- 修改subscription user返回状态
- 修改utc时间格式
- catalog调用Order返回500

### version：v-1.0.0.12
#### Fixed:
- 修改字段ActivtedAt为ActivatedAt
- 修复为返回activatedTimestamp未返回的问题

### version：v-1.0.0.9
#### Added:
- order实例中添加crmid（该字段从sso获取）
- 添加api： 
   - POST /addCrmid 补全之前order中的crmid，操作权限：globalAdmin
   - GET /checkOrders 获取所有的order，无权限校验，未在swagger中列出
- 在api /orders中添加如下查询条件   
   - crmid：根据公司id获取order （非必填）  
   - subscriptionId：根据订阅号id获取订单 （非必填）  
   - serviceName：根据serviceName获取订单 （非必填）  
   - serviceCategory：根据serviceName获取订单 （非必填）  
   - orderId：根据orderId获取订单 （非必填）  
   - orderStatus：根据orderStatus获取订单 （非必填）  
   - orderType：根据orderType获取订单 （非必填）  
> 注：globalAdmin获取所有订单，其他user只获取当前订阅号是subscriptionAdmin下的order

