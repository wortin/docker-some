FROM java:8
MAINTAINER com.wortin
WORKDIR /usr/local/apps/docker-some
ADD target/docker-some-0.0.1-SNAPSHOT.jar docker-some.jar
EXPOSE 8091
ENTRYPOINT ["nohup", "java", "-jar", "docker-some.jar","&"]