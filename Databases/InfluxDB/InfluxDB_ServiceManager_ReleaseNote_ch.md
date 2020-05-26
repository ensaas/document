# CHANGELOG

# WISE-PaaS Service Manager - InfluxDB 0.1.6 (1.0.0)

### Added:
- Requirement #13640: 將[POST] /v2/service_instances/manual的ssl參數改為非必填，若沒填則預設為false
- Requirement #13647: Deprovision時若有binding存在，不進行阻擋，要能deprovision成功
- Requirement #13767: 改為不驗證externalHosts的格式
- deprovision時自動進行unbind

### Fixed:
- Bug #13349: 進行bind或get resources時，若連接influxdb失敗，錯誤訊息不明確
- Bug #13637: 資料庫中，credentials資料表中的deployment_method欄位長度錯誤


# WISE-PaaS Service Manager - InfluxDB 0.1.5

### Added:
- Requirement #13217: 需支持https的Dedicated InfluxDB
- Requirement #13388: Unbind dedicated instance時，若username / database已不存在，也要讓unbind成功
- Suggestion #13346: 恢復instance時，若instance狀態為非法的狀態，回覆的訊息用字建議修改
- Suggestion #13411: 希望添加資訊的API能夠在呼叫後，Service Manager先ping看看連線資訊能不能連上

### Fixed:
- Bug #12861: 建立binding時，若put body為空，會得到回覆500
- Bug #12878: 呼叫PATCH /v2/service_instances/{instance_id}時，若body為空，會得到回覆500
- Bug #12894: 呼叫POST /v2/service_instances/manual時，若instanceProperties內的參數少帶，回覆不正確
- Bug #12936: 刪除binding時，若instance status為detached，錯誤訊息不正確
- Bug #13216: 綁定後，拿到的credential中的uri是postgres格式的uri
- Bug #13286: 呼叫POST /v2/service_instances/manual時，若PersistentDiskType大於長度16，會得到500錯誤
- Bug #13292: 呼叫DELETE /v2/service_instances/{instance_id}，若帳密驗證失敗，API的回覆訊息異常
- Bug #13296: 若instance狀態為detached或deleted，呼叫GET resources的回覆不是很明確
- Bug #13327: 恢復instance時，若輸入的spaceId與待恢復的instance的spaceId不同，不應該能恢復成功
- Bug #13339: 恢復instance時，若instance的狀態為deleted，回覆應為409
- Bug #13349: 進行bind或get resources時，若連接influxdb失敗，錯誤訊息不明確
- Bug #13352: 即使unbind過程發生錯誤，API還是回覆unbind成功


# WISE-PaaS Service Manager - InfluxDB 0.1.4

### Fixed:

- Bug #12768: 資料表deployment的欄位名稱有誤
- Bug #12841: 若service manager無法連到database，在進行bind/unbind時不會於時間內回應
- Bug #12851: Bind後拿到的credential要跟舊版格式完全一樣，並新增internalHosts和externalHosts
- Bug #12855: Bind時輸入的databaseName須限制只能A-Z、a-z、0-9以及橫線(-)，橫線不得在開頭，上限63字元
- Bug #12859: 透過POST /v2/service_instances/manual建立的instance其instance_parameters內有部分不明的參數為空
- Bug #12862: 建立binding時，若databaseName為空，應自動產生databaseName
- Bug #12863: 建立binding時，若databaseName為null，API無法正常回應
- Bug #12864: 建立的instance其plan_name與實際的不符
- Bug #12881: 呼叫plan_id沒帶，會得到502回覆
- Bug #12884: 資料庫中，deployment資料表中的deployment_method欄位長度錯誤
- Bug #12892: 呼叫POST /v2/service_instances/manual時，若authenticationDatabase未帶或為空，不應能建立成功
- Bug #12893: 呼叫POST /v2/service_instances/manual時，若instanceProperties未帶或為空，不應能建立成功
- Bug #12894: 呼叫POST /v2/service_instances/manual時，若instanceProperties內的參數少帶，回覆不正確
- Bug #12896: 呼叫POST /v2/service_instances/manual時，若body為空，錯誤訊息不明確
- Bug #12904: 呼叫POST /v2/service_instances/manual時，應阻擋internalHosts或externalHosts大於500字元的情況
- Bug #12906: 呼叫POST /v2/service_instances/manual時，應阻擋instanceProperties各項參數大於指定長度
- Bug #12911: 呼叫POST /v2/service_instances/manual時，應阻擋deploymentProperties各項參數大於指定長度
- Bug #12912: 呼叫POST /v2/service_instances/manual時，應阻擋PersistentDiskSize為負值的情況
- Bug #12916: 若建立重複的instanceId，錯誤訊息有誤
- Bug #12917: 呼叫POST /v2/service_instances/manual時若參數有誤，回覆訊息中的參數名稱與實際名稱不一致
- Bug #12927: 呼叫GET resources時，若service_instance_id不存在，API無法正常回覆
- Bug #12930: 呼叫GET resources時，若database名稱具特殊符號，顯示時不正常
- Bug #12934: 建立binding時，若instance status為detached，回覆訊息不明確
- Bug #12936: 刪除binding時，若instance status為detached，錯誤訊息不正確
- Bug #12938: 刪除instance時，若instance status為非預期的狀態，response code有誤
- Bug #12939: 呼叫PATCH instance時，若instance status為非預期的狀態，response code有誤
- Bug #12943: 恢復instance時，若instance_status為不合法的狀態，API無法正常回覆
- Bug #12981: GET resources的清單裡需要將resource_list改為resources_list
- Bug #13103: 支持使用不同的SECURITY_USER_NAME和SECURITY_USER_PASSWORD

### Updated:

- check header for resource list api

# WISE-PaaS Service Manager - InfluxDB 0.1.3 (2020-03-24)

### Updated:

- binding_id不允許重複使用

### Fixed:

- fix redmine bug #12766: GET /v2/catalog該支API沒有做身分驗證
- fix redmine bug #12767: POST /v2/service_instances/manual沒有阻擋非法json字串
- fix redmine bug #12768: 資料表deployment的欄位名稱有誤
- fix redmine bug #12772: 呼叫POST /v2/service_instances/manual後，建立出的dedicated_instance > instance_parameters多了一個subscriptionId參數
- fix redmine bug #12773: [GET] /v2/service_instance_id/{service_instance_id}/resources該API應列出指定的instanceId下有哪些database
- fix redmine bug #12774: 進行bind後，回覆的訊息裡externalHosts不應該為空

# WISE-PaaS Service Manager - InfluxDB 0.1.2 (2020-03-23)

### Added:
- add api [DLELTE] /v2/service_instances/{instance_id} (deprovision, only manual)
- disable [PUT] /v2/service_instances/{instance_id} in this version.
- [POST] /v2/service_instances/manual 使用同一pseudoId時可以恢復狀態為detached的instance (只有dedicated可以)

### Updated:
- credential 的status改為runnning/detached/deleted
- auth type必須為basic

# WISE-PaaS Service Manager - InfluxDB 0.1.1 (2020-03-20)

### Added:
- add api [PATCH] /v2/service_instances/{instance_id} for update deleted instance

### Updated:
- fix format by 3/20 new spec

# WISE-PaaS Service Manager - InfluxDB  version: 0.1.0 (2020-03-19)

### Added:
- 5 api
- [POST] /v2/clusters/shared (404)
- [POST] /v2/service_instances/manual
- [PUT] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [DELETE] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [GET] /v2/service_instance_id/{service_instance_id}/resources
- add helm chart
