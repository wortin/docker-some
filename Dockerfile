FROM java:8
MAINTAINER com.wortin
WORKDIR /usr/local/apps/docker-some
ADD target/docker-some-0.0.1-SNAPSHOT.xjar docker-some.jar
ADD target/booter booter
EXPOSE 8091
ENTRYPOINT ["nohup", "./booter", "java", "-jar", "docker-some.jar","&"]