# 計量服務

[TOC]

- 調用計量服務來推送PAYG（Pay As You Go）服務的用量
- 用量資用透過AMQPS(TLS/SSL encrypted AMQP)傳送
- AMQPS連線資訊可透過MG（Metering Gateway）取得（需使用SSO Clinet Token認證）
- 透過綁定指定的Routing key獲取統計完成的用量

## 用量發佈

###  Exchange與Routing Key

| Exchange | Routing Key            | 說明                          |
| -------- | ---------------------- | ----------------------------- |
| ensaas   | production.[pn].usages | [pn]（不含[]）為service的料號 |

### 訊息格式

```json
{
"pn": "<string>",
"time": ms,
 "usages": [{
  "consumerId": "<string>",
  "measuredUsage": [{
   "measure": "<string>",
   "quantity": double
  }...]
 }]
}
```
### 參數說明
| 名稱       | 類型   | 是否必選 | 示例值        | 描述              |
| ---------- | ------ | -------- | ------------- | ----------------- |
| time       | int    | 是       | 1562554500000 | EPOCH Time ms格式 |
| pn         | string | 是       |               | 料號              |
| usages     | array  | 是       | "usages":[{"consumerId":"fa78a46b-027c-4dd3-bd1a-4ab116c39e89","measuredUsage":[{"measure":"disk","quantity":20},{"measure":"calls","quantity":10}]}] |                   |
| consumerId | string | 是 | fa78a46b-027c-4dd3-bd1a-4ab116c39e89 | Instance唯一的識別ID |
| measuredUsage           | array | 是 | "measuredUsage":[{"measure":"disk","quantity":20},{"measure":"calls","quantity":10}]] |   量測的用量值                  |
| measure           | string | 是 | disk |     量測值的名稱，對應到metric，measure由英數字與符號“.”組合而成，“.”與數字只能用在字中，不可用於字首與字尾              |
| quantity           | float | 是 | 10.5 |    量測的用量                |

## 統計結果獲取
綁定指定的Routing Key，當發佈完用量後，可以由指定的routing key獲取統計後的結果。

### Exchange與Routing Key

| Exchange | Routing Key            | 說明                 |
| -------- | ---------------------- | -------------------- |
| ensaas   | mg.usages.[pn].hourly  | 該筆用量所在小時用量 |
| ensaas   | mg.usages.[pn].daily   | 該筆用量所在當日用量 |
| ensaas   | mg.usages.[pn].monthly | 該筆用量所在當月用量 |

### 訊息格式

```json
{
"pn": "<string>",
"time": ms,
 "usages": [{
  "consumerId": "<string>",
  "measuredUsage": [{
   "measure": "<string>",
   "quantity": double
  }...]
 }]
}
```
### 參數說明

| 名稱       | 類型   | 是否必選 | 示例值        | 描述              |
| ---------- | ------ | -------- | ------------- | ----------------- |
| time       | int    | 是       | 1562554500000 | EPOCH Time ms格式 |
| pn         | string | 是       | 980GEDMA001 | 料號              |
| usages     | array  | 是       | "usages":[{"consumerId":"fa78a46b-027c-4dd3-bd1a-4ab116c39e89","measuredUsage":[{"measure":"disk","quantity":20},{"measure":"calls","quantity":10}]}] |                   |
| consumerId | string | 是 | fa78a46b-027c-4dd3-bd1a-4ab116c39e89 | Instance唯一的識別ID |
| measuredUsage           | array | 是 | "measuredUsage":[{"measure":"disk","quantity":20},{"measure":"calls","quantity":10}]] |   量測的用量值                  |
| measure           | string | 是 | disk |     量測值的名稱，對應到metric，measure由英數字與符號“.”組合而成，“.”與數字只能用在字中，不可用於字首與字尾              |
| quantity           | float | 是 | 10.5 |    量測的用量                |

## 示例

### 用量發佈

```json
{
    "time":  1562554500000,
    "pn": "980GEDMA001",
    "usages": [{
            "consumerId": "fa78a46b-027c-4dd3-bd1a-4ab116c39e89",
            "measuredUsage": [{
                    "measure": "disk",
                    "quantity":  20
                }, {
                    "measure": "calls",
                    "quantity":  10
                }
            ]
        }
    ]
}
```

### 統計用量獲取（時用量）

```json
{
    "time":  1562551200000,
    "pn": "980GEDMA001",
    "usages": [{
            "consumerId": "fa78a46b-027c-4dd3-bd1a-4ab116c39e89",
            "measuredUsage": [{
                    "measure": "disk",
                    "quantity":  250
                }, {
                    "measure": "calls",
                    "quantity":  100
                }
            ]
        }
    ]
}
```
