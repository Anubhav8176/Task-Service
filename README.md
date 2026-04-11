# Task-Service 🗂️

> A task management microservice built with **Spring Boot 3** + **Apache Kafka** — focused on clean REST APIs and async event-driven communication.

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.3.5-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=flat-square&logo=apachekafka&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/status-in%20development-orange?style=flat-square)

---

### What is this?

**Task-Service** (internally `TrackerService`) is a backend microservice I built to get hands-on with Spring Boot 3, Java 21, and event-driven design using Apache Kafka. It handles task management through a RESTful API, keeps data in MySQL via JPA, and is designed to work as part of a broader microservices setup.

The goal was to explore how services communicate asynchronously through Kafka while keeping the core logic clean and the API straightforward. Still a work in progress, but the foundation is solid.

---

### Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.3.5 |
| REST API | Spring Web MVC |
| Persistence | Spring Data JPA + Hibernate |
| Messaging | Apache Kafka (`spring-kafka`) |
| Database | MySQL |
| Boilerplate | Lombok |
| Build | Apache Maven |

**Dependencies at a glance:**

- `spring-boot-starter-web` — REST API layer
- `spring-boot-starter-data-jpa` — ORM and repository support
- `spring-kafka` — Kafka producer/consumer integration
- `mysql-connector-j` — MySQL JDBC driver
- `lombok` — annotation-based code generation
- `spring-boot-starter-test` + `spring-kafka-test` — testing utilities

---

### Project Layout

```
src/
└── main/
    ├── java/com/anucodes/trackerservice/
    │   ├── controller/       ← REST endpoints
    │   ├── service/          ← business logic
    │   ├── repository/       ← JPA data access
    │   ├── model/            ← entity definitions
    │   ├── kafka/            ← producers & consumers
    │   └── TrackerserviceApplication.java
    └── resources/
        └── application.properties
```

---

### Getting Started

**Requirements**
- Java 21+
- MySQL (local or remote)
- Kafka broker running at `localhost:9092`
- Maven 3.8+ or use the included `./mvnw` wrapper

**Step 1 — Clone**
```bash
git clone https://github.com/Anubhav8176/Task-Service.git
cd Task-Service
```

**Step 2 — Set up `application.properties`**
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# Kafka
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=task-service-group
```

**Step 3 — Create the database**
```sql
CREATE DATABASE task_db;
```

**Step 4 — Build & Run**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

Service starts at `http://localhost:8080`.

---

### API Reference

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/tasks` | List all tasks |
| `GET` | `/api/tasks/{id}` | Fetch a single task |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update a task |
| `DELETE` | `/api/tasks/{id}` | Remove a task |

> Endpoints are subject to change as the service is actively developed.

---

### Running Tests

```bash
./mvnw test
```

Covers Spring Boot integration tests and Kafka messaging via `spring-kafka-test`.

---

### Contributing

Got an idea or spotted something to fix? PRs are welcome.

```bash
# 1. Fork and clone
git checkout -b feature/your-feature

# 2. Make your changes, then
git commit -m "feat: describe your change"
git push origin feature/your-feature

# 3. Open a Pull Request
```

For bugs, open an [issue](https://github.com/Anubhav8176/Task-Service/issues) with a description, steps to reproduce, and any relevant logs.

---

### License

MIT — feel free to use, modify, and distribute.

---

<sub>Built by <a href="https://github.com/Anubhav8176">Anubhav</a> · ☕ Java + too many Kafka topics</sub>
