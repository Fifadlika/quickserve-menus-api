# Stage 1: Build aplikasi dengan Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml dan download dependencies
COPY pom.xml .

# Copy source code dan build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run aplikasi
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy JAR dari stage build
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8088

# Run aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]