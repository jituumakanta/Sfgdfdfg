package com.example.volmopc1.sfgdfdfg;

/**
 * Created by volmopc1 on 18-01-2017.
 */

public class DataBean {

    //private variables
    int _id;
     static String name;
    String number;

    // Empty constructor
    public DataBean(){

    }
    // constructor
    public DataBean(int id, String name, String number){
        this._id = id;
        this.name = name;
        this.number = number;
    }

    // constructor
    public DataBean(String name, String number){
        this.name = name;
        this.number = number;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public static String getName(){
        return name;
    }

    // setting name
    public void setName(String name){
        this.name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this.number;
    }

    // setting phone number
    public void setPhoneNumber(String number){
        this.number = number;
    }
}