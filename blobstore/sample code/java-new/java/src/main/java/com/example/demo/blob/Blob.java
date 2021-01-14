package com.example.demo.blob;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobContainerItem;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobProperties;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Blob {

    private BlobServiceClient client;

    public Blob(String endpoint, String accountName, String accountKey) {
        String connectString = "DefaultEndpointsProtocol=https;AccountName=" + accountName + ";AccountKey=" + accountKey + ";EndpointSuffix=" + endpoint;
        this.client = new BlobServiceClientBuilder().connectionString(connectString).buildClient();
    }

    public List<String> listContainer() {
        List<String> containers = new ArrayList<>();
        PagedIterable<BlobContainerItem> pagedIterable = client.listBlobContainers();
        for (BlobContainerItem item : pagedIterable) {
            containers.add(item.getName());
        }
        return containers;
    }

    public void createContainer(String containerName) {
        client.createBlobContainer(containerName);
        System.out.println("=== create container:" + containerName + "===");
    }

    public void deleteContainer(String containerName) {
        client.deleteBlobContainer(containerName);
        System.out.println("=== delete container:" + containerName + "===");
    }

    public List<String> listBlob(String containerName) {
        List<String> blobs = new ArrayList<>();
        BlobContainerClient containerClient = client.getBlobContainerClient(containerName);
        PagedIterable<BlobItem> items = containerClient.listBlobs();
        for (BlobItem item : items) {
            blobs.add(item.getName());
        }
        return blobs;
    }

    public void uploadBlob(String containerName, String blobName, InputStream stream, int length) {
        BlobContainerClient containerClient = client.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(blobName);
        blobClient.upload(stream, length);
        System.out.println("===upload blob:" + blobName + "===");
    }

    public void downloadBlob(String containerName, String blobName, OutputStream outputStream) {
        BlobContainerClient containerClient = client.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(blobName);
        blobClient.download(outputStream);
        System.out.println("===download blob:" + blobName + "===");
    }

    public void deleteBlob(String containerName, String blobName) {
        BlobContainerClient containerClient = client.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(blobName);
        blobClient.delete();
        System.out.println("===delete blob:" + blobName + "===");
    }
}
