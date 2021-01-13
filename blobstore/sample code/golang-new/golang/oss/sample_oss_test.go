package oss

import (
	"fmt"
	"log"
	"simple_code/golang/properties"
	"testing"
)

func TestNewOSSClient(t *testing.T) {
	credentials := &properties.Credentials{
		Endpoint:  "",
		AccessKey: "",
		Secretkey: "",
	}
	client, err := NewOSSClient(credentials)
	if err != nil {
		log.Println("err:", err)
	}
	fmt.Println(client)

	objects := client.ListObject(credentials.Bucket)
	fmt.Println(objects)
	//err = client.UploadObject(credentials.Bucket, "myobject", strings.NewReader("hello oss!"))
	//if err != nil {
	//	log.Println("err:", err)
	//}

	//object, err := client.DownloadObject(credentials.Bucket, "myobject")
	//if err != nil {
	//	log.Println("err:", err)
	//}
	//fmt.Println(object)

	err = client.DeleteObject(credentials.Bucket, "myobject")
	if err != nil {
		log.Println("err:", err)
	}

}
