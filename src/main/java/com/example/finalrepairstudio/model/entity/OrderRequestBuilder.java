package com.example.finalrepairstudio.model.entity;

import java.sql.Date;

public class OrderRequestBuilder {
    OrderRequest orderRequest =  new OrderRequest();


    public OrderRequestBuilder setUserId(int user_id) {
        orderRequest.user_id = user_id;
        return this;
    }
    public OrderRequestBuilder setRequestDescr(String requestDescr) {
        orderRequest.requestDescr = requestDescr;
        return this;
    }
    public OrderRequestBuilder setMasterId(int master_id) {
        orderRequest.master_id = master_id;
        return this;
    }
    public OrderRequestBuilder setRequestDate(Date requestDate) {
        orderRequest.requestDate = requestDate;
        return this;
    }
    public OrderRequestBuilder setDenied(Boolean denied) {
        orderRequest.isDenied = denied;
        return this;
    }
    public OrderRequestBuilder setPrice(double price) {
        orderRequest.price = price;
        return this;
    }
    public OrderRequest build(){
        return orderRequest;
    }

    public OrderRequestBuilder setStatus(String status) {
        orderRequest.status = status;
        return this;
    }

}
