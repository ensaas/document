# Listing API DOC

## Introduction
Listing 是为服务上架到 EnSaaS 4.0 Catalog 和 Marketplace 提供上架的方案和 api.

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
| GET    | [/v1/servicePlan](#getservicePlan)                        | 获取上架的服务包信息   |
| POST   | [/v1/servicePlan](#servicePlan)                           | 上架服务包             |
| GET    | [/v1/pricing](#getpn)                                     | 获取上架的 pn 信息     |
| POST   | [/v1/pricing](#pn)                                        | 上架 pn                |

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
      "pnProperty": "string",
      "pnUnit": {},
      "chargeType": "string",
      "pnQuantity": 0
    }
  ],
  "apps": [
    {
      "serviceName": "string",
      "serviceDescription": "string",
      "serviceCategory": "string",
      "planName": "string",
      "planDescription": "string",
      "deliveryType": "string",
      "pnInfo": [
        {
          "pn": "string",
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ]
    }
  ],
  "databases": [
    {
      "serviceName": "string",
      "serviceDescription": "string",
      "serviceCategory": "string",
      "planName": "string",
      "planDescription": "string",
      "deliveryType": "string",
      "pnInfo": [
        {
          "pn": "string",
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ]
    }
  ],
  "spaces": [
    {
      "serviceName": "string",
      "serviceDescription": "string",
      "serviceCategory": "string",
      "planName": "string",
      "planDescription": "string",
      "deliveryType": "string",
      "pnInfo": [
        {
          "pn": "string",
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ]
    }
  ]
}
```

HTTP Response:

```json
{
  "data": {
      "id":1,
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
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ],
      "apps": [
        {
          "serviceName": "string",
          "serviceDescription": "string",
          "serviceCategory": "string",
          "planName": "string",
          "planDescription": "string",
          "deliveryType": "string",
          "pnInfo": [
            {
              "pn": "string",
              "pnProperty": "string",
              "pnUnit": {},
              "chargeType": "string",
              "pnQuantity": 0
            }
          ]
        }
      ],
      "databases": [
        {
          "serviceName": "string",
          "serviceDescription": "string",
          "serviceCategory": "string",
          "planName": "string",
          "planDescription": "string",
          "deliveryType": "string",
          "pnInfo": [
            {
              "pn": "string",
              "pnProperty": "string",
              "pnUnit": {},
              "chargeType": "string",
              "pnQuantity": 0
            }
          ]
        }
      ],
      "spaces": [
        {
          "serviceName": "string",
          "serviceDescription": "string",
          "serviceCategory": "string",
          "planName": "string",
          "planDescription": "string",
          "deliveryType": "string",
          "pnInfo": [
            {
              "pn": "string",
              "pnProperty": "string",
              "pnUnit": {},
              "chargeType": "string",
              "pnQuantity": 0
            }
          ]
        }
      ]
    }
  },
  "error": null,
  "path": "/v1/servicePlan",
  "status": 201,
  "timestamp": "2020-05-14T13:38:09+0000"
}
```

### <span id="getservicePackage">1.2.2 Get servicePackage</span>  

```bash
GET  /v1/servicePackage
```

```json
{
  "id": 0,
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
      "pnProperty": "string",
      "pnUnit": {},
      "chargeType": "string",
      "pnQuantity": 0
    }
  ],
  "apps": [
    {
      "serviceName": "string",
      "serviceDescription": "string",
      "serviceCategory": "string",
      "planName": "string",
      "planDescription": "string",
      "deliveryType": "string",
      "pnInfo": [
        {
          "pn": "string",
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ]
    }
  ],
  "databases": [
    {
      "serviceName": "string",
      "serviceDescription": "string",
      "serviceCategory": "string",
      "planName": "string",
      "planDescription": "string",
      "deliveryType": "string",
      "pnInfo": [
        {
          "pn": "string",
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ]
    }
  ],
  "spaces": [
    {
      "serviceName": "string",
      "serviceDescription": "string",
      "serviceCategory": "string",
      "planName": "string",
      "planDescription": "string",
      "deliveryType": "string",
      "pnInfo": [
        {
          "pn": "string",
          "pnProperty": "string",
          "pnUnit": {},
          "chargeType": "string",
          "pnQuantity": 0
        }
      ]
    }
  ]
}
```
### <span id="servicePlan">2.1 Listing servicePlan</span>  

```bash
POST /v1/servicePlan
```
HTTP Request:

```json
{
  "planName": "string",
  "planNumber": 0,
  "uiId": 0,
  "deliveryType": "string",
  "pn": "string",
  "datacenterCode": "string",
  "planDescription": "string",
  "serviceName": "string",
  "pnProperty": "string",
  "pnQuantity": "string",
  "pnUnit": {},
  "dependency": {
    "appDependency": {},
    "spaceDependency": {},
    "dbDependency": {}
  }
}
```

HTTP Response:

```json
{
  "data": {
    "id": "419fd20f-d31c-4dd2-8e05-e1aa3e69eee5",
    "planName": "planName",
    "planNumber": 1,
    "datacenterCode": "bm",
    "planDescription": "string",
    "uiId": 1,
    "deliveryType": "app",
    "pn": "9806WPDASH",
    "serviceName": "APM",
    "pnProperty": "Basic",
    "dependency": {
      "appDependency": {},
      "spaceDependency": {},
      "dbDependency": {}
    },
    "pnQuantity": "1-9",
    "onlineTime": ""
  },
  "error": null,
  "path": "/v1/servicePlan",
  "status": 201,
  "timestamp": "2020-05-14T13:38:09+0000"
}
```

### <span id="getservicePlan">2.2 Get servicePlan</span> 

```bash
GET  /v1/servicePlan
```

```json
{
  "timestamp": "string",
  "status": 0,
  "data": [
    {
      "id": "string",
      "planName": "string",
      "planNumber": 0,
      "uiId": 0,
      "deliveryType": "string",
      "pn": "string",
      "datacenterCode": "string",
      "planDescription": "string",
      "serviceName": "string",
      "pnProperty": "string",
      "pnQuantity": "string",
      "pnUnit": {},
      "dependency": {
        "appDependency": {},
        "spaceDependency": {},
        "dbDependency": {}
      }
    }
  ],
  "error": "string",
  "path": "string",
  "totalCount": 0
}
```

### <span id="pn">3.1 Listing pn</span>  

```bash
POST /v1/pricing
```

HTTP Request:

```json
{
  "pn": "string",
  "pdl": "string",
  "datacenterCode": ["sa"],
  "pnUnit": "string",
  "ProductionDescription": "string",
  "chargeType": "string",
  "pnListingPrice": 0,
  "pnRegularPrice": 0,
  "pnVipPrice": 0,
  "pnPVipPrice": 0,
  "pnInternalPrice": 0,
  "pnInternalInsourcingPrice": 0,
  "pnExternalInsourcingPrice": 0
}
```

HTTP Response:

```json
{
  "data": {
    "id": 6,
    "pn": "9806WPDASG",
    "pdl": "CSSI",
    "productionDescription": "string",
    "datacenterCode": [
      "sa"
    ],
    "pnUnit": {
      "Instance": "1"
    },
    "chargeType": "Monthly",
    "pnListingPrice": 1,
    "pnRegularPrice": 2,
    "pnVipPrice": 1,
    "pnPVipPrice": 2,
    "pnInternalPrice": 2,
    "pnInternalInsourcingPrice": 4,
    "pnExternalInsourcingPrice": 3,
    "createdAt": "2020-05-14T13:42:31.7151709+08:00",
    "updatedAt": "2020-05-14T13:42:31.7151709+08:00"
  },
  "error": null,
  "path": "/v1/pricing",
  "status": 201,
  "timestamp": "2020-05-14T13:42:31+0000"
}
```

### <span id="getpn">3.2 Get pn</span> 
```bash
GET  /v1/pricing
```

```json
{
  "timestamp": "string",
  "status": 0,
  "data": [
    {
      "id": 0,
      "pn": "string",
      "pdl": "string",
      "datacenterCode": "string",
      "pnUnit": "string",
      "ProductionDescription": "string",
      "chargeType": "string",
      "pnListingPrice": 0,
      "pnRegularPrice": 0,
      "pnVipPrice": 0,
      "pnPVipPrice": 0,
      "pnInternalPrice": 0,
      "pnInternalInsourcingPrice": 0,
      "pnExternalInsourcingPrice": 0
    }
  ],
  "error": "string",
  "path": "string",
  "totalCount": 0
}
```
