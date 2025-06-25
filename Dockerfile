# Use a lightweight JDK base image
FROM eclipse-temurin:21-jdk-alpine

# Set app directory
WORKDIR /app

# Copy the jar file built by Maven
COPY target/ZuvocloudAutomotive-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
