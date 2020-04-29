# RMS v1.0.6 - (2020-04-01)
## Summary Update
- fix several chart problems for K8s 1.16+ 
 
## [helmchart]
Bugfix:
  - fix several chart problems for K8s 1.16+

# RMS v1.0.5 - (2020-03-18)
## Summary Update
- prometheus service to modify from LoadBalancer to ClusterIP 
- fix bugs 
- kube-state-metrics image version from 1.6.0 to 1.9.5
 
## [helmchart]
Bugfix:
  - bugfix helmchart upgrade failed when servicemonitor namespace selector is any
  - bugfix helmchart upgrade failed when storage claim have selector
  - bugfix servicemonitor clusteragent-workspace not match hz
Modify:
  - remove image pull image from values.yaml
  - add global.url.host in values.yaml and ingress.yaml to match helm specification
  - prometheus service to modify from LoadBalancer to ClusterIP

## [kube-state-metrics]
Update:
  - image version from 1.6.0 to 1.9.5
