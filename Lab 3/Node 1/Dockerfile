FROM openjdk:17-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=out/artifacts/b1_jar/b1.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]