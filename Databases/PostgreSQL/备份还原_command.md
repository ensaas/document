# 备份还原

本文将为您介绍如何备份还原PostgresQL数据。

## 前提条件
1. 从管理员获取PostgreSQL的Admin账号。

## 获取外部IP和Port（Container PostgreSQL）

如果是Container PostgreSQL，需要先获取服务的外部IP，才可以将数据备份到K8S集群外部。
```
kubectl -n <your_namespace_name> get svc
```
输出类似于：
```
NAME                                    TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)
apps-postgres-stolon-keeper-headless    ClusterIP      None            <none>        5432/TCP
apps-postgres-stolon-proxy              LoadBalancer   10.233.47.118   10.1.16.131   5432:30526/TCP
```
如上输出讯息可以知道container的PG内网地址为10.233.29.72，外网地址对应到10.1.16.131，port号5432。

## 安装 postgresql client (ubuntu 16.04 为例)
```
sudo apt-get install wget ca-certificates
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
sudo apt-get update
sudo apt-get install postgresql-client-10 -y
psql
```
成功时，输出类似于：
```
psql: could not connect to server: No such file or directory
        Is the server running locally and accepting
        connections on Unix domain socket "/var/run/postgresql/.s.PGSQL.5432"?
```

## 备份

- 备份全部:
```
export PGPASSWORD=<your_pg_password>
pg_dumpall -h <your_pg_host> -p <your_pg_port> -U <your_pg_username> | gzip > backup.gz;
```
输出类似于：
```
export PGPASSWORD=xxxxxxxxxxxxxxx
pg_dumpall -h 61.219.26.33 -p 5432 -U postgres | gzip > backup.gz
ls
backup.gz
```

- 备份其中一个数据库
```
export PGPASSWORD="<your_pg_password>"
pg_dump -h <your_pg_host> -p <your_pg_port> -U <your_pg_username> -d <your_database_name> > <your_database_name>.sql
```

输出类似于：
```
export PGPASSWORD=xxxxxxxxxxxxxxx
pg_dump -h 61.219.26.33 -p 5432 -U postgres -d bd914172-68f0-49a0-a99a-f635312e317d > bd914172-68f0-49a0-a99a-f635312e317d.sql
ls
bd914172-68f0-49a0-a99a-f635312e317d.sql
```

## 还原

- 还原全部数据库

```
cat backup.gz | gunzip | psql -h <your_pg_host> -p <your_pg_port> -U <your_pg_username> postgres 
```

输出类似于：
```
cat backup.gz | gunzip | psql -h 127.0.0.1 -p 5432 --username postgres postgres
//还原过程内容省略//
```

- 还原其中一个数据库

```
export PGPASSWORD="<your_pg_password>"
psql -h <your_pg_host> -p <your_pg_port> -U <your_pg_username> <your_database_name> < <your_database_name>.sql
```

输出类似于：
```
export PGPASSWORD=xxxxxxxxxxxxxxx
psql -h 127.0.0.1 -p 5432 --username postgres bd914172-68f0-49a0-a99a-f635312e317d < bd914172-68f0-49a0-a99a-f635312e317d.sql
SET
SET
SET
SET
SET
 set_config
------------

(1 row)

SET
SET
SET
SET
CREATE EXTENSION
COMMENT
REVOKE
```

- 还原成功

登入DB查询资料库，有显示多笔资料
```

                                                              List of databases
                 Name                 |  Owner   | Encoding |   Collate   |    Ctype    |                  Access privileges
--------------------------------------+----------+----------+-------------+-------------+-----------------------------------------------------
 1cae54d8-d0e1-4d3b-8551-f4ab1676f721 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | postgres=CTc/postgres
 1da0bf93-b227-44e4-8581-52e058a05e53 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | postgres=CTc/postgres                              +
                                      |          |          |             |             | "2c7dc637-19fc-413c-a854-402de440d283"=CTc/postgres
 56a0278d-f5e5-4b3f-96db-d05e1a59c877 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | postgres=CTc/postgres                              +
                                      |          |          |             |             | "7c79c3c4-bfd4-4275-9190-7faabee849cf"=CTc/postgres+
                                      |          |          |             |             | "8465cf1f-f85e-43bd-bc48-dee43e85ab15"=CTc/postgres+
                                      |          |          |             |             | "92e674a4-a6f6-4336-a961-45fc3886a89b"=CTc/postgres+
                                      |          |          |             |             | "95ca378d-7368-4888-9734-62e4853375b2"=CTc/postgres+
                                      |          |          |             |             | "9e07e737-25f8-48f1-8347-f7646ce3ea30"=CTc/postgres+
                                      |          |          |             |             | "d8d2b54e-f2fb-4dad-be6e-a27de56fc0ac"=CTc/postgres+
                                      |          |          |             |             | "f6c9bef0-c708-4b73-ae29-153be121d3ec"=CTc/postgres+
                                      |          |          |             |             | "fba7703f-a0de-4193-a956-835943f7ab60"=CTc/postgres+
                                      |          |          |             |             | "fd7bb370-fef3-4967-9777-4d4634b8e7c9"=CTc/postgres
 67dc3670-c80a-4f34-a947-5901a1efebfb | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | postgres=CTc/postgres                              
```
