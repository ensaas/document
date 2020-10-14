package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class Config {
	
	public static String ensaasServicesStr;
	
	private static String endpoint;
	private static String accessKey;
	private static String secretKey;
	private static String bucket;

	private JSONObject ensaasServices;
		
	@Value("${ensaasServices:\"\"}")
	public void setEnsaasService() {
		this.ensaasServicesStr = System.getenv("ENSAAS_SERVICES");
		System.out.println(this.ensaasServicesStr);
		if (this.ensaasServicesStr !=null && this.ensaasServicesStr!=""){
			this.ensaasServices = new JSONObject(this.ensaasServicesStr);
		}
		System.out.println("==============set properties===========");
		try {
				this.endpoint = ensaasServices.getJSONArray("blobstore").getJSONObject(0).getJSONObject("credentials").getString("endpoint");
			} catch (NullPointerException e){
				this.endpoint = "-";
			} catch (JSONException je) {
				this.endpoint = "-";
			}
			
		try {
				this.accessKey = ensaasServices.getJSONArray("blobstore").getJSONObject(0).getJSONObject("credentials").getString("accessKey");
			} catch (NullPointerException e){
				this.accessKey = "-";
			} catch (JSONException je) {
				this.accessKey = "-";
			}			
			
		try {
				this.secretKey = ensaasServices.getJSONArray("blobstore").getJSONObject(0).getJSONObject("credentials").getString("secretKey");
			} catch (NullPointerException e){
				this.secretKey = "-";
			} catch (JSONException je) {
				this.secretKey = "-";
			}
			
		try {
				this.bucket = ensaasServices.getJSONArray("blobstore").getJSONObject(0).getJSONObject("credentials").getString("bucket");
			} catch (NullPointerException e){
				this.bucket="";
			} catch (JSONException je) {
				this.bucket="";
			}
			
		System.out.println("accessKey: "+this.accessKey);
		System.out.println("secretKey: "+this.secretKey);
		System.out.println("endpoint: "+this.endpoint);
		System.out.println("bucket: "+this.bucket);
	}
	
	public String getEndpoint(){
		return this.endpoint;
	}
	
	public String getAccessKey() {
		return this.accessKey;
	}
	
	public String getSecretKey() {
		return this.secretKey;
	}
	
	public String getBucket() {
		return this.bucket;
	}
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

}
