package minio

import (
	"context"
	"fmt"
	"github.com/minio/minio-go/v7"
	"github.com/minio/minio-go/v7/pkg/credentials"
	"io"
	"log"
	"simple_code/golang/properties"
)

type Bucket struct {
	client *minio.Client
}

func NewMinioClient(param *properties.Credentials) (b Bucket, err error) {
	var credential *credentials.Credentials
	if param.ForceV4 {
		credential = credentials.NewStaticV4(param.AccessKey, param.Secretkey, "")
	} else {
		credential = credentials.NewStaticV2(param.AccessKey, param.Secretkey, "")
	}

	b.client, err = minio.New(param.Endpoint, &minio.Options{
		Creds: credential,
		//openstack needs to connect with v2
		Secure: param.SSL,
	})
	if err != nil {
		log.Println(err)
	}
	return b, err
}

func (b *Bucket) ListBucket() (buckets []string, err error) {
	results, err := b.client.ListBuckets(context.Background())
	if err != nil {
		//HandleError(err)
		log.Println(err)
	}
	for _, result := range results {
		buckets = append(buckets, result.Name)
	}
	return buckets, err
}

func (b *Bucket) CreateBucket(bucketName string) error {
	err := b.client.MakeBucket(context.Background(), bucketName, minio.MakeBucketOptions{})
	if err != nil {
		//HandleError(err)
	}
	return err
}

func (b *Bucket) DeleteBucket(bucketName string) error {
	err := b.client.RemoveBucket(context.Background(), bucketName)
	if err != nil {
		//HandleError(err)
	}
	return err
}

func (b *Bucket) ListObject(bucketName string) (objects []string) {
	var results <-chan minio.ObjectInfo
	results = b.client.ListObjects(context.Background(), bucketName, minio.ListObjectsOptions{})
	for result := range results {
		objects = append(objects, result.Key)
	}
	return objects
}

func (b *Bucket) UploadObject(bucketName string, objectName string, reader io.Reader) error {
	rsp, err := b.client.PutObject(context.Background(), bucketName, objectName, reader, -1, minio.PutObjectOptions{})
	if err != nil {
		//HandleError(err)
	}
	fmt.Println(rsp, "--------------------------")
	return err
}

func (b *Bucket) DownloadObject(bucketName string, objectName string) (object *minio.Object, err error) {
	object, err = b.client.GetObject(context.Background(), bucketName, objectName, minio.GetObjectOptions{})
	if err != nil {
		//HandleError(err)
	}
	return object, err
}

func (b *Bucket) DeleteObject(bucketName string, objectName string) error {
	err := b.client.RemoveObject(context.Background(), bucketName, objectName, minio.RemoveObjectOptions{})
	if err != nil {
		//HandleError(err)
	}
	return err
}
