# Build spring boot app
FROM openjdk:17-alpine

RUN mkdir -p /app

WORKDIR /app

COPY . .

RUN ./mvnw package -DskipTests
RUN mv target/*.jar target/portfolio-0.0.1-SNAPSHOT.jar

WORKDIR /app/target

ENTRYPOINT ["java", "-jar", "/portfolio-0.0.1-SNAPSHOT.jar"]
