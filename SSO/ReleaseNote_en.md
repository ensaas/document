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


