package edu.cscc;

/**
 * @author Dan Lundy 11/03/2019 This is the surname class.  The purpose of this class is to define a Surname object.
 * @version 1.0
 */
public class Surname {
    private String name;
    private int rank;
    private int count;
    private double proportion;

    /**
     * Constructor
     *
     * @param name       this is a string
     * @param rank       this is an integer
     * @param count      this is an integer
     * @param proportion this is a double
     */

    public Surname(String name, int rank, int count, double proportion) {
        this.name = name;
        this.rank = rank;
        this.count = count;
        this.proportion = proportion;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getRank() {
        return rank;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public double getProportion() {
        return proportion;
    }


    public void setProportion(double proportion) {
        this.proportion = proportion;
    }


}






