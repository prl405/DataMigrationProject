package com.sparta.datamigration.model;

import java.sql.*;

public class JDBCConnector {

    public static void createEmployeeDatabase(EmpolyeeRecords theData, String dataBaseFileName){
        try(Connection con = DriverManager.getConnection("jdbc:sqlite:" + dataBaseFileName);
            Statement statement = con.createStatement();

        ) {
//
            if (statement.execute("SELECT Emp_ID FROM Employees")){ // Checks if Ids call returns a valid object hence if it exists
                statement.executeUpdate("DROP TABLE Employees");
            }
            if (statement.execute("SELECT Emp_ID FROM DuplicateIds")){
                statement.executeUpdate("DROP TABLE DuplicateIds");
            }

            statement.executeUpdate("CREATE TABLE Employees(\n" +
                    "\t\tEmp_ID INT NOT NULL PRIMARY KEY,\n" +
                    "\t\tName_Prefix VARCHAR(10),\n" +
                    "\t\tFirst_Name TEXT NOT NULL,\n" +
                    "\t\tMiddle_Name TEXT,\n" +
                    "\t\tLast_Name TEXT,\n" +
                    "\t\tGender TEXT,\n" +
                    "\t\tEmail TEXT,\n" +
                    "\t\tDate_of_Birth DATE,\n" +
                    "\t\tDate_of_Job DATE,\n" +
                    "\t\tSalary INT\n" +
                    ")");

            statement.executeUpdate("CREATE TABLE DuplicateIds(\n" +
                    "\t\tEmp_ID INT NOT NULL PRIMARY KEY,\n" +
                    "\t\tName_Prefix TEXT,\n" +
                    "\t\tFirst_Name TEXT NOT NULL,\n" +
                    "\t\tMiddle_Name TEXT,\n" +
                    "\t\tLast_Name TEXT,\n" +
                    "\t\tGender TEXT,\n" +
                    "\t\tEmail TEXT,\n" +
                    "\t\tDate_of_Birth DATE,\n" +
                    "\t\tDate_of_Job DATE,\n" +
                    "\t\tSalary INT\n" +
                    ")");

            PreparedStatement preparedStatement =
                    con.prepareStatement("INSERT INTO EMPLOYEES(Emp_ID, Name_Prefix,First_Name," +
                            "Middle_Name, Last_Name, Gender, Email, Date_of_Birth, Date_of_Job, Salary) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement preparedStatementSC =
                    con.prepareStatement("INSERT INTO DuplicateIds(Emp_ID, Name_Prefix,First_Name," +
                            "Middle_Name, Last_Name, Gender, Email, Date_of_Birth, Date_of_Job, Salary) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


            for (Employee e: theData.getEmployeeData()){
                preparedStatement.setString(1, Integer.toString(e.getId()));
                preparedStatement.setString(2, e.getTitle());
                preparedStatement.setString(3, e.getFirstName());
                preparedStatement.setString(4, e.getMiddleNameInitial());
                preparedStatement.setString(5, e.getLastName());
                preparedStatement.setString(6, e.getGender());
                preparedStatement.setString(7, e.getEmail());
                preparedStatement.setString(8, String.valueOf(e.getBirthDate()));
                preparedStatement.setString(9, String.valueOf(e.getJoinDate()));
                preparedStatement.setString(10, Integer.toString(e.getSalary()));
                preparedStatement.execute();

            }

            for (Employee e: theData.getSpecialEmployeeData()){
                preparedStatementSC.setString(1, Integer.toString(e.getId()));
                preparedStatementSC.setString(2, e.getTitle());
                preparedStatementSC.setString(3, e.getFirstName());
                preparedStatementSC.setString(4, e.getMiddleNameInitial());
                preparedStatementSC.setString(5, e.getLastName());
                preparedStatementSC.setString(6, e.getGender());
                preparedStatementSC.setString(7, e.getEmail());
                preparedStatementSC.setString(8, String.valueOf(e.getBirthDate()));
                preparedStatementSC.setString(9, String.valueOf(e.getJoinDate()));
                preparedStatementSC.setString(10, Integer.toString(e.getSalary()));
                preparedStatementSC.execute();

            }


            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
