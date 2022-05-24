package com.example.finalrepairstudio.model.entity;

import java.sql.Date;
/**
 * Order entity query builder.
 *
 * @author Aleksey Serdyukov.
 */
public class BuilderOrderRequest {
    OrderRequest orderRequest =  new OrderRequest();

    public BuilderOrderRequest setRequestId(int requestId){
        orderRequest.requestId = requestId;
        return this;
    }
    public BuilderOrderRequest setFeedback(String feedback) {
        orderRequest.feedback = feedback;
        return this;
    }
    public BuilderOrderRequest setUserId(int user_id) {
        orderRequest.user_id = user_id;
        return this;
    }
    public BuilderOrderRequest setRequestDescr(String requestDescr) {
        orderRequest.requestDescr = requestDescr;
        return this;
    }
    public BuilderOrderRequest setMaster(String master) {
        orderRequest.master = master;
        return this;
    }

    public BuilderOrderRequest setRequestDate(Date requestDate) {
        orderRequest.requestDate = requestDate;
        return this;
    }


    public BuilderOrderRequest setPrice(double price) {
        orderRequest.price = price;
        return this;
    }


    public BuilderOrderRequest setStatus(String status) {
        orderRequest.status = status;
        return this;
    }
    public OrderRequest build(){
        return orderRequest;
    }
}
