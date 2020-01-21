# KeyVault使用说明

KeyVault可以用来安全地存储机密信息，并对其访问进行严格控制。

## Step 1：

*  权限验证

KeyVault使用SSO的权限认证机制，所以使用KeyVault的API之前，需要用一个SSO账户进行登录，然后取得登录的Token，之后便可以使用Token调用KeyVault的API。

## Step 2：

* 订阅KeyVault

用户要使用KeyVault之前，需要订阅一个KeyVault实例，这里所谓的实例，其实就是一个以用户ID命名的用于存储Secret的路径。

Method
```
POST /secret
```
订阅了KeyVault实例之后，可以通过GET查看。

Method
```
GET /secret
```
还可以取消订阅，但是这里需要注意一点，如果用户取消订阅之后，当前这个用户存储的所有secret都会被删除。

Method
```
DELETE /secret
```
## Step 3：

* 添加Secrets

用户订阅了KeyVault之后，便可以将secret存储在当前路径下面。UserId路径下面可以再开子路径，即下图中的subPath，subPath支持的最大个数为10，subPath下面存储具体的secret，每个subPath存储secret的最大为100KB。

```
|-- UserId
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
POST /secret/path/{path}
```


添加完secrets之后可以查看


Method

```
GET /secret/path/{path}
```
也可以删除用户某个子路径下的secrets

Method

```
DELETE /secret/path/{path}
```

## Step 4：

* 应用程序获取Secrets

将Secrets添加成功后，应用程序可以通过注入Sidecar的方式获取Secrets的值。使用此方式之后，应用程序可以不用关注怎么获取Secrets的过程，最终，只需要更改很少的代码，便可以拿到需要的Secrets。

注入成功之后，Pod中会多出一个Container，名为consul-template，此Container负责将Secrets的值获取出来，然后以共享卷的方式共享给应用程序本身的container，因此，在应用程序本身的container下，会多出一个vault-secrets.txt文件，此文件位于/etc/sectets下面，文件的内容就是key，vaule的键值对。

Method

```
PUT /secret/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}
```
注入之后，可以查看注入是否成功

Method

```
GET /secret/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}
```
也可以对注入的container进行撤销
```
DELETE /secret/cluster/{clusterName}/namespace/{namespaceName}/deployment/{deploymentName}
```

## 注意事项
* 如果删除了某个secret，但是这个secret之前已经被注入到了deployment中，deployment会因为找不到这个secret二不断重启，所以希望在删除了某个secret之后，可以同时更新注入container的secret

