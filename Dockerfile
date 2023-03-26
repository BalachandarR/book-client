FROM openjdk:8-jdk-alpine
MAINTAINER Bala Rangasamy And Prnauv Bala
COPY target/book-client-0.0.1-SNAPSHOT.jar book-client-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/book-client-0.0.1-SNAPSHOT.jar"]