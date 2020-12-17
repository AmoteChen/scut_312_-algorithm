### Tomcat调优：maxHttpHeader问题

现象：web应用使用中，突然白屏，显示该网页无法正常运作，**状态码400**，必须重启浏览器才能访问。

问题：客户端浏览器所发送的请求的请求头过大，超出了tomcat默认的请求头最大限制，因此服务器返回 400 bad request

解决：修改服务端的tomcat的配置文件中的server.xml，在connector标签中插入maxHttpHeaderSize="1048576"

就可以解决。（也就是把最大请求头设置为1MB）

默认的请求头大小是 8*1024  8k