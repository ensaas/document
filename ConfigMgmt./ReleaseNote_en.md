### Config Mgmt. v-1.0.6- (2021-12-09)

#### Summary Update

#### Added:

- The overview page supports process guidance, resource usage,  the recent updates of config and service
- One-click update of service images and sidecar images
- Support configuration import and export through API

#### Component

- API v-1.1.0.7
- Portal v-1.1.0.7
- ECM agent v-1.1.0.7
- iptable v-1.1.0.7
- ensaasdp v-1.1.0.7

### Config Mgmt. v-1.0.5- (2021-03-11)

#### Summary Update

#### Updated:

- Adjust how to get license active information
- Limit the number of times the backend can listen on the same private config

#### Fixed:

  - Fix the bug ECM agent injecting empty datacenter, cluster, workspace, namespace and other environment variables
  - Fix the bug that configuration releases occasionally do not take effect
  - Fix the bug that CPU usage would occasionally reach 100 percent
  - Fix the bug that invalid public configuration listening information was not deleted in time
  - The backend name cannot be an empty string when grayscale is published
  - API returns 403 if the size of config exceeds the app group limit

#### Component

- API v-1.1.0.5
- Portal v-1.1.0.3
- ECM agent v-1.1.0.5
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1

### Config Mgmt. v-1.0.3- (2021-01-29)

#### Summary Update

#### Added:

- Add global auditor permission
- Check tag name exist before publishing public config and private config
- Add Public-Basic plan
- Add the number of configurations in the application group page. Click on the number of configurations to link to the configuration management page
- Add the number of services in the application group page, click the number of services to link to the service management page

#### Updated:

- Add check the postgres connected status for the API /healthz

- All APIs except the Workload related API works fine when MP crashed

#### Fixed:

  - Fix the bug that the EnSaaS control plane does not update the service backend instance addresses
  - Fix display errors of Chinese pages
  - Fix the bug that default account calls workload APIs and returns 401
  - Fix offline backend showing online status

#### Component

- API v-1.1.0.4
- Portal v-1.1.0.3
- ECM agent v-1.1.0.4
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1

### Config Mgmt. v-1.0.1- (2020-12-30)

#### Summary Update

#### Fixed:

  - Fix the bug that ECM agent crashed

#### Component

- API v-1.1.0.1
- Portal v-1.1.0.1
- ECM agent v-1.1.0.2
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1

### Config Mgmt. v-1.0.0- (2020-12-25)

#### Summary Update
#### Added

  - Application Group Management，multiple configurations can be created and services can be registered within each application group
  - Configuration Management，Public configuration and private configuration within the application group, including configuration publishing, configuration real-time push, configuration rollback, historical version management, grayscale publishing, configuration monitoring and query functions
  - Service Management，Including service registration, service deletion, service address exposure, service health check and other functions

  - User Management，There are admin permissions and group Owner permissions. Admin is the highest privilege of Config Mgmt. and group Owner is the privilege of application group, which can be added, deleted, modified and checked

#### Component

- API v-1.1.0.1
- Portal v-1.1.0.1
- ECM agent v-1.1.0.1
- iptable v-1.1.0.1
- ensaasdp v-1.1.0.1
