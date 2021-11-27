package com.example.something_new;

public class Student {
    private String name;
    private String familyName;
    private String className;
    private int aveageGrade;
    private  int id;

    public Student(String name, String familyName, String className, int aveageGrade) {
        this.name = name;
        this.familyName = familyName;
        this.className = className;
        this.aveageGrade = aveageGrade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String addres) {
        this.className = addres;
    }

    public int getAveageGrade() {
        return aveageGrade;
    }

    public void setAveageGrade(int aveageGrade) {
        this.aveageGrade = aveageGrade;
    }
}
