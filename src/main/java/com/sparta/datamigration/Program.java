package com.sparta.datamigration;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
//        ReadHandler reader = new ReadHandler();
//        ArrayList<String[]> temp = new ArrayList<>();
//        System.out.println(Arrays.toString(reader.ReadFile("EmployeeRecords.csv").get(1)));

        EmpolyeeRecords test = ReadHandler.ReadFile("EmployeeRecords.csv");
        Employee e = test.getEmployeeData().get(0);
        Employee e2 = test.getEmployeeData().get(1);
        System.out.println(e.toString());
        System.out.println(e2.toString());

//        String[] abc = {"123", "543", "omg"};
//        System.out.println(Integer.parseInt(abc[0]));
    }


}
