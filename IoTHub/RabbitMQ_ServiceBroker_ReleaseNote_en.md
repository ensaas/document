# Version: 2.0.3.4
Bug Fixes
- Provision mu user role parameter wrong

# Version: 2.0.3.3
Enhancements
- remove Apollo
- enhance credential information for DCCS 4.0
- provision - hardcode admin add to vhost

# Version: 2.0.3.2
Enhancements
- Add mqtt websocket, dockerfile

# Version: 2.0.3.1
Enhancements
- update maven dependence
- Apollo configuration integration
- Password encryption
- Add mqtt websocket (15677) information to credentials


# Version: 1.0.16_3
Bug Fixes
- Update RabbitMQAdminService.java
- Fix topic permission

# Version: 1.0.15_3
Bug Fixes
- Fix topic permission

# Version: 1.0.15.topic
Bug Fixes
- Fix topic permission

# Version: 2.0.2
Bug Fixes
- Fix 6161 side effect, parameters initial
- Fix 6161 side effect, parameter need to initial

# Version: 1.0.15.topic.2
Bug Fixes
- Fix 6161 side effect, parameters initial
- Fix topic permission

# Version: 2.0.1
Enhancements
- remove Dedicated plan

Bug Fixes
- Fix 6161 - http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/6161
- Fix 4597, delete mu-{service_instance_guid} user when delete service (deprovision) - http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/4597
- Fix topic permission

# Version: 2.0.0
Enhancements
- MG sync by message queue
- Using message queue to sync create service-key event

Bug Fixes

Known issue
- App綁定取得的Credential中, dashboard與http_api_uri連線不可用(沒有 Management權限)
- 向MG發送的註冊與反註冊訊息內容格式不正確(缺少service_name訊息)
- 刪除ServiceInstance時, 登入Portal的管理用戶未跟著刪除

# Version: 1.0.17
Enhancements
Bug Fixes
- fix metering unmapping service name
- fix coap given ssl

# Version: 1.0.16
Enhancements
- Provide CoapPubSub plan for NB-IoT support
- Ignore the exists check when deprovision, unbind or delete service key.

Bug Fixes

# Version: 1.0.15
Enhancements
Bug Fixes
- Fix if protocolMap no amqp attribute

# Version: 1.0.14
Enhancements
Bug Fixes
- fix metering mapping service name

# Version: 1.0.13
Enhancements
- Add marketplace description-

Bug Fixes
- fix dashboard url port issue

# Version: 1.0.12
Enhancements
- Add policy for RabbitMQ 3.7
- queue TTL
- queue auto-expires
- max-connections
- max-queues

Bug Fixes

# Version: 1.0.11
Enhancements
- credential add host(hosts) and uri(ruis) information 

Bug Fixes

# Version: 1.0.10
Enhancements
- support RabbitMQ 3.7 topic permission setting

Bug Fixes

# Version: 1.0.9
Enhancements
- Add dashboard information

Bug Fixes

# Version: 1.0.8
Enhancements
- support cf update-service for modify vhost policy

Bug Fixes

# Version: 1.0.7
Enhancements
- Capture Pivotal Service Broker PlanID for update service

Bug Fixes

# Version: 1.0.6
Enhancements
- Support Dedicated Plan

Bug Fixes

# Version: 1.0.5
Enhancements
- Support NB-IoT Shared Plan

Bug Fixes

# Version: 1.0.4
Enhancements
- Support user permission and topic update

Bug Fixes

# Version: 1.0.3
Enhancements
- Support provision pass vhost policy parameter

Bug Fixes
