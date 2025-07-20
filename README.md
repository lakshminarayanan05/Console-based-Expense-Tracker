# 💰 Expense Tracker - Java JDBC Project

A simple console-based Expense Tracker application built using **Java**, **JDBC**, and **MySQL**. This application allows users to perform full CRUD operations on expense records, including storing, viewing, updating, and deleting expenses.

---

## 📁 Project Structure

ExpenseTracker/

│

├── dao/

│ └── ExpenseDAO.java # Handles all DB operations

│

├── model/

│ └── Expense.java # Expense entity class

│

├── ui/

│ └── Main.java # Handles user input/output operations

│

├── DBConnection.java # Manages database connection

├── Main.java # Console-based UI

---

## ✅ Features

- Add new expenses
- View all saved expenses
- Fetch a specific expense by ID
- Update existing expense
- Delete an expense
- Uses `LocalDate` for date handling

---

## 🔧 Technologies Used

- Java (JDK 8+)
- MySQL
- JDBC API

---

## ⚙️ Setup Instructions

### 🛠 Database Setup

1. **Create a database** named `expense_tracker` (or any name you prefer):

```sql
CREATE DATABASE expense_tracker;
USE expense_tracker;

Create the expense table:

CREATE TABLE expense (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    category VARCHAR(30),
    amount DOUBLE,
    description VARCHAR(100)
);
```
---

## 🧪 Example Operations

Add Expense
Input: Date, Category, Amount, Description

Action: Saves to database

View All Expenses
Lists all records from the expense table.

Get Expense by ID
Input: ID

Action: Fetches and displays matching record.

Update/Delete Expense
Input: ID

Action: Modify or delete the matching expense.

## 📌 Future Enhancements
    GUI using JavaFX or Swing
    Export reports as PDF/CSV
    User authentication system
    Web-based version using Spring Boot

## 🙍‍♂️ Contributor:

### Lakshmi Narayanan N
