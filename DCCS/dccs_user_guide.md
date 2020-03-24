# Introduction

DCCS provides credential key for services, such as p-rabbitmq, mongodb, postgresql and so on.  A credential is a JSON file that contains Service Broker URL, supported protocols, and a connection username and password. The credential is used to verify the identity of a service client. If a service client is a remote app, device, or gateway, you must retrieve your credential through an API.

```
Reminder: You may use El-Connect as a client of the IoT Hub. El-Connect has a built-in API-redeemed credential mechanism that allows you to efficiently send data collected from devices to the WISE-PaaS cloud platform via the IoT Hub.
```

The URL for redeeming a credential  is formatted as `https://api-dccs-ensaas.{data center name}.{cloud platform domain name}`. For example, the domain name of the WISE-PaaS Singapore cloud platform is sa.wise-pass.com. Therefore, the URL for redeeming a credential is `https://api-dccs-ensaas.sa.wise-pass.com` . DCCS provides an API `api-docs` to get  the swagger document and so that the URL of Singapore swagger document is `https://api-dccs-ensaas.sa.wise-pass.com/api-docs`. 

# Authority Certification

DCCS supports two kinds of header validation, one is 'Authorization: <ssoTokenString>' and the other is 'cookie: <ssoTokenString>' . All DCCS APIs except get DCCS key API require sso token authentication. I.App have to use client token to integration with DCCS because SRP user without MP resource will fail to create/disable/enable/delete DCCS key. But rest assured that you can still use user token with MP resource to create/disable/enable/remove the DCCS key in the service console.

You can get client id and client secret from SSO via POST /clients and then get client token from SSO via POST /oauth/token. Please refer to SSO documents http://api-sso-ensaas.sa.wise-paas.com/public/apidoc/ and https://github.com/ensaas/document/tree/master/SSO. The way to create a client token is described in more detail in later section.

# An overview of REST APIs

DCCS provides the following five APIs to manage service credentials:

| Method | URL                                                       | Description            |
| ------ | --------------------------------------------------------- | ---------------------- |
| GET    | /v1/serviceCredentials/{serviceKeyName}                   | GET Credential Key     |
| POST   | /v1/serviceCredentials                                    | CREATE Credential Key  |
| DELETE | /v1/serviceCredentials/{serviceKeyName}                   | DELETE Credential Key  |
| PUT    | /v1/serviceCredentials/{serviceKeyName}/operations/enable | ENABLE Credential Key  |
| PUT    | /v1/serviceCredentials/{serviceKeyName}/operations/enable | DISABLE Credential Key |

# Service Credentials Management API

## Get a Credential Key

### HTTP Request

```
GET /v1/serviceCredentials/{serviceKeyName}
```

### Contents of an API-retrieved credential

```
{
  "serviceName": "p-rabbitmq",
  "serviceHost": "42.159.9.113",
  "serviceKeyName": "f23f080794a92f6d4b03024440d151xx",
  "serviceKeyGuid": "d3e7d06d-52f6-11ea-9c1c-dae22ed754bb",
  "org": "",
  "space": "",
  "serviceInstanceName": "iothub-dccs-test",
  "serviceInstanceId": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0",
  "subscriptionId": "7acb5cba-2215-487b-a1d2-5327875d089f",
  "credential": {
    "externalHosts": "42.159.9.113",
    "hostname": "172.21.16.6",
    "hostnames": [
      "172.21.16.6"
    ],
    "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
    "protocols": {
      "amqp+ssl": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 5671,
        "ssl": true,
        "uri": "amqps://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:5671/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0",
        "uris": [
          "amqps://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:5671/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
        ],
        "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "amqps": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 5671,
        "ssl": true,
        "uri": "amqps://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:5671/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0",
        "uris": [
          "amqps://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:5671/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
        ],
        "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "coap": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 5683,
        "ssl": false,
        "uri": "coap://iothub-advantech.wise-paas.cn/ps/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0/amq.topic/",
        "uris": [
          "coap://iothub-advantech.wise-paas.cn/ps/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0/amq.topic/"
        ],
        "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "mqtt": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 1883,
        "ssl": false,
        "uri": "mqtt://d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0%3Af067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:1883",
        "uris": [
          "mqtt://d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0%3Af067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:1883"
        ],
        "username": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0:f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "mqtt+ssl": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 8883,
        "ssl": true,
        "uri": "mqtt+ssl://d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0%3Af067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:8883",
        "uris": [
          "mqtt+ssl://d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0%3Af067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:8883"
        ],
        "username": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0:f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "stomp": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 61613,
        "ssl": false,
        "uri": "stomp://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:61613",
        "uris": [
          "stomp://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:61613"
        ],
        "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "stomp+ssl": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 61614,
        "ssl": true,
        "uri": "stomp+ssl://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:61614",
        "uris": [
          "stomp+ssl://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:61614"
        ],
        "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      },
      "ws": {
        "host": "172.21.16.6",
        "hosts": [
          "172.21.16.6"
        ],
        "password": "xxxxxxxxxxxxxxxxxxxxxxxxxx",
        "port": 15675,
        "ssl": false,
        "uri": "http/web-mqtt://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:15675/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0",
        "uris": [
          "http/web-mqtt://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:15675/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
        ],
        "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
        "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
      }
    },
    "ssl": true,
    "uri": "amqps://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:5671/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0",
    "uris": [
      "amqps://f067234c-52ba-11ea-85f4-b6bc9b25a1cc:jvSipdsguU8wew4txvWWqBCyy@172.21.16.6:5671/d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
    ],
    "username": "f067234c-52ba-11ea-85f4-b6bc9b25a1cc",
    "vhost": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0"
  },
  "serviceParameter": {
    "rmqRole": "management",
    "rmqTopicRead": "/dccs/rmq/,/dccs/rmq-2/",
    "rmqTopicWrite": "/dccs/rmq/,/dccs/rmq-3/"
  }
}
```

The image above is an example of the JSON data contained in an API-retrieved credential; the data include considerable useful information. In particular, these data provide the credential contained in a full service key, as well as additional important information such as IoT Hub URL and configuration parameters for this service.

Important fields in the credential are defined as follows:

- serviceName: service name
- serviceHost: service URL
- serviceKeyName: service credential name created 
- serviceKeyGuid: service credential GUID created
- serviceInstanceName: service instance name
- serviceInstanceId: the service instance ID of service credential
- subscriptionId: the subscription ID
- credential: Username, password, and port number for the service
- serviceParameter: service configuration parameters
- rmqTopicRead: RabbitMQ configuration parameter. The IoT device is restricted to reading data within these topics. If the parameter is empty, the device can read data within all the topics.
- rmqTopicWrite: RabbitMQ configuration parameter. The IoT device is restricted to deploying data to these topics. If the parameter is empty, all subscribers can read the deployed data.
- rmqRole: RabbitMQ configuration parameter. The parameter denotes the level of privilege assigned to the user account by which the IoT device logs into the IoT Hub. If the parameter is empty, it represents the least privilege.

### HTTP Status Code

| Code | Description                                                  |
| ---- | ------------------------------------------------------------ |
| 200  | Ok.                                                          |
| 404  | The service credential does not exist.                       |
| 410  | This service credential is disabled.                         |
| 500  | (1) Access the resource from store is failed.<br/>(2) Other errors. |

## Create a Credential Key

### HTTP Request

```
POST /v1/serviceCredentials
```

### Request Body

```
{
  "serviceInstanceId": "d2a53ff7-4d3d-11ea-93e2-aa30cd53a5e0",
  "serviceKeyDescription": "dccs test",
  "serviceParameter": {
  }
}
```

| Property Name         | Type   | Description                                                  | Required |
| --------------------- | ------ | ------------------------------------------------------------ | -------- |
| serviceInstanceId     | string | The service instance id                                      | true     |
| serviceKeyDescription | string | The description for the credential key                       | false    |
| serviceParameter      | object | The parameter of one service, such as rabbitmq, postgresql, mongodb and so on. Take the rabbitmq for example, the parameter as followings:  ServiceParameter: {<br/>   "rmqRole": "management",   <br/>   "rmqTopicRead": "/dccs/rmq/,/dccs/rmq-2/",   <br/>   "rmqTopicWrite": "/dccs/rmq/,/dccs/rmq-3/"<br/>} | false    |

### Response Body

The response body is exactly the same as the contents of the credential above.

### HTTP Status Code

| Code | Description                                                  |
| ---- | ------------------------------------------------------------ |
| 200  | Create service key OK. The service key name will be returned. |
| 401  | SSO token is invalid.                                        |
| 400  | The parameter serviceInstanceId of request body is wrong.    |
| 500  | (1) Save data into Redis failed. <br/>(2) Other errors.      |

## Delete a Credential Key

### HTTP Request

```
DELETE /v1/serviceCredentials/{serviceKeyName}
```

### HTTP Status Code

| Code | Description                                                  |
| ---- | ------------------------------------------------------------ |
| 204  | No content.                                                  |
| 401  | SSO token is invalid.                                        |
| 404  | The service credential does not exist.                       |
| 500  | (1) Remove data (key=[serviceKeyName]) from Redis failed.<br/>(2) Other errors. |

## Enable a Credential Key

### HTTP Request

```
PUT /v1/serviceCredentials/{serviceKeyName}/operations/enable
```

### HTTP Status Code

| Code | Description                                                  |
| ---- | ------------------------------------------------------------ |
| 204  | No content.                                                  |
| 400  | Enable service credential failed. The service credential may have been deleted. |
| 401  | SSO token is invalid.                                        |
| 404  | The service credential does not exist.                       |
| 500  | (1) Save data into Redis failed.<br/>(2) Other errors.       |

## Disable a Credential Key

### HTTP Request

```
PUT /v1/serviceCredentials/{serviceKeyName}/operations/disable
```

### HTTP Status Code

| Code | Description                                                  |
| ---- | ------------------------------------------------------------ |
| 204  | No content.                                                  |
| 400  | Disable service credential failed. The service credential may have been deleted. |
| 401  | SSO token is invalid.                                        |
| 404  | The service credential does not exist.                       |
| 500  | (1) Save data into Redis failed.<br/>(2) Other errors.       |

# Create DCCS Key

## 1. Get Service Instance Id

Get service instance id from secret

![](./images/getServiceInstanceId.png)

```
Note: If I.App want to create dccs key, I.App can make the service instance id as environment variable which is taken from secret.
```

## 2. Create SSO Client Id

Get Client Id from SSO url

```
POST /clients 
```

![](./images/createClientId.png)

## 3. Create SSO Client Token

Input client id and client secret to get Client token  from SSO url

```
POST /oauth/token
```

![](./images/createClientToken.png)

## 4. Creat DCCS key

Use DCCS url to create DCCS key 

```
POST /v1/serviceCredentials
```

![](./images/createDccsKey.png)