# 备份还原

本文将为您介绍如何备份还原MongoDB数据。

## 前提条件
1. 从管理员获取MongoDB的Root的账号和密码。

## 获取外部IP和Port（Container MongoDB）
```
kubectl -n <your_namespace_name> get svc
```
输出类似于：
```
NAME                                    TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)
apps-mongodb-external-entrypoint-svc    LoadBalancer   10.233.56.141   10.1.16.132   27017:31423/TC
apps-mongodb-mongodb-replicaset-svc-0   ClusterIP      10.233.24.66    <none>        27017/TCP
apps-mongodb-mongodb-replicaset-svc-1   ClusterIP      10.233.9.171    <none>        27017/TCP
apps-mongodb-mongodb-replicaset-svc-2   ClusterIP      10.233.63.53    <none>        27017/TCP
```
如上输出讯息可以知道container的MongoDB内网地址为10.233.56.141，外网地址对应到10.1.16.131，port号27017

## 安装 mongodb client 3.6.6 (ubuntu 16.04 为例)
```
wget http://downloads.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz
tar -zxvf mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz
cp mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/* /usr/local/bin/
mongo
```
成功时，输出类似于：
```
wget http://downloads.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz
--2020-08-28 07:05:06--  http://downloads.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz
Resolving downloads.mongodb.org (downloads.mongodb.org)... 13.35.7.19, 13.35.7.26, 13.35.7.83, ...
Connecting to downloads.mongodb.org (downloads.mongodb.org)|13.35.7.19|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 100627358 (96M) [application/x-gzip]
Saving to: ‘mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz’

mongodb-linux-x86_64-ubuntu1604-3.6.6. 100%[==========================================================================>]  95.96M  15.4MB/s    in 7.4s

2020-08-28 07:05:14 (13.0 MB/s) - ‘mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz’ saved [100627358/100627358]

tar -zxvf mongodb-linux-x86_64-ubuntu1604-3.6.6.tgz
mongodb-linux-x86_64-ubuntu1604-3.6.6/README
mongodb-linux-x86_64-ubuntu1604-3.6.6/THIRD-PARTY-NOTICES
mongodb-linux-x86_64-ubuntu1604-3.6.6/MPL-2
mongodb-linux-x86_64-ubuntu1604-3.6.6/GNU-AGPL-3.0
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongodump
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongorestore
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongoexport
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongoimport
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongostat
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongotop
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/bsondump
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongofiles
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongoreplay
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongoperf
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongod
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongos
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/mongo
mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/install_compass

cp mongodb-linux-x86_64-ubuntu1604-3.6.6/bin/* /usr/local/bin/

mongo
MongoDB shell version v3.6.6
connecting to: mongodb://127.0.0.1:27017
2020-08-28T07:07:06.234+0000 E QUERY    [js] Error: couldn't connect to server 127.0.0.1:27017, connection attempt failed: SocketException: Error connecting to 127.0.0.1:27017 :: caused by :: Connection refused :
connect@src/mongo/shell/mongo.js:257:13
@(connect):1:6
exception: connect failed
```

## 备份

- 备份全部:
```
mongodump --host <your_mongo_host> --port <your_mongo_port> --username <your_mongo_username> --password <your_mongo_password> --authenticationDatabase <your_mongo_authentication_database> --out ./
```
输出类似于：
```
mongodump --host 61.219.26.35 -u dmn3ntbghmctc20tpq5j -p 830wgzuvwy6fs49uby85  --authenticationDatabase admin --out ./temp            2020-08-28T08:55:52.601+0000    writing admin.system.users to
2020-08-28T08:55:52.608+0000    done dumping admin.system.users (62 documents)
2020-08-28T08:55:52.608+0000    writing admin.system.roles to
2020-08-28T08:55:52.612+0000    done dumping admin.system.roles (2 documents)
2020-08-28T08:55:52.612+0000    writing admin.system.version to
2020-08-28T08:55:52.616+0000    done dumping admin.system.version (2 documents)
2020-08-28T08:55:52.616+0000    writing cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495.scada_HistRawData to
2020-08-28T08:55:52.616+0000    writing f5e641f8-aef1-44e0-8a36-91eb05cf687c.scada_HistRawData to
2020-08-28T08:55:52.617+0000    writing a400cb0c-b130-426e-9bb8-f6186acd2ba6.scada_HistRawData to
2020-08-28T08:55:52.617+0000    writing a400cb0c-b130-426e-9bb8-f6186acd2ba6.m2i_bending_realTimeData to
//备份过程内容省略//
```

- 备份其中一个数据库
```
mongodump --host <your_mongo_host> --port <your_mongo_port> --username <your_mongo_username> --password <your_mongo_password> --db <your_mongo_database> --authenticationDatabase <your_mongo_authentication_database> --out ./
```

输出类似于：
```
mongodump --host 61.219.26.35 -u dmn3ntbghmctc20tpq5j -p 830wgzuvwy6fs49uby85 --db 0573cd0e-60ce-438c-a165-22edf50f124d --authenticationDatabase admin --out ./
2020-08-28T08:53:09.095+0000    writing 0573cd0e-60ce-438c-a165-22edf50f124d.test to
2020-08-28T08:53:09.095+0000    writing 0573cd0e-60ce-438c-a165-22edf50f124d.default to
2020-08-28T08:53:09.099+0000    done dumping 0573cd0e-60ce-438c-a165-22edf50f124d.test (1 document)
2020-08-28T08:53:09.099+0000    done dumping 0573cd0e-60ce-438c-a165-22edf50f124d.default (0 documents)
ls
0573cd0e-60ce-438c-a165-22edf50f124d
ls 0573cd0e-60ce-438c-a165-22edf50f124d/
default.bson  default.metadata.json  test.bson  test.metadata.json
```

## 还原

- 还原全部数据库

```
 mongorestore --host <your_mongo_host> --port <your_mongo_port> --username <your_mongo_username> --password <your_mongo_password>  --authenticationDatabase <your_mongo_authentication_database> ./temp/
```

输出类似于：
```
 mongorestore --host 127.0.0.1 --port 27017 --username root --password root  --authenticationDatabase admin ./temp/
 2020-08-31T09:48:47.782+0000    preparing collections to restore from
2020-08-31T09:48:47.790+0000    reading metadata for cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495.scada_HistRawData from temp/cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495/scada_HistRawData.metadata.json
2020-08-31T09:48:47.791+0000    reading metadata for f5e641f8-aef1-44e0-8a36-91eb05cf687c.scada_HistRawData from temp/f5e641f8-aef1-44e0-8a36-91eb05cf687c/scada_HistRawData.metadata.json
2020-08-31T09:48:47.791+0000    reading metadata for a400cb0c-b130-426e-9bb8-f6186acd2ba6.scada_HistRawData from temp/a400cb0c-b130-426e-9bb8-f6186acd2ba6/scada_HistRawData.metadata.json
2020-08-31T09:48:47.792+0000    reading metadata for d8e1f639-00f7-4f35-baa7-08216a9a5151.apm_metric_rawData from temp/d8e1f639-00f7-4f35-baa7-08216a9a5151/apm_metric_rawData.metadata.json
2020-08-31T09:48:47.877+0000    restoring d8e1f639-00f7-4f35-baa7-08216a9a5151.apm_metric_rawData from temp/d8e1f639-00f7-4f35-baa7-08216a9a5151/apm_metric_rawData.bson
2020-08-31T09:48:47.894+0000    restoring cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495.scada_HistRawData from temp/cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495/scada_HistRawData.bson
2020-08-31T09:48:47.911+0000    restoring f5e641f8-aef1-44e0-8a36-91eb05cf687c.scada_HistRawData from temp/f5e641f8-aef1-44e0-8a36-91eb05cf687c/scada_HistRawData.bson
2020-08-31T09:48:47.927+0000    restoring a400cb0c-b130-426e-9bb8-f6186acd2ba6.scada_HistRawData from temp/a400cb0c-b130-426e-9bb8-f6186acd2ba6/scada_HistRawData.bson
2020-08-31T09:48:50.767+0000    [################........]  d8e1f639-00f7-4f35-baa7-08216a9a5151.apm_metric_rawData  50.8MB/72.2MB  (70.3%)
2020-08-31T09:48:50.767+0000    [........................]   cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495.scada_HistRawData  33.2MB/5.93GB   (0.5%)
2020-08-31T09:48:50.767+0000    [........................]   f5e641f8-aef1-44e0-8a36-91eb05cf687c.scada_HistRawData   34.2MB/914MB   (3.7%)
2020-08-31T09:48:50.767+0000    [#.......................]   a400cb0c-b130-426e-9bb8-f6186acd2ba6.scada_HistRawData   37.0MB/508MB   (7.3%)
2020-08-31T09:48:50.767+0000
2020-08-31T09:48:51.986+0000    [########################]  d8e1f639-00f7-4f35-baa7-08216a9a5151.apm_metric_rawData  72.2MB/72.2MB  (100.0%)
2020-08-31T09:48:51.986+0000    restoring indexes for collection d8e1f639-00f7-4f35-baa7-08216a9a5151.apm_metric_rawData from metadata
//还原过程内容省略//
```

- 还原其中一个数据库

```
mongorestore --host <your_mongo_host> --port <your_mongo_port> --username <your_mongo_username> --password <your_mongo_password> --db <your_mongo_database> --authenticationDatabase <your_mongo_authentication_database> ./backup/<your_mongo_database>
```

输出类似于：
```
mongorestore --host 127.0.0.1 --port 27017 --username root --password root --db 0573cd0e-60ce-438c-a165-22edf50f124d --authenticationDatabase admin ./0573cd0e-60ce-438c-a165-22edf50f124d/
2020-08-31T09:45:32.119+0000    the --db and --collection args should only be used when restoring from a BSON file. Other uses are deprecated a                           nd will not exist in the future; use --nsInclude instead
2020-08-31T09:45:32.119+0000    building a list of collections to restore from 0573cd0e-60ce-438c-a165-22edf50f124d dir
2020-08-31T09:45:32.119+0000    reading metadata for 0573cd0e-60ce-438c-a165-22edf50f124d.test from 0573cd0e-60ce-438c-a165-22edf50f124d/test.m                           etadata.json
2020-08-31T09:45:32.120+0000    reading metadata for 0573cd0e-60ce-438c-a165-22edf50f124d.default from 0573cd0e-60ce-438c-a165-22edf50f124d/def                           ault.metadata.json
2020-08-31T09:45:32.155+0000    restoring 0573cd0e-60ce-438c-a165-22edf50f124d.default from 0573cd0e-60ce-438c-a165-22edf50f124d/default.bson
2020-08-31T09:45:32.157+0000    no indexes to restore
2020-08-31T09:45:32.157+0000    finished restoring 0573cd0e-60ce-438c-a165-22edf50f124d.default (0 documents)
2020-08-31T09:45:32.189+0000    restoring 0573cd0e-60ce-438c-a165-22edf50f124d.test from 0573cd0e-60ce-438c-a165-22edf50f124d/test.bson
2020-08-31T09:45:32.191+0000    no indexes to restore
2020-08-31T09:45:32.191+0000    finished restoring 0573cd0e-60ce-438c-a165-22edf50f124d.test (1 document)
2020-08-31T09:45:32.191+0000    done
```

- 还原成功

登入DB查询资料库，有显示多笔资料
```
root@wise-stack-maas:/home# mongo -host 127.0.0.1 --port 27017 --username root --password root --authenticationDatabase admin
MongoDB shell version v3.6.3
connecting to: mongodb://127.0.0.1:27017/
MongoDB server version: 3.6.6
Server has startup warnings:
2020-08-31T09:42:52.161+0000 I STORAGE  [initandlisten]
2020-08-31T09:42:52.161+0000 I STORAGE  [initandlisten] ** WARNING: Using the XFS filesystem is strongly recommended with the WiredTiger storage engine
2020-08-31T09:42:52.161+0000 I STORAGE  [initandlisten] **          See http://dochub.mongodb.org/core/prodnotes-filesystem
2020-08-31T09:42:53.477+0000 I CONTROL  [initandlisten] ** WARNING: You are running this process as the root user, which is not recommended.
2020-08-31T09:42:53.477+0000 I CONTROL  [initandlisten]
2020-08-31T09:42:53.478+0000 I CONTROL  [initandlisten]
2020-08-31T09:42:53.478+0000 I CONTROL  [initandlisten] ** WARNING: You are running on a NUMA machine.
2020-08-31T09:42:53.478+0000 I CONTROL  [initandlisten] **          We suggest launching mongod like this to avoid performance problems:
2020-08-31T09:42:53.478+0000 I CONTROL  [initandlisten] **              numactl --interleave=all mongod [other options]
2020-08-31T09:42:53.478+0000 I CONTROL  [initandlisten]
> show databases;
0573cd0e-60ce-438c-a165-22edf50f124d  0.000GB
13eb2d6d-1733-42ca-95b9-824051857e65  0.000GB
188943ff-ee3a-48a7-9c44-9309e12c4861  0.002GB
3dfd23fc-9071-411e-8616-66eec6755ead  0.000GB
645d2d1c-6a59-4c84-9c76-2d5948766394  0.000GB
7dcdfb4e-75e2-4b20-99d7-1ae38e9d7c07  0.000GB
a400cb0c-b130-426e-9bb8-f6186acd2ba6  0.333GB
admin                                 0.000GB
b639426f-5a42-44b1-a7b3-b982c9f75c01  0.000GB
cd2eb1c3-eaa3-43bc-9964-18a0c3eaf495  0.412GB
d42b178e-f7c5-4001-9a0f-eb4b617bd28a  0.000GB
d8e1f639-00f7-4f35-baa7-08216a9a5151  0.044GB
e4094a91-1bcd-4af7-a8a7-81f04e0bf22e  0.000GB
f5e641f8-aef1-44e0-8a36-91eb05cf687c  0.544GB
local                                 0.000GB
>                        
```
