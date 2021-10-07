package com.sparta.datamigration.view;

import java.sql.*;
import java.util.Scanner;

public class UserInput {

    public static void retrieveData() {
        String employeeID;
        String choice = "y";
        Scanner scan = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + "testfilename.db");
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
