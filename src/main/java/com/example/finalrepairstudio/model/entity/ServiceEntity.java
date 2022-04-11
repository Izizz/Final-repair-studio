package com.example.finalrepairstudio.model.entity;

public class ServiceEntity {
    int id;
    String name,price,status;
    Master master;


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }

    public Master getMaster() {
        return master;
    }


}
