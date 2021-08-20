# EmployeesCSVReader
This program will import a given CSV and we will store these records as an array of records. In this case we have employees, and their details stored in the records. We have used arraylists along with a DAO and DTO to extract store the records into our java class. Once we have the list of records, we also used JAVA DBC to connect to our local database and export the records into the database.

To use the program, you must create a properties file which includes the url,username and password to your local mySQL database. You must also be using JDBC connector in order to access the database.

The program as it stands will read in the file and clear any duplicate values. It will then attempt to write each record that has been captured in a list to the database.
I have used concurrency by creating two threads which run along side each other. This will decrease execution time drastically.

To execute all of this, you must simply run the program whilst having the correct database schema.
