FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git

WORKDIR ekholabs

RUN git clone https://github.com/ekholabs/elsie-dee
WORKDIR elsie-dee
RUN ./gradlew clean build

ENV ELSIE_DEE_PORT=80

EXPOSE $ELSIE_DEE_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "build/libs/elsie-dee-1.0-SNAPSHOT.jar"]
