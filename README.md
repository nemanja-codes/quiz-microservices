
# Quiz Microservices Application

This is the backend part of a **Quiz Application** built using a **microservices architecture** in Java with **Spring Boot**.  
The project is decomposed into separate services responsible for quiz and question management, communicating via **REST** and registered through **Eureka Service Discovery**.  
All endpoints have been tested using **Postman**.

## 🧱 Architecture

The application consists of the following services:

- `question-service` – manages questions and answers
- `quiz-service` – creates quizzes and handles quiz-related operations
- `service-registry` – Eureka server for service discovery
- `api-gateway` – centralized gateway that routes requests to respective services

Each service runs as a standalone Spring Boot application and communicates through the Eureka registry and Feign clients.

```
Client → API Gateway → Eureka → quiz-service / question-service
```

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Spring Cloud (Eureka, OpenFeign, Gateway)
- Maven
- Postman (for testing endpoints)

## 📁 Project Structure

```
quiz-microservices/
│
├── api-gateway/         # Spring Cloud Gateway
├── service-registry/    # Eureka Server
├── quiz-service/        # Handles quizzes
└── question-service/    # Handles questions
```

## 🚀 Getting Started

To run the application locally:

1. Clone the repository:
   ```
   git clone https://github.com/nemanja-codes/quiz-microservices.git
   ```

2. Make sure PostgreSQL is running and database is configured for each service.

3. Start the services in the following order:

   - `service-registry`
   - `question-service`
   - `quiz-service`
   - `api-gateway`

4. Use **Postman** or any HTTP client to interact with the endpoints via API Gateway (port `8765` by default).

## ✅ Features Implemented

- Generate random quizzes by category
- Retrieve quiz questions (without showing correct answers)
- Submit answers and receive score
- Many-to-many relationship between quizzes and questions
- HTTP status handling and error management
- Microservice communication via Feign clients
- Centralized routing with Spring Cloud Gateway

## 📌 Notes

- Only the **backend** part of the application is implemented.
- All endpoints are tested using **Postman**.
- Security and frontend are not yet implemented.

## 📬 Contact

For suggestions, improvements, or issues, feel free to open an issue or contact the author via GitHub.
