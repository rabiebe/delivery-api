# Delivery Management System

A backend service for managing deliveries and time slots using Java 21 and Spring Boot 3.2.

---

## 📦 Features
- Delivery mode selection (DRIVE, DELIVERY, DELIVERY_TODAY, DELIVERY_ASAP)
- Time slot booking system with availability checks
- Secure API with JWT authentication
- Event-driven architecture with Kafka
- PostgreSQL integration for data persistence
- Docker and Kubernetes support (planned)
- Redis caching (planned)

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven 3+
- PostgreSQL installed locally or via Docker

### Installation Steps
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/delivery-management-system.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd delivery-management-system
   ```
3. **Create a PostgreSQL database** named `deliverydb` and configure your credentials.
4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
5. **Access the API** at:
   ```bash
   http://localhost:8080
   ```

---

## 🔧 Technologies Used
- **Java 21** – For modern Java features and performance.
- **Spring Boot 3.2** – For rapid development and microservices architecture.
- **Spring Data JPA** – For database interactions.
- **PostgreSQL** – For data persistence.
- **Spring Security (JWT)** – For securing the API.
- **Apache Kafka** – For event-driven design.
- **Docker & Kubernetes** – For containerization and orchestration (planned).

---

## 🌿 Branch Documentation

### `feature/postgresql-setup`
- **Description**: Configured PostgreSQL as the main database and disabled Redis for now.
- **Changes**:
    - Added PostgreSQL configuration in `application.properties`.
    - Disabled Redis cache to focus on PostgreSQL connection.
- **How to use**:
    1. Create a PostgreSQL database named `deliverydb`.
    2. Update `application.properties` with your PostgreSQL credentials.
    3. Run the project using `mvn spring-boot:run`.

---

## 📄 To-Do List
- [x] Connect application to PostgreSQL
- [ ] Implement time slot management
- [ ] Add JWT authentication
- [ ] Integrate Kafka for event-driven architecture
- [ ] Dockerize the application
- [ ] Add Redis caching

---

## 🤝 Contributing
Pull requests are welcome. Please open an issue first to discuss what you would like to change.
