package com.sparta.datamigration;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        String line = null;
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"));
             BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"))){

            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.write(line + "\n");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
