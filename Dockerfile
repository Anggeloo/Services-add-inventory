FROM openjdk:17-jdk-slim
ARG JAR_FILE="target/app_microservices_add_inventory-0.0.1.jar"
COPY ${JAR_FILE} app_iventory_add.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app_iventory_add.jar"]
