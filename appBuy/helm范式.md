# 项目前瞻
appBuy是基于helm3的app生命周期管理应用。主要模块有app仓库管理（公有，私有，marketplace），app订阅、升配、升级、退订、删除管理等。在appBuy中，用户能够添加私有的app仓库进行app部署；也可以订阅我们EnSaaS提供的SRP solutions。

# Helm 范式
在appBuy中上架的helm chart必须满足如下要求：

* appBuy必要的参数

	1. **database.secretName**

		此处的secretName为 $chartname-$ns-secret  如dashboard-ns1-secret
		
		在app上架到被订阅部署时，根据上架的信息，appbuy会自动为每个app生成一个db secret   信息（无论此app依赖多少db都只会生成一个secret）。在app的chart中需要获取这个secret的名称
		
		values.yaml
		
		![图片](https://uploader.shimo.im/f/mBuVWm2v6V08Rvde.png!thumbnail)
		
		template/deployment.yaml
		
		![图片](https://uploader.shimo.im/f/iCaWo2evzSMS3yt4.png!thumbnail)

	2. **url.host**

		此处的url.host为ingress的host后缀。例如：**.$ns.$cluster.internal**
		
		values.yaml
		
		![图片](https://uploader.shimo.im/f/DBqmknB7ncEekBS3.png!thumbnail)
		
		 Ingress.enable上架时需要开启。
		
		Ingress.hosts[0].host只需写上该服务想要暴露的url前缀即可
		
		ingress.yaml
		
		![图片](https://uploader.shimo.im/f/nke1FHzNFuE9t3A5.png!thumbnail)
		
		![图片](https://uploader.shimo.im/f/MvfQM5xy6fYmRXlI.png!thumbnail)
		
		先定义一个变量获取values.yaml中的url.host参数
		
		再修改ingress.hosts[0].host为拼接自定url前缀+平台覆盖url后缀

* 平台必须的参数

	平台必须要在helm chart里定义sources，内容如下：
	
	![图片](https://uploader.shimo.im/f/B8l9DLStqCstYrJh.png!thumbnail)
	
	 每个container必须定义配额，否则helm安装会失败，pod无法建立。
	
	 建议大家把resources.requests填写的尽可能的低，提高平台资源利用率。


