package com.sparta.datamigration.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.regex.Matcher;

public class EmpolyeeRecords{
    private ArrayList<Employee> employeeData = new ArrayList<>();
    private ArrayList<Employee> specialEmployeeData = new ArrayList<>();
    private int employeeArrayLength;
    private int specialCasesLength;
    RegexValidator regexPatterns = new RegexValidator();

    public void setAllEmployeeData(String[] array) {

        Employee newEmployee = new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6],
                cleanDate(array[7]), cleanDate(array[8]), Integer.parseInt(array[9]));

        Matcher namePrefixMatcher = regexPatterns.getRegexNamePrefix().matcher(array[1]);
        Matcher firstNameMatcher = regexPatterns.getRegexName().matcher(array[2]);
        Matcher nameInitialsMatcher = regexPatterns.getRegexInitial().matcher(array[3]);
        Matcher lastNameMatcher = regexPatterns.getRegexName().matcher(array[4]);
        Matcher genderMatcher = regexPatterns.getRegexGender().matcher(array[5]);
        Matcher emailMatcher = regexPatterns.getRegexEmail().matcher(array[6]);

        if (this.employeeData.contains(newEmployee) || !emailMatcher.find() ||
                                                        !firstNameMatcher.find()||
                                                        !nameInitialsMatcher.find() ||
                                                        !lastNameMatcher.find() ||
                                                        !genderMatcher.find() ||
                                                        !namePrefixMatcher.find()){
            this.specialEmployeeData.add(newEmployee); // One of the duplicate rows are still in the main list
        }
        else{
            this.employeeData.add(newEmployee);
        }
    }

    public Date cleanDate(String csvDate){
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
