# Servcie Hub 整合文档

## Service Hub介绍  

云平台提供了服务于托管类云服务订阅及管理的机制（Service Hub），让第三方平台上的云服务也可以上架到云平台上。托管类云服务可以部署在任何位置，由服务提供者直接向用户提供售后技术支持和运维。与Service Hub整合之后，即可让云平台用户获得与其他部署于云平台之上的服务一致的商务界面。用户可以通过WISE-PaaS 物联云市场进行服务的订阅，以及升级，降级，重新订阅及退订。
用户订阅服务时，由Service Hub协助串接商务流程，包含服务实例授权、订单生成和自动扣费等。云服务提供商只需提供托管云服务以及与Service Hub整合的操作接口，以完成服务实例创建、授权访问等管理功能。
完成订阅后，用户可以在Service Portal页面中管理已经创建的服务实例，并且取得服务的访问方式等信息。

Service Hub与其他组件的关系如下图所示：  
![servicehub03](images/servicehub03.PNG)

## API概览

欢迎使用WISE-PaaS云平台Service Hub服务，用户将欲上架的云服务与ServiceHub整合后，ServiceHub将调用本章节说明的API完成服务实例的创建、升级、降级、恢复和退订等操作。

### Service Hub接口

| Method | API                                                          | 描述           |
| ------ | ------------------------------------------------------------ | -------------- |
| POST   | [/v2/serviceInstances](#post---v2serviceinstances)           | 订阅服务       |
| PUT    | [/v2/serviceInstances](#put---v2serviceinstances)            | 升级或降级服务 |
| POST   | [/v2/serviceInstances/redeploy](#post---v2serviceinstancesredeploy) | 重新订阅服务   |
| DELETE | [/v2/serviceInstances/{serviceInstanceId}](#delete---v2serviceinstancesserviceinstanceid) | 退订服务       |
## Service Hub接口

### POST   /v2/serviceInstances

用户通过云服务市场订阅云服务后，ServiceHub将调用本接口，通知服务商后台创建服务实例。若云服务整合了SSO API，则在服务实例创建后，即可自动完成对订阅者的授权。若云服务整合了License API，则在服务实例创建、升级和降级后，即可自动完成服务授权。 

#### 请求参数

| 名称                        | 类型    | 是否必选 | 示例值                               | 描述                             |
| --------------------------- | ------- | -------- | ------------------------------------ | -------------------------------- |
| uuid                        | String  | 是       | 8f6f3337-7ac1-486f-b22b-d3f66fdd8fc1 | 唯一值                           |
| cartId                      | String  | 是       | 71d493fc-7441-41a6-81c5-2bed867eb447 | 购物车编号                       |
| transactionId               | String  | 是       | e62bc861-f137-4039-bc6b-beaf85907f2f | 交易编号                         |
| subscriptionId              | String  | 是       | b6e4d37f-8c81-4308-9f9e-565fe225cd80 | 订阅号                           |
| userId                      | String  | 是       | b8a821c6-dc63-4fa3-b491-e4fa2c2b59ab | 使用者ID                         |
| datacenterCode              | String  | 是       | sa                                   | 站点名称                         |
| servicePackageName          | String  | 否       | WISE.M+                              | 整合包类型                       |
| servicePackagePlanName      | String  | 否       | Lite                                 | 整合包料号信息                   |
| servicePackagePnInfo        | Object  | 否       | 如下补充                             | 整合包料号信息                   |
| servicePackageId            | String  | 否       | 936fe63b-67a6-4fe4-9a2a-f091cb88fb0e | 整合包ID                         |
| servicePackageOrderId       | String  | 否       | 89bf4cd3-2427-415c-be81-88105a410be0 | 整合包订单ID                     |
| clusterName                 | String  | 否       | eks001                               | 云平台集群名称                   |
| workspaceId                 | String  | 否       | e6edad1d-905d-48ef-b466-877bfe6d9eed | 工作空间ID                       |
| workspaceName               | String  | 否       | workspaceName                        | 工作空间名称                     |
| namespaceName               | String  | 否       | namespaceName                        | 部署服务空间名称                 |
| deliverType                 | string  | 否       | pipeline                             | 部署类型                         |
| memberType                  | string  | 否       | VIP                                  | 用户类型                         |
| totalPriceByListing         | Integer | 否       | 2                                    | 按照挂牌价格计算的价格           |
| totalPriceByMemberType      | Integer | 否       | 1.66                                 | 按照用户类型计算的价格           |
| proratedPriceByMemberType   | Integer | 否       | 0.66                                 | 按照用户类型及可用日期计算的价格 |
| isFinished                  | Boolean | 否       | False                                | 是否购买完成                     |
| serviceInfo                 | Object  | 否       | 如下补充                             | 服务信息                         |

serviceInfo：

| 名称                 | 类型   | 是否必选 | 示例值                               | 描述                         |
| -------------------- | ------ | -------- | ------------------------------------ | ---------------------------- |
| deliverType          | String | 否       | servicebuy                           | 部署类型                     |
| orderId              | String | 否       | 5db0226d-0f13-43ba-ad42-441ab99a17c3 | 订单编号                     |
| serviceIntanceId     | String | 是       | 5c23b8db-d20f-4ecc-9729-9c63e8d3d949 | 服务实例ID                   |
| serviceInstanceName  | String | 否       | PostgreSQL                           | 服务实例名称                 |
| serviceInstanceQuota | Object | 否       | 如下补充                             | 计量服务所使用的信息         |
| serviceName          | String | 是       | PostgreSQL                           | 服务名称                     |
| serviceCategory      | String | 否       | EnSaaS                               | 服务种类                     |
| servicePlanName      | String | 否       | Shared                               | 购买的服务类别               |
| serviceProperty      | String | 否       | Basic                                | 服务属性                     |
| serviceParameters    | Object | 否       | 額外參數，不限定                     | 额外需要带给服务提供商的参数 |
| pnInfo               | Object | 否       | 如下补充                             | 服务料号信息                 |

serviceInstanceQuota：

| 名称         | 类型    | 是否必选 | 示例值 | 描述             |
| ------------ | ------- | -------- | ------ | ---------------- |
| Disk(GB)     | Integer | 否       | 10     | 计量时使用的信息 |
| Operation/5m | Integer | 否       | 1000   | 计量时使用的信息 |

servicePackagePnInfo /pnInfo：

| 名称                        | 类型    | 是否必选 | 示例值              | 描述                             |
| --------------------------- | ------- | -------- | ------------------- | -------------------------------- |
| pn                          | String  | 是       | 9880GEDPA000        | 料号名称                         |
| pnQuantity                  | Integer | 是       | 1                   | 料号数量                         |
| pnProperty                  | String  | 否       | Basic               | 料号属性                         |
| pnPriceByListing            | Integer | 否       | 2                   | 料号挂牌价格                     |
| pnPriceByMemberType         | Integer | 否       | 1.8                 | 按照 用户类型计算的价格          |
| pnProratedPriceByMemberType | Integer | 否       | 0.66                | 按照用户类型和可用日期计算的价格 |
| isTrialAccount              | Boolean | 否       | true                | 是否是使用用户                   |
| availableDays               | Integer | 否       | 11                  | 剩余可用天数                     |
| chargeType                  | String  | 否       | Monthly             | 收费类型（月付）                 |
| memberType                  | String  | 否       | VIP                 | 客户类型                         |
| createdTime                 | String  | 否       | 2020-04-20T09:23:19 | 建立时间                         |
| effectiveTime               | String  | 否       | 2020-04-30T23:59:59 | 有效时间                         |

#### 返回数据

| 名称              | 类型   | 示例值                                                       | 描述        |
| ----------------- | ------ | ------------------------------------------------------------ | ----------- |
| dashboardUrl      | string | https://portal-afs-ews001.hz.wise-paas.com.cn/v2/ad244f6c-cf5b-41a5-a63b-d5e70f805c26 | 订阅实例Url |
| serviceInstanceId | string | 5c23b8db-d20f-4ecc-9729-9c63e8d3d949                         | 服务实例ID  |
| serviceName       | string | PostgreSQL                                                   | 服务名称    |

#### 示例

参见各个站点的swagger：

https://api-service-ensaas.sa.wise-paas.com/public/apidoc

https://api-service-ensaas.hz.wise-paas.com/public/apidoc

https://api-service-ensaas.jp.wise-paas.com/public/apidoc

### PUT   /v2/serviceInstances

用户升级或降级云服务后，ServiceHub将调用本接口，通知服务商后台升级或降级服务实例规格。

#### 请求参数

| 名称                      | 类型    | 是否必选 | 示例值                               | 描述                             |
| ------------------------- | ------- | -------- | ------------------------------------ | -------------------------------- |
| uuid                      | String  | 是       | 8f6f3337-7ac1-486f-b22b-d3f66fdd8fc1 | 唯一值                           |
| cartId                    | String  | 是       | 71d493fc-7441-41a6-81c5-2bed867eb447 | 购物车编号                       |
| transactionId             | String  | 是       | e62bc861-f137-4039-bc6b-beaf85907f2f | 交易编号                         |
| subscriptionId            | String  | 是       | b6e4d37f-8c81-4308-9f9e-565fe225cd80 | 订阅号                           |
| userId                    | String  | 是       | b8a821c6-dc63-4fa3-b491-e4fa2c2b59ab | 使用者ID                         |
| datacenterCode            | String  | 是       | sa                                   | 站点名称                         |
| servicePackageName        | String  | 否       | WISE.M+                              | 整合包类型                       |
| servicePackagePlanName    | String  | 否       | Lite                                 | 整合包料号信息                   |
| servicePackagePnInfo      | Object  | 否       | 如下补充                             | 整合包料号信息                   |
| servicePackageId          | String  | 否       | 936fe63b-67a6-4fe4-9a2a-f091cb88fb0e | 整合包ID                         |
| servicePackageOrderId     | String  | 否       | 89bf4cd3-2427-415c-be81-88105a410be0 | 整合包订单ID                     |
| clusterName               | String  | 否       | eks001                               | 云平台集群名称                   |
| workspaceId               | String  | 否       | e6edad1d-905d-48ef-b466-877bfe6d9eed | 工作空间ID                       |
| workspaceName             | String  | 否       | workspaceName                        | 工作空间名称                     |
| namespaceName             | String  | 否       | namespaceName                        | 部署服务空间名称                 |
| deliverType               | string  | 否       | pipeline                             | 部署类型                         |
| memberType                | string  | 否       | VIP                                  | 用户类型                         |
| totalPriceByListing       | Integer | 否       | 2                                    | 按照挂牌价格计算的价格           |
| totalPriceByMemberType    | Integer | 否       | 1.66                                 | 按照用户类型计算的价格           |
| proratedPriceByMemberType | Integer | 否       | 0.66                                 | 按照用户类型及可用日期计算的价格 |
| isFinished                | Boolean | 否       | False                                | 是否购买完成                     |
| serviceInfo               | Object  | 否       | 如下补充                             | 服务信息                         |

serviceInfo：

| 名称                 | 类型   | 是否必选 | 示例值                               | 描述                         |
| -------------------- | ------ | -------- | ------------------------------------ | ---------------------------- |
| deliverType          | String | 否       | servicebuy                           | 部署类型                     |
| orderId              | String | 否       | 5db0226d-0f13-43ba-ad42-441ab99a17c3 | 订单编号                     |
| serviceIntanceId     | String | 是       | 5c23b8db-d20f-4ecc-9729-9c63e8d3d949 | 服务实例ID                   |
| serviceInstanceName  | String | 否       | PostgreSQL                           | 服务实例名称                 |
| serviceInstanceQuota | Object | 否       | 如下补充                             | 计量服务所使用的信息         |
| serviceName          | String | 是       | PostgreSQL                           | 服务名称                     |
| serviceCategory      | String | 否       | EnSaaS                               | 服务种类                     |
| servicePlanName      | String | 否       | Shared                               | 购买的服务类别               |
| serviceProperty      | String | 否       | Basic                                | 服务属性                     |
| serviceParameters    | Object | 否       | 額外參數，不限定                     | 额外需要带给服务提供商的参数 |
| pnInfo               | Object | 否       | 如下补充                             | 服务料号信息                 |

serviceInstanceQuota：

| 名称         | 类型    | 是否必选 | 示例值 | 描述             |
| ------------ | ------- | -------- | ------ | ---------------- |
| Disk(GB)     | Integer | 否       | 10     | 计量时使用的信息 |
| Operation/5m | Integer | 否       | 1000   | 计量时使用的信息 |

servicePackagePnInfo /pnInfo：

| 名称                        | 类型    | 是否必选 | 示例值              | 描述                             |
| --------------------------- | ------- | -------- | ------------------- | -------------------------------- |
| pn                          | String  | 是       | 9880GEDPA000        | 料号名称                         |
| pnQuantity                  | Integer | 是       | 1                   | 料号数量                         |
| pnProperty                  | String  | 否       | Basic               | 料号属性                         |
| pnPriceByListing            | Integer | 否       | 2                   | 料号挂牌价格                     |
| pnPriceByMemberType         | Integer | 否       | 1.8                 | 按照 用户类型计算的价格          |
| pnProratedPriceByMemberType | Integer | 否       | 0.66                | 按照用户类型和可用日期计算的价格 |
| isTrialAccount              | Boolean | 否       | true                | 是否是使用用户                   |
| availableDays               | Integer | 否       | 11                  | 剩余可用天数                     |
| chargeType                  | String  | 否       | Monthly             | 收费类型（月付）                 |
| memberType                  | String  | 否       | VIP                 | 客户类型                         |
| createdTime                 | String  | 否       | 2020-04-20T09:23:19 | 建立时间                         |
| effectiveTime               | String  | 否       | 2020-04-30T23:59:59 | 有效时间                         |

#### 返回数据

| 名称              | 类型   | 示例值                                                       | 描述        |
| ----------------- | ------ | ------------------------------------------------------------ | ----------- |
| dashboardUrl      | string | https://portal-afs-ews001.hz.wise-paas.com.cn/v2/ad244f6c-cf5b-41a5-a63b-d5e70f805c26 | 订阅实例Url |
| serviceInstanceId | string | 5c23b8db-d20f-4ecc-9729-9c63e8d3d949                         | 服务实例ID  |
| serviceName       | string | PostgreSQL                                                   | 服务名称    |

#### 示例

参见各个站点的swagger：

https://api-service-ensaas.sa.wise-paas.com/public/apidoc

https://api-service-ensaas.hz.wise-paas.com/public/apidoc

https://api-service-ensaas.jp.wise-paas.com/public/apidoc


### POST   /v2/serviceInstances/redeploy

用户退订云服务实例后，在规定的有效期内完成续订，ServiceHub将调用本接口，通知服务商后台恢复服务实例。

#### 请求参数

| 名称                      | 类型    | 是否必选 | 示例值                               | 描述                             |
| ------------------------- | ------- | -------- | ------------------------------------ | -------------------------------- |
| uuid                      | String  | 是       | 8f6f3337-7ac1-486f-b22b-d3f66fdd8fc1 | 唯一值                           |
| cartId                    | String  | 是       | 71d493fc-7441-41a6-81c5-2bed867eb447 | 购物车编号                       |
| transactionId             | String  | 是       | e62bc861-f137-4039-bc6b-beaf85907f2f | 交易编号                         |
| subscriptionId            | String  | 是       | b6e4d37f-8c81-4308-9f9e-565fe225cd80 | 订阅号                           |
| userId                    | String  | 是       | b8a821c6-dc63-4fa3-b491-e4fa2c2b59ab | 使用者ID                         |
| datacenterCode            | String  | 是       | sa                                   | 站点名称                         |
| servicePackageName        | String  | 否       | WISE.M+                              | 整合包类型                       |
| servicePackagePlanName    | String  | 否       | Lite                                 | 整合包料号信息                   |
| servicePackagePnInfo      | Object  | 否       | 如下补充                             | 整合包料号信息                   |
| servicePackageId          | String  | 否       | 936fe63b-67a6-4fe4-9a2a-f091cb88fb0e | 整合包ID                         |
| servicePackageOrderId     | String  | 否       | 89bf4cd3-2427-415c-be81-88105a410be0 | 整合包订单ID                     |
| clusterName               | String  | 否       | eks001                               | 云平台集群名称                   |
| workspaceId               | String  | 否       | e6edad1d-905d-48ef-b466-877bfe6d9eed | 工作空间ID                       |
| workspaceName             | String  | 否       | workspaceName                        | 工作空间名称                     |
| namespaceName             | String  | 否       | namespaceName                        | 部署服务空间名称                 |
| deliverType               | string  | 否       | pipeline                             | 部署类型                         |
| memberType                | string  | 否       | VIP                                  | 用户类型                         |
| totalPriceByListing       | Integer | 否       | 2                                    | 按照挂牌价格计算的价格           |
| totalPriceByMemberType    | Integer | 否       | 1.66                                 | 按照用户类型计算的价格           |
| proratedPriceByMemberType | Integer | 否       | 0.66                                 | 按照用户类型及可用日期计算的价格 |
| isFinished                | Boolean | 否       | False                                | 是否购买完成                     |
| serviceInfo               | Object  | 否       | 如下补充                             | 服务信息                         |

serviceInfo：

| 名称                 | 类型   | 是否必选 | 示例值                               | 描述                         |
| -------------------- | ------ | -------- | ------------------------------------ | ---------------------------- |
| deliverType          | String | 否       | servicebuy                           | 部署类型                     |
| orderId              | String | 否       | 5db0226d-0f13-43ba-ad42-441ab99a17c3 | 订单编号                     |
| serviceIntanceId     | String | 是       | 5c23b8db-d20f-4ecc-9729-9c63e8d3d949 | 服务实例ID                   |
| serviceInstanceName  | String | 否       | PostgreSQL                           | 服务实例名称                 |
| serviceInstanceQuota | Object | 否       | 如下补充                             | 计量服务所使用的信息         |
| serviceName          | String | 是       | PostgreSQL                           | 服务名称                     |
| serviceCategory      | String | 否       | EnSaaS                               | 服务种类                     |
| servicePlanName      | String | 否       | Shared                               | 购买的服务类别               |
| serviceProperty      | String | 否       | Basic                                | 服务属性                     |
| serviceParameters    | Object | 否       | 額外參數，不限定                     | 额外需要带给服务提供商的参数 |
| pnInfo               | Object | 否       | 如下补充                             | 服务料号信息                 |

serviceInstanceQuota：

| 名称         | 类型    | 是否必选 | 示例值 | 描述             |
| ------------ | ------- | -------- | ------ | ---------------- |
| Disk(GB)     | Integer | 否       | 10     | 计量时使用的信息 |
| Operation/5m | Integer | 否       | 1000   | 计量时使用的信息 |

servicePackagePnInfo /pnInfo：

| 名称                        | 类型    | 是否必选 | 示例值              | 描述                             |
| --------------------------- | ------- | -------- | ------------------- | -------------------------------- |
| pn                          | String  | 是       | 9880GEDPA000        | 料号名称                         |
| pnQuantity                  | Integer | 是       | 1                   | 料号数量                         |
| pnProperty                  | String  | 否       | Basic               | 料号属性                         |
| pnPriceByListing            | Integer | 否       | 2                   | 料号挂牌价格                     |
| pnPriceByMemberType         | Integer | 否       | 1.8                 | 按照 用户类型计算的价格          |
| pnProratedPriceByMemberType | Integer | 否       | 0.66                | 按照用户类型和可用日期计算的价格 |
| isTrialAccount              | Boolean | 否       | true                | 是否是使用用户                   |
| availableDays               | Integer | 否       | 11                  | 剩余可用天数                     |
| chargeType                  | String  | 否       | Monthly             | 收费类型（月付）                 |
| memberType                  | String  | 否       | VIP                 | 客户类型                         |
| createdTime                 | String  | 否       | 2020-04-20T09:23:19 | 建立时间                         |
| effectiveTime               | String  | 否       | 2020-04-30T23:59:59 | 有效时间                         |

#### 返回数据

| 名称              | 类型   | 示例值                                                       | 描述        |
| ----------------- | ------ | ------------------------------------------------------------ | ----------- |
| dashboardUrl      | string | https://portal-afs-ews001.hz.wise-paas.com.cn/v2/ad244f6c-cf5b-41a5-a63b-d5e70f805c26 | 订阅实例Url |
| serviceInstanceId | string | 5c23b8db-d20f-4ecc-9729-9c63e8d3d949                         | 服务实例ID  |

#### 示例

参见各个站点的swagger：

https://api-service-ensaas.sa.wise-paas.com/public/apidoc

https://api-service-ensaas.hz.wise-paas.com/public/apidoc

https://api-service-ensaas.jp.wise-paas.com/public/apidoc


### DELETE   /v2/serviceInstances/{serviceInstanceId}

用户退订云服务实例后，ServiceHub将调用本接口，通知服务商后台释放服务实例。如果云服务提供商在SLA中承诺了用户退订后服务实例的保留时间，若用户在规定效期内完成服务实例续订，则服务商后台应能恢复此服务实例。

#### 请求参数

| 名称              | 类型    | 是否必选 | 示例值                               | 描述                     |
| ----------------- | ------- | -------- | ------------------------------------ | ------------------------ |
| serviceInstanceId | string  | 是       | 7737d81e-6ab5-4798-a0a1-07e328d10122 | 服务实例Id               |
| cascade           | boolean | 否       | trues                                | 是否删除service_bindings |
| deleteData        | boolean | 否       | false                                | 是否删除数据             |

#### 返回数据

`204  No Content`
