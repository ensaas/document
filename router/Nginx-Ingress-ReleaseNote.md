## Nginx-Ingress ReleaseNote

### version：1.36.3
##### Updated:
- 请求告警策略修改为5分钟内4xx和5xx的请求占总请求的比例超过20%
#### Add:
- 增加 NginxIngressDown 告警
- 增加告警描述

### version：1.36.1
#### Add:
- serviceMonitor
- alert:
  1. More than 20% of 5xx requests
  2. More than 20% of 4xx requests
