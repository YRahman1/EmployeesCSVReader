package com.sparta.yr;

import com.sparta.yr.csvreader.FileIO;
import com.sparta.yr.dao.UserDAO;
import com.sparta.yr.dto.EmployeesDTO;
import com.sparta.yr.jdbc.ConnectionManager;
import com.sparta.yr.jdbc.Loader;
import com.sparta.yr.util.ArraySpliter;

public class App
{
    public static void main(String args[])
    {
        Loader loader = new Loader();
        loader.populateWithTwolists();

    }
}

