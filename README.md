# Recipe API

A RESTful API for managing recipes and their ingredients, built with Java and Spring Boot. Designed with production-style architecture patterns including a service interface layer, DTO mapping, global exception handling, unit tests, a CI/CD pipeline, and cloud deployment.

**Live demo:** https://recipe-api-production-8e08.up.railway.app/swagger-ui/index.html

## Tech Stack

- **Java 21** — Spring Boot 4.0
- **Spring Data JPA / Hibernate** — ORM and entity relationships
- **MySQL 8** — relational database
- **Lombok** — boilerplate reduction
- **Springdoc OpenAPI** — auto-generated Swagger UI
- **Docker / Docker Compose** — containerized app and database
- **Maven** — dependency management
- **JUnit 5 / Mockito** — unit testing
- **GitHub Actions** — CI/CD pipeline
- **Railway** — cloud deployment
- **Docker Hub** — image registry

## Features

- Full CRUD operations for recipes
- Search recipes by ingredient name, calories, name, or prep time
- OneToMany / ManyToOne JPA relationship between `Recipe` and `Ingredient`
- DTO pattern to decouple API responses from database entities
- Service interface pattern for clean separation of concerns
- Global exception handling for consistent JSON error responses
- Unit tests covering happy paths and exception scenarios
- CI/CD pipeline that runs tests and publishes a Docker image on every push to `main`
- Live deployment on Railway with managed MySQL
- Interactive API documentation via Swagger UI

## Getting Started

### Prerequisites

- Java 21+
- Docker Desktop
- Maven (bundled via `./mvnw`)

### Run with Docker Compose (recommended)

This spins up the app and a MySQL database together, wired with a healthcheck so the app waits for the DB to be ready before starting.

```bash
git clone https://github.com/sammm12349/Recipe-api.git
cd Recipe-api
docker compose up --build
```

Once you see `Started RecipeApplication`, the API is available at:

- **API base:** `http://localhost:3031/api/recipe`
- **Swagger UI:** `http://localhost:3031/swagger-ui/index.html`

To stop:
```bash
docker compose down
```

To wipe the database volume (fresh start):
```bash
docker compose down -v
```

### Run from Docker Hub

```bash
docker pull sammbtw/recipe-api:latest
```

(Requires a MySQL instance reachable by the container — easiest to use the provided `docker-compose.yml`.)

## Running Tests

```bash
./mvnw test
```

## API Endpoints

All endpoints are rooted at `/api/recipe`.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/recipe/all` | List all recipes |
| GET | `/api/recipe/find/id/{id}` | Get a recipe by ID |
| POST | `/api/recipe/add` | Create a new recipe |
| PUT | `/api/recipe/update/{id}` | Update an existing recipe |
| DELETE | `/api/recipe/delete/{id}` | Delete a recipe |
| GET | `/api/recipe/find/ingredient?ingredientName={name}` | Find recipes containing an ingredient |
| GET | `/api/recipe/find/calories?calories={n}` | Find recipes by calorie count |
| GET | `/api/recipe/find/name?recipeName={name}` | Find recipes by name |
| GET | `/api/recipe/find/preptime?prepTime={minutes}` | Find recipes by prep time |

### Example: create a recipe

```bash
curl -X POST http://localhost:3031/api/recipe/add \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Pancakes",
    "calories": 300,
    "prepTimeMinutes": 15,
    "servings": 4,
    "ingredients": [
      {"name": "flour", "quantity": "2 cups"},
      {"name": "milk",  "quantity": "1 cup"}
    ]
  }'
```

For full request/response schemas and a "Try it out" interface, use **Swagger UI** at `/swagger-ui/index.html`.

## Project Structure

```
src/main/java/com/example/recipe/
├── Controller/        # REST controllers (RecipeController)
├── Service/           # Service interface + implementation
├── Repo/              # Spring Data JPA repository
├── model/             # JPA entities (Recipe, Ingredient)
├── DTOmapping/        # DTOs, mapper, ingredient response
└── ErrorHandling/     # GlobalExceptionHandler + custom exceptions
```

## CI/CD Pipeline

GitHub Actions (`.github/workflows/ci.yml`) runs on every push and pull request to `main`:

1. **Build & test** — `mvn clean verify` runs the full test suite
2. **Docker image** (main branch only) — builds and pushes `sammbtw/recipe-api:latest` to Docker Hub
3. **Deploy** — Railway watches the repo and redeploys automatically

## Cloud Deployment (Railway)

Deployed on [Railway](https://railway.app) using a managed MySQL service. The app reads all DB credentials from environment variables, with the connection wired via Railway's private network.

Key environment variables on the deployed service:

```
SPRING_DATASOURCE_URL=jdbc:mysql://${{MySQL.MYSQLHOST}}:${{MySQL.MYSQLPORT}}/${{MySQL.MYSQLDATABASE}}
SPRING_DATASOURCE_USERNAME=${{MySQL.MYSQLUSER}}
SPRING_DATASOURCE_PASSWORD=${{MySQL.MYSQLPASSWORD}}
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.MySQLDialect
SERVER_PORT=${{PORT}}
```

## Author

Samuel Spear — [GitHub](https://github.com/sammm12349) | [LinkedIn](https://linkedin.com/in/samuel-spear)
