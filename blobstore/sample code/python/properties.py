import json

import os


class Blobstore:
    blobstore = None

    def __init__(self):
        self.blobstore = resolveEnv()


def getEnv(param, fallback):
    env = os.getenv(param)
    if not env:
        print("local parameters")
        env = fallback
    return env


def resolveEnv():
    env = getEnv("ENSAAS_SERVICE", '''{"blobstore": [{
    "binding_name": "<string>",
    "instance_Name": "<string>",
    "label": "<string>",
    "plan": "<string>",
    "serviceInstanceId": "<string>",
    "subscriptionId": "<string>",
    "credentials": {
        "bucket": "<string>",
        "endpoint": "<string>",
        "externalHosts": "<string>",
        "internalHosts": "<string>",
        "accesskey": "<string>",
        "secretkey": "<string>",
        "signature-version": "<string>",
        "type": "<string>",
        "-": "-"}}]}''')
    ensaasService = json.loads(env)
    # if 'blobstore' in ensaasService:
    #     print(ensaasService)
    return ensaasService["blobstore"][0]
