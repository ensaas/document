package blob

import (
	"log"
	"simple_code/golang/properties"
	"testing"
)

func TestNewBlobClient(t *testing.T) {
	credentials := &properties.Credentials{
		Endpoint:  "",
		AccessKey: "",
		Secretkey: "",
	}
	client, err := NewBlobClient(credentials)
	if err != nil {
		log.Println(err)
	}

	//containers, err := client.ListContainer()
	//if err != nil {
	//	log.Println("err:", err)
	//}
	//fmt.Println(containers)

	//err = client.CreateContainer("mycontainer")
	//if err != nil {
	//	log.Println("err:", err)
	//}

	//err = client.DeleteContainer("mycontainer")
	//if err != nil {
	//	log.Println("err:", err)
	//}

	//blobs, err := client.ListBlob("mycontainer")
	//if err != nil {
	//	log.Println("err:", err)
	//}
	//fmt.Println(blobs)

	//err = client.UploadBlob("mycontainer", "myblob", bytes.NewReader([]byte("hello blob!")))
	//if err != nil {
	//	log.Println(err)
	//}

	//body, err := client.DownloadBlob("mycontainer", "myblob")
	//if err != nil {
	//	log.Println("err:", err)
	//}
	//data, err := ioutil.ReadAll(body)
	//if err != nil {
	//	//HandleError(err)
	//}
	//fmt.Println(string(data))

	err = client.DeleteBlob("mycontainer", "myblob")
	if err != nil {
		log.Println("err:", err)
	}

}
