
# MediStock - Medicine Inventory Management System

MediStock is a Java-based backend application for managing medicine inventory using Spring Boot, Spring Data JPA, and MySQL.

## Features
- Add, view, update and delete medicines.
- Store medicine details in MySQL.
- Track medicine name, batch number, price, quantity and expiry date.
- Identify low-stock medicines.
- Track expired medicines.
- Identify medicines expiring within 30 days.
- Validate medicine input data.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- REST APIs

## API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | /api/medicines | Add medicine |
| GET | /api/medicines | Get all medicines |
| GET | /api/medicines/{id} | Get medicine by ID |
| PUT | /api/medicines/{id} | Update medicine |
| DELETE | /api/medicines/{id} | Delete medicine |
| GET | /api/medicines/low-stock | Find low-stock medicines |
| GET | /api/medicines/expired | Find expired medicines |
| GET | /api/medicines/expiring-soon | Find medicines expiring within 30 days |

## Database
MySQL database: medistock

## Running the Project
1. Install Java and MySQL.
2. Create a database named medistock.
3. Configure database credentials in application.properties.
4. Run MedistockApplication.java.
5. Test APIs using Postman.
