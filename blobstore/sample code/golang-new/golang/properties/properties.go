package properties

import (
	"encoding/json"
	"fmt"
	"log"
	"os"
	"strings"
)

var (
	blobstore *Blobstore
)

type EnsaasService struct {
	Blobstore []Blobstore `json:"blobstore"`
}

//{"blobstore":[]}
type Blobstore struct {
	BindingName       string      `json:"binding_name"`
	InstanceName      string      `json:"instance_Name"`
	Label             string      `json:"label"`
	Plan              string      `json:"plan"`
	ServiceInstanceId string      `json:"serviceInstanceId"`
	SubscriptionId    string      `json:"subscriptionId"`
	Credentials       Credentials `json:"credentials"`
}

type Credentials struct {
	Bucket           string `json:"bucket"`
	Endpoint         string `json:"endpoint"`
	ExternalHosts    string `json:"externalHosts"`
	InternalHosts    string `json:"internalHosts"`
	AccessKey        string `json:"accesskey"`
	Secretkey        string `json:"secretkey"`
	Type             string `json:"type"`
	SignatureVersion string `json:"signature-version"`
	ForceV4          bool   `json:"-"`
	SSL              bool   `json:"-"`
}

func init() {
	initProperties()
	printParam(blobstore)
}

func initProperties() {
	str := getEnv("ENSAAS_SERVICES", `{"blobstore": [{
			"binding_name": "<string>",
			"instance_Name": "<string>",
			"label": "<string>",
			"plan": "<string>",
			"serviceInstanceId": "<string>",
			"subscriptionId": "<string>",
			"credentials": {
				"bucket": "<string>",
				"endpoint": "<string>",
				"externalHosts": "<string>",
				"internalHosts": "<string>",
				"accesskey": "<string>",
				"secretkey": "<string>",
				"signature-version":"<string>",
				"type": "<string>",
				"-": "-"}}]}`)
	var ensaasService *EnsaasService

	//get ensaasServices(string)
	if err := json.Unmarshal([]byte(str), &ensaasService); err != nil {
		log.Fatalln(err)
	}
	//get ensaasServices(struct)
	if ensaasService == nil || len(ensaasService.Blobstore) == 0 {
		log.Fatalln("blobstore not found")
	}

	//get blobstore(struct) == ensaasService.Blobstore[0]
	blobstore = &ensaasService.Blobstore[0]
	if blobstore != nil {
		endpoint := blobstore.Credentials.Endpoint
		if strings.HasPrefix(endpoint, "http://") {
			blobstore.Credentials.Endpoint = strings.TrimPrefix(endpoint, "http://")
		}
		if strings.HasPrefix(endpoint, "https://") {
			blobstore.Credentials.Endpoint = strings.TrimPrefix(endpoint, "https://")
			blobstore.Credentials.SSL = true
		}
	}
}

func getEnv(key string, fallback string) string {
	value := os.Getenv(key)
	if len(value) == 0 {
		return fallback
	}
	return value
}

func GetCredentials() *Credentials {
	return &blobstore.Credentials
}

func printParam(blobstore *Blobstore) {
	b, err := json.Marshal(blobstore)
	if err != nil {
		log.Println("[config.properties] err:", err)
	}
	fmt.Println("properties:", string(b))
}
