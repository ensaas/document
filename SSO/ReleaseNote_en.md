## API 4.0.14.0- (2020-08-10)
### New Features
* /users/enterprises/subscriptions   Query enterprise account and cascade subscription number


## Portal 4.0.11.0-(2020-8-4)
### New Features
* Remove the tickets in the header

## Portal 4.0.10.0-(2020-7-29)
### Fix bugs
* Modify the bug that the subscription number of the company account cannot be found when the crmid has special characters

## API 4.0.13.0-(2020-07-24)
### New Features
* Enterprise account related functions
* List export of enterprise account and subscription number
* The role of enterprise account admin can operate the subscription number under the enterprise account by default
* Synchronize all enterprise accounts and their subscription numbers regularly, delete expired operation records regularly, and synchronize subscription number consumption points from billing regularly
* The subscription number quota records and synchronizes from billing regularly. The function is disabled by default
* The operation log function only records the enterprise account number and the record of data changes caused by the execution of scheduled tasks
* Quota must be specified when creating a subscription number
* Change the detail interface of the subscription number, add the return of membertype, ispaid, isinternal, and the return of the remaining quota of the subscription number

## Portal 4.0.9.0-(2020-7-24)
### New Features
* Add enterprise menu and enterpriseAdmin role, each enterprise account can add multiple enterpriseAdmin (created by globalAdmin), and can create multiple subscriptions, enterpriseAdmin has the authority to manage the subscriptions under its enterprise account.
* The subscription page adds the function of filtering by corporate account. The default option is all corporate accounts. When adding a subscription number, you must specify the corporate account, and the selected memberType cannot be higher than the corporate account memberType (PremierVIP > VIP > Regular > WISELead).
* Added global account export function of exporting subscription number and enterprise account excel for globalAdmin, the export result is consistent with the page filtering result. Increase the system setting menu, you can view the details of some key addition, deletion and modification operations.

## API 4.0.12.0-(2020-06-24)
### Fix bugs 
* Modify the wrong page of /subscriptions/{subscriptionid}/users

## Portal 4.0.8.0-(2020-6-24)
### New Features
* A detail button is added to the user page of the subscription number, pointing to the user's basic information page. From here, only the right to view information is entered
* When the user logs in for the first time, the password is incorrect
* Click on the client management list to enter the client user page, only showing users
* Click on a client in the client page to enter the user list of this client, displaying three columns of username clientRole status
* Add myAdvantech account login function
### Fix bugs
* Modify the search bug when the subscription name contains special characters

## API 4.0.11.0-(2020-06-22)
### New Features
* New API /clients/trust supports hosting service registration
### Fix bugs 
* Modify /clients/{ClientID}/users to support client token
* Username crmid subname to blank
* Some permissions of client are judged by the roles returned by MP users / me
* Internal users and Advantech mailbox are not assigned to the subscription number admin
* Remove the existing users under duplicate subscription numbers, and add unique constraints to the subscription number user  role table to restrict only one permission of a user under the same subscription number
* New support for login from SSO portal using myadvantech

## API 4.0.10.0-(2020-06-02)
### New Features
* Add the client corresponding to the order and add the datacenter information in the clienttoken

## Portal 4.0.6.0-(2020-6-5)
### Fix bugs
* Only 100 subscription lists can be obtained on the subscription user page

## API 4.0.9.0-(2020-05-25)
### New Features
* New API /admin/subscriptions admin can specify subscription ID to create subscription number
### Fix bugs 
* SSO role does not change after modifying and deleting the subscription number

## Portal 4.0.5.0-(2020-5-19)
### Fix bugs
* Added CRM ID column in the subscription list
* Remove the resource permission of Profile
* Modify the select box style of editing page
* When adding a subscription permission on the edit page, globalAdmin does not assign a subscription number permission by default, and the subscription role that subAdmin can add by default is user and cannot be modified.

## API 4.0.8.0-(2020-05-12)
### New Features
* MKP create user API add return authcode
* New API /auth/authcode login through authcode
* Add API /subscriptions/info to obtain subscription number information in bulk
### Fix bugs 
* Optimized /users/me API integrated with MP


## API 4.0.7.0-(2020-05-10)
### Fix bugs 
* Adding roles information to token generated by auth API

## API 4.0.6.0-(2020-05-09)
### New Features
* Create user by MKP add set token to cookie
* The admin account can delete any subscription number and user
### Fix bugs 
* Querying role information from MP when getting long token
* Modify the trigger rule for subscription number synchronization


## API 4.0.5.0-(2020-05-07)
### Fix bugs 
* The problem of incorrect synchronization results in some cases when modifying subscription number synchronization
* Modify the format of registration letter

## API 4.0.4.0-(2020-04-28)
### New Features
* New and MP permission split, SSO no longer has the concept of resource permission.
* The new SSO role is changed to global admin, subscriptionadmin, subscriptionuser, srpuser, unassigned.
* Add the SSO role field in the user list to record the user's permissions in SSO.
* During the first update, the data of SSO role will be filled in. The value of SSO role field is the highest of the user's permissions in SSO. The default value of datacenteradmin account is globaladmin. The other accounts take the highest level of each permission as the initial value.
* To ensure compatibility temporarily, SSO /users/me and /srprole API will query MP in real time.
* When creating a new user, you can specify the subscription number and add the user to the subscription number at the same time.
* Add API delete /clients/unsubscribe, and delete the client according to the client location and servicename.
* Add API delete /clients/resources to batch delete clients according to resource information.
* When creating a new user, you can specify the subscription number and add the user to the subscription number at the same time.
* New API /users/username/:userid gets username according to userid. This interface does not have permission requirements.
* New API /users/subscriptions obtains all subscription number information of current user, returns subscription number status, whether to try, etc. For the UI to determine the menu to display.
* New API /admin/users provides global admin to obtain user list, supports subscription number, client and other query modes.
* Add and reopen the verification of appid
* When you add OAuth and integrate myadvantech to log in, as long as the e-mail of Advantech is available, you will not go to marktplace to check whether there is a crmid
* Add API /clients/:ClientID/users get all users under a client



### Fix bugs 
* The authority judgment of client filtering is changed to query the resource authority in real time from MP.
* Try bug modification of subscription number related functions.
* Modify and integrate the problem that the password in the registration letter sent by myadvantech login is incorrect.
* Modify the sending method to 4.0 notification
* Modify apidoc


## Portal 4.0.2.2-(2020-4-9)
### New Features
* CRM ID is required when creating subscription.

## Portal 4.0.2.1-(2020-4-7)
### New Features
* Added trial subscription number menu, providing function of adding, deleting, and modifying trial subscription number, supporting to view billing information of using subscription number, and supporting trial subscription number user management
* Subscription number and trial subscription number support query by company and ID

## API 4.0.3.0-(2020-03-24)
### New Features
* Added api /subscriptions/{idOrCrmId}/accountInfo to get the accountInfo corresponding to the subscription
* Added api /users/me/info to get users information (excluding roles)
* Added api /clients/{clientId}/users/role to obtain the user's permissions for a specific client (similar to the previous srpRole, removed the role-related judgment)
* Added Cancel appId detection

### Fix bugs 
* Issue with refresh token setting cookie in return value
* Modify apidoc

## Portal 4.0.2.0-(2020-3-18)

### Fix bugs
* Remove the button in the navigation bar that is not implemented yet

## API 4.0.2.0-(2020-03-06)
### New Features
* Added subscription admin can create user function
* Added api /users/info to get user information in batches
* Added case-insensitive query for user under subscription

### Fix bugs 
* Modify datacneter admins cannot be deleted from each other
* Modify and marktplace synchronization API, return default if it fails
* Fix appId check when registering client
* Modify oauth client does not allow creation of srpUser
* Modify apidoc

## Portal 4.0.1.0-(2020-3-6)

### New Features
* Change the resource permission control on all pages to call the userme interface of ManagentPortal
* In the subscription management interface, click on the subscription to jump to the subscription user page and select the current subscription number by default.
* datacenter Admin can delete others, but it cannot be deleted between users who are also datacenter Admin
* The subscription Admin of the associated resource can view the resource permission menu, he can add users and assign resource permissions
* When the user selects a resource, if a duplicate resource permission is selected, a prompt is given

### Fix bugs
* On the subscription user page, when filtering the subscription, if the next page number is selected, the page is empty when the subscription with fewer users is selected again
* In the subscription number user field, the subscribers are not queried in real time after clearing the search content

## API 4.0.1-(2020-02-25)
### New Features
* Added support for oauth client mode
* Add get /users/me/info to get data from ManagentPortal in real time
* Added integration of marketplace APIs, synchronization during login, and provides an interface to determine whether changes have occurred
* Modify the subscription id generation rule to ensure that the same crmid can generate the same subscription Id

## Portal 4.0.0-(2020-02-18)

### New Features
* SSO supports single sign-on and forgot password functions
* Subscription: subscription management and subscription member management. Accessible members: datacenterAdmin, subscription members
* Subscription Management: Add, delete, and modify subscription. View subscription information (name, company, member, creation time, ID) and fuzzy filtering of subscription. Accessible members: datacenterAdmin, subscription members
* Subscription users: View, add, and remove members in the subscription, support datacenterAdmin to set subscription permissions for subscription members, and support fuzzy filtering for subscription members. Accessible members: datacenterAdmin, subscription members
* Resource permissions: The user's resource permission management and user addition, deletion, disablement, and information editing, support filtering by resources and roles, and fuzzy filtering of user names. Accessible members: workspaceOwner and above
* User edit: edit the user's basic information and resource permissions. Accessible members: workspaceOwner and above
* Client: Client management. Accessible members: all users
* Client Management: display client list, provide client add, edit, delete functions, support fuzzy filtering of client names. Accessible members: workspaceOwner and above
* Client Create: Basic information is required to create a client. After the creation is successful, a secret key and client ID will be provided. Users without client management rights will only see it once and need to save it properly. Accessible members: all users
* My profile: Show the user's basic information, resource permissions, subscription permissions, and application permissions. Provide personal information editing entry and password modification entry. Accessible members: all users
* Change password: The user changes the new password based on the old password. Accessible members: all users
* Role introduction: The roles of the tenant space role, subscription role, and application role are explained separately. Accessible members: all users

## API 4.0.0-(2020-02-19)
### New Features
* Added support for oauth client mode
* Add subscription related api / subscriptions / *, support adding, deleting, modifying, and checking subscription, and adding, deleting, modifying, and checking users under subscription
* The token supports two modes, long and short, to solve the problem that the token length exceeds the browser limit in v2
* The srp user permission supports the json mode format, which supports complex data structures
* Built-in service client, support to set permissions on sso interface through api

### Fix bugs 
* The subscription is queried based on the name. In case-insensitive case, if there is an uppercase letter in the name, it will not be found
* /patch/users/scopes cannot be deleted when action is remove
* Modify the address of the link in the registration letter
* Increase the log of operation records


