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

        correctArrayList.add(TestVariables.employee1);
        correctArrayList.add(TestVariables.employee2);
        correctArrayList.add(TestVariables.employee3);
        correctArrayList.add(TestVariables.employee4);


        assertArrayEquals(correctArrayList.toArray(), testEmployeeRecords.getEmployeeData().toArray());
    }


    @Test
    public void givenEmployeeTestData_ReturnCorrectArrayListOfSpecialCases(){
        ArrayList<Employee> correctSpecialCasesArrayList = new ArrayList<>();

        correctSpecialCasesArrayList.add(TestVariables.employee5);

        assertArrayEquals(correctSpecialCasesArrayList.toArray(), testEmployeeRecords.getSpecialEmployeeData().toArray());
    }


}
