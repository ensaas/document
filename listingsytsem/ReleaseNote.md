## ListingSystem4.0 ReleaseNote

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

