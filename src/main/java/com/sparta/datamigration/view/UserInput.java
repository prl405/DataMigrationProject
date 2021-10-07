package com.sparta.datamigration.view;

import com.sparta.datamigration.model.JDBCConnector;

import java.sql.*;
import java.util.Scanner;

public class UserInput {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "DefaultUser";
    static final String PASS = "DUpassword";

    public static void retrieveData() {
        String employeeID;
        String choice = "y";
        Scanner scan = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(DB_URL + "EmployeeRecs", USER, PASS);
             Statement statement = con.createStatement();
        ) {
            while (choice.equals("y")) {
                System.out.println("Write a Employee ID retrieve data from the database.");
                employeeID = scan.next();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees WHERE Emp_ID = '" + employeeID + "'");
                while (resultSet.next()){
                    System.out.println("Name :" + resultSet.getString("FIRST_NAME") + " " +
                        resultSet.getString("LAST_NAME"));
                }
                System.out.println("Would you like to retrieve more data?");
                System.out.println("Yes: y");
                System.out.println("Exit: x");
                choice = scan.next();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("Program exited.");
    }
}
