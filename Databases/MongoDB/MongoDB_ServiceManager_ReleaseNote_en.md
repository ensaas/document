# Release Notes

![Version](https://img.shields.io/badge/latest-1.0.28-green)

Highlight release note for mongodb service manager (mongodb-sm)

## 1.0.28

### Fixes

- (Reopened)Cluster Quota API 顯示 dedicated datacenter_code 且 Quota 資訊錯誤

## 1.0.27

### Fixes

- Cluster Quota API 顯示 dedicated datacenter_code 且 Quota 資訊錯誤

## 1.0.26

### Fixes

- Cluster Quota API 只顯示已建立 instance 的 datacenter_code Quota 資訊, 沒有 instance 的 datacenter_code 未顯示

## 1.0.25

### Requirement

- New API: Cluster Quota
- (Revised) Add 'deleteData' parameter into deprovision function

### Fixes

- 當有多個 binding_id(第一個 status 為 deleted，其餘 binding)，執行 deprovision 成功

## 1.0.24

### Requirement

- [Deprovision has parameter 'deleteData'](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13371)
- [MAX_INSTANCE_PER_DB = -1 indicates no instance limit is set on shared](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13372)
- [Recover manual addition not required pseudoId](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13386)
- [MongoDB "(UserNotFound) User '\<username\>@\<password\>' not found" should pass](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13401)
- Add swagger

### Fixes

- [恢復 Dedicated instance (填 pseudoId,instanceId, organizationId, spaceId 參數值)，返回 503 error parsing uri: must have at least 1 host](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13172)

## 1.0.23

### Fixes

- [Credentials 資訊在 mongodb ha 時，綁定時需要返回 replicaSetName 資訊](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13138)

## 1.0.22

### Fixes

- [當 databaseName:""未填寫值，呼叫 dedicated bind 失敗，返回 400 invalid value on databaseName](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13100)

## 1.0.21

### Fixes

- [Dedicated instance 無法 deprovision，返回 503 error":"pq: current transaction is aborted, commands ignored until end of transaction block](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13081)

## 1.0.20

### Fixes

- Put handling error on onDeprovision join table

## 1.0.19

### Requirement

- Change json data type from string to int for ‘port’ and ‘portX’ for binding API.
- [deprovision dedicated instance，不更新 deployment 資料表的 deleted_at 資訊](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13076)

### Fixes

- [當有多個 binding_id(第一個 status 為 deleted，其餘 binding)，執行 deprovision 成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13071)

## 1.0.18

### Fixes

- [當 ops-posgresql 取名為非 mongodb 數據庫名稱，執行 shared instance 自動刪除的失敗，日誌顯示 permission denied](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13000)
- [使用已刪除的 shared instance(detached 或 deleted)binding，返回 410 unable to recover](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12996)
- [auto delete crash, 日誌顯示 2020-03-32T01:00:00 day out of range](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12986)
- [deployment 資料表的 created_at 欄位名稱錯誤(create_at)](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12975)
- [建立 instance 到達 datacenter 上限並更新 1 個 instance status 為 deleted 後，無法建立 instance 成功，返回 507 given datacenterCode reached the limit](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12967)

## 1.0.17

### Requirement

- [移除 accepts_incomplete 參數](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12945)

### Fixes

- [建立 instance 直到超過可創建上限值，返回 507 no database found](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12933)
- [當 instance 狀態為 error，呼叫 deprovision API，返回 404](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12633)

## 1.0.16

### Fixes

- semver 0.x.xx -> 1.x.xx
- [dedicated bind 建立 DatabaseName 為非 0-9/a-z, A-Z 數據庫名稱成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12858)
- [edicated bind 建立 DatabaseName 為 admin, config (mongodb 預設資料庫名稱)成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12857)
- Update helm chart

## 0.1.15

### Fixes

- [呼叫 Provision API，返回 507 sql: no rows in result set 無法建立 shared instance](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12834)

## 0.1.14

### Fixes

- [綁定相同數據庫後呼叫 Get resources list API，列出重複的數據庫名稱](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12798)
- [當 dedicated instance 狀態為 deleted 時，恢復 instance，返回 410 error "Gone"](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12784)

## 0.1.13

### Fixes

- [當 instance 狀態為 error 時，呼叫 Update_dedicated addition API，返回 503 update rows affected 0](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12747)
- [當 app 執行自動刪除數據庫時，app cpu 用量增加至 request 資源上限且執行後 cpu 用量未被釋放](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12726)
- [當 instance 狀態為 error，呼叫 deprovision API，返回 404](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12633)
- [關閉 mongodb 服務後，呼叫 provision/ bind/ unbind API，返回 400, 500 或 404 context deadline exceeded](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12622)
- [當 dedicated instance 狀態為 deleted 時，恢復 instance，返回 409 instance_id is in use](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12620)
- [使用非創建 instance 的 datacenterCode ，恢復 instance 成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12615)
- [成功新增超過上限值的 instances (例如: MAX_INSTANCE_PER_DB as 3, 成功新增 4 個 instances)](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/11132)

## 0.1.12

### Fixes

- [當 app 執行自動刪除數據庫時，App crash](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12636)
- [當 instance 狀態為 error，呼叫 deprovision API，返回 404](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12633)
- [使用錯誤的 internalHosts 建立的 instance，執行 bind，返回 500](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12627)
- [關閉 ops-postgresql 服務後，呼叫 API，返回 500 dial tcp 61.219.26.46:32129: connect: connection refused](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12624)
- [關閉 ops-postgresql 服務後，呼叫 API，返回 500 dial tcp 61.219.26.46:32129: connect: connection refused](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12623)
- [恢復 dedicated instance 後，deployment 表格建立新的部署資訊(未更新原資訊的 update_at)](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12621)
- [當 dedicated instance 狀態為 deleted 時，恢復 instance，返回 409 instance_id is in use](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12620)
- [當 instance 狀態為 running 時，呼叫 Update_dedicated addition API，返回 200(instance 狀態未更新)](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12619)
- [使用非綁定時的 instance_id，unbindt 成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12617)
- [建立 dedicated instance 後，dedicated_instance 表格中的 instance_parameters 仍為空值](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12616)
- [使用非創建 instance 的 datacenterCode ，恢復 instance 成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12615)
- [恢復 binding 後，unbinding_time 未清除](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12614)
- [執行 provision-deprovision(5 線程\_5 分鐘)期間，app crash](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12600)
- [[API] 呼叫 Update dedicated manual(未輸入 plan_id)，返回 Non HTTP response message: \<IP\> failed to respond](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12594)
- [呼叫 Update dedicated manual(plan_id 輸入"", " "或不正確的值)，返回 404](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12592)
- [[API] 呼叫 Provision API (輸入 instance_id 超過 50 字元上限)，返回資訊 instance_id 拼寫錯誤"isntance_id"](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12589)

## 0.1.11

### Fixes

- [執行 bind/unbind 1000 次，約 30 次返回 pg: sorry ,too many clients already](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12581)
- [Initial credentials "status"為空值](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12580)
- [[API] 呼叫 Unbind API (填寫不存在的 instance_id 或 binding_id)，返回資訊 instance_id is not found,description:""](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12565)
- [[API] 呼叫 Manual addition API(password 輸入超過 50 上限值)，返回資訊 username value has exceeded char limit](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12560)
- [呼叫 Manual addition API(databaseName 填寫" "或參數值超過 50 字元)，返回資訊中的參數名"database"與實際不相符](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12557)

## 0.1.10

### Requirement

[建立 instance 時，傳入的 datacenterCode 值需要先轉為小寫再進行判斷](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12525)

- [建立 instance 時，傳入的 datacenterCode 值需要先轉為小寫再進行判斷](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12525)
- [[Chart]Chart 需能支持建立 ingress](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12526)
- [[Chart] 移除 templates 資料夾內的 broker.yaml](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12524)

### Fixes

- [輸入錯誤的 databaseName 恢復 dedicated 數據庫，恢復非此 instance 創建的數據庫成功](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12509)
- [Bind 的返回資訊，應包含 externalHosts](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12527)

# 0.1.9

### Requirement

- Add Update API (update dedicated manual to change status to 'deleted')

## 0.1.8

### Fixes

- [呼叫 shared bind API，等待 3 分鐘仍未回復 binding 成功，但 mongodb 已成功創建 user](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12481)

## 0.1.7

### Fixes

- [輸入 database 參數值為空""或未輸入，呼叫 Manual addition API，返回 400](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12443)
- [呼叫 dedicated manual addition API (instanceId, organizationId, spaceId 參數輸入 space " ")，返回 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12444)
- [呼叫 Dedicated-Deprovision API，返回 202](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12446)
- [重複呼叫 dedicated addition API (不同 pseudoId，其餘參數值相同)，返回 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12447)
- [呼叫 Bind API (加入任一參數)，返回 503 duplicate key value violates unique constraint \"shared_binding_pkey](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12471)
- [呼叫 Manual addition API(參數輸入"")，返回 400 parameter 'instanceId' is empty，與其他 API 返回資訊不一致](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12431)
- [呼叫 Provision API (datacenterCode 輸入"")，返回 400](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12432)
- [輸入錯誤的 service_id 呼叫 API，返回 200,201](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12433)
- [錯誤的方法呼叫 Dedicated Addition (PATCH)，返回 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12430)

## 0.1.7

### Fixes

- [輸入 database 參數值為空""或未輸入，呼叫 Manual addition API，返回 400](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12443)
- [呼叫 dedicated manual addition API (instanceId, organizationId, spaceId 參數輸入 space " ")，返回 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12444)
- [呼叫 Dedicated-Deprovision API，返回 202](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12446)
- [重複呼叫 dedicated addition API (不同 pseudoId，其餘參數值相同)，返回 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12447)
- [呼叫 Bind API (加入任一參數)，返回 503 duplicate key value violates unique constraint \"shared_binding_pkey](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12471)
- [呼叫 Manual addition API(參數輸入"")，返回 400 parameter 'instanceId' is empty，與其他 API 返回資訊不一致](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12431)
- [呼叫 Provision API (datacenterCode 輸入"")，返回 400](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12432)
- [輸入錯誤的 service_id 呼叫 API，返回 200,201](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12433)
- [錯誤的方法呼叫 Dedicated Addition (PATCH)，返回 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12430)

## 0.1.6

### Requirement

- Add instance status 'error' indicates error during process
- Add instance status 'in process' indicates request is being processed

## 0.1.5

### Requirement

- Change instance status 'exist' to 'running'
- Change instance status 'cleaned' to 'deleted'

## 0.1.4

### Requirement

- Add dedicated plan

## 0.1.3

### Fixes

- [[API] 呼叫 bind API 後，返回信息中 credentials 資訊缺少 host 和 port](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/11111)
- [當 instance 數量達到 MAX_INSTANCE_PER_DB 參數設定(instance_status is removed)，新增 instance 失敗，返回碼 507](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/11124)
- [當 instance_status 為 delete 或 removed 時，仍可以使用 binding 中的資訊連接 mongodb 寫入資訊](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/11145)
- [在 ops-pgsl 數據庫 Share_instance table 中，instance_status 更新為 removed 後，delete_instanced_time 變更為 null。復原訂閱後，delete_instanced_time 仍顯示刪除時間。](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/11123)
- [在使用者綁定情況下，可以刪除訂閱](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/11158)

## 0.1.2

- [[API] 輸入 Content-Type 參數值 text/plain 呼叫 API，返回碼應為 415，而不是 200 或 201](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/10516)
- [[API] 呼叫 API 參數輸入""," "或沒有輸入參數，返回碼應為 400, 而不是 201,200 或 404](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/10520)
- [[API] 執行未提供 header 資訊的 API，返回碼應為 401, 而不是 201 或 200](http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/10514)

## 0.1.1

- Update chart with pullSecrets.enabled
- Update repo to harbor.arfa.wise-paas.com

## 0.1.0

- Remove vendor
- CHANGELOG.MD
- Refactor all to modular and more go-style
- Support helm deployment
