#  Blob-Ceph ReleaseNote

## wise-paas-service-manager-blob-ceph 1.0.0 (2021-06-16)

- Requirement #20573: 需要更換SM的service_id和plan_id

## Helm Chart - wise-paas-service-manager-blob-ceph 1.0.0 (2021-06-16)

- Requirement #20207: 請在chart裡加上resources.requests段落
- Suggestion #20571: 建議修改chart裡的Memory資源改為32Mi

## wise-paas-service-manager-blob-ceph 0.0.1.1 (2021-06-04)

- Bug #20155: 建立instance時，若沒有帶datacenterCode，返回的status code不應該回500
- Bug #20160: 建立instance時，若organization_guid或space_guid過長，應該要阻擋
- Bug #20162: 建立instance時，應阻擋輸入datacenterCode超過50字元
- Bug #20170: 綁定出的credential少了signature-version和type兩個項目，chart裡也需要放這兩個參數
- Bug #20171: Swagger的內容是TWCC SM的，沒有改成Ceph
- Bug #20173: 呼叫GET /resources時，若instance_id不存在，API的回應不正確
- Bug #20175: Swagger裡需移除 PATCH /v2/service_instances/{instance_id} 這支api
- Bug #20178: 無法恢復instance
- Bug #20194: 刪除binding時，若ceph的subuser已不存在，也應該要刪除成功
- Bug #20199: 刪除instance時，若ceph user已不存在，也要刪除成功
- Bug #20205: 建立instance時，如果連不到ceph，API回覆不正確
- Bug #20210: SM啟動後，沒有檢查有哪些instance需要被清理資料
- Bug #20213: 恢復instance時，不需要檢查request body裡是否有organization_guid或datacenterCode
- Bug #20222: ESM相關功能不太正確
- Add unit test

## Helm Chart - wise-paas-service-manager-blob-ceph 0.0.2 (2021-06-04)

- Bug #20170: 綁定出的credential少了signature-version和type兩個項目，chart裡也需要放這兩個參數
- Bug #20207: 請在chart裡加上resources.requests段落

## wise-paas-service-manager-blob-ceph 0.0.1 (2021-05-21)

### Added:
- 6 api
- [GET] /v2/catalog
- [PUT] /v2/service_instances/{instance_id}
- [DELETE] /v2/service_instances/{instance_id}
- [PUT] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [DELETE] /v2/service_instances/{instance_id}/service_bindings/{binding_id}
- [GET] /v2/service_instance_id/{service_instance_id}/resources
- add helm chart

## Helm Chart - wise-paas-service-manager-blob-ceph 0.0.1 (2021-05-21)

- first version
