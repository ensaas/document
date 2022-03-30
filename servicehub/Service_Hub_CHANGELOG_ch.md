# 1.0.6 (2022-03-30)
 * feat: 取消了 hz mongodb 非自動佈署。
 * feat: 更換了 redis 的服務名稱，修改了判斷式。

# 1.0.5 (2022-01-18)
 * feat: bind unbind API 加上500毫秒的等待時間
 * feat: bind unbind API 加上 retry 3次的機制
 * feat: 更新API，順便會把 rabbitmq 的 dashboard URL 一起更新。
 * feat: 修改chart value，加上 ingress proxy-read-timeout 和 proxy-send-timeout 
 * feat: 修改chart value，將service-hub cpu 開到 500m 
 * feat: 新增查詢 dccs key 的API。
 * 
# 1.0.4 (2021-12-28)
 * feat: 立刻退訂的API帶上 cascade 參數，預設值為true

# 1.0.3 (2021-08-24)
 * bug: 修正 purge 的選項無法刪除 inprogress 和 error 狀態的 bug

# 1.0.1.2 (2021-08-10) (1.0.2)
 * feat: 修正 /v2/user/{userId}/info 回覆值 (因應UI需求)

# 1.0.1.1 (2021-08-10)
 * bug: 修正刪除log的時間

# 1.0.1 (2021-08-09)
 * feat: 測試+修正 log 功能。
 * bug: fix user-provider 沒擋的錯誤
 * bug: fix dccs disable enable disable 後回出現 enable 的錯誤

# 1.0.0 (2021-08-05)
 * feat: 新增log功能，記錄每筆用戶操作的資訊。
 * feat: 進一個穩定的版本號

# 0.3.27 (2021-08-03)
 * feat: 新增兩隻API，記錄用戶同意備份還原服務協議 

# 0.3.26.1 (2021-06-30)
 * feat: 開放 service-hub 的 client token 通過 super user 驗證

# 0.3.26 (2021-06-30)
 * feat:  提供透過catalog購買 BlobStore 變成 inprogress 的 API 
 * feat: user-provider 的功能實做

# 0.3.25 (2021-06-16)
 * feat: bind unbind 需要有個參數，有參數得時後不執行 bind unbind

# 0.3.24 (2021-06-16)
 * feat: 讓 hz 的 mongodb plan Dedicated-Single-Small-V2 暫時改用兩步驟佈署 

# 0.3.23.1 (2021-04-27)
 * bug: 修正binding 後無法解析 response body

# 0.3.23 (2021-04-26)
 * bug: 修正fasthttp 回傳 status code 判斷
 * feat: 修正 get instance 回傳值

# 0.3.22.7 (2021-04-21)
 * feat: 修正連線成為 fasthttp 的方式 

# 0.3.22.6 (2021-04-16) 
 * bug: 修正一個 更換IP 會讓 secret 消失的bug 
 * bug: 修正 license unauthorized invalid 拼錯字
 * feat: 現在 purge 的選項可以刪除 inprogress 和 error 狀態的 instances 

# 0.3.22.5 (2021-04-07)
 * feat: 允許 subscription user 使用回傳加密的帳號密碼的API

# 0.3.22.4 (2021-04-01)
 * feat: 取消檢查 mp users me 在 CheckSsoNormalUser

# 0.3.22.3 (2021-03-05)
 * feat: 新增API 回傳加密的帳號密碼
 * bug: 把密碼替換成 * 

# 0.3.22.1 (2021-03-02)
 * bug: #18348 需要為GET /v2/license/info和POST /v2/license/check的前面添加/v2

# 0.3.21.18 (2021-01-25) (0.3.22)
 * bug: #18166 在ESM上配置了OPS_RMQ_URL，但Service Hub沒有套用ESM上的設定
 * bug: #18103 健檢時，即使RabbitMQ連線錯誤，API也返回200
 * bug: #18099 [GET] /license/info和[POST] /license/info的inactiveDays計算方式錯誤

# 0.3.21.15 (2021-01-21)
 * bug: #18109 [GET] /v2/publisher/{subscriptionId}/services 若token沒有該訂閱號的權限，API應該要阻擋
 * bug: #18106 部分NOTIFICATION參數實時更新有誤
 * bug: #18105 建立instance時，若發送rabbitmq message失敗，不應該判定建立instance成功
 * bug: #18103 健檢時，即使RabbitMQ連線錯誤，API也返回200
 * bug: #18102 建議將健檢API檢查失敗時的status code改為503
 * bug: #18101 在env配置一組過期9天的license，獲取license info時，其expireTime卻為空
 * bug: #18099 [GET] /license/info和[POST] /license/info的inactiveDays計算方式錯誤
 * bug: #18096 在ESM Portal上將AUTH_CODE的配置從無效改為有效後，呼叫[POST] /license/check 卻判定license驗證失敗
 * bug: #18095 若CALCULATOR_ENABLE_FLAG為true，pod啟動後，第一次健康檢查一定會失敗
 * bug: #18093 如果OPS_POSTGRES參數要支持實時更新，則更換完OPS_POSTGRES後務必要做一次初始化資料表
 * bug: #18089 Env license無效的情況下，若license server的license也無效，應該要判定license驗證失敗
 
# 0.3.21.14 (2021-01-14)
 * bug: #12597 客戶沒有購買的服務不要列出來，且提供All選項

# 0.3.21.13 (2021-01-12)
 * bug: #17890 呼叫[DELETE] /v2/serviceInstances/{serviceInstanceId}時，發現service hub呼叫了2次SM的deprovision api
 * bug: #17901 啟用ESM時，如果指定一個全新的database作為ops postgres database，則service hub不會自動建立所需的資料表
 * bug: #17905 在ESM Portal將CALCULATOR_ENABLE_FLAG設為true後，service hub因為rabbitmq連不到而一直crash
 * bug: #17909 在ESM修改SECURITY_USER_NAME和SECURITY_USER_PASSWORD，沒有作用
 * bug: #17910 建立instance時，若無法成功publish message至rabbitmq，Service Hub就會crash
 * bug: #17915 若license驗證通過，api回覆的inactiveDays應該要是0
 * bug: #17916 加密或解密license相關資訊時，應加入activeInfo作為加解密的要素之一
 * bug: #17919 [GET] /license/info的回覆不符合規範
 * bug: #17920 [POST] /license/info的回覆不符合規範
 * bug: #17923 當AUTH_CODE有誤時，GET和POST license的回覆中的expireTime返回格式不一致
 * bug: #17933 某個情況下，當license server上的license檢查失敗時，Service Hub依然判定license驗證成功
 * bug: #17978 PUT ​/v2​/userProvided​/{serviceInstanceId} 執行後 secret 為空

# 0.3.21.10 (2021-01-08)
 * feat: 新增penguin參數

# 0.3.21.9 (2021-01-05)
 * bug: charts 底下新增 imagePullSecrets
 * bug: RP,CQ 修改成 201
 * bug: RP,CQ 更改 swagger 描述

# 0.3.21.6 (2020-12-28)
 * feat: code 整理
 * feat: 修正只有 "dedicated" 開頭的才有兩步驟佈署
 * feat: 重新綁定API (不包含重啟pod)

# 0.3.21.5 (2020-12-28)
 * feat: 加上ESM 功能
 * bug: 修正 CI/CD for AXA 環境
 * feat: 加上 livenessProbe 需檢查 PG 和 RMQ

# 0.3.21.2 (2020-12-08)
 * feat: 加上 livenessProbe 於 chart 中
 * feat: 加上 CI/CD for AXA 環境，更改helm chart 位置
 * feat: 新增統一的 License API 
 * bug: #17308 無法更新service broker

# 0.3.20.5 (2020-11-18) (0.3.21)
 * bug: 修正plan 不小心擋到 + 號 

# 0.3.20.3 (2020-11-17) 
 * bug: #17157 [PUT] /v2/userProvided/{serviceInstanceId} 這支API呼叫成功時，應該要回201
 * bug: #17137 刪除plan時，若尚有instance存在，錯誤訊息需要改善
 * bug: #17075 綁定 Redis 時，parameter 為空會發生程式錯誤。

# 0.3.20.2 (2020-11-12)
 * bug: change creater to creator

# 0.3.20.1 (2020-11-11)
 * feat: 多一個欄位判斷 user 自訂義的 broker 
 * bug: redis 綁定時的錯誤修正
 * bug: 修正綁定 parameter 為空時，dccs 出現的錯誤

# 0.3.19.10 (2020-11-03) (0.3.20)
 * bug: auth code 檢查

# 0.3.19.5 (2020-10-28)
 * feat: 修正rabbitmq 連線問題，同時推一版 0.3.18.3.1 專門修改這連線問題
 * feat: 新增參數，給前端查詢狀態用
 * bug: auth code 檢查
 * bug: 修正 redeploy 部分流程 active instance 回200

# 0.3.19.4 (2020-10-27) 
 * feat: 更新 chart，更新環境變數

# 0.3.19.3 (2020-10-13) 
 * feat: 新增認證機制 (License認證)
 * feat: 修正信件內容 (修改標題)
 * feat: 整理所有設定訊息
 * bug: 修正重新發貨API時間問題

# 0.3.19.2 (2020-10-12) 
 * bug: 修正計時器未啟動的錯誤

# 0.3.19.1 (2020-10-8) 
 * bug: 修正 swager 版號和API回傳 statusCode 
 * bug: 修正HZ站點參數錯誤

# 0.3.19 (2020-09-23) 
 * feat: influxdb 新需求
 * feat: 允許不同訂閱號下，相同名稱的 secret name 互相合併

# 0.3.18.7.1 (2020-09-21) 
 * feat: 優化 postgresql 連線處理
 * feat: 與 ESM/ECM 整合

# 0.3.18.5 (2020-09-16) 
 * feat: 新增 user provider 選項

# 0.3.18.4 (2020-09-14)
 * feat: 新增 plan API (需要維運人員先建立 User-Provided plan 好) 
 * feat: 新增 user provider API https://shimo.im/docs/loqeWmBM9LuLBdAn
 * feat: 新增自行購買API
 * feat: catalog 開關關閉時 不連線 rabbitmq 
 * bugfix: 修正寄信內容會有資訊缺少的問題，改使用servicehub client token 詢問

# 0.3.18.3 (2020-08-14)
 * bugfix: 7天後到期不應該去呼叫 service Manager
 * 每日檢查會印出下一次檢查時間和日期

# 0.3.18.2 (2020-08-13)
 * bugfix: #15763: 建議把通知信裡的更新時間和最後更新時間移除
 * bugfix: #15752: 建立instance成功，但收到的通知信內，狀態碼卻是204，而不是201
 * bugfix: #15764: 退訂信裡交易ID是空的
 * bugfix: #15774:「收到回覆的狀態碼」用意不明確
 * bugfix: #15775: 退訂時沒有更新actived_at

# 0.3.18.1 (2020-08-10) 
 * bugfix: #15708: 即使已關閉寄信功能，service hub也會不停寄信
 * bugfix: #15234: 刪除instance時(deleteData=true)，Service Hub沒有真正呼叫SM去將instance完整刪除
 * bugfix: #15594: 透過cascade=true的方式刪除instance，通知信標題所寫的天數錯誤
 * bugfix: #15544: [Chart] 移除chart裡用不到的檔案
 * bugfix: 修改寄信內容和判斷式


# 0.3.17.8 (0.3.18) (2020-08-04)
 * bugfix: #15562: 不應該有將料號寫死的情況
 * bugfix: #15545: [Chart] Chart預設資源過小

# 0.3.17.7 (2020-08-03)
 * bugfix: #15451: [GET] /v2/cluster/list此API需支持顯示deploymentName
 * bugfix: #15271: [GET] /v2/servicebrokers需要將帳密隱藏
 * bugfix: #15466: [GET] 解決常常因為token失效而被登出Portal的問題
 * bugfix: #15209: 信件中的檢查完成次數不會更新
 * bugfix: #15210: 無法成功寄送通知信
 * bugfix: #15234: 刪除instance時(deleteData=true)，Service Hub沒有真正呼叫SM去將instance完整刪除
 * bugfix: #15248: 若建立dedicated instance失敗，資料庫紀錄的狀態不正確
  
# 0.3.17.6 (2020-07-23)
 * feat: 取消駝峰與底線兼容的API
 * bugfix: broker 帳密隱藏，當缺少: 和 @ 時不噴錯
 * bugfix: 修正resource API 回傳的錯誤訊息不是 last operation 
 * bugfix: #15251: 寄信內容缺少訂閱號名稱和公司資訊

# 0.3.17.3 (2020-07-20)
 * bugfix: #15221: 呼叫[POST] /v2/clusters/shared時，沒有將deploymentProperties送去給Service Manager
 * bugfix: #15214: Dedicated Overview未計算到除了Dedicated-Single-Small以外的dedicated instance

# 0.3.16.12 (0.3.17) (2020-07-16)
 * bugfix: #15127: Overview API顯示出的dedicated instance數量有誤
 * bugfix: #15125: 嘗試建立dedicated instance時，API會得到502的回覆
 * bugfix: #15019: 透過[GET] ​/v2​/datacenterCode​/{datacenterCode}​/overview查詢MongoDB的數量，卻得到PortgreSQL的數量
 * bugfix: #15153: 配合SM的manual和resources兩支API的修改，Service Hub在調用SM API時，需要調用新版API，且須兼容新舊版 (未測)
 
# 0.3.16.10 (2020-07-13)
 * feat: 新增寄信包含 datacenterCode

# 0.3.16.9 (2020-07-13)
 * feat: 新增寄信功能
 * bugfix: 修正 deprovision 異步時，可以區分deleteData，並修正狀態。

# 0.3.16.8 (2020-07-8)
 * bugfix: 修正 broker 檢查錯誤
 * bugfix: 修正 manual overview API 只有查詢到 Postgresql 的錯誤
 * bugfix: #14968: 將料號轉換成service manager 看得懂得 resource type
 * bugfix: #14947: 提供健康檢查用的API

# 0.3.16.6 (2020-07-8)
 * bugfix: 更新 rmq 參數
 * bugfix: 更新 staus 回傳為 lifecycle status
 * bugfix: 快速修正all訂閱API的bug

# 0.3.16.1 (2020-07-8)
 * feat: 修正了檢查訂閱號的API
 * bugfix: #14435: instances資料表沒有區分instance被退訂時間點、以及7天後真正被刪除的時間點
 * bugfix: #14459: 呼叫[DELETE] /v2/cluster/dedicated/{pseudoId}後，沒有將dedicated instance的狀態從Inactive變None
 * bugfix: #14486: 若查不到instance的company和subscription name，需回覆N/A
 * bugfix: #14723: [PUT] /v2/servicebrokers這支API沒有更新到serviceName
 * bugfix: #14696: 依照SM資源管理API的新設計，修改對應的API
 * bugfix: #14777: 新增一支API查詢當前環境是公有雲 / 私有雲
 * bugfix: #14786: 新增 plan name list 的API，讓UI 能夠知道現在的 service 和 plan 有哪些，json 格式回傳
 * bugfix: #14894: 修改Dedicated Overview頁面的設計，因此Service Hub也要修改對應的API
 * bugfix: #14242: 接收catalog訊息用的queue讓部署人員自行設定queue名稱
 * bugfix: #14498: 資源管理的API，將得到的status轉為lifecycle_status的用詞

# 0.3.15.14 (0.3.16) (2020-07-01)
 * bugfix: #13740 [PUT] /v2/serviceCredentials/{dccsKey} 請將該API的description欄位改為非必填，且允許任意字元
 * bugfix: #14658 設定CALCULATOR_ENABLE_FLAG為false，但呼叫[PUT] /v2/serviceInstances/manual時卻得到serviceInstanceId not found from catalog之錯誤
 * bugfix: #14666 Instance刪除後，再建立同樣instance id的instance，但一點進instance時得到instance已被刪除之訊息
 * bugfix: put broker 少更新 serviceName

# 0.3.15.13 (2020-06-30)
 * feat: 允許pipeline 通過
 * bugfix: #14658 設定CALCULATOR_ENABLE_FLAG為false，但呼叫[PUT] /v2/serviceInstances/manual時卻得到serviceInstanceId not found from catalog之錯誤

# 0.3.15.12 (2020-06-28)
 * bugfix: Bug #14439 Inprogress狀態在資料庫中大小寫與其他狀態不一致
 * bugfix: Bug #14576 呼叫[PUT] /v2/serviceInstances/manual時，若發生serviceInstanceId not found from catalog的錯誤，instance不應該能成功建立
 * bugfix: Bug #14579 刪除inprogress的instance時，回覆的訊息有誤
 * bugfix: Bug #14540 [GET] /v2/serviceInstances/all 該API將被刪除的instance一併列出來了 
 

# 0.3.15.11 (2020-06-18)
 * 默認service instance name 轉小寫
 * bugfix: Bug #14441 Deprovision時，若得到SM的回覆為404，service hub無法正常反應
 * bugfix: Bug #14439 Inprogress狀態在資料庫中大小寫與其他狀態不一致
 * bugfix: Bug #14457 [POST] /v2/serviceInstances沒有擋重複的instance id
 * bugfix: Bug #14428 調用[PUT] /v2/serviceInstances/manual後，instance name沒有維持用戶當初取的名稱
 * bugfix: 修正client 呼叫MP create secret
 * bugfix: Bug #14436 不管對dedicated instance做任何事，actived_at的時間點都不會更新
 * bugfix: Bug #14500 呼叫[PUT] /v2/serviceInstances/manual時，若輸入的subscriptionId與資料庫內記錄的不一致，錯誤訊息不明確
 * bugfix: Bug #14501 呼叫[PUT] /v2/serviceInstances/manual時，若輸入的serviceInstanceId不存在，沒有錯誤訊息
 * bugfix: Bug #14496 若呼叫[DELETE] /v2/serviceInstances/{serviceInstanceId}嘗試刪除一個Inactive instance，全部訂閱號的Inactive instance都會被刪除
 * bugfix: Bug #14484 [GET] /v2/serviceInstances/all 這支API沒有返回Inactive和Inprogress的instance
 * bugfix: Bug #14433 精簡[PUT] /v2/serviceInstances/manual 的必填參數

# 0.3.15.10 (2020-06-16)
 * bugfix: 修正 Dedicated 同步 catalog 參數值未通知
 * bugfix: 修正 Dedicated service instance name 沒有與原本的訂閱時相同

# 0.3.15.9 (2020-06-16)
 * feat: 修正v2版本訂閱流程，dedicated部分
 * bugfix: deleteData 參數修正

# 0.3.15.8 (2020-06-16)
 * bugfix: 新增influxdb 服務 v2 流程

# 0.3.15.7 (2020-06-15)
 * feat: 新增 dedicated manual 的API，只會將Inprogress的服務更新，會檢查
 * feat: 新版 catalog/v2/ 訂閱API，會判斷是否是 dedicated 服務，如果是dedicated服務，會設定狀態為Inprogress
 * feat: cancel 那一隻API 一律帶上 cascade 參數
 * feat: 調整檢查訂閱是否完成的時間間隔
 * feat: list API 404 回傳先過濾
 * bugfix: lifecycle status 修正
 * bugfix: call SSO 查詢訂閱號列表太久，需調整
 * bugfix: 修正bug #14185 建立instance時，若使用的service instance name已被使用，錯誤訊息有誤


# 0.3.15.6 (2020-06-12)
 * feat: 新增all 的API

# 0.3.15.5 (2020-06-12)
 * feat: 多加上參數 activedAtTimestamp
 * bugfix: serviceInstanceId 參數錯誤

# 0.3.15.4 (2020-06-11)
 * feat: 完成 resume API
 * bugfix: category 參數值沒有存入的問題


# 0.3.15.3 (2020-06-10)
 * feat: 新增計時器
 * feat: 新增 status 狀態detached，當7(可變動)天後會出現 delete
 * feat: 新增 lifecycle 狀態None，當7(可變動)天後會由 Inactive 變成 None
 * feat: 新增 resume API
 * bugfix: rmq update API 出現問題修正

# 0.3.15.1 (2020-06-09)
 * bugfix: 修正 list API 回傳內容
 * bugfix: update API 出現問題修正

# 0.3.15 (2020-06-06)
 * feat: 支援管理接口 list API 新增回傳內容
 * feat: 新增執行 catalog API (背景執行)，不算錢
 * bugfix: 修正新版catalog訂閱得時候少了時間
 * bugfix: update API 沒有帶到料號數量

# 0.3.14.4 (2020-06-05)
 * bugfix: 修正 list api 讀取格式

# 0.3.14.3 (2020-06-03)
 * bugfix: 支援管理接口修正
 * bugfix: redis 無法訂閱問題
 * bugfix: 異步訂閱失敗問題

# 0.3.14 (2020-06-01)
 * feat: 支持資源管理接口
 * bugfix: 讓用戶輸入plan 於 post /v2/manual/cluster/shared 接口
 * bugfix: 補上catalog 的 cancel 接口，移除deleteData參數

# 0.3.13.4 (2020-05-29)
 * bug: 修正serviceInstacneName為空時，沒有自動帶入值

# 0.3.13.3 (2020-05-28)
 * feat: 修正傳給catalog參數，舊版要帶舊版參數，新版要帶新版參數，兩者不能並存。
 * feat: 如此這般 dedicated 購買API 在v2 catalog 會失去效用

# 0.3.13.2 (2020-05-22)
 * feat: 修正新帶給 catalog API 的參數

# 0.3.13.1 (2020-05-22)
 * bugfix: serviceParameters 為null
 * bugfix: 檢查料號限制解除 

# 0.3.13 (2020-05-21)
 * feat: 查詢 membertype API 更新
 * feat: 料號檢查
 * bugfix: 修正回傳 actived_at 修正為 activedAt
 * 效能優化: 改善instance 數量很多的時候的建立 binding 和 刪除 binding 時間

# 0.3.12 (2020-05-20)
 * feat: 更新SSO users/me 位置
 * feat: API 加上 datacenterCode (broker,quota)，API 檢查權限位置更動
 * feat: ListingSystem API 修正，加上datacenterCode
 * feat: 新增時間欄位 ActivedAt (於instances表格中)
 * feat: 調整時間格式，都使用utc
 * feat: 更新 catalog 回傳內容
 * bugfix: 更新時間精準度 timestamp ==> timestamp(6)

# 0.3.11 (2020-05-11)
 * feat: 新增client token (半完成)
 * bugfix: #13694 需要將broker-deployment.yaml的appVersion改成apps/v1
 * bugfix: #13727 [POST]/v2/serviceInstances/manual 該API不應阻擋密碼含特殊字元
 * bugfix: #13748 [POST]/v2/serviceInstances/manual 請將這隻API的pnInfo參數改為必填，至少需要填一組
 * bugfix: #13740 [PUT] /v2/serviceCredentials/{dccsKey} 請將該API的description欄位改為非必填，且允許任意字元

# 0.3.10 (2020-05-06)
 * feat: 新增 serviceInstanceName rename API
 * feat: Dedicated manual API 新增 ssl,parameter 參數，authenticationDatabase 必填移除
 * feat: 新增 Shared manual API，必填external host 移除
 * feat: dccs key enable 的時候，需要帶上舊有的參數值
 * feat: 支持rmq 升級API
 * bugfix: 修正 serviceInstanceName 未定義的時候，帶上完整InstacneId

# 0.3.9 (2020-04-30)
 * feat: 更新 changelog
 * feat: 新增查詢剩餘數量API
 * feat: 新增broker建立、刪除、更新等API
 * feat: RabbitMQ 註冊時攜帶參數
 * bugfix: 修正回傳數值統一
 * bugfix: datacenterAdmin 改為查詢 MP role 

# 0.3.8 (2020-04-28)
 * feat: 更新 sso 權限檢查

# 0.3.7 (2020-04-19)
 * feature: 移除mongodb時帶上replicasetName
 * feature: 支持新的 catalog (汪輝那邊) 回傳訊息
 * feature: 增加新的API 送貨退貨回收
 * feature: dataService 更名為 pnInfo

# 0.3.6.6 (2020-04-10)
 * feature: 新增mongodb時帶上replicasetName
 * bugfix: 修正dccs 部分的 parameter bug

# 0.3.6.4 (2020-04-9)
 * feature: 新增redis服務綁定時會做參數檢查的功能
 * feature: 新增dccs recreate API
 * feature: 訂閱時允許 catalog client token
 * feature: 新增mongodb時帶上replicasetName

# 0.3.5 (2020-04-1)
 * feature: 更正reids 呼叫 redis service manager

# 0.3.4 (2020-04-1)
 * feature: 新增自訂義API，可以自訂instance id (搬遷用)
 * feature: 新增傳入 pnQuantity
 * bugfix: 修正swagger 路徑，改為放在/public/openapi 底下
 * bugfix: 修正查詢用戶membertype API
 * bugfix: 修正manual unbind 遭遇到交易ID不存在的錯誤和錯誤訊息
 * bugfix: 修正當無法正常建立secret時，Binding 卻成功建立


# 0.3.3
 * feature: 移除dataService結構中的 serviceName
 * feature: 新增dedicater manual API，可以呼叫小SB做dedicate的各種操作
 * feature: 新增查詢 database name 列表查詢API
 * feature: 新增迴圈刪除binding功能
 * bugfix: 刪除secret 失敗時(如果namespace不存在時)不中斷，回傳204
 * bugfix: changeType 修正為 chargeType
 * bugfix: helm chart 修正 錯誤和 API 位置 
 

# 0.3.2
 * feature: 算錢和不算錢合併，新增一開關的環境變數
 * feature: 新增timeout 時間環境變數
 * feature: rabbitmq 改為 TLS，並忽略
 * feature: 新增查詢 database API 
 * bugfix: get broker 權限修正，其他權限修正
 * bugfix: api timeout 時間延長

# 0.3.0
 * feature: redis binding 的額外需求
 * feature: 新增與catalog 溝通機制 (會送價錢)
 * feature: 新增檢查交易ID功能
 * feature: 修改 helm chart 內容
 * feature: post 訂閱結構改變  dbservice 裡面的 serviceInstanceName 換成 serviceName 
 * bugfix: delete purge 此操作沒有正常執行的bug
 
# 0.2.20
 * 修正 UI list API 會有重複的值的問題。
 * 修正 secret name 相同但不同 namespace 會被 merge 的問題
 * 修正 post 所需要帶上的參數，根據db-buy 會傳來的訊息改了內容，同時Get Service 也一併修正
 * planName => servicePlanName 
 * 新增 dataService 陣列 ，需要帶上 pn 
 * 新增 chargeType 和 serviceProperty
 * Manual 手動新增功能
 * Redis 在 Post binding 時可以建立 secret 
 * 新增計算價錢功能與傳送catalog DB
 * 修改 helm chart ，新增RMQ 位置，URL配置

# 0.2.13
 * 修改SSO權限，讓admin操作方便點
 * DCCS 除了GET之外，其他都接上 SSO
 * 修正一個swagger筆誤，serviceInstanceId

# 0.2.12 (2/24)
 * 新增appName關聯API 2隻(post和 delete)，一隻留給 admin 測試 (Get)
 * 新增 dccs list API ，給 service UI 使用
 * 修正 dccs 回傳不統一，有駝峰有底線的問題
 * 修正 disable 的 key ，被get 的時候是回 404
 * 新增查詢 service name API給UI 

# 0.2.10
 * 新增異步功能，會每30秒詢問狀態，持續20分鐘
 * 新增dccs enable 和 disable 功能
 * 新增dccs post 和 delete 功能，其操作會影響現有的bind和unbind對映關係。
 * binding 現在會產生dccs key

# 0.2.8
 * 基本 service broker api 操作與儲存功能

# 0.2.4
 * add dccs founction
 * add async founction (not test)
 * bug fix

# 0.1.2
 * add service api
 * add store db function
 * add call small sb api

# 0.1.1
 * add publisher api
 * add store db function
 * start to call small sb api

# 0.1.0
 * copy mongodb service broker (change source to github.com/openservicebrokerapi/osb-checker)
 * add parser catalog function
 * change something about mongodb into service-broker
