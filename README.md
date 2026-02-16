# Laundry Reservation System

A Spring Boot backend application for managing laundry machine reservations.

This project demonstrates layered architecture, business rule validation, and REST API design.

## Overview

The system allows:

- Creating and managing laundry machines
- Creating reservations linked to machines
- Preventing overlapping reservations
- Validating time consistency
- Handling business rule violations with structured error responses

## Architecture

The project follows a layered structure:

Controller → Service → Repository → Database

- Controller: Handles HTTP requests and responses
- Service: Contains business logic and validation rules
- Repository: Handles database access using Spring Data JPA
- Entity: Defines database models (Machine, Reservation)
- DTO: Separates API request structure from database models

## Business Rules

- Start time must be in the future
- End time must be after start time
- Machines marked as BROKEN cannot be reserved
- Overlapping reservations for the same machine are not allowed
- Completed reservations cannot be rescheduled

## Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Jakarta Validation
- Maven

## Running the Application

Clone the repository:
