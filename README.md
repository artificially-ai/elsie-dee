# Elsie-Dee

Elsie-Dee is a Spring application user as a wrapper for the Carnegie Mellon University famous Sphinx4 Speech-to-Text library.

* [Sphynx4](https://github.com/cmusphinx/sphinx4)

Although Elsie-Dee is currently under development, it can already be used to process small files.

# Technology Stack

Elsie-Dee is comprised of the following technology stack:

* Gradle
* Java 8
* Spring Boot
* Spring Web
* Spring Actuator
* Sphynx4

# Running from Source

In order to run Elsie-Dee, please follow the steps below:

1. ```git clone https://github.com/ekholabs/elsie-dee.git```
2. ```cd elsie-dee```
3. ```./gradlew clean build```
4. ```./gradlew bootRun```

# Running with Docker

1. ```docker pull ekholabs/elsie-dee:alpha2```
2. ```docker run -d -p 80:80 elsie-dee```

Elsie-Dee will run on the background. To check details about the container, execute the following:

* ```docker ps```

For logs:

* ```docker logs [container_id]```

# Actuator Endpoints

Once the application is running, the user/developer can find health status and metrics via the following endpoints:

* http://localhost/elsie-dee/health
* http://localhost/elsie-dee/metrics
* http://localhost/elsie-dee/env

#Processing Audio Files

In order to process audio files and extract text, one can use the ```/process``` endpoint with Postman or cURL.

##Postman

[wip] - need screenshots

##cURL

* ```curl -v -F input=@[path_to_file] http://localhost/elsie-dee/process```