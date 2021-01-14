package com.example.demo.oss;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OSS {

    private AmazonS3 s3Client;

    public OSS(String endpoint, String accessKey, String accessSecret) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecret);
        ClientConfiguration cc = new ClientConfiguration();
//        if (!endpoint.contains("aliyun")) {
//            cc.setSignerOverride("S3SignerType");
//        }
//        Boolean pathStyleAccess = !endpoint.contains("aliyun");
        s3Client = AmazonS3ClientBuilder.standard().withClientConfiguration(cc)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withPathStyleAccessEnabled(false)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, null)).build();
    }

    public List<String> listObject(String bucketName) {
        List<String> objList = new ArrayList<>();
        try {
            ObjectListing obj = s3Client.listObjects(bucketName);
            for (S3ObjectSummary os : obj.getObjectSummaries()) {
                objList.add(os.getKey());
            }
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        }
        return objList;
    }

    public void uploadObject(String bucketName, String object, InputStream inputStream) {
        try {
            PutObjectRequest request = new PutObjectRequest(bucketName, object, inputStream, null);
            s3Client.putObject(request);
            System.out.println("===upload object:" + object + "===");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        }
    }

    public InputStream downloadObject(String bucketName, String object) {
        InputStream in = null;
        try {
            GetObjectRequest request = new GetObjectRequest(bucketName, object);
            S3Object obj = s3Client.getObject(request);
            S3ObjectInputStream inputStream = obj.getObjectContent();
            in = inputStream.getDelegateStream();
            System.out.println("===download object:" + object + "===");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        }
        return in;
    }

    public void removeObject(String bucketName, String fileName) {
        try {
            DeleteObjectRequest request = new DeleteObjectRequest(bucketName, fileName);
            s3Client.deleteObject(request);
            System.out.println("===delete file " + fileName + "===");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        }
    }


}
