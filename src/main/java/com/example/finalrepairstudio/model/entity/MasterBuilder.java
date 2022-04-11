package com.example.finalrepairstudio.model.entity;

public class MasterBuilder {

    Master master = new Master();

    public MasterBuilder setId(int id){
        master.id = id;
        return this;
    }
    public MasterBuilder setFirstname(String firstname) {
        master.firstname = firstname;
        return this;
    }
    public MasterBuilder setLastname(String lastname) {
        master.lastname = lastname;
        return this;

    }
    public MasterBuilder setEmail(String email) {
        master.email = email;
        return this;

    }
    public MasterBuilder setPhone(String phone) {
        master.phone = phone;
        return this;

    }
    public MasterBuilder setStatus(String status) {
        master.status = status;
        return this;

    }
    public MasterBuilder setRole(String role){
        master.role = role;
        return this;
    }
    public MasterBuilder setPassword(String password){
        master.password = password;
        return  this;
    }


    public  Master build(){
        return master;
    }
}
