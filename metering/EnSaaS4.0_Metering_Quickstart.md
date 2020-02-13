# EnSaaS4.0 Metering快速整合



## 1.1 MA用量發佈格式與Routing Key
Exchange： ensaas
Routing Key：  production.[pn].usages，其中[pn]為service的料號


訊息格式：

```
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

## 1.2 MG發佈用量 

MG收到MA發佈的用量後，會將質算為時、日與月三種用量，並且將其透過以後Routing Key發佈。

| Routing Key            | 說明     |
| ---------------------- | -------- |
| mg.usages.[pn].hourly  | 小時用量 |
| mg.usages.[pn].daily   | 日用量   |
| mg.usages.[pn].monthly | 月用量   |

訊息格式：

```
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

其欄位格式說明如下：

| 欄位          | 說明                       |
| ------------- | -------------------------- |
| time          | EPOCH Time ms格式          |
| pn            | 料號                       |
| consumerId    | Instance唯一的識別ID       |
| measuredUsage | 量測的用量值               |
| measure       | 量測值的名稱，對應到metric |
| quantity      | 量測的用量                 |



## WISEPaaS 3.0 與 4.0 差異

相較於3.0，4.0的Request Json比照k8s，由原先的底線命名方式改為駝峰式的命名方式。

量測上由原先服務為單位改以料號為單位，並且取消了註冊程序。

量測的時間取消了start_time與end_time，改以單一time取代，並且將time移至外層，同一批量測的用量只需要帶一次時間即可。

用量的傳送由原先的Rest API方式改由AMQPS傳送，並且MG會將統計後的時、日、月用量透過AMQPS發送出來，以利服務進行用量的管控。

|項目|3.0|4.0|
|---|---|---|
|Request Body Json命名方式|底線|駝峰式|
|註冊|需要|無|
|**用量**|||
|End Point|/v1/collection/usagelist|無（改用AMQPS）|
|時間|start_time, end_time|time|
|服務名稱|service_name|pn|
|服務類型|service_type|無|
