## Reporting 0.0.0.17(2020-09-18)
## Bug Fixes
 *  去掉datacenterAdmin认证部分(即去掉从mp获取role部分代码);
 *  与前端查询时的有效token进行存储与redis中，减少访问sso次数；

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
