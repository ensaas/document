## App订阅或部署失败

App没有成功部署，主要有两种情况，一是App订阅失败，二是App订阅成功（即UI上显示订阅成功），但部署失败。其中，App订阅失败，较好排查，一般通过UI就可以看出；App订阅成功，部署失败，需要排查服务的log信息，才能确定失败原因。以下主要列出常见的几种App订阅或部署失败原因。

- 订阅号User订阅App失败  

    - 由于只有订阅号下的Admin用户及Gloabl Admin用户可以订阅App，订阅号下的User用户订阅App时，UI会提示如下错误
 
       ![subscription user](/image/subscription-user.png)
     
    - 解决方法

      - 使用订阅号下的Admin用户订阅App（可通过SSO Portal查看订阅号下的Admin用户）

        ![subscribe admin](/image/subscribe-admin.png)

      - 修改订阅号下的User为Admin用户，然后订阅App（企业账号Admin有权限修改）

        ![modify subscribe role](/image/modify-subscribe-role.png)

- 未付费用户且非内部用户订阅App失败

    - 此种情况，UI会提示如下错误

         ![ispaid=false](/image/ispaid=false.png)

    - 解决方法

      - 首先通过SSO Protal查看订阅号付费类型，如图

          ![ssodetail](/image/ssodetail.png)

      - 结合上一步，若Is Paid=No，Is Internal=No，则符合未付费用户且非内部用户订阅App失败这种情况，请联系WISE-PaaS.SRE（WISE-PaaS.SRE@advantech.com）进行订阅部署

- 付费用户，点数不足，导致订阅App失败

    - 此种情况，UI会提示如下错误

       ![ispaid=true, wp is not enough](/image/ispaid=truewp-is-not-enough.png)

    - 解决方法

        请联系WISE-PaaS.SRE（WISE-PaaS.SRE@advantech.com）充加点数，再进行订阅App。

- 空间资源不足，导致订阅App失败  

    - 此种情况，选择部署的workspace或namespace时，UI会提示如下错误

       ![resources is not enough](/image/resources-is-not-enough.png)

    - 解决方法

      - 若购买的是Dedicated Cluster，请自行对工作空间进行扩容，操作手册请参考：https://docs.wise-paas.advantech.com/zh-CN/Guides_and_API_References/Cloud_Services/1589509684297039988/1589890089018143254/v1.0.0   

      - 若购买的General Workspace，目前请联系WISE-PaaS.SRE（WISE-PaaS.SRE@advantech.com）对General Workspace进行扩容（扩容相当于加购General Workspace，这部分需要收费）。后续会有UI界面支持用户自主对General Workspace扩容

- 除上述情况，订阅App时，UI提示如下错误，请联系WISE-PaaS.SRE（WISE-PaaS.SRE@advantech.com）解决
    - UI上提示400，listing system get service Plan failed，具体如下图

         ![clienttoken失效-listing](/image/clienttoken失效-listing.png)

    - UI上提示500，按F12，查看api response返回order create failed，具体如下图

         ![clinettoken失效-order](/image/clinettoken失效-order.png)

    - UI上提示 The App has failed to subscribe，没有明确错误码信息，具体如下图

        ![createorder失败](/image/createorder失败.png)

    - UI上提示Account not found in mkp，具体如下图

       ![crmid is not in mkp](/image/crmid-is-not-in-mkp.png)

    - UI上提示service name had been subscribed，具体如下图

       ![app is subscribe](/image/app-is-subscribe.png)

- 当App订阅成功后，即UI上已经提示如下图信息，等待5min左右，namespace仍然没有部署订阅的App，那么App可能已经部署失败了。App部署失败，需要去排查Catalog api及Appbuy api的log信息，才能得出App部署失败的确切原因。

     ![subscription success](/image/subscription-success.png)

    - App部署失败常见的几种情况
        - 空间资源不够
        - DB serviceinstance已关联过该App
        - DB serviceinstance不存在
        - 该namespace已存在某些资源（之前删除不干净）
        - chart不存在
        - helm部署超时
        - 获取mp config失败

    - 解决方法

        若App部署失败，请联系WISE-PaaS.SRE（WISE-PaaS.SRE@advantech.com）解决，并说明Appbuy订阅及部署情况。

注：上述仅列出了常见的App订阅或部署失败原因，如果在App订阅过程中还遇到其他问题，请联系WISE-PaaS.SRE（WISE-PaaS.SRE@advantech.com），并说明订阅情况。
