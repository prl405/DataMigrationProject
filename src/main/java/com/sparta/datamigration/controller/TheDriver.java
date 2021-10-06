package com.sparta.datamigration.controller;

import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.EmpolyeeRecords;
import com.sparta.datamigration.model.JDBCConnector;
import com.sparta.datamigration.view.UserMessages;

public class TheDriver {
    public static void initializer(String filname){
        EmpolyeeRecords empolyeeRecords = ReadHandler.ReadFile(filname);
        UserMessages.fileInputMessage(filname);
        UserMessages.resultsMessage(empolyeeRecords.getEmployeeArrayLength(),
                empolyeeRecords.getSpecialCasesLength());

        JDBCConnector.createEmployeeDatabase(empolyeeRecords, "testfilename.db");

//        Employee e = empolyeeRecords.getEmployeeData().get(0);
//        Employee e2 = empolyeeRecords.getEmployeeData().get(1);
//        Employee se = empolyeeRecords.getSpecialEmployeeData().get(0);
//        System.out.println(e.toString());
//        System.out.println(e2.toString());
//        System.out.println(se.toString());
    }
}
