1.1.0 (2020-05-12)
--
# New Features
- 獲取連線資訊API
- 支援SSL的Influx DB
- 存活確認API
- DB斷線重連機制
- DB無法連線時，將資料留在RMQ上，避免漏資料

# Bug Fixes
- 若查詢不到用量，不應該回覆null
- 呼叫GET /v2/usages/{pn} 時，若缺少必要參數，錯誤訊息用字有誤  

# Improvements
- GET /v2/usages/{pn} 回覆中的datas改為data

# Other Changes
- Swagger路徑改為host/public/apidoc/index.html
