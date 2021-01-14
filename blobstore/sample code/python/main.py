from python.properties import Blobstore
from python.sample_blob import *
from python.sample_minio import *
from python.sample_oss import *


# for blob
def blob_operation(endpoint, account_name, account_key):
    blob_client = BLOB(endpoint=endpoint, account_name=account_name, account_key=account_key)

    # ----------------list container-------------
    containers = blob_client.list_container()
    print(containers)

    # ----------------create container-------------
    blob_client.create_container("mycontainer03")

    # ----------------delete container-------------
    blob_client.delete_container("mycontainer03")

    # ----------------list blob-------------
    blobs = blob_client.list_blob("mycontainer01")
    print(blobs)

    # ----------------upload blob-------------
    blob_client.upload_blob("mycontainer01", "myblob", "requirement.txt")

    # ----------------download blob-------------
    file = blob_client.download_blob("mycontainer01", "myblob")
    print(file)

    # ----------------delete blob-------------
    blob_client.delete_blob("mycontainer01", "myblob")


def minio_operation(endpoint, access_key, secret_key):
    minio_client = MINIO(endpoint=endpoint, access_key=access_key, secret_key=secret_key)

    # ----------------list bucket-------------
    buckets = minio_client.list_bucket()
    print(buckets)

    # ----------------create bucket-------------
    minio_client.create_bucket("mybucket02")

    # ----------------delete bucket-------------
    minio_client.delete_bucket("mybucket02")

    # ----------------list object-------------
    objects = minio_client.list_object("cindy1")
    print(objects)

    # ----------------upload object-------------
    minio_client.upload_object("mybucket01", "myobject", "hello minio!")

    # ----------------upload object-------------
    s = minio_client.download_object("mybucket01", "myobject")
    print(s)

    # ----------------delete object-------------
    minio_client.delete_object("mybucket01", "myobject")


def oss_operation(endpoint, access_key, secret_key, bucket_name):
    bucket_client = OSS(endpoint, access_key, secret_key, bucket_name)
    # ----------------list object-------------
    objects = bucket_client.list_object()
    print(objects)

    # # ----------------upload object-------------
    bucket_client.upload_object("myobject", "hello minio!")

    # ----------------upload object-------------
    s = bucket_client.download_object("myobject")
    print(s)

    # ----------------delete object-------------
    bucket_client.delete_object("myobject")


def main():
    blobstores = Blobstore()
    credential = blobstores.blobstore["credentials"]
    credential['type'] = 'aliyun-oss'
    if credential:
        if credential['type'] == 'azure-blob':
            blob_operation(credential["endpoint"], credential["accesskey"], credential["secretkey"])
        elif credential['type'] == 'aliyun-oss':
            oss_operation(credential["endpoint"], credential["accesskey"], credential["secretkey"],
                          credential["bucket"])
        elif credential['type'] == 's3-compatible':
            minio_operation(credential["endpoint"], credential["accesskey"], credential["secretkey"])


if __name__ == '__main__':
    main()
