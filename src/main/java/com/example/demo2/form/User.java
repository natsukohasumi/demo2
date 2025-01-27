package com.example.demo2.form;

public class User {
    private String name;
    private String remarks;

    
    public User() {
    }

    public User(String name, String remarks) {
        this.name = name;
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

   
    

}
