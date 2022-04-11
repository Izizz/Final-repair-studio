package com.example.finalrepairstudio.model.entity;

public class User {
    int id;
    double balance;
     String password,email,role,firstname,lastname,phonenumber;

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }



}
