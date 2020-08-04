# Release Notes

![Version](http://img.shields.io/badge/latest-1.1.1.2-green) ![Chart](https://img.shields.io/badge/chart-0.4.0-blue)

Highlight release note for mongodb service manager (mongodb-sm)

### Features

- [+] Update Helm chart 0.4.0

- [+] Support Provision on dedicated plan (db-cloud-driver enabled)

- [+] Update: [GET] API ClusterQuota

  - Shared:

  ```json
  [
    {
      "sharedInstanceQuota": 10,
      "sharedInstanceRemain": 5,
      "sharedInstanceRunning": 5,
      "sharedInstanceDetached": 0,
      "datacenterCode": "test",
      "totalClusters": 1
    }
  ]
  ```

  - Dedicated:

  ```json
  [
    {
      "dedicatedInstanceRunning": 0,
      "dedicatedInstanceDetached": 0,
      "datacenterCode": "test",
      "totalClusters": 1
    }
  ]
  ```

* [+] New: [GET] API Last Operation

  - Endpoint: /v2/service_instances/{instance_id}/last_operation

  - Response:

  ```json
  {
    "state": "in progress"
  }
  ```

* [+] New: [GET] API Resources List

  - Endpoint: /v2/serviceInstances/{instance_id}/resources
  - Response:

  ```json
  {
    "resources_list": []
  }
  ```

- [+] New: [GET] API ClusterList

  - Endpoint: /v2/clusters/list
  - Response:

  ```json
  [
    {
      "pseudoId": "0",
      "instanceQuota": 100,
      "instanceRemain": 100,
      "instanceRunning": 0,
      "instanceDetached": 0,
      "datacenterCode": "test",
      "status": "running"
    }
  ]
  ```

- [+] New: [GET] API Cluster Shared Details

  - Endpoint: /v2/clusters/shared/{pseudoId}
  - Response:

  ```json
  {
    "pseudoId": "test",
    "status": "running",
    "datacenterCode": "test",
    "internalHosts": "127.0.0.1:27017",
    "externalHosts": "127.0.0.1:27017",
    "username": "user",
    "password": "pass",
    "authenticationDatabase": "test",
    "deploymentProperties": {
      "location": "test",
      "engineVersion": "1.0.0",
      "vmType": "small",
      "vmSize": "2C8G",
      "storageSize": 100,
      "storageType": "hdd"
    }
  }
  ```

- [+] New: [GET] API Cluster Dedicated Details

  - Endpoint: /v2/serviceInstances/{instanceId}/info
  - Response:

  ```json
  {
    "pseudoId": "test",
    "status": "running",
    "datacenterCode": "test",
    "internalHosts": "127.0.0.1:27017",
    "externalHosts": "127.0.0.1:27017",
    "username": "user",
    "password": "pass",
    "authenticationDatabase": "test",
    "deploymentProperties": {
      "location": "test",
      "engineVersion": "1.0.0",
      "vmType": "",
      "vmSize": "",
      "storageSize": 100,
      "storageType": "",
      "deploymentName": "",
      "zoneId": "",
      "resourceType": ""
    }
  }
  ```

- [+] New: [GET] API Datacenter Overview

  - Endpoint: /v2/datacenter/{datacenterCode}/overview
  - Response:

  ```json
  {
    "totalClusters": 1,
    "totalRunning": 1,
    "totalDetached": 0,
    "instance": {
      "quota": 10,
      "totalRemain": 10,
      "totalRunning": 0,
      "totalDetached": 0
    }
  }
  ```

- [+] New: [GET] API Resource Info

  - Endpoint: /v2/resourceInfo
  - Response:

  ```json
  {
    "datacenterCode": "test",
    "vmType": "test.test.small.1",
    "vmSize": "test",
    "replicationFactor": "1",
    "storageType": "",
    "engineVersion": "4.0",
    "resourceType": "Dedicated-Single-Small",
    "storageSize": 100,
    "storageSizeUnit": 100,
    "zoneID": "test",
    "deploymentMethod": "test"
  }
  ```

- [+] New: [POST] API Dedicated Addition

  - Endpoint: /v2/serviceInstances/{instanceId}/resources

- [+] New: [POST] API Resource Info

  - Endpoint: /v2/resourceInfo

- [+] New: [PATCH] API Reprovision Shared Cluster

  - Endpoint: /v2/clusters/shared/{pseudoId}

- [+] New: [PATCH] API Update Dedicated Resource

  - Endpoint: /v2/resourceInfo/datacenterCode/{datacenterCode}/deploymentMethod/{deploymentMethod}/resourceType/{resourceType}

- [+] New: [DELETE] API Deprovision Shared Cluster

  - Endpoint: /v2/clusters/shared/{pseudoId}

- [+] New: [DELETE] API Delete Dedicated Resource
  - Endpoint: /v2/resourceInfo/datacenterCode/{datacenterCode}/deploymentMethod/{deploymentMethod}/resourceType/{resourceType}
