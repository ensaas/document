# SCADA

Supervisory control and data acquisition (SCADA) is an automation management system for software and hardware used in IoT applications, specifically for data acquisition, integration, analytics, and visualization technology.

## TL;DR;

```console
$ helm install --name scada harbor/scada --version <scada version>
```

## Introduction

This chart bootstraps a SCADA deployment on a [Kubernetes](http://kubernetes.io) cluster using the [Helm](https://helm.sh) package manager.

## Release Note
https://docs.google.com/spreadsheets/d/1b021SxYtYdNLH1ihfd8UmVRHBgJo0yRQBzq2a1OSsLc/edit

## Prerequisites

- Kubernetes 1.14+ 

## Installing the Chart

To install the chart with the release name `scada`:

```bash
$ helm repo add --username <username> --password <password> harbor https://harbor.wise-paas.io/chartrepo/scada
```
```bash
$ helm install --name scada --namespace scada harbor/scada --version <scada version>
```

> **Tip**: List all releases using `helm list`

## Uninstalling the Chart

To uninstall/delete the `scada` deployment:

```bash
$ helm delete scada
```

The command removes all the Kubernetes components associated with the chart and deletes the release.

## Configuration

The following table lists the configurable parameters of the scada chart and their default values.

| Parameter                                    | Description                                                                     | Default                                              |
| -------------------------------------------- | ------------------------------------------------------------------------------- | ---------------------------------------------------- |
| `portal.replicaCount`                               | Pod relicaCount.                                                                | `1`                                                  |
| `portal.containerPort`                           | Image repository.                                                               | `3000`  |
| `portal.image.repository`                           | Image repository.                                                               | `harbor.wise-paas.io/scada/portal-scada`  |
| `portal.image.tag`                                  | Image tag.                                                                      | `1.3.32`                                              |
| `portal.image.pullPolicy`                           | Image pullPolicy.                                                               | `Always`                                       |
| `portal.resources.limits.cpu`                           | Resource limit CPU..                                                               | `1000m`                                       |
| `portal.resources.limits.memory`                           | Resource limit memory.                                                               | `512Mi`                                       |
| `portal.resources.requests.cpu`                           | Resource requests CPU.                                                               | `1000m`                                       |
| `portal.resources.requests.memory`                           | Resource requests memory.                                                               | `512Mi`                                       |
| `worker.replicaCount`                               | Pod relicaCount.                                                                | `1`                                                  |
| `worker.image.repository`                           | Image repository.                                                               | `harbor.wise-paas.io/scada/scada-dataworker`  |
| `worker.image.tag`                                  | Image tag.                                                                      | `1.3.25`                                              |
| `worker.image.pullPolicy`                           | Image pullPolicy.                                                               | `Always`                                       |
| `worker.resources.limits.cpu`                           | Resource limit CPU..                                                               | `1000m`                                       |
| `worker.resources.limits.memory`                           | Resource limit memory.                                                               | `512Mi`                                       |
| `worker.resources.requests.cpu`                           | Resource requests CPU.                                                               | `1000m`                                       |
| `worker.resources.requests.memory`                           | Resource requests memory.                                                               | `512Mi`                                       |
| `imageCredentials.username`                               | harbor username.                                                                   | `USERNAME`                                          |
| `imageCredentials.password`                               | harbor password.                                                                   | `PASSWORD`                                          |
| `nameOverride`                               | NameOverride.                                                                   | `nil`                                                |
| `fullnameOverride`                           | FullnameOverride.                                                               | `nil`                                                |
| `envs.org_name`                                       | org name.                                                                   | `nil`|
| `envs.org_id`                                       | org id.                                                                   | `nil`|
| `envs.space_name`                                       | space name.                                                                   | `nil`|
| `envs.space_id`                                       | space id.                                                                   | `nil`|
| `envs.application_id`                                       | application id.                                                                   | `nil`|
| `envs.sso_url`                                       | sso url.                                                                   | `nil`|
| `envs.dccs_url`                                       | dccs url.                                                                   | `nil`|
| `envs.notification_url`                                       | notification url.                                                                   | `nil`|
| `envs.tech_url`                                       | tech portal url.                                                                   | `nil`|
| `envs.mp_url`                                       | mp url.                                                                   | `nil`|
| `envs.dashboard_url`                                       | dashboard url.                                                                   | `nil`|
| `envs.amqp_prefetch`                                       | amqp_prefetch.                                                                   | `20`|
| `envs.MESSAGE_RULE`                                       | MESSAGE_RULE.                                                                   | `nil`|
| `global.database.secretName`                                       | all-in-one services secret name.                                                                   | `scada-secret`|
| `livenessProbe.enabled`                      | LivenessProbe enabled.                                                          | `false`                                              |
| `livenessProbe.initialDelaySeconds`          | LivenessProbe initialDelaySeconds.                                              | `30`                                                 |
| `livenessProbe.periodSeconds`                | LivenessProbe periodSeconds.                                                    | `10`                                                 |
| `livenessProbe.httpGet.path`                 | LivenessProbe http path.                                                        | `/`                                                  |
| `readinessProbe.enabled`                     | ReadinessProbe enabled.                                                         | `false`                                              |
| `readinessProbe.initialDelaySeconds`         | ReadinessProbe initialDelaySeconds.                                             | `5`                                                  |
| `readinessProbe.periodSeconds`               | ReadinessProbe periodSeconds.                                                   | `10`                                                 |
| `readinessProbe.httpGet.path`                | ReadinessProbe http path.                                                       | `/`                                                  |
| `service.type`                               | Service Type.                                                                   | `ClusterIP`                                          |
| `service.targetPort`                      | Pod port.                                          | `3000`                                               |
| `service.port`                               | Service port.                                                                   | `80`                                                 |
| `ingress.enabled`                            | Ingress enabled.                                                                | `true`                                              |
| `ingress.annotations`                        | Ingress annotations.                                                            | `{}`                                                 |
| `ingress.path`                               | Ingress path.                                                                   | `/`                                                  |
| `ingress.hosts`                              | Ingress hosts.                                                                  | `[cluster.local]`                                    |
| `ingress.tls`                                | Ingress tls.                                                                    | `[]`                                                 |

```bash
$ helm install --name scada  -f values.yaml harbor/scada --version <scada version>
```

> **Tip**: You can use the default [values.yaml](values.yaml)