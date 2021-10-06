package com.sparta.datamigration.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class EmpolyeeRecords{
    private ArrayList<Employee> employeeData = new ArrayList<>();
    private ArrayList<Employee> specialEmployeeData = new ArrayList<>();
    private int employeeArrayLength;
    private int specialCasesLength;


    public void setAllEmployeeData(String[] array) {
        Employee newEmployee = new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6],
                cleanDate(array[7]), cleanDate(array[8]), Integer.parseInt(array[9]));
        if (this.employeeData.contains(newEmployee)){ // One of the duplicate rows are still in the main list
            this.specialEmployeeData.add(newEmployee);
        }
        else{
            this.employeeData.add(newEmployee);
        }
    }

    private Date cleanDate(String csvDate){
        if (csvDate == null){return null;}

        java.util.Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("MM/dd/yyyy").parse(csvDate); // What if csvDate is not of the specified pattern?
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date theDate = new java.sql.Date(utilDate.getTime());
        return theDate;
    }


    public ArrayList<Employee> getEmployeeData() {
        return employeeData;
    }

    public ArrayList<Employee> getSpecialEmployeeData() {
        return specialEmployeeData;
    }

    public int getEmployeeArrayLength() {
        employeeArrayLength = employeeData.size();
        return employeeArrayLength;
    }

    public int getSpecialCasesLength() {
        specialCasesLength = specialEmployeeData.size();
        return specialCasesLength;
    }


}
