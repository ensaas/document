# Servcie Hub 服務中心簡介

## 服務中心介紹  

應用程式部署於平台上，經常會需要使用存儲類型的數據庫服務或是提供數據傳輸類型的訊息佇列服務。EnSaaS 提供一套服務訂閱及管理機制 (Service Hub)，讓服務提供者可以上架托管服務，供其他用戶或是應用程式集成。  

服務上架需要由服務提供商提供Service Broker，Service Broker主要負責服務自動化服務管理，包含服務創建等管理功能。用戶訂閱服務時，由Service Hub協助串接商務流程，包含訂單系統及計費系統。  

用戶可以在Service Instance Management頁面中管理已經創建的服務實例，並且取得服務連線資訊。若用戶需要更詳細的資訊，例如服務資源用量，則需要服務提供商額外提供console頁面供用戶查看。

Service Hub 與其他元件關係如下圖所示，服務供應商只需提供灰色區塊

![](images/servicehub01.PNG)

---

## Service Hub API (console串接使用)
Service Hub API 採用駝峰方式撰寫，可以接受 basicAuth 、 bearerAuth 和 cookieAuth 三種認證方式(目前以bearerAuth為主)，  
目前可以查看API資訊的 Swagger 網址[請點我](http://service-hub-master.es.wise-paas.cn/swaggerui/dist/#) ，主要提供 Service Console UI 製作使用  
清單如下表：

| METHOD | URL | 用途 | 詳細內容說明 |
| -------- | ---------------------- | --------- | --- |
| POST | /v2/subscriptions/{subscriptionId}/serviceInstances | 建立一個instance | 訂閱時需要帶上 ServiceRequest 模組 |
| DELETE | /v2/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceId} | 刪除一個instance ||
| GET | /v2/subscriptions/{subscriptionId}/serviceInstances | 列出所有instance，可帶上條件查詢 | 可以帶上 serviceName、planName、datacenterCode、serviceInstanceName、deleted 做查詢，回傳 serviceResponse object 陣列 |
| GET | /v2/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceId} | 列出特定instance| 回傳 serviceResponse object |
| POST | /v2/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceId}/bindings  | 建立一個綁定和 secret | 綁定時需要帶上 BindRequest 模組 |
| DELETE | /v2/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceId}/bindings/{serviceBindingId} | 刪除一個綁定和 secret ||
| GET | /v2/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceId}/bindings/ | 列出所有綁定，可帶上條件查詢 | 可以帶上 secretName、serviceName、planName、clusterName、workspaceId、namespaceName、enableSecret、deleted 做查詢，回傳 bindingResponse object 陣列 |
| GET | /v2/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceId}/bindings/{serviceBindingId} | 列出特定的綁定 | 回傳 bindingResponse object |

#### ServiceRequest 模組
ServiceRequest 用於請求訂閱時使用，其詳細傳入內容如下：
| 參數名稱 | 類別 | 可以為空 | 詳細說明 |
|----|-----|----|----|
| serviceInstanceName | string | X | 由用戶命名的 service instacne 名稱，相同訂閱號下禁止重複，避免使用相同訂閱號下的使用者混淆認不清 |
| serviceCategory | string | O | 該服務的總類(查詢註冊資料取得)，目前有：EnSaaS、Common Apps、Industry App 這三種 |
| subscriptionId | string (UUID) | X | 使用者的訂閱號，會判斷該使用者是否有權限操作 |
| transactionId | string (UUID) | X | 該次訂閱的交易編號(目前預定由 catalog 產生，選擇卡片時會帶入) |
| serviceName | string | X | 使用者購買的服務名稱 |
| datacenterCode | string | X | 使用者當前所在的 datacenter 位置 |
| planName | string | X | 使用者選擇購買的該服務計畫名稱(查詢註冊資料取得)，可以從很多計劃中選擇但最後只能挑一個購買 |
| parameters | object | O | Service Broker 在上架的時候會註冊額外需要填上的參數的內容，可以去查詢註冊資料取得清單，顯示給使用者選擇後組成 json 物件帶入此參數中。 |

#### ServiceResponse 模組
ServiceResponse 用於查詢訂閱時的回傳內容，其詳細說明如下：
| 參數名稱 | 類別 | 詳細說明 |
|--------|----|---|
| serviceInstanceId | string (UUID) | Service 創建的唯一 UUID |
| serviceInstanceName | string | 此 instance 由使用者訂得服務名稱 |
| serviceCategory | string | 此 instance 所屬服務的總類 |
| subscriptionId | string (UUID) | 查詢此 instance 的訂閱號 |
| transactionId | string (UUID) | 此 instance 是由什麼交易ID所產生 |
| userId | string (UUID) | 購買此 instance 的人 |
| serviceName | string |  此 instance 的服務名稱 |
| datacenterCode | string |  此 instance 當前所在的 datacenter 位置 | 
| planName | string |  此 instance 的計劃名稱 |
| lifecycleStatus | string | 此 instance 的當前狀態，其狀態一共有四種，分別是{ Active (正常可使用), Inprogress (正在建立/刪除), Inactive (已刪除訂閱，但還在保留期間之內，可復原), None (已刪除訂閱且無法復原)} |
| status | string | 此狀態為 Service Hub 記錄，可不理會 |
| bindable | boolean | 此 instance 可不可以進行綁定的操作 | 
| createdAt| string | 此 instance 的建立時間 |
| updatedAt | string | 此 instance 的更新時間，例如：100 connection -> 200 connection |
| deletedAt | string | 此 instance 的解除訂閱時間 |
| usage | integer | 此 instance 的目前用量 |
| parameters | object | 訂閱的時候傳入的參數 |

#### BindingRequest 模組
BindingRequest 用於請求綁定時使用，其詳細傳入內容如下：
| 參數名稱 | 類別 | 可以為空 | 詳細說明 |
|----|-----|----|----|
| serviceInstanceId | string (uuid) | X | 訂閱服務時所產生的ID |
| serviceInstanceName | string | O | 此 instance 由使用者訂閱時得服務名稱  |
| serviceCategory | string | O | 此 instance 所屬服務的總類 |
| subscriptionId | string (uuid) | X | 當前使用者的訂閱號 |
| serviceName | string | X | 此 instance 的服務名稱 |
| planName | string | O | 此 instance 的計劃名稱 |
| secretName | string | X | 使用者自定義的 secret 名稱，定義名稱的時候會依照"密鑰"章節的規則來判斷是否合法，特定情況時用戶的 secret 會不允許被建立 |
| enableSecret | boolean | X | 當此參數值為true時，創建綁定時會檢查 clusterName 、workspaceId 和 NamespaceName 是否合法，若合法會將 secret 建立至所屬 namespace 中；當此參數值為false時，不會檢查參數，且不會建立 secret。 |
| clusterName | string | O | 此用戶想要建立 secret 之 clusterName |
| workspaceId | string (uuid) | O | 此用戶想要建立 secret 之 workspaceId |
| namespaceName | string | O | 此用戶想要建立 secret 之 NamespaceName |
| parameters | object | O | 對於綁定時所需要的額外參數需求 |

#### BindingResponse 模組
BindingResponse 用於查詢綁定訂閱時的回傳內容，其詳細說明如下：
| 參數名稱 | 類別 | 詳細說明 |
|--------|----|---|
| serviceBindingId | string | 此次 secret 建立出來的綁定ID | 
| secretName | string | 此 secret 的使用者自定義名稱，若有建立 secret 也會是 secretName 名稱 | 
| serviceInstanceId | string | 此 binding 的 instance ID | 
| serviceInstanceName | string | 此 binding 的 instance 名稱 | 
| serviceCategory | string | 此 instance 所屬服務的總類 | 
| subscriptionId | string | 當前使用者的訂閱號 | 
| userId | string | 執行此 binding 的人 | 
| serviceName | string | 此 instance 的服務名稱 | 
| datacenterCode | string | 此 instance 當前所在的 datacenter 位置 | 
| planName | string | 此 instance 的計劃名稱 | 
| enableSecret | boolean | 當初建立綁定時的 flag 狀態 | 
| clusterName | string | 當初建立綁定時 clusterName 位置 | 
| workspaceId | string | 當初建立綁定時 workspaceId 位置 | 
| namespaceName | string | 當初建立綁定時 namespaceName 位置 | 
| status | string | 此狀態為 Service Hub 記錄，可不理會 | 
| createdAt | string | 此 binding 的建立時間 | 
| updatedAt | string | 此 binding 的更新時間，例如：更新postgresql group | 
| deletedAt | string | 此 binding 的刪除時間 | 
| parameters | object | 當初建立綁定時所帶入的參數 | 
| credentials | object | 綁定時取得的 credentials 資訊 | 

## Service Broker 教學
Service Broker 是由很簡易的幾支 rest API 所組成，它的角色類似為服務提供與資源池的中介者，  
Service Broker 一方面向服務使用者提供資源調用的方法，讓用戶透過訂閱/綁定/解綁/退訂...等 API 操作資源池，  
而另一方面就是後端實現了實際管理與操作，不限定任何程式語言開發，  
其詳細的 API 接口可以參考最新的[設計規格說明](https://github.com/openservicebrokerapi/servicebroker "v2.15")，以下先將重點最基本的 API 列出來整理下：  

### 最基本需要有的API
| METHOD | URL | 用途 | 詳細內容說明 |
| -------- | ---------------------- | --------- | --- |
| GET | /v2/catalog | 填寫註冊用的服務訊息 | 該API會回傳一個特定組好的 services 結構，包含您的服務唯一ID、服務名稱、計劃唯一ID、計劃名稱，以及這個計畫需要的費用資訊，版本編號，最簡易的回傳範例如下：|
```
"services": {
  "id": "exampleId",  //全平台唯一服務ID
  "name": "example",  //服務名稱
  "description": "this service is example", //服務描述
  "tags": [ //標籤
    "service-example" //標籤內容
  ],
  "bindable": true, //有沒有綁定的功能 (必填)
  "plans": [ //提供的計劃列表
    {
      "id": "planId",  //全名台唯一計劃ID
      "name": "plan",  //計劃名稱
      "description": "this plan is example" //計劃描述
    }
  ]
}
```
| METHOD | URL | 用途 | 詳細內容說明 |
| --- | ----------- | --- | --- |
| PUT | /v2/service_instances/{instances_id} | 訂閱服務  | 通知資源池做個準備的動作，準備一個可以提供給用戶使用的空間，以 DB 服務為範例，這支 API 被成功觸發的時候，會去資源池建立出一個 database，準備提供給需要綁定的用戶使用 |
| DELETE | /v2/service_instances/{instances_id} | 刪除服務 | 通知資源池不再使用這資源，以DB服務為範例，這時可以把訂閱時創建的database刪除 |
| PUT | /v2/service_instances/{instances_id}/service_bindings/{binding_id} | 建立綁定 | 綁定的動作通常被用來讓用戶向Service broker獲取連線資訊，以 DB 服務為範例，這時會新增一位使用者並賦予他操作訂閱時的 database 權限，回傳訊息必須包含 credentials 的物件(即使為空值) |
| DELETE | /v2/service_instances/{instances_id}/service_bindings/{binding_id} | 刪除綁定 | 刪除綁定的動作通常被用於暫停使用的功能，需要保留再次觸發綁定功能後可以進行重新綁定，其本身訂閱的資訊未刪除，以 DB 服務為範例，這時會將用戶登入權限移除，但是 database 狀態仍舊維持一樣，沒有釋放資源 |

以上表格的前三支是 Service Broker 最基本需要有的 API ( catalog 中 bindable 設定為 false 就可以不用有綁定 API)，  
有這幾支基本 API 且完成其相對應邏輯，就可以向 Service hub 進行註冊。

### Service Broker 進階 API
| METHOD | URL | 用途 | 詳細內容說明 |
| -------- | ---------------------- | ------------ | --- |
| GET | /v2/service_instances/{instances_id}/last_operation | 查詢某訂閱號的訂閱結果 | 有時候訂閱時的準備動作無法在一瞬間完成，因此提供了異步的操作，當訂閱的時候是回傳 202 Accept 時，需要提供此 API 讓前端詢問狀態，其狀態總共有3種：in progress、succeeded和failed，需要回傳當前訂閱號狀態。|
| GET | /v2/service_instances/{instances_id}/service_bindings/{binding_id}/last_operation | 查詢某訂閱號下的某綁定號的綁定結果 | 有時候綁定時的建立關係動作無法在一瞬間完成，因此提供了異步的操作，當綁定的時候是回傳 202 Accept 時，需要提供此API讓前端詢問狀態，其狀態總共有3種：in progress、succeeded和failed，需要回傳當前綁定號狀態 |
| PATCH | /v2/service_instances/{instances_id} | 更新服務 | 提供這支 API 之前，需要在 catalog 下設定服務是可以被更新的( "plan_updateable" boolean)，當plan_updateable 設定為 true 時，若有更新需求，Service Hub 會透過此API進行更新動作|

Service Broker 的規格是全球共通的，完成後能使用的將不會只有限定在 WISE-PaaS 上，  
相對的，若是有在其他平台上的 Service Broker，也可以透過註冊的方式，  
不需要任何改動的將服務放到平台上。

---
## 服務註冊/上架
### 如何將 Broker 註冊到 Service Hub 中

完成後的 Broker 會是一支可執行的程序，可以將它佈署到平台空間中運行，  
也可以放置在網路可以連接到的任意位置，需要和 Service Hub 完成註冊的動作即可，  

#### 註冊服務時需要在註冊API的內容提供以下參數：

| 參數名稱 | 定義         |
| -------- | ------------ |
| serviceName   | service名稱，service名稱全平台唯一，服務名稱由字母、數字、"-"、"."組成，區分大小寫，不可含有空格，空格可用"-"替代，不可含有特殊字符。例如：MongoDB、Dashboard、APM、EnSaaS-K8s-Service、APM-CNC等 |
| serviceVersion | 服務的版號，以 MongoDB 為例：3.6.6 |
| planName | service plan 名稱，service plan 方案名稱由字母、數字、"-"、"."組成，區分大小寫，不可含有空格，空格可用"-"替代，不可含有特殊字符。同一個 serviceName 的服務不可以有相同的 planName，不同的 serviceName 可以有同樣的 planName，以 MongoDB 為例：Shared、Dedicated 兩種 planName，以 PostgreSQL 為例：可分為 Shared、Dedicated 兩種 planName。|
| serviceBrokerUrl | 完整帶驗證的 Service Broker 連線資訊，其內容為：https://\<username\>:\<password\>@\<endpoint\>，以 MongoDB SB 為例：https://user:password@mongodb-sb.wise-paas.com |
| extraParam | 創建服務時可以帶入額外參數，固定使用 json 格式，以 MongoDB SB 為例：'{"operation":[1000,2000,3000]}'，以 IotHub SB 為例：'{"connection":[100,200,300]}'，註冊的時候寫上可以讓 Service Hub 被呼叫訂閱的時候預設以 json 格式帶入陣列中的第一個值。 |
| releaseNote | 關於此 Broker 的版本訊息，以 MongoDB SB為例："Service Borker v2.1 版本新增跨平台功能，修正bug #123454 "|

雖然目前此部分仍先是以文件註冊為準，未來預計 Service Hub 註冊一定會有提供 API 接口，  

#### 規劃中 & 開發中的 API 接口 (可能會有所更動)  
| METHOD | URL | 用途 | 詳細內容說明 |
| -------- | ---------------------- | ------------ | --- |
| POST | https://service-hub-master.\<domain\>/v2/servicePublisher | 註冊 service broker| 將上述參數組成 json 帶入 body 中呼叫，範例如下：
```
curl -X POST "http://service-hub-master.\<domain\>/v2/servicePublisher" -H "accept: application/json" -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d 
{
  "serviceName": "MongoDB",
  "serviceVersion": "3.6.6",
  "planName": [
    "Shared",
    "Dedicate-Small"
  ],
  "serviceBrokerUrl": "https://user:password@mongodb-sb.wise-paas.com",
  "extraParam": {
    "operation": [
        1000,
        2000,
        3000
    ]
  },
  "releaseNote": "Service Borker v2.1 版本新增跨平台功能，修正bug #123454 "
}
```
| METHOD | URL | 用途 | 詳細內容說明 |
| -------- | ---------------------- | ------------ | --- |
| PUT | https://service-hub-master.\<domain\>/v2/servicePublisher | 更新註冊訊息 | 同上將更新後的 json 帶入 body 信息中傳遞。 |
| GeT | https://service-hub-master.\<domain\>/v2/servicePublishers | 取得已註冊的詳細資訊 | 使用此 API 可以查詢全部已註冊的服務訊息，帶上 query 可以查詢特定 serviceName、planeName 的訊息 | 
| Delete | https://service-hub-master.\<domain\>/v2/servicePublishers/{serviceName} | 取消註冊 | 將服務下架，平台將不再提供此 Service Broker 和其資源 |

---
### Service Hub 如何讀取 Broker 訊息
服務來和 Service Hub 註冊時，會進行以下步驟來做檢查：  
1. 判斷 serviceName 是否有重複，必須全服務唯一，有重複會失敗並跳出警告。
2. Service Hub 會讀取 Broker /v2/catalog 的內容並解析，檢查有沒有漏填的必填項目，有漏填會失敗並跳出警告。
3. 讀取必須是全平台唯一的 service id 和 plan id，判斷是否有衝突，有重複會失敗並跳出警告。
4. 紀錄註冊訊息與註冊時間、狀態於DB中。

---
### 如何實現訂閱/綁定時帶入參數功能
註冊時帶入的 extraParam 內容，會在訂閱的時候已預設的參數陣列中的第一個值傳入Service Broker 中，  
如果需要更改傳入的參數內容，UI上面需要提供用戶選項，  
其選項內容就是該參數值的陣列內容，以 MongoDB 的 SB 來說，可能會像這樣：  
```
operation: [1000] ^ (下拉選單)
           [2000] |
           [3000] v
```  
選擇完成後在訂閱時以 json 格式整理並帶入Service Hub API 中

---
### 如何處理同步/異步功能
依據 open service broker api spec， 訂閱/綁定時回傳 202 Accept 會進入異步處理流程，  
此時 Service Hub 會以每30秒的時間向 Service Broker 詢問訂閱/綁定異步的結果(透過進階 Broker API 表格中有last_operation 的 API)，  
會根據不同的回傳結果而做出不同處理，處理方式如下表：
| 狀態碼 | 回傳訊息 | 處理方式 |
|-------|-------|------|
| 200 | "state":"in progress" | instance 狀態為 in Progress 等待30秒後再次詢問 | 
| 200 | "state":"succeeded" | instance 狀態為成功可使用，Service Hub 紀錄並取消詢問 |
| 200 | "state":"failed"| instance 狀態為失敗且不可使用，Service Hub 紀錄並取消詢問 |
| 4xx | error message | instance 狀態為失敗且不可使用，Service Hub 會詢問兩次，若第二次仍然失敗，會紀錄並取消詢問
| 5xx | error message | instance 狀態為失敗且不可使用，Service Hub 會詢問兩次，若第二次仍然失敗，會紀錄並取消詢問

---
## 建立密鑰
Service Hub 綁定的時候，可以透過 enableSecret 選擇是否要建立secret，  
* enableSecret = true (建立secret到 namespace 中)
* enableSecret = false (不建立 secret 但可以取得 credentials 內容)  

關於建立secret有些規則，  
* 不同 serviceName 不同 secretName 不同 namespace 的服務會將分開建立。
* 不同 serviceName 不同 secretName 相同 namespace 的服務會將分開建立。
* 不同 serviceName 相同 secretName 相同 namespace 的服務會將 secret 寫在一起，並且以ENSAAS_SERVICES 為 key 把 credentials 內容組合加密後放入，如下：
```
{"ENSAAS_SERVICES":"<base64 string>"}
```
* 相同 serviceName 不同 secretName 不同 namespace 的服務會將分開建立。
* 相同 serviceName 不同 secretName 相同 namespace 後來的 secret 不給予建立(沒意義且重複內容)，但是可以進行綁定(用途: dccs)。
* 相同 serviceName 相同 secretName 相同 namespace 的服務將不給予建立 secret。(沒意義且重複內容)