# CMA Postgresql ReleaseNote

## 0.2.3

### Fix:
- Bug #14361: 同時鎖定instance的Disk + Call，實際上只有鎖到Disk

## 0.2.2

### Fix:
- Bug #14257: 同時解鎖Call + Disk時，CMA只解鎖Call，Disk沒有被解鎖到

### Update:
- Suggestion #14258: 希望CMA進行動作時，log能把動作印得更明白點

## 0.2.1

### Fix:
- Bug #14093: 進行限制時，若service_instance_list的陣列內容為null時，不應該限制成功
- Bug #14109: 建立具有g_rw_public權限的binding後，將instance鎖定Call，使用者登入後不應該可以進行select操作
- Bug #14132: 連打兩次request，會觸發pq: tuple concurrently updated的錯誤

### Update:
- Suggestion #14092: 建議以JSON格式呈現API的回應內容
- Suggestion #14094: 驗證request是否合法時，建議先驗證Authorization，再驗證Content-type

## 0.2.0

### Add:
- Requirement #12252: 要能夠支援對多個DB作限制
- Requirement #12536: 鎖定用的API需要區分是要鎖Disk還是鎖Call
- 定時重新掃描表格中記錄為執行失敗的instance重新執行限制或解鎖

## 0.1.3

- fix redmine bug #12528: 被限制的instance需要補上TRUNCATE權限
- redmine requirement #12267: 應阻擋對某些特定database作限制

## 0.1.2

- 將spec更新於readme
- swagger的delete api增加body
- fix redmine bug #12243: 部署參數都填正確，但部署完顯示authentication failed
- fix redmine bug #12259: 若限制成功，response code應為201，而不是200
- fix redmine bug #12269: 進行限制時，不需要紀錄隱藏的schema
- fix redmine bug #12271: 呼叫設限或恢復的API時，若header的content-type有誤，response code有誤
- fix redmine bug #12278: 若limit失敗，資料庫裡記錄的failed_count永遠為1
- fix redmine bug #12296: 進行Resume時，若service_instance_list為空，API會回覆兩種結果
- fix redmine bug #12297: 進行resume時，若body為空，API會回覆三種不同的訊息
- fix redmine bug #12299: 若Resume成功，response code應為201，而不是200
- fix redmine bug #12312: 若resume時連接apps database失敗，時間花太久
- fix redmine bug #12313: 若進行resume時PostgreSQL CMA連不到ops postgres，會回覆500 Internal Server Error
- limit→unbind某個是tableowner的user→resume，會造成table找不到原tableowner的問題，目前交還給與instance_id同名的role
- 刪除自動建立ops db的功能

## 0.1.1

- fix redmine bug #12243: 部署參數都填正確，但部署完顯示authentication failed
- fix redmine bug #12259: 若限制成功，response code應為201，而不是200
- fix redmine bug #12269: 進行限制時，不需要紀錄隱藏的schema
- fix redmine bug #12271: 呼叫設限或恢復的API時，若header的content-type有誤，response code有誤
- fix redmine bug #12278: 若limit失敗，資料庫裡記錄的failed_count永遠為1
- fix redmine bug #12282: 若資料庫是乾淨的，進行revoke後，CMA沒有紀錄任何資訊，因此也無法幫使用者resume
- fix redmine bug #12296: 進行Resume時，若service_instance_list為空，API會回覆兩種結果
- fix redmine bug #12297: 進行resume時，若body為空，API會回覆三種不同的訊息
- fix redmine bug #12299: 若Resume成功，response code應為201，而不是200
- fix redmine bug #12312: 若resume時連接apps database失敗，時間花太久
- fix redmine bug #12313: 若進行resume時PostgreSQL CMA連不到ops postgres，會回覆500 Internal Server Error
- 若ops和apps postgres db皆可正常連線，執行resume時會刪除ops table裡已經不存在的role及所屬table，避免下次resume時執行恢復不存在的user的指令

## 0.1.0

- Golang version
