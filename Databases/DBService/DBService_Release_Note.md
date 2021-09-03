# DBService Release Notes

# 1.0.2 (2021-09-03)
- add api-server in package

# 1.0.1 (2021-08-27)
- Update dbbackup-tool version to 1.0.1
- Remove sample parameter podResource

## 1.0.0 (29072021)
- Update dbbackup-tool version to 1.0.0
- Update controller version to 1.0.0
- Update controller default cpu and memory
- Update dafault namespace as "dbservice"

## 1.0.0-rc12 (12072021)
- Update dbbackup-tool version to 0.0.9.3
- Update controller version to 1.0.0-rc9
- Add crd parameter podResource

## 1.0.0-rc11 (23062021)
Change image from gcr.io/kubebuilder/kube-rbac-proxy:v0.5.0 to harbor.arfa.wise-paas.com/frbimo/kube-rbac-proxy:v0.5.0

Update dbbackup-tool version to 0.0.9
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/49

add mail notification
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20537

Add "instanceID" on dbrestore sample

Update README to 1.0.0-rc11

## 1.0.0-rc10 (07062021)
Update dbbackup-tool version to 0.0.8.7
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20465

## 1.0.0-rc9 (02062021)
Update dbbackup-tool version to 0.0.8.6
http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20314

## 1.0.0-rc8 (01062021)
add webhook validator for dbstorageconfiguration
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/merge_requests/21/diffs?commit_id=62108893add1f3c0cd519eaaa88dbc2113a344db

Update dbbackup-tool version to 0.0.8.3
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/issues/8

## 1.0.0-rc7 (10052021)
Update dbbackup-tool version to 0.0.8.3
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/issues/6

remove force under mongodb sample yaml
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/issues/5

add rpcPort to influx restore yaml
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/issues/4

remove 'start' and 'end'from influxdb yaml
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/issues/3


## 1.0.0-rc6
-   Update kustomize to v4.1.1

-   Remove backupType from dbschedule status

## 1.0.0-rc5
-   Add rpcPort as input parameter for influxdb's database info 

-   Add backupType as input parameter for dbbackup and dbschedule

-   Remove enum Unknown from backupType, set Full as default

-   Update controller image tag to 1.0.0-rc4

## 1.0.0-rc4
-   Update dbbackup-database image and resources
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice-package/-/issues/2

-   Update Makefile for undeployment


## 1.0.0-rc3

-   Change container name from backup-influxdb to backup-manager
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/12

-   Dbservice controller pod should have secret since the image is set to private
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/13

-   Remove imagePullSecret from backup-manager's manifest
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/14

-   Update image to "harbor.arfa.wise-paas.com/backup-database/backup-database:0.0.7"
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/merge_requests/38
    

## 1.0.0-rc2

-   DbStorageConfiguration should detect if resource is being deleted
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/11

-   DbStorageConfiguration will keep reconciling when remotePath is wrong
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/10

-   Requirement: Backup tool needs additional envs
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/9

-   DBStorageConfiguration NFS version should follows standard semver
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/7

-   Add logic to delete backup files on nfs server when resource is deleting
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/6

-   Custom namespace name
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/8

-   Update backup-tool version 0.0.6.1
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/7
    
## 1.0.0-rc1

initial release
