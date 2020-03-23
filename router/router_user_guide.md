| **名称**   | **长度**   | **规则**   |
|:----:|:----:|:----:|
| clustername | <= 8字符 | 字母 、数字，不允许其他字符 |
| workspace | <= 8字符 | 字母 、数字，不允许其他字符 |
| namespacename  | <= 16字符 | 字母 + 数字，不允许其他字符 |
| servicename | <= 24字符 | 字母、数字、"-" ，不允许其他字符 |

| 整合共享路由   | 路由规则Internal Domain：<servicename>.<namespacename>.<clustername>.internalExtenal Domain: https://<servicename>-<namespacename>-<clustername>.es.wise-paas.cn注意：<servicename>字符串可包含"-",<namespacename>字符串不能含有“-” |
|----|----|
| 整合专属路由   | 建议Dedicated Cluster 的用户在正式运营场景中使用专属路由服务。EnSaaS 4.0 在Dedicated Cluster APIM上(Kong)，提供了Public IP。专属路由用户自行配置Domain和凭证(可用工具自签)   |
|----|----|


整体流程图：

![图片](https://uploader.shimo.im/f/Lizhk6mucp0f96Mv.png!thumbnail)



1. intetnal domain 查询方式：
```
curl -X GET "https://ensaas-router-master.es.wise-paas.cn/v1/routers/domain?serviceType=shared&networkType=internal" -H "accept: application/json"
```
1. external domain 查询方式：
```
curl -X GET "https://ensaas-router-master.es.wise-paas.cn/v1/routers/domain?serviceType=shared&networkType=external" -H "accept: application/json"
```
1. 通过 internal domain 查询 extenal domain：
```
curl -X GET "https://ensaas-router-master.es.wise-paas.cn/v1/routers/domain/{your internal domain}/external" -H "accept: application/json"
```



