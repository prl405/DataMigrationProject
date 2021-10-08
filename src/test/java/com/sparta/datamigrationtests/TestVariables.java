package com.sparta.datamigrationtests;

import com.sparta.datamigration.model.Employee;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TestVariables {
    public static final Employee employee1 = new Employee(198429, "Mrs.", "Serafina", "I",
            "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", cleanDate("9/21/1982"),
            cleanDate("2/1/2008"), 69294);

    public static final Employee employee2 = new Employee(178566, "Mrs.", "Juliette", "M",
            "Rojo", "F", "juliette.rojo@yahoo.co.uk", cleanDate("5/8/1967"), cleanDate("6/4/2011"),
            193912);

    public static final Employee employee3 = new Employee(647173, "Mr.", "Milan", "F", "Krawczyk",
            "M", "milan.krawczyk@hotmail.com", cleanDate("4/4/1980"), cleanDate("1/19/2012"), 123681);

    public static final Employee employee4 = new Employee(834635, "Hon.", "Deloise", "T", "Oyler",
            "F", "deloise.oyler@yahoo.com", cleanDate("9/4/1963"), cleanDate("1/6/2015"), 173977);

    public static final Employee employee5 = new Employee(834635, "Mrs.", "Serafina", "I",
            "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", cleanDate("9/21/1982"),
            cleanDate("2/1/2008"), 69294);


    private static Date cleanDate(String csvDate){
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


}
