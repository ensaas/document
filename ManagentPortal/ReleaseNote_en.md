### EnSaaS-K8s-Service 4.0.5- (2020-04-24)

#### [Cluster Agent]- 4.0.5

Fixed:

- open the authority to change quota of workspace "ensaas" and namespace "logging", "rms", "ensaas-service"
- if the namespace "logging" and "rms" are not exist, agent will startup failed
- datacenterAdmin user can not create namespace



### EnSaaS-K8s-Service 4.0.4- (2020-04-01)

#### [Managment Portal UI]

Added:

- Platform management：
  - Add config view, copy and refresh functions
  - add display API version and cluster agent version in UI
  - add import cluster

Fixed:

- Application page appears blank occasionally
- Enter the monitor page from cluster, workspace and namespace list. The cluster drop-down box on the UI cannot be displayed or refreshed normally
- After entering the monitor page, it will be blank, and kubernetes on the left is not selected
- Switch the subscription number on the workload page and refresh the page. No content show in the UI
- Switch the subscription number on the Application page and refresh the page. the page does not update

#### [Managment Portal API]- 4.0.5

Fixed:

- Fixed the problem of injecting environment variable error

#### [Managment Portal API]- 4.0.4

Added:

- Add API to get version of MP API
- Add API to support upgrading all cluster agents through API

Fixed:

- Private key and public not match problems after rolebinding
- Fixed an asynchronous problem when creating or deleting rollbinding
- Fix the problem that users with clusterowner and above permissions cannot modify workspace
- Fix user with subscription permission can't get user number

#### [Cluster Agent]

Added:

- Add cluster agent version in clusterinfo

Fixed:

- Fixed the permission problem of workspaceowner
- Fix the problem that the update of authority is not timely
- Restrict users from operating ensaas workspace


- Fixed the problem that if there is no PV in a cluster, the clusterinfo has no totaldisk and useddisk



### EnSaaS-K8s-Service 4.0.3- (2020-03-21)

#### [Managment Portal UI]

Added:

- Platform management：
  - Style of subscription drop-down box:add  subscription company，add search function
  - datacenter admin user can add general workspace from UI

Updated:

- Uniform resource list style:both displayed as percentage and progress bar styles
- Change memory style in quota: Memory drop-down box supports 32G at most; for a dedicated cluster, memory can select the value of the drop-down box or allow the user to enter

Fixed:

- The scale namespace quota page will be blank when the quota bound by the namespace is changed
- when user have WS owner and NS developer permissions. The console page have some problems
- Switch the namepsace in Console page,namepspace information not update,UI did not call the corresponding API

- Jump from console page to workspace page, the workspace page will be blank after refreshing
- Occasionally, the add buttons of WS and NS do not display
- Refresh workspace page , the page is blank
- This problem exists in multiple pages: After switching the subscription number and refreshing the page, there is some display problem in the page

### 

### EnSaaS-K8s-Service 4.0.2- (2020-03-10)

#### Summary Update

Added:

- Platform management：
  - Add workload page，user can view the workload of the namespace.
  - Add real-time log of workload pod.

Updated:

- Add categories in the left menu bar to distinguish between the dedicated cluster and shared cluster.

Fixed:

- Fix the issue of viewing resources by subscription.
- application page cannot be displayed.


- when create WS failed, ws record will exist in the database.Bug12493.


- when getting resource of WS return return value  . Bug 12465.
- Fixed the permissions of datacenteradmin under the default subscription.
- The authority of WS owner in clusteragent.
- when input the wrong subscription number,user can still get the the workspace name according to the workspace ID. Bug 12459.
- Optimize API error messages.
- When switching the subscription number on the node page, the node list is not updated in time,  still displays the node information obtained last time.
- From General workspace switch to NS list page and go back to the previous page. The add workspace button will appear.





### EnSaaS-K8s-Service 4.0.0- (2020-02-19)

#### Summary Update

Added:

- Subscription  and user permissions:
  - Add subscription name on the top navigation bar, and support  display resources by the subscription name
  - Users with subscription privileges (subscription admin/user) can see and manipulate the resources purchased by the subscription

- Monitor:
  - Integrate RMS : Provide different levels of monitoring display



Fixed:

- Modify the synchronization method of rolebinding between MP and sso, and add subscription number verification before creating rolebinding.
- Add synchronization mechanism between slave cluster and master cluster to fix the problem that info and metric cannot be updated immediately 
- Fix port error when clusteragent synchronizes resources to master cluster
- In the applications page,  only 20 app can be displayed 
- On the workspace overview page, the limitmemory of the quota is error
- Click console from SSO UI, unable to log in MP automatically
- workspace owner and namespace developer in namespace page. After the cluster is switched through the breadcrumbs, the workspace overview page displays n / A, and cannot resume though refresh
- User with namespace developer permission. when entering the namespace page for the first time or refreshing the page, the workspace drop-down box does not support clicking
- When the namespace developer enters the application page, the workspace drop-down box cannot get the workspace list. and refresh this page, the namespace list is  empty
- In scale namespace quota page, the page display nothing when change the quota of namespace
- Modify page scaling problem
- Fix when the user has multiple permissions, the UI display error.

