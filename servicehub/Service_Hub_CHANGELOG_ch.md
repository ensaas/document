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
