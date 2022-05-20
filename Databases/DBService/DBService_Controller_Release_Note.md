# DBService Controller Release Notes

### 1.0.0.2 (2022-05-19)

- 配合1.22版k8s升級package: 
    - sigs.k8s.io/controller-runtime => v0.11.0
    - k8s.io/* => v0.23.2
    - github.com/go-logr/logr => v1.2.0
    - github.com/open-policy-agent/cert-controller => v0.3.0
- 修正升級package後產生的問題

### 1.0.0.1 (2021-09-23)

- Requirement #20888: 增加dbRestore自動刪除功能
- Requirement #22758: 添加type為pvc的dbStorageConfiguration

### 1.0.0/1.0.0-rc10 (16072021)

- Bug #21119: dbschedule 相同時間執行了2次備份
- Bug #21120: 建立錯誤的資源參數值dbservice resource，controller持續crash
- Requirement #20133: 執行備份/還原時，可以用svc路徑,host執行 (Extend Bug #20096)

### 1.0.0-rc9 (12072021)
- #20801 啟用備份排程時，不應該馬上進行一次備份
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20801
- #21084 dbbackup, dbrestore, dbSchedule增加podResource區塊
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/21084
- #20133: 執行備份/還原時，轉換svc路徑為IP (Extend Bug #20096)
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20133

### 1.0.0-rc8 (22062021)
- 在備份過程中disable dbSchedule所建立的dbBackup，紀錄和檔案沒有在超過過期時間後自動刪除
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20677

- expiration day calculation will be based on completion time
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20305

- 新增storage時，應阻擋使用只有讀取權限的NFS
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20167

- add email notification
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20537

- parse svc to ip
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20133

- Update dbbackup-tool to v 0.0.8.8
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/20518

- Update dbbackup-tool to v 0.0.9
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/49


### 1.0.0-rc7 (01062021)
- Update dbbackup-tool to v0.0.8.5
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/41

- add more condition to reject dbrestore request
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/40

- add webhook validator for dbstorageconfigurations
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/39

- Update dbbackup-tool to v0.0.8.4
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/38

- validators add username and password for influxdb checks
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/37

- change Pod Phase Unknown to Failed
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/36

- controller should pass env RESTORE_NAME with value from dbRestore newDatabaseName
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/35

- dbStorage should block delete request when in use
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/33


### 1.0.0-rc6
- dbrestore updates status to Unknown when dbbackup is not found during restore process
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/25

- dbRestore's validator check database name before restore
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/28

- remove force 'from' mongodb database info
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/30

- rpcPort should be string
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/24

- dbrestore should update to unknown when dbbackup is gone during restore process
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/25

- Update dbbackup-tool version to 0.0.8.3
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/32

### 1.0.0-rc5 (23042021)
- Fix dbrestore stuck when dbbackup is not found
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/merge_requests/44/diffs?commit_id=550e42cb8a4cb8fe308dd2fe8938dbe471ece97d
- Fix dbschedule not updating status, instead release multiple dbbackup
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/merge_requests/44/diffs?commit_id=f270724884096c99819e702af5387dfe386cf4c6
- Fix dbschedule cannot update status due to backupType empty by removing field backupType in status  + set default value to dbbackup backupType
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/merge_requests/44/diffs?commit_id=a6daee3c63fd26e295c4a22edbeb6afb21b62d78
- Fix delete job without seeing namespace
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/merge_requests/44/diffs?commit_id=6b597ee623212e17a3a799115d5745b7aa3f4c9b
    
### 1.0.0-rc4 (19042021)
- Add auto delete when expire
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/18287
- validator requires to validate database connection
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/18335
- Backup tool v0.0.8 requires additonal env PARAMS_RPCPORT to be separated with PARAMS_PORT
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/18316
- BackupType has wrong meaning
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/16
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19076
- Multiple dbschedule job when sets enable then disable while status is running
    http://aclredmine.advantech.com.tw/redmines/EI-PaaS/issues/19043
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/21
- Add key replicaset for mongodb databaseInfo
    https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/merge_requests/42/diffs?commit_id=55c7a28e006cb615aeeec2615a042c21c93a82fa

1/25/2021
- remove region from dbstorageconfiguration
- change cmd args 'debugLogs' to 'debug-logs' 
- update README
- change yaml sample 'database' to 'dbAuthentication'

1/13/2021
- change annotation dbservice.ensaas.io into app.kubernetes.io/managed-by
https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/4
- refactor all reconcilers
- use api. instead of v1alpha1.
- remove webhooks on /api/v1alpha1
- remove enable-webhooks since only allow use of CRD with webhooks
- cleanup /cmd/manager
- cleanup internal/manifest/manifest.go
- cleanup internal/reconcilers/object.go
- cleanup internal/reconcilers/setup.go

1/11/2021
- Orphaned object should not go to reconcile (https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/3)
- CRD will not responsible for deletion when object is expired (https://gitlab.wise-paas.com/WISE-PaaS-4.0-Ops/dbservice/-/issues/2)


1/7/2021
1. Refactor DbBackup
2. Change 'Expires' to 'ExpiryDays'
3. Put .status.ExpirationTime 
4. Add secret into kustomize config files  
5. Update DbBackup printcolumn
6. Update DbSchedule printcolumn
7. Add random sleep on dbbackup retry get to avoid conflict
8. Add retryGetDbBackup into DbSchedule for ReleaseDbBackup function
9. Change DbBackup metadata.name into from timestamped to uuid on DbSchedule


12/31/2020
1. add verifyPodPhase before release dbbackup
2. fix nil value on lastbackupTime when suspend: true

12/25/2020
-DEMO-
TODO:
1. remove label from dbbackup

12/16/2020
-DEMO-
progress:
1. change label key value
2. remove 'Envs' on both dbschedule and dbbackup
3. Remove pointInTime on dbschedule
4. BackupType is set to 'Unknown' because yet to know how to judge this value.
5. Refactor 'Database' struct
6. Change args to env for input related to manifest image
7. Refactor 'manifest.DB'
8. Remove NewServerCheck
9. remove 'hasLabel' check  on both dbschedule and dbbackup. dbservice can have their own label.

issue:
1. sometimes dbbackup create 2 jobs (*need to test)
2. reconcile for every second

note:

12/15/2020

progress:
1. simplify condition.affecteddatabase 
2. refactor storageType on dbstorageconfiguration

issue:
1. sometimes dbbackup create 2 jobs (*need to test)
2. reconcile for every second

note:


12/14/2020

progress:
1. integrate dbStorageConfiguration into dbBackup and dbschedule
2. Reformat env into key-value yaml

issue:
1. sometimes dbbackup create 2 jobs *need to test

note:
1. next, integrate dbbackup and dbschedule to call dbStorageConfiguration for storage information (done)

12/10/2020

progress:
1. add dbStorageConfiguration api and controller
2. add test file for /internal/servers/
3. add GetVersion() for mongodb, postgres, and influxdb
4. function tested on mgo v4.4.2, pg 11.10, and influxd 1.8.3 using ROOT account
5. add handler for hanging connection issue on postgresql 

issue:
1. sometimes dbbackup create 2 jobs

note:
1. next, integrate dbbackup and dbschedule to call dbStorageConfiguration for storage information


12/07/2020

progress:
1. integrate cronjob into DbBackup
2. DbBackup containerState set to pointer, therefore can be empty

issue:
1. no intensive test yet

note:


12/04/2020

progress:
1. integrate job into DbBackup
2. add containerState filed into DbBackup status
3. reconcile works fine
4. finalizer works fine

issue:
1. no intensive test yet

note:
1. cronjob integration is WIP


11/18/2020

progress:
1. create initial framework 
2. update apiextension to v1 (deprecated in 1.16)
3. update clientset
4. add webhook validator

issue:
1. unfix format of API
2. clientset returns error 'panic: the server could not find the requested resource'
3. webhook validator has rbac/SA issue

note:
1. check whether existing clientset requires additional addScheme (because i didnt see it under kubebuilder based)
