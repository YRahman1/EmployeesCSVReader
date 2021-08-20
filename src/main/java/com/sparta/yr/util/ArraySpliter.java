package com.sparta.yr.util;

import com.sparta.yr.csvreader.FileIO;
import com.sparta.yr.dto.EmployeesDTO;

import java.util.ArrayList;

public class ArraySpliter
{
    public long split(ArrayList<EmployeesDTO> employees)
    {
        FileIO fileIO = new FileIO();
        ArrayList<EmployeesDTO> distinctEmployees = fileIO.getDistinctList(employees);

        int splitLength = (distinctEmployees.toArray().length / 2) + 1;
        System.out.println("Array Split into 2 sublists of length: " + splitLength);
        ArrayList<EmployeesDTO> subList1 = new ArrayList<>(distinctEmployees.subList(0,splitLength)) ;
        ArrayList<EmployeesDTO> subList2 = new ArrayList<>(distinctEmployees.subList(splitLength + 1 , distinctEmployees.toArray().length)) ;
        Action action1 = new Action(subList1);
        Action action2 = new Action(subList2);

        action1.start();
        try {
            action1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action2.start();
        return System.nanoTime();
    }
}
