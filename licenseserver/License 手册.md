# License 手册

## 简介

license 为 WISE-PaaS 云服务提供有效的license 以及期限，分为两部分，server 端和 agent 端，server 运行在云端，为云上服务生成和维护服务的 license，agent 端运行在边缘端，为边缘端服务提供license，agent 端license 是通过server 端激活生成后通过License File添加至agent 端。
server 端和agent 端提供相同的校验方式和 RESTful API，兼容服务在云端和边缘端 license 的校验，服务不需要进行任何适配修改。

## 1. 流程

### 1.1 云服务

![云服务流程](images/云服务流程.png)

- Step1: 用户订购或更新服务后，Catalog生成订阅信息，通知各个buy生成服务实例，同时将订阅信息同步给License Server。
- Step2: License Server获得订阅信息后，生成license信息。
- Step3: 服务实例启动后通过API向License Server获取license。
- Step4: 服务实例获取到license后，拿自身信息根据规则与license中的信息对比，验证通过成功激活，反之，激活失败。

### 1.2 边缘服务

![边缘服务流程](images/边缘服务流程.png)

## 2. License 验证

> licese server 端和 agent 端提供相同的校验方式和RESTful API

### 2.1. 获取接口

| API                                                                       | 描述           |
| ------------------------------------------------------------------------- | ------------ |
| /v1/api/partNum/licenseQty                                                | 通过服务料号获取     |
| /v1/api/serviceName/ [serviceName]/serviceInstanceId/ [serviceInstanceId] | 通过服务名称获取     |
| /v1/api/licenses/serviceName/[serviceName]/username/[username]            | 通过用户名和服务名称获取 |

#### 2.2. 通过服务料号获取

> 调用/v1/api/partNum/licenseQty可以通过服务料号（pn）和服务实例id（id）获取激活码

##### 请求参数

| 名称  | 类型     | 是否必选 | 示例                                                  | 描述                                                                                                              |
| --- | ------ | ---- | --------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| pn  | Stirng | 是    | 9806WPDASH                                          | 服务上架时提供的服务料号，即PN                                                                                                |
| id  | String | 是    | eks00120a957f4-0bf9-4faf-90cd-694919cd4b68Dashboard | 服务实例id，即serviceInstanceId。若为App，生成规则为clustername+workspaceId+namespaceName（不含+）；若为其他服务，则为订阅时由Managed Service生成。 |

##### 返回数据

| 名称                 | 类型      | 示例值                                                 | 描述                                 |
| ------------------ | ------- | --------------------------------------------------- | ---------------------------------- |
| id                 | String  | eks00120a957f4-0bf9-4faf-90cd-694919cd4b68Dashboard | 服务实例id，即serviceInstanceId          |
| subscriptionId     | String  | ff4fbd21-5962-4427-88a0-b8ef4ac9b393                | 订阅号id                              |
| isValidTransaction | Boolean | true                                                | 用户订阅状态，true=有效，false=无效，若为无效时，激活失败 |
| number             | Int     | 1                                                   | 订阅的料号数量，即pnQuantity                |
| authcode           | String  | 3080-e825-003c                                      | 激活码                                |
| datacenterCode     | String  | sa                                                  | 数据中心编号，如sa，hz，je                   |
| activeInfo         | String  | “ ”                                                 | 服务上架时自定义的激活信息，保留项                  |
| company            | String  | Advantech                                           | 订阅号所属公司信息                          |
| subscriptionType   | String  | paid                                                | 订阅类型（付费/试用），值为：paid/on trial       |

##### 返回码

| Http Code | 描述                                                    |
| --------- | ----------------------------------------------------- |
| 200       | successful operation，返回的json数据格式如上Response Example中所述 |
| 204       | *no content*，未查询到license 信息                           |

#### 2.3.  通过服务名称获取授权码

> 调用/v1/api/serviceName/[serviceName]/serviceInstanceId/[serviceInstanceId]可以通过服务名称（serviceName）和服务实例id（serviceInstanceId）获取激活码

##### 请求参数

| 名称                | 类型     | 是否必选 | 示例值                                               | 描述                 |
| ----------------- | ------ | ---- | ------------------------------------------------- | ------------------ |
| serviceName       | String | 是    | Dashboard                                         | 服务上架时提供的服务名称       |
| serviceInstanceId | String | 是    | eks00145b957f4-0bf9-4faf-90cd-694200cd4b74Datahub | 服务实例id             |
| page              | Int    | 否    | 1                                                 | 查询结果的第几页，默认是1      |
| pageSize          | Int    | 否    | 10                                                | 查询结果每页显示的结果数，默认是10 |

##### 返回数据

| 名称                 | 类型      | 示例值                                           | 描述                                 |
| ------------------ | ------- | --------------------------------------------- | ---------------------------------- |
| total              | Int     | 3                                             | 查询到的激活码总数                          |
| id                 | String  | eks00145b957f4-0bf9-4faf-90cd-694200cd4b74apm | 服务实例id，即serviceInstanceId          |
| pn                 | String  | 9806WPDASH                                    | 服务上架时提供的服务料号，即PN                   |
| subscriptionId     | String  | 2e687325-2f50-43c8-b221-771ea517c40b          | 订阅号id                              |
| isValidTransaction | Boolean | true                                          | 用户订阅状态，true=有效，false=无效，若为无效时，激活失败 |
| number             | Int     | 1                                             | 订阅的料号数量，即pnQuantity                |
| authcode           | String  | a7d7-7d48-0001                                | 激活码                                |
| datacenterCode     | String  | sa                                            | 数据中心编号，如sa，hz，je                   |
| activeInfo         | String  | “ ”                                           | 服务上架时自定义的激活信息，保留项                  |
| company            | String  | Advantech                                     | 订阅号所属公司信息                          |
| subscriptionType   | String  | paid                                          | 订阅类型（付费/试用），值为：paid/on trial       |

##### 返回码

| Http Code | 描述                                                       |
| --------- | -------------------------------------------------------- |
| 200       | *successful operation*，返回的json数据格式如上Response Example中所述。 |

#### 2.4. 通过用户名和服务名称获取授权码

> 调用/v1/api/licenses/serviceName/[serviceName]/username/[username]可以通过服务名称（serviceName）和用户名（username）获取激活码

##### 请求参数

| 名称          | 类型     | 是否必选 | 示例值                   | 描述                 |
| ----------- | ------ | ---- | --------------------- | ------------------ |
| serviceName | String | 是    | Dashboard             | 服务上架时提供的服务名称       |
| username    | String | 是    | test@advantech.com.cn | 用户 E-mail          |
| page        | Int    | 否    | 1                     | 查询结果的第几页，默认是1      |
| pageSize    | Int    | 否    | 10                    | 查询结果每页显示的结果数，默认是10 |

##### 返回数据

| 名称                 | 类型      | 示例值                                           | 描述                                 |
| ------------------ | ------- | --------------------------------------------- | ---------------------------------- |
| total              | Int     | 3                                             | 查询到的激活码总数                          |
| id                 | String  | eks00145b957f4-0bf9-4faf-90cd-694200cd4b74apm | 服务实例id，即serviceInstanceId          |
| pn                 | String  | 9806WPDASH                                    | 服务上架时提供的服务料号，即PN                   |
| subscriptionId     | String  | 2e687325-2f50-43c8-b221-771ea517c40b          | 订阅号id                              |
| isValidTransaction | Boolean | true                                          | 用户订阅状态，true=有效，false=无效，若为无效时，激活失败 |
| number             | Int     | 1                                             | 订阅的料号数量，即pnQuantity                |
| authcode           | String  | a7d7-7d48-0001                                | 激活码                                |
| datacenterCode     | String  | sa                                            | 数据中心编号，如sa，hz，je                   |
| activeInfo         | String  | “ ”                                           | 服务上架时自定义的激活信息，保留项                  |
| company            | String  | Advantech                                     | 订阅号所属公司信息                          |
| subscriptionType   | String  | paid                                          | 订阅类型（付费/试用），值为：paid/on trial       |

##### 返回码

| Http Code | 描述                                                       |
| --------- | -------------------------------------------------------- |
| 200       | *successful operation*，返回的json数据格式如上Response Example中所述。 |
