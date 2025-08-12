# 📚 Book Management API
*Made to learn implementation of REST API in Java and DTO Model Conversion.*

## Overview
This is a simple Spring Boot REST API for managing books, in this scenario for library.

It demonstrates clean separation of Model and DTO, validation with `@Valid`, and the use of H2 for the database.

## Tech Stack
- Java 17+
- Spring Boot (Web, Validation, Data JPA)
- Lombok (for @Data, @RestContoller, and etc.)
- H2 Database (In-memory for testing)
- Maven (Dependency Management)

## Key Concepts Learned
### Model
Part of program that represents the actual database entity. Code is [here](src/main/java/com/portfolio/library_api/model/Book.java)

---
### DTO (Data Transfer Object)
A simpler version of object, used to send/receive data in API calls. It prevents exposing the full database structure and allow customizing request/response fields. Code is [here](src/main/java/com/portfolio/library_api/dto/BookDTO.java)

## Flow of Data
Request -> Controller -> Service -> Repository -> Database
and back.

Example Scenario:
1. User sends `POST /books` with JSON Body
```json
{
	"title": "The Hobbit",
    "author": "J.R. Tolkien",
    "quantity": 30
}
```
2. Controller receives `BookDTO` (`@Valid` runs validation).
3. Service converts DTO to Model
4. Repository saves Model to DB
5. Response is sent back as BookDTO
```json
{
    "title": "The Hobbit",
    "author": "J.R. Tolkien",
    "quantity": 30
}
```