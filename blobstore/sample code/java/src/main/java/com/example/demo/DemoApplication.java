package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/")
	public String home() {
		return "his is example for using blob by java.";
	}

	public static void main(String[] args) {
		System.out.println("This is example for using blob by java.");
		
		SpringApplication.run(DemoApplication.class, args);
		
		example();
	}
	
	public static void example() {	
		Config config = new Config();
		
	
		blob blobConn = new blob();
		blobConn.getBucketList();
		
		System.out.println("******list object of bucket "+config.getBucket());
		
		System.out.println("******object list:");
		List<String> objList = blobConn.getObjectList();
		
		System.out.println("******put a yaml file to first bucket as example.");

		blobConn.uploadFile(config.getBucket(), "values.yaml", "./charts/values.yaml");
		
		System.out.println("******get first file from first bucket as example.");
		blobConn.downloadFile(config.getBucket(), objList.get(0));

	}

}
