# Use the official OpenJDK 17 runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file
COPY pom.xml /app

# Copy the source code into the container
COPY src /lab3_1/src

# Install Maven and build the application
RUN apk add --no-cache maven \
    && mvn dependency:resolve \
    && mvn package -DskipTests \
    && mv target/*.jar app.jar

# Expose the Spring Cloud Config Server port
EXPOSE 8888

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]