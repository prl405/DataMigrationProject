package com.sparta.datamigration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadHandler {

    public static EmpolyeeRecords ReadFile(String fileName){
        EmpolyeeRecords empolyeeRecords = new EmpolyeeRecords();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            boolean firstPass = true;
            while ((line = reader.readLine()) != null) {
                if (firstPass){
                    String[] values = line.split(",");
                    firstPass = false;
                    continue;
                }
                String[] values = line.split(",");
                empolyeeRecords.setAllEmployeeData(values);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return empolyeeRecords;
    }
}
