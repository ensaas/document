import boto.s3.connection
from boto.s3.key import Key


class MINIO:
    client = None

    def __init__(self, endpoint, access_key, secret_key):
        self.client = boto.connect_s3(
            aws_access_key_id=access_key,
            aws_secret_access_key=secret_key,
            host=endpoint,
            is_secure=True,
            calling_format=boto.s3.connection.OrdinaryCallingFormat()
        )

    # -------list buckets---------------
    def list_bucket(self):
        list = []
        buckets = self.client.get_all_buckets()
        for bucket in buckets:
            list.append(bucket.name)
        return list

    # -------create bucket---------------
    def create_bucket(self, bucket_name):
        self.client.create_bucket(bucket_name)
        print("crete bucket:", bucket_name)

    # -------delete bucket---------------
    def delete_bucket(self, bucket_name):
        self.client.delete_bucket(bucket_name)
        print("delete bucket:", bucket_name)

    # -------list objects---------------
    def list_object(self, bucket_name):
        list = []
        bucketclient = self.client.get_bucket(bucket_name)
        keys = bucketclient.get_all_keys()
        for key in keys:
            list.append(key.name)
        return list

    # -------upload object---------------
    def upload_object(self, bucket_name, object_name, str):
        bucketclient = self.client.get_bucket(bucket_name)
        key = Key(bucketclient)
        key.name = object_name
        key.set_contents_from_string(str)
        print("upload object:", object_name)

    # -------download object---------------
    def download_object(self, bucket_name, object_name):
        bucketclient = self.client.get_bucket(bucket_name)
        key = Key(bucketclient)
        key.name = object_name
        s = key.get_contents_as_string()
        return s

    # -------delete object---------------
    def delete_object(self, bucket_name, object_name):
        bucketclient = self.client.get_bucket(bucket_name)
        key = Key(bucketclient)
        key.name = object_name
        key.delete()
        print("delete object:", object_name)
