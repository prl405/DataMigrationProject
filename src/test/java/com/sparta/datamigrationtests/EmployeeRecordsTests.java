package com.sparta.datamigrationtests;

import com.sparta.datamigration.controller.ReadHandler;
import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.EmpolyeeRecords;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeRecordsTests {
    EmpolyeeRecords testEmployeeRecords = ReadHandler.ReadFile("EmployeeTestCases.csv");


    @Test
    public void givenEmployeeTestData_ReturnCorrectArrayListOfEmployees(){
        ArrayList<Employee> correctArrayList = new ArrayList<>();

        correctArrayList.add(TestVariables.EMPLOYEE_1);
        correctArrayList.add(TestVariables.EMPLOYEE_2);
        correctArrayList.add(TestVariables.EMPLOYEE_3);
        correctArrayList.add(TestVariables.EMPLOYEE_4);


        assertArrayEquals(correctArrayList.toArray(), testEmployeeRecords.getEmployeeData().toArray());
    }


    @Test
    public void givenEmployeeTestData_ReturnCorrectArrayListOfSpecialCases(){
        ArrayList<Employee> correctSpecialCasesArrayList = new ArrayList<>();

        correctSpecialCasesArrayList.add(TestVariables.EMPLOYEE_5);

        assertArrayEquals(correctSpecialCasesArrayList.toArray(), testEmployeeRecords.getSpecialEmployeeData().toArray());
    }


}
