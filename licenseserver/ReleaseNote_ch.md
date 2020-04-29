## License Server 1.0.0.4-(2020-04-28)
### New Features
* 新增 获取license接口返回值中增加isTrial字段，返回该订阅号是否试用的信息。

## License Server 1.0.0.2-(2020-03-20)
### Fix bugs
* 修复 退订后再部署时，出现license失效的问题，增加判断catalog消息中的licensestatus(目前有两种状态：uncompleted和completed),只处理licensestatus为uncompleted

## License Server 0.0.2.1-(2020-02-24)
### New Features
* 新增 接口可根据serviceName和serviceInstanceId获取license信息


## License Server 0.0.1.3-(2020-01-19)
### New Features
* 新增 获取license接口返回值中增加subscriptionId、datacenterCode，提供订阅号和站点信息。
