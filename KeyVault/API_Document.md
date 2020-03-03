# Get servcie information
获取服务信息

| Method | Path                                                        |
| ---- | ----|
| GET   | /v2/catalog     |

### Sample Request
---

```
$ curl \
    --header "authorization: Basic YXhtbThPbz****" \
    --request GET \
    http://keyvault-url/v2/catalog
```

### Sample Response
---
```
{  
  "id": "keyvault-id",  //全平台唯一服務ID
  "name": "keyvault",  //服務名稱
  "description": "this service is keyvault", //服務描述
  "tags": [ //標籤
    "service-keyvault" //標籤內容
  ],
  "bindable": false, //有沒有綁定的功能 (必填)
  "plans": [ //提供的計劃列表
    {
      "id": "keyvault-plan-id",  //全名台唯一計劃ID
      "name": "standard",  //計劃名稱
      "description": "this plan is standard" //計劃描述
    }
  ]
}

```


# Subscribe keyvault service
订阅keyvault服务


| Method | Path                                                        |
| ---- | ----|
| PUT   | /v2/service_instances/{instances_id}     |




### Sample Payload
---
```
{
  "service_id": "keyvault-id",
  "plan_id": "keyvault-plan-id", 
  "organization_guid": "subscriptionId",
  "space_guid": "subscriptionId"  
}
```

### Sample Request
---

```
 
$ curl \
    --header "authorization: Basic YXhtbThPbz****" \
    --data @payload.json \  
    --request PUT \
    http://keyvault-url/v2/service_instances/instance-1  
```

### Sample Response
---
```
{
  "dashboard_url": "http://keyvault-dashboard.example.com" 
}

```
# Unsubscribe keyvault service
退订keyvault服务

| Method | Path                                                        |
| ---- | ----|
| DELETE   | /v2/service_instances/{instances_id}      |



### Sample Request
---

```
$ curl \  
  --header "authorization: Basic YXhtbThPbz****" \
  --request DELETE \
  http://keyvault-url/v2/service_instances/instance_1?service_id=keyvault-id&plan_id=keyvault-plan-id

```

### Sample Response
---
```
{
  "reason": "success",
  "message": "OK",
  "code": 200
}

```


# Create Secret

| Method | Path                                                        |
| ---- | ----|
| POST   | /v2/service_instances/{instance_id}/path/{path}                               |


### Parameters
---

* <font color=Blue>instance_id</font> (Map: required) - Service instance的Id
* <font color=Blue>path</font> (Map: required) - Service instance下path的名称
* <font color=Blue>data</font> (Map: required) - 需要存入的secret的key，value之，key值不可重复

### Sample Payload
---
```
{
  "data":{
    "key1":"value1",
    "key2":"value2"
  }
}
```

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request POST \
    --data @payload.json \   
    http://keyvault-url/v2/service_instances/instance-1/path/path-1  
```

### Sample Response
---
```
{
  "request_id": "43ccec60-e38c-9f06-c899-6a41017844a6",
  "lease_id": "",
  "lease_duration": 0,
  "renewable": false,
  "data": {
    "created_time": "2020-01-16T05:25:47.985093248Z",
    "deletion_time": "",
    "destroyed": false,
    "version": 1
  },
  "warnings": null
}

```


# Get Secret
获取secret


| Method | Path                                                        |
| ---- | ----|
| GET   | /v2/service_instances/{instance_id}/path/{path}                                |

### Parameters
---

* <font color=Blue>instance_id</font> (Map: required) - Service instance的Id
* <font color=Blue>path</font> (Map: required) - Service instance下path的名称

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request GET \  
    http://keyvault-url/v2/service_instances/instance-1/path/path-1  
```

### Sample Response
---
```
{
  "request_id": "e2efeeeb-7252-57e1-bde9-23e0fc799216",
  "lease_id": "",
  "lease_duration": 0,
  "renewable": false,
  "data": {
    "data": {
      "key1": "vaule1",
      "key2": "vaule2"
    },
    "metadata": {
      "created_time": "2020-01-16T05:25:47.985093248Z",
      "deletion_time": "",
      "destroyed": false,
      "version": 1
    }
  },
  "warnings": null
}

```

# Delete Secret
删除secret


| Method | Path                                                        |
| ---- | ----|
| DELETE   | /v2/service_instances/{instance_id}/path/{path}                                 |
### Parameters
---

* <font color=Blue>subscription_id</font> (string: required) - 订阅号的Id
* <font color=Blue>instance_id</font> (Map: required) - Service instance的Id
* <font color=Blue>path</font> (Map: required) - Service instance下path的名称

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request DELETE \  
    http://keyvault-url/v2/service_instances/instance-1/path/path-1
```
# Inject sidecar to deployment

给deployment对应的pod注入sidecar

| Method | Path                                                        |
| ---- | ----|
| PUT   | /v2/clusters/{cluster_name}/namespaces/{namespace_name}/deployments/{deployment_name}                                |


### Parameters
---
* <font color=Blue>cluster_name</font> (string: required) - cluster的名称
* <font color=Blue>namespace_name</font> (string: required) - namespace的名称
* <font color=Blue>deployment_name</font> (string: required) - deployment的名称
* <font color=Blue>instance_id</font> (Map: required) - Service instance的Id
* <font color=Blue>path</font> (string: required) - path的名称
* <font color=Blue>keys</font> ([]string: optional) - secret中key的名称


### Sample Payload
---
```

[
  {
	"keys": ["key1", "key2"],
	"path": "nginx-test"
  },
  {
	"keys": ["key1"],
	"path": "nginx-test-1"
  }
]


```

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request PUT \
    --data @payload.json \
    http://keyvault-url/v2/clusters/c-1/namespaces/ns-1/deployments/dm-1?instances_id=instance-id-1
```

### Sample Response
---
```
{
  "reason": "success",
  "message": "OK",
  "code": 200
}

```
# Remove injected container

移除pod中注入的container


| Method | Path                                                        |
| ---- | ----|
| DELETE   | /v2/clusters/{cluster_name}/namespaces/{namespace_name}/deployments/{deployment_name}                               |


### Parameters
---
* <font color=Blue>cluster_name</font> (string: required) - cluster的名称
* <font color=Blue>namespace_name</font> (string: required) - namespace的名称
* <font color=Blue>deployment_name</font> (string: required) - deployment的名称
* <font color=Blue>instance_id</font> (Map: required) - Service instance的Id


### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request DELETE \   
    http://keyvault-url/v2/clusters/c-1/namespaces/ns-1/deployments/dm-1?instances_id=instance-1
```

### Sample Response
---
```
{
  "reason": "success",
  "message": "OK",
  "code": 200
}

```

# Get deployment status

获取deployment下pod的状态


| Method | Path                                                        |
| ---- | ----|
| GET   | /v2/clusters/{cluster_name}/namespaces/{namespace_name}/deployments/{deployment_name}                               |


### Parameters
---
* <font color=Blue>cluster_name</font> (string: required) - cluster的名称
* <font color=Blue>namespace_name</font> (string: required) - namespace的名称
* <font color=Blue>deployment_name</font> (string: required) - deployment的名称


### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request GET \
    http://keyvault-url/v2/clusters/c-1/namespaces/ns-1/deployments/dm-1?instances_id=instance-1
```

### Sample Response
---
```
{
  "status": "Running"
}
```
