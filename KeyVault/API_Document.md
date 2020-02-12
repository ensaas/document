# Subscribe keyvault 

订阅keyvault

| Method | Path                                                        |
| ---- | ----|
| POST   | /v1/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceName}     |


### Parameters
---

* <font color=Blue>subscriptionId</font> (string: required) - 订阅号id
* <font color=Blue>serviceInstanceName</font> (string: required) - Service instance名称，同一个订阅号下，不允许同名的service instanc名称



### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request POST \
    http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1
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
# Unsubscribe keyvault 

用户退订keyvault

| Method | Path                                                        |
| ---- | ----|
| DELETE   | /v1/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceName}       |


* <font color=Blue>subscriptionId</font> (string: required) - 订阅号id
* <font color=Blue>serviceInstanceName</font> (string: required) - Service instance名称

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request DELETE \
	http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1 
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

# Get all service instances 

获取某个订阅号下的所有service instances

| Method | Path                                                        |
| ---- | ----|
| GET   | /v1/subscriptions/{subscriptionId}/serviceInstances      |

### Parameters
---

* <font color=Blue>subscriptionId</font> (string: required) - 订阅号id

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request GET \    
    http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances
```

### Sample Response
---
```
{
  "request_id": "6071835e-f70c-6b8a-081e-8b54bfad7f67",
  "lease_id": "",
  "lease_duration": 0,
  "renewable": false,
  "data": {
    "keys": [
      "service-instance-1",
      "service-instance-2"
    ]
  },
  "warnings": null
}

```
# Get one service instances 

获取某个service instances

| Method | Path                                                        |
| ---- | ----|
| GET   | /v1/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceName}     |

### Parameters
---

* <font color=Blue>subscriptionId</font> (string: required) - 订阅号id
* <font color=Blue>serviceInstanceName</font> (string: required) - Service instance名称

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request GET \    
    http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1
```

### Sample Response
---
```
{
  "request_id": "6071835e-f70c-6b8a-081e-8b54bfad7f67",
  "lease_id": "",
  "lease_duration": 0,
  "renewable": false,
  "data": {
    "keys": [
      "path-1",
      "path-2"
    ]
  },
  "warnings": null
}

```
# Create Secret

添加secret


| Method | Path                                                        |
| ---- | ----|
| POST   | /v1/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceName}/path/{path}                               |


### Parameters
---

* <font color=Blue>subscriptionId</font> (string: required) - 订阅号的Id
* <font color=Blue>serviceInstanceName</font> (Map: required) - Service instance的名称
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
	http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1/path/path-1  
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
| GET   | /v1/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceName}/path/{path}                                |

### Parameters
---

* <font color=Blue>subscriptionId</font> (string: required) - 订阅号的Id
* <font color=Blue>serviceInstanceName</font> (Map: required) - Service instance的名称
* <font color=Blue>path</font> (Map: required) - Service instance下path的名称

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request GET \  
    http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1/path/path-1  
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
| DELETE   | /v1/subscriptions/{subscriptionId}/serviceInstances/{serviceInstanceName}/path/{path}                                 |
### Parameters
---

* <font color=Blue>subscriptionId</font> (string: required) - 订阅号的Id
* <font color=Blue>serviceInstanceName</font> (Map: required) - Service instance的名称
* <font color=Blue>path</font> (Map: required) - Service instance下path的名称

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request DELETE \  
    http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1/path/path-1
```
# Inject sidecar to deployment

给deployment对应的pod注入sidecar

| Method | Path                                                        |
| ---- | ----|
| PUT   | /v1/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}                                |


### Parameters
---
* <font color=Blue>clusterName</font> (string: required) - cluster的名称
* <font color=Blue>namespaceName</font> (string: required) - namespace的名称
* <font color=Blue>deploymentName</font> (string: required) - deployment的名称
* <font color=Blue>subscriptionId</font> (string: required) - 订阅号的Id
* <font color=Blue>serviceInstanceName</font> (Map: required) - Service instance的名称
* <font color=Blue>path</font> (string: required) - path的名称
* <font color=Blue>keys</font> ([]string: optional) - secret中key的名称


### Sample Payload
---
```
{
  "subscriptionId": "d1ef2306-33d9-4616-967d-eedee837661f",
  "serviceInstanceName": "service-instance-1",
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
}

```

### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request PUT \
    --data @payload.json \
    http://127.0.0.1:8200/v1/subscriptions/d1ef2306-33d9-4616-967d-eedee837661f/serviceInstances/service-instance-1
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
| DELETE   | /v1/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}                               |


### Parameters
---
* <font color=Blue>clusterName</font> (string: required) - cluster的名称
* <font color=Blue>namespaceName</font> (string: required) - namespace的名称
* <font color=Blue>deploymentName</font> (string: required) - deployment的名称


### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request DELETE \   
    http://127.0.0.1:8200/v1/cluster/c-1/namespace/ns-1/deployment/dm-1
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
| GET   | /v1/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}                               |


### Parameters
---
* <font color=Blue>clusterName</font> (string: required) - cluster的名称
* <font color=Blue>namespaceName</font> (string: required) - namespace的名称
* <font color=Blue>deploymentName</font> (string: required) - deployment的名称


### Sample Request
---

```
$ curl \
    --header "Authorization: Bearer .... \
    --request GET \
    http://127.0.0.1:8200/v1/cluster/c-1/namespace/ns-1/deployment/dm-1
```

### Sample Response
---
```
{
  "status": "Running"
}
```
