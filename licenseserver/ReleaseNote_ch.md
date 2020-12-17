## License Server v-1.1.0.31-(2020-12-17)
### Fixed
- 更改swagger 不显示问题

## License Server v-1.1.0.29-(2020-12-08)
### Added
- 添加环境变量Swagger，显示不同的apidoc

## License Server v-1.1.0.28-(2020-12-07)
### Added
- 所有post api添加sso权限，可用用户为ssoRole为globalAdmin和deploy的client token的用户
### Fixed
- 修复调用 Get  api/ensaasService/{serviceName}/licenseId/{licenseId}会为非ensaas生成两条license的问题
- 修复从catalog订阅后出现serviceCategory为空的情况
### Updated
- Get /api/partNum/licenseQty 和 api/serviceName/{serviceName}/serviceInstanceId/{licenseInstanceId}不再返回ensaas service的license

## License Server 1.0.0.5-(2020-05-12)
### New Features
* 新增 获取license接口返回值中增加subscriptionType和company字段，返回该订阅号类型信息（包含试用和付费）及公司信息，去除isTrial字段。

## License Server 1.0.0.4-(2020-04-28)
### New Features
* 新增 获取license接口返回值中增加isTrial字段，返回该订阅号是否试用的信息。

## License Server 1.0.0.2-(2020-03-20)
### Bug Fixes
* 修复 退订后再部署时，出现license失效的问题，增加判断catalog消息中的licensestatus(目前有两种状态：uncompleted和completed),只处理licensestatus为uncompleted

## License Server 0.0.2.1-(2020-02-24)
### New Features
* 新增 接口可根据serviceName和serviceInstanceId获取license信息


## License Server 0.0.1.3-(2020-01-19)
### New Features
* 新增 获取license接口返回值中增加subscriptionId、datacenterCode，提供订阅号和站点信息。
