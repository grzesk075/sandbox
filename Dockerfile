#
# Build stage
#
FROM maven:3.6-jdk-13 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:13
COPY --from=build /home/app/target/sandbox*.jar /usr/local/lib/sandbox.jar
EXPOSE 5005
ENTRYPOINT ["java","--enable-preview","-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005","-cp","/usr/local/lib/sandbox.jar","pl.grzesk075.sandbox.java.Java13Tutorial"]