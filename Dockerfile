from blueuninfo-registry.com:5000/oracle-java-font:8
MAINTAINER yueyu <yueyu@blueuninfo.com>
ENV LANG=en_US.UTF-8
ENV TZ=Asia/Shanghai
workdir /
add op-service.jar op.jar
arg active
run echo "${active}"
arg active
#"-Dspring.profiles.active=train"
cmd ["java","-jar","/op.jar"]