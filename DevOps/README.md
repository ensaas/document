# DevOps 在 KubeEnSaaS 容器云中的实践
## 安装
### KubeEnSaaS 容器云中安装 Tekton
- 首先需要创建名为"tektonpipelines" 的 namespace
- 使用 cluster-admin 权限的 config 进行部署 
    - `kubectl apply -f DeployTekton/pipeline-ensaas.yaml` 
    - `kubectl apply -f DeployTekton/tekton-dashboard-release-ensaas.yaml`
    - `kubectl apply -f DeployTekton/dashboard-ingress.yaml`
### 原生 K8s 安装 Tekton
- 使用 cluster-admin 权限的 config 进行部署 
    - `kubectl apply -f DeployTekton/pipeline.yaml` 
    - `kubectl apply -f DeployTekton/tekton-dashboard-release.yaml`
    - `kubectl apply -f DeployTekton/dashboard-ingress.yaml`
