# shopping-mall



## 介绍

Spring Cloud + Spring Secuity + Spring Boot + MyBatis + Nacos + MySQL 



## 软件架构

微服务

**已实现：**

- 服务拆分
- 远程调用 (OpenFeign)
- 服务治理 (nacos)
- 请求路由 (gateway)
- 身份认证 (Spring Security)
- 配置管理 (nacos)

**未实现：**

- 服务保护 (Sentinel)
- 分布式事务 (Seata)
- 异步通信 (RabbitMQ)
- 消息可靠性 (RabbitMQ)
- 延迟消息 (RabbitMQ)
- 分布式搜索 (ElasticSearch)
- 倒排索引 (ElasticSearch)
- 数据聚合 (ElasticSearch)



## 环境配置

- JDK：17
- maven：3.9.10
- 虚拟机：CenOS7 （利用docker部署下述服务）
  - mysql：8.0.27
  - nacos：v2.1.0-slim

## 使用教程



1. 安装docker，并且更换源

2. 虚拟机中创建网络

   ```shell
   docker network create hm-net
   ```

3. 利用`tool-package`中的`mysql`文件夹，**部署mysql环境**。后利用sql文件创建表

   ```shell
   docker run -d \
     --name mysql \
     -p 3306:3306 \
     -e TZ=Asia/Shanghai \
     -e MYSQL_ROOT_PASSWORD=123 \
     -v /root/mysql/data:/var/lib/mysql \
     -v /root/mysql/conf:/etc/mysql/conf.d \
     -v /root/mysql/init:/docker-entrypoint-initdb.d \
     --network hm-net\
     mysql
   ```

4. 利用`tool-package`中的`nacos`文件夹，**部署nacos环境**

   ```shell
   docker run -d \
   --name nacos \
   --env-file ./nacos/custom.env \
   -p 8848:8848 \
   -p 9848:9848 \
   -p 9849:9849 \
   --restart=always \
   nacos/nacos-server:v2.1.0-slim
   ```

5. 更改源代码中的配置文件中的虚拟机IP地址和其他配置

6. 更新maven仓库

7. 在idea中配置本地启动环境`local`

## 访问地址

- `nacos`地址：http://[虚拟机IP地址]:8848/nacos
- `swagger`地址：http://[虚拟机IP地址]:8080/doc.html
- `后端服务`地址：http://[虚拟机IP地址]:8080/[路径]

## 后续

1. 服务保护和分布式事务
2. 消息队列MQ
3. ...

hm项目详细地址：https://b11et3un53m.feishu.cn/wiki/OQH4weMbcimUSLkIzD6cCpN0nvc









































