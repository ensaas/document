@[TOC](Kong是否可以跨Kubernetes集群使用？)
# Kong 的solutions
- [kong](https://konghq.com/kong/) 有三个solution
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190712143051669.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMzA1MTAz,size_16,color_FFFFFF,t_70)
# Kong api gateway 架构图
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019071214323459.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMzA1MTAz,size_16,color_FFFFFF,t_70)
# Kubernetes Ingress Controller for Kong 架构
- 架构图
![db-deployment](https://img-blog.csdnimg.cn/20190712140434998.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMzA1MTAz,size_16,color_FFFFFF,t_70)
- kubernetes中数据访问
![on-k8s](https://img-blog.csdnimg.cn/20190712140850944.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMzA1MTAz,size_16,color_FFFFFF,t_70)
# Kubernetes Ingress Controller for Kong 的组成

 [Kubernetes Ingress Controller for Kong](https://github.com/Kong/kubernetes-ingress-controller) 的yaml有三部分。
[kong-ingress.yaml](https://bit.ly/kong-ingress)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191015175446437.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwMzA1MTAz,size_16,color_FFFFFF,t_70)

1. kong 的Deployment 中有一个container（kong-proxy）
	
	> kong-proxy:  作为数据平面的组件承担处理转发请求的任务
	
2. kong-ingress-controller 的Deployment中有两个container（admin-api 、ingress-controller）
	> admin-api : 开启了admin监听端口，它只作为控制平面的组件，接受ingress-controller容器下发的控制指令，不承担数据平面的处理任务;  
	
	> ingress-controller : 监听Kubernetes中的资源变化，及时向kong的控制平面，也就是它的参数--publish-service=kong/kong-proxy指定的地址发送控制指令

# 结论
Kubernetes Ingress Controller for Kong 无发使用自定义资源定义（CRD）跨kubernetes集群进行服务转发。但Kong api gateway可以跨云使用。
后续：使用kong + consul 进行多集群服务发现注册
