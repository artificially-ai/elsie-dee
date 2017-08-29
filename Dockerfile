FROM openjdk:jre-alpine

RUN apk update && apk add vim procps

COPY build/libs/elsie-dee-1.0-SNAPSHOT.jar /ekholabs/elsie-dee.jar

WORKDIR ekholabs

ENV CONFIGURATION_SERVER_HOST_NAME=configuration-service
ENV EUREKA_SERVICE_HOST_NAME=eureka-service
ENV CONFIGURATION_SERVER_PORT=8082
ENV EUREKA_SERVICE_PORT=8083

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "elsie-dee.jar"]
