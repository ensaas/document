# Blobstore Service Manager (minio+pvc) ReleaseNote

## Blobstore Service Manager 1.0.5 (2021-01-11)

### 新增：
- 整合ECM，當前熱部署支持參數：
    + SECURITY_USER_NAME
    + SECURITY_USER_PASSWORD
    + DELETED_DAYS
- 支持健康檢查：[GET] /healthz

### 修復bug：
- #16861 恢復instance時，應該要驗證space_guid是否與當初建立的一致
- #16867 進行bind時，若binding_id大於50字元，會出現2個錯誤訊息
- #16868 若instance_id錯誤，不應該能成功進行unbind
- #16875 建立instance時，若連不到ops postgres，API的回覆有誤
- #16877 Bind/Unbind時，若連不到ops postgres，API的回覆有誤
- #16878 刪除instance時，若連不到ops postgres，API的回覆有誤
- #16918 刪除instance時，若連不到ops postgres，API的回覆有誤
    
## Blobstore Service Manager 1.0.0 (2020-11-02)

### 新增：
- 6 api
- [GET] /healthz
- [GET] /v2/catalog
- [PUT] /v2/service_instances/{instance_id}
- [PUT] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [DELETE] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [DELETE] /v2/service_instances/{instance_id}
