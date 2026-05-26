# Spring Boot Microservices Platform

A scalable and production-oriented **Spring Boot Microservices architecture** designed for secure job marketplace and service management workflows. The platform integrates authentication, API gateway routing, service discovery, asynchronous communication, distributed configuration, and file storage capabilities.

---

# 🚀 Features

- JWT-based Authentication & Authorization
- API Gateway Routing
- Service Discovery using Eureka Server
- Distributed Configuration using Config Server
- Kafka-based Asynchronous Communication
- Redis Caching
- File Upload & Download Service
- Dockerized Environment
- Swagger/OpenAPI Documentation
- Secure REST APIs
- Role-Based Access Control (ADMIN / USER)

---

# 🏗️ Microservices Included

| Service | Description |
|---|---|
| Config Server | Centralized configuration management |
| Eureka Server | Service discovery |
| API Gateway | Centralized routing & security |
| Auth Service | Authentication & JWT generation |
| User Service | User management operations |
| Job Service | Jobs, adverts & offers management |
| Notification Service | Kafka-based notifications |
| File Storage Service | File upload/download handling |

---

# 🛠️ Tech Stack

## Backend
- Java
- Spring Boot
- Spring Security
- Spring Cloud
- Spring Data JPA
- Hibernate
- REST APIs
- Feign Client

## Security
- JWT Authentication
- Role-Based Authorization

## Database & Messaging
- PostgreSQL
- Redis
- Apache Kafka

## DevOps & Tools
- Docker
- OpenAPI / Swagger UI
- Maven
- Lombok
- Log4j2

---

# 📌 Core Functionalities

## 🔐 Authentication & Authorization
- User Registration & Login
- JWT Token Generation
- Role-Based Access Control
- Secure API Access

## 👤 User Management
- Update User Profile
- Get User by ID / Email
- Delete User
- Profile Image Upload

## 💼 Job & Advertisement System
- Create & Manage Categories
- Job Posting & Search
- Advertisement Management
- Offer/Bidding Workflow
- Personalized Job Recommendations

## 🔔 Notification Service
- Kafka-based Event Communication
- Real-time Notifications

## 📁 File Storage
- Secure File Upload/Download APIs
- Media & Profile Storage

---

# ⚙️ Architecture Highlights

- Microservices Architecture
- API Gateway Security Layer
- Centralized Config Management
- Distributed Service Discovery
- Kafka Event-Driven Communication
- Dockerized Deployment
- Layered Enterprise Architecture
- RESTful API Design

---

# 📡 Sample API Endpoints

## Auth APIs

### Register
```http
POST /v1/auth/register
```

### Login
```http
POST /v1/auth/login
```

---

## User APIs

### Get User By ID
```http
GET /v1/user/getUserById/{id}
```

### Update User
```http
PUT /v1/user/update
```

---

## Job APIs

### Create Job
```http
POST /v1/job-service/job/create
```

### Get All Jobs
```http
GET /v1/job-service/job/getAll
```

---

## Offer APIs

### Make An Offer
```http
POST /v1/job-service/offer/makeAnOffer
```

---

# 🔨 Run The Project

## 1️⃣ Clone Repository

```bash
git clone https://github.com/satyamshivhare85/SpringBoot.git
```

---

## 2️⃣ Navigate to Project

```bash
cd SpringBoot
```

---

## 3️⃣ Run Docker Containers

```bash
docker compose up
```

---

## 4️⃣ Start Services in Order

1. Eureka Server  
2. API Gateway  
3. Config Server  
4. Auth Service  
5. User Service  
6. Job Service  
7. Notification Service  
8. File Storage Service  

---

# 📚 Swagger Documentation

```bash
http://localhost:8080/v1/{service-name}/swagger-ui/index.html
```

Example:

```bash
http://localhost:8080/v1/user-service/swagger-ui/index.html
```

---

# 🧪 Security

- JWT Authentication
- Role-Based Access Control
- Bearer Token Validation
- Gateway-Level Request Filtering

---

# 🐳 Docker Support

The project supports containerized deployment using Docker Compose for easier setup and scalability.

---

# 📈 Future Improvements

- Kubernetes Deployment
- CI/CD Integration
- Monitoring & Logging Dashboard
- Rate Limiting
- OAuth2 Integration
- Distributed Tracing

---

# 👨‍💻 Author

**Satyam Shivhare**

- Backend Developer
- Java & Spring Boot Enthusiast
- Microservices & System Design Learner

---

# ⭐ Project Highlights

✅ Enterprise-Level Microservices Architecture  
✅ Secure JWT Authentication  
✅ Kafka-Based Communication  
✅ Redis Caching  
✅ Dockerized Deployment  
✅ Production-Style REST APIs  
✅ Modular & Scalable Design  
