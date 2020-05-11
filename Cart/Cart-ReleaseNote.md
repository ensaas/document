## Cart ReleaseNote

### version：v-1.0.0.5
#### Added:
- 创建购物车之后，把SSO返回的header信息中去除token等信息，写入到cookie中，user可以免登陆进入catalog

### version：v-1.0.0.4
#### Added:
- cart支持分页查询，默认的page number是1，page size是100

### version：v-1.0.0.3
#### Fixed:
- 修复当一个用户属于多个订阅号时，购物车会创建在第一个订阅号下的bug

### version：v-1.0.0.2
#### Updated:
- AvailablePoints的类型改为decimal
- 修改了创建cart后的返回值，返回值中直接有跳转的url，可以直接使用
- 更新swagger文档
