package com.sparta.datamigration.controller;

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
        JDBCConnector.createEmployeeTables(empolyeeRecords.getEmployeeData(), "Employees", 10);
        JDBCConnector.createEmployeeTables(empolyeeRecords.getSpecialEmployeeData(), "DuplicateIds", 1);
        timeTaken = timer.endTimer();
        UserMessages.displayDatabaseWriteRuntime(timeTaken);
        UserInput.retrieveData();

    }
}
