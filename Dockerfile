FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre vim procps curl

COPY build/libs/elsie-dee-1.0-SNAPSHOT.jar /ekholabs/elsie-dee.jar

WORKDIR ekholabs

ENV CONFIGURATION_SERVER_HOST_NAME=configuration-service
ENV CONFIGURATION_SERVER_PORT=8082

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "elsie-dee.jar"]
