FROM openjdk:19-jdk-slim AS build

# Atualiza e instala o Maven
RUN apt-get update && apt-get install maven -y

# Copia o conteúdo do diretório local para o diretório correto dentro do container
COPY . /Api-Hallel

# Defina o diretório de trabalho onde o pom.xml está
WORKDIR /Api-Hallel

# Executa o Maven para compilar o projeto
RUN mvn clean install

FROM openjdk:19-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o JAR gerado para o contêiner final
COPY --from=build /Api-Hallel/target/Api-Hallel-0.0.1-SNAPSHOT.jar app.jar

# Define o comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
