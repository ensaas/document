## Reporting 0.0.0.26(2020-12-30)
### New Features
 * 新增查询用户信息的接口，包括/search,/serviceNames
 * 新增支持从服务提供api的方式获取mapping关系；
 * 新增支持mp dedicated cluster mappings关系获取；
 * 调整mapping表结构
 * 新增支持ECM
## Bug Fixes
 * 修复程序若干功能bug
 * 修复程序重启问题
 * 优化性能
 

## Reporting 0.0.0.20(2020-09-23)
### New Features
 * 新增实时用量查询
 * 添加清理缓存功能
 * 使用licenseInstanceId,替换mapping_table中的serviceInstanceId;
## Bug Fixes
 * 修复程序崩溃重启问题


## Reporting 0.0.0.12(2020-06-04)
### New Features

 * 新增数据库表subscription_info（存储subscription信息）定时更新功能

## Bug Fixes

 *  修复从sso分页获取subscription信息的问题；
 *  修复获取指定subscriptionId下的serviceInstanceId用量；
 *  修复查询用量的时间有跨月时，避免数据的时间点不连续;
 *  调整: db migration 版本号变更功能。

## Reporting  0.0.0.9(2020-05-18)

### Bug Fixes
 * 修复http客户端响应信息（report/errors/）；
* 修改从servicehub拿到的结构体(report/models/schedule/）。
