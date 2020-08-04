# Release Notes 1.1.1

### Release notes for mongodb service manager (mongodb-sm)

_Note: Release notes will include releases from **1.0.28** since there are major update on specification._

![Version](http://img.shields.io/badge/latest-1.1.1.2-green) ![Chart](https://img.shields.io/badge/chart-0.4.0-blue)

## New Features

- [+] deployment.persistent_disk_type is deprecated.
  Aliyun doesn't have persistent, so need to modify this term. Will be remove in the next release.

- [+] deployment.persistent_disk_size is deprecated.
  Aliyun doesn't have persistent, so need to modify this term. Will be remove in the next release.

- [+] deployment.database_version is deprecated.
  In the future, not only database can deploy but also other kind of instance, so need to modify this term. Will be remove in the next release.

- [+] deployment.storage_type is added.
  replacement for persistent_disk_type.

- [+] deployment.persistent_disk_size is added.
  replacement for database_version.

- [+] deployment.engine_version is added.
  replacement for database_version.

* [+] Update Helm chart 0.4.0

* [+] Provision dedicated is available. (db-cloud-driver enabled)
  Create instance for dedicated plan in Aliyun.

* [+] Deprovision dedicated is available. (db-cloud-driver enabled)
  Delete instance for dedicated plan in Aliyun.

* [+] Update: [GET] API ClusterQuota

- [+] New: [GET] API Last Operation

  - Endpoint: /v2/service_instances/{instance_id}/last_operation

* [+] New: [GET] API Resources List

  - Endpoint: /v2/serviceInstances/{instance_id}/resources

- [+] New: [GET] API ClusterList

  - Endpoint: /v2/clusters/list

* [+] New: [GET] API Cluster Shared Details

  - Endpoint: /v2/clusters/shared/{pseudoId}

* [+] New: [GET] API Cluster Dedicated Details

  - Endpoint: /v2/serviceInstances/{instanceId}/info

* [+] New: [GET] API Datacenter Overview

  - Endpoint: /v2/datacenter/{datacenterCode}/overview

- [+] New: [GET] API Resource Info

  - Endpoint: /v2/resourceInfo

* [+] New: [POST] API Dedicated Addition

  - Endpoint: /v2/serviceInstances/{instanceId}/resources

* [+] New: [POST] API Resource Info

  - Endpoint: /v2/resourceInfo

* [+] New: [PATCH] API Reprovision Shared Cluster

  - Endpoint: /v2/clusters/shared/{pseudoId}

* [+] New: [PATCH] API Update Dedicated Resource

  - Endpoint: /v2/resourceInfo/datacenterCode/{datacenterCode}/deploymentMethod/{deploymentMethod}/resourceType/{resourceType}

* [+] New: [DELETE] API Deprovision Shared Cluster

  - Endpoint: /v2/clusters/shared/{pseudoId}

* [+] New: [DELETE] API Delete Dedicated Resource
  - Endpoint: /v2/resourceInfo/datacenterCode/{datacenterCode}/deploymentMethod/{deploymentMethod}/resourceType/{resourceType}

## Bug Fixes

## 1.1.1.2

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14511
  app schema 和 schema spec 資訊不相同 (spec 無 storage_size，storage_type varchar(50))

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14352
  remove version on banner

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15270
  [GET] /v2/clusters/shared/{pseudoId} 返回資訊多了 deploymentName、zoneId 和 resourceType 參數資訊

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15328
  Deprovision dedicated adm instance (deleteData =true) then delete sm pod，tag 資訊未更新為 lifecycle:inactive

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15318
  OPS 數據庫中的 credentials 和 deployment 資料表中成功建立空的資訊(dedicated instance)或 2 筆相同 instances

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15319
  Recover dedicated instance (不同的 space_id)，有時會 recover 成功

## 1.1.1.1

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15177
  從 service Portal 建立 dedicated addition，建立 2 個重複的 dedicated instance

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15173
  Provision dedicated instance(resourceType/zoneId 參數輸入錯誤的值或未輸入參數)，返回 400 {"error":"invalid resourceType on given datacenterCode","description":"incorrect_resourceType"}

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15112
  GET /clusters/shared/{pseudoId} API 輸入 shared pseudoId 返回 404，instance_id is not found

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15109
  Deprovision shared instance (detached to deleted)，數據庫未被刪除

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15151
  Provision adm instance (securityIpList 參數填寫值非陣列參數值，app crash

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14848
  SM 啟動時，自動於 dedicated_resources 添加 resource type 資料

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15163
  App crash 或 pod 重啟後，繼續執行建立/降規 dedicated instance(ADM)未完成的操作

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15142
  Deprovision fail and return 403 when dedicated instance that created from ADM and instance status is error

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/15132
  建立或刪除 instance 時，若連不上 ADM，不要立刻判定 error

## 1.1.1.0

- [+]http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14846
  [GET] /v2/clusters/dedicated/{pseudoId} 修改設計

- [+]http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14847
  [GET] /v2/clusters/list 在回傳 dedicated 資訊時，額外增加回傳 deploymentName

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14848
  SM 啟動時，自動於 dedicated_resources 添加 resource type 資料

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14850
  Dedicated plan 調用 ADM status API，可根據環境變量可配置查詢間隔(預設 60s)和 timeout(預設 40 分鐘)

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14903
  若客戶額外添購硬碟，provision 時需支持輸入添購的數量，且透過 ADM 開硬碟時，開出的大小須為(Base Size) + (Additional Size) \* (Quantity)

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14983
  移除 [GET] /v2/clusters/dedicated/{pseudoId} API

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14854
  [POST] /v2/service_instances/manual 和 [GET] /v2/service_instance_id/{instance_id}/resources API 兼容於駝峰式 url (serviceInstances)

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14599
  Deprovision dedicated instance (create by ADM)，deployment 資料表未更新 deleted_at 資訊，且 credentials 資料表中的 internal_hosts 和 external_hosts 資訊消失

* [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14661
  使用其他 instance 的 pseudo_id recover dedicated instance ，返回 409 pseudo_id is in use

* [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14775
  Get cluster shared /dedicated details 返回資訊移除 databaseVersion、persistentDiskType、persistentDiskSize 參數名稱

* [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14766
  若刪除 instance 或 unbind 時 instance_id 或 binding_id 已不存在，API 的 response code 改成 410

* [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14665
  Shared instance deprovision API 支援 deleteData=true 時將 status detached 更改為 deleted (不需等待設定天數自動刪除)

* [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14657
  Deprovision dedicated instance (deleteData =true)，credentials 資料表 status 顯示 running 且 deployment 資料表未記錄 deleted_at 資訊

* [+] #14523 呼叫 Deprovision shared cluster API 更新為 detached 時，deployment 資料表更新 deleted_at 資訊

* [+] #14511 app schema 和 schema spec 資訊不相同 (spec 無 storage_size，storage_type varchar(50))

* [+] #14510 adm 版本 Swagger 未將 addition API sample json body 參數名稱更改為 engineVersion、storageSize、storageType

## 1.1.0

- [+] Provision dedicated is available.
  Create instance for dedicated plan in Aliyun.

- [+] Deprovision dedicated is available.
  Delete instance for dedicated plan in Aliyun.

* [+] deployment.persistent_disk_type is deprecated.
  Aliyun doesn't have persistent, so need to modify this term. Will be remove in the next release.

* [+] deployment.persistent_disk_size is deprecated.
  Aliyun doesn't have persistent, so need to modify this term. Will be remove in the next release.

* [+] deployment.database_version is deprecated.
  In the future, not only database can deploy but also other kind of instance, so need to modify this term. Will be remove in the next release.

* [+] deployment.storage_type is added.
  replacement for persistent_disk_type.

* [+] deployment.persistent_disk_size is added.
  replacement for database_version.

* [+] deployment.engine_version is added.
  replacement for database_version.

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14404
  deprovision dedicated issue due to disabled

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14395
  recover wont take pseudo_id parameter

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14401
  swagger issue on deprovision dedicated cluster. Change 'detached->running' to 'detached->deleted'

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14403
  add more verbose on unexpected end of JSON input

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14392
  fix dedicated addition API return error description

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14356
  fix shared addition API return error description

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14412
  fix Deprovision/Reprovision shared cluster should insert deleted_at and updated_at

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12615
  see if instanceID is exists. If exists, SM pass checking datacenterCode parameter

## 1.0.32

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14404
  deprovision dedicated issue due to disabled

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14395
  recover wont take pseudo_id parameter

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14401
  swagger issue on deprovision dedicated cluster. Change 'detached->running' to 'detached->deleted'

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14403
  add more verbose on unexpected end of JSON input

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14392
  fix dedicated addition API return error description

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14356
  fix shared addition API return error description

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14412
  fix Deprovision/Reprovision shared cluster should insert deleted_at and updated_at

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12615
  see if instanceID is exists. If exists, SM pass checking datacenterCode parameter

## 1.0.31

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14273
  Cannot deprovision dedicated instance

## 1.0.30

- [+] change parameter key name on [DELETE] /clusters/dedicated/{pseudoId}
  pseudo_id -> pseudoId
  service_id -> serviceId

- [+] change parameter key name on [PATCH] /clusters/shared/{pseudoId}
  pseudo_id -> pseudoId
  service_id -> serviceId

- [+] change parameter key name on [DELETE] /clusters/shared/{pseudoId}
  pseudo_id -> pseudoId
  service_id -> serviceId

- [+] change parameter key name on [GET] /clusters/shared/{pseudoId}
  pseudo_id -> pseudoId

- [+] retry OPS connection before start goroutine

## 1.0.29

- [+] move path:
  "advgitlab.eastasia.cloudapp.azure.com/PCF-Resource/wise-paas-service-manager-mongodb" -> "gitlab.wise-paas.com/PCF-Resource/wise-paas-service-manager-mongodb"

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14102,
  Move [PATCH] /V2/service_instances/{instance_id} -> [DELETE]/v2/clusters/dedicated/{pseudo_id}

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14075,
  New: [GET] API Get Datacenter Overview

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14074,
  New: [GET] API Get Dedicated Cluster

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14073,
  New: [GET] API Get Shared Cluster

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14072,
  New: [DELETE] API Reprovision Shared Cluster

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/14071,
  New: [PATCH] API Reprovision Shared Cluster

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13985,
  New: [GET] API ClusterList

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13996,
  Shared provision 建立 database 時，寫入 default collection

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13980,
  Update: API ClusterQuota

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13653,
  column 'externalHosts' requires alter on OPS: NOT NULL DEFAULT '', omit externalHosts as required value for manual shared addition

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13371
  deleteData and unbinding when deprovision

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/13442
  deprovision will triggers auto unbind for all plan

- [+] http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/12538
  move configmap to args in deployment

- [+] remove configmap

- [+] Provision, Deprovision, Bind, Unbind look up 'status' on credentials

- [+] API Addition: orgId will no longer be used when recover
