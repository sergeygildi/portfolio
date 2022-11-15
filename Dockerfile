# Build spring boot app
FROM maven:3.8.3-openjdk-17-slim AS builder
COPY pom.xml /portfolio/
COPY src /portfolio/src
RUN --mount=type=cache,target=/root/.m2 mvn -f /portfolio/pom.xml clean package -DskipTests

FROM openjdk:17-slim
COPY --from=builder /portfolio/target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
