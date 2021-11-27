package com.example.something_new;

public class Teacher {
    private  int id;
    private String fName;
    private String lName;
    private String subject;

    public Teacher(int id, String fName, String lName, String subject) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getSubject() {
        return subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}