# Finances Management Application

## Description

Our project is a Java-based budgeting system designed to give people and households an easy-to-use tool for managing their money in the most effective way. Our aim is to simplify the experience for our customers by enabling them to log and monitor their expenses, make budgets, and receive reminders when necessary for future payments and bills, with minimal inconveniences. We recognise that handling finances may be difficult.


Our major packages consist of our user implements, budgeting system, printing information, and UI elements. Our printing information implements most of our
user implements and communicates with our GUI. The budgeting system is used by the User implements as well as the printing information, and it segregates the user data into income, User info, and purchase info.
To allow for future classes to manipulate users easily, we set up a user manager interface. We also separated all of the printing information into different classes to more easily change aspects when we add more functionality, making it easier to diagnose and fix bugs if they ever come up. The total information class will be used in order to better manage the information classes at a later date,
and it will allow us to expand them further if need be.


Because there is a lot of user input necessary,
the GUI class handles creating users from user input as well as making and validating purchases based on user input. Our GUI is currently our largest class; this is by design to reduce the number of handlers needed for user input.
By allowing users to define budgets by category, this budgeting system gives customers the knowledge they need to plan their spending wisely and intelligently distribute monies. Additionally, it enables budget revision, reworking, and expenditure modification as the user's 
financial condition changes and evolves. A tool that determines the difference between earnings and spending over a period is also provided, along with record grouping, record searching by date, category, and price, and record grouping.
The system has payment notifications that allow users to manage their finances even more effectively and cautiously by keeping them informed about impending obligations.
In the event of any problems, users can easily erase records and alter purchase information. Our mission is to enable individuals and households to take charge of their financial lives and, in addition to defining financial goals, to realise them via careful planning. For anyone wishing to accurately and competently manage their finances, especially for time-constrained individuals and families, our budgeting system is a vital tool.
  
 *We hope you enjoy using this app!*

## Features

- Budgetting by category
- Record grouping and search
- Budget reworking
- Payment notifications
- Updating and deleting purchase information

## Installation and Running

To install the application, follow these steps:

1. Download the folder.
2. Open the jar file.

## Usage

Use the programme by doing the following:

1. Open the application.
2. Enter the desired user name in the "User Name" field.
3. Assign an income to the new user.
4. Choose the income frequency from the dropdown menu.
5. Click the "Insert New User" button.
6. After the user completes a transaction, select their name from the dropdown menu.
7. Input the transaction amount in the "Amount" field.
8. Enter the transaction date.
9. Decide between the "Purchase" and "Return" options.
10. Select the transaction category from the dropdown menu or simply type it in.
11. Click the "Insert Purchase" button.
12. To view a user's purchase history, select their name from the dropdown menu.
13. Press the "View Purchases" button.
14. If a transaction was logged incorrectly, locate the transaction ID.
15. Complete the required fields for the corrected transaction.
16. Click the "Replace Purchase Info" button.
17. Alternatively, remove the transaction using the "Delete Transaction" button.
18. If a user's income changes after the initial value was set, adjust it by entering the new amount in the "Income" field and pressing the "Extra Income" button.


## Contributors

- Avi Guttman
- Abdullah Djama
- Curtis Lecasse
- Ashkan Khademi
- Kavyan Nasseri

