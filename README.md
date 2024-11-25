
   
Banking Application Documentation
1. Introduction
The Banking Application is a console-based Java program that provides basic banking operations such as managing customers, transactions, and accounts. It simulates features like account creation, withdrawal, deposit, account transfer, and transaction history.

2. Application Features
Customer Management:

Add a new customer.
Display the list of customers.
Banking Operations:

ATM Withdrawal: Withdraw money from a customer account.
Cash Deposit: Deposit money into a customer account.
Account Transfer: Transfer money between accounts.
View Statement: View account transaction history.
Top N Customers:

Display customers ranked by account balance.
Encryption:

Passwords are encrypted using a custom encryption algorithm.
3. Project Structure
Packages
com.kannanrameshrk: Main application logic.
com.kannanrameshrk.baseview: Handles user interaction and application flow.
com.kannanrameshrk.dto: Contains data models (Customer and Transaction).
com.kannanrameshrk.repository: Stores and manages application data.
Classes and Descriptions
1. Main Class
Package: com.kannanrameshrk
Functionality:
Entry point of the application.
Initializes the BaseView class to start the application.
2. BaseView Class
Package: com.kannanrameshrk.baseview
Responsibilities:
Displays menus for the user to interact with.
Provides options for customer management and banking operations.
3. BaseViewModel Class
Package: com.kannanrameshrk.baseview
Responsibilities:
Acts as a bridge between BaseView and Repository.
Handles data initialization and provides transaction history.
4. Repository Class
Package: com.kannanrameshrk.repository
Responsibilities:
Stores application data (customerList).
Provides access to customer data.
5. Customer Class
Package: com.kannanrameshrk.dto
Attributes:
custId: Unique identifier for the customer.
accountNo: Customer's account number.
name: Customer's name.
balance: Account balance.
password: Encrypted password.
tranData: List of transactions associated with the customer.
6. Transaction Class
Package: com.kannanrameshrk.dto
Attributes:
tId: Transaction ID.
tranType: Type of transaction (e.g., Deposit, Withdrawal).
amount: Transaction amount.
balance: Balance after the transaction.
4. Key Functionalities
Customer Addition
Validates password strength (minimum 6 characters, at least 2 uppercase, 2 lowercase, and 2 digits).
Encrypts the password using a custom logic:
Shifts characters (e.g., A → B, 1 → 2).
ATM Withdrawal
Validates user password.
Ensures minimum balance of 1000 is maintained post-transaction.
Cash Deposit
Updates customer balance after deposit.
Records the transaction.
Account Transfer
Transfers funds between two accounts.
Validates recipient account and password.
Transaction Statement
Displays all transactions for the user.
Top N Customers
Displays all customers sorted by their balance in descending order.
5. Application Flow
Main Menu:

1. Show Customers: Displays all registered customers.
2. Add Customers: Adds a new customer after validation.
3. Operations: Provides options for ATM Withdrawal, Cash Deposit, Account Transfer, and Statement.
4. Top N Customers: Displays customers sorted by balance.
5. Exit: Closes the application.
User Operations:

For each operation, the user is prompted to enter details such as User ID and Password.
Passwords are encrypted and matched for authentication.
   
   Banking App
		*********
1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
1
CusId   AccountNo   Name   Balance   EncryptedPwd
--------------------------------------------------------
11      11011      Kumar    10000.0  ApipNbjm23
12      11012      Madhu    20000.0  CBoljoh23
13      11013      Rahual    30000.0  DBnqvt23
14      11014      Robin    40000.0  KBwb22
--------------------------------------------------------

1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
2
		 Add Customer
		*************
Enter Name:
Ramesh
Enter Password:
12RKkannan
Enter ReType Password:
12RKkannan
Customer Added successfully...
1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
3
		Bank Operation
		*************
Enter Your User ID:
15
Enter Your Password:
12RKkannan

1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
1
		ATM WithDraw
		**********
Enter Your Password:
12RKkannan
Enter Withdraw Amount:
2000
ATM WithDraw Successfully



1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
2
		 Cash Deposit
		*************
Enter Deposit Amount:
4000
Enter Your Password:
12RKkannan
Cash Deposit Successfully..


1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
3
		Account Transfer
		 ***********
Enter Oppsite Person Accno:
11011
Enter Transfer Amount:
2000
Enter Your Password:
12RKkannan
Account Transfer Successfully


1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
4
		Account Statement
		******************
ID - 15
Name - Ramesh
Account No - 11015

---------------------------------------------
 TransId    TransType     Amount    Balance
---------------------------------------------
1         Opening   10000.0    10000.0
2         ATMWithdrawal   2000.0    8000.0
2         CashDeposit   4000.0    12000.0
2         Transfer To 11011   2000.0    10000.0
---------------------------------------------

1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
5

1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
4
		Top N Customer
		************
CusId   AccountNo   Name   Balance   EncryptedPwd
--------------------------------------------------
14      11014      Robin    40000.0  KBwb22
13      11013      Rahual    30000.0  DBnqvt23
12      11012      Madhu    20000.0  CBoljoh23
11      11011      Kumar    12000.0  ApipNbjm23
15      11015      Ramesh    10000.0  23SLlboobo
-----------------------------------------------------
1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
3
		Bank Operation
		*************
Enter Your User ID:
15
Enter Your Password:
12RKkannan

1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
4
		Account Statement
		******************
ID - 15
Name - Ramesh
Account No - 11015

---------------------------------------------
 TransId    TransType     Amount    Balance
---------------------------------------------
1         Opening   10000.0    10000.0
2         ATMWithdrawal   2000.0    8000.0
2         CashDeposit   4000.0    12000.0
2         Transfer To 11011   2000.0    10000.0
---------------------------------------------

1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
5

1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
3
		Bank Operation
		*************
Enter Your User ID:
11
Enter Your Password:
ZohoMail12

1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
4
		Account Statement
		******************
ID - 11
Name - Kumar
Account No - 11011

---------------------------------------------
 TransId    TransType     Amount    Balance
---------------------------------------------
1         Opening   10000.0    10000.0
2         Transfer From 11015   2000.0    12000.0
---------------------------------------------

1.ATM WithDraw
2.Cash Deposit
3.Account Transfer
4.Statement
5.Exit
Enter Your Choice:
5

1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
4
		Top N Customer
		************
CusId   AccountNo   Name   Balance   EncryptedPwd
--------------------------------------------------
14      11014      Robin    40000.0  KBwb22
13      11013      Rahual    30000.0  DBnqvt23
12      11012      Madhu    20000.0  CBoljoh23
11      11011      Kumar    12000.0  ApipNbjm23
15      11015      Ramesh    10000.0  23SLlboobo
-----------------------------------------------------
1.show Customers
2.AddCustomers
3.Operations
4.Top n Customer
5.Exit
Enter Your Choice:
