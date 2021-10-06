package com.sparta.datamigration.view;

public class UserMessages {
    public static void fileInputMessage(String filename){
        System.out.println("Reading file: " + filename);
    }

    public static void resultsMessage(int employeeResults, int specialCasesResults){
        System.out.println("Reading completed to collection with: ");
        System.out.println(employeeResults + " valid entries");
        System.out.println(specialCasesResults +
                " special case entries");
    }
}
