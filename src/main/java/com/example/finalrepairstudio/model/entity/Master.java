package com.example.finalrepairstudio.model.entity;

/**
 * Master entity class.
 *
 * @author Aleksey Serdyukov.
 */
public class Master {
     String firstname, lastname,email,phone,password;
     String status = "0";
     String role = "master";
     int id;
     public String getFirstname() {
          return firstname;
     }
     public String getLastname() {
          return lastname;
     }
     public String getEmail() {
          return email;
     }
     public String getPhone() {
          return phone;
     }
     public String getStatus() {
          return status;
     }
     public int getId() {
          return id;
     }
     public String getRole() {
          return role;
     }

     public String getPassword() {
          return password;
     }




}
