FROM openjdk:8-jre-alpine

WORKDIR /app

COPY . .

RUN ./portal/mvnw package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "services/user/target/user-0.0.1-SNAPSHOT.jar"]
