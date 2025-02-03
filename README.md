# pharmacy-management-system

This project is a Pharmacy Management System built using **Java** and **MySQL**. It allows doctors to manage medicines, update stock, and create promotional codes. Customers can make orders, view medicines, and apply promo codes for discounts. It uses **JDBC** for database connectivity and **SQL** for managing the backend.

## Features

### Doctor/Pharmacist Module
- **Add** new medicines to inventory.
- **Update** medicine details and stock quantities.
- **Remove** expired/discontinued medicines.
- **Generate** promotional discount codes.
- **View** complete medicine stock.
- **Login**: Doctors can log in with a username and password to access the menu.
  
<div>
  <img src="https://github.com/user-attachments/assets/fd1a914f-3b03-47d8-952c-bfcce9ec1ef8">
</div>


### Customer Menu
- **Make an order**: Customers can add medicines to their orders, check available stock, and calculate the total cost.
- **Delete an order**: Customers can delete their orders.
- **Browse medicines**: Customers can view all available medicines in the stock.
- **View order history**: Customers can view their order history with the ability to see the quantity and date of purchase.
- **Apply promocode**: Customers can use a promocode for a discount on their total order amount.
- **Track** medicine expiration dates.
<div>
  <img src="https://github.com/user-attachments/assets/bbddbbf0-d983-4346-bf9c-e74f8094051b">
</div>

###  Admin Features
- MySQL database backend.
- Role-based user authentication.
- Sales transaction recording.
- Inventory tracking system.
 
## Tech Stack
- **Java**: Core programming language for the project.
- **MySQL**: Database for storing medicine details, orders, promocodes, and user information.
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.

## Technologies Used
- **Core Language**: Java 17
- **Database**: MySQL 8.0
- **Database Connectivity**: JDBC
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA (Recommended)

## Getting Started

To set up this project locally, follow the instructions below:

### Prerequisites
1. **Java Development Kit (JDK)**: Ensure that Java 8 or higher is installed.
2. **MySQL Database**: MySQL server should be installed and running. You will also need a `PharmacyDB` database created in MySQL.
3. **IDE**: Any Java IDE (Eclipse, IntelliJ, NetBeans, etc.) will work.

### Setting up MySQL Database
1. Download and install MySQL from [here](https://dev.mysql.com/downloads/installer/).
2. Create a new database named `PharmacyDB` in MySQL and set up tables for medicines, orders, promocodes, customers, etc.
3. Modify the connection details in the Java code (`localhost`, `root`, `password`, etc.) to match your MySQL setup.

### Steps to Run
1. Clone the repository.
   ```bash
   git clone https://github.com/your-username/Pharmacy-Management-System.git




