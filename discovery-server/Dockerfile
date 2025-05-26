# Use a lightweight base image with Java
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR from your host to the container
COPY target/discovery-server-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app uses (e.g., 8761 for Eureka)
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
