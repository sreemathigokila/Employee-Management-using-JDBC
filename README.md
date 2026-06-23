# Employee Management System

## Overview

The Employee Management System is a Java-based console application developed using JDBC and Oracle Database. It allows users to perform CRUD (Create, Read, Update, Delete) operations on employee records stored in a database.

## Features

* Add a new employee
* Update employee details
* Delete an employee
* Fetch a single employee by ID
* Fetch all employee records
* Menu-driven console interface

## Technologies Used

* Java
* JDBC (Java Database Connectivity)
* Oracle Database 21c XE
* Eclipse IDE

## Project Structure

```
src/
in.kce.bean
    Employee.java
in.kce.dao
    EmployeeDAO.java
in.kce.service
    EmployeeService.java
in.kce.util
    DBUtil.java
in.kce.main
    TestEmployee.java
```

## Database Configuration

### Create Table

```sql
CREATE TABLE EMPLOYEE2(
    EMPID NUMBER(5) PRIMARY KEY,
    EMPNAME VARCHAR2(25),
    DESIGNATION VARCHAR2(20)
);
```

### JDBC Configuration

```java
String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
String user = "SYSTEM";
String pass = "password";
```

## Functionalities

### 1. Store Employee

Insert a new employee record into the database.

### 2. Update Employee

Update employee name using employee ID.

### 3. Delete Employee

Delete an employee record using employee ID.

### 4. Fetch One Employee

Retrieve a specific employee's details using employee ID.

### 5. Fetch All Employees

Retrieve and display all employee records from the database.

## Sample Input

```
1
101
Sree
Developer
```

## Sample Output

```
Inserted
```

## Learning Outcomes

* Understanding JDBC architecture
* Database connectivity using Java
* PreparedStatement usage
* CRUD operations
* Layered architecture (Bean, DAO, Service, Utility)
* Exception handling in JDBC

