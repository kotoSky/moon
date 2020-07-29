# Dockerfile
# 基于的镜像
FROM openjdk:8-jdk-alpine

MAINTAINER kotoSky <kotoSky@163.com>

WORKDIR /

VOLUME /home/docker/java/logs

#ARG JAR_FILE
ADD target/*.jar app.jar

# 对外端口
EXPOSE 8081

# -Djava.security.egd=file:/dev/./urandom 可解决tomcat可能启动慢的问题
# 具体可查看：https://www.cnblogs.com/mightyvincent/p/7685310.html
ENTRYPOINT ["java","-jar","/app.jar"]