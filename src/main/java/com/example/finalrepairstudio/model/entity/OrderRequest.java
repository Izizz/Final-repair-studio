package com.example.finalrepairstudio.model.entity;

import java.sql.Date;
/**
 * Order entity class.
 *
 * @author Aleksey Serdyukov.
 */
public class OrderRequest {
     int requestId;
     int  user_id;
     String requestDescr;
     String master;
     double price;
     String feedback;




    public String getFeedback() {
        return feedback;
    }

    Date requestDate;

     Boolean isDenied;
     String status;
    public double getPrice() {
        return price;
    }
    public String getStatus() {
        return status;
    }
    public int getRequestId() {
        return requestId;
    }
    public int getUser() {
        return user_id;
    }
    public String getMaster() {
        return master;
    }
    public String getRequestDescr() {
        return requestDescr;
    }
    public Date getRequestDate() {
        return requestDate;
    }
    public Boolean getDenied() {
        return isDenied;
    }



}
