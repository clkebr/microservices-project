# Use an official Maven image as a build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy the POM file and download dependencies
COPY order-service/pom.xml .
RUN mvn -B -f pom.xml dependency:resolve

# Copy the application source code
COPY order-service/src src/

# Build the application
RUN mvn -B package -DskipTests

# Use an official OpenJDK runtime image as a base image
FROM eclipse-temurin:17.0.4.1_1-jre
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/order-service.jar .

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "order-service.jar"]
