package main

import (
	"encoding/json"
	"fmt"
	"net/url"
	"os"
	"strings"

	"github.com/minio/minio-go/v7/pkg/s3utils"
)

var BlobCredential blobCredentials
var BlobPlan string

type ensaasServicesBlob struct {
	Blobstore []bindings `json:"blobstore"`
}

type bindings struct {
	BindingName       string          `json:"binding_name"`
	InstanceName      string          `json:"instance_Name"`
	Label             string          `json:"label"`
	Plan              string          `json:"plan"`
	ServiceInstanceId string          `json:"serviceInstanceId"`
	SubscriptionId    string          `json:"subscriptionId"`
	Credentials       blobCredentials `json:"credentials"`
}

type blobCredentials struct {
	AccessKey     string `json:"accesskey"`
	Bucket        string `json:"bucket"`
	Endpoint      string `json:"endpoint"`
	ExternalHosts string `json:"externalHosts"`
	InternalHosts string `json:"internalHosts"`
	Secretkey     string `json:"secretkey"`
	Type          string `json:"type"`

	ForceV4 bool `json:"-"`
	SSL     bool `json:"-"`
}

func GetEnv() error {
	ensaasServices := os.Getenv("ENSAAS_SERVICES")
	//得到json

	if len(ensaasServices) > 0 {
		fmt.Println(ensaasServices)
		/*
			blobInfoMap, err := getBlobInfoByMap(ensaasServices)
			if err != nil {
				fmt.Println(err)
			}
		*/
		//用map的方式得到secret內容

		blobInfoStruct, err := getBlobInfoByStruct(ensaasServices)
		if err != nil {
			return err
		}

		BlobCredential = blobInfoStruct.Blobstore[0].Credentials
		BlobPlan = blobInfoStruct.Blobstore[0].Plan

		fmt.Println("accessKey:", BlobCredential.AccessKey)
		fmt.Println("secretKey:", BlobCredential.Secretkey)
		fmt.Println("endpoint:", BlobCredential.Endpoint)

	} else {
		//沒有secret
		return fmt.Errorf("Cannot get secret.")
	}

	if strings.HasPrefix(BlobCredential.Endpoint, "http://") {
		BlobCredential.Endpoint = strings.TrimPrefix(BlobCredential.Endpoint, "http://")
	} else if strings.HasPrefix(BlobCredential.Endpoint, "https://") {
		BlobCredential.Endpoint = strings.TrimPrefix(BlobCredential.Endpoint, "https://")
		BlobCredential.SSL = true
	}

	endpointURL := url.URL{Host: BlobCredential.Endpoint}

	if s3utils.IsAliyunOSSEndpoint(endpointURL) {
		BlobCredential.ForceV4 = true
		BlobCredential.SSL = true
	}

	return nil
}

func getBlobInfoByStruct(ensaasServices string) (*ensaasServicesBlob, error) {
	blobInfo := &ensaasServicesBlob{}

	if err := json.Unmarshal([]byte(ensaasServices), blobInfo); err != nil {
		return nil, err
	}

	return blobInfo, nil
}

func getBlobInfoByMap(ensaasServices string) (map[string]interface{}, error) {
	var ensaasServicesMap map[string]interface{}

	if err := json.Unmarshal([]byte(ensaasServices), &ensaasServicesMap); err != nil {
		return nil, err
	}

	return ensaasServicesMap, nil
}
