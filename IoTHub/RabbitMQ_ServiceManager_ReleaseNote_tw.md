# Release Notes

[Highlight release note for rabbitmq service manager (rabbitmq-sm)](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/projects/rabbitmq-service-broker/roadmap)

## 1.0.24
### Fix
   - Bug #19503: 當 ops credentials 表格中有2個以上 shared_use 為 true 時，執行 share provision 會拿到不 mapping 的 host 與帳密資訊
     同為舊版問題，1.0.22 只同步了帳密資訊, 其連線使用的 internal host 也必須同步不然也會機率出錯(視pg環境而有所不同)，於該版修正此問題。
​
## 1.0.22
### Fix
   - 修正舊有淺在問題 (from v1.0.4)，當 ops pg credentials table 內若同時包含 shared 以及 dedicated 連線信息時, 在做 shared provision 的時候拿取 rabbitmq 連線信息時 sql query 語句不嚴謹, 會因 pg 內部排序規則而不同, 導致有可能會拿到錯誤的帳密信息。

## 1.0.21
### Add
   - Requirement #18016: addition API 增加檢查輸入的帳號是否具有足夠權限
   - Requirement #17871: 根據一體機文件，新增 api 修改 cluster IP 設定, 並且需檢查是否為 administrator 權限
   - Suggestion #17997: 建議將 configMap 參數值和 ops 數據庫帳密移到 deployment 中
### Fix
   - Bug #13696: 呼叫 Manual addition API parameters 中的任一參數填寫空值" ")成功，將造成 provision 或 binding 失敗，應強制填寫必須參數
   - Bug #17974: 刪除default values且注入config後，Pod create container config失敗，日誌顯示無法從ConfigＭap取得參數
   - Bug #17956: 注入的esm config參數名稱和default value不一致
   - Bug #17954: 注入 esm config 後，馬上呼叫 API 失敗，返回502，未顯示sm init log, 需等待下才會正常啟動
   - Bug #18050: PATCH /v2/serviceInstances/{instance}/info 返回格式錯誤，無法透過 service hub api 更改連線資訊
   - Bug #17964: 在無法連接 ops postgres 數據庫時，Get healthz api 返回 404, 建議返回 503
​
## 1.0.20
### Add
   - 整合 ECM 更新環境變數
   - 新增健康檢查功能: k8s 透過 livenessprobe 定期呼叫 healthz api 確認 ops db 是否正常
   - 整合 CICD 自動 build image 並上 harbor

## 1.0.19
### Add
   - 新增查詢 vhosts 及 instanceId 對應關係之 API

## 1.0.18
### Fix
   - Bug #16419: Recover instance，會修改數據庫中其他instance的parameters欄位instance_id資訊
​
## 1.0.17
### Add
   - 新增 db migration 檢查腳本讓 sm 舊版本 db 欄位資料符合新版需求

## 1.0.16
### Fix
   - Bug #16245: Dedicated bind (未輸入vhost參數)，返回504 Gateway Time-out
   - Bug #16114: 延伸議題: 處理 recovery api 在新舊版本 sm 的相容問題

## 1.0.15
### Update  
   - Requirement #16239: 移除 Update pnQuantity API 返回 dashboard_url 資訊
​
## 1.0.14
### Fix
   - Bug #16114: 使用舊版本(v1.0.10) 建立的instance/ binding_id，無法在新版本(v1.0.13) bind、unbind、update pnQuantity 或  deprovision成功
   - Bug #14155: standard bind 時創建非 management 權限的使用者帳號成功 (如：administrator)
   - Bug #16094: 當 topic 權限只設定一個時(rmqTopicRead或rmqTopicWrite)，RabbitMQ management portal 顯示使用者未設定權限，但API返回資訊顯示權限設定成功
   - Bug #14935: bind 時將使用者權限設定為管理者tag，返回資訊中 dashboard_url, http_api_uri, http_api_uris 為 internal_host資訊
### Update  
   - Requirement #13721: 部署 app 不新增預設的 credential

## 1.0.13
### Add
   - 新增 api: /v2/convert/{instance_id}, 返回轉換為 shortId 後的 instanceId 以方便查詢
### Fix
   - Bug #14935: bind 時將使用者權限設定為管理者tag，返回資訊中 dashboard_url 為 internal_host 資訊
   - Bug #14292: Update API未返回dashboard_url，更新 pnQuantity 用量後，service portall 無法點擊 instance 開啟 rabbitmq management
   - Bug #15768: ops-postgres數據庫中紀錄轉換後的instance_id和 bindind_id，使用此id無法成功 deprovision 和 unbind
### Update
   - Requirement #15004: [PATCH] /v2/service_instances/{instance_id} 會判斷料號確認是否更新 pnQuantity
   - Requirement #15769: ops-postgres 數據庫中需紀錄 instance_id和binding_id 轉換後的使用者資訊
​
## 1.0.12
### Fix
- Bug #15768: ops-postgres 數據庫中紀錄轉換後的 instance_id 和 bindind_id，使用此 id 無法成功 deprovision 和 unbind
### Update
- Requirement #15769: ops-postgres 數據庫中需紀錄 instance_id 和 binding_id 轉換後的使用者資訊
​
## 1.0.11
### Fix
- Bug #14718: 返回資訊的參數名稱與 API 參數名稱格式不同 (addition)
- Bug #14935: bind 時將使用者權限設定為管理者 tag，返回資訊中 dashboard_url 為 internal_host 資訊
### Update
- 因應 MQTT username/passoword 對於某些設備有長度過長問題, 對 instance id 以及 bindind id 轉換成短 id 
- 在做 binding 時, 讓 rmqTopicRead/rmqTopicWrite 可以支援綁定多組 topic (逗號隔開)

## 1.0.10
### Fix
-Bug: 修正 bind 的時候 http_api_uri 會返回兩個 port 的問題

## 1.0.9

### Fix
-Bug: 在做 shared provision 以及 dedicate addition 的時候 dashboard url 轉為回傳 external host

## 1.0.8
### Fix
-Bug: 改為只透過INTERNAL_HOSTS檢查是否與rmq server有連上
-Bug: 修正http_api_uri port重複

## 1.0.7
### Fix
-Bug: binding api 的參數改為駝峰式 rmq_role->rmqRole, rmq_topic_read->rmqTopicRead, rmq_topic_write->rmqTopicWrite 

## 1.0.6
### Fix
-Bug: dedicated manual 返回的dashboard url 從string改為json格式

## 1.0.5
### Fix
<!-- - Bug #13696: 呼叫Manual addition API(parameters中的任一參數填寫空值" ")成功，將造成provision或binding失敗，應強制填寫必須參數 -->
- Bug #13725: 輸入錯誤pnQuantity參數值類型(如：abc)或未填寫pnQuantity參數，呼叫shared provision 返回503
<!-- - Bug #14028: 新增Manual addition時(username或password參數填寫空值、未填寫或參數未填寫)，返回503 -->
- Bug #14030: Standard bind (未輸入parameters) 返回 Response code: Non HTTP response code: org.apache.http.NoHttpResponseException
- Bug #14034: impersonator帳號權限無法登入RabbitMQ management，Bind返回資訊不須包含dashboard_url、http_api_uri、http_api_uris 、management、management+ssl
- Bug #14039: Dedicated bind 權限設定(role) 與standard plan 不一致(rmq_role)
- Bug #14042: Dedicated bind 無法設定 "rmqTopicRead"和"rmqTopicWrite" Topic權限
- Bug #14048: Dedicated bind 建立的administrator權限帳號，無法登入RabbitMQ management portal (返回錯誤的username)
- Bug #14056: application_name (在ops postgresql的url字串) 顯示mongodb-sm
- Bug #14061: 建立addition時，未檢查INTERNAL_IPS和EXTERNAL_IPS連線，使用者可能無法連線
- Requirement #13686: [Chart] 移除values.yaml中不需要的環境變數
- Requirement #13695: 新增Manual addition時，確認internal_hosts連線成功且RabbitMQ server連線失敗時返回503
<!-- - Requirement #13885: 不檢查binding_id是否存在，deprovision 可執行成功 (改由service hub直接管控) -->

## 1.0.4
### Fix
- Bug #13700: 建立的vhostName名稱僅支援0-9,a-z,A-Z以及 - (非字首)
- Bug #13722: 建立Manual addition時設定internalHosts為錯誤參數值，呼叫shared provision API或dedicated bind API 返回No response
- Bug #13793: Provision(recover) 1000個instances，其中3次失敗後，再次呼叫API仍無法recover，返回503 ErrorMessage: Vhost already exist
- Bug #13815: Dedicated bind 無法設定使用者權限，預設為management
- Bug #13818: Dedicated bind (未輸入parameters) 返回400 error: {\"error\":\"bad_request\",\"reason\":\"Validation failed\\n\\n0 is not a valid queue expiry\\n\"}"
- Bug #13819: 呼叫Update API (parameters參數內無更新資訊)，返回200
- Bug #13820: 呼叫Update API (未輸入parameters參數)，返回400 error:{\"error\":\"bad_request\",\"reason\":\"Validation failed\\n\\n0 is not a valid queue expiry\\n\"}
- Bug #13826: Catalog返回資訊中的plan名稱和metadata bullets參數"standard"和"Dedicated"大小寫不一致
- Bug #13829: 呼叫provision API (未填寫pnQuantity參數或填寫錯誤的值)，vhost的max-connections和max-queues為0
- Bug #13853: vhost刪除後，bind 返回400 vhost_or_user_not_found，但 rabbitmq management user已建立
- Bug #13860: bind時將使用者權限設定administrator,monitoring，返回資訊沒有dashboard_url, http_api_rui, http_api_uris
- Bug #13861: 使用者權限為monitoringr帳號無法登入RabbitMQ management
- Bug #13879: Dedicated addition建立成功後未返回dashboard_url
- Bug #13883: 不同的dedicated instance綁定相同vhostName成功
- Bug #13888: Bind時role參數帶management ，protocol 返回資訊中無management和management+ssl協定
- Bug #13998: Dedicated bind (vhostName參數填寫空值" ")，返回201，vhost名稱隨機創建成功
- Requirement #13662: [Chart] 部署Go 版本app名稱顯示rabbitmq-sm，以區分3.0版本rabbitmq-service-broker

## 1.0.3
### Add
- 支援dedicated
- 新增update api
- 新增shared addition api
- 新增dedicated manual addition api
- 新增resources list api
- 使用opsdb紀錄關聯性
