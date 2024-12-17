package com.example.form.Model;

public class Employee {
    private String id;
    private String name;
    private String contactNumber;

    public Employee() {

    }

    public Employee(String id, String contactNumber, String name) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
