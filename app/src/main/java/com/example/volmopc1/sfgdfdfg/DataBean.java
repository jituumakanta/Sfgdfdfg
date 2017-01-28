package com.example.volmopc1.sfgdfdfg;

/**
 * Created by volmopc1 on 18-01-2017.
 */

public class DataBean {

    //private variables
    static int id;
    static String name;
    static String number;
    static String area;

    // Empty constructor
    public DataBean() {
    }

    // constructor
    public DataBean(int id, String name, String number, String area) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.area = area;
    }

    // constructor
    public DataBean(String name, String number) {
        this.name = name;
        this.number = number;
    }


    // getting ID
    public static int getID() {
        return id;
    }

    // setting id
    public void setID(int id) {
        this.id = id;
    }

    // getting name
    public static String getName() {
        return name;
    }

    // setting name
    public void setName(String name) {
        this.name = name;
    }

    // getting phone number
    public static String getNumber() {
        return number;
    }

    // setting phone number
    public void setNumber(String number) {
        this.number = number;
    }

    // getting area
    public static String getArea() {
        return area;
    }

    // setting area
    public void setArea(String area) {
        this.area = area;
    }


}
