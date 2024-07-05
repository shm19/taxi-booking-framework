FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . .

RUN ./mvnw package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "services/user/target/user-0.0.1-SNAPSHOT.jar"]
