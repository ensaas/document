## API 4.0.29 (2022-5-6)
* The user can add data login and log in through login + password.
* A new parameter systemdisablepasswordpolicy is added to control that password rules are not checked in non-public cloud scenarios
* In order to be compatible with SRP applications, when creating users through the login field, username is consistent with login by default (ensure that username is not empty)
* The user name and login are not allowed to be repeated, nor are they allowed to be repeated with each other (the new login is not equal to any existing login or user name. The 	new user name rules are consistent)
* Regularly delete the operation record (7D) no longer delete the membertype change record of the enterprise account
* On the docker Version (there is no MP and the license is not a public cloud), the subscription number user has the permission to view all clients


## API 4.0.28 (2021-12-31)
* Add enterprise account and user data to partner sinnet cloud.
* Add user real name authentication
* Increase enterprise real name certification
* Add API for the current login person to obtain personal real name authentication and enterprise real name authentication information initiated
* Add a proxy API to forward the API related to the invoice to the sinnet
* Change the pricetype to read from the configuration, and the priority env > config > JSON
* Add API to synchronize enterprise real name authentication results
* API for adding and modifying enterprise member type
* New API supporting proxy work order management 
* Add API for obtaining enterprise number balance
* New API / mail / SRE / contact send mail to SRE
* New configuration email SREs set the SRE array to accept SMS in the environment variable
* New enterprise account management mechanism
* When the system starts, count the enterprise number admin list that needs to send a letter, and inform the enterprise number management mechanism of the change in turn
* Add API / users / {username} / real name auth to query whether others have completed real name authentication
* Add verification code check to API sending notification email to SRE
* Add API / mail / verify / image to obtain verification code

### Fix bugs 
* Modify the operation record. If the operator is the root account, the operator role is empty


## Portal 4.0.29 (2021-8-12)
* Add self-activation function. Automatically disabled users can receive the verification code through email and mobile phone to activate their account.

## API 4.0.25 (2021-8-12)
* Automatically disable the user and change the user status to inactive
* Inactive users are not allowed to log in
* Inactive users support users to accept verification code activation through email and SMS

## API 4.0.24-hotfix2 (2021-7-27)
* Catalog uri append /login

## Portal 4.0.28-(2021-5-13)
### Requirement
* Add the advertisement pop-up window
## API 4.0.24-(2021-5-12)
### Fix bugs
* env adds ldapPartners parameter
## Portal 4.0.27-(2021-5-12)
### Fix bugs
* Determine whether to display the Zhongrong Hospital option in ldap according to the background interface
## Portal 4.0.26-(2021-5-11)
### Fix bugs
* Fix the bug when switching languages
## Portal 4.0.25-(2021-4-29)
### New Features
* Delete subscription account users in batches
* Add LDAP login and LDAP configuration page
* Add the login configuration page
## API 4.0.23 (2021-4-29)
* New integration standard LDAP
* Add the total LDAP API in the new integration platform
* Add LDAP system configuration
* Add update system configuration API
* The disabled SSO account cannot log in using LDAP
* Add API /users/me/marketplace /sync. Synchronize the subscription number and permission data of a user from the marketplace.
* Add a new configuration httprequest.usefasthttp to enable fasthttp to send HTTP requests.

### Fix bugs 
* Modify some bugs
* Due to the nginx characteristic, the IP check in the password locking judgment is cancelled
* Modify mail template
* Failed to modify password old password verification from return 401 to 403
## API 4.0.22 (2021-1-28)
* The new system configuration items are as follows:
	SystemLoginErrorCountConfig ---- Set the total number of login errors of the system, and the default value for the first update is 500
	SystemLoginErrorIntervalConfig ---- Set the interval of system login error statistics, and the default value of initial update is 60 (s) (in an interval, if the number of login errors exceeds the setting of the total number of errors, the logic of sending mail will be triggered)
	SystemLoginErrorReceiverConfig ---- For recipients (arrays) of frequent error messages, the default value of the first update is empty
	SystemPasswordChangeRemindIntervalConfig ---- Prompt the user to modify the password cycle. The default value of the first update is 60 * 60 * 24 * 90 (s), that is, 90 days
	SystemAccountLockErrorCountConfig  ----  The number of times that a user's password is wrong to lock account settings. The default value for the first update is 3
	SystemAccountLockIntervalConfig ---- The length of user account locking. The default value for the first update is 300 (s)
* Add the function of recording the last three passwords of users. (there is no data after the update, only the password is recorded every time the password is changed)
* Add API get /admin/config to get the value configured in 1
* Add API put /admin/config body {"Id": "configuration name in 1", "params": "configuration result"} modify a configuration
* When new users modify their passwords, check whether the last three passwords are repeated.
* When the new user's login password is input incorrectly, the cumulative number of times will be counted. When the threshold value set in 1 is reached, an email will be sent.
* When a new user logs in, if the password has not been changed for a long time (the standard for a long time is set in 1), a prompt will be returned.
* If the new user has not logged in for more than 6 months, it will be automatically disabled.
* If the new subscription number has been created for more than 6 months, and no user has logged in for the last 6 months under the subscription number, and there are no resources, the subscription number will be automatically disabled.
* If the new enterprise number has been created for more than 6 months, and no user has logged in in the last 6 months, and the subscription numbers under it are all disabled, the enterprise number will be automatically disabled
* When modifying the enterprise number to synchronize with the marketplace automatically, the log record is not written into the operation record table, but only printed.
* Export enterprise number to excel list, add status field to return.
* The verification code of user's password can be reused within 10 minutes.
* Modifying the registered client scopes with spaces will result in the problem of generating clienttoken error.
* When adding a subscription number, if limitpoint > 0, a quota change record will be generated by default.
* /v4.0/users/enterprises/subscriptions Only active subscription number is returned by default
* /v4.0/subscriptions/selector Only active subscription number is returned by default
* Add create user, register user, MKP automatically log in to create user's operation record
* Modify the helm chart

## Portal 4.0.24-(2021-1-28)
### New Features
* Add subscription users in bulk
### Fix bugs 
* Fix bugs that change the subscription number when the subscription number page is refreshed
* Fix bugs that alert you when switching pages when you fix the license inactive
* Fix bugs that modify your phone without sending a verification code that is incorrectly formatted
* Root users can delete their subscription number permissions on the page where they edit their information
* Fix the bug that appears in the document button in the navigation bar at the top of the registration page
* Fix the bug that changed the page when the subscription number was filtered

## Portal 4.0.23 (2020-12-31)
### Fix bugs 
* Modify bugs when other portals log on using sso

## Portal 4.0.22 (2020-12-31)
### Fix bugs 
* Fix the bug when you log on with the old path

## API 4.0.21 (2020-12-30)
### New Features
* New subscription number disable enable function
* New enterprise number disable enable function
* Add /v4.0/health to view the current status of app, PG and redis
* Add /v4.0/license/info to view the current license information
* Add /v4.0/license/check and recheck the license
* New user registration API
* Add API user batch subscription number


### Fix bugs 
* Modify active info



## Portal 4.0.21 (2020-12-30)
### New Features
* Add the disable functionality to enterprise and subscription
* Add the self-reistration feature for login page

## Portal 4.0.20 (2020-11-30)
### New Features
* Modify the static file caching mechanism

### Fix bugs 
* Fix the bug that the enterprise admin cannot delete other subscription admin when it hosted the subscription

## API 4.0.20 (2020-11-27)
### New Features
* Add subscription number user change operation record
* Add subscription number bill discount to change operation record
* Add the subscription number effective bill discount to change the operation record
* The API is provided to the subscriber to query the above operation records

### Fix bugs 
* The user list of subscription number distinguishes the permissions obtained by returning the enterprise number hosting and the permissions that are actually bound
* When the subscription number is modified, if the limitpoint needs to be changed, the limitpoint cannot be negative
* Modify the bug of the new subscription number admin (when the user does not exist)
* When modifying /users/{username} to return cross permissions, add the judgment of the relevant subscription number of the enterprise number.

## Portal 4.0.19-(2020-11-27)
### New Features
* Increase subscription user change record and subscription discount change record
* The subscription user list is divided into a member list and a hosting member list

## API 4.0.19- (2020-11-11)
### New Features
* In the initial update, all available credit of default subscription  will be changed to - 1 and non default subscription numbers will be changed to 0
* At the initial startup, the membertype of all enterprise numbers whose membertype is internal will be changed to wisread, isinternal to true, and mpdefault will be changed to premiervip
* When starting for the first time, all enterprise numbers will be scanned. If there is no default subscription number under it, it will be created. The ID is the name by default and encrypted with MD5. If it is repeated, it will be changed to UUID

### Fix bugs 
* Modify the problem of error judgment of notification return status when sending a message
* The problem of inaccuracy of decimal places when modifying and querying the remaining quota (involving all APIs that return the remaining points)
* Modify registration letter and reset password letter to add data center information
* Modify non default subscription number, limit cannot be set to - 1 (new and modify)
* Modifying the sorting problem of surplus quota
* Modify the fifth point. For the initial start-up, the default subscription number is - 1, and the non default subscription number is guaranteed to be 0
* The detail API of the subscription number is added to verify whether the result returned by the marketplace is valid, not only judging the success from the status code.

## Portal 4.0.18-(2020-11-11)
### New Features
* The unlimited available credit of the sub-subscription is adjusted to 0. If you need to adjust, please go to [Subscription Number] [Edit] [Current Available Scale] to adjust
* The subscription hosting notification received by the enterprise administrator is presented in the form of a table in the pop-up window after login

## Portal 4.0.17-(2020-11-5)
### New Features
* The subscription available credit change record form shows the details and balance

## Portal 4.0.16-(2020-11-4)
### New Features
* The enterprise account no longer has the subscription admin permission by default when creating a subscription
* The enterprise admin can apply for a managed subscription to gain access to applications under the subscription
* The subscription admin can apply to be hosted, so that the enterprise admin has access to applications under the subscription
* After the user logs in, if a escrow request is received, a pop-up prompt will guide him to the subscription page for processing
* The lite version removes functions related to enterprise

## API 4.0.18.0- (2020-10-23)
### New Features
* Integrate license
* Add API /subscriptions/:notifyid/hosting-request/never-notify, and set the current message to no longer remind.
* Add API /subscriptions/:subscriptionid/hosting-request. Get the subscription number notify according to the subscription ID
* Adjust the mechanism of subscription number notification to realize the new two landlord mechanism.
* Adjust the API /subscriptions/hosting-requests to return only the total number of reminders to return the details of each reminder.
* Adjust the parameter fields returned by API /subscriptions/:subscriptionid/detail

## API 4.0.17.0- (2020-09-30)
### New Features
* 添加 billRateUnit KRW

## API 4.0.16.0- (2020-09-29)
### New Features
* Add subscription number configuration item, share membership, visit expense center, consumption cooperation, whether it is hosted by enterprise number, and exchange rate of expense bill
* Whether the enterprise number admin has the permission of subscription number admin by default depends on whether the subscription number is enabled and managed by the enterprise number (currently, it is mainly reflected in the API of user token /users/me)
* Whether the attribute is managed by enterprise number can be changed only when subscription number admin and enterprise number admin pass at the same time
* Creating an enterprise account will create a subscription number with the same name and crmid by default
* Integrating ECM
* Record the change of subscription number, quota limit, used and whether it is managed by the enterprise number, and provide API /subscriptions/records to query

### Fix bugs 
* The modification is to parse the apibody returned by notification, not only to judge the returned status code

## Portal 4.0.15.0-(2020-9-15)
### New Features
* The memberType of the enterprise is used by default when creating a subscription

## Portal 4.0.14.0-(2020-8-31)
### Fix bugs
* Modify the description of each service in the top navigation bar

## Portal 4.0.13.0-(2020-8-28)
### New Features
* The head navigation bar uses public components
### Fix bugs
* For other items, when you click forgot password to access the forgot password page of sso, you will be redirected to the login page of sso

## API 4.0.15.0- (2020-08-21)
### New Features
* New mobile phone number binding, through the mobile phone number reset password and other functions, respectively corresponding to 2, 3, 4 API
* Add API / users / mobile phone / {mobilephone} / binding code, and send verification code for binding mobile phone number
* Add API / users / mobile phone / {mobilephone} / binding, bind or replace the bound mobile phone
* Add API / users / {mobilephone} / pwdresetsms, and send the verification code of forgotten password to the corresponding mobile phone number
* New configuration item 1 Sms.Enabled (whether SMS sending function is enabled), ② Sms.LimitCount (the number of times that the same account can send the binding verification code in a certain period of time) Sms.LimitTime (time period in 2, in bits and seconds)
* Add API delete / auth / native to log off token, modify API delete / auth, and log off token after logging out
* Modify /params add return Sms.Enabled
* The enterprise account admin can modify the subscription number membertype
* The default subscription number does not allow editing information
* The membertype of the default subscription number (that is, the subscription number whose name is equal to the enterprise account ID) will always be consistent with the enterprise account, regardless of modifying the membertype of the enterprise account or calling detail to refresh

## Portal 4.0.12.0-(2020-8-21)
### New Features
* The mobile phone number can be bound in the personal homepage
* If you forget your password at the login location, you can choose to use your mobile phone number or email to receive the verification code

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


