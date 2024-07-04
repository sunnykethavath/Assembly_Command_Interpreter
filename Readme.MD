# <h1 align = "center"> Assembly Language Command Interpreter </h1>
<p align = "center"> 
<a href = "https://go.dev">  
    <img alt = "Java" src="https://img.shields.io/badge/Java-21-orange.svg">
</a>
<a href = "https://docs.gofiber.io">  
    <img alt = "Maven" src="https://img.shields.io/badge/maven-3.5.3-green.svg">
</a>
<a href = "https://gorm.io/index.html">  
    <img alt = "SpringBoot" src="https://img.shields.io/badge/SpringBoot-3.3.1-blue.svg">
</a>
</p>

<p align="left">

## Overview

This project is a Assembly Language Command Interpreter that allows users to give move , add and show register commands in assembly language and in backend java will be interpreting the information and gives back the result.

## Prerequisites
 * Java Development Kit (JDK) 
 *  Maven build tool
 *  Docker Desktop (for Docker deployment)
 *  MySQL server (if not using Docker for MySQL)
 
## Dependencies
 * Spring Web
 * Spring Data JPA
 * lombok
 * MySQL Driver

 ## Getting Started
 ### Clone the Repository

```bash
git clone https://github.com/sunnykethavath/Assembly_Command_Interpreter.git
```

### Configuration

**Database Configuration:**

1. Open `application.properties` file located in `<project_directory>/src/main/resources`.
2. Modify the database connection settings:
```bash
spring.datasource.url=jdbc:mysql://<mysql_host>:<mysql_port>/<database_name>
spring.datasource.username=<mysql_username>
spring.datasource.password=<mysql_password>
```
Replace `jdbc:mysql://localhost:3306/mydatabase` with your actual database URL, `myusername` with your database username, and `mypassword` with your database password.

### Build and run
```bash
mvn clean package
mvn install package
```

### Build docker image
```bash
docker pull mysql:latest
docker build -t <springboot_application_image_name>:<version> .
```

### Run MySQL docker container
```bash
docker run -p <port_you_want_to_expose:3306> --name <mysql_container_name> -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=<database_name> <mysql_image>
```
### Create network and connect MySQL container
```bash
docker network create <network_name> 
docker network connect <network_name> <mysql_container_name>
```

### Run SpringBoot application docker container and connect to network
```bash
docker run -p <port_you_want_to_expose:8080> --name <springboot_application_container_name> --net <network_name> -e MYSQL_HOST=<mysql_container_name> -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 <springboot_application_image_name>:<version>
```

## Usage
### Postman URL
```bash
https://localhost:<port>/execute
```
### For example
 * Request
 ```bash
 MV REG1 #6000
MV REG2 #1500
MV REG3 #1500
ADD REG1 REG3
ADD REG1 REG2
SHOW REG
 ```
 * Response
 ```bash
 REG2:1500,REG3:1500,REG1:9000
 ```




 