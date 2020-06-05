FROM jenkins/jenkins:latest
USER root
RUN apt-get update
RUN apt-get install -y maven
RUN apt-get install -y curl
RUN mkdir /java
RUN cd /java && \
    curl -o jdk.tgz https://download.java.net/openjdk/jdk14/ri/openjdk-14+36_linux-x64_bin.tar.gz && \
    tar -xvf jdk.tgz
USER jenkins