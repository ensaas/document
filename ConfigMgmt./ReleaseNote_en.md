### Config Mgmt. v-1.0.2- (2021-01-29)

#### Summary Update

#### Added:

- Add global auditor permission
- Check tag name exist before publishing public config and private config
- Add Public-Basic plan
- Add the number of configurations in the application group page. Click on the number of configurations to navigate to the configuration management page
- Add the number of services in the application group page, click the number of services to jump to the service management page

#### Updated:

- Add check the postgres connected status for the API /healthz

- All APIs except the Workload related API works fine when MP crashed

#### Fixed:

  - Fixed the bug that the EnSaaS control plane does not update the service backend instance addresses
  - Fixed  display errors of Chinese pages
  - Fixed the bug that default account calls workload APIs and returns 401

#### Component

- API v-1.1.0.3
- Portal v-1.1.0.3
- ECM agent v-1.1.0.3
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
