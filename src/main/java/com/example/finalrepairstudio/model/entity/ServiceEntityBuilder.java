package com.example.finalrepairstudio.model.entity;

public class ServiceEntityBuilder {

    ServiceEntity service = new ServiceEntity();

    public ServiceEntityBuilder setId(int id) {
        service.id = id;
        return this;
    }
    public ServiceEntityBuilder setName(String name) {
        service.name = name;
        return this;

    }
    public ServiceEntityBuilder setPrice(String price) {
        service.price = price;
        return this;
    }

    public ServiceEntityBuilder setMaster(Master master) {
        service.master = master;
        return this;

    }
    public ServiceEntity build() {
        return service;

    }
}
