package edu.cscc;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author Dan Lundy
 * @Version 2.0
 * 11/26/2019
 * This is the main class.  The purpose of this class is to display output.
 * The class uses a Map of the census data file.  A scanner is used to prompt
 * the user for a surname.  The surname is then compared to the census data.
 * If the surname is a key then the value will be displayed. The value includes
 * rank, count, and proportion.
 */
public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Surname> namelist = Census.loadCensusData(CENSUSDATAFNAME);

        if (namelist != null) {
            boolean quit = false;
            String input;
            while (!quit) {
                System.out.println("Enter a surname (or quit to end):");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("quit")) {
                    quit = true;
                } else if (namelist.containsKey(input.toUpperCase())) {
                    Surname surname = namelist.get(input.toUpperCase());
                    String name = surname.getName();
                    int rank = surname.getRank();
                    int count = surname.getCount();
                    double proportion = surname.getProportion();
                    System.out.println("Surname: " + name + " rank: " + rank + " count: " + count + " proportion: " + proportion);
                } else {
                    System.out.println("Surname: " + input + " not found");
                }
            }
        }
    }
}