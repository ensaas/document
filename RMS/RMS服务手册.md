# RMS服务手册

## 什么是RMS

RMS（全称 RealTime Monitor Service）实时监控服务是一款基于prometheus的稳定，高效，灵活的监控告警系统，包含监控和告警服务，提供多维度的监控和告警，多层级涵盖了cluster（集群），node（节点），workspace（工作空间），namespace（命名空间），pod（容器组），workload（工作负载），container（容器）的层级，及多服务db，iothub，apim等服务的监控及报警，搭配Dashboard提供丰富的监控面板组成监控中心，能帮助您高效的进行运维管理。

## 如何查看监控面板

当您订阅了RMS服务后，可在管理页面中点击MonitorCenter，进入管理中心即可看到监控面板。

监控面板列表：

| 面板名称           | 面板说明                                                     |
| ------------------ | ------------------------------------------------------------ |
| physics-resources  | 显示集群的物理资源使用情况                                   |
| node               | 显示node节点的物理资源使用情况                               |
| workspace          | 显示按照workspace/namespace级别统计的监控指标                |
| pod                | 显示pod和container层级的资源使用情况，包括cpu，memory和network |
| workload           | 显示按照workload分类的监控指标，workload包括Deployment，StatefulSet，DaemonSet等 |
| persistent-volumes | 显示PV，PVC相关的资源使用情况                                |

以上是订购集群后默认可看到的面板，后续还可根据你订阅的其他服务（如DB，APIM等），接入服务对应的面板。

面板会持续更新，请以实际显示为准。

## 如何接收监控告警

目前支持微信和email接收告警，后续会增加更多的告警方式。

### 如何使用微信接收监控告警

微信接收监控告警是基于企业微信来发送的，需要您先加入我们的企业微信号。

若您已经订阅RMS服务，需要开通微信接收告警功能，可提工单给我们申请。

### 如何使用email接收监控告警

开通邮件接收告警功能，可通过工单系统给我们提工单进行申请。



## 附录

以下监控项和告警项会持续更新

###  监控项说明

1. physics-resources面板监控项说明

    | 监控项名称             | 监控项说明                                            |
    | ---------------------- | ----------------------------------------------------- |
    | CPU usage（5m avg）    | 集群CPU使用率（5分钟平均）                            |
    | Memory usage（RSS）    | 集群内存使用率，RSS 是常驻内存集（Resident Set Size） |
    | Filesystem usage       | 集群文件系统使用率                                    |
    | Pod usage              | 集群容器组使用率                                      |
    | Network Utilisation    | 集群网络用量                                          |
    | Disk Inode Utilisation | 集群磁盘Inode用量                                     |
    | Disk IOPS              | 集群磁盘IO操作数用量                                  |
    | Disk Throughput        | 集群磁盘每秒读/写数据量                               |

2. node面板监控项说明

    | 监控项名称          | 监控项说明                                           |
    | ------------------- | ---------------------------------------------------- |
    | Pod Usage           | 节点容器组用量                                       |
    | CPU Usage           | 节点CPU使用率                                        |
    | Memory Usage        | 节点内存使用率                                       |
    | FileSystem Usage    | 节点文件系统用量                                     |
    | System load         | 节点CPU平均负载（1分钟，5分钟，15分钟，物理CPU核数） |
    | Usage Per Core      | 节点每个CPU核的使用率                                |
    | Network Utilisation | 节点网络流量（包括上行和下行）                       |
    | Inodes Utilisation  | 节点磁盘Inodes用量                                   |
    | Disk R/W Throughput | 节点磁盘读/写数据量                                  |
    | Disk R/W iops       | 节点磁盘读/写操作数                                  |

    > 内存说明：
    >
    > 1. memory used：包括缓存
    > 2. memory used（wo cache）：不包括缓存（buffer，cache）
    > 3. memory buffers： 缓存
    > 4. memory cache： 缓存
    > 5. memory free： 剩余可用内存

    > CPU说明：
    > 平均负载：指单位时间内，单位 CPU 运行队列中处于可运行或不可中断状态的平均进程数。如果数值大于 1，表示 CPU 不足以服务进程，有进程在等待。

3. workspace面板监控项说明

    | 监控项名称      | 监控项说明                                              |
    | --------------- | ------------------------------------------------------- |
    | CPU Usage       | 工作空间CPU用量                                         |
    | Memory（RSS）   | 工作空间内存用量，RSS 是常驻内存集（Resident Set Size） |
    | Network         | 工作空间网络用量（包括上行和下行用量）                  |
    | CPU Requests    | 工作空间总的CPU Requests                                |
    | CPU Limits      | 工作空间总的CPU Limits                                  |
    | Memory Requests | 工作空间总的内存 Requests                               |
    | Memory Limits   | 工作空间总的内存 Limits                                 |

4. pod面板监控项说明
    | 监控项名称         | 监控项说明                       |
    | ------------------ | -------------------------------- |
    | CPU Usage          | 容器组CPU用量                    |
    | CPU Requests       | 容器组CPU Requests用量           |
    | CPU Limits         | 容器组CPU Limits用量             |
    | CPU (user)         | 容器组CPU (user)用量             |
    | CPU (system)       | 容器组CPU (system)用量           |
    | Memory Usage       | 容器组内存用量                   |
    | Memory Requests    | 容器组内存Requests用量           |
    | Memory Limits      | 容器组内存Limits用量             |
    | Memory MaxUsage    | 容器组内存最大使用量             |
    | Memory RSS         | 容器组常驻内存集使用量           |
    | Memory  WorkingSet | 容器组WorkingSet内存使用量       |
    | Memory Cache       | 容器组内存缓存使用量             |
    | Network I/O        | 容器组网络用量（包括上行和下行） |


5. workload面板监控项说明

    | 监控项名称          | 监控项说明                                               |
    | ------------------- | -------------------------------------------------------- |
    | CPU                 | 工作负载的CPU用量                                        |
    | Memory(RSS)         | RSS 是常驻内存集（Resident Set Size）                    |
    | Network             | 工作负载的网络用量（包括上行和下行流量）                 |
    | Desired Replicas    | 工作负载的期望副本数                                     |
    | Available Replicas  | 工作负载的可用副本数                                     |
    | Observed Generation | 最近观察到的工作负载可用的版本迭代（仅在镜像升级时更新） |
    | Metadata Generation | 工作负载的元配置数据被修改了多少次（包括配置文件和镜像） |
    | UpTime              | 实例运行时间                                             |

6. persistent-volumes面板监控项说明
    | 监控项名称             | 监控项说明               |
    | ---------------------- | ------------------------ |
    | Volume Used Space      | 外挂磁盘使用的磁盘用量   |
    | Volume Available Space | 外挂磁盘可用的磁盘用量   |
    | Volume Capacity Space  | 外挂磁盘的磁盘总的用量   |
    | Volume Space Usage     | 外挂磁盘的磁盘空间使用率 |
    | Volume inodes Usage    | 外挂磁盘inodes使用率     |

### 告警项说明

目前仅列出告警级别为critical的告警

| 告警项名称                         | 告警项级别 | 告警项说明                                                   |
| ---------------------------------- | ---------- | ------------------------------------------------------------ |
| Watchdog                           | none       | 告警系统的watchdog告警                                       |
| NodeDiskRunningFull                | critical   | node的filesystem可用空间即将用尽                             |
| AlertmanagerDown                   | critical   | AlertManager 从prometheus监控目标中消失                      |
| KubeAPIDown                        | critical   | APIServer从prometheus监控目标中消失                          |
| KubeStateMetricsDown               | critical   | KubeStateMetrics从prometheus监控目标中消失                   |
| KubeletDown                        | critical   | Kubelet从prometheus监控目标中消失                            |
| NodeExporterDown                   | critical   | NodeExporter从prometheus监控目标中消失                       |
| PrometheusOperatorDown             | critical   | PrometheusOperator从prometheus监控目标中消失                 |
| KubeDaemonSetRolloutStuck          | critical   | DaemonSet中有部分Pod部署失败                                 |
| KubeDeploymentGenerationMismatch   | critical   | Deployment部署失败，并且未回滚                               |
| KubeDeploymentReplicasMismatch     | critical   | Deployment 部署与预期的副本数量不匹配                        |
| KubePodCrashLooping                | critical   | Pod频繁重启                                                  |
| KubePodNotReady                    | critical   | Pod处于非就绪状态已超过一小时                                |
| KubeStatefulSetGenerationMismatch  | critical   | StatefulSet generation 不匹配，表明部署失败，并且未回滚      |
| KubeStatefulSetReplicasMismatch    | critical   | StatefulSet 实际副本与预期副本不一致，部署失败               |
| KubeStatefulSetUpdateNotRolledOut  | critical   | StatefulSet 更新状态未回滚                                   |
| KubePersistentVolumeErrors         | critical   | persistent volume 状态为Failed\|Pending                      |
| KubePersistentVolumeFullInFourDays | critical   | persistent volume使用空间将在4天内用尽（根据目前使用情况预测） |
| KubePersistentVolumeUsageCritical  | critical   | persistent volume可用空间小于3%                              |
| KubeAPIErrorsHigh                  | critical   | APIServer 错误码5xx的错误率过高                              |
| KubeAPILatencyHigh                 | critical   | APIServer 90% 延迟时间过高                                   |
| KubeClientCertificateExpiration    | critical   | APIServer的客户端证书将在不到24.0小时内到期                  |
| PrometheusErrorSendingAlerts       | critical   | prometheus发送告警时失败                                     |

