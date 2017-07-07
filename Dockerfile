FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git vim procps

COPY build/libs/elsie-dee-1.0-SNAPSHOT.jar /ekholabs/elsie-dee.jar

WORKDIR ekholabs

ENV ELSIE_DEE_PORT=80
ENV CONFIGURATION_SERVER_HOST_NAME=configurtion-service
EXPOSE $ELSIE_DEE_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "elsie-dee.jar"]
