package com.sparta.datamigration.model;

import com.sparta.datamigration.controller.TheDriver;

public class Program {
    public static void main(String[] args) {
//        ReadHandler reader = new ReadHandler();
//        ArrayList<String[]> temp = new ArrayList<>();
//        System.out.println(Arrays.toString(reader.ReadFile("EmployeeRecords.csv").get(1)));

//        EmpolyeeRecords test = ReadHandler.ReadFile("EmployeeRecords.csv");
//        Employee e = test.getEmployeeData().get(0);
//        Employee e2 = test.getEmployeeData().get(1);
//        Employee se = test.getSpecialEmployeeData().get(0);
//        System.out.println(e.toString());
//        System.out.println(e2.toString());
//        System.out.println(se.toString());
//        System.out.println(test.getEmployeeArrayLength());
//        System.out.println(test.getSpecialCasesLength());
        TheDriver.initializer("EmployeeRecords.csv");
//        JDBCConnector.createEmployeeDatabase("testfilename.db");

    }


}
