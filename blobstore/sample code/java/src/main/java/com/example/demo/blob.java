package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class blob {
	  @Autowired
	  Config config = new Config();
	  String endpoint= config.getEndpoint();
	  String accessKeyId = config.getAccessKey();
	  String accessKeySecret= config.getSecretKey();
	  String bucketName= config.getBucket();

	 
	  AWSCredentials credentials = new BasicAWSCredentials(
			  accessKeyId, 
			  accessKeySecret
			);
	  

	  AmazonS3 s3client = AmazonS3ClientBuilder
			  .standard()
			  .withClientConfiguration(amazonS3CC())
			  .withCredentials(new AWSStaticCredentialsProvider(credentials))
			  .withPathStyleAccessEnabled(pathStyleAccess())
			  .withEndpointConfiguration(new EndpointConfiguration(endpoint,null))
			  .build();
	  
	  
	  public List<Bucket> getBucketList() {
		  List<Bucket> buckets = null;
		  
		  if (endpoint.indexOf("aliyun")<0){
			  try {
				  buckets = s3client.listBuckets();
				  for(Bucket bucket : buckets) {
				      System.out.println("- "+bucket.getName());
				  }
				  if (!buckets.isEmpty()){
					  config.setBucket(buckets.get(0).getName());
				  }
				  
			  } catch(AmazonServiceException ase) {
				  System.out.println("error: "+ase);
			  } catch(SdkClientException sce) {
				  System.out.println("error: "+sce);
			  }
			  
		  }
		  return buckets;
	  }
	  
	  public List<String> getObjectList() {
		  String bucketName= config.getBucket();
		  List<String> objList = new ArrayList<String>();
		  if (bucketName!="") {
			  try {
				  ObjectListing objectListing = s3client.listObjects(bucketName);
				  for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
					  objList.add(os.getKey());
					  System.out.println("- "+os.getKey());
				  }
			  } catch(AmazonServiceException ase) {
				  System.out.println("error: "+ase);
			  }
		  } else {
			  System.out.println("no bucket.");
		  }
		  return objList;
	  }
	  
	  public void uploadFile(String bucketName, String fileName, String filePath) {
		  try {		  
			  PutObjectRequest request = new PutObjectRequest(bucketName, fileName, new File(filePath));
			  s3client.putObject(request);
			  System.out.println("======upload file "+fileName+"=======");
		  } catch (AmazonServiceException ase) {
			  System.out.println("error: "+ase);
	      } 
	  }
	  
	  public void downloadFile(String bucketName, String fileName) {
		  try {		  
			  GetObjectRequest request = new GetObjectRequest(bucketName,  fileName);
			  String filePath = fileName;
			  File localFile = new File(filePath);
			  s3client.getObject(request,localFile);		  
			  System.out.println("======download file "+fileName+"=======");
		  } catch (AmazonServiceException ase) {
			  System.out.println("error: "+ase);
	      } 
	  }
	  
	  private ClientConfiguration amazonS3CC() {
		  ClientConfiguration cc = new ClientConfiguration();
		  if (endpoint.indexOf("aliyun")<0){
			  cc.setSignerOverride("S3SignerType");
		  }
		  return cc;
	  }
	  
	  private Boolean pathStyleAccess() {
		  if (endpoint.indexOf("aliyun")<0){
			  return true;
		  }
		  return false;
	  }
	  
}
