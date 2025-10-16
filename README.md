Java Insurance Management System

This is a console-based Java application for managing users and calculating car insurance premiums. It features a dual-role system (Admin and User) and connects to a MySQL database to persist user data.

The project has been refactored from its original structure to follow standard Java conventions, with a clear separation of concerns into different packages.

Key Features

Admin Role: Admins can log in to view all users currently in the database and add new users with specific roles.

User Role: Regular users can access a calculator to receive an estimated car insurance premium based on their age and their car's age.

Database Integration: Securely connects to a MySQL database using credentials stored in an external db.properties file, not hardcoded in the source.

Organized Codebase: The project is structured into model, dao, util, and app packages to improve maintainability and readability.

How to Run

Prerequisites

Java Development Kit (JDK) 11 or higher

Apache NetBeans or VS Code with the "Extension Pack for Java"

MySQL Server

MySQL Connector/J (JDBC Driver)

Setup Steps

Database Setup:

Create a new database in MySQL named databaseCA.

Run the following SQL script to create the users table:

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(20) NOT NULL
);


Configure Connection:

Open the db.properties file located in the com.insurancecompany.app package.

Update the db.url, db.user, and db.password to match your MySQL setup if they are different.

Add JDBC Driver:

In your IDE (NetBeans or VS Code), add the MySQL Connector/J .jar file to the project's libraries.

Run the Application:

Set com.insurancecompany.app.Main as the project's main class.

Clean, build, and run the project
