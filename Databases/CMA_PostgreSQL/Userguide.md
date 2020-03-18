# Api-Consumption-Agent-Postgresql-GO

## Prerequisites

- Ops database must have been created and the same as postgresql servicemanager.

## Install

```bash
helm install [name] ./charts --namespace=[namespace]
```

## Uninstall

```bash
helm delete [name] --namespace=[namespace]
```

## API

### API spec

- **/apidoc**: swagger api document.

#### [POST] /v1/policies

Request header:

| Key             | Value                                                                        |
| --------------- | ---------------------------------------------------------------------------- |
| `Authorization` | Basic auth, authorized by `SECURITY_USER_NAME` and `SECURITY_USER_PASSWORD`. |
| `Content-Type`  | Array of service_instance_id.                                                |

Request body:

````json
{
    "operation":"limit",
    "service_instance_list":[
        "30a8dc65-c797-42c5-8634-72563f63fb1a",
        "57519480-9edd-4c54-8faa-a42bb8ed4e1d"
    ]
}
````

| Key                     | Value                |
| ----------------------- | -------------------- |
| `operation`             | limit/revoke         |
| `service_instance_list` | array of instance id |

Responce:

| Code   | Description                                       |
| ------ | ------------------------------------------------- |
| 201    | OK                                                |
| 400    | Request body error.                               |
| 401    | Authorization error.                              |
| 405    | Method not allowed.                               |
| 415    | Content-Type error.                               |
| 502    | Failed to connect to ops postgres.                |

Operation of each service_instance in service_instance_list:

- limit:
  - Limit permission of all users in service_instance (e.g. create schema).
  - Limit permission of all users in all schemas in service_instance  (e.g. create table).
  - Limit permission of all users in all tables in service_instance  (e.g. insert a new record).
  - "Limit" means user can only read and delete.
  - Super user still have permission to do anything.

- revoke:
  - User will be kicked out and having no permission to login in this service_instance.

#### [DELETE] /v1/policies

Request header:

| Key             | Value                                                                        |
| --------------- | ---------------------------------------------------------------------------- |
| `Authorization` | Basic auth, authorized by `SECURITY_USER_NAME` and `SECURITY_USER_PASSWORD`. |
| `Content-Type`  | Array of service_instance_id.                                                |

Request body:

````json
{
    "service_instance_list":[
        "30a8dc65-c797-42c5-8634-72563f63fb1a",
        "57519480-9edd-4c54-8faa-a42bb8ed4e1d"
    ]
}
````

| Key                     | Value                |
| ----------------------- | -------------------- |
| `service_instance_list` | array of instance id |

Responce:

| Code   | Related issue                                     |
| ------ | ------------------------------------------------- |
| 201    | OK                                                |
| 400    | Request body error.                               |
| 401    | Authorization error.                              |
| 405    | Method not allowed.                               |
| 415    | Content-Type error.                               |
| 502    | Failed to connect to ops postgres.                |

Operation of each service_instance in service_instance_list:

- resume:
  - Resume all before executing limit or revoke.
  - If any tableowner of some tables was deleted during the instance being limited, **these table will grant to the role named by instance**. 

## Ops postgres

- Api-Consumption-Agent-Postgresql-GO saves infomation in ops postgres tables. If there is no ops postgres, all CMA function can not work and API returns status code `502`.

### Database spec

#### *consumption.operation_db*

| Column                  | Type                 | Description                                     |
| ----------------------- | -------------------- | ----------------------------------------------- |
| `service_instance_pid`  | SERIAL (PRIMARY KEY) | Database generate this id when filling in data. |
| `service_instance_id`   | VARCHAR(256)         | User filled in service_instance_id in api.      |
| `policies`              | VARCHAR(16)          | `limit`, `revoke` or `resume`.                  |
| `status`                | VARCHAR(16)          | `limit`, `revoke`, `resume`, or `failed`.       |
| `failed_count`          | int8 (DEDAULT 0)     | >`0` when `status` is `failed`.                 |
| `message`               | VARCHAR(500)         | Only record one latest failed message.          |
| `updated_at`            | timestamptz          | Latest update time.                             |

#### *consumption.db_user*

| Column                  | Type                 | Description                                     |
| ----------------------- | -------------------- | ----------------------------------------------- |
| `user_pid`              | SERIAL (PRIMARY KEY) | Database generate this id when filling in data. |
| `service_instance_pid`  | SERIAL               | REFERENCES operation_db(service_instance_pid)   |
| `service_instance_id`   | VARCHAR(256)         | User filled in service_instance_id in api.      |
| `users`                 | VARCHAR(256)         | User in database `<service_instance_id>`        |

#### *consumption.group_schema*

| Column                  | Type                 | Description                                     |
| ----------------------- | -------------------- | ----------------------------------------------- |
| `schema_pid`            | SERIAL (PRIMARY KEY) | Database generate this id when filling in data. |
| `service_instance_pid`  | SERIAL               | REFERENCES operation_db(service_instance_pid)   |
| `service_instance_id`   | VARCHAR(256)         | User filled in service_instance_id in api.      |
| `schema_name`           | VARCHAR(256)         | Schema in database `<service_instance_id>`      |
| `schema_owner`          | VARCHAR(256)         | Schema owner.                                   |
| `updated_at`            | timestamptz          | Latest update time.                             |

#### *consumption.user_table*

| Column                  | Type                 | Description                                     |
| ----------------------- | -------------------- | ----------------------------------------------- |
| `table_pid`             | SERIAL (PRIMARY KEY) | Database generate this id when filling in data. |
| `service_instance_pid`  | SERIAL               | REFERENCES operation_db(service_instance_pid)   |
| `service_instance_id`   | VARCHAR(256)         | User filled in service_instance_id in api.      |
| `schema_name`           | VARCHAR(256)         | Schema in database `<service_instance_id>`      |
| `table_name`            | VARCHAR(256)         | table in database `<service_instance_id>`       |
| `table_owner`           | VARCHAR(256)         | table owner.                                    |
| `updated_at`            | timestamptz          | Latest update time.                             |

## Detail about ops posgres working

### Limit

1. Insert one record in *consumption.operation_db* to generate service_instance_pid
    - In ops postgres:

    ````bash
    INSERT INTO consumption.operation_db (service_instance_id) VALUES ('<service_instance_id>')
    ````

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message | updated_at |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------- | ---------- |
    | 1                    | instance-id-1        |          |        | 0            |         |            |

2. Insert records in *consumption.db_user* by searching users in apps postgres
    - In apps postgres:

    ````bash
    select datacl FROM pg_database WHERE datname = '<service_instance_id>'
    ````

    CMA will get a list of usernames except `APPS_POSTGRES_USERNAME` in enviromental variable and `vcap`, and using this list to limit users in apps postgres. After users are limited, CMA inserts records in ops postgres *consumption.db_user* in order to resume them in future.
    - In ops postgres:

    ````bash
    select user_pid from consumption.db_user where service_instance_pid='<service_instance_pid>' and users = '<service_instance_id>'
    ````

    If this user record is not exist, CMA inserts this user record in *consumption.db_user*:

    ````bash
    INSERT INTO consumption.db_user (service_instance_pid,service_instance_id, users) VALUES('<service_instance_pid>','<service_instance_id>','<username>')
    ````

    Example:

    -*consumption.db_user*

    | user_pid | service_instance_id | service_instance_pid   | users        |
    | -------- | ------------------- | ---------------------- | ------------ |
    | 1        | 1                   | instance-id-1          | binding-id-1 |
    | 2        | 1                   | instance-id-1          | binding-id-2 |
    | 3        | 1                   | instance-id-1          | binding-id-3 |
3. Insert records in *consumption.user_table* by searching tables in apps postgres
    - In apps postgres:

    In last step we got a list of usernames. Additionally, CMA add `service_instance_id` as an user in this list. This is because service broker `REASSIGN OWNED BY "<binding_id>" TO "<instance_id>"` to keep all things in instance by using instance_id as owner. CMA loops this list to get tables own by these users:

    ````bash
    select schemaname, tablename from pg_tables where tableowner ='<user>'
    ````

    Now CMA got a list of tables, and CMA alter their owner to `APPS_POSTGRES_USERNAME` by each table. Therefore, CMA inserts records in order to resume them in future.
    - In ops postgres:

    ````bash
    select table_pid from consumption.user_table where service_instance_id='<service_instance_id>' and table_owner = '<table_owner>' and schema_name = '<schema_name>'  and table_name = '<table_name>'
    ````

    If this table record is not exist, CMA inserts this user record in *consumption.db_user*:

    ````bash
    INSERT INTO consumption.user_table (service_instance_pid,service_instance_id, table_owner,schema_name, table_name, updated_at) VALUES('<service_instance_pid>', '<service_instance_id>', '<table_owner>','<schema_name>', '<table_name>', time.Now())
    ````

    Example:

    -*consumption.user_table*

    | table_pid | service_instance_id | service_instance_pid   | schema_name | table_name | table_owner   | updated_at          |
    | --------- | ------------------- | ---------------------- | ----------- | ---------- | ------------- | ------------------- |
    | 1         | 1                   | instance-id-1          | testSchema1 | table1     | binding-id-1  | 2020-02-02 02:02:02 |
    | 2         | 1                   | instance-id-1          | testSchema1 | table2     | binding-id-1  | 2020-02-02 02:02:02 |
    | 3         | 1                   | instance-id-1          | testSchema2 | newtable   | binding-id-2  | 2020-02-02 02:02:02 |
    | 3         | 1                   | instance-id-1          | testSchema3 | testtable  | instance-id-1 | 2020-02-02 02:02:02 |

4. Insert records in *consumption.group_schema* by searching schamas and groups in apps postgres
  
    By [user guide](http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/Documentation/blob/ce35deac9626c154a926659ed4a9da435f393e1a/documents/Database/PostgreSQL/userguide.md), wise-paas users binding schema to group to keep availble between different usernames in one group or multi groups. CMA have to limit and record schema when executing limit.
    - In apps postgres:

    ````bash
    select schema_name, schema_owner from information_schema.schemata where schema_owner <> 'vcap' and schema_owner <> 'postgres'
    ````

    Now CMA got a list of schemas and their owner, and CMA limit usage of each schema owner. Therefore, CMA inserts records in order to resume them in future.
    - In ops postgres:

    ````bash
    select select schema_pid from consumption.group_schema where service_instance_id='<service_instance_id>' and schema_owner = '<schema_owner>' and schema_name = '<schema_name>'
    ````

    If this table record is not exist, CMA inserts this user record in *consumption.db_user*:

    ````bash
    INSERT INTO consumption.group_schema (service_instance_pid,service_instance_id, schema_owner,schema_name, updated_at) VALUES('<service_instance_pid>', '<service_instance_id>', '<schema_owner>','<schema_name>',  time.Now())
    ````

    Example:

    -*consumption.group_schema*

    | schema_pid | service_instance_id | service_instance_pid   | schema_name | schema_owner   | updated_at          |
    | ---------- | ------------------- | ---------------------- | ----------- | -------------- | ------------------- |
    | 1          | 1                   | instance-id-1          | testSchema1 | group_1        | 2020-02-02 02:02:02 |
    | 3          | 1                   | instance-id-1          | testSchema2 | user_1         | 2020-02-02 02:02:02 |
    | 3          | 1                   | instance-id-1          | testSchema3 | group_1        | 2020-02-02 02:02:02 |

5. Insert records in *consumption.user_table* by searching tables own by schema_owner in apps postgres

    Wise-paas app developers can grant table owner to whitch they need when the app get usage permission in the instance. Schema owner may also be a table owner without list in `pg_database`.
    - In apps postgres:

    ````bash
    select tablename from pg_tables where tableowner ='<schema_owner>' and schemaname='<schema>'
    ````

    Now CMA got a list of tables and inserts records in order to resume them in future.
    - In ops postgres:

    ````bash
    select table_pid from consumption.user_table where service_instance_id='<service_instance_id>' and table_owner = '<table_owner>' and schema_name = '<schema_name>'  and table_name = '<table_name>'
    ````

    If this table record is not exist, CMA inserts this user record in *consumption.db_user*:

    ````bash
    INSERT INTO consumption.user_table (service_instance_pid,service_instance_id, table_owner,schema_name, table_name, updated_at) VALUES('<service_instance_pid>', '<service_instance_id>', '<table_owner>','<schema_name>', '<table_name>', time.Now())
    ````

    Example:

    -*consumption.user_table*

    | table_pid | service_instance_id | service_instance_pid   | schema_name | table_name | table_owner   | updated_at          |
    | --------- | ------------------- | ---------------------- | ----------- | ---------- | ------------- | ------------------- |
    | 1         | 1                   | instance-id-1          | testSchema1 | table1     | binding-id-1  | 2020-02-02 02:02:02 |
    | 2         | 1                   | instance-id-1          | testSchema1 | table2     | binding-id-1  | 2020-02-02 02:02:02 |
    | 3         | 1                   | instance-id-1          | testSchema2 | newtable   | binding-id-2  | 2020-02-02 02:02:02 |
    | 3         | 1                   | instance-id-1          | testSchema3 | testtable  | instance-id-1 | 2020-02-02 02:02:02 |
    | 3         | 1                   | instance-id-1          | testSchema1 | table3     | group_1       | 2020-02-02 02:02:02 |

6. Get list of tableowner to limit permission in schema

    Sometimes tableowner also have permission of usage to schema. CMA will search by *consumption.user_table*.
    - In ops postgres:

    ````bash
    select distinct table_owner, schema_name FROM consumption.user_table where service_instance_id= '<service_instance_id>'
    ````

    **This will not insert or update any record in ops table.**

7. After limit these users in schema, CMA complete its job about limit in one instance. So now CMA update its work status:

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message | updated_at          |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------- | ------------------- |
    | 1                    | instance-id-1        | limit    | limit  | 0            |         | 2020-02-02 02:02:02 |

    If any error occured in limiting this instance, CMA will record failed count and only one latest error message.

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message      | updated_at          |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------------ | ------------------- |
    | 1                    | instance-id-1        | limit    | failed | 1            | pq: i/o tim..| 2020-02-02 02:02:02 |

### Revoke

1. Insert one record in *consumption.operation_db* to generate service_instance_pid
    - In ops postgres:

    ````bash
    INSERT INTO consumption.operation_db (service_instance_id) VALUES ('<service_instance_id>')
    ````

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message | updated_at |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------- | ---------- |
    | 1                    | instance-id-1        |          |        | 0            |         |            |

2. Insert records in *consumption.db_user* by searching users in apps postgres
    - In apps postgres:

    ````bash
    select datacl FROM pg_database WHERE datname = '<service_instance_id>'
    ````

    CMA will get a list of usernames except `APPS_POSTGRES_USERNAME` in enviromental variable and `vcap`, and using this list to limit users in apps postgres. After users are revoked, CMA inserts records in ops postgres *consumption.db_user* in order to resume them in future.
    - In ops postgres:

    ````bash
    select user_pid from consumption.db_user where service_instance_pid='<service_instance_pid>' and users = '<service_instance_id>'
    ````

    If this user record is not exist, CMA inserts this user record in *consumption.db_user*:

    ````bash
    INSERT INTO consumption.db_user (service_instance_pid,service_instance_id, users) VALUES('<service_instance_pid>','<service_instance_id>','<username>')
    ````

    Example:

    -*consumption.db_user*

    | user_pid | service_instance_id | service_instance_pid   | users        |
    | -------- | ------------------- | ---------------------- | ------------ |
    | 1        | 1                   | instance-id-1          | binding-id-1 |
    | 2        | 1                   | instance-id-1          | binding-id-2 |
    | 3        | 1                   | instance-id-1          | binding-id-3 |

3. After revoked these users , CMA complete its job about revoke in one instance. So now CMA update its work status:

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message | updated_at          |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------- | ------------------- |
    | 1                    | instance-id-1        | revoke   | revoke | 0            |         | 2020-02-02 02:02:02 |

    If any error occured in revoking this instance, CMA will record failed count and only one latest error message.

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message      | updated_at          |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------------ | ------------------- |
    | 1                    | instance-id-1        | revoke   | failed | 1            | pq: i/o tim..| 2020-02-02 02:02:02 |

### Resume

1. Grant user in service_instance
    - In ops postgres:

    ````bash
    select users from consumption.db_user where service_instance_id='<service_instance_id>'
    ````

2. Grant table to user and schema owner
    - In ops postgres:

    ````bash
    select schema_name, table_name, table_owner from consumption.user_table where service_instance_id='<service_instance_id>'
    ````

    If any tableowner of some tables was deleted during the instance being limited, **these table will grant to the role named by instance**. (具體操作例子: 某user建立table → CMA limit → SB unbind某user，某user被刪除 → 已被CMA記錄的table無法還給原tableowner → 還給instance_id)

3. Grant schema to users
    - In ops postgres:

    ````bash
    select schema_name, schema_owner from consumption.group_schema where service_instance_id='<service_instance_id>'
    ````

4. After resumed these users , CMA complete its job about resume in one instance. So now CMA update its work status:

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message | updated_at          |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------- | ------------------- |
    | 1                    | instance-id-1        | resume   | resume | 0            |         | 2020-02-02 02:02:02 |

    If any error occured in resuming this instance, CMA will record failed count and only one latest error message.

    Example:

    -*consumption.operation_db*

    | service_instance_pid | service_instance_id  | policies | status | failed_count | message      | updated_at          |
    | -------------------- | -------------------- | -------- | ------ | ------------ | ------------ | ------------------- |
    | 1                    | instance-id-1        | resume   | failed | 1            | pq: i/o tim..| 2020-02-02 02:02:02 |

    CMA WILL remove record related to the instance in *consumption.db_user*, *consumption.group_schema* and *consumption.user_table* when the instance resume successfully.

## For developer

### Build

- windows

```bash
  go build -o cmagent.exe ./cmd/postgresqlcma
```

- linux

```bash
  go build -o cmagent ./cmd/postgresqlcma
```

### Docker image

```bash
docker build -t harbor.arfa.wise-paas.com/database/api-consumption-agent-postgresql-go:<version> .
```

```bash
docker push harbor.arfa.wise-paas.com/database/api-consumption-agent-postgresql-go:<version>
```

### Helm chart

- package: 

```bash
helm package charts/
```

