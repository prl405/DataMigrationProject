package com.sparta.datamigration.model;

import java.sql.*;

public class JDBCConnector {

    public static void createEmployeeDatabase(String dataBaseFileName){
        try(Connection con = DriverManager.getConnection("jdbc:sqlite:" + dataBaseFileName);
            Statement statement = con.createStatement();
        ) {
//            statement.executeUpdate("DROP TABLE TEST");
//            statement.executeUpdate("DROP TABLE TEST_TABLE");
            statement.executeUpdate("DROP TABLE EMPLOYEES");
            statement.executeUpdate("CREATE TABLE Employees(\n" +
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
                    con.prepareStatement("INSERT INTO EMPLOYEES(Emp_ID, Emp_ID,First_Name," +
                            "Middle_Name, Last_Name, Gender, Email, Date_of_Birth, Date_of_Job, Salary) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "A_Name");
            preparedStatement.setString(3, "A_Name");
            preparedStatement.execute();

            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
