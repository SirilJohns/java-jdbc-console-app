# Java JDBC CRUD Console Application

A simple Java console-based application that demonstrates CRUD operations
(Create, Read, Update, Delete) using JDBC and MySQL.

## Technologies Used
- Java
- JDBC
- MySQL

## 📂 Project Structure

```
src/
└── com/
    └── siril/
        └── jdbc/
            └── crud/
                ├── App.java
                └── ProfileDAO.java
```

## ✨ Features
- Insert profile
- Update profile
- Delete profile
- Get profile by ID
- Get all profiles
- Uses PreparedStatement to prevent SQL Injection

## ▶️ How to Run
1. Clone the repository
2. Import as a Java Project in Eclipse
3. Add MySQL Connector/J to the build path
4. Update database credentials
5. Run `App.java`

## 📌 Learning Outcome
- JDBC connection handling
- PreparedStatement usage
- DAO design pattern
