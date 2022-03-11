## 上架整合流程

### 服务上架流程（包含单一服务和集成服务）

```bash
 上架服务 ---> 上架服务方案料号 ---> 上架服务对应的方案 ---> 上架服务方案付费模式 ---> 上架按量付费料号（可选） ---> 上架服务方案部署配置（可选）
```

### 服务上架步骤（包含单一服务和集成服务）

1. 上架服务，调用 [上架服务接口](#上架服务接口) 进行上架
2. 上架服务方案料号，调用 [上架服务料号接口](#上架服务料号接口) 进行上架
3. 上架服务对应的方案，调用 [上架服务方案接口](#上架服务方案接口) 进行上架
4. 上架服务方案付费方式，调用[上架服务方案付费方式接口](#上架服务方案付费方式接口)进行上架
5. 上架按量计费料号和定价，调用[上架按量付费料号接口](#上架按量付费料号接口)进行上架（可选）
6. 上架服务方案部署配置，调用[上架服务方案部署配置接口](#上架服务方案部署配置接口)进行上架（可选）

## Listingsystem 介绍

Listingsystem 是为服务上架到 EnSaaS 4.0 Catalog 和 Marketplace 提供上架的方案和 API.

## Listingsystem 结构关系图

- [x] service
- [x] servicePackage



## <span id="API概览">API 概览</span>  

:point_right: [上架服务接口](#上架服务接口)  

[:point_right: 上架服务料号接口](#上架服务料号接口)  

:point_right: [上架服务方案接口](#上架服务方案接口)  

:point_right: [上架服务方案付费方式接口](#上架服务方案付费方式接口)  

:point_right: [上架按量付费料号接口](#上架按量付费料号接口)  

:point_right: [上架服务方案部署配置接口](#上架服务方案部署配置接口)  

### <span id="上架服务接口">上架服务接口</span> 

| API                       | 描述                                               |
| ------------------------- | -------------------------------------------------- |
| [GetService](#GetService) | 获取上架的服务或服务包 &nbsp; &nbsp; &nbsp; &nbsp; |
| [CreateService](#service) | 上架服务或服务包                                   |

### <span id="上架服务料号接口">上架服务料号接口</span> 

| API                                                          | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [GetPn](#GetPn) &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; | 获取上架的服务料号（包括单一服务料号、服务包对外料号、按量付费料号等） |
| [CreatePn](#CreatePn)                                        | 上架服务料号（包括单一服务料号、服务包对外料号、按量付费料号等） |

### <span id="上架服务方案接口">上架服务方案接口</span> 

| API                                                          | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [GetServicePlan](#DescribeServicePlan) &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; | 获取上架的单一服务方案或服务包方案 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; |
| [CreateServicePlan](#CreateServicePlan)                      | 上架单一服务方案或服务包方案                                 |

### <span id="上架服务方案付费方式接口">上架服务方案付费方式接口</span> 

| API                                                     | 描述                                         |
| ------------------------------------------------------- | -------------------------------------------- |
| [GetServiceSaleStrategy](#GetServiceSaleStrategy)       | 获取上架的单一服务方案或服务包方案的付费方式 |
| [CreateServiceSaleStrategy](#CreateServiceSaleStrategy) | 上架的单一服务方案或服务包方案的付费方式     |

### <span id="上架按量付费料号接口">上架按量付费料号接口</span> 

| API                                         | 描述                   |
| ------------------------------------------- | ---------------------- |
| [GetMetricPricing](#GetMetricPricing)       | 获取上架的按量付费料号 |
| [CreateMetricPricing](#CreateMetricPricing) | 上架按量付费料号       |

### <span id="上架服务方案部署配置接口">上架服务方案部署配置接口</span> 

| API                                   | 描述                                       |
| ------------------------------------- | ------------------------------------------ |
| [GetDeployment](#GetDeployment)       | 获取上架的单一服务方案或服务包方案部署配置 |
| [CreateDeployment](#CreateDeployment) | 上架的单一服务方案或服务包方案部署配置     |

---

## API 详情

:point_right: [Apidoc swagger](https://api-listingsystem-ensaas.bj.wise-paas.cn/apidoc/)  

### <span id="CreateService">CreateService</span> 

#### 请求方式

```bash
POST /v1/service
```

#### 请求参数

| 名称             | 描述                                                         | 示例值               | 类型   | 必要性 |
| ---------------- | ------------------------------------------------------------ | -------------------- | ------ | ------ |
| serviceName      | service的唯一名                                              | Dashboard            | string | 必填   |
| serviceCategory  | service的分类，目前支持EnSaaS、Common Apps、Industrial Apps、EnSaaS MicroService、Consulting Service、WISE-STACK | Common Apps          | string | 必填   |
| activeInfo       | 只有serviceCategory为EnSaaS Microservice的服务需要。若不填，则默认为serviceName:serviceCategory的加密信息 | ""                   | string | 非必填 |
| buyType          | 部署类型，支持app、service、plugin、manual、ensaas           | app                  | string | 必填   |
| uiId             | 页面标识，支持1,2                                            | 1                    | int    | 必填   |
| IsVisible        | true表示在页面显示该服务；false表示下架该服务                | true                 | bool   | 必填   |
| displayName      | UI上显示的服务名称，若为空，UI上默认显示serviceName          | ""                   | string | 非必填 |
| subscriptionName | 拆账给该订阅号名称                                           | ""                   | string | 非必填 |
| subscriptionId   | 拆账给该订阅号id                                             | ""                   | string | 非必填 |
| crmid            | 拆账的订阅号名称对应的crmid                                  | ""                   | string | 非必填 |
| company          | 拆账的crmid对应的company名称                                 | ""                   | string | 非必填 |
| serviceProvider  | 服务提供商                                                   | ensaas               | string | 非必填 |
| releaseNote      | 无效字段                                                     | ""                   | string | 不填   |
| iconUrl          | 无效字段                                                     | ""                   | string | 不填   |
| description      | 服务描述，需完整填写                                         | xxx                  | string | 必填   |
| manager          | 服务管理人员                                                 | {“manager":"lu.jin"} | object | 必填   |
| onlineTime       | 上线时间                                                     | 2021-12-31 00:00:00  | string | 非必填 |

#### 请求参数示例

```json
{
          "serviceName": "Dashboard",
          "displayName": "",
          "serviceCategory": "Common Apps",
          "serviceProvider": "Advantech",
          "isVisible": true,
          "subscriptionName": "",
          "subscriptionId": "",
          "crmid": "",
          "company": "",
          "buyType": "app",
          "uiId": 2,
          "manager": {
            "AE": [
              {
                "name": "fangqiang.xi",
                "Email": "fangqiang.xi@advantech.com.cn"
              }
            ],
            "PM": [
              {
                "name": "tingting.ning",
                "Email": "tingting.ning@advantech.com.cn"
              }
            ],
            "RD": [
              {
                "name": "song.yan",
                "Email": "song.yan@advantech.com.cn"
              }
            ],
            "SRE": [
              {
                "name": "SRE",
                "Email": "WISE-PaaS.SRE@advantech.com"
              }
            ]
          },
          "description": "一款低代码可视化工具，可接入物联网数据和常用的数据库数据，可快速制作各种常用和工业物联网领域专有的报表。",
          "onlineTime": "2020-06-03 00:00:00",
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="GetService">GetService</span> 

#### 请求方式

```bash
GET /v1/service
```

#### 请求参数

| 名称            | 描述               | 示例值                        |        | 必要性 |
| --------------- | ------------------ | ----------------------------- | ------ | ------ |
| serviceName     | service的唯一名    | Dashboard                     | string | 非必填 |
| serviceCategory | service的分类      | Common Apps                   | string | 非必填 |
| datacenterCode  | 站点               | bj                            | string | 必填   |
| lang            | 语言，默认返回英文 | en-us,zh-cn,zh-tw,ko-kr,ja-jp | string | 非必填 |

#### 返回数据示例

```json
{
  "data": [
    {
      "serviceList": [
        {
          "id": "7504116e-5e51-11ec-94a3-3e5661aeea4b",
          "serviceName": "Dashboard",
          "displayName": "",
          "serviceCategory": "Common Apps",
          "serviceProvider": "Advantech",
          "isVisible": true,
          "enterpriseName": "",
          "datacenter": [         
            {
              "datacenterCode": "bj",
              "datacenterName": "EnSaaS 4.0 BeiJing"
            }
          ],                            //服务所在站点
          "buyType": "app",
          "uiId": 2,
          "servicePlan": [
            "Standard-Package",
            "DigitalV-Professional",
            "Professional-Package",
            "DigitalV-Standard",
            "Professional",
            "Standard",
            "Professional-HalfPrice",
            "Standard-HalfPrice",
            "Advanced-Edition",
            "Enhanced",
            "Professional-Shared"
          ],                            //服务所上架的方案
          "manager": {
            "AE": [
              {
                "name": "fangqiang.xi",
                "Email": "fangqiang.xi@advantech.com.cn"
              }
            ],
            "PM": [
              {
                "name": "tingting.ning",
                "Email": "tingting.ning@advantech.com.cn"
              }
            ],
            "RD": [
              {
                "name": "song.yan",
                "Email": "song.yan@advantech.com.cn"
              }
            ],
            "SRE": [
              {
                "name": "SRE",
                "Email": "WISE-PaaS.SRE@advantech.com"
              }
            ]
          },
          "description": "一款低代码可视化工具，可接入物联网数据和常用的数据库数据，可快速制作各种常用和工业物联网领域专有的报表。",
          "onlineTime": "2020-06-03T00:00:00+0000",
          "createdAt": "2020-06-03T18:28:38.34724+08:00",
          "updatedAt": "2022-01-20T16:23:25.39799+08:00"
        }
      ]
    }
  ],
  "error": null,
  "path": "/v1/service?serviceName=Dashboard&datacenterCode=bj",
  "status": 200,
  "timestamp": "2022-02-08T05:16:46+0000",
  "totalCount": 1
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="CreatePn">CreatePn</span> 

#### 请求方式

```bash
POST  /v1/pricing
```

#### 请求参数

| 名称                  | 描述                                 | 示例值            | 类型   | 必要性 |
| --------------------- | ------------------------------------ | ----------------- | ------ | ------ |
| pn                    | 料号                                 | 9806WPDASG        | string | 必填   |
| pdl                   | 产品线                               | CSSI              | string | 必填   |
| datacenterCode        | 站点代码                             | ["bj"]            | array  | 必填   |
| pnUnit                | 料号单位                             | {"Instance": "1"} | object | 必填   |
| ProductionDescription | 产品描述                             | pp for nn         | string | 必填   |
| chargeType            | 付费类型，支持Monthly、PAYG          | Monthly           | string | 必填   |
| level1                | 注册用户价格，支持两位小数，向上圆整 | 22                | number | 必填   |
| level2                | 银牌会员价格，支持两位小数，向上圆整 | 22                | number | 必填   |
| level3                | 金牌会员价格，支持两位小数，向上圆整 | 22                | number | 必填   |
| level4                | 贵宾会员价格，支持两位小数，向上圆整 | 22                | number | 必填   |
| level0                | 内部用户价格                         | 22                | number | 必填   |

#### 请求参数示例

```json
{
      "pn": "980GEDPSM00",
      "pdl": "ENSS",
      "productionDescription": "EnSaaS4.0 Database PostgreSQL Single Mini",
      "datacenterCode": [
        "bj"
      ],
      "pnUnit": {
        "Node": "1",
        "RAM(GB)": "4",
        "Disk(GB)": "30",
        "CPU(Core)": "2",
        "Connection": "400"
      },
      "chargeType": "Monthly",
      "level1": 279,
      "level2": 265.05,
      "level3": 237.15,
      "level4": 237.15,
      "level0": 237.15
      
}
```

**[ :point_up_2: API概览 ](#API概览)**  

### <span id="GetPn">GetPn</span> 

#### 请求方式

```bash
GET  /v1/pricing
```

#### 请求参数

| 名称           | 描述 | 示例值      | 类型   | 必要性 |
| -------------- | ---- | ----------- | ------ | ------ |
| pn             | 料号 | 980GEDPS001 | string | 非必填 |
| datacenterCode | 站点 | bj          | string | 必填   |

#### 返回数据示例

```json
{
  "data": [
    {
      "id": 418,
      "pn": "980GEDPS001",
      "pdl": "ENSS",
      "productionDescription": "EnSaaS4.0 Database PostgreSQL Single Small V2",
      "datacenterCode": [
        "bj"
      ],
      "pnUnit": {
        "Node": "1",
        "RAM(GB)": "8",
        "Disk(GB)": "40",
        "CPU(Core)": "2",
        "Connection": "800"
      },
      "chargeType": "Monthly",
      "level0": 293.25,
      "level1": 345,
      "level2": 327.75,
      "level3": 293.25,
      "level4": 293.25,
      "createdAt": "2022-01-20T13:28:53.179748+08:00",
      "updatedAt": "2022-01-20T13:28:53.179748+08:00"
    }
  ],
  "error": null,
  "path": "/v1/pricing?pn=980GEDPS001&datacenterCode=bj",
  "status": 200,
  "timestamp": "2022-02-08T05:42:15+0000",
  "totalCount": 1
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="CreateServicePlan">CreateServicePlan</span> 

#### 请求方式

```bash
POST  /v1/servicePlan
```

#### 请求参数

| 名称               | 描述                                                         | 示例值   | 类型   | 必要性 |
| ------------------ | ------------------------------------------------------------ | -------- | ------ | ------ |
| planName           | 服务方案名称                                                 | Lite     | string | 必填   |
| planNumber         | 方案排序                                                     | 1        | int    | 必填   |
| planCategory       | 服务方案类别，支持standard（单一服务）、package（集成服务）、intergration（整合类型服务） | package  | object | 必填   |
| planType           | 服务方案类型，支持Service、License                           | Service  | string | 必填   |
| deploymentSolution | 方案属性，支持Cloud（公有云）、Private（私有云）及Custom（定制） | Cloud    | string | 必填   |
| uiId               | 页面标识，默认是0                                            | 0        | int    | 必填   |
| deliveryType       | 订阅方式，支持appbuy、servicebuy、mpbuy、pluginbuy、pipeline、manual | pipeline | string | 必填   |
| isInfrastructure   | 该服务方案是否是硬件基础设施，默认是false。选择true的前提是planType必须为License。 | false    | bool   | 必填   |
| namespace          | 无效字段                                                     |          | string | 非必填 |
| cluster            | 无效字段                                                     |          | string | 非必填 |
| datacenterCode     | 站点                                                         | bj       | string | 必填   |
| planForTrial       | 是否是试用方案，默认是false                                  | false    | bool   | 必填   |
| isVisible          | true表示在页面显示该服务方案；false表示下架该服务方案        | true     | bool   | 必填   |
| hasActiveInfo      | 生成license authcode中是否要加激活信息，默认是false（目前只有EnSaaS MicroService类型服务需要） | false    | bool   | 必填   |
| licenseType        | license类型，当planType为service时，licenseType支持Default、None；当planType为License时，licenseType支持BindingInfra、BindingMac | Default  | string | 必填   |
| description        | 服务方案描述                                                 | xxx      | string | 必填   |
| serviceName        | 服务名称                                                     | APM.M2I  | string | 必填   |
| pnInfo             | 服务方案的料号信息                                           | []       | array  | 必填   |
| dependency         | 单一服务方案依赖的其他服务，planCategory为standard需填写该项 | {}       | object | 非必填 |
| package            | 集成服务方案包含的其他服务，planCategory为package需填写该项  | {}       | object | 非必填 |
| integration        | 整合服务方案包含的其他服务，planCategory为integration需填写该项 | {}       | object | 非必填 |

**pnInfo 参数**

| 名称            | 描述                                                         | 示例值            | 类型   | 必要性 |
| --------------- | ------------------------------------------------------------ | ----------------- | ------ | ------ |
| pn              | 料号                                                         | 980GEDPS001       | string | 必填   |
| pnProperty      | 料号属性，支持Basic、Additional、PYAG。其中Basic属性的料号必须存在 | Basic             | string | 必填   |
| chargeType      | 付费类型，支持Monthly、PAYG                                  | Monthly           | string | 必填   |
| pnQuantity      | 料号数量                                                     | 1或者1-9          | string | 必填   |
| pnUnit          | 料号单位                                                     | {"Instance": "1"} | object | 必填   |
| planDescription | 服务方案描述                                                 | xxx               | string | 必填   |

**dependency 参数**

- apps（依赖的app服务）
- dataservices（依赖的数据库服务）
- spaces（依赖的EnSaaS K8s Service服务）
- infrastructures（依赖的基础设施，只有当isInfrastructure=false&planType=License&licenseType=BindingInfra时需要填写）

| 名称            | 描述                                                         | 示例值      | 类型   | 必要性 |
| --------------- | ------------------------------------------------------------ | ----------- | ------ | ------ |
| serviceName     | 依赖的服务名称                                               | Dashboard   | string | 非必填 |
| Plans           | 依赖的服务方案，若为空，则表示可以选择该服务的任一方案       | ["xx","xx"] | array  | 非必填 |
| RequirementType | 必须性，支持Essential（必选），Alternative（多选一）、Unessential（非必选） | Essential   | string | 非必填 |

**package 参数**

- apps（依赖的app服务）
- dataservices（依赖的数据库服务）
- spaces（依赖的EnSaaS K8s Service服务）
- infrastructures（依赖的基础设施，只有当isInfrastructure=false&planType=License&licenseType=BindingInfra时需要填写）

| 名称               | 描述                                                         | 示例值      | 类型   | 必要性 |
| ------------------ | ------------------------------------------------------------ | ----------- | ------ | ------ |
| serviceName        | 服务名称                                                     | Dashboard   | string | 必填   |
| deliveryType       | 订阅方式，支持支持appbuy（单一服务）、servicebuy（托管服务）、mpbuy（EnSaaS-K8s-Service服务）、pluginbuy（插件服务）、pipeline（集成服务或整合服务）、manual（人工服务） | appbuy      | string | 必填   |
| Dept               | 部门，用于Package拆分订单。如订阅APM.M2I，需要拆分IoTSuite订单，那么Package中EnSaaS服务的dept需填写为ENSS，非EnSaaS服务的dept为空 | ENSS        | string | 非必填 |
| serviceDescription | 服务描述                                                     | xxx         | string | 非必填 |
| serviceCategory    | 服务类别                                                     | Common Apps | string | 非必填 |
| planName           | 服务方案名称                                                 | Lite        | string | 必填   |
| planDescription    | 服务方案描述                                                 | xxx         | string | 非必填 |
| RequirementType    | 必须性，仅支持Essential                                      | Essential   | string | 必填   |
| pnInfo             | 服务方案的料号信息                                           | []          | array  | 必填   |

**integration 参数**

- apps（依赖的app服务）
- dataservices（依赖的数据库服务）
- spaces（依赖的EnSaaS K8s Service服务）
- infrastructures（依赖的基础设施，只有当isInfrastructure=false&planType=License&licenseType=BindingInfra时需要填写）

| 名称               | 描述                                                         | 示例值      | 类型   | 必要性 |
| ------------------ | ------------------------------------------------------------ | ----------- | ------ | ------ |
| serviceName        | 服务名称                                                     | Dashboard   | string | 必填   |
| deliveryType       | 订阅方式，支持支持appbuy、servicebuy、mpbuy、pluginbuy、pipeline、manual | appbuy      | string | 必填   |
| Dept               | 部门，用于Package拆分订单。如订阅APM.M2I，需要拆分IoTSuite订单，那么Package中EnSaaS服务的dept需填写为ENSS，非EnSaaS服务的dept为空 | ENSS        | string | 非必填 |
| serviceDescription | 服务描述                                                     | xxx         | string | 非必填 |
| serviceCategory    | 服务类别                                                     | Common Apps | string | 非必填 |
| planName           | 服务方案名称                                                 | Lite        | string | 必填   |
| planDescription    | 服务方案描述                                                 | xxx         | string | 非必填 |
| planNumber         | 服务方案排序                                                 | xxx         | int    | 非必填 |
| cpu                | 服务需要的CPU资源，单位为Core                                | 0.5         | string | 必填   |
| memory             | 服务需要的Memory资源，单位为MB                               | 1024        | string | 必填   |
| ephemeralStorage   | 服务需要的Ephemeral Storage资源，单位为MB                    | 1024        | string | 必填   |
| RequirementType    | 必须性，仅支持Essential                                      | Essential   | string | 必填   |
| pnInfo             | 服务方案的料号信息                                           | []          | array  | 必填   |

#### 单一服务请求参数示例

```json
 {
      "planName": "Standard",
      "planNumber": 1,
      "datacenterCode": "bj",
      "planForTrial": false,
      "isInfrastructure": false,
      "deploymentSolution": "Cloud",
      "namespace": "",
      "cluster": "",
      "isVisible": true,
      "planType": "Service",
      "hasActiveInfo": false,
      "licenseType": "Default",
      "planCategory": "standard",
      "description": "standard AIFS Medical Imaging Service",
      "uiId": 3,
      "deliveryType": "appbuy",
      "serviceName": "AIFS-Medical-Imaging",
      "pnInfo": [
        {
          "pn": "9806WPEMI01",
          "pnProperty": "Basic",
          "pnUnit": {
             "Node": "1",
             "CPU(Core)":"0.5",
             "RAM(GB)":"2"
          },
          "pnQuantity": "1",
          "planDescription": "standard AIFS Medical Imaging Service"
        }
      ],
     "dependency": {
         "apps": [
         ],
        "databases": [
          {
            "serviceName": "PostgreSQL",
            "plans":[],
            "requirementType": "Essential"
          }
        ],
        "spaces": [
         {
            "serviceName": "EnSaaS-K8s-Service",
            "plans":[],
            "requirementType": "Essential"
          }
        ]
      }
 }
```

#### 集成服务请求参数示例

```json
  {
      "planName": "M2I-31A-with-Datahub",
      "planNumber": 1,
      "datacenterCode": "bj",
      "planForTrial": false,
      "isInfrastructure": false,
      "deploymentSolution": "Cloud",
      "namespace": "",
      "cluster": "",
      "isVisible": true,
      "planType": "Service",
      "hasActiveInfo": false,
      "licenseType": "Default",
      "planCategory": "package",
      "description": "Advanced functional package for APM.M2I (with Datahub) include 1000 tags",
      "uiId": 0,
      "deliveryType": "pipeline",
      "serviceName": "APM.M2I",
      "pnInfo": [
        {
          "pn": "9803M2IA103",
          "pnProperty": "Basic",
          "pnUnit": {
            "Instance": "1"
          },
          "pnQuantity": "1",
          "planDescription": "Advanced functional package for APM.M2I (with Datahub) include 1000 tags"
        },
        {
          "pn": "980GEMRA100",
          "pnProperty": "PAYG",
          "pnUnit": {
            "Messages(Million)": "1"
          },
          "pnQuantity": "1",
          "planDescription": "Message Usage"
        }
      ],
      "package": {
        "apps": [
          {
            "serviceName": "APM.M2I",
            "deliveryType": "appbuy",
            "dept":"",
            "serviceDescription": "APM.M2I (Machine to Intelligence), a low-code IoT solution for industrial equipment, is a one-stop development tool that can help factories and equipment manufacturers quickly complete their own machine monitoring, maintenance, notification, reporting and remote control system. APM.M2I also provides various templates for different domains, which mainly focus on improving machine  performances, reducing maintenance and administration costs.",
            "serviceCategory": "Industrial Apps",
            "planName": "M2I-31A-with-Datahub",
            "planDescription": "Advanced functional package for APM.M2I (with Datahub) include 1000 tags",
            "pnInfo": [
              {
                "pn": "9803M2IA013",
                "pnProperty": "Basic",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "Dashboard",
            "dept":"ENSS",
            "deliveryType": "appbuy",
            "serviceDescription": "A data analysis and visualization tool, which allows access to various data sources and gives convenient access to WISE-PaaS data",
            "serviceCategory": "Common Apps",
            "planName": "Standard",
            "planDescription": "Dashboard Advanced Edition with unlimited number of users and dashboards advantech plugins multiple SRP-Frame management and Customizable logo supporting",
            "pnInfo": [
              {
                "pn": "980GDSHCS00",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "DataHub",
            "dept":"ENSS",
            "deliveryType": "appbuy",
            "serviceDescription": "WISE-PaaS/DataHub is an IoT solution accelerator. It offers data collection, device management functions, and data aggregation API that are suitable for IoT situation, such as Smart City, Smart Factory or Internet of Vehicle.",
            "serviceCategory": "Common Apps",
            "planName": "Standard",
            "planDescription": "below 10000 tags published per minute",
            "pnInfo": [
              {
                "pn": "980GDTHBS00",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "Notification",
            "dept":"ENSS",
            "deliveryType": "appbuy",
            "serviceDescription": "WISE-PaaS Notification is a messaging service that is primarily for integration with SRPs. Users can send E-mail, LINE, WeChat, DingTalk, WhatsApp, and call third-party APIs through the WISE-PaaS Notification API to achieve instant message notification.",
            "serviceCategory": "Common Apps",
            "planName": "Standard",
            "planDescription": "Notification Standard",
            "pnInfo": [
              {
                "pn": "9806WPSC02",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "APM",
            "dept":"",
            "deliveryType": "appbuy",
            "serviceDescription": "WISE-PaaS/APM is designed to reduce unplanned downtime, improve availability, minimize operation cost, and eliminate the risk of equipment failure",
            "serviceCategory": "Common Apps",
            "planName": "APM-Managed-1000",
            "planDescription": "APM Managed with 1000 Parameters",
            "pnInfo": [
              {
                "pn": "9806WPAPM4",
                "pnProperty": "Basic",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "SaaS-Composer",
            "dept":"ENSS",
            "deliveryType": "appbuy",
            "serviceDescription": "WISE-PaaS/SaaS Composer is the new generation cloud based graphical control tool that allow user to interact with machine in real-time. It is a browser based infrastructure, which replaced the traditional IDE limitations and allow cross platform usage. This satisfies variety of industrial domains and business solutions. With 100% customization ability, users can reconstruct the on-site environment and offer a live detailed representation.",
            "serviceCategory": "Common Apps",
            "planName": "Professional-IBMS",
            "planDescription": "SaaS Composer Advanced Edition with unlimited number of Users, Organizations, 2D Displays, 3D Scenes, data tags connection for 2D and 3D, and support SQL database connection",
            "pnInfo": [
              {
                "pn": "980GWPSCP00",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          }
        ],
        "databases": [
          {
            "serviceName": "MongoDB",
            "deliveryType": "servicebuy",
            "dept":"ENSS",
            "serviceDescription": "The NoSQL databases is relatively flexible, stores data as key?value pairs in the JSON format, and efficiently processes high-traffic websites and indexes big data. WISE-PaaS uses this database service to store key?value data. Trends in stored data are then illustrated using WISE-PaaS visualization tools and analytics services for advanced value-added applications.",
            "serviceCategory": "EnSaaS",
            "planName": "Dedicated-Single-Small-V2",
            "planDescription": "Dedicated MongoDB w/o Replica",
            "pnInfo": [
              {
                "pn": "980GEDMS001",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Node": "1",
	            "RAM(GB)": "8",
	            "Disk(GB)": "100",
	            "CPU(Core)": "4",
	            "Connection": "3000"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "PostgreSQL",
            "dept":"ENSS",
            "deliveryType": "servicebuy",
            "serviceDescription": "An object-relational database management system that establishes relations between data tables within an object-oriented framework in order to achieve data independence and consistency. WISE-PaaS uses this database service to store the metadata of edge devices.",
            "serviceCategory": "EnSaaS",
            "planName": "Dedicated-Single-Small",
            "planDescription": "Dedicated PostgreSQL w/o Replica",
            "pnInfo": [
              {
                "pn": "980GEDPS000",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Node": "1",
                  "RAM(GB)": "8",
                  "Disk(GB)": "100",
                  "CPU(Core)": "2"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          },
          {
            "serviceName": "RabbitMQ",
            "dept":"ENSS",
            "deliveryType": "servicebuy",
            "serviceDescription": "RabbitMQ is a general purpose messaging solution, often used to allow web servers to respond to requests quickly instead of being forced to perform resource-heavy procedures while the user waits for the result. It?s also good for distributing a message to multiple recipients for consumption. When your requirements extend beyond throughput, RabbitMQ has a lot to offer: features for reliable delivery, routing, federation, HA, security, management tools and other features",
            "serviceCategory": "EnSaaS",
            "planName": "standard",
            "planDescription": "Shared RabbitMQ Service",
            "pnInfo": [
              {
                "pn": "980GEMRA000",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "Messages(Million)": "3",
                  "Connection": "100",
                  "Queue": "100",
                  "Queued Message Size(MB)": "2",
                  "Queued Messages": "2000"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              },
              {
                "pn": "980GEMRA100",
                "pnProperty": "PAYG",
                "pnUnit": {
                  "Messages(Million)": "1"
                },
                "pnQuantity": "1",
                "chargeType": "PAYG"
              }
            ]
          },
          {
            "serviceName": "Redis",
            "dept":"ENSS",
            "deliveryType": "servicebuy",
            "serviceDescription": "An in-memory data structures server, used as a database and cache service. It supports data structures such as strings, hashes, lists, sets, sorted sets with range queries.",
            "serviceCategory": "EnSaaS",
            "planName": "Containerized",
            "planDescription": "Containerized Redis, deployed in user space",
            "pnInfo": [
              {
                "pn": "980GEDRK000",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "POD": "1",
                  "CPU(Core)": "0.1",
                  "RAM(GB)": "0.125",
                  "Ephemeral Storage(GB)": "0.25"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          }
        ],
        "spaces": [
          {
            "serviceName": "EnSaaS-K8s-Service",
            "dept":"ENSS",
            "deliveryType": "mpbuy",
            "serviceDescription": "As the WISE-PaaS AIoT data application platform evolves to version 4.0 with Kubernetes, the newly introduced micro-service and open design broadens our service portfolio to match the partner's development and operation need.",
            "serviceCategory": "EnSaaS",
            "planName": "General-Workspace",
            "planDescription": "Shared Performance Kubernetes Workspace",
            "pnInfo": [
              {
                "pn": "980GENGW100",
                "pnProperty": "Insourcing",
                "pnUnit": {
                  "CPU(Core)": "0.5",
                  "RAM(GB)": "2",
                  "Ephemeral-storage(GB)": "10",
                  "Pod": "10"
                },
                "pnQuantity": "4",
                "chargeType": "Monthly"
              }
            ]
          }
        ]
      },
      "createdAt": "2021-03-30T16:34:07.86999Z",
      "updatedAt": "2021-04-09T01:12:55.673642Z"
    }
```

#### 整合服务请求参数示例

```json
{
	"planName": "E100",
	"planNumber": 1,
	"datacenterCode": "bj",
	"planForTrial": false,
	"isInfrastructure": false,
    "deploymentSolution": "Cloud",
	"namespace": "ensaas-service",
	"cluster": "ensaas",
	"isVisible": true,
	"planType": "License",
	"hasActiveInfo": true,
	"licenseType": "BindingInfra",
	"planCategory": "integration",
	"description": "EnSaaS Service",
	"uiId": 3,
	"deliveryType": "pipeline",
	"serviceName": "EnSaaS-Service",
	"pnInfo": [{
		"pn": "980GESE100",
		"pnProperty": "Basic",
		"pnUnit": {
			"Instance": "1"
		},
		"pnQuantity": "1",
		"planDescription": "EnSaaS-Service"
	}],
	"integration": {
		"apps": [{
				"serviceName": "EnSaaS-Management-Portal",
				"deliveryType": "pipeline",
				"serviceDescription": "As the WISE-PaaS AIoT data application platform evolves to version 4.0 with Kubernetes, the newly introduced micro-service and open design broadens our service portfolio to match the partner's development and operation need.",
				"serviceCategory": "EnSaaS MicroService",
				"price": 0,
				"planName": "Lite-Standard",
				"planDescription": "EnSaaS-Management-Portal For Edge",
				"cpu": "0.6",
				"memory": "768",
				"ephemeralStorage": "640",
				"pnInfo": [{
					"pn": "980GEKSLM00",
					"pnProperty": "Basic",
					"pnUnit": {
						"Node": "1"
					},
					"pnQuantity": "1",
					"chargeType": "Monthly"
				}],
				"requirementType": "Essential"
			},
			{
				"serviceName": "EnSaaS-SSO",
				"deliveryType": "pipeline",
				"serviceDescription": "identity authentication for applications, data,and platforms",
				"serviceCategory": "EnSaaS MicroService",
				"price": 0,
				"planName": "Lite-Standard",
				"planDescription": "SSO standard plan for IoTSuite Edge is mainly used for identity authentication of applications? data and platforms?management of subscription?client and users.",
				"cpu": "0.25",
				"memory": "310",
				"ephemeralStorage": "278",
				"pnInfo": [{
					"pn": "980GSSOLS00",
					"pnProperty": "Basic",
					"pnUnit": {
						"Subscription": "1",
						"Users": "100"
					},
					"pnQuantity": "1",
					"chargeType": "Monthly"
				}],
				"requirementType": "Essential"
			},
			{
				"serviceName": "EnSaaS-Service-Hub",
				"deliveryType": "pipeline",
				"serviceDescription": "Used to manage services.",
				"serviceCategory": "EnSaaS MicroService",
				"price": 0,
				"planName": "Lite-Standard",
				"planDescription": "Standard plan for IoTSuite Edge",
				"cpu": "0.27",
				"memory": "672",
				"ephemeralStorage": "2048",
				"pnInfo": [{
					"pn": "980GESHLS00",
					"pnProperty": "Basic",
					"pnUnit": {
						"Instance": "1"
					},
					"pnQuantity": "1",
					"chargeType": "Monthly"
				}],
				"requirementType": "Essential"
			},
			{
				"serviceName": "EnSaaS-Appbuy",
				"deliveryType": "appbuy",
				"serviceDescription": "The appbuy is mainly used to deploy services, including adding, deleting, modifying, querying chartrepos, and deploying, deleting, stopping, resuming and updating services. Services and chartrepos can support the types of marketplace?public and private",
				"serviceCategory": "EnSaaS MicroService",
				"price": 0,
				"planName": "Lite-Standard",
				"planDescription": "Lite Standard Plan",
				"cpu": "0.1",
				"memory": "500",
				"ephemeralStorage": "1024",
				"pnInfo": [{
					"pn": "980GAPPLS00",
					"pnProperty": "Basic",
					"pnUnit": {
						"Instance": "1"
					},
					"pnQuantity": "1",
					"chargeType": "Monthly"
				}],
				"requirementType": "Essential"
			},
			{
				"serviceName": "MongoDB",
				"deliveryType": "servicebuy",
				"serviceDescription": "The NoSQL databases is relatively flexible, stores data as key?value pairs in the JSON format, and efficiently processes high-traffic websites and indexes big data. WISE-PaaS uses this database service to store key?value data. Trends in stored data are then illustrated using WISE-PaaS visualization tools and analytics services for advanced value-added applications.\r\nThe NoSQL databases is relatively flexible, stores data as key?value pairs in the JSON format, and efficiently processes high-traffic websites and indexes big data. WISE-PaaS uses this database service to store key?value data. Trends in stored data are then illustrated using WISE-PaaS visualization tools and analytics services for advanced value-added applications.",
				"serviceCategory": "EnSaaS",
				"price": 0,
				"planName": "Containerized-Single-Small",
				"planDescription": "Containerized MongoDB w/o Replica",
				"cpu": "2",
				"memory": "8192",
				"ephemeralStorage": "10240",
				"pnInfo": [{
					"pn": "980GEDMKS00",
					"pnProperty": "Basic",
					"pnUnit": {
						"Node": "1",
						"RAM(GB)": "8",
						"PVC(GB)": "512",
						"CPU(Core)": "2",
						"Connection": "2500"
					},
					"pnQuantity": "1",
					"chargeType": "Monthly"
				}],
				"requirementType": "Essential"
			}
		],
		"databases": [],
		"spaces": [],
		"infrastructures": [{
			"serviceName": "WISE-STACK-Edge-Series",
			"plans": [
				"E100",
				"E300"
			],
			"requirementType": "Alternative"
		}]
	}
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="GetServicePlan">GetServicePlan</span> 

#### 请求方式

```bash
GET  /v1/servicePlan
```

#### 请求参数

| 名称           | 描述         | 示例值           | 类型   | 必要性 |
| -------------- | ------------ | ---------------- | ------ | ------ |
| planName       | 服务方案名称 | Standard-Package | string | 非必填 |
| serviceName    | 服务名称     | Dashboard        | string | 必填   |
| datacenterCode | 站点         | sa               | string | 必填   |

#### 单一服务返回数据示例

```json
{
  "data": [
    {
      "id": "c2cffad9-3477-4abe-8715-7b74fd6cea8f",
      "planName": "Standard",
      "planNumber": 4,
      "datacenterCode": "bj",
      "planForTrial": false,
      "isInfrastructure": false,
      "deploymentSolution": "Cloud",
      "namespace": "",
      "cluster": "",
      "isVisible": false,
      "planType": "Service",
      "hasActiveInfo": false,
      "licenseType": "Default",
      "planCategory": "standard",
      "description": "每分钟最多上传100,00测点数据",
      "uiId": 0,
      "deliveryType": "appbuy",
      "serviceName": "DataHub",
      "pnInfo": [
        {
          "pn": "980GDTHBS00",
          "pnProperty": "Basic",
          "pnUnit": {
            "Instance": "1"
          },
          "pnQuantity": "1",
          "planDescription": "每分钟最多上传100,00测点数据"
        }
      ],
      "dependency": {
        "apps": [],
        "databases": [
          {
            "serviceName": "PostgreSQL",
            "requirementType": "Essential"
          },
          {
            "serviceName": "Redis",
            "requirementType": "Essential"
          },
          {
            "serviceName": "RabbitMQ",
            "requirementType": "Essential"
          },
          {
            "serviceName": "MongoDB",
            "requirementType": "Alternative"
          },
          {
            "serviceName": "InfluxDB",
            "plans": [
              "Dedicated-Single-Small"
            ],
            "requirementType": "Alternative"
          }
        ],
        "spaces": [
          {
            "serviceName": "EnSaaS-K8s-Service",
            "requirementType": "Essential"
          }
        ]
      },
      "createdAt": "2020-09-26T23:28:47.237801+08:00",
      "updatedAt": "2022-01-20T09:31:49.315436+08:00"
    }
  ],
  "error": null,
  "path": "/v1/servicePlan?planName=Standard&datacenterCode=bj&serviceName=DataHub",
  "status": 200,
  "timestamp": "2022-03-11T03:47:27+0000",
  "totalCount": 1
}
```

#### 集成服务返回数据示例

```json
{
  "data": [
    {
      "id": "3e2b4499-9393-423f-8b44-d33c0e466415",
      "planName": "Standard-Package",
      "planNumber": 1,
      "datacenterCode": "bj",
      "planForTrial": false,
      "isInfrastructure": false,
      "deploymentSolution": "Cloud",
      "namespace": "",
      "cluster": "",
      "isVisible": true,
      "planType": "Service",
      "hasActiveInfo": false,
      "licenseType": "Default",
      "planCategory": "package",
      "description": "标准版 Dashboard;0.5C2G 共享型工作空间 EnSaaS K8s Service;单节点 30G Disk PostgreSQL",
      "uiId": 0,
      "deliveryType": "pipeline",
      "serviceName": "Dashboard",
      "pnInfo": [
        {
          "pn": "980GDAHSP01",
          "pnProperty": "Basic",
          "pnUnit": {
            "Instance": "1"
          },
          "pnQuantity": "1",
          "planDescription": "标准版 Dashboard;0.5C2G 共享型工作空间 EnSaaS K8s Service;单节点 30G Disk PostgreSQL"
        }
      ],
      "package": {
        "apps": [
          {
            "serviceName": "Dashboard",
            "deliveryType": "appbuy",
            "dept": "",
            "serviceDescription": "A data analysis and visualization tool, which allows access to various data sources and gives convenient access to WISE-PaaS data",
            "serviceCategory": "Common Apps",
            "planName": "Standard",
            "planDescription": "Dashboard basic functions and application construction framework",
            "pnInfo": [
              {
                "pn": "980GDSHCS00",
                "pnProperty": "Basic",
                "pnUnit": {
                  "Instance": "1"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          }
        ],
        "databases": [
          {
            "serviceName": "PostgreSQL",
            "deliveryType": "servicebuy",
            "dept": "",
            "serviceDescription": "An object-relational database management system that establishes relations between data tables within an object-oriented framework in order to achieve data independence and consistency. WISE-PaaS uses this database service to store the metadata of edge devices.",
            "serviceCategory": "EnSaaS",
            "planName": "Dedicated-Single-Mini",
            "planDescription": "Dedicated PostgreSQL w/o Replica",
            "pnInfo": [
              {
                "pn": "980GEDPSM00",
                "pnProperty": "Basic",
                "pnUnit": {
                  "Node": "1",
                  "RAM(GB)": "4",
                  "Disk(GB)": "30",
                  "CPU(Core)": "2"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          }
        ],
        "spaces": [
          {
            "serviceName": "EnSaaS-K8s-Service",
            "deliveryType": "mpbuy",
            "dept": "",
            "serviceDescription": "As the WISE-PaaS AIoT data application platform evolves to version 4.0 with Kubernetes, the newly introduced micro-service and open design broadens our service portfolio to match the partner's development and operation need.",
            "serviceCategory": "EnSaaS",
            "planName": "General-Workspace",
            "planDescription": "Shared Performance Kubernetes Workspace",
            "pnInfo": [
              {
                "pn": "980GENGW100",
                "pnProperty": "Basic",
                "pnUnit": {
                  "CPU(Core)": "0.5",
                  "RAM(GB)": "2",
                  "Ephemeral-storage(GB)": "10",
                  "Pod": "10"
                },
                "pnQuantity": "1",
                "chargeType": "Monthly"
              }
            ]
          }
        ]
      },
      "createdAt": "2020-09-28T12:58:45.117593+08:00",
      "updatedAt": "2022-02-09T08:55:32.932908+08:00"
    }
  ],
  "error": null,
  "path": "/v1/servicePlan?planName=Standard-Package&datacenterCode=bj&serviceName=Dashboard",
  "status": 200,
  "timestamp": "2022-02-09T01:30:44+0000",
  "totalCount": 1
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="CreateserviceSaleStrategy ">CreateserviceSaleStrategy </span> 

#### 请求方式

```bash
POST  /v1/serviceSaleStrategy
```

#### 请求参数

| 名称        | 描述                                              | 示例值    | 类型   | 必要性 |
| ----------- | ------------------------------------------------- | --------- | ------ | ------ |
| serviceName | 服务名称                                          | Dashboard | string | 必填   |
| planName    | 服务方案名称                                      | Standard  | string | 必填   |
| discount    | 折扣，0-1之间                                     | 1         | int    | 必填   |
| datacenter  | 站点                                              | bj        | string | 必填   |
| isVisible   | 下架标识，true表示上架，false表示下架             | true      | bool   | 必填   |
| isPackage   | 集成服务标识，true表示集成服务，false表示单一服务 | true      | bool   | 必填   |
| payInfo     | 付费类型信息                                      | {}        | object | 必填   |
| package     | 集成服务信息                                      | {}        | object | 非必填 |

**payInfo参数**

| 名称       | 描述                                                         | 示例值  | 类型   | 必要性 |
| ---------- | ------------------------------------------------------------ | ------- | ------ | ------ |
| chargeType | 付费类型，支持Monthly、Quarterly、HalfYear、Yearly、Eternal  | Monthly | string | 必填   |
| spuNumber  | 份数。Monthly（spuNumber=1）、Quarterly（spuNumber=3）、HalfYear（spuNumber=6）、Yearly（spuNumber=12）、Eternal（spuNumber=1） | 1       | string | 必填   |

**package参数**

当isPackage为true，必须填写package参数信息

- apps（依赖的app服务）
- dataservices（依赖的数据库服务）
- spaces（依赖的EnSaaS K8s Service服务）

| 名称                | 描述                                                         | 示例值  | 类型   | 必要性 |
| ------------------- | ------------------------------------------------------------ | ------- | ------ | ------ |
| serviceName         | 付费类型，支持Monthly、Quarterly、HalfYear、Yearly、Eternal  | Monthly | string | 必填   |
| planName            | 份数。Monthly（spuNumber=1）、Quarterly（spuNumber=3）、HalfYear（spuNumber=6）、Yearly（spuNumber=12）、Eternal（spuNumber=1） | 1       | string | 必填   |
| pnInternalPriceList | 集成服务中包含的服务的价格列表                               | []      | array  | 必填   |

- pnInternalPriceList参数

  | 名称       | 描述                                  | 示例值  | 类型   | 必要性 |
  | ---------- | ------------------------------------- | ------- | ------ | ------ |
  | pn         | 料号                                  | Monthly | string | 必填   |
  | pnProperty | 料号属性，支持Basic、Additional、PAYG | Basic   | string | 必填   |
  | pnQuantity | 料号数量                              | 1       | int    | 必填   |
  | level1     | 注册会员价格，支持两位小数，向上圆整  | 22      | float  | 必填   |
  | level2     | 银牌会员价格，支持两位小数，向上圆整  | 22      | float  | 必填   |
  | level3     | 金牌会员价格，支持两位小数，向上圆整  | 22      | float  | 必填   |
  | level4     | 贵宾会员价格，支持两位小数，向上圆整  | 22      | float  | 必填   |
  | level0     | 内部用户价格，支持两位小数，向上圆整  | 22      | float  | 必填   |

#### 单一服务或整合服务请求参数示例

```json
{
  "serviceName": "AIFS-Medical-Imaging",
  "planName": "Standard",
  "datacenter": "bj",
  "discount": 1,
  "isVisible": true,
  "isPackage": false,
  "payInfo": {
    "chargeType": "Monthly",
    "spuNumber": 1
  }
}
```

#### 集成服务请求参数示例

```json
{
  "serviceName": "APM.M2I",
  "planName": "M2I-31A-with-Datahub",
  "datacenter": "${hz}",
  "discount": 1,
  "isVisible": true,
  "isPackage": true,
  "payInfo": {
    "chargeType": "Monthly",
    "spuNumber": 1
  },
  "package": {
    "apps": [
      {
        "serviceName": "APM.M2I",
         "dept":"",
        "planName": "M2I-31A-with-Datahub",
        "pnInternalPriceList": [
          {
            "pn": "9803M2IA013",
            "pnProperty": "Basic",
            "level1": 1398.4,
	      "level2": 1247.2,
	      "level3": 1348.8,
	      "level4": 1448,
	      "level0": 1448,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "Dashboard",
         "dept":"ENSS",
        "planName": "Standard",
        "pnInternalPriceList": [
          {
            "pn": "980GDSHCS00",
            "pnProperty": "Insourcing",
            "level1": 648,
	      "level2": 616,
	      "level3": 551.2,
	      "level4": 486.4,
	      "level0": 486.4,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "DataHub",
         "dept":"ENSS",
        "planName": "Standard",
        "pnInternalPriceList": [
          {
            "pn": "980GDTHBS00",
            "pnProperty": "Insourcing",
            "level1": 720,
	      "level2": 684,
	      "level3": 612,
	      "level4": 540,
	      "level0": 540,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "Notification",
         "dept":"ENSS",
        "planName": "Standard",
        "pnInternalPriceList": [
          {
            "pn": "9806WPSC02",
            "pnProperty": "Insourcing",
            "level1": 0,
	      "level2": 0,
	      "level3": 0,
	      "level4": 0,
	      "level0": 0,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "SaaS-Composer",
         "dept":"ENSS",
        "planName": "Professional-IBMS",
        "pnInternalPriceList": [
          {
            "pn": "980GWPSCP00",
            "pnProperty": "Insourcing",
            "level1": 480,
	      "level2": 456,
	      "level3": 408,
	      "level4": 360,
	      "level0": 360,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "APM",
         "dept":"",
        "planName": "APM-Managed-1000",
        "pnInternalPriceList": [
          {
            "pn": "9806WPAPM4",
            "pnProperty": "Basic",
            "level1": 576,
	      "level2": 547.2,
	      "level3": 489.6,
	      "level4": 432,
	      "level0": 432,
            "pnQuantity": 1
          }
        ]
      }
    ],
    "databases": [
      {
        "serviceName": "MongoDB",
         "dept":"ENSS",
        "planName": "Dedicated-Single-Small-V2",
        "pnInternalPriceList": [
          {
            "pn": "980GEDMS001",
            "pnProperty": "Insourcing",
            "level1": 597.6,
	      "level2": 568,
	      "level3": 508,
	      "level4": 448,
	      "level0": 448,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "PostgreSQL",
         "dept":"ENSS",
        "planName": "Dedicated-Single-Small",
        "pnInternalPriceList": [
          {
            "pn": "980GEDPS000",
            "pnProperty": "Insourcing",
           "level1": 468,
	      "level2": 444.8,
	      "level3": 397.6,
	      "level4": 351.2,
	      "level0": 351.2,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "RabbitMQ",
         "dept":"ENSS",
        "planName": "standard",
        "pnInternalPriceList": [
          {
            "pn": "980GEMRA000",
            "pnProperty": "Insourcing",
            "level1": 72,
	      "level2": 68.8,
	      "level3": 61.6,
	      "level4": 54.4,
	      "level0": 54.4,
            "pnQuantity": 1
          },
          {
            "pn": "980GEMRA100",
            "pnProperty": "PAYG",
            "level1": 0,
	      "level2": 0,
	      "level3": 0,
	      "level4": 0,
	      "level0": 0,
            "pnQuantity": 1
          }
        ]
      },
      {
        "serviceName": "Redis",
         "dept":"ENSS",
        "planName": "Containerized",
        "pnInternalPriceList": [
          {
            "pn": "980GEDRK000",
            "pnProperty": "Insourcing",
           "level1": 0,
	      "level2": 0,
	      "level3": 0,
	      "level4": 0,
	      "level0": 0,
            "pnQuantity": 1
          }
        ]
      }
    ],
    "spaces": [
      {
        "serviceName": "EnSaaS-K8s-Service",
         "dept":"ENSS",
        "planName": "General-Workspace",
        "pnInternalPriceList": [
          {
            "pn": "980GENGW100",
            "pnProperty": "Insourcing",
            "level1": 360,
	      "level2": 342,
	      "level3": 306,
	      "level4": 270,
	      "level0": 270,
            "pnQuantity": 4
          }
        ]
      }
    ]
  }
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="GetserviceSaleStrategy ">GetserviceSaleStrategy </span> 

#### 请求方式

```bash
GET  /v1/serviceSaleStrategy/services/{serviceName}/plans/{planName}
```

#### 请求参数

| 名称            | 描述         | 示例值           | 类型   | 必要性 |
| --------------- | ------------ | ---------------- | ------ | ------ |
| serviceName     | 服务名称     | Dashboard        | string | 必填   |
| serviceCategory | 服务方案名称 | Standard-Package | string | 必填   |
| datacenterCode  | 站点         | bj               | string | 必填   |
| spuNumber       | 份数         | 1                | string | 必填   |

#### 单一服务或整合服务返回数据示例

```json
{
  "id": "8ede95a2-5324-469c-a26e-3264be063260",
  "serviceName": "EnSaaS-K8s-Service",
  "planName": "General-Workspace",
  "datacenter": "bj",
  "discount": 1,
  "isVisible": true,
  "isPackage": false,
  "payInfo": {
    "chargeType": "Monthly",
    "spuNumber": 1
  },
  "package": null
}
```

#### 集成服务返回数据示例

```json
{
  "id": "db9b1f6c-d5b6-441e-a7da-e8e5f24ab1ac",
  "serviceName": "Dashboard",
  "planName": "Standard-Package",
  "datacenter": "bj",
  "discount": 1,
  "isVisible": true,
  "isPackage": true,
  "payInfo": {
    "chargeType": "Monthly",
    "spuNumber": 1
  },
  "package": {
    "apps": [
      {
        "serviceName": "Dashboard",
        "planName": "Standard",
        "dept": "",
        "pnInternalPriceList": [
          {
            "pn": "980GDSHCS00",
            "pnProperty": "Basic",
            "pnQuantity": 1,
            "level0": 540,
            "level1": 720,
            "level2": 684,
            "level3": 612,
            "level4": 540
          }
        ]
      }
    ],
    "databases": [
      {
        "serviceName": "PostgreSQL",
        "planName": "Dedicated-Single-Mini",
        "dept": "",
        "pnInternalPriceList": [
          {
            "pn": "980GEDPSM00",
            "pnProperty": "Basic",
            "pnQuantity": 1,
            "level0": 237.15,
            "level1": 279,
            "level2": 265.05,
            "level3": 237.15,
            "level4": 237.15
          }
        ]
      }
    ],
    "spaces": [
      {
        "serviceName": "EnSaaS-K8s-Service",
        "planName": "General-Workspace",
        "dept": "",
        "pnInternalPriceList": [
          {
            "pn": "980GENGW100",
            "pnProperty": "Basic",
            "pnQuantity": 1,
            "level0": 340,
            "level1": 400,
            "level2": 380,
            "level3": 340,
            "level4": 340
          }
        ]
      }
    ]
  }
}
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="CreateMetricPricing">CreateMetricPricing</span> 

#### 请求方式

```bash
POST  /v1/metricPricing
```

#### 请求参数

| 名称              | 描述                                 | 示例值       | 类型   | 必要性 |
| ----------------- | ------------------------------------ | ------------ | ------ | ------ |
| metric            | 计量指标名称，自定义                 | 1C2M         | string | 必填   |
| metricCategory    | 计量指标类型，自定义                 | container    | string | 必填   |
| serviceName       | 服务名称                             | AIFS         | string | 必填   |
| datacenterCode    | 站点                                 | [   "bj"   ] | array  | 必填   |
| pn                | 按量计费料号                         | 9806WPAFS3   | string | 必填   |
| metricDescription | 计量指标描述                         | xxxx         | string | 必填   |
| quantityUnit      | 量测单位                             | 3600         | int    | 必填   |
| metricUnit        | 计量单位                             | 1 hours      | string | 必填   |
| level1            | 注册用户价格，支持两位小数，向上圆整 | 22           | number | 必填   |
| level2            | 银牌会员价格，支持两位小数，向上圆整 | 22           | number | 必填   |
| level3            | 金牌会员价格，支持两位小数，向上圆整 | 22           | number | 必填   |
| level4            | 贵宾会员价格，支持两位小数，向上圆整 | 22           | number | 必填   |
| level0            | 内部用户价格                         | 22           | number | 必填   |
| statisticsType    | 统计类型，支持sum，max两种           | sum          | string | 必填   |

#### 请求参数示例

```json
{
     
      "metric": "1C2M",
      "metricCategory": "container",
      "serviceName": "AIFS",
      "datacenterCode": [
        "bj"
      ],
      "pn": "9806WPAFS3",
      "metricDescription": "1 vCPU / 2G Memory  [Free Tier] No more than 90hr for each AFS instance",
      "quantityUnit": 3600,
      "metricUnit": "1 hours",
      "level1": 0,
      "level3": 0,
      "level2": 0,
      "level4": 0,
      "level0": 0,
      "metricInternalInsourcingPrice": 0,
      "metricExternalInsourcingPrice": 0,
      "statisticsType": "sum"
}
```

**[ :point_up_2: API概览 ](#API概览)**  

### <span id="GetMetricPricing">GetMetricPricing</span> 

#### 请求方式

```bash
GET  /v1/metricPricing
```

#### 请求参数

| 名称           | 描述                 | 示例值      | 类型   | 必要性 |
| -------------- | -------------------- | ----------- | ------ | ------ |
| serviceName    | 服务名称             | AIFS        | string | 非必填 |
| metric         | 计量指标名称         | 1C2M        | string | 非必填 |
| metricCategory | 计量指标类型，自定义 | container   | string | 非必填 |
| pn             | 料号                 | 980GEDPS001 | string | 非必填 |
| datacenterCode | 站点                 | bj          | string | 必填   |

#### 返回数据示例

```json
{
      "id": 197,
      "metric": "NB2G8C32M.T",
      "metricCategory": "Jupyter Notebook",
      "serviceName": "AIFS",
      "datacenterCode": [
        "bj"
      ],
      "pn": "9806WPAFS3",
      "metricDescription": "2 GPU / 8 vCPU / 32G Memory ; Nvidia GEFORCE RTX 2080 Ti",
      "quantityUnit": 3600,
      "metricUnit": "1 hours",
      "level0": 0.57,
      "level1": 0.63,
      "level2": 0.63,
      "level3": 0.6,
      "level4": 0.57,
      "statisticsType": "sum"
    }
```

**[ :point_up_2: API概览 ](#API概览)**

### <span id="CreateDeployment">CreateDeployment</span> 

#### 请求方式

```bash
POST  /v1/deployment
```

#### 请求参数

| 名称                  | 描述                                                         | 示例值                                                       | 类型   | 必要性 |
| --------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ------ |
| serviceName           | 服务名称                                                     | APM.M2I                                                      | string | 必填   |
| planName              | 服务方案名称                                                 | M2I-31A-with-Datahub                                         | string | 必填   |
| chartVersion          | Helm chart版本                                               | 2.11.0                                                       | string | 必填   |
| chartName             | Helm chart名称                                               | m2i                                                          | string | 必填   |
| isBaseline            | 是否是基线版本                                               | true                                                         | bool   | 必填   |
| cpu                   | 该版本需要的cpu资源，单位是Core                              | 0.43                                                         | string | 必填   |
| memory                | 该版本需要的memory资源，但是是MB                             | 1310                                                         | string | 必填   |
| ephemeralStorage      | 该版本需要ephemeralStorage的资源，但是是MB                   | 1290                                                         | string | 必填   |
| deploymentType        | 部署类型，默认appbuy                                         | appbuy                                                       | string | 必填   |
| appServicesDependency | 该方案依赖的其他服务信息，该字段暂时没用                     | []                                                           | array  | 必填   |
| extraParam            | 额外参数，目前这里加的是服务外部访问地址的前缀（如没有外部访问地址，urlPrefix为[]） | {     "urlPrefix": [          "portal-m2i",          "api-m2i"        ]      } | object | 必填   |
| values                | Helm chart中values.yaml内容                                  | xxx                                                          | string | 必填   |
| apps                  | 该版本中包含的各个app                                        | {}                                                           | object | 必填   |

**apps**

| 名称                   | 描述                              | 示例值  | 类型   | 必要性 |
| ---------------------- | --------------------------------- | ------- | ------ | ------ |
| appName                | app名称                           | api-m2i | string | 必填   |
| appVersion             | app版本                           | 2.0.1   | string | 必填   |
| cpu                    | 该app需要的cpu资源，单位是Core    | 0.33    | string | 必填   |
| memory                 | 该app需要的memory资源，但是是MB   | 1054    | string | 必填   |
| extraDbDependencyParam | 该app需要的数据库信息，没有则为{} | {}      | object | 必填   |

**extraDbDependencyParam**

| 数据库名称 | group信息       | 示例值                                    | 类型   | 必要性 |
| ---------- | --------------- | ----------------------------------------- | ------ | ------ |
| mongodb    | 不需要group信息 | ""                                        | string | 非必填 |
| redis      | 不需要group信息 | ""                                        | string | 非必填 |
| rabbitmq   | 不需要group信息 | ""                                        | string | 非必填 |
| influxdb   | 不需要group信息 | ""                                        | string | 非必填 |
| postgresql | 必需group信息   | {   "postgresql_service_group": "g_m2i" } | object | 非必填 |

#### 请求参数示例

```json
{
      "apps": [
        {
          "appName": "api-m2i",
          "appVersion": "2.0.1",
          "memory": "1054",
          "cpu": "0.33",
          "ephemeralStorage": "778",
          "extraDbDependencyParam": {
            "mongodb": "",
            "rabbitmq": "",
            "postgresql": {
              "postgresql_service_group": "g_m2i"
            }
          }
        },
        {
          "appName": "portal-m2i",
          "appVersion": "2.12.0",
          "memory": "256",
          "cpu": "0.1",
          "ephemeralStorage": "512",
          "extraDbDependencyParam": {
            "mongodb": "",
            "rabbitmq": "",
            "postgresql": {
              "postgresql_service_group": "g_m2i"
            }
          }
        }
      ],
      "appServicesDependency": [],
      "releaseNote": "",
      "serviceName": "APM.M2I",
      "planName": "M2I-31A-with-Datahub",
      "chartVersion": "2.12.0",
      "isBaseline":true,
      "memory": "1310",
      "deploymentType": "appbuy",
      "cpu": "0.43",
      "ephemeralStorage": "1290",
      "chartName": "m2i",
      "extraParam": {
        "urlPrefix": [
          "portal-m2i",
          "api-m2i"
        ]
      },
      "values": "# Default values for apm-chart.\n# This is a YAML-formatted file.\n# Declare variables to be passed into your templates.\nsecretCreate: true\n\nimageCredentials:\n  registry: harbor.hz.wise-paas.com.cn\n  username: \"\"\n  password: \"\"\n\napps:\n  apiM2iEnable: true\n  portalM2iEnable: true\n\nmicro_service_env: &micro_service_env\n  consulToken: \"msftoken\"\n\ncommonEnvs:\n  # common envs\n  - &postgresql_service_name \"postgresql\"\n  - &kafka_service_name \"kafka\"\n\n\n\nglobal:\n  ensaas:\n    namespace: m2idemo\n    workspace: msf\n    cluster: cluster01\n    datacenter: msf\n    appID: msf\n  k8sType: ensaas\n  # auto gen pod env option\n  # ensaas import values\n  ensaasApps:\n    apiSso:\n      internalUrl: https://sso.axa-dev.wise-paas.top/v4.0\n      externalUrl: https://sso.axa-dev.wise-paas.top/v4.0\n    apiMg:\n      internalUrl:\n      externalUrl:\n    apiDccs:\n      internalUrl:\n      externalUrl:\n    apiLicense:\n      internalUrl:\n      externalUrl:\n    ensaas:\n      datacenterCode: axa-dev\n      internalUrl: en.internal\n      externalUrl: axa-dev.wise-paas.top\n  url:\n    host: \".m2idemo.cluster01.en.internal\"\n  database:\n    secretName: \"m2idemo-secret\"\n  kafkaSecret:\n    secretName: \"kafka-connector\"\n\n  createServiceAccount: false\n\n  msfResource:\n    requests:\n      cpu: \"2m\"\n      memory: \"10Mi\"\n      ephemeral-storage: \"10M\"\n    limits:\n      cpu: \"60m\"\n      memory: \"60Mi\"\n      ephemeral-storage: \"30M\"\n\n  # docker信息\n  api:\n    <<: *micro_service_env\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: m2i/api-m2i\n    tag: 2.0.1\n    name: \"api-m2i\"\n    serviceId: \"msf\"\n    tagType: \"common\"\n    tagVer: \"v1\"\n    servicePort: 8080\n  portal:\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: m2i/portal-m2i\n    tag: 2.12.0\n    servicePort: 80\n    name: portal-m2i\n    serviceId: \"03f11da5-4dda-47fa-8d29-788ccd35c4a3\"\n    tagType: \"common\"\n    tagVer: \"v1\"\n  register:\n    frameNamespace: system\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/register-client\n    tag: v2.3.0\n  vpnClient:\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/vpn-connect-agent\n    tag: v1.0.0\n  pn: \"9803M2IA013\"\n  serviceName: \"APM.M2I\"\n\napi-m2i:\n  envs:\n    postgresql_service_name: *postgresql_service_name\n    kafka_service_name: *kafka_service_name\n"
}
```

**[ :point_up_2: API概览 ](#API概览)**  

### <span id="GetDeployment">GetDeployment</span> 

#### 请求方式

```bash
GET  /v1/deployment
```

#### 请求参数

| 名称           | 描述                                     | 示例值                 | 类型   | 必要性 |
| -------------- | ---------------------------------------- | ---------------------- | ------ | ------ |
| name           | 服务名称                                 | Microservice-Framework | string | 必填   |
| plan           | 服务方案名称                             | Standard               | string | 必填   |
| chartversion   | Helm chart版本，不填默认返回最新版本信息 |                        | string | 非必填 |
| datacenterCode | 站点                                     | bj                     | string | 必填   |

#### 返回数据示例

```json
{
  "data": [
    {
      "id": 175,
      "apps": [
        {
          "appName": "apigateway",
          "appVersion": "v2.3.0",
          "memory": "1524",
          "cpu": "1.23",
          "ephemeralStorage": "1124",
          "extraDbDependencyParam": {}
        },
        {
          "appName": "registry",
          "appVersion": "v2.3.0",
          "memory": "1024",
          "cpu": "0.2",
          "ephemeralStorage": "500",
          "extraDbDependencyParam": {}
        },
        {
          "appName": "dns-server",
          "appVersion": "v2.3.0",
          "memory": "30",
          "cpu": "0.02",
          "ephemeralStorage": "100",
          "extraDbDependencyParam": {}
        },
        {
          "appName": "redis",
          "appVersion": "5.0.5",
          "memory": "256",
          "cpu": "0.1",
          "ephemeralStorage": "512",
          "extraDbDependencyParam": {}
        },
        {
          "appName": "etcd",
          "appVersion": "3.4.14-debian-10-r44",
          "memory": "256",
          "cpu": "0.1",
          "ephemeralStorage": "512",
          "extraDbDependencyParam": {}
        },
        {
          "appName": "kafka",
          "appVersion": "2.4.0",
          "memory": "512",
          "cpu": "0.25",
          "ephemeralStorage": "512",
          "extraDbDependencyParam": {}
        },
        {
          "appName": "zookeeper",
          "appVersion": "3.6.0",
          "memory": "1536",
          "cpu": "0.25",
          "ephemeralStorage": "3072",
          "extraDbDependencyParam": {}
        }
      ],
      "appServicesDependency": [],
      "releaseNote": "### Microservice Framework v-1.5.2 (2020-03-31)\n\n#### Summary Update\n\n- add authtication when user access register portal\n- fix bug about service doesn`t register to msf again when first register failed\n\n#### [Microservice Framework-1.5.2]\n\nFixed:\n\n- Bug #service doesn`t register to msf again when first register failed\n- Bug #registry node acl update failed\n",
      "serviceName": "Microservice-Framework",
      "planName": "Standard",
      "chartVersion": "2.3.0",
      "isBaseline": true,
      "memory": "5138",
      "deploymentType": "appbuy",
      "cpu": "2.15",
      "ephemeralStorage": "6332",
      "chartName": "msf",
      "extraParam": {
        "urlPrefix": []
      },
      "values": "# Default values for msf.\n# This is a YAML-formatted file.\n\nglobal:\n  url:\n    host: \".ns.cluster.en.internal\"\n  ensaasApps:\n    apiSso:\n      externalUrl: \"\"\n      internalUrl: \"\"\n    ensaas:\n      externalUrl: \"\"\n      internalUrl: \"\"\n      cluster: \"\"\n\n  imageRegistry: \"harbor.hz.wise-paas.com.cn/app-production\"\n  httpProtocol: \"\"\n\n  metrics:\n    enabled: false\n\n# all container images\nimage:\n  apigateway:\n    pullPolicy: IfNotPresent\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/apigateway\n    tag: v2.3.0\n  apigatewayConfig:\n    pullPolicy: IfNotPresent\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/apigateway-config\n    tag: v2.3.0\n  dnsServer:\n    pullPolicy: IfNotPresent\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/dns-server\n    tag: v2.3.0\n  registry:\n    pullPolicy: IfNotPresent\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/registry\n    tag: v2.3.0\n  exporter:\n    pullPolicy: IfNotPresent\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/msfmanagement-msf-exporter\n    tag: v2.2.2\n  opentracing:\n    pullPolicy: IfNotPresent\n    registry: harbor.hz.wise-paas.com.cn/app-production\n    repository: microservice/jaegertracing\n    tag: all-in-one\n\nmsf:\n  # deploy mode 'HA' for HA mode, 'NonHA' for Non HA.mode, default mode is HA\n  mode: \"NonHA\"\n\n  # deploy environment 'ENSAAS' or 'STDK8S', 'ENSAAS' for ensaas platform, 'STDK8S' for standard k8s platform, default 'ENSAAS'\n  deployEnv: \"ENSAAS\"\n\n  # current microservice framework name, default name is 'cluster01'\n  cluster: \"cluster01\"\n\n  # replicas for different deploy mode\n  replicaCount:\n    NonHA:\n      apigateway: 1\n      dnsServer: 1\n      registry: 1\n    HA:\n      apigateway: 3\n      dnsServer: 3\n      registry: 3\n\n  # set msf internal access domain, default internal domain is 'en.internal'\n  internalDomain: \"en.internal\"\n\n  # set msf external access domain, default external domain is 'msf-dev.top'\n  externalDomain: \"msf-dev.top\"\n\n  # set http protocol ('http' or 'https', default 'https') for external access.\n  httpProtocol: \"https\"\n\n  # export service type, 'NodePort', 'LoadBalancer', 'Ingress' default 'NodePort'\n  # when service type is 'NodePort', Add DNS record to resolve external domain to your k8s node ip\n  # when service type is 'LoadBalancer',Add DNS record to resolve external domain to load balancer ip\n  # when service type is 'Ingress', Add DNS record to resolve external domain to ingress controller external ip.\n  exportType: \"Ingress\"\n\n  # set node port paramers when service export type is NodePort, default 80 for http, 443 for https\n  nodePort:\n    http: 80\n    https: 443\n\n  # set load balancer ip when service export type is LoadBalancer, default auto obtain load balancer ip\n  loadBalancerIP:\n\n  # use custom https certificate switch, default false\n  # when useCustomCertificate is false,we will use self-signed certificate.\n  # when useCustomCertificate is true, set certificate in helm private.key and certificate.pem file\n  useCustomCertificate: false\n  customCertificate: \"\"\n  customPrivateKey: \"\"\n\n  # enable or disable MSF Monitor function, default 'false', set 'true' to open this function\n  enableMonitor: false\n\n  # enable or disable MSF Opentracing\n  enableOpentracing: false\n\n  # the count of nginx worker process per apigateway instance, default value is 1\n  worker_processes: 1\n\n  # the max tcp connections can a worker process supports, default value is 65535\n  worker_connections: 65535\n\n  # extral response http header of http server, now just for display Microservice Framework Server version info, default to 'Server:MSF-Server'\n  more_set_headers: \"Server:MSF-Server\"\n\n  # the max keep time duration when a tcp connection be in idle state, default to 300s\n  keepalive_timeout: 300s\n\n  # the max request count can a tcp connection processes, default value is 1000000\n  keepalive_requests: \"1000000\"\n\n  # resource quota\n  resources:\n    apigateway:\n      limits:\n        cpu: \"1\"\n        memory: \"1Gi\"\n        ephemeral-storage: \"1Gi\"\n      requests:\n        cpu: \"30m\"\n        memory: \"60Mi\"\n        ephemeral-storage: \"100Mi\"\n    apigatewayConfig:\n      limits:\n        cpu: \"200m\"\n        memory: \"500Mi\"\n        ephemeral-storage: \"100Mi\"\n      requests:\n        cpu: \"30m\"\n        memory: \"60Mi\"\n        ephemeral-storage: \"100Mi\"\n    dnsServer:\n      limits:\n        cpu: \"20m\"\n        memory: \"30Mi\"\n        ephemeral-storage: \"100Mi\"\n      requests:\n        cpu: \"5m\"\n        memory: \"5Mi\"\n        ephemeral-storage: \"10Mi\"\n    registry:\n      limits:\n        cpu: \"200m\"\n        memory: \"1Gi\"\n        ephemeral-storage: \"500Mi\"\n      requests:\n        cpu: \"30m\"\n        memory: \"60Mi\"\n        ephemeral-storage: \"100Mi\"\n\n# micorserivce framework 3rd service\netcd:\n  enabled: true\n\nkafka:\n  enabled: true\n\nredis:\n  enabled: true\n",
      "createdAt": "2021-12-16T17:21:54.185405+08:00",
      "updatedAt": "2022-02-14T16:43:07.710351+08:00"
    }
  ],
  "error": null,
  "path": "/v1/deployment/Microservice-Framework/plan/Standard?datacenterCode=bj",
  "status": 200,
  "timestamp": "2022-03-11T03:05:17+0000",
  "totalCount": 1
}
```

**[ :point_up_2: API概览 ](#API概览)**

**[⬆ top](#上架整合文档)**
