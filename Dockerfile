FROM gradle:8.5-jdk17 AS builder

WORKDIR /auklglsqincnfqquekkn

COPY ./ .

RUN gradle clean build

CMD ["java", "-jar", "app.jar"]