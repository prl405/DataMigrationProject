package com.sparta.datamigration.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CopyOnWriteArrayList;

public class TableThreads implements Runnable{
    private CopyOnWriteArrayList<Employee> whichTable;
    private PreparedStatement thePrepStatement;
    private int lowerIndex;
    private int upperIndex;

    public void insertTableValues(CopyOnWriteArrayList<Employee> whichTable, PreparedStatement thePrepStatement,
                                  int lowerIndex, int upperIndex) {

            try {
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

//    public TableThreads(CopyOnWriteArrayList<Employee> whichTable, PreparedStatement thePrepStatement) {
//        this.whichTable = whichTable;
//        this.thePrepStatement = thePrepStatement;
//    }

    public TableThreads(CopyOnWriteArrayList<Employee> whichTable, PreparedStatement thePrepStatement, int lowerIndex, int upperIndex) {
        this.whichTable = whichTable;
        this.thePrepStatement = thePrepStatement;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }

    @Override
    public void run() {
        insertTableValues(this.whichTable, this.thePrepStatement, this.lowerIndex, this.upperIndex);
    }

}
