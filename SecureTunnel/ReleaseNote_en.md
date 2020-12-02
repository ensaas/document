### SecureTunnel 1.0.2- (2020-12-02)

#### Added:

 - When creating cluster type tunnel, add tools and guidelines for getting token
 - Support to get cluster config from UI, add Web kubectl
 - Add the number of tunnels in the client information
 - The Tunnels page adds filtering function, tunnels can be filtered according to the client and tunnel type

#### Updated：

 - TCP type tunnel, which supports downloading Certificate and CA through UI
 
#### Component

- securetunnel：v-1.0.2
- securetunnel-ui：v-1.0.2



### SecureTunnel 1.0.1- (2020-11-12)

#### First Version:

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
