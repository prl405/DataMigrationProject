package com.sparta.datamigration;

import java.sql.Date;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String title;
    private String firstName;
    private String middleNameInitial;
    private String lastName;
    private String gender;
    private String email;
    private Date birthDate;
    private Date joinDate;
    private int salary;

    public Employee(int id, String title, String firstName, String middleNameInitial, String lastName, String gender, String email, Date birthDate, Date joinDate, int salary) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.middleNameInitial = middleNameInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.salary = salary;
    }
}
