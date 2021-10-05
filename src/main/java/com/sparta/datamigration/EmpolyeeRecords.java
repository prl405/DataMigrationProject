package com.sparta.datamigration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class EmpolyeeRecords{
    private ArrayList<Employee> employeeData = new ArrayList<>();


    public void setEmployeeData(String[] array) {
        this.employeeData.add(new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6],
                cleanDate(array[7]), cleanDate(array[8]), Integer.parseInt(array[9])));
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

    public ArrayList<Employee> getEmployeeData() {
        return employeeData;
    }


}
