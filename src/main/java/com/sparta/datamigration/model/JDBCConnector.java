package com.sparta.datamigration.model;

import java.sql.*;

public class JDBCConnector {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "DefaultUser";
    static final String PASS = "DUpassword";

    public static void createEmployeeDatabase(){
        try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = con.createStatement();

        ) {
          statement.executeUpdate("CREATE DATABASE IF NOT EXISTS EmployeeRecs");

            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEmployeeTables(EmpolyeeRecords theData){
        try(Connection con = DriverManager.getConnection(DB_URL + "EmployeeRecs", USER, PASS);
            Statement statement = con.createStatement();

        ) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS EmployeeRecs");
            if (statement.execute("SELECT Emp_ID FROM Employees")){ // Checks if Ids call returns a valid object hence if it exists
                statement.executeUpdate("DROP TABLE Employees");
            }
            if (statement.execute("SELECT Emp_ID FROM DuplicateIds")){
                statement.executeUpdate("DROP TABLE DuplicateIds");
            }

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Employees(\n" +
                    "\t\tEmp_ID INT NOT NULL PRIMARY KEY,\n" +
                    "\t\tName_Prefix VARCHAR(50),\n" +
                    "\t\tFirst_Name VARCHAR(50) NOT NULL,\n" +
                    "\t\tMiddle_Name VARCHAR(50),\n" +
                    "\t\tLast_Name VARCHAR(50),\n" +
                    "\t\tGender VARCHAR(50),\n" +
                    "\t\tEmail VARCHAR(50),\n" +
                    "\t\tDate_of_Birth DATE,\n" +
                    "\t\tDate_of_Job DATE,\n" +
                    "\t\tSalary INT\n" +
                    ")");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS DuplicateIds(\n" +
                    "\t\tEmp_ID INT NOT NULL PRIMARY KEY,\n" +
                    "\t\tName_Prefix VARCHAR(50),\n" +
                    "\t\tFirst_Name VARCHAR(50) NOT NULL,\n" +
                    "\t\tMiddle_Name VARCHAR(50),\n" +
                    "\t\tLast_Name VARCHAR(50),\n" +
                    "\t\tGender VARCHAR(50),\n" +
                    "\t\tEmail VARCHAR(50),\n" +
                    "\t\tDate_of_Birth DATE,\n" +
                    "\t\tDate_of_Job DATE,\n" +
                    "\t\tSalary INT\n" +
                    ")");

//            PreparedStatement thePrepStatement =
//                    theConnection.prepareStatement("INSERT INTO EMPLOYEES(Emp_ID, Name_Prefix,First_Name," +
//                            "Middle_Name, Last_Name, Gender, Email, Date_of_Birth, Date_of_Job, Salary) " +
//                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

//            PreparedStatement preparedStatementSC =
//                    con.prepareStatement("INSERT INTO DuplicateIds(Emp_ID, Name_Prefix,First_Name," +
//                            "Middle_Name, Last_Name, Gender, Email, Date_of_Birth, Date_of_Job, Salary) " +
//                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


//            for (Employee e: theData.getEmployeeData()){
//                preparedStatement.setString(1, Integer.toString(e.getId()));
//                preparedStatement.setString(2, e.getTitle());
//                preparedStatement.setString(3, e.getFirstName());
//                preparedStatement.setString(4, e.getMiddleNameInitial());
//                preparedStatement.setString(5, e.getLastName());
//                preparedStatement.setString(6, e.getGender());
//                preparedStatement.setString(7, e.getEmail());
//                preparedStatement.setString(8, String.valueOf(e.getBirthDate()));
//                preparedStatement.setString(9, String.valueOf(e.getJoinDate()));
//                preparedStatement.setString(10, Integer.toString(e.getSalary()));
//                preparedStatement.execute();
//
//            }

            TableThreads table1 = new TableThreads(theData.getEmployeeData(), "Employees", con, 0,
                    theData.getEmployeeArrayLength()/2);
            Thread t1 = new Thread(table1);
            t1.start();

            TableThreads table3 = new TableThreads(theData.getEmployeeData(),"Employees", con,
                    (theData.getEmployeeArrayLength()/2), theData.getEmployeeArrayLength());
            Thread t3 = new Thread(table3);
            t3.start();

            TableThreads table2 = new TableThreads(theData.getSpecialEmployeeData(), "DuplicateIds", con,
                    0, theData.getSpecialCasesLength());
            Thread t2 = new Thread(table2);
            t2.start();

            t1.join();
            t3.join();
            t2.join();


//            for (Employee e: theData.getSpecialEmployeeData()){
//                preparedStatementSC.setString(1, Integer.toString(e.getId()));
//                preparedStatementSC.setString(2, e.getTitle());
//                preparedStatementSC.setString(3, e.getFirstName());
//                preparedStatementSC.setString(4, e.getMiddleNameInitial());
//                preparedStatementSC.setString(5, e.getLastName());
//                preparedStatementSC.setString(6, e.getGender());
//                preparedStatementSC.setString(7, e.getEmail());
//                preparedStatementSC.setString(8, String.valueOf(e.getBirthDate()));
//                preparedStatementSC.setString(9, String.valueOf(e.getJoinDate()));
//                preparedStatementSC.setString(10, Integer.toString(e.getSalary()));
//                preparedStatementSC.execute();
//
//            }


            System.out.println("Tables created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
