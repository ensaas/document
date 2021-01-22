package blob

import (
	"context"
	"fmt"
	"github.com/Azure/azure-storage-blob-go/azblob"
	"io"
	"log"
	"net/url"
	"simple_code/golang/properties"
	"strings"
)

type Blob struct {
	ServiceUrl *azblob.ServiceURL
}

//endpoint: blob.core.chinacloudapi.cn
//endpoint: blob.core.windows.net
func NewBlobClient(cre *properties.Credentials) (blob Blob, err error) {
	var rawUrl string
	if strings.HasPrefix(cre.Endpoint, "blob.") {
		rawUrl = fmt.Sprintf("https://%s.%s/", cre.AccessKey, cre.Endpoint)
	} else {
		rawUrl = fmt.Sprintf("https://%s.blob.%s/", cre.AccessKey, cre.Endpoint)
	}
	credential, err := azblob.NewSharedKeyCredential(cre.AccessKey, cre.Secretkey)
	if err != nil {
		//HandleError(err)
		return blob, err
	}
	uRL, _ := url.Parse(rawUrl)
	p := azblob.NewPipeline(credential, azblob.PipelineOptions{})
	serviceUrl := azblob.NewServiceURL(*uRL, p)
	blob.ServiceUrl = &serviceUrl
	return blob, err
}

func (blob *Blob) ListContainer() (containers []string, err error) {
	response, err := blob.ServiceUrl.ListContainersSegment(context.Background(), azblob.Marker{}, azblob.ListContainersSegmentOptions{})
	if err != nil {
		//HandleError(err)
		log.Println("err:", err)
		return nil, err
	}
	//fmt.Println(response, "---------------------------------------------------")
	if len(response.ContainerItems) > 0 {
		for _, item := range response.ContainerItems {
			containers = append(containers, item.Name)
		}
	}
	return containers, err
}

func (blob *Blob) CreateContainer(containerName string) error {
	containerUrl := blob.ServiceUrl.NewContainerURL(containerName)
	_, err := containerUrl.Create(context.Background(), azblob.Metadata{}, azblob.PublicAccessNone)
	if err != nil {
		//HandleError(err)
	}
	return err
}

func (blob *Blob) DeleteContainer(containerName string) error {
	containerUrl := blob.ServiceUrl.NewContainerURL(containerName)
	_, err := containerUrl.Delete(context.Background(), azblob.ContainerAccessConditions{})
	if err != nil {
		//HandleError(err)
	}
	return err
}

func (blob *Blob) ListBlob(containerName string) (blobs []string, err error) {
	containerUrl := blob.ServiceUrl.NewContainerURL(containerName)
	response, err := containerUrl.ListBlobsFlatSegment(context.Background(), azblob.Marker{}, azblob.ListBlobsSegmentOptions{})
	if err != nil {
		//HandleError(err)
	}
	if response != nil {
		for _, blob := range response.Segment.BlobItems {
			blobs = append(blobs, blob.Name)
		}
	}
	return blobs, err
}

//strings.NewReader("")
func (blob *Blob) UploadBlob(containerName, blobName string, body io.ReadSeeker) (error) {
	containerUrl := blob.ServiceUrl.NewContainerURL(containerName)
	blobUrl := containerUrl.NewBlockBlobURL(blobName)
	//ctx context.Context, body io.ReadSeeker, h BlobHTTPHeaders, metadata Metadata, ac BlobAccessConditions
	rsp, err := blobUrl.Upload(context.Background(), body, azblob.BlobHTTPHeaders{}, nil,
		azblob.BlobAccessConditions{}, azblob.DefaultAccessTier, azblob.BlobTagsMap{})
	if err != nil {
		//HandleError(err)
	}
	fmt.Println(rsp)
	return err
}

func (blob *Blob) DownloadBlob(containerName string, blobName string) (msg io.ReadCloser, err error) {
	containerUrl := blob.ServiceUrl.NewContainerURL(containerName)
	blobUrl := containerUrl.NewBlockBlobURL(blobName)
	rsp, err := blobUrl.Download(context.Background(), 0, 0, azblob.BlobAccessConditions{}, false)
	if err != nil {
		//HandleError(err)
		return nil, err
	}
	return rsp.Response().Body, err
}

func (blob *Blob) DeleteBlob(containerName string, blobName string) (error) {
	containerUrl := blob.ServiceUrl.NewContainerURL(containerName)
	blobUrl := containerUrl.NewBlockBlobURL(blobName)
	rsp, err := blobUrl.Delete(context.Background(), azblob.DeleteSnapshotsOptionNone, azblob.BlobAccessConditions{})
	if err != nil {
		//HandleError(err)
	}
	fmt.Println(rsp)
	return err
}
