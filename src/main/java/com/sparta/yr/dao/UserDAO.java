package com.sparta.yr.dao;

import com.sparta.yr.csvreader.FileIO;
import com.sparta.yr.dto.EmployeesDTO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserDAO
{

    private Connection connection;
    private Statement statement;

    public UserDAO(Connection connection)
    {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void truncateTable()
    {
        try {
            statement.execute("truncate employees_db.employees");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getNumberOfRecsPresent()
    {
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM employees_db.employees");
            resultSet.next();
            int count = resultSet.getInt(1);
            System.out.println("There are " + count + " number of records in the table.");
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void createRecord(ArrayList<EmployeesDTO> employees)
    {
        try {
            int numOfRecords = 0;
            for(EmployeesDTO e : employees)
            {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employees_db`.`employees` (`employee_ID`, `Name_Prefix`, `First_Name`, `Middle_Initial`, `Last_Name`, `Gender`, `Email`, `DoB`, `Join_Date`, `Salary`)" + " VALUES (?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, e.getEmployeeID());
                preparedStatement.setString(2, e.getNamePref());
                preparedStatement.setString(3, e.getFirstName());
                preparedStatement.setString(4, String.valueOf(e.getMidInitial()));
                preparedStatement.setString(5, e.getLastName());
                preparedStatement.setString(6, String.valueOf(e.getGender()));
                preparedStatement.setString(7, e.getEmail());
                preparedStatement.setDate(8, Date.valueOf(e.getBirthDate()));
                preparedStatement.setDate(9, Date.valueOf(e.getJobStart()));
                preparedStatement.setInt(10, e.getSalary());
                preparedStatement.execute();
                numOfRecords++;
            }

            System.out.println("Populated " + numOfRecords + " number of users." );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

//    public void printEmployees(ArrayList<EmployeesDTO> employeeList)
//    {
//        int numOfRecords = 0;
//        for(int i = 0;i < employeeList.size(); i++)
//        {
//            System.out.println(employeeList.get(i).getEmployeeID() + " - " +employeeList.get(i).getFirstName());
//            numOfRecords = i;
//        }
//    }
