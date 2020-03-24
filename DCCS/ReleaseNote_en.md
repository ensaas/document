# DCCS 1.1.2.3- (2020-03-19)
## Summary Update
Updated:

- Maintain automatic reconnection to redis always

Fixed:

- The "serviceHost" of the dccs key is empty when the "internalHosts" of the credentials is empty

- Fix the log information when delete dccs key with null request body
- Cannot get and create dccs key when redis is not connected
- The response times out when delete/enable/disable dccs key
- Pod is restarted after redis disconnects

# DCCS 1.1.2.2- (2020-03-13)

## Summary Update

Fixed:

- Cannot use cookie to delete/disable/enable dccs key in service console

# DCCS 1.1.2.1- (2020-03-08)

## Summary Update

Added:

- Support previous request body to create dccs key
- Support that delete previous dccs key by guid
- Support delete/disable/enable the dccs key created by previous request body

# DCCS 1.1.2- (2020-03-04)

## Summary Update

Added:

- There is no need to enter a 'subscriptionId' to create dccs key

Fixed:

- Return 415 status code when creating dccs key without headers
- Cannot set rabbitmq service parameter when creating dccs key

# DCCS 1.1.1- (2020-03-03)

## Summary Update

Added:

- Support that connect redis index
- Use "internalHosts" as the "serviceHost" when remote address use internal route

Updated:

- Create dccs key successfully when redis save data fail

Fixed:

- The dccs key was created successfully without entering the "Bearer" in header "Authorization"
- Wrong Log information is returned when the content-type is empty

# DCCS 1.1.0- (2020-02-25)

## Summary Update

Added:

- Use service hub to create/enable/disable/delete dccs key
- Support swagger document

Removed：

- Remove the environment variables including sso url

# DCCS 1.0.3- (2019-12-23)

## Summary Update

Added:

- Support sso ensaas4.0

# DCCS 1.0.2- (2019-10-24)

## Summary Update

Added:

- Support that create dccs key for service postgres and mongodb