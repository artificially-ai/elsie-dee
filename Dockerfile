FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven gradle git

WORKDIR ekholabs

RUN git clone https://github.com/ekholabs/sphinx4.git
WORKDIR sphinx4
RUN gradle clean build

RUN git clone https://github.com/ekholabs/elsie-dee
WORKDIR elsie-dee
RUN gradle clean build

COPY build/libs/elsie-dee-1.0-SNAPSHOT.jar ./elsie-dee.jar

EXPOSE 80

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx1G", "-jar", "elsie-dee.jar"]