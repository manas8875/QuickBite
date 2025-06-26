# 🍽️ QuickBite – Food Delivery API (Java + Spring Boot)

QuickBite is a backend REST API for a food delivery system built using Spring Boot. It supports features like user registration,
restaurant & menu management, cart operations, order processing, and JWT-based authentication.

## 🚀 Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- Spring Security + JWT
- H2 Database (in-memory)
- Lombok
- Postman (for testing)
- Maven

## 📂 Project Structure

com.project.QuickBite
│
├── controller → REST endpoints
├── model → JPA entities
├── repository → DB access with Spring Data JPA
├── service → Business logic
├── security → JWT filters, config
├── dto → Request/Response models (coming soon)
└── config → Security & app-level configs

## ✅ Features

- 👤 User Signup/Login with JWT
- 🔐 Role-based access (Admin/User)
- 🍴 Add/View Restaurants
- 🧾 Add/View Menu Items
- 🛒 Add to Cart, View Cart
- 🧾 Place Orders, View Order History
- 🧪 Swagger API Documentation (coming soon)
