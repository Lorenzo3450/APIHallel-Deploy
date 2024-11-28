# Etapa de build
FROM openjdk:19-jdk-slim AS build

# Atualiza e instala o Maven
RUN apt-get update && apt-get install maven -y

# Defina o diretório de trabalho onde o pom.xml está localizado
WORKDIR /Api-Hallel

# Copia o conteúdo do diretório atual (onde o pom.xml está) para o diretório de trabalho do container
COPY . /Api-Hallel

# Executa o Maven para compilar o projeto
RUN mvn clean install

# Etapa final (para o ambiente de execução)
FROM openjdk:19-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o JAR gerado da etapa anterior para o contêiner final
COPY --from=build /Api-Hallel/target/Api-Hallel-0.0.1-SNAPSHOT.jar app.jar

# Define o comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
