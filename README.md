# Employee Microservice

A robust and scalable REST API microservice for managing employee data and operations, built with Spring Boot and following industry-standard microservice architecture principles.

## 📋 Overview

The Employee Microservice is a backend API that handles all employee-related operations in a distributed system. It provides comprehensive CRUD (Create, Read, Update, Delete) functionality, data validation, error handling, and integrates seamlessly with other microservices through REST endpoints.

### Key Features

- **Employee Management**: Create, retrieve, update, and delete employee records
- **Data Validation**: Comprehensive input validation and business logic checks
- **Error Handling**: Centralized exception handling with meaningful error responses
- **Database Persistence**: JPA/Hibernate integration with MySQL for reliable data storage
- **RESTful API**: Clean and consistent REST endpoint design following HTTP standards
- **Pagination & Sorting**: Efficient data retrieval with pagination support
- **Logging & Monitoring**: Structured logging for debugging and troubleshooting
- **Scalability**: Designed to handle high-volume requests in enterprise environments

## 🛠️ Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Framework** | Spring Boot | 3.x |
| **Language** | Java | 17+ |
| **Database** | MySQL | 8.0+ |
| **ORM** | Spring Data JPA / Hibernate | 3.x |
| **Build Tool** | Maven | 3.8+ |
| **API Documentation** | Swagger/OpenAPI | 3.0 |
| **Containerization** | Docker | Latest |
| **Testing** | JUnit 5, Mockito | 5.x |

## 📁 Project Structure

```
EmployeeMicroservice/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── microservice/
│   │   │           └── employee/
│   │   │               ├── controller/          # REST API endpoints
│   │   │               ├── service/             # Business logic layer
│   │   │               ├── repository/          # Data access layer
│   │   │               ├── entity/              # JPA entities
│   │   │               ├── dto/                 # Data Transfer Objects
│   │   │               ├── exception/           # Custom exceptions
│   │   │               ├── config/              # Configuration classes
│   │   │               └── EmployeeMicroserviceApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── application-dev.yml
│   │       └── application-prod.yml
│   └── test/
│       └── java/                               # Unit & integration tests
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
└── .gitignore
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- MySQL 8.0+
- Docker & Docker Compose (optional, for containerized setup)
- Git

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/brej-29/EmployeeMicroservice.git
   cd EmployeeMicroservice
   ```

2. **Configure Database**
   Update `application.yml` with your MySQL credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/employee_db
       username: root
       password: your_password
     jpa:
       hibernate:
         ddl-auto: update
   ```

3. **Build the Application**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   The service will be available at `http://localhost:8080`

### Docker Setup

Build and run using Docker Compose:
```bash
docker-compose up -d
```

## 📚 API Endpoints

### Employee Operations

| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/api/employees` | Retrieve all employees (paginated) |
| **GET** | `/api/employees/{id}` | Get employee by ID |
| **POST** | `/api/employees` | Create new employee |
| **PUT** | `/api/employees/{id}` | Update existing employee |
| **DELETE** | `/api/employees/{id}` | Delete employee |
| **GET** | `/api/employees/search` | Search employees by criteria |

### Example Request/Response

**Create Employee (POST)**
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@company.com",
    "department": "Engineering",
    "salary": 75000
  }'
```

**Response (201 Created)**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@company.com",
  "department": "Engineering",
  "salary": 75000,
  "createdAt": "2025-12-27T12:47:00Z"
}
```

## 🔧 Configuration

### Application Properties

Key configuration parameters in `application.yml`:

```yaml
spring:
  application:
    name: employee-microservice
  datasource:
    url: jdbc:mysql://localhost:3306/employee_db
    username: root
    password: password
  jpa:
    show-sql: false
    hibernate:
      ddl-auto: validate
  jackson:
    serialization:
      write-dates-as-timestamps: false

server:
  port: 8080
  servlet:
    context-path: /api

# Logging
logging:
  level:
    root: INFO
    com.microservice.employee: DEBUG
```

## 🧪 Testing

Run the test suite:
```bash
mvn test
```

### Test Coverage
- Unit tests for service layer
- Repository integration tests
- Controller endpoint tests
- Exception handling tests

## 📖 API Documentation

Swagger/OpenAPI documentation is automatically generated and available at:
```
http://localhost:8080/swagger-ui.html
```

## 🏗️ Architecture

The microservice follows a layered architecture:

1. **Controller Layer**: Handles HTTP requests/responses
2. **Service Layer**: Contains business logic and validations
3. **Repository Layer**: Manages database operations
4. **Entity Layer**: JPA entities mapped to database tables
5. **DTO Layer**: Data transfer objects for API contracts

## 🔒 Error Handling

The application implements centralized exception handling with custom exceptions:

- `EmployeeNotFoundException`: When employee record doesn't exist
- `InvalidEmployeeDataException`: When validation fails
- `DuplicateEmployeeException`: When duplicate records are created
- `DatabaseException`: For database operation failures

## 📊 Monitoring & Logging

- **Structured Logging**: JSON formatted logs for easy parsing
- **SLF4J Integration**: Consistent logging across the application
- **Health Check Endpoint**: `/actuator/health` for service health status
- **Metrics**: Application metrics available at `/actuator/metrics`

## 🚢 Deployment

### Build Docker Image
```bash
docker build -t employee-microservice:latest .
```

### Push to Registry
```bash
docker tag employee-microservice:latest your-registry/employee-microservice:latest
docker push your-registry/employee-microservice:latest
```

### Deploy to Kubernetes
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: employee-microservice
spec:
  replicas: 3
  selector:
    matchLabels:
      app: employee-microservice
  template:
    metadata:
      labels:
        app: employee-microservice
    spec:
      containers:
      - name: employee-microservice
        image: your-registry/employee-microservice:latest
        ports:
        - containerPort: 8080
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Code Standards

- Follow Google Java Style Guide
- Maintain test coverage > 80%
- Use meaningful variable and method names
- Add Javadoc for public methods
- Keep methods focused and single-responsibility

## 🐛 Troubleshooting

### Database Connection Issues
- Verify MySQL is running and accessible
- Check credentials in `application.yml`
- Ensure database exists: `CREATE DATABASE employee_db;`

### Port Already in Use
```bash
# Change port in application.yml
server:
  port: 8081
```

### Build Failures
```bash
mvn clean install -DskipTests
```

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Author

**Brejesh Balakrishnan** - [@brej-29](https://github.com/brej-29)
- Full-stack Developer @ Accenture
- Aspiring Data Scientist
- GitHub: https://github.com/brej-29

## 📧 Support

For issues, questions, or suggestions, please open an GitHub issue or contact the maintainer.

## 🔗 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [REST API Best Practices](https://restfulapi.net/)
- [Microservices Architecture Patterns](https://microservices.io/)

---

**Last Updated**: December 2025  
**Status**: Active Development  
**Java Version**: 17+  
**Spring Boot**: 3.x
