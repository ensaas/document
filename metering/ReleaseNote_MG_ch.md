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


