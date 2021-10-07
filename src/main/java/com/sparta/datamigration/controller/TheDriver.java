package com.sparta.datamigration.controller;

import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.EmpolyeeRecords;
import com.sparta.datamigration.model.JDBCConnector;
import com.sparta.datamigration.model.MyTimer;
import com.sparta.datamigration.view.UserInput;
import com.sparta.datamigration.view.UserMessages;

public class TheDriver {


    public static void initializer(String filname){
        MyTimer timer = new MyTimer();
        float timeTaken;

        timer.startTimer();
        EmpolyeeRecords empolyeeRecords = ReadHandler.ReadFile(filname);
        timeTaken = timer.endTimer();
        UserMessages.fileInputMessage(filname);
        UserMessages.resultsMessage(empolyeeRecords.getEmployeeArrayLength(),
                empolyeeRecords.getSpecialCasesLength());
        UserMessages.displayCollectionReadRuntime(timeTaken);

        timer.startTimer();
        JDBCConnector.createEmployeeDatabase();
        JDBCConnector.createEmployeeTables(empolyeeRecords);
        timeTaken = timer.endTimer();
        UserMessages.displayDatabaseWriteRuntime(timeTaken);
        UserInput.retrieveData();

//        Employee e = empolyeeRecords.getEmployeeData().get(0);
//        Employee e2 = empolyeeRecords.getEmployeeData().get(1);
//        Employee se = empolyeeRecords.getSpecialEmployeeData().get(0);
//        System.out.println(e.toString());
//        System.out.println(e2.toString());
//        System.out.println(se.toString());
    }
}
