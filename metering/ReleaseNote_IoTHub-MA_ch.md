## IoTHub-MA 1.0.4(2020-01-04)

### Bug Fixes
 *  修正通过vhsotName查询rabbitmq servicemanager 中对应的instanceId；并以instanceId作为consumerId；
 *  修正ma量测多组rabbitmq连接信息；


## IoTHub-MA 1.0.2(2020-05-27)

### New Features
 * 若当前获取到的某个vhost的用量记录为null，则记作该vhost的Messages用量为0。

### Bug Fixes
 * 去掉声明在Rabbitmq中被叫做‘usage’的queue。

## IoTHub-MA 1.0.1(2020-04-17)

### Bug Fixes
 * 调整月初第一笔资料送给当前月base料号下。
