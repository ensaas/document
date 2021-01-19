# Blobstore Service Manager (minio+pvc) ReleaseNote

## Blobstore Service Manager 1.0.5 (2021-01-11)

### 新增
- 整合ECM，當前熱部署支持參數：
    + SECURITY_USER_NAME
    + SECURITY_USER_PASSWORD
    + DELETED_DAYS
- 支持健康檢查：[GET] /healthz

### 修復bug
- 修復部分輕微的bug
    
## Blobstore Service Manager 1.0.0 (2020-11-02)

### 新增
- 6 api
- [GET] /healthz
- [GET] /v2/catalog
- [PUT] /v2/service_instances/{instance_id}
- [PUT] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [DELETE] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [DELETE] /v2/service_instances/{instance_id}
