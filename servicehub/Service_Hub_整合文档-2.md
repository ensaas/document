# Servcie Hub 整合文档

## Service Hub介绍  

EnSaaS平台提供一套服务订阅及管理机制（Service Hub），让服务提供者可以上架托管服务，供其他用户或是应用程序集成。托管服务与Service Hub整合之后，即可让用户通过EnSaaS平台的MaketPlace或者Catalog完成服务的订阅，升级，降级，重新订阅及退订。

服务上架需要由服务提供商提供Service Broker，Service Broker主要负责服务自动化管理，包含服务创建等管理功能。用户订阅服务时，由Service Hub协助串接商务流程，包含订单系统及计费系统。

用户可以在Service Portal页面中管理已经创建的服务实例，并且取得服务连线信息。

Service Hub与其他组件的关系如下图所示，服务提供商需要提供Service Broker：  

![](images/servicehub02.PNG)

## 整合流程
1. [开发Service Broker](#service-broker接口)
2. [部署Service Broker](#部署service-broker)
3. [在Service Hub注册Service Broker](#将service-broker注册到service-hub中)
4. [调用ServiceHub API完成服务的订阅、升级、降级、重新订阅、退订](#service-hub接口-1)
5. [在Service Portal进行Service Secret的管理](#service-portal)

## API概览

欢迎使用研华EnSaaS平台Service Hub服务，用户可以使用本文档介绍的 API 完成Service Broker的开发，并对上架的托管服务进行订阅、升级、降级、重新订阅、退订的操作。

### Service Broker接口

Service Broker 是由很简易的几支Rest API组成，它的角色类似为服务提供与资源池的中介者，Service Broker 一方面向服务使用者提供资源调用的方法，让用户透过订阅/绑定/解绑/退订等API操作资源池，而另一方面就是后端实现了实际管理与操作，不限定任何语言开发，完成以下几支必须的API就可以去Service Hub注册。

| Method | API                                                          | 描述                 |
| ------ | ------------------------------------------------------------ | -------------------- |
| GET    | [/v2/catalog](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md#catalog-management) | 填写注册用的服务信息 |
| PUT    | [/v2/service_instances/{instances_id}](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md#provisioning) | 订阅服务             |
| DELETE | [/v2/service_instances/{instances_id}](/https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md#request-9}) | 删除服务             |
| PUT    | [/v2/service_instances/{instances_id}/service_bindings/{binding_id}](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md#request-6) | 建立绑定             |
| DELETE | [/v2/service_instances/{instances_id}/service_bindings/{binding_id}](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md#request-8) | 删除绑定             |

### Service Hub接口

将Service Broker在Service Hub注册之后，用户就可以调用以下API对上架的托管服务进行订阅、升级、降级、重新订阅、退订的操作。

| Method | API                                                          | 描述           |
| ------ | ------------------------------------------------------------ | -------------- |
| POST   | [/v2/serviceInstances](#post---v2serviceinstances)           | 订阅服务       |
| PUT    | [/v2/serviceInstances](#put---v2serviceinstances)            | 升级或降级服务 |
| POST   | [/v2/serviceInstances/redeploy](#post---v2serviceinstancesredeploy) | 重新订阅服务   |
| DELETE | [/v2/serviceInstances/{serviceInstanceId}](#delete---v2serviceinstancesserviceinstanceid) | 退订服务       |

## Service Broker接口

Service Broker的规格是全球共通的，详细的Service Broker设计请参考官方最新的[设计规格](https://github.com/openservicebrokerapi/servicebroker)，API接口实现请参考[API文档](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md)。

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

| 名称              | 类型    | 是否必选 | 示例值                               | 描述                     |
| ----------------- | ------- | -------- | ------------------------------------ | ------------------------ |
| serviceInstanceId | string  | 是       | 7737d81e-6ab5-4798-a0a1-07e328d10122 | 服务实例Id               |
| cascade           | boolean | 否       | trues                                | 是否删除service_bindings |
| deleteData        | boolean | 否       | false                                | 是否删除数据             |

#### 返回数据

`204  No Content`

## 部署Service Broker

完成后的 Service Broker 是一支可执行的程序，可以将它部署到EnSaaS平台空间中运行，也可以放置在网络可以连接到的任意位置，部署好后，只需要和 Service Hub 完成注册的动作即可。

## 将Service Broker注册到Service Hub中

在Service Hub注册之前，需要先去Listing System上架。完成上架之后，提供brokerUrl参数给Service Hub管理员，管理员会帮忙完成注册的动作。注册成功后，客户便可以在EnSaaS平台的MarketPlace或者CataLog购买服务，并在Service Portal上对服务进行管理。

| 参数名称  | 描述                                                         |
| --------- | ------------------------------------------------------------ |
| brokerUrl | 完整带验证的 Service Broker 连线信息，其內容为：https://\<username\>:\<password\>@\<endpoint\>，以 MongoDB SB 为例：https://user:password@mongodb-sb.wise-paas.com |

 

## Service Portal

服务订阅后，可以登录Service Portal进行Service Secret的管理，即建立绑定，生成服务的连接信息，提供给APP使用，详细请参考Service Portal使用手册。

![](images/ServicePortal01.PNG)
