package com.sparta.datamigration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class EmpolyeeRecords implements RecordCreatable {
    ArrayList<Employee> employeeData;
    SimpleDateFormat dateFormater = new SimpleDateFormat("dd-mm-yyyy");

    @Override
    public EmpolyeeRecords arrayToEmployeeCollection(ArrayList<String[]> array) {
        for (String[] row: array){
            this.employeeData.add(new Employee(Integer.valueOf(row[0]), row[1], row[2], row[3], row[4], row[5], row[6],
                    cleanDate(row[7]), cleanDate(row[8]), Integer.valueOf(row[9])));
        }
        return null;
    }

    private Date cleanDate(String csvDate){
        if (csvDate == null){return null;}

        java.util.Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("MM/dd/yyyy").parse(csvDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date theDate = new java.sql.Date(utilDate.getTime());
        return theDate;
    }
}
