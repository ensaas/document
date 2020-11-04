### EnSaaS-K8s-Service Lite 4.1.0- (2020-11-04)

#### Added:
- add Service instance portal to mplite，Supported roles：globalAdmin、subscriptionAdmin和subscriptionUser
- API adds support for job, easy to use for dispatch job
- API adds support for backup and restore of cluster,workspace and namespace.The storage now supports S3,use though yaml files
- API adds support for LoadBalancer and node port service
- API adds support for PV and PVC

#### Updated：
- Upgrade CRD version from v1beta1 to V1 (v1beta1 will be obsolete after k8s 1.19)
- Modify the group information of CRD resources. The V1 version of CRD does not support groups ending with k8s.io. Modify to edgecloud.ensaas.io
- The logic of metric acquisition is reconstructed, and the API for viewing ns, WS and node resources is added
- Add Applications page
- Cancel the toolbox of application and service pages
- top_navbar add Home button

#### Fixed:
- Cluster agent and kubeensaas will restart after long time running
- Fix the problem that the pod with two containers will go wrong
- Optimize the text description and translation of application/node binding quotas
- Optimize the prompt when the user does not have resource permission
- Modify the problem that the blank box will flash when web kubectl is just opened 
- overview,quota and scale quota page,change the limitsDisk to PVC Disk
- Fix the display problems of scale quota page
- When the permission is workspaceowner, user do not have permission to delete quota in the quota page, set operation button to disable
- In global page,when used is 0,circle text have display problems
- In create user page, not give prompt information to existing users
- Fix add cluster failed
- The style of statistical summary

#### Component
- kubeensaas-lite：v-4.1.0
- clusteragent-lite：v-4.1.0
- mp-ui-lite：v-4.1.0

#### Note:
- After ensaas-k8s-service 4.0.11, the ensaas-k8s-service Lite is split for iotsuite edge scenarios
- Ensaas-k8s-service Lite creates a new chart, and the chart package contains the required services
