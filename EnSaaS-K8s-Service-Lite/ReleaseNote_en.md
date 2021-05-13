### EnSaaS-K8s-Service Lite v-4.1.7- (2020-05-13)

#### Fixed
 - Fix the bug when switching languages

#### Component
- kubeensaas-lite：v-4.1.4
- clusteragent-lite：v-4.1.5
- mp-ui-lite：v-4.1.7

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.7                       |
| Listingsystem              | 1.8.25        | listingsystem:1.8.0.25                  |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22          |
| DCCS                       | 1.0.11         | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21         | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |
| SSO	                       | 4.0.24	       |ssov3/ssov3:v-4.0.24                      |


### EnSaaS-K8s-Service Lite v-4.1.6- (2020-03-25)

#### Fixed
 - Fixed an issue where the service page was incorrectly displayed when switching subscription
 - Fixed the issue that the cluster display was incorrect when switching subscription
 - Fixed the incorrect display of package list when switching clusters under same subscription
 - Fixed the problem that the cluster information selected on the cluster, ws or ns page would be passed to the Application page
 - Fixed the problem that the cluster list is incorrect when switching between shared and dedicate clusters

#### Updated
- If cluster or ws or ns does not exist, a prompt will be given when entering the page

#### Component
- kubeensaas-lite：v-4.1.4
- clusteragent-lite：v-4.1.5
- mp-ui-lite：v-4.1.6

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.6                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.24                  |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22          |
| DCCS                       | 1.0.11         | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21         | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |
| SSO	                       | 4.0.21	       |ssov3/ssov3:v-4.0.22                      |


### EnSaaS-K8s-Service Lite v-4.1.5- (2020-03-04)

#### Fixed
 - Fixed the invalid day counting problem When the license is invalid
 - Fixed the problem of GPU usage calculation error in namespace and workspace
 - Fixed incorrect injection of request resource

#### Updated
- Modify the style of the page, and move the subscription number drop-down box down to each page
- When a pod is in error status and its restart policy is never, the usage of the pod is not included in the quota statistics

#### Component
- kubeensaas-lite：v-4.1.4
- clusteragent-lite：v-4.1.4
- mp-ui-lite：v-4.1.5

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.33	       | wise-paas-service-broker:0.3.22          |
| DCCS                       | 1.0.11         | dccs:1.1.6.2                             |
| MongoDB Service Manager    | 0.6.0         | mongodb-sm:1.1.6                         |
| PostgreSQL Service Manager | 0.2.9         | wise-paas-service-manager-postgresql:1.0.0 |
| InfluxDB Service Manager   | 0.1.6         | wise-paas-service-manager-influxdb:1.0.2 |
| RabbitMQ Service Manager   | 1.0.21         | rabbitmq-sm:1.0.21                       |
| Redis Service Manager      | 0.0.5         | redis-service-manager:0.0.0.7            |
| Blobstore Service Manager  | 1.0.4         | metering/servicebroker:1.0.5             |


### EnSaaS-K8s-Service Lite v-4.1.4- (2020-02-04)

#### Fixed
 - Problems with service page display
 - Remove serviceaccount.yaml and modify the value of DCCS from deployment file 
 
#### Component
- kubeensaas-lite：v-4.1.3
- clusteragent-lite：v-4.1.3
- mp-ui-lite：v-4.1.4

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |


### EnSaaS-K8s-Service Lite v-4.1.3- (2020-01-25)

#### Fixed
 - The issue of Integrate WISE-PaaS/ESM
 - Environment variables cannot be written to workspace during deployment
 
#### Component
- kubeensaas-lite：v-4.1.3
- clusteragent-lite：v-4.1.3
- mp-ui-lite：v-4.1.3

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |

### EnSaaS-K8s-Service Lite v-4.1.2- (2020-12-30)

#### Added
- Add support for storage class， PV and PVC. Support to view storage class and PV, and support to create PVC

#### Updated
- Application page supports jump to the corresponding resource overview page when click cluster, workspace, and namespace 
- Add selected version when upgrading app
- Update the logic to get the used request quota
- Integrate WISE-PaaS/ESM,support obtain config from WISE-PaaS/ESM

#### Fixed
 - The issue of license
 - Fix some problems with the monitor page, and modify the problem that dashbord address must be with / API in env
 - Modify the problem that limit quota must be configured

#### Component
- kubeensaas-lite：v-4.1.2
- clusteragent-lite：v-4.1.2
- mp-ui-lite：v-4.1.2

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Appbuy api                 | 1.4.9         | appbuy-api:1.4.1.5                       |
| Listingsystem              | 1.8.19        | listingsystem:1.8.0.19                  |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |


### EnSaaS-K8s-Service Lite v-4.1.1- (2020-11-18)
#### Added
- Add support for GPU. Support pod to use GPU resources, At the same time, the usage of GPU will be monitored
- The default workspace quota can be configured. It can be dynamically configured according to the proportion of platform resources
- Support configuration of the namespace that is not constrained by webhook to facilitate cluster upgrade

#### Updated
- Add Web kubectl to application page
- Modify the logic of getting status and instance on the application page
- Optimize Serviceinstance page

#### Fixed
- The number of instances on the application page is incorrect

#### Component
- kubeensaas-lite：v-4.1.1
- clusteragent-lite：v-4.1.1
- mp-ui-lite：v-4.1.1

#### Dependent Service
| Serivce                    | Chart version | image version                            |
| -------------------------- | ------------- | ---------------------------------------- |
| Serivce Hub                | 0.3.27	       | wise-paas-service-broker:0.3.21          |
| DCCS                       | 1.0.4         | dccs:1.1.4.1                             |
| MongoDB Service Manager    | 0.5.1         | mongodb-sm:1.1.3                         |
| PostgreSQL Service Manager | 0.2.7         | wise-paas-service-manager-postgresql:0.2.2 |
| InfluxDB Service Manager   | 0.1.4         | wise-paas-service-manager-influxdb:1.0.1 |
| RabbitMQ Service Manager   | 1.0.5         | rabbitmq-sm:1.0.18                       |
| Redis Service Manager      | 0.0.1         | redis-service-manager:0.0.0.3            |
| Blobstore Service Manager  | 1.0.2         | metering/servicebroker:1.0.0             |


### EnSaaS-K8s-Service Lite v-4.1.0- (2020-11-04)

#### Added
- Merged Service Portal to eks-lite, Supported roles：globalAdmin、subscriptionAdmin和subscriptionUser
- API adds support for job, easy to use for dispatch job
- API adds support for PV and PVC

#### Updated
- Upgrade CRD version from v1beta1 to V1 (v1beta1 will be obsolete after k8s 1.19)
- Modify the group information of CRD resources. The V1 version of CRD does not support groups ending with k8s.io. Modify to edgecloud.ensaas.io
- The logic of metric acquisition is reconstructed, and the API for viewing ns, ws and node resources is added
- Add Applications page
- Cancel the toolbox of application and service pages
- top_navbar add Home button

#### Fixed
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
