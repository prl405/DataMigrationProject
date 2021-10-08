package com.sparta.datamigration.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableThreads implements Runnable{
    private ArrayList<Employee> whichTable;
    private int lowerIndex;
    private int upperIndex;
    private String sqlTableName;

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "DefaultUser";
    static final String PASS = "DUpassword";

    public void insertTableValues(ArrayList<Employee> whichTable, String sqlTableName,
                                  int lowerIndex, int upperIndex) {

            try(Connection theConnection = DriverManager.getConnection(DB_URL + "EmployeeRecs", USER, PASS)) {
                PreparedStatement thePrepStatement =
                        theConnection.prepareStatement("INSERT INTO " + sqlTableName + "(Emp_ID, Name_Prefix,First_Name," +
                                "Middle_Name, Last_Name, Gender, Email, Date_of_Birth, Date_of_Job, Salary) " +
                                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                for (int i = lowerIndex; i < upperIndex; i++) {
                    thePrepStatement.setString(1, Integer.toString(whichTable.get(i).getId()));
                    thePrepStatement.setString(2, whichTable.get(i).getTitle());
                    thePrepStatement.setString(3, whichTable.get(i).getFirstName());
                    thePrepStatement.setString(4, whichTable.get(i).getMiddleNameInitial());
                    thePrepStatement.setString(5, whichTable.get(i).getLastName());
                    thePrepStatement.setString(6, whichTable.get(i).getGender());
                    thePrepStatement.setString(7, whichTable.get(i).getEmail());
                    thePrepStatement.setString(8, String.valueOf(whichTable.get(i).getBirthDate()));
                    thePrepStatement.setString(9, String.valueOf(whichTable.get(i).getJoinDate()));
                    thePrepStatement.setString(10, Integer.toString(whichTable.get(i).getSalary()));
                    thePrepStatement.execute();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }

    public TableThreads(ArrayList<Employee> whichTable, String sqlTableName, int lowerIndex, int upperIndex) {
        this.whichTable = whichTable;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
        this.sqlTableName = sqlTableName;
    }

    @Override
    public void run() {
        insertTableValues(this.whichTable, this.sqlTableName, this.lowerIndex, this.upperIndex);
    }

}
