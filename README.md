# 🍴 Food Plaza

## 📌 Overview
Food Plaza is a web-based application for online food ordering and management.  
It enables **customers** to register, browse food items, add them to a cart, and place orders, while **admins** can manage food items and monitor customers.  

This project is developed using **Java Servlets, JSP, JDBC, and MySQL**, and deployed on **Apache Tomcat**.

---

## 🚀 Features
### 👤 Customer
- User registration and login  
- Browse available food items  
- Add/Remove items from the cart  
- Place and track orders  

### 👨‍💼 Admin
- Add, update, and delete food items  
- View customer details  
- Manage orders  

---

## 🛠️ Tech Stack
- **Frontend**: JSP, HTML, CSS  
- **Backend**: Java (Servlets, JSP)  
- **Database**: MySQL (via JDBC)  
- **Server**: Apache Tomcat  

---

## ⚙️ Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/komalthokal/Food_Plaza.git

2.Import the project into Eclipse/IntelliJ.
3.Configure the database:
  -Create a database fs in MySQL.
  -Run the SQL script provided (fs.sql).
  -Update DB credentials in DBUtil.java:
    private static final String URL = "jdbc:mysql://localhost:3306/fs";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

4.Deploy the project on Apache Tomcat (v9 or above).
5.Start Tomcat and open:
 http://localhost:8080/Food_Plaza/
