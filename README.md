# Services Add Inventory

## Description
This microservice allows adding inventory items to the system using a REST API. It is built with Java and Spring Boot, utilizing a relational database.

## Prerequisites
Ensure you have the following installed:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Environment Variables
Create a `.env` file in the root directory and configure the required variables:

## Installation
1. Build the project using Maven:
   ```sh
   mvn clean install
   ```

2. Run the service:
   ```sh
   mvn spring-boot:run
   ```

## Running with Docker
1. Build the Docker image:
   ```sh
   docker build -t services-add-inventory .
   ```

2. Run the container:
   ```sh
   docker run -p 8081:8080 --env-file .env services-add-inventory
   ```

3. Alternatively, use Docker Compose:
   ```sh
   docker-compose up --build
   ```

## API Documentation
This service provides API documentation via Swagger. Once the service is running, access it at:
```
http://localhost:5050/swagger-ui/index.html
```

## Database Setup
Ensure you have a MySQL database running. If using Docker, you can spin up a MySQL container with:
```sh
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=your_root_password -e MYSQL_DATABASE=your_database_name -e MYSQL_USER=your_database_user -e MYSQL_PASSWORD=your_database_password -p 3306:3306 -d mysql:latest
```

## Testing
Currently, no test scripts are defined. You may add tests and run them using:
```sh
mvn test
```

## Authors
Cadena Anggelo and Caiza Katherine
