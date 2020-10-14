package main

import (
	"fmt"
	"net/http"
)

func main() {
	if err := GetEnv(); err != nil {
		fmt.Println("get env error:", err)
	}

	fmt.Println("******list object of bucket", BlobCredential.Bucket)
	objectList, err := GetObjectList()
	if err != nil {
		fmt.Println("get object list error:", err)
	}
	fmt.Println("******objectList:", objectList)

	fmt.Println("******put a yaml file to first bucket as example.")
	if err := UploadObject(BlobCredential.Bucket, "values.yaml", "./charts/values.yaml", "text/plain"); err != nil {
		fmt.Println("upload error:", err)
	}

	fmt.Println("******get first file from first bucket as example.")
	if err := DownloadObject(BlobCredential.Bucket, objectList[0], objectList[0]); err != nil {
		fmt.Println("download error:", err)
	}

	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "")
	})

	http.ListenAndServe(":8080", nil)
}
