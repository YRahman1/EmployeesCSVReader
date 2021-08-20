package com.sparta.yr.util;

import com.sparta.yr.csvreader.FileIO;
import com.sparta.yr.dao.UserDAO;
import com.sparta.yr.dto.EmployeesDTO;
import com.sparta.yr.jdbc.ConnectionManager;
import com.sparta.yr.jdbc.Loader;

import java.util.ArrayList;

public class Action extends Thread
{
    private ArrayList<EmployeesDTO> subList;

    public Action(ArrayList<EmployeesDTO> subList)
    {
        this.subList = subList;
    }

    @Override
    public void run() {
        try {
            UserDAO userDAO = new UserDAO(ConnectionManager.connectToDB());
            FileIO fileIO = new FileIO();
            userDAO.createRecord(subList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}