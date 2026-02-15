# shopping-mall

## Introduction

Spring Cloud + Spring Security + Spring Boot + MyBatis + Nacos + MySQL

## Software Architecture

Microservices architecture

**Implemented:**

- Service decomposition
- Remote calls (OpenFeign)
- Service governance (Nacos)
- Request routing (Gateway)
- Authentication & authorization (Spring Security)
- Configuration management (Nacos)

**Not Implemented Yet:**

- Service protection (Sentinel)
- Distributed transactions (Seata)
- Asynchronous communication (RabbitMQ)
- Message reliability (RabbitMQ)
- Delayed messages (RabbitMQ)
- Distributed search (ElasticSearch)
- Inverted index (ElasticSearch)
- Data aggregation (ElasticSearch)

## Environment Setup

- JDK: 17  
- Maven: 3.9.10  
- Virtual Machine: CentOS 7 (services below are deployed using Docker)
  - MySQL: 8.0.27  
  - Nacos: v2.1.0-slim  

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









































