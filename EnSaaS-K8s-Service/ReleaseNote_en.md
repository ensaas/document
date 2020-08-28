### EnSaaS-K8s-Service 4.0.11- (2020-08-28)

#### [Managment Portal API]- 4.0.11

Added:
- Add workload related APIs, including Deployment, Daemonset, Statefulset, Job, CronJob, etc
- Add workspace-permission related APIs for MPbuy
- Add APIs that can operate the all K8S resources

Fixed:
- When users have permissions of the same namespace in different clusters, the users/me API will only return one of them
- A call to the Workload API returns a 504 error code when the workloads under some namespace is massive
- Fixed the bug that cluster controller is running all the time
- Fixed the bug that kubeensaas service restart irregularly
- Fixed the bug that the state of cluster would not be updated when cluster was added for the first time 

#### [Cluster Agent]- 4.0.9

Added:
- Optimize websocket processing logic
- Support automatic injection of sidecar

Fixed:
- The pods with status "Completed" is not calculated to the Pod quota number
- Fixed the bug that clusterAgent occasionally restarting
- Fixed the bug that the CrobJob resource can't be created when clustaragent is running

#### [Managment Portal UI]- 4.0.11

Added:
- Workload management, including Deployment, Daemonset, Statefulset, Job and CronJob
- Support yaml view and online editing, and support workload scale up & scale down
- Pod management, list the container details of the pod
- Supports show log information of a container
- Add a sort function to the creation time under workload page 

Fixed:
- Workload is not sorted by name
- Memory(Request/Quota) remains unchanged after switching the units
- On Node, Workspace, Namespace page, change "Usage" to "Usage/Quota"
- Add CPU Request/Limit and Memory Request/Limit columns to workspace, namespace page
- Default values of CPU request/limit and memory Request /limit do not display correctly
- On Workspace page,  Cpu_usage/Memory_Usage totalValue shows Unlimited
- Application page switch namespace appears empty



### EnSaaS-K8s-Service 4.0.10- (2020-07-10)

#### [Managment Portal API]- 4.0.10

Added:
- Delete evicted pod periodically
- WorkspaceOwner and above roles can modify label name of the workspace
- Support Rest APIs to create/delete helm package
- Support the dedicated route ingress
- Upgrade clusteragent of one or all slave cluster 

Fixed:
- Subscription user can not download the config file 

#### [Cluster Agent]- 4.0.8

Added:
- Support HelmRelease crd

#### [Managment Portal UI]- 4.0.10

Added:
- Provide toolbox and users can use web Kubectl tool at any time
- Support the page theme selection, currently there are three theme colors for users to choose

Fixed:
- on user edit page, deleting permission continuously will cause blank-page issue 



### EnSaaS-K8s-Service 4.0.9- (2020-06-16)

#### [Managment Portal API]- 4.0.9

Added:
- Use token for authentication
- Support datacenterAdmin role
- Cache the SSO requests, the API performance get more improvement
- Optimize the connection between proxy and kubeensaas
- The subscription permission and rolebinding permission are combined
- Support user search functionality under the user management interface
- Optimize the APIs about permission 

Fixed:
- Fix bug about subscription workspaceOwner and rolebinding workspaceOwnere's combination issue
- Fix bug for permission addition & deletion issue
- Optimize resource permission update issue, get 100 times better performance 

#### [Cluster Agent]- 4.0.7

Added:
- Add proxy functionality
- Kubectl get more rich information about workspace, namespacequota and workspacequota
- Support more clusteragent deployment under one cluser scope  

#### [Managment Portal UI]- 4.0.9

Added:
- Support datacenterAdmin
- Add active time on dedicated cluster and general worksapce page

Fixed:
- Some options on the workspace page could not be sorted correctly
- After clicking secret, the ns-overview page keeps bouncing, unable to display properly, and finally causes the page crash
- On workspace/namespaces overview page, the quota table UI at the bottom shows incomplete
- Click namespace under the WorkSpaces Overview to enter the namespace list, which displays cluster and workspace that are not currently selected by the user
- On Namespace Overview page. When namespace does not limit the number of pods, the total POD amount shows NaN, and the utilization rate shows NaN%
- After modifying user permissions, the resource permissions page is returned. The cluster/workspace selected at the top does not match the user list
- The subscription company name cannot be displayed on the UI when the user has only resource permissions
- The pod number in the namesapce Usage column of namesapce permission is not an integer



### EnSaaS-K8s-Service 4.0.8- (2020-05-21)

#### [Managment Portal API]- 4.0.8

Added:
- Support Web Kubectl

#### [Managment Portal UI]- 4.0.8

Added:
- Support Web Kubectl

Fixed:
- On 'User permission' page, after assign role to user, the 'type' filed is blank
- Workspace search issue
- Sometimes, user cann't see namespace list on namespace page after login
- On monitor page，after worksapce switch，namespace select box disappear



### EnSaaS-K8s-Service 4.0.7- (2020-05-11)

#### [Managment Portal API]- 4.0.7

Added:
- Add route management

Fixed:
- Through token imported clusters, get admin config when config incomplete

#### [Managment Portal UI]- 4.0.7

Added:
- Add route management page
- add node-number show on cluster page
- add type filed under resource management page, to distinguish permission type
- support search functionality for select component

Fixed:
- disable for user information modification



### EnSaaS-K8s-Service 4.0.6- (2020-04-28)

#### [Managment Portal UI]- 4.0.5

#### [Managment Portal API]- 4.0.6

Added:

Mirgrating user management and editing user functionality from SSO, which will no longer provide this feature in the future.
- User management:
    - View user lists
    - Filter users with cluster/workspace/namespace
    - Query users by search bar
    - Add new users
    - Invite users: Assign your own resource permissions to existing users
- Edit users:
    - Edit selected user's basic information (Current user only)
    - Modifying/assigning user resource permissions
- Supporting globalAdmin role from SSO, all previous datacenterAdmin accounts will be promoted to globalAdmin

Note: Operational limitations for resource permission assignments:
- For resource permissions, only roles lower than that of current account can be assigned(e.g. clusterOwner can only be assigned to user workspaceOwner permissions)
- For subscription number permissions, same and lower roles can be assigned
- Existing resource permissions for subscriptions cannot be modified

Fixed:
- Through token imported clusters, get admin config when config incomplete
- Fix bugs where subscription number permissions can be modified



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

