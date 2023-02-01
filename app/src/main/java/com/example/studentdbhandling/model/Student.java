package com.example.studentdbhandling.model;

public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String sabaq;
    private String sabqi;
    private String manzil;

    public Student()
    {

    }

    public Student(String name,String rollno) {
        this.name = name;
        this.rollNo = rollno;
    }

    public Student(String name,String rollno, String sabaq, String sabqi, String manzil) {
        this.name = name;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
        this.rollNo = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSabaq() {
        return sabaq;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public String getSabqi() {
        return sabqi;
    }

    public void setSabqi(String sabqi) {
        this.sabqi = sabqi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }
    @Override
    public String toString() {
        return "Student [name=" + name +",rollno = "+ rollNo + ",id = "+ id + ", sabaq=" + sabaq + ", manzil=" + manzil + ", sabqi=" + sabqi + "]";
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
