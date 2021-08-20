package com.sparta.yr.jdbc;

import com.sparta.yr.csvreader.FileIO;
import com.sparta.yr.dto.EmployeesDTO;
import com.sparta.yr.jdbc.ConnectionManager;
import com.sparta.yr.dao.UserDAO;
import com.sparta.yr.util.ArraySpliter;

import java.util.ArrayList;

public class Loader
{

    public void populateWithTwolists()
    {
        FileIO fileIO = new FileIO();
        ArraySpliter ar = new ArraySpliter();
        UserDAO userDAO = new UserDAO(ConnectionManager.connectToDB());
        userDAO.truncateTable();
        long execTime = 0;
        long startTime = System.nanoTime();
        long finishTime = ar.split(fileIO.getEmployeeList());

        execTime = finishTime - startTime;
        System.out.println("It Took " + (execTime / 1000000000) + " seconds to fill the database.");

    }

}
