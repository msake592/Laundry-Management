# Laundry Reservation System

A simple role-based laundry reservation backend built with:

- Spring Boot
- Spring Security (Basic Auth)
- PostgreSQL
- JPA / Hibernate

## Features

- User registration (BCrypt password hashing)
- Basic Authentication login
- Role-based access (ADMIN / USER)
- Machine management (Admin only)
- Reservation creation
- Reservation deletion
- Reservation rescheduling
- Time conflict validation
- Start/End time validation

## Tech Stack

- Java 17+
- Spring Boot 3
- Spring Security
- PostgreSQL
- Maven

## Roles

ADMIN:
- Create machines

USER:
- Create reservation
- Delete reservation
- Reschedule reservation

## Authentication

Basic Authentication is used.
Credentials must be sent via Authorization header.

## Database

PostgreSQL is required.
Tables are generated automatically via JPA.

---

This project was built for backend learning purposes and focuses on:
- REST design
- Validation
- Security
- Role-based UI logic
