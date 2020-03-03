<!-- Document Revision History

2020.02.19

1. Update content for EnSaaS 4.0

-->


# WISE-PaaS 時間序列資料庫服務

WISE-PaaS提供[時間序列資料庫服務][2]Time Series Database (TSDB)，讓使用者儲存大量與時間有相依性的資料，TSDB在儲存與管理間序列資料比一般資料庫更省空間，同時效能更佳。當雲平台應用服務需要進行與時間相依得訊息儲存時，可透過時間序列資料庫服務來達成。例如由IoT Hub服務傳送到WISE-PaaS上的資訊可以用此服務儲存管理，介接平台提供的可視化工具了解資料趨勢，以及利用平台的分析服務進行進階加值應用。WISE-PaaS 上時間序列資料庫是基於InfluxDB建構的資料儲存服務，若想更了解[InfluxDB][1]詳細的相關介紹可以參考[InfluxDB官網][3]。

WISE-PaaS 的時間序列資料庫服務主要功能包括：

1. 支援<span style="color:red;">專屬型</span>服務，確保效能控管與資料隱密性。
2. 支援SSL加密安全傳輸連線，確保資料傳輸過程安全性
3. 提供web 介面讓使用者操作
4. 包含Telegraf、Chronograf和Kapacitor等附加元件。

![時間序列資料庫服務 示意圖](../uploads/images/InfluxDB/InfluxDB.jpg)

<td align="center">時間序列資料庫服務 [示意圖</td>][10]

## 如何使用時間序列資料庫服務
---------------------------------------
### 使用者可透過下列步驟使用時間序列資料庫服務

1. 購買專屬型InfluxDB服務 
3. 建立Secret並取得連線憑證 Service Credential
3. 將Secret的資訊注入到Kubernetes Pods中
4. 程式在環境變數中獲取連線憑證，並與InfluxDB進行連線

### 步驟一：購買專屬型InfluxDB服務 
---------------------------------------
InfluxDB僅提供單節點專屬型服務，服務規格如下，如有需要，請至[研華商城](https://wise-paas.advantech.com/zh-tw/marketplace)訂閱購買

|方案                 | 規格*                          |
| -------------------- | --------------------------------- |
| Single Node - Small  | 2 vCPU, 8GB RAM, 128GB SSD Disk   |
| Single Node - Medium | 4 vCPU, 16GB RAM, 512GB SSD Disk  |
| Single Node - Large  | 8 vCPU, 32GB RAM, 1024GB SSD Disk |

*: 規格可能依站點而有不同，實際規格依各站點公告為主



### 步驟二：創建Secret並取得連線憑證 Service Credential

---------------------------------------
連線至influxDB服務前首先確定您擁有下列資訊：

* 已成功購買InfluxDB

* <span style="color:red;">Service Portal</span>的登入網址及登入權限

* 您的帳號擁有登入<span style="color:red;">Service Portal</span>的權限

  

各站點Service Portal連結如下

 站點代碼 | 所在地點          | Service Portal連結                             |
 | -------- | ----------------- | ---------------------------------------------- |
 | SA       | Azure Singapore   | https://portal-service-ensaas.sa.wise-paas.com |
 | HZ       | Alibaba  Hangzhou | https://portal-service-ensaas.hz.wise-paas.com |
 | JE       | Japan East        | https://portal-service-ensaas.jp.wise-paas.com |

 建立InfluxDB的Secret步驟簡述如下，更多建立細節請參考此[Service Portal使用者操作手冊](../../ServicePortal/userguide.md):
 1. 登入Service Portal之後選擇您的時間序列資料庫服務實例
 2. 點選右方操作選項，進入Secret管理頁面
 3. 點選 "+" 號，將influxdb的連線憑證以Secret的方式建立到所選的Namespace中
 4. 或是點選"檢視"，也可以查看當前建出來的連線憑證

 連線憑證是一組包含時間序列資料庫連線位址、連線帳號、連線密碼等資訊的JSON格式文檔，用來驗證使用時間序列資料庫服務對象的身分。

 ![1582025913841](../uploads/images/InfluxDB/influxdb_credential.png)

 * database：字串型態，標準[UUID格式][9]
 * host：字串型態，時間序列資料庫所在位址，只提供內部網路存取位址，IP格式
 * password：字串型態，由小寫英文字母與數字隨機組成，長度為25字元
 * port：數值型態，時間序列資料庫通訊埠
 * uri：字串型態，http://\<host\>:\<port\>
 * username：字串型態，標準[UUID格式][9]



### 步驟三：將Secret的資訊注入到Kubernetes Pods中

------

完成上一步驟在Namespace創建Secret後，可以在namespace裡看到一個同名的Secret。查看Secret內容後，會看到一個Key值為ENSAAS_SERVICES的內容，從kubctl指令看到的是base64編碼後的內容，可將其base64解碼後，或是注入到環境變數後取得原本得Credential內容。

```shell
$ kubectl -n my-namespace get secret
$ kubectl -n my-namespace get secret influxdb-secret -o yaml
```

![1582025913841](../uploads/images/InfluxDB/influxdb_secret.png)



創建一個Pod(以busybox為例)，並將Secret注入到Pod環境變數中，並從環境變數中取得Credential內容

- spec.cotainers.env.name: 注入到Pod的環境變數名稱
- spec.cotainers.env.valueFrom.secretKeyRef.name: 注入的來源為同Namespace底下，名為influxdb-secret的Secret
- pec.cotainers.env.valueFrom.secretKeyRef.key: Secret中的Key值，EnSaaS創建出來的Key名稱固定為"ENSAAS_SERVICES"

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: busybox
  namespace: my-namespace
spec:
  containers:
  - name: busybox
    image: busybox:latest
    env:
    - name: ENSAAS_SERVICES
      valueFrom:
        secretKeyRef:
          name: influxdb-secret
          key: ENSAAS_SERVICES
    command:
      - sleep
      - "3600"
    imagePullPolicy: IfNotPresent
  restartPolicy: Always
```

進入到Pod裡面執行env的指令，就可以取得JSON格式的influxdb credential了

```shell
$ kubectl -n my-namespace exec -ti busybox sh
$ env
```

![1582025913841](../uploads/images/InfluxDB/influxdb_secret_env.png)

### 步驟四：程式在環境變數中獲取連線憑證，並與InfluxDB進行連線

---------------------------------------
當您有連線憑證後，您就可以搭配您所熟悉的客戶端應用來使用InfluxDB的服務。

* <a class="false-class" href="#!documents/Database/InfluxDb/userguide__zh-TW.md#Java開發者">Java開發者</a>
* <a class="false-class" href="#!documents/Database/InfluxDb/userguide__zh-TW.md#Python開發者">Python開發者</a>
* <a class="false-class" href="#!documents/Database/InfluxDb/userguide__zh-TW.md#NodeJs開發者">NodeJs開發者</a>

## Java開發者
在Java中您可以使用JSON來對Credential JSON進行解析，以下為使用Maven引入json lib的範例：

```
<repositories>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20160810</version>
    </dependency>
</repositories>

```

取得InfluxDB服務連線帳號/密碼範例如下:
```
import org.json.JSONObject;

JSONObject ensaasServices = new JSONObject(System.getenv("ENSAAS_SERVICES"));

String InfluxDBURI = ensaasServices.getJSONArray("influxdb").getJSONObject(0).getJSONObject("credentials").getJSONObject("uri");
String InfluxDBDatabase = ensaasServices.getJSONArray("influxdb").getJSONObject(0).getJSONObject("credentials").getJSONObject("database");
String InfluxDBHost = ensaasServices.getJSONArray("influxdb").getJSONObject(0).getJSONObject("credentials").getJSONObject("host");
String InfluxDBPort = ensaasServices.getJSONArray("influxdb").getJSONObject(0).getJSONObject("credentials").getJSONObject("port");
String InfluxDBUser = ensaasServices.getJSONArray("influxdb").getJSONObject(0).getJSONObject("credentials").getJSONObject("username");
String InfluxDBPasssword = ensaasServices.getJSONArray("influxdb").getJSONObject(0).getJSONObject("credentials").getJSONObject("password");

```
---------------------------------------
## Python開發者
取得InfluxDB服務連線帳號/密碼範例如下:

```
import os
import json

# Load 'ENSAAS_SERVICES' from enviroment variable and parse the URI
ensaas_services = os.getenv('ENSAAS_SERVICES')
ensaas_services = json.loads(ensaas_services)
influx_uri = ensaas_services['influxdb'][0]['credentials']['uri']
influx_database = ensaas_services['influxdb'][0]['credentials']['database']
influx_host = ensaas_services['influxdb'][0]['credentials']['host']
influx_port = ensaas_services['influxdb'][0]['credentials']['port']
influx_user = ensaas_services['influxdb'][0]['credentials']['username']
influx_password = ensaas_services['influxdb'][0]['credentials']['password']

```
---------------------------------------
## NodeJs開發者
取得InfluxDB服務連線帳號/密碼範例如下:

```
ensaas_services = process.env.ENSAAS_SERVICES
influx_uri = ensaas_services.influxdb[0].credentials.uri
influx_database = ensaas_services.influxdb[0].credentials.database
influx_host = ensaas_services.influxdb[0].credentials.host
influx_port = ensaas_services.influxdb[0].credentials.port
influx_user = ensaas_services.influxdb[0].credentials.username
influx_password = ensaas_services.influxdb[0].credentials.password
```
---------------------------------------
[1]:https://zh.wikipedia.org/wiki/InfluxDB "InfluxDB"
[2]:https://en.wikipedia.org/wiki/Temporal_database "時間序列資料庫"
[3]:https://www.influxdata.com/ "InfluxDB 官方網站"
[4]:https://docs.influxdata.com/influxdb/v1.5/ "InfluxDB Manual"
[5]:https://docs.influxdata.com/influxdb/v1.4/tools/api_client_libraries/#main-nav "Influx Client example"
[6]:https://docs.influxdata.com/influxdb/v0.9/tools/web_admin/#accessing-the-ui "Influx DB Web Admin Interface"
[7]:https://www.influxdata.com/blog/influxdb-the-platform-for-time-series-data/ "Influx DB 架構文件"
[8]:http://wise-paas.advantech.com/en-us/marketplace/detailinfo/41 "儲存空間"
[9]:https://en.wikipedia.org/wiki/Universally_unique_identifier "UUID"
[10]:https://www.influxdata.com/blog/influxdb-the-platform-for-time-series-data/ "influxdb 架構參考資料來源"


