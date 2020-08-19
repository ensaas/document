## Service-Portal-UI 1.1.1 (2020-08-19)

**新特性：**

- #15897 Parameters新增支持Array型別
- #15044 Service Usage頁面改為動態獲取Plan清單


## Service-Portal-UI 1.1.0.4 (2020-08-07)

**新特性：**

- Overview頁面支持顯示MongoDB服務


## Service-Portal-UI 1.1.0.3 (2020-08-04)

**新特性：**

- 移除Tickets按鈕


## Service-Portal-UI 1.1.0.2 (2020-07-23)

**新特性：**

- #15268 資源管理頁面修改需求

**修改Bug：**

- #15305 需移除Create Dedicated Instance畫面針對Username和Password的限制


## Service-Portal-UI 1.1.0.0 (2020-07-15)

**新特性：**

- #13962 【管理运维】提供給Shared Cluster Overview用的页面 (僅支持PostgreSQL)
- #13938 【管理运维】提供給Dedicated Cluster Overview用的页面 (僅支持PostgreSQL)
- #14596 新增服務管理頁面
- #14659 若instance狀態為inprogress或Inprogress，將其呈現為In Progress
- 搜尋框改為按enter鍵觸發搜尋功能
- 可編輯、複製的按鈕改為將游標移入表格時才會顯示icon
- 重新命名實例的按鈕添加tooltip
- 畫面缩小时，添加修改實例名稱的功能

**修改Bug：**

- 修復select下拉式選單定位錯誤
- #13750 使用到冒號的地方，英文應使用半形字，中文使用全形字
- #14721 切換到Service Usage時，明明有instance存在，卻顯示No Instance


## Service-Portal-UI 1.0.2.8-patch (2020-07-08)

**新特性：**

- 配合AFS修改服務名稱為AIFS，調整Service Usage頁面


## Service-Portal-UI 1.0.2.8 (2020-06-24)

**新特性：**

- 支持顯示全部訂閱號的instance
- 封鎖狀態為Inprogress/Inactive的instance的Action按鈕
- 更新建立dedicated instance的填寫畫面
- 增加RabbitMQ dedicated instance的Role的下拉式選單選項，追加Policymaker、Monitoring、Administrator、Impersonator
- 微調部分文字

**修改Bug：**

- #14481 新增參數的部分，key需要擋空格


## Service-Portal-UI 1.0.2.6 (2020-06-16)

**新特性：**

- Instance狀態新增Inactive和Inprogress
- 建立dedicated instance畫面的料號阻擋空格
- 新增專用實例畫面將Service Category改為必填，並且於Service Property新增默認值Basic
- 建立dedicated instance時用的API從[POST] /v2/serviceInstances/manual 改 [PUT] /v2/serviceInstances/manual


## Service-Portal-UI 1.0.2.4 (2020-06-04)

**新特性：**

- 參數部分新增下拉式選單，可選擇參數的型別


## Service-Portal-UI 1.0.2.2 (2020-05-26)

**修改Bug：**

- 14055 Service Usage页面的提示句中的standard的s应为小写
- 13919 左方清单样式尽量与MP的样式相近
- 14009 【ServicePortal】Service Usage过滤条件加上Service Plan
- 13919 左方清单样式尽量与MP的样式相近
- 13983 可能需要过滤AFS的两个料号9806WPAFS0和9806WPAFS1
- 14022 若用浏览器的上一页按钮退回前页，会有左上方的选单选项无法点选的问题
- 14031 Service Usage页面的Instance Name显示不正常


## Service-Portal-UI 1.0.2.0 (2020-05-21)

**新特性：**

- 添加监控服务用量的看板


**修改Bug：**

- 13915 显示用量时，连接到的dashboard应该要使用当前平台的dashboard
- 13918 Consumption改回Service Usage
- 13916 Service Name下拉式选单只需要保留MongoDB、PostgreSQL、RabbitMQ、AFS
- 实例名称的下拉式选单只列出plan为Shared或standard的instance
- 页面上方提示本页面支持显示哪些服务的用量
- 13922 若从Service Instances页面选择Redis服务，再切换去Service Usage页面，会显示Redis的instance资料
- 13923 需隐藏Dashboard上方以及左方的功能列
- 13921 页面上方提示本页面支持显示哪些服务的用量


## Service-Portal-UI 1.1.0.8 (2020-08-19) for private cloud

**新特性：**

- #15897 Parameters新增支持Array型別


## Service-Portal-UI 1.0.1.6 (2020-05-15)

 **修改Bug：**
 - 13855 生产环境上，Service Key Name的连接在部分电脑上打不开


## Service-Portal-UI 1.0.1.5 (2020-05-12)

 **修改Bug：**
 - 13773 對文字部分的建議 part4
 - 13728 修改instance名稱時，請加上不得超過150字元的阻擋，且只允許[a-zA-Z0-9_-.]
 - 13751 增加建立 / 編輯服務密鑰時對描述欄位的限制


## Service-Portal-UI 1.0.1.4 (2020-05-11)

 **修改Bug：**
 - 13729 在Secret Management頁面若instance名稱太長，名稱會和其他項目重疊到                                      
 - 13723 編輯description的欄位必須是必填                                                              
 - 13737 搜尋instance完點進Secret Management，會顯示不出secret，且退出Secret Management後，顯示的instance列表不正確  
 - 13728 修改instance名稱時，請加上不得超過150字元的阻擋，且只允許[a-zA-Z0-9_-.]                                   
 - 13149 部分文字沒有被加入語言檔，需要補加入                                                                 
 - 13744 建立secret時應阻擋輸入大寫                                                                   
 - 13632 匯入Dedicated DB功能的調整意見(初步)                                                          
 - 13746 需移除參數部分對特殊符號的限制，另需添加鍵不得為空的限制                                                       
 - 13747 若service key列表中有任何key的描述為空，該欄位會無法排序                                                
 - 13751 增加建立 / 編輯服務密鑰時對描述欄位的限制                                                             
 - 13674 對文字部分的建議 part3 


## Service-Portal-UI 1.0.1.3 (2020-05-08)

 **新增和修改:**
 - 重命名instance 名称

 **修改Bug:**
 - 13667 匯入Dedicated DB問題統整
 - 13647 對文字部分的建議 part3

## Service-Portal-UI 1.0.1.2 (2020-05-07)
 **修改Bug：**
 - 13629 編輯service key的畫面中，description欄位消失了
 - 13628 當服務為RabbitMQ時，應移除畫面上的容量
 - 13654 在View的頁面裡json字串太靠邊界，需要增加與邊界的間距
 - 13149 部分文字沒有被加入語言檔，需要補加入
 - 12690 若參數的值為空，也應該送出值為空的請求；若不允許值為空，則需於前端阻擋
 - 13632 匯入Dedicated DB功能的調整意見(初步)
 - 13658 建立secret時，若輸入非法字元，顯示的錯誤訊息有誤
 - 13226 針對RabbitMQ的建立secret和建立service key的畫面進行修改
 - 13227 移除畫面上方會顯示的tooltip
 - 13655 匯入Dedicated DB頁面的提示句
 - 13219 Credentials中的複製按鈕按下後，複製到的字串建議不包含雙引號
 - 13663 匯入Dedicated DB時，Service Instance Name不需要阻擋符號在開頭或結尾
 - 13665 需要記憶instance排列方式

## Service-Portal-UI 1.0.1.1 (2020-04-30)

 **修改Bug：**
 - 13610 Global admin登入後，看不到匯入Dedicated DB的按鈕


## Service-Portal-UI 1.0.1 (2020-04-29)

 **新增和修改:**
 - react-json-view 组建样式调整
 - table list length 小于等于5时。隐藏分页组建
 - vhost name 输入问题
 - api: /datacenter未能正常返回数据时，取消dccs key name的点击功能
 - 读取cookie取得默认订阅号
 - 密钥管理页面：当列表为空的时候，新建时，输入名称时报错

 **修改Bug：**
 - 13149 部分文字沒有被加入語言檔，需要補加入
 - 13137 將畫面縮至67%後，Subscription Name的下拉式選單會移至第二排
 - 13136 將畫面縮小後，用戶中心的icon會移位
 - 13133 應記下用戶選擇的分頁選項
 - 13223 於Secret Management畫面切換頁籤時，應記下用戶選擇的選項
 - 13134 對文字部分的建議 part2
 - 13227 移除畫面上方會顯示的tooltip
 - 13219 Credentials中的複製按鈕按下後，複製到的字串建議不包含雙引號
 - 13226 針對RabbitMQ的建立secret和建立service key的畫面進行修改
 - 13147 建立密鑰時，若cluster底下無任何workspace，或workspace底下無任何namespace，希望提示給使用者
 - 13258 建立secret或service key時，希望能加大參數按鈕與底下參數的間隔
 - 13225 建立secret時，阻擋在同cluster / workspace / namespace下建立重複的secret名稱 
 - 13200 建立secret時，阻擋用戶輸入重複的parameters
 - 13338 建立service key時，description欄位應為非必填項目 
 - 113307 匯入Dedicated DB功能詳細需求
 - 13570 請將頁面標題改為Service Portal
 - 13568 若將Portal的網址後面部分亂打，則將頁面導回Portal的主頁

## Service-Portal-UI 1.0.0.11 (2020-04-20)

 **修改Bug:**
 - 13302 當獲得database / vhost清單時若回覆為空，UI會不停嘗試讀取database / vhost清單


## Service-Portal-UI 1.0.0.10 (2020-04-16)

 **新增和修改:**
 - Service Instance list 表格新增显示service instance id
 - 将 service name：p-rabbitmq 替换为RabbitMQ
 - DB Dedicated Plan开放建立secret
 - 开放所有Plan的新建secret功能
 - secret management页面 secret name 位置固定
 - secret list 不显示问题
 - 创建secret、service key时可以选择db name或自行输入新db name
 - rabbitmq service建secret时新增vhost name选项
 - dccs key name 添复制功能
 - DCCS Key Name点击打开新页面显示credentials
 - 更改DCCS Key为Service Key
 - 去掉view json 中的root
 - 模态框查看详情时添加parameters 项
 - 模态框表单select添加搜索
 - 头部document跳转语言错误问题
 - antd 组件全局化配置
 - table 分页添加每页显示条数下拉框选单
 - dropdown & select 下拉框定位问题

 **修改Bug：**
 - 12690 若參數的值為空，也應該送出值為空的請求；若不允許值為空，則需於前端阻擋
 - 13093 建立shared instance的secret時，不需要提供Database Name欄位
 - 13095 應開放所有Plan都能建立secret
 - 13198 建立RabbitMQ的key時，Role / Topic Read Path / Topic Write Path改為選填
 - 13199 每次建立dedicated secret/service key時，應重新獲取Database Name清單
 - 13203 若選擇了一個database name，無法改回空白的database name
 - 13205 建立secret / service key時輸入的Database Name須限制只能A-Z、a-z、0-9以及橫線(-)，橫線不得在開頭，上限63字元
 - 13210 InfluxDB的dedicated plan也要提供選擇Database Name的功能

## Service-Portal-UI 1.0.0.51 (2020-03-31)

 **新增和修改：**
 - 导航栏中订阅号下拉框添加公司名称

## Service-Portal-UI 1.0.0.5 (2020-03-27)

 **新增和修改：**
 - 响应式表格（屏幕变小，table组件会替换为description组件）
 - header 添加Support（弹出框显示邮箱）
 - header 添加tickets Icon
 - header Supprot替换为Tickets
 - instance list 无法加载问题
 - tabel 每页显示10条数据

 **修改Bug：**

- 12825 有取得datacenterCode，但右上圖示沒有顯示站點


## Service-Portal-UI 1.0.0.41 (2020-03-23)

 **新增和修改：**
 - 添加表格的表头排序功能
 - 添加返回页面顶部功能
 - 更换订阅号API(SSO/subscriptions)


## Service-Portal-UI 1.0.0.4 (2020-03-20)

 **新增和修改：**
 - 页面内部侧边菜单栏
   - 服务实例管理页面添加左侧菜单栏
   - 做菜单栏的显示与收起
   - secret和DCCS的tab切换替换为左侧菜单栏切换
   - 更换订阅号API(SSO/users/me：roles)

 **修改Bug：**
 - 12696 需限制密鑰名稱和DCCS Key描述不能超過150字元
 - 12703 DCCS Key Name若不需要提供連結或功能，不應以連結方式呈現
 - 12690 若參數的值為空，也應該送出值為空的請求；若不允許值為空，則需於前端阻擋
 - 12566 登入後未顯示Instance清單，要F5後才能正確顯示列表
 - 12558 若因dccs異常而導致無法建secret，沒有任何錯誤訊息


## Service-Portal-UI 1.0.0.3 (2020-03-18)

 **新增和修改：**
 - 替换所有Icon

 **修改Bug：**
 - 12654 右上圖示若沒作用，建議取消連結，且電腦圖示需要新開視窗
 - 12673 刪除DCCS Key時，調用DCCS API時不應帶body
 - 12610 英文語系文字錯誤


## Service-Portal-UI 1.0.0.2 (2020-03-17)

 **新增和修改：** 
 - 密钥管理页面：
   - 新建密钥中的parameters改为非必填
   - 根据plan控制用户是否可以新建密钥
   - 查看时，模态框仅显示确认按钮

 - 密钥管理页面(DCCS)：
   - 添加
   - 列表
   - 查看
   - 编辑
   - 停用
   - 删除
 - App 列表页面：
   - datacenter 列表
   - cluster 列表
   - workspace 列表
   - namespace 列表
   - 四级联动下拉选单
   - 获取 App 列表
 - 页面Header：
   - 订阅号下拉选单，切换订阅号
   - 隐藏暂未开发的链接Icon
   - 链接在新页签中打开
   - 更换浏览器页签Icon以及title(service console)
   - 登出功能
 - 侧边菜单栏
   - 添加侧边菜单栏
   - 隐藏除服务实力外的其余menu
 - 隐藏服务实列页面操作中的取消订阅和服务管理
 - 服务下拉选单，切换服务
 - 多语言文字修改

 **修改Bug：**
 - 12556 只要一在Secret Management的搜尋欄打字，頁面就會直接變空白
 - 12553 [HZ站點] 點選左上LOGO，會連到空的頁面
 - 12554 若Instance Name沒有要提供連接至其它地方的功能，不應以連結方式呈現
 - 12561 正體中文時，Secret Management標題還是英文
 - 12562 右上選單的大小寫不一致
 - 12563 右上選單的中文用詞建議與SSO一致
 - 12564 上方選單的用詞建議與SSO一致
 - 12571 點進Secret Management後，instance name的開頭會變大寫
 - 12572 編輯description時，填寫欄位應該要先清空
 - 12577 刪除DCCS Key時的確認訊息建議修改
 - 12579 建立Secret或DCCS Key時，填寫欄位應該要先清空
 - 12032 Billing頁面為空白
 - 12029 畫面用字不應中英文混雜
 - 12588 刪除DCCS Key時，Service Console應該要呼叫DCCS的API，而不是Service Hub的API
 - 12578 在Secret Manager頁面，先切到DCCS Key，再切回Secret，欄位上會出現一個痕跡
 - 12559 View secret的畫面，若無編輯功能，OK或Cancel是否要拿掉一個按鈕？
 - 12596 列出instance時，應增加過濾條件datacenterCode
 - 12649 提供All選項顯示已訂閱的所有instance
 - 12610 英文語系文字錯誤
 - 12605 切成中文語系時，DCCS Key頁籤還是顯示英文
 - 12035 Log Out按鈕沒有作用，與SSO的按鈕也不一致
 - 12034 左上選單按鈕沒有作用
 - 12033 顯示的subscription name不正確
 - 12030 服務選單上多出現一個名為rmq的服務
 - 12031 頁面標題不正確
 - 12028 登入subscription admin帳號後，任意選一個服務，選完都會彈出一個空白視窗
 - 12027 若未登入SSO，應將使用者導至SSO登入頁面
 - 12133 登入了subscription admin帳號，還是顯示401驗證失敗
 - 12654 右上圖示若沒作用，建議取消連結，且電腦圖示需要新開視窗
 - 12635 對文字部分的建議


## Service-Portal-UI 1.0.0.1 (2020-02-19)

 **新增和修改：**
 - 服务实例列表页面：
   - 获取列表
   - 取消订阅
 - 密钥管理页面(secret)：
   - 密钥列表
   - 添加密钥
   - 删除密钥
   - 重建密钥
   - 查看
