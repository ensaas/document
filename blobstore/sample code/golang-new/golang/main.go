package main

import (
	"bytes"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"simple_code/golang/blob"
	"simple_code/golang/minio"
	"simple_code/golang/oss"
	"simple_code/golang/properties"
	"strings"
)

func main() {
	credentials := properties.GetCredentials()
	switch credentials.Type {
	case "azure-blob":
		blob_operation(credentials)
	case "s3-compatible":
		minio_operation(credentials)
	case "aliyun-oss":
		oss_operation(credentials)
	}
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "")
	})

	http.ListenAndServe(":8080", nil)
}

func blob_operation(cre *properties.Credentials) {
	//--------------new demo.client--------------
	client, err := blob.NewBlobClient(cre)
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
	//--------------list container of storageAccount--------------
	containers, err := client.ListContainer()
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
	fmt.Println(containers)

	//--------------create container--------------
	err = client.CreateContainer("mycontainer")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------list sample_blob--------------
	blobs, err := client.ListBlob("mycontainer")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
	fmt.Println(blobs)

	//--------------upload sample_blob--------------
	err = client.UploadBlob("mycontainer", "myblob", bytes.NewReader([]byte("hello blob!")))
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------down sample_blob--------------
	body, err := client.DownloadBlob("mycontainer", "myblob")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
	data, err := ioutil.ReadAll(body)
	if err != nil {
		log.Println("err:", err)
	}
	fmt.Println(string(data))

	//--------------delete sample_blob--------------
	err = client.DeleteBlob("my_container", "my_blob")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------delete container--------------
	err = client.DeleteContainer("my_container")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
}

func minio_operation(cre *properties.Credentials) {
	//--------------new s3.client--------------
	client, err := minio.NewMinioClient(cre)
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------list bucket--------------
	buckets, err := client.ListBucket()
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
	fmt.Println(buckets)

	//--------------create bucket--------------
	err = client.CreateBucket("mybucket")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------delete bucket--------------
	err = client.DeleteBucket("mybucket")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------list object of bucket--------------
	objects := client.ListObject("mybucket")
	fmt.Println(objects)

	//--------------upload object to bucket--------------

	err = client.UploadObject("mybucket", "myobject", strings.NewReader("hello bucket!"))
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------download object of bucket--------------
	object, err := client.DownloadObject("mybucket", "myobject")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}
	fmt.Println(object.Stat())

	//--------------delete object of bucket--------------
	err = client.DeleteObject("mybucket", "myobject")
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

}

func oss_operation(cre *properties.Credentials) {
	//--------------new demo.client--------------
	client, err := oss.NewOSSClient(cre)
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
	}

	//--------------list object of bucket--------------
	objects := client.ListObject(cre.Bucket)
	fmt.Println(objects)

	//--------------get object from bucket--------------
	err = client.UploadObject("my_bucket", "my_object", strings.NewReader("hello oss!"))
	if err != nil {
		log.Println("err:", err)
	}

	object, err := client.DownloadObject(cre.Bucket, "myobject")
	if err != nil {
		log.Println("err:", err)
	}
	fmt.Println(object)

	//--------------delete object of bucket--------------
	err = client.DeleteObject(cre.Bucket, "myobject")
	if err != nil {
		log.Println("err:", err)
	}
}
