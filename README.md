<div align="center">
  <br />
  <img src=".github/banner.png" width="546" alt="To Do List" /></a>
  <br />
  <p>
    <img src="https://img.shields.io/badge/made%20by-Thales%20Macena-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=visual-studio-code&logoColor=2D325E" alt="Made by Thales Macena">
    <img alt="Top Language" src="https://img.shields.io/github/languages/top/thalesmacena/springboot-crud-todo?color=2D325E&labelColor=F0DB4F&style=for-the-badge&logo=java&logoColor=2D325E">
    <a href="https://github.com/thalesmacena/springboot-crud-todo/commits/main">
      <img alt="Last Commits" src="https://img.shields.io/github/last-commit/thalesmacena/springboot-crud-todo?color=2D325E&labelColor=F0DB4F&style=for-the-badge&logo=github&logoColor=2D325E">
    </a>
<a href="https://github.com/thalesmacena/springboot-crud-todo/issues"><img alt="Top Language" src="https://img.shields.io/github/issues-raw/thalesmacena/springboot-crud-todo?color=2D325E&labelColor=F0DB4F&style=for-the-badge&logo=github&logoColor=2D325E"></a>
  </p>
</div>

## 🗂 Table of Contents
- [🗂 Table of Contents](#-table-of-contents)
- [📑 About](#-about)
- [💻 Technologies](#-technologies)
- [🔥 Running the application](#-running-the-application)
- [🕵 API DOC](#-api-doc)
  
  
## 📑 About
This is a small example of how to create a To Do List CRUD Rest API using Springboot, using docker containers for postgres, redis for caching, serving API documentation and with automated testing.

## 💻 Technologies

<a href="https://maven.apache.org/"><img src="https://img.shields.io/badge/-Maven-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=apache-maven&logoColor=2D325E" alt="Maven"></a>

<a href="https://spring.io/projects/spring-boot"><img src="https://img.shields.io/badge/-SpringBoot-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=spring-boot&logoColor=2D325E" alt="Spring Boot"></a>

<a href="https://en.wikipedia.org/wiki/Java_(programming_language"><img src="https://img.shields.io/badge/-Java-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=java&logoColor=2D325E" alt="Java"></a>

<a href="https://spring.io/"><img src="https://img.shields.io/badge/-Spring-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=spring&logoColor=2D325E" alt="Spring"></a>

<a href="https://www.docker.com/"><img src="https://img.shields.io/badge/-Docker-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=docker&logoColor=2D325E" alt="Docker"></a>

<a href="https://www.postgresql.org/"><img src="https://img.shields.io/badge/-PostgreSQL-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=postgresql&logoColor=2D325E" alt="PostgreSQL"></a>

<a href="https://redis.io/"><img src="https://img.shields.io/badge/-Redis-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=redis&logoColor=2D325E" alt="Redis"></a>

<a href="https://springdoc.org/"><img src="https://img.shields.io/badge/-SpringDoc-2D325E?labelColor=F0DB4F&style=for-the-badge&logo=openapi-initiative&logoColor=2D325E" alt="Springdoc"></a>

## 🔥 Running the application

**Prerequisites**
-java jdk 11

-Maven

-Docker

**Run**
```PowerShell
# To copy this repository
git clone https://github.com/thalesmacena/springboot-crud-todo.git

# To move to project directory
cd springboot-crud-todo

# Up container
docker-compose up

# To install and run
mvn spring-boot:run
```

## 🕵 API DOC
to access the api documentation just access the following [url](http://localhost:8080/swagger-ui.html) after run the application.
