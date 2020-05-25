## Order-API ReleaseNote

### version：v-1.0.0.9
#### Added:
- order实例中添加crmid（该字段从sso获取）
- 添加api： 
   - POST /addCrmid 补全之前order中的crmid，操作权限：globalAdmin
   - GET /checkOrders 获取所有的order，无权限校验，未在swagger中列出
- 在api /orders中添加如下查询条件   
   - crmid：根据公司id获取order （非必填）  
   - subscriptionId：根据订阅号id获取订单 （非必填）  
   - serviceName：根据serviceName获取订单 （非必填）  
   - serviceCategory：根据serviceName获取订单 （非必填）  
   - orderId：根据orderId获取订单 （非必填）  
   - orderStatus：根据orderStatus获取订单 （非必填）  
   - orderType：根据orderType获取订单 （非必填）  
> 注：globalAdmin获取所有订单，其他user只获取当前订阅号是subscriptionAdmin下的order

