# Api Consumption Agent Postgresql

Postgresql-Consumption-Agent-go is a postgresql consumption agent on Kubernetes.

### Features

* Serve 3 API (Lock, Resume, Status)

## Prerequisites

* Kubernetes 1.14+

## Installing the Chart

To install the chart with the release name `cma-postgresql-go`:

```bash
helm repo add  --username <username> --password <password> develop http://harbor.arfa.wise-paas.com/chartrepo/develop
```

> **Tip**: List all releases using `helm list`

## Uninstalling the Chart

To uninstall/delete the `cma-postgresql-go` deployment

```bash
helm delete <deployment_name> --purge
```

The command removes all the Kubernetes components associated with the chart and deletes the release.

## Configuration

* Default value of values.yaml:

| Parameter                           | Description                 | Default   |
| ----------------------------------- | ----------------------------|---------- |
| `image.repository`                  | Image repository            |`harbor.arfa.wise-paas.com/database/api-consumption-agent-postgresql-go`|
| `image.tag`                         | Image tag                   |`0.2.1`       |
| `image.pullPolicy`                  | Image pullPolicy            |`IfNotPresent`|
| `image.pullSecrets.enabled`         | Kubernetes pullSecrets      |`true`        |
| `replicas`                          | Pod replicas                |`1`           |
| `service.type`                      | Service Type                |`ClusterIP`   |
| `service.port`                      | Service port                |`8080`        |
| `resources`                         | Resource limit & request    | `{}`         |

* Env config

| Parameter                | Description                      | Default         |
| ------------------------ | -------------------------------- | --------------- |
| `SECURITY_USER_NAME`     | login servicemanager username    | `user`          |
| `SECURITY_USER_PASSWORD` | login servicemanager password    | `password`      |
| `OPS_POSTGRES_HOST`      | Ops postgres host                | `61.219.26.37`  |
| `OPS_POSTGRES_PORT`      | Ops postgres port                | `5432`          |
| `OPS_POSTGRES_USERNAME`  | Ops postgres username            | `postgres`      |
| `OPS_POSTGRES_PASSWORD`  | Ops postgres password            | `************`  |
| `OPS_POSTGRES_DATABASE`  | Ops postgres database            | `postgres`      |

> **Tip**: You can use the default [values.yaml](values.yaml)
