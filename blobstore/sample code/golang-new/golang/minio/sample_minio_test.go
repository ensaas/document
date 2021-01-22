package minio

import (
	"fmt"
	"log"
	"simple_code/golang/properties"
	"testing"
)

func TestNewMinioClient(t *testing.T) {
	credentials := &properties.Credentials{
		Endpoint:  "",
		AccessKey: "",
		Secretkey: "",
	}

	client, err := NewMinioClient(credentials)
	if err != nil {
		log.Println(err)
	}
	fmt.Println(client)

	//buckets, err := client.ListBucket()
	//if err != nil {
	//	log.Println(err)
	//}
	//fmt.Println(buckets)

	//err = client.CreateBucket("mybucket")
	//if err != nil {
	//	log.Println("err:", err)
	//}

	//err = client.DeleteBucket("mybucket")
	//if err != nil {
	//	log.Println("err:", err)
	//}

	//objects := client.ListObject("mybucket")
	//fmt.Println(objects)

	//err = client.UploadObject("mybucket", "myobject", strings.NewReader("hello bucket!"))
	//if err != nil {
	//	log.Println(err)
	//}
	//var object []byte
	//obj, err := client.DownloadObject("mybucket", "myobject")
	//if err != nil {
	//	log.Println("err:", err)
	//}
	//fmt.Println(obj.Stat())

	//err = client.DeleteObject("mybucket", "myobject")
	//if err != nil {
	//	log.Println(err)
	//}

}
