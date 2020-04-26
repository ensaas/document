## ListingSystem4.0 ReleaseNote

### version：v-1.3.0.6
##### Fixed:
- 修改定时同步serviceInfo的bug
##### Updated:
- 同步时间添加到环境变量，默认是每日00：00

### version：v-1.3.0.2
##### Added:
- 在servicePackage上添加planNum
- 在servicePackage中的pnInfo中添加chargeType
- datacenterCode添加local的校验

### version：v-1.3.0.1
##### Added:
- post /v1/servicePackage
- get /v1/servicePackage
- get /v1/servicePackage/packageList
- put /v1/servicePackage/{id}
- delete /v1/servicePackage/{id}
- 在servicePlan上添加deliveryType 
##### Removed:
- 从deployment上删除deliveryType

### version：v-1.2.0.9
##### Update:
- 修改检验ssoToken的参数validateDc为datacenterCode

### version：v-1.2.0.8
##### Fixed:
- 修改swagger，添加https协议头
- 修改swagger上面显示的版本号
- 修改serviceNamByPn的定义类型
- 修改查询servicePackage查询参数问题

### version：v-1.2.0.7
##### Updated:
- 兼容k8s 1.14, 1.16
##### Fixed:
- 修改swagger

### version：v-1.2.0.6
##### Added:
- 添加charts目录，进行CI操作
- 在serviceWithPlan中，在依赖的plan中返回pn对应的所有价格
##### Updated:
- 修改serviceByPn，返回的pn全部从pricing中获取到
##### Fixed:
- 修改一键同步serviceInfo的问题

### version：v-1.2.0.3
##### Added:
- get serviceNameByPn中不仅返回该serviceName，同时返回这个serviceName中对应的所有的pn以及pn的各种身份的价格
##### Updated:
- 从一个料号查找到的所有该pn对应的service下的所有pn的信息中，去掉je站点的信息
##### Removed:
- 去掉了添加service时对serviceName的限制
- 去掉了添加plan时对planName的限制

### version：v-1.2.0.2
##### Updated:
- 更新swagger中的servicePackage
- 更新metric中的添加限制，serviceName必须存在于service中，datacenterCode必须存在于datacenterCode表中
- 更新metric中的修改限制，可以修改所有字段
- 更新了同步serviceInfo查询service的条件，从service和servicePackage中查询
##### Fixed:
- 修改了serviceInfo同步时，如果serviceInfo已经存在的问题
- 修改了通过serviceName查询metric失败的问题

### version：v-1.2.0.1
##### Added:
- get   /servicePackage
- put   /servicePackage
- delete /servicePackage
- post /servicePackage
##### Updated:
- 修改 GET /service/serviceWithPlan 接口的返回字段，添加 dependency中的serviceCategory,plan对应的pn
- 在同步的时候将所有的pn记录到表中，如果下次不输入pn就直接用表中的pn来同步service Info，首先是通过service name和pn从marketplace同步信息，之后就会记录当前的service与pn的对应关系。如果之后不输入pn就用这个pn去查询，如果输入了pn就去更新这个serive与pn的对应关系
- metric pricing添加serviceName和datacenterCode字段，同时添加这个两个字段查询
- 对所有的get接口添加operation app的client Token的验证
- 对于serviceInfo添加一键同步操作（前提是先要缓存service和pn之间的关系）
##### Fixed:
- 修改了同步service info中图片中，当service从markketlace获取不到出错的问题
- 改了同步service最低价由于更改pnQuantity变化而出现的问题
- 修改env中环境变量ssoUrl.esSSo为ssoUrl.esSso 

### version：v-1.1.0.9

##### Updated:

- 在版本v-1.1.0.4的基础上添加了clientToken
- 修改了最低价由于pnQuantity由[1,10]变成[1-10]的问题

### version：v-1.1.0.8

##### Updated:

- 修改 GET  /service/serviceWithPlan 接口的返回字段，并对plan进行排序

### version：v-1.1.0.7

##### Add:

- 添加api    get  /service/serviceWithPlan

### version：v-1.1.0.6

##### Updated:

- 修改serviceCategory在swagger中的字段错误

- 修改了serviceInfo路径不准确的问题


### version：v-1.1.0.5

##### Updated:

- 对所有的增删改api添加日志记录，该记录整合了logging项目，将日志记录到容器指定的文件中
- 同步serviceInfo中的图片，将图片下载到本地，替换serviceInfo中的imgUrl为本地的url
- get pricing添加appBuy的client Token认证
- 除get  /datacenter这个接口外，其他所有接口增加查询参数：validateDc,使用该参数来判断需要到哪个sso平台进行验证

#### version：v-1.1.0.4

##### Added:

- 对所有的增删改api添加日志记录，该记录整合了logging项目，将日志记录到容器指定的文件中
- 同步serviceInfo中的图片，将图片下载到本地，替换serviceInfo中的imgUrl为本地的url
- get pricing添加appBuy的client Token认证
- 除get /datacenter这个接口外，其他所有接口增加查询参数：validateDc,使用该参数来判断需要到哪个sso平台进行验证


### version：v-1.1.0.3
##### Updated:

- 在返回的 serviceInfo中添加了serviceDetail
- 修改了无法更新最低价的问题

### version：v-1.1.0.1

##### updated：

-  在service返回的信息中添加了serviceInfo的信息
- 修改servicelowestprice，添加所有plan的最低价以及最低价对应的plan规格。返回的信息中最外层的planName显示的就是当前service最低价对应的plan

##### Fixed：

- 添加price时，未对datacentercode做判断，导致datacenterCode输入为空，price添加成功，添加plan时，datacentercode输入为default，添加plan失败，提示datacenter code not exist
- get lowprice，返回结果为空
- 修改service信息，datacentercode返回为null;但get service信息时，datacentercode返回为default
- 获取service时，datacentercode为sa或hz，datacentercode为default类型的servicedatacentercode返回为空，且serviceplan也为空


### version：v-1.0.0.9
##### Updated：
- service中不存储datacenterCode和plan，这两个字段的内容从该service对应的plan中获取

##### Fixed：

- 调用/service?serviceName=Dashboard获取service信息，未返回serviceProvider字段
- 调用/serviceLowestPrice（POST）计算最低价格时，若该最低价格的plan中包括Basic和Additional，Additional为PAYG类型，pnQuantity为1，此时计算的价格有误，少了一个点
- 当pn对应的price（或serviceplan信息）发生变化时，调用/serviceLowestPrice（POST）不能更新service最低价格
- 不输入datacenterCode，调用/serviceLowestPrice（GET）获取service最低价格，api调用失败，返回datacenterCode is required
- 调用 /service/{id}（PUT）修改datacenterCode或servicePlan信息时，api返回201，实际未修改；建议这种情况返回错误，datacenterCode和servicePlan不能修改
- 调用/pricing/{id}修改datacenterCode信息，api返回201，实际未修改；建议这种情况下，api报错返回datacenterCode不能修改
- Service支持datacenterCode A和B，删除datacenterCode A上的某一个Plan，获取datacenterCode B上的该Service信息，servicePlan中Planname显示不全
- 已删除该pn对应的plan信息，调用/pricing/{id}仍不能删除price信息
- Service删除后，仍可获取到该Service对应的lowPrice，建议Service删除后，也应删除该Service对应的lowPrice
- 删除部分plan信息，再删除Service，此时调用 /servicePlan（GET）获取该service的plan信息，仍可获取到
- 使用client token，调用POST（或PUT或DELETE）类型的api，返回500，internal error
- 当查询通过serviceName和datacenterCode查询serviceInfo时，如果datacenterCode=sa时，查询不到数据，而应该可以查询到datacenterCode=default的数据 。
- 并发测试get  /datacenterCode接口时，出现：driver:bad connection

### version：v-1.0.0.8

#### NewFeature

增加ServiceInfo API，用于同步和获取serviceinfo

- /serviceInfo（GET） 获取当前这个service的服务信息
- /serviceInfo/synchronized（POST） 从marketplace同步服务信息到Listingsystem。说明：从marketplace上同步serviceInfo时，要输入serviceName和pn  

增加ServiceLowestPrice API，用于计算和获取指定服务的最低价格  

- /serviceLowestPrice（GET） 获取指定服务的最低价格。说明：如果只输入serviceName返回这个service在全平台的最低价格，如果输入指定serviceName和datacenterCode，则返回该service在该平台的最低价格
- /serviceLowestPrice（POST） 计算指定服务或者所有服务的最低价格

#### ChangeList
- datacenterCodeUrl由string更改为了json
- service api添加buyType字段
- deployment api添加deploymentType字段
- /datacenter（GET）去掉sso权限
- deployment api返回结果中增加CreateAt和updatedAt字段
- 添加service时不需要添加datacenterCode，当添加plan时，会同步datacenterCode到对应的service上
- 删除和更新某一个service的plan时，也会更新对应的service的datacenterCode
- 更新plan的datacenterCode时，会检查pricingTable中是否存在该datacenterCode对应的pn，如果不存在，则更新失败
- 删除plan之后，如果该plan对应的service不存在任何一个plan，那么这个service也会被删掉
- service、pricing中的datacenterCode不能更改，plan的datacenterCode可以更改
- 删除pricing时，如果该pn在plan表中存在，则要首先删除所有的plan
- 删除datacenterCode之前，要删除掉再pricing表中使用该datacenterCode的所有pricing条目
- 所有get接口整合marketplace的client token

### version：v-1.0.0.7

#### ChangeList

api添加sso权限  

- GET类型：只要是该站点的sso用户，即可访问
- POST、PUT、DELETE：只有该站点sso 的datacenter Admin用户才能访问 
 
添加字段  

- /deployment（POST、PUT、GET）：增加values字段，用于添加、修改、获取Service的values.yaml
- /datacenter（POST、PUT、GET）：增加datacenterUrl字段，用于添加、修改、获取datacenterCode对应的datacenterUrl

修改get service api逻辑（/service）  

 - 如果不传入datacenterCode，则获取所有的service  
 - 如果传入datacenterCode为default，则获取所有datacenterCode为default的service  
 - 如果传入一个其他站点，如ES，则获取datacenterCode为ES及 default的service
#### BugFix：
- /deployment：获取deployment，传入serviceName时，应该获取指定的deployment
- /pricing?pn=xx：获取price信息不用传入datacentercode，只需pn即可

### version：v-1.0.0.6

#### NewFeature

metricPricing：

- 创建metricPricing:  POST      /metricPricing
- 获取metricPricing:  GET       /metricPricing
- 删除metricPricing:  DELETE    /metricPricing/{id}
- 更新metricPricing:  PUT       /metricPricing/{id}

#### ChangeList:

pricing：

- 添加pnListingPrice，pnRegularPrice，pnVipPrice，pnPVipPrice，pnInsourcingPrice字段

deployment：

- 添加：EphemeralStorage
- 删除：Type，catalog，description，DataServiceDependency
- 更新：version->chartVersion，name->serviceName，plan->planName

service：

- 添加：Manager

### version：v-1.0.0.5

#### New Feature

- get deployment by version: /deployment/:name/plan/:plan（GET）
- rollback deployment to laster version： /deployment/:id/rollback（DELETE）

### version：v-1.0.0.4

#### ChangeList

deployment

- 创建deployment:  POST       /deployment
- 获取deployment:  GET        /deployment
- 删除deployment:  DELETE     /deployment/{id}
- 更新deployment:  PUT        /deployment/{id}

#### BugFix

- service plan通过planName和pnProperty唯一标识

### version：v-1.0.0.3

#### ChangeList

- 更改service name为service的唯一标识
- 同一个service的plan中，plan name不能重复
- service中datacenter输出为datacenterCode 以及datacenterName
- 更改pricingTable中productLine为pdl

#### Bug Fix

- 更改datacenter code的字段名字
- 更改查询字段datacenter name无效的情况
- 更改service name 获取plan的问题
- 更改service中datacentercode为数组

### version：v-1.0.0.2

#### New Feature

pricing table

- 创建app pricing item:  POST       /plan/prices
- 获取app pricing table: GET        /plan/prices
- 删除app pricing item:  DELETE     /plan/prices/{id}
- 更新app pricing item:  PUT        /plan/prices/{id}

datacenter

- 创建datacenter code:  POST       /datacenter
- 获取datacenter code:  GET        /datacenter
- 删除datacenter code:  DELETE     /datacenter/{id}
- 更新datacenter code:  PUT        /datacenter/{id}

serviceCategory

- 创建serviceCategory:  POST      /serviceCategory
- 获取serviceCategory:  GET       /serviceCategory
- 删除serviceCategory:  DELETE    /serviceCategory/{id}
- 更新serviceCategory:  PUT       /serviceCategory/{id}

serviceCategory

- 创建service:  POST      /service
- 获取service:  GET         /service
- 删除service:  DELETE   /service/{id}
- 更新service:  PUT         /service/{id}

servicePlan

- 创建servicePlan:  POST      /servicePlan
- 获取servicePlan:  GET         /servicePlan
- 删除servicePlan:  DELETE   /servicePlan/{id}
- 更新servicePlan:  PUT         /servicePlan/{id}

### version：v-1.0.0.1

#### New Feature

base-service plan

- 创建base-service plan:  POST       /plan/base-services
	
	注：service-category:ensaas,iothub,dataservice

- 获取base-service plan:  GET         /plan/base-services?name=&category=&datacenterCode=
- 删除base-service plan:  DELETE   /plan/base-services/{id}
- 更新base-service plan:  PUT         /plan/base-services/{id}

app-service-plan

- 创建app-service plan:  POST       /plan/app-services
	
	注：app-category:app
	
- 获取app-service plan:  GET         /plan/app-services?name=&category=&datacenterCode=
- 删除app-service plan:  DELETE   /plan/app-services/{id}
- 更新app-service plan:  PUT         /plan/app-services/{id}

app-relation

- 创建app relation:  POST       /plan/relations
- 获取app relation:  GET         /plan/relations?appName=
- 删除app relation:  DELETE   /plan/relations/{id}
- 更新app relation:  PUT         /plan/relation/{id}

pricing table

- 创建app pricing item:  POST       /plan/prices
- 获取app pricing table:  GET         /plan/prices?pn=&datacenterCode=
- 删除app pricing item:  DELETE   /plan/prices/{id}
- 更新app pricing item:  PUT         /plan/prices/{id}
