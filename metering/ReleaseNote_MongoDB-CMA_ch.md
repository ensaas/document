

## Mongo cma 1.0.1(2020-06-23) 

### Fixed Bugs: 

* 调整mongo连线方式为mongo-driver，修正限制mongodb ha数据库权限失败，日志显示not master的问题 



## Mongo cma 1.0.0(2020-06-18)

### New Features

 * 将mongo cma中的接口重新定义实现
 * 跟mongo sm共用数据库，支持限制多台mongodb
 * 记录使用者数据库权限限制咨询到数据库
 * 设定权限限制失败后API重试次数与重试的间隔时间
 * 支持不对MongoDB预设数据库进行限制




