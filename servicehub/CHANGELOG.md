#0.3.2
1. 算錢和不算錢合併，新增一開關的環境變數
2. 新增timeout 時間環境變數
3. rabbitmq 改為 TLS，並忽略
4. 新增查詢 database API 
5. get broker 權限修正，其他權限修正
6. api timeout 時間延長

#0.2.20
1.	修正 UI list API 會有重複的值的問題。
2.	修正 secret name 相同但不同 namespace 會被 merge 的問題
3.	修正 post 所需要帶上的參數，根據db-buy 會傳來的訊息改了內容，同時Get Service 也一併修正
planName => servicePlanName 
新增 dataService 陣列 ，需要帶上 pn 
新增 chargeType 和 serviceProperty
4.	Manual 手動新增功能
5.	Redis 在 Post binding 時可以建立 secret 
6.	新增計算價錢功能與傳送catalog DB
7.	修改 helm chart ，新增RMQ 位置，URL配置

#0.2.13
1. 修改SSO權限，讓admin操作方便點
2. DCCS 除了GET之外，其他都接上 SSO
3. 修正一個swagger筆誤，serviceInstanceId

#0.2.12 (2/24)
1. 新增appName關聯API 2隻(post和 delete)，一隻留給 admin 測試 (Get)
2. 新增 dccs list API ，給 service UI 使用
3. 修正 dccs 回傳不統一，有駝峰有底線的問題
4. 修正 disable 的 key ，被get 的時候是回 404
5. 新增查詢 service name API給UI 

#0.2.10
1. 新增異步功能，會每30秒詢問狀態，持續20分鐘
2. 新增dccs enable 和 disable 功能
3. 新增dccs post 和 delete 功能，其操作會影響現有的bind和unbind對映關係。
4. binding 現在會產生dccs key

#0.2.8
1. 基本 service broker api 操作與儲存功能

# 0.2.4
## Feature
 * [+] add dccs founction
 * [+] add async founction (not test)
 * [+] bug fix

# 0.1.2
## Feature
 * [+] add service api
 * [+] add store db function
 * [+] add call small sb api

# 0.1.1
## Feature
 * [+] add publisher api
 * [+] add store db function
 * [+] start to call small sb api

# 0.1.0
## Feature
 * [+] copy mongodb service broker (change source to github.com/openservicebrokerapi/osb-checker)
 * [+] add parser catalog function
 * [+] change something about mongodb into service-broker
