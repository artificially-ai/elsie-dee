FROM debian:latest
RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven gradle git

WORKDIR source

EXPOSE 80

RUN git clone https://github.com/ekholabs/sphinx4.git

WORKDIR sphinx4

RUN gradle build

WORKDIR source

RUN git clone https://github.com/ekholabs/elsie-dee

WORKDIR elsie-dee

RUN gradle build && gradle bootRun