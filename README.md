# Student Marks Management System

A web-based application for managing student marks, built with Spring Boot and PostgreSQL.

## Features

- Manage students (add, edit, delete)
- Manage subjects (add, edit, delete)
- Manage student marks (add, update, delete)
- View student marks by roll number and exam type
- View top 3 rankers based on exam type

## Technologies Used

- Java 8
- Spring Boot 1.5.22
- Thymeleaf
- PostgreSQL
- Maven
- HTML, CSS

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 8 JDK installed
- Maven installed
- PostgreSQL installed and running

## Database Setup

1. Create a PostgreSQL database:

```sql
CREATE DATABASE studentmarks;
```

2. Update the database configuration in `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentmarks
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Running the Application

1. Clone this repository
2. Navigate to the project directory
3. Build the application:

```bash
mvn clean package
```

4. Run the application:

```bash
java -jar target/student-marks-management-1.0-SNAPSHOT.war
```

5. Open a browser and go to: `http://localhost:8080`

## Database Schema

The application uses the following database tables:

1. `student` - Stores student information

   - `roll_number` (VARCHAR, Primary Key)
   - `name` (VARCHAR)

2. `subject` - Stores subject information

   - `subject_id` (SERIAL, Primary Key)
   - `subject_name` (VARCHAR)

3. `marks` - Stores student marks
   - `mark_id` (SERIAL, Primary Key)
   - `roll_number` (VARCHAR, Foreign Key)
   - `exam_type` (VARCHAR)
   - `subject_id` (INTEGER, Foreign Key)
   - `marks` (INTEGER)

## Initial Data

The system comes with sample data for subjects:

- Maths, Science, Marathi, Social, Kannada, Hindi, English

Sample student and marks data is also included.
