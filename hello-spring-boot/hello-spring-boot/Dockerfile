FROM openjdk:21

ARG JAR_FILE=target/hello-spring-boot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "/app.jar", "--server.port=80"]
