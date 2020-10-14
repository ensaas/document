FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY /charts /charts
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]