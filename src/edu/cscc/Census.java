package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dan Lundy
 * @Version 2.0
 * @date 11/26/2019
 * This is the Census Java class.  The purpose of this class
 * is to read the CSV file and store the date to a HashMap.
 * The surname is the key and the rank, count, and proportion is the value.
 * The user will be prompted for a surname and that will be compared to our keys from the HashMap.
 * If the user provides a valid key the value will be displayed.  The user will then be prompted
 * for another surname.  If the user enters quit the program will stop.
 * The class handles 2 exceptions if the file is not found
 * or if the data is an invalid data type.
 */

public class Census {
    /**
     * @param fname      fname is the name of the file being read
     * @param input      this is the scanner
     * @param s          String the input(file) is assigned as a string as it is read from the scanner
     * @param String[]   a This is the new array that is created by splitting @param s at the comma
     * @param name       This string is the name in the surname object
     * @param rank       this is the first int value in the surname object
     * @param count      this is the second int value in the surname object
     * @param proportion this is the first double value in the surname object
     * @return namelist
     * The loadCensusData method reads the entire census file and stores to HashMap called namelist
     * The Surnames_2010Census.csv file is given to the scanner.
     * The scanner will continue to read and separate the data to an array.  The array is split at the commas.
     * The namelist HashMap is then constructed from the array.
     * The method does catch invalid input and file not found exceptions.
     */
    public static Map<String, Surname> loadCensusData(String fname) {
        Map<String, Surname> namelist = new HashMap<>();
        try {
            Scanner input = new Scanner(new File(fname));
            input.nextLine();
            while (input.hasNext()) {
                String s = input.nextLine();
                String[] a = s.split(",");
                try {
                    String name = a[0];
                    int rank = Integer.parseInt(a[1]);
                    int count = Integer.parseInt(a[2]);
                    double proportion = Double.parseDouble(a[3]);
                    namelist.put(a[0], new Surname(a[0], rank, count, proportion));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                    return null;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }

        return namelist;
    }
}




