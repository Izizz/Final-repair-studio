package com.example.finalrepairstudio.model.entity;

/**
 * User entity query builder.
 *
 * @author Aleksey Serdyukov.
 */
public class BuilderUser {

    User user = new User();

    public BuilderUser setPassword(String password) {
        user.password = password;
        return this;
    }
    public BuilderUser setEmail(String email) {
        user.email = email;
        return this;
    }
    public BuilderUser setRole(String role) {
        user.role = role;
        return this;
    }

    public BuilderUser setFirstname(String firstname) {
        user.firstname = firstname;
        return this;

    }
    public BuilderUser setLastname(String lastname) {
        user.lastname = lastname;
        return this;

    }
    public BuilderUser setPhonenumber(String phonenumber) {
        user.phonenumber = phonenumber;
        return this;

    }
    public BuilderUser setBalance(double balance) {
        user.balance = balance;
        return this;
    }
    public BuilderUser setId(int id){
        user.id = id;
        return this;
    }
    public User build() {
        return user;
    }
}