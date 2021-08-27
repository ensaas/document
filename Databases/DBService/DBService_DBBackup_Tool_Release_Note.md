# DBBackup Tool

### 1.0.1/1.0.0.2 (2021-08-20)
- Bug #20430: 當influxdb備份檔案不存在時，不要報錯
- Bug #21355: 備份postgres包含特殊字元的數據庫名稱失敗
- Bug #21674: 還原postgres整個數據庫中的其中一個數據庫時，日誌顯示備份數據庫詳細內容

### 1.0.0.1 (2021-08-06)
- Bug #20947: 還原PostgreSQL失敗後，無法使用原本的root帳密登入數據庫
- Bug #21117: 透過command line建立influxdb備份(填寫rpc port)，influxdb用tcp port執行備份失敗
- Bug #21336: 備份vm postgres整個數據庫，因連線數過多失敗，狀態顯示成功
- Bug #21341: 備份influxdb database v1,7.x失敗
- Bug #21354: 備份mongodb包含特殊字元的數據庫名稱失敗
- Bug #21355: 備份postgres包含特殊字元的數據庫名稱失敗

### 1.0.0/0.0.9.3 (2021/07/29)

- Bug #19081: Backup mongodb整個數據庫，指定已設定使用者權限的數據庫還原至新的數據庫名稱後，使用者無法登入
- Bug #19327: Restore mongodb數據庫未完成，日誌停止在restore document
- Bug #20903: Retry mongodb restore失敗，日誌顯示continuing through error: E11000 duplicate key error collection
- Bug #20950: 還原PostgreSQL單一資料庫時，資料沒有被正確還原到指定的資料庫，卻是被還原到postgres這個資料庫
- Bug #20837: postgresql備份單個數據庫格式改為sql，不做壓縮

### 0.0.9.2

- Bug #18761: Backup / Restore 日誌顯示安全性相關資訊（如：root帳號/密碼）
- Bug #20753: 備份influxdb nodeport失敗，無法取得rpc port資訊
- Requirement #20837: postgresql備份單個數據庫格式改為sql，不做壓縮

### 0.0.9.1

- 修正influxdb check file path

### 0.0.9

- 優化儲存於nfs的log
- Bug #18761: Backup / Restore 日誌顯示安全性相關資訊（如：root帳號/密碼）
- Bug #19737: backup 整個postgres數據庫，還原其中一個數據庫失敗
- Bug #20627: Backup不存在的數據庫時，nfs server日誌紀錄和k8s pod log不完全相同 ，無法知道失敗原因
- Bug #20636: 未完整還原postgres單一數據庫，但restore狀態顯示成功
- Bug #20638: Restore不存在的postgres單一數據庫，狀態顯示成功

### 0.0.8.8

- Bug #20385: 還原influxdb失敗
- Bug #20430: 當influxdb備份檔案不存在時，不要報錯

### 0.0.8.7

- Bug #19737: backup 整個postgres數據庫，還原其中一個數據庫失敗
- Bug #20385: 還原influxdb失敗

### 0.0.8.6
- 修正docker proxy錯誤導致無法mount

### 0.0.8.5
- 修正permission denied拼字錯誤導致辨識失敗的bug

### 0.0.8.4
- Bug #19737: backup 整個postgres數據庫，還原其中一個數據庫失敗
- Bug #19783: 使用非root或非superadmin帳號restore mongodb數據庫失敗，但狀態顯示成功

### 0.0.8.3
- Bug #19737: backup 整個postgres數據庫，還原其中一個數據庫失敗

### 0.0.8.2
- Bug #19016: 使用無任何資料的influxdb 單一數據庫backup file還原(selectedDatabase as "" or 非backup的數據庫名稱)，restore錯誤提示database may already exist
- Bug #19081: Backup mongodb整個數據庫，指定已設定使用者權限的數據庫還原至新的數據庫名稱後，使用者無法登入
- Bug #19660: Restore mongodb數據庫資料不完全，且狀態顯示Succeeded
- Requirement #18505: 還原時，當db名稱重複時的規則
- Requirement #19031: 加入backup/restore database retry機制，避免因網路不穩定，造成backup/restore直接失敗
- Requirement #19325: 阻擋restore mongodb 至admin 數據庫
- Requirement #19629: 修改mongodb還原規格
- New feature: mongodb增加oplog，只有備份整個mongo時可以使用，預設為true。"PARAMS_OPLOG"=false時關閉

### 0.0.8.1
- New feature: Retry mongodb restore，相關issue: #19031, #18694
- Bug #18974: 指定起始/結束時間restore influxdb單一數據庫，未依照設定時間還原資料
- Bug #18279: 指定新資料庫執行還原，但日誌顯示使用舊數據庫還原
- Suggestion #18978: 建議describe dbbackup/dbrestore pod中的Error Message只顯示錯誤的關鍵資訊，而非日誌中一段內容
- Suggestion #18761: Backup / Restore 日誌不顯示安全性相關資訊（如：root帳號/密碼）

### 0.0.8
- Bug #18373: backup influxdb 單一數據庫後restore到全新influxdb數據庫（selectedDatabase as ""），還原失敗
- Bug #18445: Backup PostgreSQL有role設定的單一數據庫，restore失敗，日誌顯示error: role does not exist
- Bug #18458: Backup PostgreSQL未設定role的單一數據庫，執行backup失敗
- Requirement #18505: 還原時，當db名稱重複時的規則
- New feature: Store <backupname>.dbbackup in nfs for backup infomation.

### 0.0.7
- Bug #18278: Restore mongodb (all collection)失敗，status仍顯示Succeeded
- Bug #18294: 用不存在的數據庫名稱或只有使用者資訊的數據庫執行備份，顯示備份成功，但restore失敗

### 0.0.6
- first version

### 0.0.5
- unreleased test version
