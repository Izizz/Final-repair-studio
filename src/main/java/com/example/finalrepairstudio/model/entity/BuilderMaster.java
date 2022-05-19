package com.example.finalrepairstudio.model.entity;
/**
 * Master entity query builder.
 *
 * @author Aleksey Serdyukov.
 */
public class BuilderMaster {

    Master master = new Master();

    public BuilderMaster setId(int id){
        master.id = id;
        return this;
    }
    public BuilderMaster setFirstname(String firstname) {
        master.firstname = firstname;
        return this;
    }
    public BuilderMaster setLastname(String lastname) {
        master.lastname = lastname;
        return this;

    }
    public BuilderMaster setEmail(String email) {
        master.email = email;
        return this;

    }
    public BuilderMaster setPhone(String phone) {
        master.phone = phone;
        return this;

    }
    public BuilderMaster setStatus(String status) {
        master.status = status;
        return this;

    }
    public BuilderMaster setRole(String role){
        master.role = role;
        return this;
    }
    public BuilderMaster setPassword(String password){
        master.password = password;
        return  this;
    }


    public  Master build(){
        return master;
    }
}
