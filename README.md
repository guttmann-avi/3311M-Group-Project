# EECS 3311M-Group-Project
This project is a budgeting system built in java. Our major packages consist of our user implements, budgeting system, printing information,
and our UI elements. Our printing information implements most of our user implements, and it communicates with our GUI.
The budgeting system is used by the User implements as well as the printing information, and it segregates the user data into income,
User info, and purchase info. We decided to set up a user manager interface in order to allow for future classes to manipulate users easily.
We also seperated all of the printing information into different classes in order to more easily change aspects when we add more functionality.
This seperation also makes it easier to diagnose and fix bugs if they ever come up. The total information class will be used in order to better
manage the information classes at a later date, and it will allow us to expand them further if need be. 
As of now, our GUI class handles creating users from user input, as well as making and checking purchases based on user input.
The GUI handles this because there is a lot of user input required, so there is not a lot of logic classes  required for our program to function as of now.
The GUI being our biggest class was by design in order to lower the amount of handlers required for user input.