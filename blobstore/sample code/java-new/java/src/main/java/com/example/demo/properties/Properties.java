package com.example.demo.properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.demo.model.Blobstore;
import com.example.demo.model.Credentials;

import java.util.List;

public class Properties {
    private Credentials credentials;

    public Properties() {
        getEnv();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void getEnv() {
        String env = System.getenv("ENSAAS_SERVICES");
        if (env == null || env.equals("")) {
            env = "{\"blobstore\": [{\"binding_name\": \"bind\",\"instance_Name\": \"instance\",\"label\": \"label\"," +
                    "\"plan\": \"plan\",\"serviceInstanceId\": \"instance_id\",\"subscriptionId\": \"subscription_id\"," +
                    "\"credentials\": {\"bucket\": \"bucketname\",\"endpoint\": \"minio-cindy-eks002.labs.wise-paas.com\"," +
                    "\"externalHosts\": \"minio-cindy-eks002.labs.wise-paas.com\",\"internalHosts\": \"10.233.20.159\"," +
                    "\"accesskey\": \"AKIAIOSFODNN7EXAMPLE\",\"secretkey\": \"wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY\"," +
                    "\"type\": \"type\",\"-\": \"-\"}}]}";
        }
        JSONObject jsonObject = JSON.parseObject(env);
        JSONArray array = jsonObject.getJSONArray("blobstore");
        List<Blobstore> blobstores = JSON.parseObject(array.toJSONString(), new TypeReference<List<Blobstore>>() {

        });
        if (blobstores != null) {
            credentials = blobstores.get(0).getCredentials();
        }
    }
}
