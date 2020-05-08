# Nginx-Ingress  :simple_smile:  
:point_right: [NGINX Ingress Controller](https://github.com/kubernetes/ingress-nginx)  

#### helm chart:
:point_right: https://harbor.wise-paas.com/harbor/projects/4/helm-charts/nginx-ingress/versions/1.36.1

## 新部署
1. 修改 values.yaml useComponentLabel 为 true  
```bash
## nginx configuration
## Ref: https://github.com/kubernetes/ingress/blob/master/controllers/nginx/configuration.md
##
controller:
  name: controller
  image:
    repository: harbor.wise-paas.com/ensaas-shared/kubernetes-ingress-controller/nginx-ingress-controller #quay.io/kubernetes-ingress-controller/nginx-ingress-controller
    tag: "0.30.0"
    pullPolicy: IfNotPresent
    # www-data -> uid 101
    runAsUser: 101
    allowPrivilegeEscalation: true

  # This will fix the issue of HPA not being able to read the metrics.
  # Note that if you enable it for existing deployments, it won't work as the labels are immutable.
  # We recommend setting this to true for new deployments.
  useComponentLabel: true

```
```bash
## Default 404 backend
##
defaultBackend:

  ## If false, controller.defaultBackendService must be provided
  ##
  enabled: true

  name: default-backend
  image:
    repository: harbor.wise-paas.com/ensaas-shared/defaultbackend-amd64  #k8s.gcr.io/defaultbackend-amd64
    tag: "1.5"
    pullPolicy: IfNotPresent
    # nobody user -> uid 65534
    runAsUser: 65534
    
  # This will fix the issue of HPA not being able to read the metrics.
  # Note that if you enable it for existing deployments, it won't work as the labels are immutable.
  # We recommend setting this to true for new deployments.
  useComponentLabel: true

```
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
>  需要在每个 datacenter 的 ensaas 集群中导入 Dashboard 面板

:point_right: [Dashboard](https://github.com/kubernetes/ingress-nginx/tree/master/deploy/grafana/dashboards)  
:point_right: [nginx.json](https://github.com/kubernetes/ingress-nginx/blob/master/deploy/grafana/dashboards/nginx.json)  
:point_right: [request-handling-performance.json](https://github.com/kubernetes/ingress-nginx/blob/master/deploy/grafana/dashboards/request-handling-performance.json)

## :exclamation: 注意
> 请确保values.yaml 中job 名为nginx-ingress metrics 的 svc name (`nginx-ingress-controller-metrics`)
```bash
        - alert: NginxIngressDown
          expr: absent(up{job="nginx-ingress-controller-metrics"} == 1)
          for: 1m
          labels:
            severity: critical
          annotations:
            message: Nginx ingress has disappeared from Prometheus target discovery.

```
