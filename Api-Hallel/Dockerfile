FROM openjdk:19-jdk-slim AS build

RUN apt-get update && apt-get install maven -y

COPY . .

RUN mvn clean install

FROM openjdk:19-jdk-slim

EXPOSE 8080

COPY --from=build /target/Api-Hallel-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
