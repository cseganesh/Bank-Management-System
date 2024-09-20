# Banking System Application

This project is a **Java-based desktop application** simulating basic ATM functionalities, built using **Java Swing** for the frontend and **MySQL** for database management. It features modules for account login, signup, transactions, and other ATM operations such as deposits and withdrawals.

## Features

1. **Login System**
   - Users can securely log into their bank accounts using card number and PIN.
   - Provides validation and error handling for incorrect credentials.

2. **Account Signup**
   - Multi-page account creation process.
   - Collects personal details (name, father's name, DOB, email, address, etc.).
   - Stores information securely in the MySQL database.

3. **ATM Transactions**
   - Options for cash withdrawal, deposit, fast cash, balance inquiry, mini statement, and PIN change.
   - Users can view recent transactions and check account balances.

4. **Database Integration**
   - All user data and transaction records are stored in a **MySQL** database.
   - **SQL Queries** are used for secure retrieval and storage of information.

## Technologies Used

- **Java**: Backend logic and frontend GUI.
- **Java Swing**: For building the graphical user interface.
- **MySQL**: Database for storing user details and transactions.
- **JDBC**: For database connectivity.

## Login page
![Screenshot 2024-09-20 170514](https://github.com/user-attachments/assets/97994dfb-3925-46cc-b80f-3f85ab3ca699)

## Signup Screen (Page 1 - Personal Details)
![Screenshot 2024-09-20 171003](https://github.com/user-attachments/assets/a5bc7daa-c671-4eac-b192-3c7af461d485)

## Signup Screen (Page 2 - Personal Details)
![Screenshot 2024-09-20 172003](https://github.com/user-attachments/assets/af4afae4-90ee-41dc-8749-276ac98504c6)

## Signup Screen (Page 3 - Account Details)
![Screenshot 2024-09-20 173411](https://github.com/user-attachments/assets/4a5a8051-a161-4215-80d0-16f97544b3e5)

## ATM Transactions Screen
![Screenshot 2024-09-20 174515](https://github.com/user-attachments/assets/2f15389e-6d85-425e-b7a6-2d3e96968067)

## Deposit Screen
![Screenshot 2024-09-20 175057](https://github.com/user-attachments/assets/6a9e017a-3553-4f5a-b51d-0ffca47abbc3)

## Withdraw Screen
![Screenshot 2024-09-20 175444](https://github.com/user-attachments/assets/d08a605e-6893-4771-877e-56992d07ac46)

## Fast Cash Screen
![Screenshot 2024-09-20 180004](https://github.com/user-attachments/assets/1270f624-1cbd-41ab-9744-ec5c00cf1315)

## PIN Change Screen
![Screenshot 2024-09-20 184445](https://github.com/user-attachments/assets/1e67726a-3bea-414e-86b2-6d194a362da2)

## Balance Inquiry Screen
![Screenshot 2024-09-20 184730](https://github.com/user-attachments/assets/5cc385b0-9305-4862-bf8c-f09b98eec21d)


## System Requirements

To run the Banking System application, you need the following setup:

### Hardware:
- **Processor**: Dual-Core or higher
- **RAM**: 4 GB or higher
- **Disk Space**: Minimum 500 MB of free space for database and application files
- **Display**: 1024x768 resolution or higher

### Software:
- **Operating System**: 
  - Windows 11 or later
  - Linux (any distribution)
  - macOS (version 10.10 or later)
- **Java Development Kit (JDK)**: Version 8 or higher
- **MySQL**: Version 5.7 or higher
- **JDBC Driver**: MySQL Connector/J
- **IDE**: Any Java Integrated Development Environment (IDE), such as:
  - IntelliJ IDEA
  - Eclipse
  - NetBeans
 
## Conclusion

The Banking System project is a comprehensive simulation of a basic ATM system, developed using Java Swing for the user interface and MySQL for database management. This project covers essential banking functionalities, including account creation, login, deposits, withdrawals, balance inquiry, and mini-statements. 

By integrating secure login and database operations, the system ensures data consistency and transaction integrity. With simple yet robust features, this project is suitable for beginners to intermediate Java developers aiming to understand how desktop applications interact with databases through JDBC.
