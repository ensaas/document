# DCCS v-1.1.7.2 (2021-07-21)

## Summary Update

Added:

- SSO, ECM, and Service Hub URLs support include port other than 80  
- DCCS API no longer calls the RabbitMQ Get Version API
- For non-existent DCCS keys, it is no longer necessary to call the service hub to determine whether the DCCS key exists  

# DCCS v-1.1.6.2 (2021-01-13)

## Summary Update

Added:

- Support that get service addresses from ECM
- Support API /healthz for health check

# DCCS v-1.1.5 (2020-09-25)

## Summary Update

Added:

- Support that get configuration from ECM

# DCCS v-1.1.4.1 (2020-05-28)

## Summary Update

Removed:

- Remove the support that use http://api.dccs.ensaas.en.internal/v1 to get dccs key returns the service host with internal IP

# DCCS v-1.1.4 (2020-04-21)

## Summary Update

Added:

- Support that use http://api.dccs.ensaas.en.internal/v1 to get dccs key returns the service host with internal IP

Fixed:

- Fix the log information when create custom DCCS key with wrong service hub url
- Fix the log information when disable/enable/get/delete DCCS key with wrong service hub url

# DCCS v-1.1.3.3 (2020-04-21)

## Summary Update

Fixed:

- Fix the bug that getting dccs key without serviceHost return 500 status code

# DCCS v-1.1.3.2 (2020-04-20)

## Summary Update

Fixed：

- Fix the bug that call the ensaas 3.0 sso url returned 302
- Fix ensaas 3.0 dccs key with wrong service host
- Fix the bug that return 400 status code when creating a dccs key with the same name
- Fix the log information when create dccs key after service instance id is deleted
- Fixed the log information when create DCCS key with wrong service hub url

# DCCS v-1.1.3.1 (2020-04-15)

## Summary Update

Added:

- Support different domain names with different sso url

# DCCS v-1.1.3 (2020-04-10)

## Summary Update

Added: 

- Support different rabbitmq hosts with different domain names
- Add one API to create dccs key with specified name mainly for relocation

Updated:

- update swagger document
- update swagger url to "/public/apidoc"

Fixed:

- fix the bug that the pod restarts when service hub url is wrong

# DCCS v-1.1.2.3 (2020-03-19)

## Summary Update
Updated:

- Maintain automatic reconnection to redis always

Fixed:

- The "serviceHost" of the dccs key is empty when the "internalHosts" of the credentials is empty

- Fix the log information when delete dccs key with null request body
- Cannot get and create dccs key when redis is not connected
- The response times out when delete/enable/disable dccs key
- Pod is restarted after redis disconnects

# DCCS v-1.1.2.2 (2020-03-13)

## Summary Update

Fixed:

- Cannot use cookie to delete/disable/enable dccs key in service console

# DCCS v-1.1.2.1 (2020-03-08)

## Summary Update

Added:

- Support previous request body to create dccs key
- Support that delete previous dccs key by guid
- Support delete/disable/enable the dccs key created by previous request body

# DCCS v-1.1.2 (2020-03-04)

## Summary Update

Added:

- There is no need to enter a 'subscriptionId' to create dccs key

Fixed:

- Return 415 status code when creating dccs key without headers
- Cannot set rabbitmq service parameter when creating dccs key

# DCCS v-1.1.1 (2020-03-03)

## Summary Update

Added:

- Support that connect redis index
- Use "internalHosts" as the "serviceHost" when remote address use internal route

Updated:

- Create dccs key successfully when redis save data fail

Fixed:

- The dccs key was created successfully without entering the "Bearer" in header "Authorization"
- Wrong Log information is returned when the content-type is empty

# DCCS v-1.1.0 (2020-02-25)

## Summary Update

Added:

- Use service hub to create/enable/disable/delete dccs key
- Support swagger document

Removed：

- Remove the environment variables including sso url

# DCCS v-1.0.3 (2019-12-23)

## Summary Update

Added:

- Support sso ensaas4.0

# DCCS v-1.0.2 (2019-10-24)

## Summary Update

Added:

- Support that create dccs key for service postgres and mongodb