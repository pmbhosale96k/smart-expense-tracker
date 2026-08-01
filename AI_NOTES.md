# AI_NOTES.md

## AI Tools Used

During the development of this assignment, I used ChatGPT as an engineering assistant to accelerate development, understand design choices, and review code quality. AI was used to assist with implementation, but all generated code was manually reviewed, integrated, tested, and modified where necessary.

---

## 1. AI-Generated Assistance

AI was primarily used for:

- Designing a clean layered architecture (Controller → Service → Repository).
- Generating initial Spring Boot boilerplate.
- Suggesting REST endpoint naming and API structure.
- Implementing DTOs and validation annotations.
- Creating global exception handling using `@RestControllerAdvice`.
- Suggesting Swagger/OpenAPI integration.
- Implementing Java Stream operations for analytics and search.
- Preparing project documentation (README).

---

## 2. Manual Validation and Changes

All AI-generated code was manually reviewed and tested before being added to the project.

The following improvements were made after reviewing AI suggestions:

- Replaced simple list-based storage with a thread-safe `ConcurrentHashMap`.
- Used `AtomicLong` for automatic ID generation.
- Used `BigDecimal` instead of `double` for monetary values.
- Used an `enum` for expense categories instead of plain strings.
- Added Bean Validation to validate incoming requests.
- Added custom exception handling for invalid IDs and validation failures.
- Improved API responses with proper HTTP status codes such as `201 Created`, `204 No Content`, `400 Bad Request`, and `404 Not Found`.
- Added Swagger/OpenAPI documentation to simplify API testing.

Every endpoint was manually tested using Swagger UI to verify request validation, responses, and error handling.

---

## 3. AI Suggestions That Were Not Used

Some AI suggestions were intentionally not implemented because they did not align with the assignment requirements.

Examples include:

- **Using Spring Data JPA and Hibernate**
  - Rejected because the assignment explicitly required in-memory storage or a local JSON file instead of a database.

- **Using MySQL**
  - Not implemented because persistent storage was outside the assignment scope.

- **Adding Docker support**
  - Not selected because only one bonus feature was required, and Swagger/OpenAPI was chosen instead.

- **Adding JWT Authentication**
  - Considered unnecessary for this assignment since authentication was not part of the requirements.

---

## 4. Personal Contribution

I was responsible for:

- Understanding the assignment requirements.
- Designing the project structure.
- Integrating all project components.
- Reviewing and modifying AI-generated code.
- Resolving compilation issues.
- Debugging API behavior.
- Testing every endpoint using Swagger.
- Organizing the GitHub repository.
- Writing the final documentation.

---

## 5. Reflection

AI significantly improved development speed by assisting with boilerplate code, design suggestions, and documentation. However, every generated solution was manually reviewed, tested, and adapted to ensure it met the assignment requirements and followed Spring Boot best practices.