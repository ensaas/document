### MpBuy 2.0.1.7 - (2020-11-16)

Added:
- 支持license(部署成功后调用GET: /v1/license/info 查看，invalidTimes 为0 表示成功)
Fixed:
- 修改cluster 扩容后无法更新pn信息的bug
- 修改订阅workspace,检验cluster cpu资源时计算bug
