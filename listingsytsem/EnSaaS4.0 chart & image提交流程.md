## EnSaaS 4.0 chart & image 提交流程  
**App Service Tickets提交流程及需要提供的内容：**

1、App Service首次上架，请提供完整上架信息（主要包括service、serviceplan、price、metric、deployment等信息），详情请参见如下表格：

[EnSaaS 4.0 Listing Service Introduction and Template -v20200310.xlsx](https://github.com/ensaas/document/blob/master/listingsytsem/EnSaaS%204.0%20Listing%20Service%20Introduction%20and%20Template%20-v20200310.xlsx)



**其中：**

  * helmchart中README.md模板如下附件（以DataHub为例）：
[README.md](https://github.com/ensaas/document/blob/master/listingsytsem/README.md)



  * service上架时，请更新如下地址中releasenote：[http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/ReleaseNote/tree/master](http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/ReleaseNote/tree/master)；releasenote模板请见[http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/ReleaseNote/blob/master/releasenote%20template.md](http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/ReleaseNote/blob/master/releasenote%20template.md)

2、App Service已上架过，再次上架时

  * 若serviceplan、price、metric信息没有变化，则只需提供deployment信息（按（1）中deployment table提供即可）
  * 若serviceplan、price、metric信息发生变化，则需要提供service、serviceplan、price、metric、deployment等完整信息（按第（1）步中表格提供即可）

**综上：** App Service上架时，提交的tickets request中内容包括：

  * serviceName
  * chart版本及地址
  * image版本及地址
  * releasenote
  * EnSaaS 4.0 Listing Service Introduction and Template table或deployment table
  * solution类型service需要提供部署、更新、升级、退订的pipeline（跟之前3.0一样流程，在git上develop分支打tag，提供tag号）

**EnSaaS Service Tickets提交流程及需要提供的内容：**

1、EnSaaS Service需要更新image和chart，请提交 Tickets 申请，Tickets内容如下：

  * chart名称及版本：[https://harbor.arfa.wise-paas.com/harbor/projects/6/helm-charts/ensaas-routers/versions/0.1.8](https://harbor.arfa.wise-paas.com/harbor/projects/6/helm-charts/ensaas-routers/versions/0.1.8)
  * image名称及版本：harbor.arfa.wise-paas.com/lujin/ensaas-router:v-1.0.0
  * REDME.md：README.md放在helmchart中，模板如下（以DataHub为例）
[README.md](https://uploader.shimo.im/f/JoxpQ6kBZhttps://github.com/ensaas/document/blob/master/listingsytsem/README.md)



  * releasenote：模板见[http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/ReleaseNote/blob/master/releasenote%20template.md](http://advgitlab.eastasia.cloudapp.azure.com/WISE-PaaS-Documentation/ReleaseNote/blob/master/releasenote%20template.md)
  * 备注：部署依赖信息。比如部署该service，前提是否需要先部署好其他service

**App Service或EnSaaS Service提交上架信息后**

1、上架验证人员（孙迪）同步镜像到生产环境harbor  -- 此步骤可自动化

2、上架到生产环境的 chart&image 添加标签为 “未验证” 标签  -- 此步骤可自动化

![图片](https://uploader.shimo.im/f/zC6NfnQLTXcZ5o6r.png!thumbnail)

3、上架验证人员验证chart & image 的可用性后，更改标签为 “已验证” 或者 “未通过”

![图片](https://uploader.shimo.im/f/9khR76R6GlUOPZms.png!thumbnail)


* 备注：readmine project 选择 DeploymentRequest

![图片](https://uploader.shimo.im/f/RdQoq9QUj1Qzxwdo.png!thumbnail)

