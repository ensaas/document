### EnSaaS-K8s-Service Lite 4.1.1- (2020-11-18)
#### Added:
- Add support for GPU. Support pod to use GPU resources, At the same time, the usage of GPU will be monitored
- The default workspace quota can be configured. It can be dynamically configured according to the proportion of platform resources
- Support configuration of the namespace that is not constrained by webhook to facilitate cluster upgrade

#### Updated：
- Add Web kubectl to application page
- Modify the logic of getting status and instance on the application page
- Optimize Serviceinstance page

#### Fixed:
- The number of instances on the application page is incorrect

#### Component:
- kubeensaas-lite：v-4.1.1
- clusteragent-lite：v-4.1.1
- mp-ui-lite：v-4.1.1

#### Dependent Service:
| Service                    | Version |
| -------------------------- | ------- |
| Serivce Hub                | 0.3.27  |
| Serivce Portal             | 0.1.2   |
| DCCS                       | 1.0.4   |
| MongoDB Service Manager    | 0.5.1   |
| PostgreSQL Service Manager | 0.2.7   |
| InfluxDB Service Manager   | 0.1.4   |
| RabbitMQ Service Manager   | 1.0.5   |
| Redis Service Manager      | 0.0.1   |
| Blobstore Service Manager  | 1.0.2   |


### EnSaaS-K8s-Service Lite 4.1.0- (2020-11-04)

#### Added:
- Merged Service Portal to eks-lite, Supported roles：globalAdmin、subscriptionAdmin和subscriptionUser
- API adds support for job, easy to use for dispatch job
- API adds support for PV and PVC

#### Updated：
- Upgrade CRD version from v1beta1 to V1 (v1beta1 will be obsolete after k8s 1.19)
- Modify the group information of CRD resources. The V1 version of CRD does not support groups ending with k8s.io. Modify to edgecloud.ensaas.io
- The logic of metric acquisition is reconstructed, and the API for viewing ns, ws and node resources is added
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
- In create user page, when user already exis UI does not give prompt information
- Fix add cluster failed
- modify the style of summary

#### Component
- kubeensaas-lite：v-4.1.0
- clusteragent-lite：v-4.1.0
- mp-ui-lite：v-4.1.0

#### Note:
- After ensaas-k8s-service 4.0.11, the ensaas-k8s-service Lite is split for iotsuite edge scenarios
- Ensaas-k8s-service Lite creates a new chart, and the chart package contains the required services
