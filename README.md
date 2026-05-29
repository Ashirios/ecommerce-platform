# 🛒 E-Commerce Platform

> Микросервисная платформа электронной коммерции на Java 21 + Spring Boot 4  
> A microservices-based e-commerce platform built with Java 21 + Spring Boot 4

---

## 🇷🇺 Русский

### О проекте

Учебный проект — полноценная платформа интернет-магазина, построенная по принципам микросервисной архитектуры. Цель проекта — изучить реальный стек Java-разработки: Spring Cloud, API Gateway, безопасность через JWT и современные подходы к организации кода.

### Стек технологий

| Слой | Технологии |
|---|---|
| Язык | Java 21 |
| Фреймворк | Spring Boot 4.0.3 |
| Микросервисы | Spring Cloud 2025.1.0 |
| Сборка | Gradle (Kotlin DSL) |
| Логирование | Logback + Logstash encoder |
| Тестирование | JUnit 5, Mockito, Testcontainers |
| Утилиты | Lombok |

### Структура проекта

```
ecommerce-platform/
├── api-gateway/              # API Gateway — точка входа, роутинг
├── services/
│   └── user-service/         # Сервис пользователей
│       ├── entities/         # User, Profile, Role
│       └── repositories/     # UserRepository, ProfileRepository, RoleRepository
├── shared/                   # Общие модели и утилиты
├── build.gradle.kts          # Корневой Gradle-конфиг
└── settings.gradle.kts
```

### Сервисы

**API Gateway** — единая точка входа для всех запросов. Отвечает за маршрутизацию к нужному сервису.

**User Service** — управление пользователями: регистрация, профили, роли.

### Как запустить

```bash
# Клонировать репозиторий
git clone https://github.com/Ashirios/ecommerce-platform.git
cd ecommerce-platform

# Собрать все сервисы
./gradlew buildAllServices

# Запустить тесты
./gradlew test
```

### Требования

- Java 21+
- Gradle 8.x (или используй `./gradlew`)

### Статус проекта

🚧 В активной разработке. Проект создаётся для изучения Java-разработки и формирования портфолио.

---

## 🇬🇧 English

### About

A learning project — a full-featured e-commerce platform built on microservices architecture principles. The goal is to explore a real-world Java development stack: Spring Cloud, API Gateway, JWT-based security, and modern code organization practices.

### Tech Stack

| Layer | Technologies |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.0.3 |
| Microservices | Spring Cloud 2025.1.0 |
| Build tool | Gradle (Kotlin DSL) |
| Logging | Logback + Logstash encoder |
| Testing | JUnit 5, Mockito, Testcontainers |
| Utilities | Lombok |

### Project Structure

```
ecommerce-platform/
├── api-gateway/              # API Gateway — entry point and routing
├── services/
│   └── user-service/         # User management service
│       ├── entities/         # User, Profile, Role
│       └── repositories/     # UserRepository, ProfileRepository, RoleRepository
├── shared/                   # Shared models and utilities
├── build.gradle.kts          # Root Gradle config
└── settings.gradle.kts
```

### Services

**API Gateway** — single entry point for all incoming requests. Handles routing to the appropriate downstream service.

**User Service** — manages users: registration, profiles, and roles.

### Getting Started

```bash
# Clone the repository
git clone https://github.com/Ashirios/ecommerce-platform.git
cd ecommerce-platform

# Build all services
./gradlew buildAllServices

# Run tests
./gradlew test
```

### Requirements

- Java 21+
- Gradle 8.x (or use the included `./gradlew` wrapper)

### Project Status

🚧 Actively in development. This project is being built for learning Java backend development and building a portfolio.

---

*Built by [Ashirios](https://github.com/Ashirios)*
