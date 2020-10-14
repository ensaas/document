package main

import (
	"context"
	"fmt"
	"mime"
	"os"
	"path/filepath"

	"github.com/minio/minio-go/v7"
	"github.com/minio/minio-go/v7/pkg/credentials"
	"github.com/minio/minio-go/v7/pkg/s3utils"
)

type Blob struct {
	client *minio.Client
}

func GetObjectList() ([]string, error) {
	fmt.Println("example for using blob:", BlobPlan)

	blob, err := NewClient()
	if err != nil {
		return nil, err
	}

	if !BlobCredential.ForceV4 {
		bucketList, err := blob.standardGetBucketList()
		if err != nil {
			return nil, err
		}
		fmt.Println("bucketList:", bucketList)
		if len(bucketList) > 0 {
			BlobCredential.Bucket = bucketList[0]
			fmt.Println("we don't know the bucket name created by user, so here we use the first bucket as an example.")
		}
	}

	objectList, err := blob.getObjectList(BlobCredential.Bucket)

	if err != nil {
		return nil, err
	}
	return objectList, nil

}

func NewClient() (*Blob, error) {
	var cred *credentials.Credentials
	if BlobCredential.ForceV4 {
		cred = credentials.NewStaticV4(BlobCredential.AccessKey, BlobCredential.Secretkey, "")
	} else {
		cred = credentials.NewStaticV2(BlobCredential.AccessKey, BlobCredential.Secretkey, "")
	}
	s3Client, err := minio.New(BlobCredential.Endpoint, &minio.Options{
		Creds: cred,
		//openstack needs to connect with v2
		Secure: BlobCredential.SSL,
	})
	if err != nil {
		return nil, err
	}

	return &Blob{client: s3Client}, err
}

func (b *Blob) standardGetBucketList() ([]string, error) {
	list := []string{}
	buckets, err := b.client.ListBuckets(context.Background())
	if err != nil {
		return nil, err
	}

	for _, bucket := range buckets {
		list = append(list, bucket.Name)
	}

	return list, nil
}

func (b *Blob) getObjectList(bucketName string) ([]string, error) {
	list := []string{}
	for object := range b.client.ListObjects(context.Background(), bucketName, minio.ListObjectsOptions{}) {
		if object.Err != nil {
			return nil, object.Err
		}
		list = append(list, object.Key)
	}
	return list, nil
}

func UploadObject(bucketName, objectName, filePath, contentType string) error {
	blob, err := NewClient()
	if err != nil {
		return err
	}

	fmt.Println("===========upload", filePath, "============")

	_, err = blob.client.FPutObject(context.Background(), bucketName, objectName, filePath, minio.PutObjectOptions{ContentType: contentType})
	if err != nil {
		return err
	}

	return nil
}

func StepUploadObject(bucketName, objectName, filePath, contentType string) error {
	blob, err := NewClient()
	if err != nil {
		return err
	}

	if err := s3utils.CheckValidBucketName(bucketName); err != nil {
		fmt.Print(err)
	}
	if err := s3utils.CheckValidObjectName(objectName); err != nil {
		fmt.Print(err)
	}

	// Open the referenced file.
	fileReader, err := os.Open(filePath)
	// If any error fail quickly here.
	if err != nil {
		fmt.Print(err)
	}
	defer fileReader.Close()

	// Save the file stat.
	fileStat, err := fileReader.Stat()
	if err != nil {
		fmt.Print(err)
	}

	// Save the file size.
	fileSize := fileStat.Size()

	// Set contentType based on filepath extension if not given or default
	// value of "application/octet-stream" if the extension has no associated type.
	if contentType == "" {
		if contentType = mime.TypeByExtension(filepath.Ext(filePath)); contentType == "" {
			contentType = "application/octet-stream"
		}
	}

	info, err := blob.client.PutObject(context.Background(), bucketName, objectName, fileReader, fileSize, minio.PutObjectOptions{ContentType: contentType})
	if err != nil {
		fmt.Print(err)
	}

	fmt.Print(info)

	return nil
}

func DownloadObject(bucketName, objectFullName, filePath string) error {
	blob, err := NewClient()
	if err != nil {
		return err
	}

	fmt.Println("===========download", objectFullName, "to", filePath, "============")

	if err := blob.client.FGetObject(context.Background(), bucketName, objectFullName, filePath, minio.GetObjectOptions{}); err != nil {
		return err
	}
	return nil
}
