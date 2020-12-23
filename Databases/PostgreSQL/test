本文为您介绍应用如何使用PostgreSQL。

1. 部署应用，将密钥配置到环境变量中。

   ![PostgreSQL-SC-AppUseSecret-1.PNG](/dataSource/resource/1608693676519178250.png)
   
   - spec.cotainers.env.name：注入到Pod的环境变量名称
   - spec.cotainers.env.valueFrom.secretKeyRef.name：密钥注入的来源，为相同命名空间底下名为postgresql-secret的密钥
   - pec.cotainers.env.valueFrom.secretKeyRef.key：密钥中的Key值，EnSaaS建立出来的Key名称固定为「ENSAAS_SERVICES」
   
2. 进入到Pod里面执行env指令，就可以取得JSON格式的PostgreSQL证书了

```
$ kubectl -n <namespace> exec -ti <pod_name> sh
$ env
```

当您取得连接证书后，您可以搭配您熟悉的客户端应用来使用PostgreSQL服务。

* <a class="false-class" href="#Java开发者">Java开发者</a>
* <a class="false-class" href="#Python开发者">Python开发者</a>
* <a class="false-class" href="#Nodejs开发者">Node.js开发者</a>

### Java开发者

在Java中您可以使用JSON来对证书JSON进行解析，以下为使用Maven汇入json lib的范例：

```
<repositories>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20160810</version>
    </dependency>
</repositories>
```

取得PostgreSQL服务连接账号/密码示例如下：
```
import org.json.JSONObject;

JSONObject vcapServices = new JSONObject(System.getenv("ENSAAS_SERVICES"));

String pgUri = vcapServices.getJSONArray("postgresql").getJSONObject(0).getJSONObject("credentials").getJSONObject("uri");
String pgDatabase = vcapServices.getJSONArray("postgresql").getJSONObject(0).getJSONObject("credentials").getJSONObject("database");
String pgHost = vcapServices.getJSONArray("postgresql").getJSONObject(0).getJSONObject("credentials").getJSONObject("host");
String pgPort = vcapServices.getJSONArray("postgresql").getJSONObject(0).getJSONObject("credentials").getJSONObject("port");
String pgUser = vcapServices.getJSONArray("postgresql").getJSONObject(0).getJSONObject("credentials").getJSONObject("username");
String pgPasssword = vcapServices.getJSONArray("postgresql").getJSONObject(0).getJSONObject("credentials").getJSONObject("password");
```
---------------------------------------
### Python开发者

取得PostgreSQL服务连接账号/密码示例如下：

```
import os
import json

# Load 'ENSAAS_SERVICES' from enviroment variable and parse the URI 
ensaas_services = os.getenv('ENSAAS_SERVICES')
ensaas_services = json.loads(ensaas_services)
postgres_uri = ensaas_services['postgresql'][0]['credentials']['uri']
postgres_database = ensaas_services['postgresql'][0]['credentials']['database']
postgres_host = ensaas_services['postgresql'][0]['credentials']['host']
postgres_port = ensaas_services['postgresql'][0]['credentials']['port']
postgres_user = ensaas_services['postgresql'][0]['credentials']['username']
postgres_password = ensaas_services['postgresql'][0]['credentials']['password']
```
---------------------------------------
### Node.js开发者

取得PostgreSQL服务连接账号/密码示例如下：

```
ensaas_services = process.env.ENSAAS_SERVICES
postgres_uri = ensaas_services.postgresql[0].credentials.uri
postgres_database = ensaas_services.postgresql[0].credentials.database
postgres_host = ensaas_services.postgresql[0].credentials.host1
postgres_port = ensaas_services.postgresql[0].credentials.port1
postgres_user = ensaas_services.postgresql[0].credentials.username
postgres_password = ensaas_services.postgresql[0].credentials.password
```
