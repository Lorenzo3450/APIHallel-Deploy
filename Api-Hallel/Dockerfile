# Etapa 1: Build
FROM maven:3.8.6-openjdk-19 AS build
LABEL authors="Lorenzo"

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo de configuração e dependências primeiro para otimizar o cache
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copia o restante do código-fonte
COPY src ./src

# Executa o build
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:19-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Expondo a porta 8080
EXPOSE 8080

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/Api-Hallel-0.0.1-SNAPSHOT.jar app.jar

# Comando de inicialização
ENTRYPOINT [ "java", "-jar", "app.jar" ]
