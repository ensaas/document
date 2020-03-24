# Blobstore 1.1.13- (2020-03-19)
## Summary Update

Added:

- Add "internalHosts" and "externalHosts" in credentials
- Support swagger document
- Add environment variables 'resource.requests.ephemeralStorage' and 'resource.limits.ephemeralStorage'

Updated:

- JE data center use minio and storage account
- Update minio to the latest

Fixed:

- Fix bugs about null pointer exceptions

# Blobstore 1.1.12- (2019-12-17)

## Summary Update

Added:

- Support aliyun oss bucket
- Support minio with pvc
- Support that restore the service instance within 30 days

Removed:

- Remove register/unregister metering gateway

# Blobstore 1.1.11- (2019-11-04)

## Summary Update

Fixed:

- Nginx uses too many memory when using the endpoint provided by binding instance 

# Blobstore 1.1.10- (2019-10-31)

## Summary Update

Fixed:

- Fix the error message for invalid parameter 'provider'

# Blobstore 1.1.9- (2019-10-30)

## Summary Update

Added:

- Support to modify the default repository of minio

Updated:

- Wise-PaaS platform can only create one storage account of its area

# Blobstore 1.1.8- (2019-10-15)

## Summary Update

Removed:

- remove the restriction that a domain name can only include one of com or cn

# Blobstore 1.1.7- (2019-10-11)

## Summary Update

Added:

- Support to modify the region of azure storage account using environment variable

Updated:

- The storage account created is the same area with wise-paas platform by default
- Use the original minio image of helm chart because the latest minio image need token to get metric data

# Blobstore 1.1.6- (2019-10-09)

## Summary Update

Fixed:

- Do not catch all exceptions when register/unregister with MG 
- The service instance cannot be bound when creating a service instance that does not require minio

# Blobstore 1.1.5- (2019-10-09)

## Summary Update

Fixed:

- The service_type is wrong when register with MG

# Blobstore 1.1.4- (2019-09-30)

## Summary Update

Added:

- Minio pod supports horizontal auto-scaling

Updated:

- Blob and minio are registered seperately with MG
- Update minio chart and minio server to the latest
- Optimize the parameters of the minio ingress

Fixed:

- Fix bugs reported by DQA

Removed:

- Remove the restriction that one org can only create one service instance with AWS s3 interface

# Blobstore 1.1.3- (2019-08-09)

## Summary Update

Added:

- Support to connect the kubernetes cluster with the intranet
- Support prometheus service monitor for minio
- An org can only create one service instance with AWS s3 interface

Updated:

- Use ASIA_SOUTHEAST storage account instead of ASIA_EAST storage account
- Retry the installation three times when minio installation fails
- Retry to recreate storage account three times when the storage account creation fails

# Blobstore 1.1.2- (2019-07-24)

## Summary Update

Added:

- Support to unregister to MG when delete.sa.flag is false
- Support to register and unregister to MG when backend is openstack
- Support to provide different endpoint credential when different apps binding to one same service instance

Updated:

- Modify the columes of service_instance_binding table
- Regenerate the secret key in deleting service instance when delete.sa.flag is false

Fixed:

- The validation of accesskey and secretkey
- Invalid parameter check

Removed:

- Remove the Shared plan
- Remove the useless columes of service_instance table

# Blobstore 1.1.1- (2019-07-03)

## Summary Update

Added:

- Support to metering the blob
- Support to connect the kuberntes cluster creating by rancher
- Support to share service instance

Updated:

- Modify the  environment variables

# Blobstore 1.1.0- (2019-06-13)

## Summary Update

Added:

- Support to create azure storage account
- Support to create azure china storage account
- Support the existing azure storage account
- Install minio for storage account
- Return dashboard url when create service instance

# Blobstore 1.0.3 (2019-06-11)

## Summary Update

Fixed:

- Fix manifest mem from 512 to 768
- Fix can use url nor IP to create service instances 

# Blobstore 1.0.2 (2018-07-13)

## Summary Update

Fixed:

- Credentials裡的Key值拼字錯誤

# Blobstore 1.0.1 (2018-06-05)

## Summary Update

Updated:

  - Change BlobStore Service Broker plan name Shared to Standard

Fixed:
  - Create Credential fail

# Blobstore 1.0.0 (2018-03-30)

## Summary Update

Added:

- Blobstore phease 2 version
- Add manifest with openstack value

Fixed:

  - Fix encrypt jsonObject error
  - Fix cann't get metering 404 response
  - Fix phease 1 verstion some bug when create-service instances
