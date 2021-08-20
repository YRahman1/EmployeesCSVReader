package com.sparta.yr.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class EmployeesDTO
{
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("M/d/yyyy");
    int employeeID;
    String namePref;
    String firstName;
    char midInitial;
    String lastName;
    char gender;
    String email;
    LocalDate birthDate;
    LocalDate jobStart;
    int salary;

    public EmployeesDTO(String[] csvData)
    {
        this.employeeID = Integer.parseInt(csvData[0]);
        this.namePref = csvData[1];
        this.firstName = csvData[2] ;
        this.midInitial = csvData[3].charAt(0);
        this.lastName = csvData[4];
        this.gender = csvData[5].charAt(0);
        this.email = csvData[6];
        this.birthDate = LocalDate.parse(csvData[7],dTF);
        this.jobStart = LocalDate.parse(csvData[8],dTF);
        this.salary = Integer.parseInt(csvData[9]);
    }

    public String getAllDetails()
    {
        String details = employeeID + "  " + namePref + "  " + firstName + "  " + midInitial + "  " + lastName + "  " + gender + "  " + email + "  " + birthDate + "  " + jobStart + "  " + salary;
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesDTO that = (EmployeesDTO) o;
        return employeeID == that.employeeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getNamePref() {
        return namePref;
    }

    public void setNamePref(String namePref) {
        this.namePref = namePref;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMidInitial() {
        return midInitial;
    }

    public void setMidInitial(char midInitial) {
        this.midInitial = midInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJobStart() {
        return jobStart;
    }

    public void setJobStart(LocalDate jobStart) {
        this.jobStart = jobStart;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
