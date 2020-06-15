## ReleaseNote
### version：2.0.0.7
#### Fixed：
- 修改订阅时对db、mp instanceName的校验逻辑
- 修正在各时区中endedAt时间错误的问题
#### Added：
- 新增补录数据接口  POST  /serviceInstanceOnlyForData 。支持mpbuy，servicehub和appbuy的clientToken调用
