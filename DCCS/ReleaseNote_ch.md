# DCCS v-1.1.4 (2020-04-21)

## Summary Update

Added:

- 支持用内部域名http://api.dccs.ensaas.en.internal/v1调用dccs key返回的service host为内部IP

Fixed:

- 修复service hub地址填错创建 custom dccs key的提示信息
- 修复service hub地址填错disable/enable/get/delete dccs key的提示信息

# DCCS v-1.1.3.3 (2020-04-21)

## Summary Update

Fixed:

- 修复get不带service host的dccs key返回500的错误

# DCCS v-1.1.3.2 (2020-04-20)

## Summary Update

Fixed：

- 修复调用ensaas 3.0 sso url返回302的错误
- 修复ensaas 3.0 dccs key返回错误的service host
- 修复创建同名的dccs key返回400的错误
- 修复service instance id删掉之后创建dccs key的提示信息
- 修复service hub地址填错创建dccs key的提示信息

# DCCS v-1.1.3.1 (2020-04-15)

## Summary Update

Added:

- 支持不同的域名连不同的sso地址

# DCCS v-1.1.3 (2020-04-10)

## Summary Update

Added: 

- 支持不同的域名连不同的rabbitmq地址
- 增加一支可以指定dccs key name的API（搬迁仓库使用）

Updated:

- 更新swagger文档
- 修改swagger url为 "/public/apidoc"

Fixed:

- 修复service hub地址填错pod会重启的问题

# DCCS v-1.1.2.3 (2020-03-19)

## Summary Update
Updated:

- redis连接失败自动重连

Fixed:

- "internalHosts"为空，dccs key中的"serviceHost"也为空
- 用null body删除dccs key的时候，修复log信息提示
- redis连接失败，不能拿和创建dccs key
- redis连接失败，调用删除和enable/disable dccs key API响应超时
- redis连接失败，pod重启

# DCCS v-1.1.2.2 (2020-03-13)

## Summary Update

Fixed:

- service console不能使用cookie删除和enable/disable dccs key

# DCCS v-1.1.2.1 (2020-03-08)

## Summary Update

Added:

- 支持以前ensaas 3.0的request body去创建dccs key
- 支持用key guid删除ensaas3.0的dccs key
- 支持删除和enable/disable ensaas3.0的dccs key

# DCCS v-1.1.2 (2020-03-04)

## Summary Update

Added:

- 创建dccs key的body中去掉“subscriptionId”

Fixed:

- 没有headers时API返回值415
- 创建dccs key不能设置rabbitmq的参数

# DCCS v-1.1.1 (2020-03-03)

## Summary Update

Added:

- 支持连接redis index
- 用内部路由访问dccs key时"serviceHost"为内部地址

Updated:

- 当redis连接失败支持创建dccs key

Fixed:

- 当header “Authorization”中没有输入“Bearer”时dccs key创建成功
- header "Content-type"为空时修复错误信息提示

# DCCS v-1.1.0 (2020-02-25)

## Summary Update

Added:

- 用service hub去创建、enable、disable和删除dccs key
- 支持swagger

Removed：

- 移除sso url环境变量

# DCCS v-1.0.3 (2019-12-23)

## Summary Update

Added:

- 支持ensaas4.0 sso 

# DCCS v-1.0.2 (2019-10-24)

## Summary Update

Added:

- 支持创建postgres和mongodb的dccs key