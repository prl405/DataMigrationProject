package com.sparta.datamigration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadHandler {

    public ArrayList<String[]> ReadFile(String fileName){
        ArrayList<String[]> theData = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("COMMA_DELIMITER");
                theData.add(values);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return theData;
    }
}
