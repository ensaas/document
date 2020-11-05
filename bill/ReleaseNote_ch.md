# 1.1.0 (2020-11-04)

# **New Features**
- API Version更新至1.1版

  - 支持二房東功能
    - SSO AllowAccessBillingPortal設定
    - SSO扣款
    - 加入匯率功能
  - /v1.1/deduction 
    - 移除“isPaidAccount” 欄位
    - 移除subscriptionType欄位
    - 扣款時新增deductionType欄位

  - /v1.1/portal/bills
    - 新增currency欄位
    - deductionType若為空，則表示查詢所有帳款

- 支持ECM功能

- 本版有改動db，部署後需進行db migration

# **Bug Fixes**

# **Breaking Changes**

- 停用deduction中的“isPaidAccount” 欄位，改由deduction type來決定扣款身份

# **Chart Version**
1.1.0





# 1.0.2.4 (2020-11-02)
- /v1.1/portal/bills

  - 移除currency的預設值改為必帶
  - deductionType若為空，則表示查詢所有帳款
-  /v1.1/deduction 
  - 移除subscriptionType欄位
- 加入SSO扣款功能


# **New Features**
# 1.0.2.3 (2020-10-27)

# **New Features**

- API Version更新至1.1版
	- 支持二房東功能
	- deduction “isPaidAccount” 停用
	- 扣款時新增deductionType欄位
	- 支持SSO AllowAccessCostCenter設定
- 加入訂閱號匯率記錄
# **Breaking Changes**
- 停用deduction中的“isPaidAccount” 欄位，改由deduction type來決定扣款身份
# 1.0.2.2 (2020-10-14)

# **New Features**
- 支援ECM

# **Bug Fixes**

# **Breaking Changes**

# **Chart Version**
1.1.0
# 1.0.2 (2020-09-10)
# **New Features**
- /v1/portal/bills 
  - Response中加入company

# **Bug Fixes**

# **Breaking Changes**

# 1.0.1 (2020-09-08)

# **New Features**

- Portal API
  - 允許CrmIds為空
  - 暫時取消pageSize上限50筆的限制
- 扣款功能
  - 支援MKP對帳功能

# **Bug Fixes**

  - 修正折扣計算方案
  - 修正分頁顯示筆數與排序問題

# 1.0.0 (2020-09-03)

# **New Features**

- 扣款功能
  - 支援訂閱、續訂以及PAYG
  - 未扣款記錄查詢
  - 未扣款記錄整併扣點
- 扣款相關
  - 支援API新增、修改和刪除資料中心
- 提供Portal查詢API
  - 支援由Cookie認證
  - 支援Global Admin與CRM Admin二種角色
    - Global Admin可以查詢所有Data Center所有CRM的帳
    - CRM Admin可以查詢該CRM下所有Subscription的帳

# 0.0.3.0 (2020-08-19)

# **New Features**

- 扣點API
- 可以透過API新增、修改和刪除資料中心
- 提供未扣款記錄查詢
- 提供未扣款整併重送給MKP進行扣點
- 加入Pseudo Marketplace API，用在沒有MKP下測試使用

# **Bug Fixes**

- 無

# **Breaking Changes**

- 無
