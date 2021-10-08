# Data Migration Project

## Description
This program migrates Employee data stored in CSV files into a MySQL local database using JDBC.

## Instructions
1. The function called in main method 'initializer()' takes the inputted Employee CSV file which then begins the process of creating a collection in Java preparing for writing to the database.

2. In the terminal once the process has been completed, you will have the option to either input a valid Employee_ID to retrieve a name from the MySQL database or exit the program.

3. If you have not exited the program at this point, then you should be able to see the returned corresponding Name of the respective Employee_ID.

4. Again at this point you have the option to exit the program, or retrieve another name from the MySQL database repeating step 2.

5. To change the number of threads per table used you must change the last argument of line 26 and 27 in the 'TheDriver' class.

#### Design Choices
##### Model-View-Controller
Separated components of the project to follow the MVC design pattern.
##### Data Validation
Basic data validation of Employee data fields using Regex patterns.
##### Multi-Threading
As the data from the CSV file is passed through the program, the data is stored in an ArrayList. As the program does not change the ArrayList in any way whilst threads read batches of the data into MySQL, it does not matter that the ArrayList is not thread-safe.

Small CSV:
  Approximate Average time with 1 thread per table: 30s
  Approximate Average Time with 8 threads per table: 7s
Large CSV:
  Approximate Average time with 1 thread per table: 500s
  Approximate Average Time with 10 threads per table: 115s

##### MySQL
The project first started out with the idea of writing all the data into SQLite. However, since SQLite did not support multi-threaded writing to the database, a requirement of the project, I switched to MySQL which did allow for it.


#### Future Additions
##### User Input Selection Validation
Currently if you input an incorrect command the program exits with no warning.
##### Streaming File Read Process with Functional Programming
