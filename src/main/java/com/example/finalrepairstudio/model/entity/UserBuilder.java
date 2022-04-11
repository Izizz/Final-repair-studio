package com.example.finalrepairstudio.model.entity;

public class UserBuilder {

    User user = new User();

    public UserBuilder setPassword(String password) {
        user.password = password;
        return this;
    }
    public UserBuilder setEmail(String email) {
        user.email = email;
        return this;
    }
    public UserBuilder setRole(String role) {
        user.role = role;
        return this;
    }

    public UserBuilder setFirstname(String firstname) {
        user.firstname = firstname;
        return this;

    }
    public UserBuilder setLastname(String lastname) {
        user.lastname = lastname;
        return this;

    }
    public UserBuilder setPhonenumber(String phonenumber) {
        user.phonenumber = phonenumber;
        return this;

    }
    public UserBuilder setBalance(double balance) {
        user.balance = balance;
        return this;
    }
    public UserBuilder setId(int id){
        user.id = id;
        return this;
    }
    public User build() {
        return user;
    }
}
