package com.sparta.datamigration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(title, employee.title) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(middleNameInitial, employee.middleNameInitial) &&
                Objects.equals(lastName, employee.lastName) && Objects.equals(gender, employee.gender) &&
                Objects.equals(email, employee.email) && Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(joinDate, employee.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, firstName, middleNameInitial,
                lastName, gender, email, birthDate, joinDate, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleNameInitial='" + middleNameInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                '}';
    }
}
