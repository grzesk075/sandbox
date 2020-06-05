FROM jenkins/jenkins:latest
USER root
RUN apt-get update
RUN apt-get install -y maven
RUN apt-get install -y curl
RUN mkdir /java
RUN cd /java && \
    curl -o jdk.tgz https://download.java.net/openjdk/jdk13/ri/openjdk-13+33_linux-x64_bin.tar.gz && \
    tar -xvf jdk.tgz
USER jenkins