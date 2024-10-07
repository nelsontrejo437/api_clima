FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/Seguridad-0.0.1.jar
COPY ${JAR_FILE} app_clima.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app_clima.jar"]