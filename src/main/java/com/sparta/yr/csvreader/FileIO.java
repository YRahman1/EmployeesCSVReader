package com.sparta.yr.csvreader;
import com.sparta.yr.dto.EmployeesDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO
{
    public void readFile()
    {
        try {
            FileReader fileReader = new FileReader("src/main/resources/EmployeeRecordsLarge.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

            for(String nextLine= bufferedReader.readLine(); nextLine != null; nextLine = bufferedReader.readLine())
            {
                System.out.println(nextLine.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<EmployeesDTO> getEmployeeList()
    {
        int counter = 0;
        try {
            FileReader fileReader = new FileReader("src/main/resources/EmployeeRecords.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String firstLine = bufferedReader.readLine();
            ArrayList<EmployeesDTO> employeeList = new ArrayList<>();

            for(String nextLine = bufferedReader.readLine(); nextLine != null; nextLine = bufferedReader.readLine())
            {
                counter++;
                String[] splitted = nextLine.split(",");
                employeeList.add(new EmployeesDTO(splitted));
            }
            System.out.println("You have " + counter + " Records.");
            return employeeList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<EmployeesDTO> getDistinctList(ArrayList<EmployeesDTO> employeesDTO)
    {
        int counter = 0;
        ArrayList<EmployeesDTO> newList = (ArrayList<EmployeesDTO>) employeesDTO.stream().distinct().collect(Collectors.toList());
        for(EmployeesDTO e : newList)
        {
            counter++;
        }
        System.out.println("You have " + counter + " Distinct rows.");
        return newList;
    }
}
