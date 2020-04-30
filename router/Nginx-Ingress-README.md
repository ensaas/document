# Nginx-Ingress
[link](https://github.com/kubernetes/ingress-nginx)

## 新部署
1. 修改 values.yaml useComponentLabel 为 true 
  1. controller.useComponentLabel
  2. defaultBackend.useComponentLabel
2. 修改 values.yaml internal loaBalancer
```bash
    annotations:  # [ensaas] 根据不同的平台填写不同的Annotations
    #  service.beta.kubernetes.io/azure-load-balancer-internal: "true"  # azure
    #  service.beta.kubernetes.io/alicloud-loadbalancer-address-type: intranet # ali
    loadBalancerIP: # [ensaas] 需要添加ingress的内部loadBalancer Ip
```
3. helm3 install
```bash
helm install nginx-ingress -f values.yaml .
```
## 更新
1. 修改 values.yaml internal loaBalancer
```bash
    annotations:  # [ensaas] 根据不同的平台填写不同的Annotations
    #  service.beta.kubernetes.io/azure-load-balancer-internal: "true"  # azure
    #  service.beta.kubernetes.io/alicloud-loadbalancer-address-type: intranet # ali
    loadBalancerIP: # [ensaas] 需要添加ingress的内部loadBalancer Ip
```
2. helm3 upgrade
```bash
helm upgrade nginx-ingress -f values.yaml .
```
## 导入 Dashboard 面板
[Dashboard](https://github.com/kubernetes/ingress-nginx/tree/master/deploy/grafana/dashboards)  
[nginx.json](https://github.com/kubernetes/ingress-nginx/blob/master/deploy/grafana/dashboards/nginx.json)  
[request-handling-performance.json](https://github.com/kubernetes/ingress-nginx/blob/master/deploy/grafana/dashboards/request-handling-performance.json)
