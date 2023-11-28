
# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/AWSSpringbootDemo-0.0.1-SNAPSHOT.jar AWSSpringbootDemo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "AWSSpringbootDemo.jar"]
