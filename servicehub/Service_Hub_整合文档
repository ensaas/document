# Servcie Hub 整合文档

## Service Hub介绍  

EnSaaS平台提供一套服务订阅及管理机制（Service Hub），让服务提供者可以上架托管服务，供其他用户或是应用程序集成。托管服务与Service Hub整合之后，即可让用户通过EnSaaS平台的MaketPlace或者Catalog完成服务的订阅，升级，降级，重新订阅及退订。
![](images/ServiceHub02.PNG)

## 整合流程
4. [调用ServiceHub API完成服务的订阅、升级、降级、重新订阅、退订](###Service Hub接口)
5. [在Service Portal进行Service Secret的管理](##Service Portal)

## API概览

欢迎使用研华EnSaaS平台Service Hub服务，用户将欲上架EnSaaS平台的服务与ServiceHub整合后，即可以使用本文档介绍的 API 对上架的托管服务进行订阅、升级、降级、重新订阅、退订的操作。

### Service Hub接口

| Method | API                                      | 描述           |
| ------ | ---------------------------------------- | -------------- |
| POST   | /v2/serviceInstances                     | 订阅服务       |
| PUT    | /v2/serviceInstances                     | 升级或降级服务 |
| POST   | /v2/serviceInstances/redeploy            | 重新订阅服务   |
| DELETE | /v2/serviceInstances/{serviceInstanceId} | 退订服务       |

---
## Service Hub接口

### POST   /v2/serviceInstances

订阅服务。

#### 请求参数

```
{
  "uuid": "string",
  "cartId": "string",
  "transactionId": "string",
  "subscriptionId": "string",
  "userId": "string",
  "datacenterCode": "string",
  "servicePackageName": null,
  "servicePackagePlanName": null,
  "servicePackagePnInfo": null,
  "servicePackageId": null,
  "servicePackageOrderId": null,
  "clusterName": null,
  "workspaceId": null,
  "workspaceName": null,
  "namespaceName": null,
  "deliverType": "string",
  "memberType": "string",
  "totalPriceByListing": 0,
  "totalPriceByMemberType": 0,
  "proratedPriceByMemberType": 0,
  "isFinished": true,
  "serviceInfo": [
    {
      "pnInfo": [
        {
          "pn": "string",
          "pnQuantity": 1,
          "pnProperty": "string",
          "pnPriceByListing": 0,
          "pnPriceByMemberType": 0,
          "pnProratedPriceByMemberType": 0,
          "isTrialAccount": true,
          "availableDays": 18,
          "chargeType": "string",
          "memberType": "string",
          "createdTime": "2020-04-13T11:46:57.846771037+08:00",
          "effectiveTime": "2020-04-30T23:59:59.999999999+08:00"
        }
      ],
      "deliverType": "string",
      "orderId": "string",
      "serviceIntanceId": "string",
      "serviceInstanceName": "string",
      "serviceInstanceQuota": {},
      "serviceName": "string",
      "serviceCategory": "string",
      "servicePlanName": "string",
      "serviceProperty": "string",
      "serviceParameters": {}
    }
  ]
}
```
#### 返回数据
```
[
  {
    "dashboardUrl": "string",
    "serviceInstanceId": "string",
    "serviceName": "string"
  }
]
```

### PUT   /v2/serviceInstances

升级或降级服务。

#### 请求参数

```
{
  "uuid": "string",
  "cartId": "string",
  "transactionId": "string",
  "subscriptionId": "string",
  "userId": "string",
  "datacenterCode": "string",
  "servicePackageName": null,
  "servicePackagePlanName": null,
  "servicePackagePnInfo": null,
  "servicePackageId": null,
  "servicePackageOrderId": null,
  "clusterName": null,
  "workspaceId": null,
  "workspaceName": null,
  "namespaceName": null,
  "deliverType": "string",
  "memberType": "string",
  "totalPriceByListing": 0,
  "totalPriceByMemberType": 0,
  "proratedPriceByMemberType": 0,
  "isFinished": true,
  "serviceInfo": [
    {
      "pnInfo": [
        {
          "pn": "string",
          "pnQuantity": 1,
          "pnProperty": "string",
          "pnPriceByListing": 0,
          "pnPriceByMemberType": 0,
          "pnProratedPriceByMemberType": 0,
          "isTrialAccount": true,
          "availableDays": 18,
          "chargeType": "string",
          "memberType": "string",
          "createdTime": "2020-04-13T11:46:57.846771037+08:00",
          "effectiveTime": "2020-04-30T23:59:59.999999999+08:00"
        }
      ],
      "deliverType": "string",
      "orderId": "string",
      "serviceIntanceId": "string",
      "serviceInstanceName": "string",
      "serviceInstanceQuota": {},
      "serviceName": "string",
      "serviceCategory": "string",
      "servicePlanName": "string",
      "serviceProperty": "string",
      "serviceParameters": {}
    }
  ]
}
```

#### 返回数据

```
[
  {
    "dashboardUrl": "string",
    "serviceInstanceId": "string",
    "serviceName": "string"
  }
]
```

### POST   /v2/serviceInstances/redeploy

重新订阅服务。

#### 请求参数

```
{
  "uuid": "string",
  "cartId": "string",
  "transactionId": "string",
  "subscriptionId": "string",
  "userId": "string",
  "datacenterCode": "string",
  "servicePackageName": null,
  "servicePackagePlanName": null,
  "servicePackagePnInfo": null,
  "servicePackageId": null,
  "servicePackageOrderId": null,
  "clusterName": null,
  "workspaceId": null,
  "workspaceName": null,
  "namespaceName": null,
  "deliverType": "string",
  "memberType": "string",
  "totalPriceByListing": 0,
  "totalPriceByMemberType": 0,
  "proratedPriceByMemberType": 0,
  "isFinished": true,
  "serviceInfo": [
    {
      "pnInfo": [
        {
          "pn": "string",
          "pnQuantity": 1,
          "pnProperty": "string",
          "pnPriceByListing": 0,
          "pnPriceByMemberType": 0,
          "pnProratedPriceByMemberType": 0,
          "isTrialAccount": true,
          "availableDays": 18,
          "chargeType": "string",
          "memberType": "string",
          "createdTime": "2020-04-13T11:46:57.846771037+08:00",
          "effectiveTime": "2020-04-30T23:59:59.999999999+08:00"
        }
      ],
      "deliverType": "string",
      "orderId": "string",
      "serviceIntanceId": "string",
      "serviceInstanceName": "string",
      "serviceInstanceQuota": {},
      "serviceName": "string",
      "serviceCategory": "string",
      "servicePlanName": "string",
      "serviceProperty": "string",
      "serviceParameters": {}
    }
  ]
}
```

#### 返回数据

```
{
  "dashboardUrl": "string",
  "serviceInstanceId": "string"
}
```

### DELETE   /v2/serviceInstances/{serviceInstanceId}

退订服务。

#### 请求参数

| 名称              | 类型    | 是否必选 | 示例值 | 描述                     |
| ----------------- | ------- | -------- | ------ | ------------------------ |
| serviceInstanceId | string  | 是       |        | 服务实例Id               |
| cascade           | boolean | 否       | trues  | 是否删除service_bindings |
| deleteData        | boolean | 否       | false  | 是否删除数据             |

#### 返回数据

`204  No Content`

## Service Portal

服务订阅后，可以登录Service Portal进行Service Secret的管理，即建立绑定，生成服务的连接信息，提供给APP使用，详细请参考Service Portal使用手册。

![](images/ServicePortal01.PNG)
