# DBBackup-apiserver

### 1.1.1/1.1.0.3 (2022-05-17)
- 修正只允許global admin時的寄信清單

### 1.1.0.2 (2022-05-11)
- 增加只允許global admin備份還原的開關

### 1.1.0.1 (2021-11-10)
- Bug #20197: 呼叫GET /dbSchedules/all 或 Get /dbSchedules/{dbScheduleId} API (已被刪除的dbBackupConfigId的dbScheduleId 或不輸入任何查詢條件)，返回500 internal server error
- Bug #20587: 呼叫POST dbBackupConfigs API (輸入不存在的dbStorageId)，返回500
- Bug #20842: Get ​/dbSchedules​/all 輸入指定搜尋時間超過42天上限值，返回從當下時間點+42天的next資訊
- Bug #20925: 呼叫任一api (未輸入header)，返回200
- Bug #21283: swagger 版本資訊與app實際版號不相符
- Requirement #20595: 移除dbSchedule api中返回資訊的minute字樣
- Requirement #20610: 阻擋還在被dbScheduleId使用的dbBackupConfigId刪除(Extend Bug #20197)
- Requirement #20889: 提供一支API，刪除與instance相依的dbschedule和dbBackupConfig
- Requirement #20920: 增加Get /dbSchedules/all API，增加status搜尋條件

### 1.1.0/1.0.0.3 (2021-08-18)
- 寄信規則改為寄給訂閱號下所有人員
- 刪除多餘log
 
### 1.0.0.2 (2021-08-18)
- Bug #21451: 告警通知的郵件沒有顯示所有詳細信息內容，資訊顯示空值
- Bug #21453: dbBackup / dbRestore執行期間手動刪除，告警通知信息沒有instanceId資訊
- Bug #21477: 備份/還原失敗，通知郵件中的備份/還原狀態，失敗原因，instanceId等信息顯示空值
- Bug #21478: 告警通知郵件標題，沒有顯示執行結果
- Bug #21488: 從dbschedule建立的dbbackukp失敗後，沒有收到通知郵件
- Bug #21490: 備份完整數據庫數據庫，通知郵件中備份數據庫顯示空值
- Bug #21504: dbschedule建立的dbBackup約3分鐘後加入dbBackupQueue
- Bug #21513: 刪除enable狀態的dbschedule後，約3分鐘沒有從list移除dbscheduleId，仍顯示下次執行backup時間
- Bug #21520: Enable dbschedule一分鐘內自動建立的dbbackup，完成後不會寄送通知郵件
- Bug #21566: App pod重啟，日誌顯示panic: runtime error: invalid memory address or nil pointer dereference（無法複製此問題）
- Bug #21652: GET /dbBackups這支API沒有列出所有的備份

### 1.0.0.1 (2021-08-04)
- #20537 增加告警通知功能，當備份或還原失敗時，會發郵件通知
- 整合notification
- 添加整合notification部署說明的readme文件

### 1.0.0/1.0.0-rc17 (22/07/2021)
- Bug #21055: 執行restore後重啟api-server pod，restore成功後沒有restart secret
- Bug #21213: 當influxdb instance internal hosts為host時，無法透過api建立dbbackup/dbrestore/dbschedule (Requirement #20133)
- Requirement #20996: 當controller取得3個ip時，只送一個可以連上數據庫的ip給backup-tool

### 1.0.0-rc16 (08/07/2021)
- Bug #20954: 使用沒有權限的非自定義dedicted instance呼叫所有 dbBackups API，返回403 "instance <instanceId> is userdefined"
- **增加debug log(未復現)** Bug #20982: 同時執行2個完整數據庫，完成restore後，日誌持續顯示錯誤 (queue 未刪除成功）
- Requirement #20996: 當controller取得3個ip時，只送一個可以連上數據庫的ip給backup-tool

### 1.0.0-rc15 (01/07/2021)
- #20756 還原整個數據庫時，會自動更新Secret (單一數據庫不更新）

### 1.0.0-rc14 (23/06/2021)
呼叫PATCH dbSchedules API (dbScheduleId參數沒有權限)，返回200
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19418

呼叫POST dbBackup/dbSchedule api，因為dbStorage phase為error原因失敗時，返回500 failed to create backup resource
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20671

使用訂閱號user帳號，呼叫Get Restore api 返回資訊包含沒有權限的instance
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20582

呼叫PUT/POST/PATCH dbstorage api (錯誤的remotePath參數值)，返回500
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20564

Delete dbStorage API ，若dbStorage被使用時無法刪除時，返回500
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20464

使用無權限的dbStorageId呼叫POST/PATCH dbBackupConfig成功
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20584

呼叫POST/ dbSchedules API，返回資訊與swagger不一致(createTs)
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19413


### 1.0.0-rc13 (11/06/2021)
使用訂閱號權限的帳號呼叫Get dbSchedule相關api (沒有輸入搜尋條件)， 返回Schedule資訊
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20514#change-63862

dbschedule and dbstorage PATCH doesn't support change to empty value
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19972

change dbrestore return code when delete from 500 to 400
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20413

change dbstorage return code when delete from 500 to 409
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20464

Update schedule cron validator data size (Extend Requirement #20011)
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20521

新增一支API，提供備份的數據庫清單 GET /dbBackup/<dbBackupId>/availableDatabases
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20463

dbbackup requires to check dbstorage's subscriptionId
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19368

相同的instance在還原/備份過程中不能執行其他備份或還原，如果在還原過程中啟動備份任務，或備份過程中啟動還原，將跳過該操作
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20208

### 1.0.0-rc12 (07/06/2021)
顯示的storage清單不正確
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20459

### 1.0.0-rc11 (03/06/2021)
呼叫Get /dbSchedules/all 或 Ｇet /dbSchedules/{dbScheduleId} API，當最近一次預計執行備份時間超過查詢時間範圍時，會顯示最近一次的時間
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20257

使用沒有訂閱號權限的帳號，刪除dbstorage成功 
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20345

呼叫GET /dbSchedules/all 或 Get /dbSchedules/{dbScheduleId} API (已被刪除的dbBackupConfigId的dbScheduleId 或不輸入任何查詢條件)，返回500 internal server error 
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20197

呼叫PATCH dbSchedules API後，dbSchedules status由Enabled更新為Disabled
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19707

呼叫PUT dbSchedules enable/disable API (dbScheduleId參數值不存在, 沒權限或已被刪除)，錯誤提示不明確
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19427

呼叫GET dbStorage API (輸入沒權限的subscriptionId)，返回dbStorage相關資訊
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20369

Get /dbSchedules/{dbScheduleId} API 和GET /dbSchedules/all 清單列出的時間查詢需求
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20192

當呼叫POST dbbackup或dbrestore時狀態為unknow時，返回pending使UI不會出現unknow字樣
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19637

移除所有api中的dbBackupName參數
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20044

呼叫/v1/dbBackups api(輸入沒有權限的dbStorageId)，返回201
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19368

調整ops schedule_records表格中cron_schedule字元限制上限為80
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20011

Get dbRestores api返回資訊增加description參數
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20135

PATCH dbschedule API無法更新參數內容成功 
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20454

### 1.0.0-rc10 (26/05/2021)
add new API GET dbschedule/all
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/65


### 1.0.0-rc9 (21/05/2021)
cron schedule should be shown on GET dbschedule
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/48

dbstorage error does not show due to err variable is overwritten on inner loop
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/49

fix missing updated_at when update dbbackup configuration
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/50

add details to dbstorage error message
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/52

Change error message format "Resource is not found"
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/53

add swagger component 400 to PUST dbschedule
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/55

add validator check when instanceId for dbBackupConfigs
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/56

[requirement]increase subscription data size to 70
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/51

呼叫POST/PATCH dbBackupConfigs API(dbStorageId, dbBackupConfigName, instanceId參數未輸入或參數值為空值或沒權限)，返回Resource is not found或Invalid request value
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19392

fix dbrestore GET /log error message
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/58

change dbbackup and dbrestore GET log return code to 204 when log is empty
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/59

Add instanceName to GET dbschedule and dbbackup
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/63

NEW API GET dbschedule/:dbscheduleId
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/62


### 1.0.0-rc8 (12/05/2021)

1. add query condition 'subscriptionId' for dbbackupconfig
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19378

2. Update dependencies dbservice to v1.0.0-rc6
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/44

3. remove force from mongodb databaseInfo
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/43

4. change subscription data type from VARCHAR(55) to VARCHAR(70)
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19242

5. dbRestore InstanceID dissapear when related dbbackup is deleted
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/41

6. dbRestore should support restore to other instance ID
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/40

7. dbschedule deploys multiple dbbackup when set enable disable multiple times in short time
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/39

8. dbschedule keep shows dbbackupconfig when dbbackupconfig was deleted
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/38

9. fix cron dbschedule maximum size
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/37

10. dbschedule GET returns empty due to by filter TriggerMode
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/36

11. triggerMode is not exists on dbschedule
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/35

12. instance created by user (private instance) is not be able to use dbservice
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19635

13. dbRestore will reject if existing database is not match with the required condition
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/46

14. add query condition 'subscriptionId' for dbbackupconfig
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19378


### 1.0.0-rc7 (29/04/2021)
1. Fix wrong backup_type placement due to different git branch

### 1.0.0-rc6 (29/04/2021)
1. Requirement: Pod Phase will replaced for all 'Unknown' to 'Failed'
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19637
2. Dbbackupconfig returns 200 when instance id is wrong
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/32
3. Fix restore log filename
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19379
4. globalAdmin cannot retrieve all data from method
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/30
5. cookie should be set ONLY if token get refreshed
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/27
6. change fmt to errors for error with no format
7. cleanup unused log on pkg/database/tables.go
8. fix error dbbackup update due to comma typo in statement 

### 1.0.0-rc5 (09/04/2021)
1.  error SQL statement when query backup_configuration
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/25
2.  whitelist is not implemented in dbstorage
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/24
3.  internet connection issue makes multiple incoming request
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/23
4.  dbbackupConfig cannot be deleted
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/22
5.  support globalAdmin role
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/merge_requests/5/diffs?commit_id=3b48cbf020fdd1393320155201bf4cd839cc4c65


### 1.0.0-rc4 (06/04/2021)
1. 	呼叫POST / PATCH dbstorage api (dbStorageName或subscriptionId參數未輸入或空值)，返回500或200
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19251
2.  無法使用MPDefaultGroup subscription id建立dbstorage成功，返回500 reason:"",message:""
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19242
3. 	[POST] dbstorage和 [POST] dbbackup api 返回的時間參數名稱不一致
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19275
4.  呼叫POST dbstorage api ”version“參數沒有輸入,輸入不支援的參數值或空值，返回500 Failed to create storage service
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19249
5. 	呼叫PUT / PATCH dbstorage api ”version“參數沒有輸入,輸入不支援的參數值或空值，返回400 Malformed request body
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19248  
6.	呼叫PUT / POST/ PATCH dbstorage api (type參數未輸入或空值)，返回200或 400 Malformed request data
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19252
7.	呼叫 POST/ PATCH dbstorage api "remotePath"參數沒有輸入,輸入錯誤的參數值或空值，返回200或201
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19245
8. 	呼叫 POST/ PATCH dbstorage api "remotePath"參數沒有輸入,輸入錯誤的參數值或空值，返回200或201
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19243
9.  GET API takes too much time
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/21
10. dbrestore doesnt need name
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/20
11. Add query parameter dbBackupConfigId for dbSchedule
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/13
12. UI requested to use "items" instead of "data" for all API with GET method
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbbackup-apiserver/-/issues/11

    
### 1.0.0-rc3
1. Refactor API
    POST /dbSchedules
    GET /dbSchedules
    PATCH /dbSchedules/{dbScheduleId}
    DELETE /dbSchedules/{dbScheduleId}
    PUT /dbSchedules/{dbScheduleId}/enable
    PUT /dbSchedules/{dbSchedulesId}/disable
    POST /dbRestores
    GET /dbRestores
    DELETE /dbRestores/{dbRestoreId}
    GET /dbRestores/{dbRestoreId}/log

### 1.0.0-rc2
1. Fix token validation when token expired (RFC6750)
2. Add response header parameter 'error' and 'error_description' when authentication fail (RFC6750)
3. Add response header 'Cache-Control' to GET method (RFC7234#section-5.2.1)
4. Remove OAuth validation (Bearer token) since we are using JWT only
5. Fix hanging connection without log. 
6. Refactor API
    POST /dbStorages
    PATCH /dbStorages/{dbStorageId}
    DELETE /dbStorages/{dbStorageId}
    GET /dbStorages?
    PUT /dbStorages/checkz
    POST /dbBackupConfigs
    PATCH /dbBackupConfigs/{dbBackupConfigId}
    DELETE /dbBackupConfigs/{dbBackupConfigId}
    GET /dbBackupConfigs？
    POST /dbBackups
    DELETE /dbBackups/{dbBackupId}
    GET /dbBackups？
    GET /dbBackups/{dbBackupId}/log

Note:
dbbackup:
1. change all API route according to new doc
2. add storageDeviceType and storageName label everytime create new dbstorage
3. add subscriptionId ,instanceId, triggerMode and uiName everytime create dbackup and dbschedule 
4. triggerMode has Manual and Scheduler value
4. RetrieveDbBackup needs storagetype information, therefore need to separately query dbStorageConfiguration info
6. change dbStorageConfiguration to dbStorage
7. Call SH to fill databaseInfo
   curl -X GET "http://api-service-ews.axa.wise-paas.com.cn/v2/cluster/serviceInstances/s" -H "accept: application/json"
   curl -X GET "http://api-service-ews.axa.wise-paas.com.cn/v2/serviceInstances/s" -H "accept: application/json"
    Create function check connection to these API server
8. Remote databaseInfo field
8. Call SSO to check subscriptionId

### 1.0.0-rc1

Initial release
Features:
1. DbStorage
    - Add DbStorage
    - Patch/Modify DbStorage
    - Delete DbStorage
    - Get all DbStorage
    - Get single DbStorage

2. DbBackup Manifest
    - Add DbBackup Manifest
    - Patch/Modify DbBackup Manifest
    - Delete DbBackup Manifest
    - Get all DbBackup Manifest
    - Get single DbBackup Manifest

3. DbBackup
    - Create DbBackup
    - Delete DbBackup
    - Get all DbBackup
    - Get single DbBackup
