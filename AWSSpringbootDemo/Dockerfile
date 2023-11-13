# Use the official Maven image to build the application
FROM maven:3.8.1-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven POM file
COPY pom.xml .

# Download the Maven dependencies (cached separately to improve build speed)
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package

# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim AS runtime

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage to the runtime image
COPY --from=build /app/target/AWSSpringbootDemo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
