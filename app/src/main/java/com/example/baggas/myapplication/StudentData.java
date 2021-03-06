package com.example.baggas.myapplication;

/**
 * Created by BAGGAS on 6/18/2018.
 */

public class StudentData {
    String name;
    String collegeName;
    String address;
    long phoneNumber;
    int id;

    public StudentData(int id, String name, String collegeName, String address, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.collegeName = collegeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public StudentData(String name, String collegeName, String address, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.collegeName = collegeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public StudentData() {

    }

    public long getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCollegeName()
    {
        return collegeName;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCollegeName(String collegeName)
    {
        this.collegeName = collegeName;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
