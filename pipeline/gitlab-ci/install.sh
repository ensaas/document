kubectl apply -f https://github.com/tektoncd/pipeline/releases/download/v0.10.1/release.yaml
kubectl apply -f https://github.com/tektoncd/dashboard/releases/download/v0.5.2/tekton-dashboard-release.yaml
kubectl apply -f https://github.com/tektoncd/triggers/releases/download/v0.3.1/release.yaml

kubectl create clusterrolebinding tekton-pipeline --clusterrole=cluster-admin --serviceaccount=tekton-pipelines:tekton-pipeline --namespace=tekton-pipelines
