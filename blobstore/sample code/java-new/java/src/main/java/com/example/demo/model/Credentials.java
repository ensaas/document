package com.example.demo.model;

public class Credentials {
    private String Bucket;
    private String Endpoint;
    private String ExternalHosts;
    private String InternalHosts;
    private String AccessKey;
    private String SecretKey;
    private String Type;
    private Boolean ForceV4;
    private Boolean SSL;

    public Credentials() {
    }

    public Credentials(String bucket, String endpoint, String externalHosts, String internalHosts, String accessKey, String secretKey, String type, Boolean forceV4, Boolean SSL) {
        Bucket = bucket;
        Endpoint = endpoint;
        ExternalHosts = externalHosts;
        InternalHosts = internalHosts;
        AccessKey = accessKey;
        SecretKey = secretKey;
        Type = type;
        ForceV4 = forceV4;
        this.SSL = SSL;
    }

    public String getBucket() {
        return Bucket;
    }

    public void setBucket(String bucket) {
        Bucket = bucket;
    }

    public String getEndpoint() {
        return Endpoint;
    }

    public void setEndpoint(String endpoint) {
        Endpoint = endpoint;
    }

    public String getExternalHosts() {
        return ExternalHosts;
    }

    public void setExternalHosts(String externalHosts) {
        ExternalHosts = externalHosts;
    }

    public String getInternalHosts() {
        return InternalHosts;
    }

    public void setInternalHosts(String internalHosts) {
        InternalHosts = internalHosts;
    }

    public String getAccessKey() {
        return AccessKey;
    }

    public void setAccessKey(String accessKey) {
        AccessKey = accessKey;
    }

    public String getSecretKey() {
        return SecretKey;
    }

    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Boolean getForceV4() {
        return ForceV4;
    }

    public void setForceV4(Boolean forceV4) {
        ForceV4 = forceV4;
    }

    public Boolean getSSL() {
        return SSL;
    }

    public void setSSL(Boolean SSL) {
        this.SSL = SSL;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "Bucket='" + Bucket + '\'' +
                ", Endpoint='" + Endpoint + '\'' +
                ", ExternalHosts='" + ExternalHosts + '\'' +
                ", InternalHosts='" + InternalHosts + '\'' +
                ", AccessKey='" + AccessKey + '\'' +
                ", SecretKey='" + SecretKey + '\'' +
                ", Type='" + Type + '\'' +
                ", ForceV4=" + ForceV4 +
                ", SSL=" + SSL +
                '}';
    }
}
