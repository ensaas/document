## Service-Console-UI 1.0.0.10 (2020-04-16)

 新增和修改:
 -Service Instance list 表格新增顯示service instance id
 -将 service name：p-rabbitmq 替换为RabbitMQ
 -DB Dedicated Plan開放建立secret
 -secret management secret name 位置固定
 -secret list 不显示问题
 -創建secret、service key時可以選擇db name或自行輸入新db name
 -rabbitmq service建secret時新增vhost name選項
 -dccs key name 添复制功能
 -DCCS Key Name点击打开新页面显示credentials
 -更改DCCS Key为Service Key
 -去掉view json 中的root
 -模态框查看详情时添加parameters 项
 -模态框表单select搜索
 -头部document跳转语言错误问题
 -antd 组件全局化配置
 -table 分页添加每页显示条数下拉框选单
 -dropdown & select 下拉框定位问题
 
 修改Bug：
 1.  12690 若參數的值為空，也應該送出值為空的請求；若不允許值為空，則需於前端阻擋
 2.  13093 建立shared instance的secret時，不需要提供Database Name欄位
 3.  13095 應開放所有Plan都能建立secret
 4.  13198 建立RabbitMQ的key時，Role / Topic Read Path / Topic Write Path改為選填
 5.  13199 每次建立dedicated secret/service key時，應重新獲取Database Name清單
 6.  13203 若選擇了一個database name，無法改回空白的database name
 7.  13205 建立secret / service key時輸入的Database Name須限制只能A-Z、a-z、0-9以及橫線(-)，橫線不得在開頭，上限63字元
 8.  13210 InfluxDB的dedicated plan也要提供選擇Database Name的功能

## Service-Console-UI 1.0.0.51 (2020-03-31)

 新增和修改：
 -导航栏中订阅号下拉框添加公司名称

## Service-Console-UI 1.0.0.5 (2020-03-27)

 新增和修改：
 -响应式表格（屏幕变小，table组件会替换为description组件）
 -header 添加Support（弹出框显示邮箱）
 -header 添加tickets Icon
 -header Supprot替换为Tickets
 -instance list 无法加载问题
 -tabel 每页显示10条数据
 
 修改Bug：
 12825 有取得datacenterCode，但右上圖示沒有顯示站點
 
 
## Service-Console-UI 1.0.0.41 (2020-03-23)

 新增和修改：
 - 添加表格的表头排序功能
 - 添加返回页面顶部功能
 - 更换订阅号API(SSO/subscriptions)


## Service-Console-UI 1.0.0.4 (2020-03-20)

 新增和修改：
 - 页面内部侧边菜单栏
   - 服务实例管理页面添加左侧菜单栏
   - 做菜单栏的显示与收起
   - secret和DCCS的tab切换替换为左侧菜单栏切换
   - 更换订阅号API(SSO/users/me：roles)
  
 修改Bug：
 1.  12696 需限制密鑰名稱和DCCS Key描述不能超過150字元
 2.  12703 DCCS Key Name若不需要提供連結或功能，不應以連結方式呈現
 3.  12690 若參數的值為空，也應該送出值為空的請求；若不允許值為空，則需於前端阻擋
 4.  12566 登入後未顯示Instance清單，要F5後才能正確顯示列表
 5.  12558 若因dccs異常而導致無法建secret，沒有任何錯誤訊息


## Service-Console-UI 1.0.0.3 (2020-03-18)

 新增和修改：
 - 替换所有Icon
 
 修改Bug：
 1. 12654 右上圖示若沒作用，建議取消連結，且電腦圖示需要新開視窗
 2. 12673 刪除DCCS Key時，調用DCCS API時不應帶body
 3. 12610 英文語系文字錯誤


## Service-Console-UI 1.0.0.2 (2020-03-17)

 新增和修改： 
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
 
 修改Bug：
 1. 12556 只要一在Secret Management的搜尋欄打字，頁面就會直接變空白
 2. 12553 [HZ站點] 點選左上LOGO，會連到空的頁面
 3. 12554 若Instance Name沒有要提供連接至其它地方的功能，不應以連結方式呈現
 4. 12561 正體中文時，Secret Management標題還是英文
 5. 12562 右上選單的大小寫不一致
 6. 12563 右上選單的中文用詞建議與SSO一致
 7. 12564 上方選單的用詞建議與SSO一致
 8. 12571 點進Secret Management後，instance name的開頭會變大寫
 9. 12572 編輯description時，填寫欄位應該要先清空
 10. 12577 刪除DCCS Key時的確認訊息建議修改
 11. 12579 建立Secret或DCCS Key時，填寫欄位應該要先清空
 12. 12032 Billing頁面為空白
 13. 12029 畫面用字不應中英文混雜
 14. 12588 刪除DCCS Key時，Service Console應該要呼叫DCCS的API，而不是Service Hub的API
 15. 12578 在Secret Manager頁面，先切到DCCS Key，再切回Secret，欄位上會出現一個痕跡
 16. 12559 View secret的畫面，若無編輯功能，OK或Cancel是否要拿掉一個按鈕？
 17. 12596 列出instance時，應增加過濾條件datacenterCode
 18. 12649 提供All選項顯示已訂閱的所有instance
 19. 12610 英文語系文字錯誤
 20. 12605 切成中文語系時，DCCS Key頁籤還是顯示英文
 21. 12035 Log Out按鈕沒有作用，與SSO的按鈕也不一致
 22. 12034 左上選單按鈕沒有作用
 23. 12033 顯示的subscription name不正確
 24. 12030 服務選單上多出現一個名為rmq的服務
 25. 12031 頁面標題不正確
 26. 12028 登入subscription admin帳號後，任意選一個服務，選完都會彈出一個空白視窗
 27. 12027 若未登入SSO，應將使用者導至SSO登入頁面
 28. 12133 登入了subscription admin帳號，還是顯示401驗證失敗
 29. 12654 右上圖示若沒作用，建議取消連結，且電腦圖示需要新開視窗
 30. 12635 對文字部分的建議
 
 
## Service-Console-UI 1.0.0.1 (2020-02-19)

 新增和修改：
 - 服务实例列表页面：
   - 获取列表
   - 取消订阅
 - 密钥管理页面(secret)：
   - 密钥列表
   - 添加密钥
   - 删除密钥
   - 重建密钥
   - 查看
