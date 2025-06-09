# Use a lightweight OpenJDK 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy everything from your springboot project root (where pom.xml lives)
COPY . .

# Run Maven wrapper to build the project (skip tests)
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on (usually 8080)
EXPOSE 8080

# Run the Spring Boot app on container start
CMD ["java", "-jar", "target/springboot-0.0.1-SNAPSHOT.jar"]
