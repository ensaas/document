# KeyVault使用说明

KeyVault可以用来安全地存储机密信息，并对其访问进行严格控制。

##  权限验证

KeyVault使用SSO的权限认证机制，所以使用KeyVault的API之前，需要用一个SSO账户进行登录，然后取得登录的Token，之后便可以使用Token调用KeyVault的API。



## 订阅KeyVault

用户如果拥有某个Namespace的权限，便可以给当前Namespace订阅一个KeyVault实例，这里所谓的实例，其实就是一个用于存储Secret的路径。

Method

```
POST /secret/cluster/{clusterName}/namespace/{namespaceName}
```

参数说明如下：

| Name | Value                                                        |
| ---- | ------------------------------------------------------------ |
| clusterName   | cluster的名称                               |
| NamespaceName   | namespace的名称 |

返回参数json格式如下：

```
{
	"id": "<string>",
	"subscriptionId": "<string>",
	"isValidTransaction": <bool>,
	"number": <integer>,
	"authcode": "<string>",
	"activeInfo": "<string>"
}
```

参数说明如下：

| Name               | Value                                                     |
| ------------------ | --------------------------------------------------------- |
| id                 | 服务实例id，即serviceInstanceId                           |
| subscriptionId     | 订阅号id                                                  |
| isValidTransaction | 用户订阅状态，true=有效，false=无效，若为无效时，激活失败 |
| number             | 订阅的料号数量，即pnQuantity                              |
| authcode           | 激活码                                                    |
| activeInfo         | 服务上架时自定义的激活信息                                |

举例：

* Request Example:
  http://api-license-master.internal/v1/api/partNum/licenseQty?pn=9806WPAFS0&id=9ca0b70f-3357-11ea-beb1-76a42f50fd69

* Response Example:

  ```
  {
  	id: "9ca0b70f-3357-11ea-beb1-76a42f50fd69", //服务实例id
  	subscriptionId: "ff4fbd21-5962-4427-88a0-b8ef4ac9b393", //订阅号id
  	isValidTransaction: true,  //用户订阅状态，true=有效，false=无效
  	number: 120,   // 订阅的料号数量
  	authcode: "3080-e825-003c",  
  	activeInfo: ""  //服务上架时自定义的激活信息
  }
  
  ```



## 添加Secrets

订阅了某个Namespace的KeyVault之后，便可以将当前Namespace的secret存入相应的路径下面。Namespace路径下面可以再开子路径，即下图中的subPath，subPath支持的最大个数为10，subPath下面存储具体的secret，每个subPath存储secret的最大为100KB。

```
|-- NamespacePath
|   |-- subPath1
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath2
|   |   |  key1: vaule1
|   |-- subPath3
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath4
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath5
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath6
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath7
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath8
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath9
|   |   |  key1: vaule1
|   |   |  key2: vaule2
|   |-- subPath10
|   |   |  key1: vaule1
|   |   |  key2: vaule2
```

Method

```
POST /secret/cluster/{clusterName}/namespace/{namespaceName}/path/{path}
```

Request body：

```
{
  "data":{
    "key1":"vaule1",
    "key2":"vaule2"
  }
}
```
参数说明如下：

| Name | Value                                                        |
| ---- | ------------------------------------------------------------ |
| clusterName   | cluster的名称                               |
| NamespaceName   | namespace的名称 |
| path   | path的名称 |
| data   | secret的key和vaule，支持多组key和vaule |



## 获取Secrets



Method

```
GET /secret/cluster/{clusterName}/namespace/{namespaceName}/path/{path}
```

参数说明如下：

| Name | Value                                                        |
| ---- | ------------------------------------------------------------ |
| clusterName   | cluster的名称                               |
| NamespaceName   | namespace的名称 |
| path   | path的名称 |
| data   | secret的key和vaule，支持多组key和vaule |


## 应用程序获取Secrets

将Secrets添加成功后，应用程序可以通过注入Sidecar的方式获取Secrets的值。使用此方式之后，应用程序可以不用关注怎么获取Secrets的过程，最终，只需要更改很少的代码，便可以拿到需要的Secrets。

注入成功之后，Pod中会多出一个Container，名为consul-template，此Container负责将Secrets的值获取出来，然后以共享卷的方式共享给应用程序本身的container，因此，在应用程序本身的container下，会多出一个vault-secrets.txt文件，此文件位于/etc/sectets下面，文件的内容就是key，vaule的键值对。

Method

```
POST /secret/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}
```

Request body：

```

[
	{
		"path":"subPath1",
		"keys":["key1", "key2"]
	},
	{
		"path":"subPath2",
		"keys":["key1"]
	}
]
```
参数说明如下：

| Name | Value                                                        |
| ---- | ------------------------------------------------------------ |
| clusterName   | cluster的名称                               |
| NamespaceName   | namespace的名称 |
| deployment   | 需要进行注入的deployment的名称 |
| path   | namespace下子路径的名称，支持多组 |
| keys   | namespace下子路径下存储的secrets的key值，支持多组 |


