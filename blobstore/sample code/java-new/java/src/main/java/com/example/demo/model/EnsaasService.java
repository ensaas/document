package com.example.demo.model;

import java.util.List;

public class EnsaasService {
    private List<Blobstore> ensaasServiceList;

    public EnsaasService(List<Blobstore> ensaasServiceList) {
        this.ensaasServiceList = ensaasServiceList;
    }

    public List<Blobstore> getEnsaasServiceList() {
        return ensaasServiceList;
    }

    public void setEnsaasServiceList(List<Blobstore> ensaasServiceList) {
        this.ensaasServiceList = ensaasServiceList;
    }
}
