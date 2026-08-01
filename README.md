# 💰 Smart Expense Tracker API

A RESTful API built using **Java Spring Boot** to manage personal expenses. The application allows users to add, view, search, filter, summarize, and delete expenses using an in-memory data store. It follows a clean layered architecture and includes validation, exception handling, and interactive API documentation with Swagger.

---

## 🚀 Features

### Core Features
- ➕ Add a new expense
- 📋 View all expenses
- 🔍 Filter expenses by category
- 📊 Calculate total expenses
  - Overall summary
  - Category-wise summary
- ❌ Delete an expense

### Bonus Features
- 🔎 Search expenses by title
- 🏆 Top Spending Category Analytics
- 📖 Interactive Swagger/OpenAPI Documentation

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3
- Maven
- Lombok
- Spring Validation
- Swagger (OpenAPI)
- In-Memory Storage (ConcurrentHashMap)

---

## 📂 Project Structure

```
expense-tracker-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.expensetracker
│   │   │        ├── config
│   │   │        ├── controller
│   │   │        ├── dto
│   │   │        ├── exception
│   │   │        ├── model
│   │   │        ├── repository
│   │   │        └── service
│   │   └── resources
│   │
│   └── test
│
├── README.md
├── AI_NOTES.md
└── pom.xml
```

---

## ⚙️ Installation

Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/expense-tracker-api.git
```

Move into the project

```bash
cd expense-tracker-api
```

Install dependencies

```bash
mvn clean install
```

---

## ▶️ Run the Application

```bash
mvn spring-boot:run
```

The application will start on

```
http://localhost:8080
```

---

## 🧪 Run Tests

```bash
mvn test
```

---

# 📘 Swagger Documentation

Once the application is running, open

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides interactive documentation for all available REST APIs.

---

# 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/expenses` | Add a new expense |
| GET | `/api/expenses` | View all expenses |
| GET | `/api/expenses?category=FOOD` | Filter expenses by category |
| GET | `/api/expenses/summary` | Overall expense summary |
| GET | `/api/expenses/summary?category=FOOD` | Category-wise summary |
| DELETE | `/api/expenses/{id}` | Delete an expense |
| GET | `/api/expenses/search?keyword=pizza` | Search expenses by title |
| GET | `/api/expenses/analytics/top-category` | Get top spending category |

---

# 📥 Sample Request

## Add Expense

**POST**

```
/api/expenses
```

Request Body

```json
{
  "title": "Pizza",
  "amount": 450,
  "category": "FOOD",
  "date": "2026-07-31"
}
```

Response

```json
{
  "id": 1,
  "title": "Pizza",
  "amount": 450,
  "category": "FOOD",
  "date": "2026-07-31"
}
```

---

# 🏗️ Architecture

The application follows a layered architecture.

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
ConcurrentHashMap (In-Memory Storage)
```

---

# ⚠️ Validation

The application validates user input using Bean Validation.

Examples:

- Title cannot be blank
- Amount must be greater than zero
- Category is required
- Date cannot be in the future

---

# ❗ Exception Handling

Global exception handling is implemented using `@RestControllerAdvice`.

Handled exceptions include:

- Expense Not Found (404)
- Validation Errors (400)
- Invalid Category (400)

---

# 🚀 Future Improvements

- Database integration using MySQL/PostgreSQL
- User authentication with JWT
- Pagination and sorting
- Expense update endpoint
- Export expenses to CSV/PDF

---

# 👨‍💻 Author

**Pratham Bhosale**

Built as part of the **Diligent Software Engineering Apprenticeship 2026** take-home assignment.