Banking Application
-------------------

A console-based Java application for managing customers, transactions, and accounts. It simulates banking features such as account creation, withdrawal, deposit, account transfer, and viewing transaction history.

Table of Contents
--------------------

Introduction
Features
Project Structure
Key Functionalities
Application Flow
Sample Interaction

Introduction
------------
The Banking Application is a Java-based console program that allows users to perform basic banking operations. It includes features for managing customer data, handling transactions, and maintaining account balances securely.

Features
----------
Customer Management
Add new customers.
Display the list of customers.
Banking Operations
ATM Withdrawal: Withdraw money from an account.
Cash Deposit: Deposit money into an account.
Account Transfer: Transfer funds between two accounts.
View Statement: View detailed transaction history.
Top N Customers
Displays customers ranked by their account balance.

Password Encryption
All passwords are encrypted using a custom encryption algorithm.


Project Structure
Packages
com.kannanrameshrk: Main application logic.
com.kannanrameshrk.baseview: Handles user interaction and application flow.
com.kannanrameshrk.dto: Data models for customers and transactions.
com.kannanrameshrk.repository: Stores and manages application data.
Classes
Main Class

Entry point of the application.
Initializes the BaseView class to start the application.
BaseView Class

Displays menus for user interaction.
Provides options for customer management and banking operations.
BaseViewModel Class

Acts as a bridge between BaseView and Repository.
Handles data initialization and transaction history retrieval.
Repository Class

Manages application data (e.g., customer list).
Provides access to customer information.
Customer Class

Attributes:
custId, accountNo, name, balance, password (encrypted), tranData (transaction list).
Transaction Class

Attributes:
tId, tranType, amount, balance.
Key Functionalities
1. Customer Addition
Validates password strength:
Minimum 6 characters, at least 2 uppercase, 2 lowercase, and 2 digits.
Encrypts passwords using a custom algorithm (e.g., shifts characters).

3. ATM Withdrawal
Validates user password.
Ensures a minimum balance of ₹1000 post-transaction.

5. Cash Deposit
Updates the account balance.
Records the transaction in the user's history.

7. Account Transfer
Transfers funds between accounts after validation.
Updates both sender and receiver balances.

9. Transaction Statement
Displays all transactions for a user.
10. Top N Customers
Displays customers ranked by balance in descending order.

Application Flow:

1. Show Customers  
2. Add Customers  
3. Operations  
4. Top N Customers  
5. Exit  

Banking Operations Menu:

1. ATM Withdrawal  
2. Cash Deposit  
3. Account Transfer  
4. Statement  
5. Exit  

Sample Interaction
1. Main Menu Example

1. Show Customers  
2. Add Customers  
3. Operations  
4. Top N Customers  
5. Exit  
Enter Your Choice: 1  


2. Customer List Output
CusId   AccountNo   Name    Balance   EncryptedPwd  
---------------------------------------------------  
11      11011       Kumar   10000.0   ApipNbjm23  
12      11012       Madhu   20000.0   CBoljoh23  
13      11013       Rahul   30000.0   DBnqvt23  
14      11014       Robin   40000.0   KBwb22  

3. Add Customer

Enter Name: Ramesh  
Enter Password: 12RKkannan  
Enter ReType Password: 12RKkannan  
Customer Added Successfully!  

4. Banking Operation Example
ATM Withdrawal

Enter Your Password: 12RKkannan  
Enter Withdraw Amount: 2000  
ATM Withdrawal Successfully!  

View Statement

ID: 15  
Name: Ramesh  
Account No: 11015  

---------------------------------------------  
TransId   TransType       Amount   Balance  
---------------------------------------------  
1         Opening         10000.0  10000.0  
2         ATM Withdrawal   2000.0   8000.0  
3         Cash Deposit     4000.0  12000.0  
4         Transfer To 11011 2000.0 10000.0  
---------------------------------------------  
