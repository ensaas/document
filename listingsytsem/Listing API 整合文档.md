# Listing API DOC

## Introduction
Listing 是为服务上架到 EnSaaS 4.0 Catalog 和 advantech marketplace 提供上架的方案和 api.

## Listing 流程图  

- [x] service
- [x] servicePackage


```bash
  ___________________________________________________________________________________________________
  |      Service        |      ServicePlan        |       PN         |    Datacenter  |     Price   |
  |                     |                         |                  |                |             | 
  |                     |                         |                  |                |             |
  |                     |                         |               /~~~~~>    SA    ~~~~~>   price   |
  |                     |                         |    --------  /   |                |             |
  |                     |  _________________   /~~~~~~>| PN A | /  ~~~~~>    HZ    ~~~~~>   price   |
  |                     |  |               |  /   |    -------- \    |                |             | 
  |                /~~~~~~>| servicePlan A | /    |              \ ~~~~~>    JE    ~~~~~>   price   |
  |  -----------  /     |  |               | \    |                  |                |             |
  |  | service | /      |  -----------------  \   |                  |                |             | 
  |  ----------- \      |                      \  |     --------  / ~~~~~>   SA    ~~~~~>   price   | 
  |               \     |                       \~~~~~~>| PN B | /   |                |             |
  |                \    |                         |     -------- \  ~~~~~>   HZ    ~~~~~>   price   | 
  |                 \   |   _________________     |               \  |                |             | 
  |                  \  |   |               |     |                \~~~~~>   JE    ~~~~~>   price   | 
  |                   \~~~~>| servicePlan B |     |                  |                |             |
  |                     |   |               |     |                  |                |             |
  |                     |   -----------------     |                  |                |             | 
  |                     |                         |                  |                |             | 
  ---------------------------------------------------------------------------------------------------
```

## Listing sequence
- service  
[Listing service](#service) ---> [Listing servicePlan](#servicePlan) ---> [Listing pn](#pn)

- servicePackage  
[Listing servicePackage](#servicePackage) ---> [Listing pn](#pn)  

## Listing API 
:point_right: [apidoc swagger](https://api-listingsystem-ensaas.bm.wise-paas.com.cn/apidoc/)  

| Method | URL                                                       | Description            |
| ------ | --------------------------------------------------------- | ---------------------- |
| GET    | [/v1/service](#getservice)                                | 获取上架的服务信息     |
| POST   | [/v1/service](#service)                                   | 上架服务               |
| GET    | [/v1/servicePackage](#getservicePackage)                  | 获取上架的服务包信息   |
| POST   | [/v1/servicePackage](#servicePackage)                     | 上架服务包             |
| GET    | [/v1/pricing](#pricing)                                   | 获取上架的 pn 信息     |
| POST   | [/v1/pricing](#getpricing)                                | 上架 pn                |

### <span id="service">1.1.1 Listing service</span>  
  
```bash
POST /v1/service
```  

HTTP Request:  

```json
{
  "serviceName": "string",
  "serviceCategory": "string",
  "buyType": "string",
  "uiId": 0,
  "serviceProvider": "string",
  "releaseNote": "string",
  "iconUrl": "string",
  "description": "string",
  "manager": "string",
  "onlineTime": "string"
}
```

HTTP Response:

```json
{
  "data": {
    "id": "e3c7c9fb-7e51-46fd-ba16-7cc1f2f6db41",
    "serviceName": "APM",
    "serviceProvider": "Common Apps",
    "serviceCategory": "EnSaaS",
    "serviceKey": "RbePpjJXdSv9S1C5Ot7PAw==",
    "buyType": "app",
    "uiId": 1,
    "iconUrl": "string",
    "manager": "string",
    "description": "string",
    "onlineTime": "",
    "createdAt": "2020-05-14T13:32:16.2629185+08:00",
    "updatedAt": "2020-05-14T13:32:16.2629185+08:00"
  },
  "error": null,
  "path": "/v1/service",
  "status": 201,
  "timestamp": "2020-05-14T13:32:16+0000"
}
```

### <span id="getservice">1.1.2 Get service</span>  

```bash
GET  /v1/service
```

```json
{
  "timestamp": "string",
  "status": 0,
  "data": [
    {
      "serviceName": "string",
      "serviceCategory": "string",
      "buyType": "string",
      "uiId": 0,
      "serviceProvider": "string",
      "datacenter": {},
      "releaseNote": "string",
      "iconUrl": "string",
      "servicePlan": [
        "string"
      ],
      "serviceInfo": [
        {
          "id": 0,
          "serviceName": "string",
          "description": "string",
          "imgUrlLogo": "string",
          "imgUrlArchitecture": "string",
          "architectureInfo": "string",
          "serviceDetail": {},
          "serviceProvider": "string"
        }
      ],
      "description": "string",
      "manager": "string",
      "onlineTime": "string"
    }
  ],
  "error": "string",
  "path": "string",
  "totalCount": 0
}
```
### <span id="servicePackage">1.2.1 Listing servicePackage</span>  

```bash
POST  /v1/servicePackage
```  
HTTP Request:

```json
{
  "servicePackage": "string",
  "serviceCategory": "string",
  "serviceProvider": "string",
  "uiId": 0,
  "deliveryType": "string",
  "datacenterCode": "string",
  "planName": "string",
  "planDescription": "string",
  "planNum": 0,
  "pnInfo": [
    {
      "pn": "string",
      "pnProper
