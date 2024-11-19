# Registration Management System

This project is a **Registration Management System** built with **Java** for the backend and **MySQL** for database management. The system performs CRUD (Create, Read, Update, Delete) operations on a `registration` table stored in a MySQL database.

## Project Structure

The repository is divided into the following main directory:

- **backend**: Contains Java code (`Program2.java`) and MySQL database schema (`registration.sql`).

## Prerequisites

Before running the backend program, ensure the following tools are installed:

### Tools & Technologies:
- **Java** (JDK 8 or higher)
- **MySQL** (for database operations)
- **JDBC** Driver for MySQL

### Backend Setup (Java with MySQL)

1. **Clone the Repository**:
   Clone the repository to your local machine:
   ```bash
   git clone https://github.com/Dhanush-Sindhe/Registration.git
   cd Registration

   Set Up MySQL Database:




2.Open MySQL and create a new database called internassesment.
Run the following SQL script from registration.sql to create the registration table:
sql
Copy code
CREATE DATABASE IF NOT EXISTS internassesment;

USE internassesment;

CREATE TABLE IF NOT EXISTS registration (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    dob DATE,
    phonenum VARCHAR(15)
);




3.Configure Database Connection:

Open the Program2.java file and modify the following database connection details to match your MySQL setup:
java
Copy code
private static final String URL = "jdbc:mysql://localhost:3306/internassesment"; // Database URL
private static final String USER = "root";  // MySQL username
private static final String PASSWORD = "root";  // MySQL password (update accordingly)



4.Run the Backend Program:

Open a terminal or command prompt, and navigate to the backend directory.
Compile the Java file:
bash
Copy code
javac Program2.java
Run the program:
bash
Copy code
java Program2



5.Using the Program: The program will prompt you to choose an operation from the following:

Create: Insert a new registration.
Read: Retrieve a registration by ID.
Update: Update an existing registration by ID.
Delete: Delete a registration by ID.
You'll be asked to enter the required fields such as ID, Name, Email, Date of Birth (DOB), and Phone Number for Create and Update operations.

Contributing
If you would like to contribute to this project, feel free to fork the repository and submit a pull request.

Contact:
Author: Dhanush Sindhe
Email: dhanushsindhe28@gmail.com
