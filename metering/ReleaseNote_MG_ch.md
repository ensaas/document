# 1.2.0.1 (2020-09-15)

# New Features

- CM設定API
- 支援數字開頭Metric （正則： /[a-zA-Z]|\\d|\\.|-|_+/）
- 對於新部署的mg，加入部份已知pn的metric

# Bug Fixes

- Bug #11736 MG的API應加上身分驗證，避免外部人士任意呼叫

- Bug #11745 呼叫PUT /services，若statistic未帶或為空，提示訊息不明確

- Bug #11750 PUT /services 該API應阻擋pn及metric name使用英數字以外的符號 (正則： /[a-zA-Z]|\\d|\\.|-|_+/)

- Bug #11761 呼叫PUT /services時，若put data為空，不應該能呼叫成功

- Bug #12331 呼叫PUT /v2/connectors時，若put body全空，不應該能呼叫成功

- Bug #12357 新增connectors時，若沒成功寫進資料庫，API不應該回201

- Bug #12359 新增connectors時，若port輸入非int型態的資料，API不應該回覆200

- Bug #12362 刪除connector時，若刪除成功，回覆不正確

- Bug #12365 若刪除connector時沒有刪除到任何東西，建議修改回覆的response code或message

- Bug #13378 呼叫GET /v2/usages/{pn} 時，若缺少必要參數，錯誤訊息用字有誤

- Suggestion #11706 若連線不到iothub，應顯示error級別的log以提示無法連接iothub

- Suggestion #12361 PUT /v2/connectors這支API在建立或更新成功時，建議回覆訊息顯示建立出的connector資料

- Suggestion #15846 部署新的一套MG時，在parts資料表新增更多服務

  

# 1.2.0 (2020-08-17)

# New Features

- 料號用量統計新支持mean（平均）與integral（定積分）
- aggregatedLevel新增custom型態，當aggregatedLevel型態為custom時，可以透過新增加的hourly、daily與monthly三個欄位，自訂義統計方式

# Bug Fixes

- Bug #15779 若新建的service只需要計算daily或monthly的用量，則MG無法計算出用量


# 1.1.1 (2020-07-29)

# New Features

* health chcek api
* Real Time Data存入Redis

# Upgrade Steps

* 加入以下redis連線資訊，此連線資訊與reporting相同

| 名稱 | 說明 |
|----|----|
| REDIS_URI | redis的uri |
| REDIS_PORT | redis的port |
| REDIS_PASSWORD | redis的密碼 |
| REDIS_INDEX | redis的index |

# Breaking Changes

無

# Bug Fixes

* 修正redis寫入時間錯誤 (bug 14744)

# Improvements

無

# Other Changes

無

# 1.1.0 (2020-05-12)

## New Features
- 獲取連線資訊API
- 支援SSL的Influx DB
- 存活確認API
- DB斷線重連機制
- DB無法連線時，將資料留在RMQ上，避免漏資料

## Bug Fixes
- 若查詢不到用量，不應該回覆null
- 呼叫GET /v2/usages/{pn} 時，若缺少必要參數，錯誤訊息用字有誤  

## Improvements
- GET /v2/usages/{pn} 回覆中的datas改為data

## Other Changes
- Swagger路徑改為host/public/apidoc/index.html

------

# 1.0.1.3 (2020-04-06)

## New Features
- 支援SSL的Influx DB


# 1.0.1.2 (2020-03-02)

## New Features
- 獲取連線資訊API


