FROM openjdk:15-jdk-alpine

ARG JAR_FILE=target/basicservice.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar