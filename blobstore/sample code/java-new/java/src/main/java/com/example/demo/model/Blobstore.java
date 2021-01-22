package com.example.demo.model;

public class Blobstore {
    private String bindingName ;
    private String instanceName;
    private String label;
    private String plan;
    private String serviceInstanceId;
    private String subscriptionId;
    private Credentials credentials;

    public Blobstore() {
    }

    public Blobstore(String bindingName, String instanceName, String label, String plan, String serviceInstanceId, String subscriptionId, Credentials credentials) {
        this.bindingName = bindingName;
        this.instanceName = instanceName;
        this.label = label;
        this.plan = plan;
        this.serviceInstanceId = serviceInstanceId;
        this.subscriptionId = subscriptionId;
        this.credentials = credentials;
    }

    public String getBindingName() {
        return bindingName;
    }

    public void setBindingName(String bindingName) {
        this.bindingName = bindingName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getServiceInstanceId() {
        return serviceInstanceId;
    }

    public void setServiceInstanceId(String serviceInstanceId) {
        this.serviceInstanceId = serviceInstanceId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Blobstore{" +
                "bindingName='" + bindingName + '\'' +
                ", instanceName='" + instanceName + '\'' +
                ", label='" + label + '\'' +
                ", plan='" + plan + '\'' +
                ", serviceInstanceId='" + serviceInstanceId + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", credentials=" + credentials +
                '}';
    }
}
