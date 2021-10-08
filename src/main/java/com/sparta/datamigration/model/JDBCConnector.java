package com.sparta.datamigration.model;

import java.sql.*;
import java.util.ArrayList;

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

    public static void createEmployeeTables(ArrayList<Employee> employeeArrayList, String tableName, int numberOfThreads){
        try(Connection con = DriverManager.getConnection(DB_URL + "EmployeeRecs", USER, PASS);
            Statement statement = con.createStatement();

        ) {

            if (statement.execute("SELECT Emp_ID FROM " + tableName)){ // Checks if Ids call returns a valid object hence if it exists
                statement.executeUpdate("DROP TABLE " + tableName);
            }

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + "(\n" +
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

            startThreads(divideThreads(employeeArrayList, numberOfThreads, tableName));


            System.out.println("Table: " + tableName + " created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Thread> divideThreads(ArrayList<Employee> employeeArrayList, int numberOfThreads,
                                      String tableName){
        ArrayList<Thread> theThreads = new ArrayList<>();

        for(int i = 0; i < numberOfThreads; i++){
            TableThreads table = new TableThreads(employeeArrayList, tableName,
                    (employeeArrayList.size()/numberOfThreads) * i,
                    (employeeArrayList.size()/numberOfThreads) * (i + 1)); //Divide array up

            theThreads.add(new Thread(table));
        }
        return theThreads;
    }

    private static void startThreads(ArrayList<Thread> theThreads) throws InterruptedException{
        for (Thread t: theThreads){
            t.start();
        }

        for(Thread t: theThreads){
            t.join();
        }
    }

}
