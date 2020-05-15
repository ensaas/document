# Listing API

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
### 1.1 Listing service  

```bash
POST  /service
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
### 1.2 Listing servicePackage

```bash
POST  /servicePackage
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

### Listing servicePlan
```bash
POST /servicePlan
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
### 3.Listing pn
```bash
POST /pricing
```

Request:

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
