import oss2


class OSS:
    client = None

    def __init__(self, endpoint, access_key, secret_key, bucket_name):
        self.client = oss2.Bucket(oss2.Auth(access_key_id=access_key, access_key_secret=secret_key),
                                  endpoint=endpoint,
                                  bucket_name=bucket_name)

    # -------list objects---------------
    def list_object(self):
        list = []
        objects = self.client.list_objects()
        for obj in objects.object_list:
            list.append(obj.key)
        return list

    # -------upload object---------------
    def upload_object(self, object_name, str):
        self.client.put_object(object_name, str)
        print("upload object:", object_name)

    # -------download object---------------
    def download_object(self, object_name):
        object = self.client.get_object(object_name)
        return object.read()

    # -------delete object---------------
    def delete_object(self, object_name):
        self.client.delete_object(object_name)
        print("delete object:", object_name)
