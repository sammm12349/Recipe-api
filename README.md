[README (2).md](https://github.com/user-attachments/files/26161302/README.2.md)
# Recipe API

A RESTful API for managing recipes and ingredients, built with Java and Spring Boot. Designed with production-style architecture patterns including a service interface layer, DTO mapping, and global exception handling.

## Tech Stack

- **Java** — Spring Boot
- **Spring Data JPA** — ORM and entity relationships
- **MySQL** — relational database
- **Docker / Docker Compose** — containerized database environment
- **Maven** — dependency management

## Features

- Full CRUD operations for recipes and ingredients
- OneToMany / ManyToOne JPA entity relationships
- DTO pattern to decouple API responses from database entities
- Service interface pattern for clean separation of concerns
- Global exception handling for consistent error responses

## Getting Started

### Prerequisites

- Java 17+
- Docker Desktop
- Maven

### Run Locally

1. Clone the repository
   ```bash
   git clone https://github.com/sammm12349/Recipe-api.git
   cd Recipe-api
   ```

2. Start the MySQL database with Docker
   ```bash
   docker-compose up -d
   ```

3. Run the application
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`

## API Endpoints

### Recipes

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/recipes` | Get all recipes |
| GET | `/api/recipes/{id}` | Get recipe by ID |
| POST | `/api/recipes` | Create a new recipe |
| PUT | `/api/recipes/{id}` | Update a recipe |
| DELETE | `/api/recipes/{id}` | Delete a recipe |

### Ingredients

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/ingredients` | Get all ingredients |
| GET | `/api/ingredients/{id}` | Get ingredient by ID |
| POST | `/api/ingredients` | Add a new ingredient |
| PUT | `/api/ingredients/{id}` | Update an ingredient |
| DELETE | `/api/ingredients/{id}` | Delete an ingredient |

## Project Structure

```
src/
├── controller/       # REST controllers (request handling)
├── service/          # Service interfaces and implementations
├── repository/       # Spring Data JPA repositories
├── entity/           # JPA entities
├── dto/              # Data Transfer Objects
└── exception/        # Global exception handler
```

## Author

Samuel Spear — [LinkedIn](https://linkedin.com/in/samuel-spear-094606246) | [GitHub](https://github.com/sammm12349)
