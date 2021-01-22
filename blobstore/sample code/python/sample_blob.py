from azure.storage.blob import BlobServiceClient


class BLOB:
    blob_service = None

    def __init__(self, endpoint, account_name, account_key):
        self.blob_service = BlobServiceClient.from_connection_string(
            'DefaultEndpointsProtocol=https;AccountName=' + account_name + ';AccountKey=' +
            account_key + ';EndpointSuffix=' + endpoint)

    # -------list containers---------------
    def list_container(self):
        containers = []
        results = self.blob_service.list_containers()
        for result in results:
            containers.append(result.name)
        return containers

    # -------create container---------------
    def create_container(self, container_name):
        self.blob_service.create_container(container_name)
        print("create container:", container_name)

    # -------delete container---------------
    def delete_container(self, container_name):
        self.blob_service.delete_container(container_name)
        print("delete container:", container_name)

    # -------list blobs---------------
    def list_blob(self, container_name):
        list = []
        container_client = self.blob_service.get_container_client(container_name)
        blobs = container_client.list_blobs()
        for b in blobs:
            list.append(b["name"])
        return list

    # -------upload blob---------------
    def upload_blob(self, container_name, blob_name, file):
        container_client = self.blob_service.get_container_client(container_name)
        container_client.upload_blob(blob_name, file)
        print("upload:", file)

    # -------download blob---------------
    def download_blob(self, container_name, blob_name):
        container_client = self.blob_service.get_container_client(container_name)
        file = container_client.download_blob(blob_name)
        return file

    # -------delete blob---------------
    def delete_blob(self, container_name, blob_name):
        container_client = self.blob_service.get_container_client(container_name)
        container_client.delete_blob(blob_name)
        print('delete blob:', blob_name)
