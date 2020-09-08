# WISE-PaaS Service Manager Postgresql Release Note

## WISE-PaaS Service Manager - PosrgreSQL 0.2.1.3 (2020-09-08)

- Bug #15604: init ops db時，binding表格裡的binding_time資料類型錯誤
- Bug #16135: shared provision失敗時需要可以rollback
- Requirement #13558: 客戶自帶DB納入sm管理
- Requirement #15681: 支持設置shared instance的預設連線數
- Requirement #16118: 新增API [PATCH] /v2/serviceInstances/{serviceInstanceId}/info
- Requirement #16119: [POST] /v2/serviceInstances/manual 增加檢查輸入的帳號是否具有足夠權限


## WISE-PaaS Service Manager - PosrgreSQL 0.2.1.2 (2020-08-04)

- Requirement #15465: 若instance被鎖住，不允許進行unbind
- Suggestion #14987: 需要有一支API讓運維人員將error的instance改為running


## WISE-PaaS Service Manager - PosrgreSQL 0.2.1.1 (2020-07-29)

- Bug #13403: 若欲恢復的shared instance其狀態不為detached，錯誤訊息用字有誤
- Bug #13423: 若dedicated instance的deployment_method不為manual，不應該能透過dedicated deprovision用的api刪除
- Bug #14502: 永久刪除dedicated cluster時，若該cluster已被刪除，回覆的訊息用字不一致
- Bug #14504: 永久刪除shared cluster時，若該cluster已被刪除，回覆的訊息用字不一致
- Bug #15056: 建立dedicated instance時，若沒帶vSwitchId，錯誤訊息有誤
- Bug #15190: 建立dedicated instance時，若沒帶resourceType，錯誤訊息有誤
- Bug #15191: 建立dedicated instance時，若沒帶zoneId，錯誤訊息有誤
- Bug #15205: Instance刪除後(退訂時)，當下應該就要在阿里雲上更改標籤為lifecycle:inactive，並標上detached_time
- Bug #15222: Instance退訂後，在阿里雲上記錄的detached_time要等同於ServiceManager記錄的detached_at時間
- Bug #15351: 若一個dedicated instance的inernalHosts有2個以上的IP，建立binding後，產生的uri只有包含一個host
- Bug #15379: 恢復instance時，若當前剩餘shared instance額度為0，會發生錯誤，無法恢復
- Bug #15391: 用ADM開出來的instance不應該能透過[POST] /v2/service_instances/manual這支API進行恢復
- Requirement #15228: 建立或刪除instance時，若連不上ADM需要再失敗三次才判定error
- Requirement #15402: 需提供API能對resource type進行新增、查詢、修改、刪除
- Suggestion #15235: 若刪除dedicated instance時設deleteData=true，更改阿里雲上的標籤


##  WISE-PaaS Service Manager - PosrgreSQL 0.2.0.4(0.2.1) (2020-07-24)

- 修正啟動時添加的dedicated_resource vm type規格


##  WISE-PaaS Service Manager - PosrgreSQL 0.2.0.3 (2020-07-23)

- Bug #15266: 無法成功建立HA instance


##  WISE-PaaS Service Manager - PosrgreSQL 0.2.0.2 (2020-07-16)

- Bug #15114: 呼叫[DELETE] /v2/service_instances/{instance_id}?deleteData=true，沒辦法將detached instance變為deleted
- Requirement #14891: [GET] /v2/clusters/dedicated/{pseudoId} 改為 [GET] /v2/serviceInstances/{instanceId}/info (Reopen)
- Requirement #15150: 降規時支持不同的實例付費方式
- Suggestion #15132: 建立或刪除instance時，若連不上ADM，不要立刻判定error


##  WISE-PaaS Service Manager - PosrgreSQL 0.2.0.1 (2020-07-13)

- Bug #14871: 當自動建立的dedicated instance建立完成時，deployment資料表的updated_at沒有更新
- Bug #15005: 建立HA的instance後，發現instance的externalHosts有兩個
- Bug #15057: 建立instance時，若parameters為nullparameters內參數為null，API無法正常回應
- Requirement #14667: 阿里雲DB的時間格式和時區問題
- Requirement #14804: [GET] /v2/clusters/list在回傳dedicated資訊時，額外增加回傳deploymentName
- Requirement #14816: 啟用[GET] /v2/service_instances/{instance_id}/last_operation，讓Service Hub可以透過該API查詢部署狀態
- Requirement #14818: SM啟動時，自動於dedicated_resources添加resource type資料
- Requirement #14859: 修改service instances 相關API路徑
- Requirement #14891: [GET] /v2/clusters/dedicated/{pseudoId} 改為 [GET] /v2/serviceInstances/{instanceId}/info
- Requirement #14902: 若客戶額外添購硬碟，provision時需支持輸入添購的數量，且透過ADM開硬碟時，開出的大小須為(Base Size) + (Additional Size) * (Quantity)
- Suggestion #14890: 透過ADM建立dedicated instance後，deployment資料表中的parameters沒有內容
- 新增使用ADM自動退訂功能
- 新增dedcated instance 狀態detached 7天後自動變更狀態為deleted功能
- 修正dedicated連續provision, deprovision相同ID問題


##  WISE-PaaS Service Manager - PosrgreSQL 0.2.0 (2020-07-02)

- 需搭配helm chart版本0.2.0
- ops db自動更新至0.2.0版
- 可調整log印出模式
- Requirement #13319: 客戶訂閱Dedicated DB時整合ADM自動部署
- Requirement #14499: 新增一支API，立刻將shared instance從detached變deleted，並刪除database
- Requirement #14580: [GET] /v2/clusters/list在回傳dedicated資訊時，額外增加回傳instanceId
- Requirement #14583: 資源管理的API規格改動
- Requirement #14667: 阿里雲DB的時間格式和時區問題


##  WISE-PaaS Service Manager - PosrgreSQL 0.1.20 (2020-06-23)

- Bug #14517: 建立dedicated instance的binding後，資料庫連線沒有關閉


##  WISE-PaaS Service Manager - PosrgreSQL 0.1.19 (2020-06-12)

- Bug #13396: 新增一筆shared database後，deployment資料表的parameters會多一筆SkipTest
- Bug #14184: 若對shared instance進行恢復，應於updated_at欄位記上恢復的時間
- Bug #14189: 刪除dedicated instance時會得到postgresql回覆的錯誤訊息
- Bug #14323: Deprovision時若設deleteData=true，database沒有實際被刪掉，instance的狀態也是detached
- Bug #14342: 呼叫[POST] /v2/service_instances/manual時，沒有正確檢查連線資訊是否合法
- Requirement #14284: 呼叫[GET] /v2/datacenter/{datacenterCode}/overview時，若找不到datacenterCode時，要回覆全部值為0的結果
- Requirement #14285: 呼叫[GET] /v2/clusters/list，若找不到datacenterCode，需回覆空陣列
- Suggestion #13406: 若在database不存在的情況嘗試進行bind/unbind/deprovision，建議修改response code
- Suggestion #14167: 建議[PATCH] /v2/clusters/shared/{pseudo_id}多驗證Content-type


## WISE-PaaS Service Manager - PosrgreSQL 0.1.18 (2020-06-04)

- Bug #14111: 屬於g_rw_public權限的user在public schema底下建立table後，在binding被刪掉之後，該table能被其他只能讀取的user刪除
- Bug #14156: 呼叫GET /v2/clusters/list，當instance上限無限制時，顯示內容有誤
- Bug #14157: GET /v2/clusters/list 此API的datacenterCode應為必填
- Bug #14160: 呼叫GET /v2/clusters/list時，若datacenterCode亂填，得到的結果有誤
- Bug #14165: 呼叫PATCH /v2/clusters/shared/{pseudo_id}，若對象是dedicated cluster，不應該能呼叫成功
- Bug #14166: 呼叫PATCH /v2/clusters/shared/{pseudo_id}，若body為空，會得到502的回覆
- Bug #14182: Deprovision時沒有自動unbind
- Bug #14187: 恢復dedicated instance時，不應該以pseudoId作為判斷參數
- Bug #14189: 刪除dedicated instance時會得到postgresql回覆的錯誤訊息
- Requirement #14175: 0.1.17版新增的API需要遵照重新決定的參數格式

## WISE-PaaS Service Manager - PosrgreSQL 0.1.17 (2020-05-28)

- Bug #13402: 若恢復shared instance時space_guid填錯，錯誤訊息有誤
- Bug #13404: 恢復shared instance時，若instance的狀態為running、deleted或其他，response code應為409
- Bug #13410: 添加dedicated instance時，若instance_id已被使用，錯誤訊息有誤
- Bug #13415: 呼叫POST /v2/service_instances/manual時，應阻擋PersistentDiskType大於長度16的情況
- Bug #13422: 呼叫[PATCH] /v2/service_instances/{instance_id}時，若instance status不為detached，錯誤訊息有誤
- Bug #13424: 呼叫[POST] /v2/service_instances/manual時，若連不到ops postgres，會回覆500錯誤
- Bug #13425: 進行dedicated bind/unbind時，若無法連到apps database，會得到500錯誤
- Bug #13427: 進行dedicated get resources時，若無法連到apps database，回覆訊息要修改
- Bug #13501: 清理database時，若database已不存在，則忽略此錯誤，視作已成功把database刪除
- Requirement #12445: 在instance被limit或revoke後，應阻擋使用者進行bind
- Requirement #13387: Unbind時，若username或database已不存在，也要讓unbind成功
- Requirement #13641: 提供給Shared Cluster Overview用的API
- Requirement #13642: 提供給Dedicated Cluster Overview用的API
- Requirement #13651: [POST] /v2/clusters/shared該API的externalHosts改為非必填
- Requirement #13652: 改為不驗證externalHosts的格式
- deprovision時自動unbind

## WISE-PaaS Service Manager - PosrgreSQL 0.1.16.2 (2020-05-12)

### Fixed:
- Bug: Aliyun上ALTER SCHEMA "public" OWNER TO "g_rw_public"的錯誤

## WISE-PaaS Service Manager - PosrgreSQL 0.1.16.1 (2020-04-29)

### Fixed:
- Bug #13607: Deprovision時會發生刪除role失敗的錯誤

## WISE-PaaS Service Manager - PosrgreSQL 0.1.16 (2020-04-29)


### Added:
- Requirement #13449: 新開發一支API，顯示當前剩餘多少shared instance額度

## WISE-PaaS Service Manager - PosrgreSQL 0.1.15

### Added:
- Requirement #13102: 支持使用不同的SECURITY_USER_NAME和SECURITY_USER_PASSWORD
- Requirement #13183: 設INSTANCE_LIMIT_PER_DB為-1時表示無instance上限
- Requirement #13310: Deprovisoon的API增加deleteData參數
- Suggestion #13107: 希望添加資訊的兩隻API能夠在呼叫後，Service Manager先ping看看連線資訊能不能連上

### Fixed:
- 修改dedicated instance recover的規格
- Bug #13043: 若dedicated database裡沒有任何非系統用database存在，GET resources應回覆空的陣列
- Bug #13045: 若instance狀態為detached或deleted，呼叫GET resources的回覆不是很明確
- Bug #13084: 若綁定group時parameters格式錯誤，API無法正常回覆

## WISE-PaaS Service Manager - PosrgreSQL 0.1.14

### Fixed:
- Bug #12708: 移除部署後的pod裡多餘的名稱
- Bug #13036: 呼叫POST /v2/clusters/shared後，建立出的deployment資料其parameters多了一筆enableDeprovision
- Bug #13037: 呼叫POST /v2/clusters/shared時，若body為空，錯誤訊息不明確
- Bug #13038: 建立shared資訊時，若pseudoId有誤，提示訊息裡的參數與實際不一樣
- Bug #13039: 透過POST /v2/service_instances/manual建立的instance其instance_parameters內有部分不明的參數為空
- Bug #13043: 若dedicated database裡沒有任何非系統用database存在，GET resources應回覆空的陣列
- Bug #13047: shared_instance資料表的space_id欄位名稱錯誤
- Bug #13061: 一邊連續進行shared的操作，另一邊進行dedicated的bind/unbind，dedicated的操作會受到影響
- fix recover dedicated instance bug

### Updated:
- Requirement #13056: 若刪除instance或unbind時instance_id或binding_id不存在，API的response code改成410
- Requirement #13067: INSTANCE_LIMIT_PER_DB所限制的對象改為running和detached的shared database

## WISE-PaaS Service Manager - PosrgreSQL 0.1.13

### Fixed:
- Bug #13040: 在新增完dedicated credential後進行shared的bind，會發生無法insert資料進資料庫的錯誤
- Bug #13041: Bind後拿到的credential其port型別與舊版credential不一致

## WISE-PaaS Service Manager - PosrgreSQL 0.1.12

### Fixed:
- 修正service_id和plan_id格式

## WISE-PaaS Service Manager - PosrgreSQL 0.1.11

### Fixed:
- Bug #13006: 無法成功添加shared database資訊

## WISE-PaaS Service Manager - PosrgreSQL 0.1.10

### Updated:
- 增加dedicated plan。plan name和舊版相同統一使用大寫
- 增加4支新的API
  - [PATCH]/v2/service_instances/{instance_id}
  - [POST]/v2/clusters/shared
  - [POST]/v2/service_instances/manual
  - [GET]/v2/service_instance_id/{service_instance_id}/resources
- Requirement #12189: 新增一支API用來添加Shared DB資訊
- Requirement #12190: 增加一支新增dedicated database的API
- Requirement #12314: Binding後顯示出的credential要加上internalHosts和externalHosts
- Requirement #12707: Helm chart需能兼容k8s 1.14和1.16版本

### Fixed:
- 阻擋不合法的db名稱
- bind的credential加上port,host
- 刪除從環境變數讀取apps db的相關內容
- 按照3/20新規格修改ops table
- Bug #11884 Unbind一個不屬於該instance的binding_id時，沒有對應的錯誤訊息
- Bug #11884: Unbind一個不屬於該instance的binding_id時，沒有對應的錯誤訊息
- Bug #12265: 無法藉由過往刪除username的方法將binding所屬的username從資料庫刪除


## 0.1.9

- requirement redmine #12037 修正space_id和org_id的欄位長度，改成150字元
- requirement redmine #11927 建立instance時，傳入的env值需要先轉為小寫再進行判斷
- fix bug redmine #11862: 進行deprovision時，若service_id或plan_id為空或有誤，小SB會沒辦法正常回覆訊息
- fix bug redmine #12039: 建立instance時，應阻擋instance_id大於資料庫欄位限制長度(50字元)
- fix bug redmine #12040: 建立instance時，應阻擋organization_guid和space_guid大於資料庫欄位限制長度(150字元)
- fix bug redmine #12041: 進行bind時，應阻擋binding_id大於資料庫欄位限制長度(50字元)

## 0.1.8

- 修改binding status - exist/delete -> binding/deleted
- 修正env mapping錯誤
- 修改shared db default上限(INSTANCE_LIMIT_PER_DB)為20
- requirement redmine #11934 [Chart] 移除templates資料夾內的broker.yaml以及其他不需要的檔案

## 0.1.7

- requirement redmine #11996 2/20 Service Manager資料表修改
- requirement redmine #11897 需提供適當的ephemeral-storage大小
- requirement redmine #11935 [Chart] Chart需能支持建立ingress
- fix bug redmine #11857 初次部署小SB時，會無法成功建立instance
- fix bug redmine #11995 Provision的API需將env改為datacenterCode

## 0.1.6

- fix bug redmine #11774 [Chart] 將createConfigMap設為false後會部署失敗
- fix bug redmine #11772 [Chart] 希望支持參數列在deployment，並且修改deployment內的參數後，pod會自動套用並重啟
- 修正init recorder時的sql

## 0.1.5

- 增加credential表格裡的status欄位，可控止此連線資訊是否可用於小sb的操作
- 修改已使用的instance計算方式，增加mutex和channel(會暫存pennding的instance數量)
- add mutex to provision/deprovision/bind/unbind/remove deleted db
- fix bug redmine #11421 [Chart] 無法下載private image
- fix bug redmine #11492 [Chart] 將部署參數從configmap移到deployment
- fix bug redmine #11723 [Chart] 部署時指定type為NodePort時，沒有正確套用
- fix bug redmine #11506 回復資料庫成功時，增加回覆中的提示訊息(status code 200)
- fix bug redmine #11540 5 threads連續呼叫，會發生tuple concurrently updated之錯誤
- fix bug redmine #11526, #11527, #11528, #11529 連不到ops postgres會回500錯誤
- fix bug redmine #11451 當header中Authorization的type不對時，API不應該能呼叫成功
- fix bug redmine #11509 回復instance時，若該instance狀態為removed，則返回錯誤，並提示無法恢復
- fix bug redmine #11430 沒有帶env參數時，錯誤訊息有誤
- fix bug redmine #11479 有未解綁的情況下，不應允許刪除instance
- fix bug redmine #11469 修改507 Insufficient Storage情況的錯誤訊息
- fix bug redmine #11434 實際能建立的instance數量與INSTANCE_LIMIT_PER_DB的設定不符
- fix bug redmine #11491 修改資料表欄位名稱created_at、updated_at、deleted_at、cleaned_at
- fix bug redmine #11487 清理database時，若database尚有連線，需要將連線踢除後再清理
- fix bug redmine #11486 自動清理database時，若遇到錯誤，後續的清理就不會繼續
- fix bug redmine #11525 若連不到apps postgres，小SB的回應時間太長
- fix bug redmine #11433 當apps postgres的部署帳號非postgres時，無法建立instances
- fix bug redmine #10929 Bind時若綁定group，應阻擋含有非法字元的group名稱(-)

## 0.1.4

- 修改ops table內char改為varchar
- 在deprovision後，經過X天後將相關database自動刪除 (X可設定)
- 支持多個shared DB
- 扣除已deprovision的instance後，建立的instance上限為Y個 (Y可設定)
- 支持恢復訂閱功能
- Provision時需要讀取名為env的參數以支持跨平台
- fix bug redmine #10939 若刪除service key時當下無法連到apps postgres，會出現不正確的錯誤訊息
- fix bug redmine #10931 進行unbind時，若database不存在，會出現invalid memory address的錯誤
- fix bug redmine #10930 應阻擋綁定64字元以上的群組名稱
- fix bug redmine #10929 Bind時若綁定group，應阻擋含有非法字元的group名稱
- fix bug redmine #10927 綁定g_ro_public群組的app不應該能在public schema底下建立table
- fix bug redmine #10926 進行bind時groups參數沒有被進行處理

## 0.1.3

- 修正啟動時根據環境變數更新apps db資訊的方法
- 若ops db未被建立，service manager會crash以防止其他錯誤操作

## 0.1.2

- fix bug redmine #10513 不應有Dedicated plan
- fix bug redmine #10546 helm delete後發現還有殘留項目
- fix bug redmine #10622 若使用者曾經建立schema，則無法進行unbind
- fix bug redmine #10673 Bind後產生的連線資訊內未包含DB的host/port
- fix bug redmine #10675, #10678, #10700 呼叫provision API 的參數錯誤提示回傳用字、status code不正確
- fix bug redmine #10692, #10693, #10712, #10713, #10714 呼叫binding API 的參數錯誤提示回傳用字、status code不正確
- fix bug redmine #10718, #10721, #10722, #10723, #10725, #10726 呼叫unbinding API 的參數錯誤提示回傳用字、status code不正確
- fix bug redmine #10731, #10733, #10734, #10735, #10736 呼叫deprovision API 的參數錯誤提示回傳用字、status code不正確
- fix bug redmine #10738 小SB剛啟動時，不應在ops建立database
- fix bug redmine #10743 進行bind時，若database不存在，沒有錯誤訊息
- fix bug redmine #10767 更新database資訊後，service manager依然套用舊的連線資訊
- fix bug redmine #10769 進行deprovision時，若database不存在，應deprovision失敗
- fix bug redmine #10801 部署上的service manager沒有版號

## 0.1.1

- fix close connection issue
- fix error status problem
- fix deprov setting problem

## 0.1.0

- 5 basic api
- helm chart
