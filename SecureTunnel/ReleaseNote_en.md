### SecureTunnel v-1.0.6- (2020-01-29)

#### Added

 - Support white-list function
 
#### Updated

 - Change UI header style
 - Batch mapping optimization

#### Component

- securetunnel：v-1.0.6
- securetunnel-ui：v-1.0.6
- securetunnel-client: v-1.0.5 and above

#### Dependent Service


### SecureTunnel v-1.0.5- (2020-12-30)

#### Added

 - Support Service batch mapping in cluster

#### Component

- securetunnel：v-1.0.5
- securetunnel-ui：v-1.0.5
- securetunnel-client: v-1.0.5

### SecureTunnel v-1.0.3- (2020-12-28)

#### Added

 - Add diagnostic function for tunnels

#### Updated

 - when change the cluster type tunnel, you can use the tool to automatically obtain the intranet address and token
 - The internal address of tunnels, which supports the selection of HTTP and HTTPS through the drop-down box


#### Component

- securetunnel：v-1.0.3
- securetunnel-ui：v-1.0.3




### SecureTunnel v-1.0.2- (2020-12-02)

#### Added

 - When creating cluster type tunnel, add tools and guidelines for getting token
 - Support to get cluster config from UI, add Web kubectl
 - Add the number of tunnels in the client information
 - The Tunnels page adds filtering function, tunnels can be filtered according to the client and tunnel type

#### Updated

 - TCP type tunnel, which supports downloading Certificate and CA through UI
 
#### Component

- securetunnel：v-1.0.2
- securetunnel-ui：v-1.0.2



### SecureTunnel v-1.0.1- (2020-11-12)

#### First Version

- Clients：

  - Clients can be located in a cluster, container, virtual machine, or physical machine used to communicate with the tunnel service side
  - Supports adding and deleting clients
  - Support to view client details
  - Provide deployment files and deployment guidelines to guide users to deploy clients

- Tunnels

  - Tunnels can be used for intranet penetration. The external network can access services built on the intranet anywhere anytime through the domain name provided by tunnels

  - Support Tunnel type : TCP, HTTP and cluster

  - Support to add, delete and edit Tunnel

#### Component

- securetunnel：v-1.0.1
- securetunnel-ui：v-1.0.1
