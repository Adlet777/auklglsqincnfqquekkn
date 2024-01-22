#FROM gradle:8.5-jdk17 AS builder
#WORKDIR /auklglsqincnfqquekkn
#COPY ./ .
#RUN gradle clean build
#
#COPY build/libs/auklglsqincnfqquekkn-0.0.1-SNAPSHOT.jar app.jar
#COPY src/main/resources/application.yml application.yml
#
#CMD ["java", "-jar", "app.jar"]