# Recipe API

A RESTful API for managing recipes and ingredients, built with Java and Spring Boot. Designed with production-style architecture patterns including a service interface layer, DTO mapping, global exception handling, unit tests, and a CI/CD pipeline.

## Tech Stack

- **Java** — Spring Boot
- **Spring Data JPA** — ORM and entity relationships
- **MySQL** — relational database
- **Docker / Docker Compose** — containerized application and database
- **Maven** — dependency management
- **JUnit 5 / Mockito** — unit testing
- **GitHub Actions** — CI/CD pipeline

## Features

- Full CRUD operations for recipes and ingredients
- OneToMany / ManyToOne JPA entity relationships
- DTO pattern to decouple API responses from database entities
- Service interface pattern for clean separation of concerns
- Global exception handling for consistent error responses
- Unit tests for service layer covering happy path and exception scenarios
- CI/CD pipeline that runs tests and builds a Docker image on every push to main
- Docker image published to Docker Hub

## Getting Started

### Prerequisites

- Java 24+
- Docker Desktop

### Run with Docker (recommended)

1. Clone the repository
```bash
   git clone https://github.com/sammm12349/Recipe-api.git
   cd Recipe-api
```
2. Start the application and database
```bash
   docker-compose up --build
```
The API will be available at `http://localhost:3031`

### Run Locally

1. Clone the repository
```bash
   git clone https://github.com/sammm12349/Recipe-api.git
   cd Recipe-api
```
2. Start the MySQL database with Docker
```bash
   docker-compose up -d mysql
```
3. Run the application
```bash
   ./mvnw spring-boot:run
```
The API will be available at `http://localhost:3031`

### Pull Docker Image

```bash
docker pull sammbtw/recipe-api:latest
```

## Running Tests

```bash
mvn test
```

## CI/CD Pipeline

This project uses GitHub Actions to automatically run tests and build a Docker image on every push to main. The pipeline:

1. Runs all unit tests
2. If tests pass, builds and pushes a Docker image to Docker Hub

## API Endpoints

### Recipes

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/recipes` | Get all recipes |
| GET | `/recipes/{id}` | Get recipe by ID |
| POST | `/recipes/add` | Create a new recipe |
| PUT | `/recipes/{id}` | Update a recipe |
| DELETE | `/recipes/{id}` | Delete a recipe |

### Ingredients

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/ingredients` | Get all ingredients |
| GET | `/ingredients/{id}` | Get ingredient by ID |
| POST | `/ingredients/add` | Add a new ingredient |
| PUT | `/ingredients/{id}` | Update an ingredient |
| DELETE | `/ingredients/{id}` | Delete an ingredient |

## Project Structure

```
src/
├── controller/       # REST controllers (request handling)
├── service/          # Service interfaces and implementations
├── repository/       # Spring Data JPA repositories
├── model/            # JPA entities
├── dto/              # Data Transfer Objects and mappers
└── exception/        # Global exception handler
```

## Author

Samuel Spear — [GitHub](https://github.com/sammm12349) | [LinkedIn](https://linkedin.com/in/samuel-spear)

Samuel Spear — [LinkedIn](https://linkedin.com/in/samuel-spear-094606246) | [GitHub](https://github.com/sammm12349)
