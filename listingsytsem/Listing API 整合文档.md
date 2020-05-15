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
## Listing service  `POST  /service`

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
## Listing servicePackage
