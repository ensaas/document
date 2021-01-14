package com.example.demo;

import com.example.demo.blob.Blob;
import com.example.demo.minio.Minio;
import com.example.demo.model.Credentials;
import com.example.demo.oss.OSS;
import com.example.demo.properties.Properties;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Credentials cre = new Properties().getCredentials();
        switch (cre.getType()) {
            case "aliyun-oss":
                oss_operation(cre);
            case "azure-blob":
                blob_operation(cre);
            case "s3-compatible":
                minio_operation(cre);
            default:
                System.out.println("nothing");
        }
    }

    private static void oss_operation(Credentials credential) {

        OSS oss = new OSS(credential.getEndpoint(), credential.getAccessKey(), credential.getSecretKey());
        //--------------list object--------------
        List<String> objs = oss.listObject(credential.getBucket());
        System.out.println(objs);

        //--------------upload object--------------
        try {
            InputStream input = null;
            String s = "hello minio!";
            byte[] a = s.getBytes();
            input = new ByteArrayInputStream(a);
            oss.uploadObject(credential.getBucket(), "myobject", input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------download object--------------
        InputStream in = oss.downloadObject(credential.getBucket(), "myobject");
        System.out.println(in);

        //--------------delete object--------------
        oss.removeObject(credential.getBucket(), "myobject");
    }

    private static void minio_operation(Credentials credential) {
        //--------------new minio.client--------------
        Minio minio = new Minio(credential.getEndpoint(), credential.getAccessKey(), credential.getSecretKey());

        //--------------list bucket--------------
        List<String> buckets = minio.listBucket();
        System.out.println(buckets);

        //--------------create bucket--------------
        minio.createBucket(credential.getBucket());

        //--------------list object--------------
        List<String> objs = minio.listObject(credential.getBucket());
        System.out.println(objs);


        //--------------upload object--------------
        try {
            InputStream input = null;
            String s = "hello minio!";
            byte[] a = s.getBytes();
            input = new ByteArrayInputStream(a);
            minio.uploadObject(credential.getBucket(), "myobject", input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------download object--------------
        InputStream in = minio.downloadObject(credential.getBucket(), "myobject");
        System.out.println(in);

        //--------------delete object--------------
        minio.removeObject(credential.getBucket(), "myobject");

        //--------------delete bucket--------------
        minio.deleteBucket(credential.getBucket());

    }

    private static void blob_operation(Credentials credential) {
        //--------------new blob.client--------------
        Blob blob = new Blob(credential.getEndpoint(), credential.getAccessKey(), credential.getSecretKey());

        //--------------list container--------------
        List<String> containers = blob.listContainer();
        System.out.println(containers);

        //--------------create container--------------
        blob.createContainer("mycontainer02");

        //--------------list blob--------------
        List<String> blobs = blob.listBlob("mycontainer01");
        System.out.println(blobs);


        //--------------upload blob--------------
        try {
            InputStream input = null;
            String s = "hello blob!";
            byte[] a = s.getBytes();
            input = new ByteArrayInputStream(a);
            blob.uploadBlob("mycontainer", "myblob", input, a.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------download blob--------------
        OutputStream outputStream = new ByteArrayOutputStream();
        blob.downloadBlob("mycontainer", "myblob", outputStream);
        byte[] arr = ((ByteArrayOutputStream) outputStream).toByteArray();
        System.out.println(arr.toString());

        //--------------delete blob--------------
        blob.deleteBlob("mycontainer", "myblob");

        //--------------delete container--------------
        blob.deleteContainer("mycontainer");
    }
}


