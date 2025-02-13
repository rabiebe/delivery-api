# Delivery Management System

> 📄 **This README.md is specific to the `feature/hexagonal-architecture` branch.**
> The main branch will contain the full combined documentation of all branches.
A backend service for managing deliveries, time slots, and bookings using Java 21 and Spring Boot 3.2.
## `feature/hexagonal-architecture` Branch Documentation
### **Description**
This branch implements a complete hexagonal architecture for the Delivery project, including:
- Domain models and business logic.
- Application ports (in/out) and service implementations.
- Infrastructure layer with JPA entities and repositories.
- Web layer with DTOs, mappers (MapStruct), and REST controllers.
### **Project Structure**
```
src
└── main
    └── java
        └── com.delivery
            ├── application
            │   ├── ports
            │   │   ├── in       // Interfaces for use cases
            │   │   └── out      // Interfaces for external adapters
            │   └── service      // Business services implementations
            │
            ├── domain
            │   ├── model        // Business entities (Delivery, TimeSlot, Booking)
            │   ├── exception    // Domain-specific exceptions
            │   └── service      // Domain services
            │
            ├── infrastructure
            │   ├── config       // Spring Boot configurations
            │   ├── entity       // JPA entities
            │   ├── repository   // JPA repositories
            │   ├── messaging    // Kafka adapters
            │   └── external     // External services integrations
            │
            └── web
                ├── controller   // REST controllers
                ├── dto
                │   ├── request  // Request DTOs
                │   └── response // Response DTOs
                └── mapper       // MapStruct mappers
```
- **domain**: Business entities (Delivery, TimeSlot, Booking).
- **application**: Ports and services.
- **infrastructure**: Entities, repositories, and configurations.
- **web**: DTOs, mappers, and controllers.
### **How to Run the Project**
### **To-Do List**
- [x] Implement hexagonal architecture structure
- [x] Add domain models and services
- [x] Create DTOs and mappers
- [x] Implement REST controllers
- [x] Add JPA entities and repositories
- [ ] Finalize service logic and integrate repositories
- [ ] Add tests and documentation
- [ ] Dockerize the application

1. Clone the repository.
2. Checkout the `feature/hexagonal-architecture` branch.
3. Set up PostgreSQL and configure `application.properties`.
4. Run `mvn spring-boot:run`.