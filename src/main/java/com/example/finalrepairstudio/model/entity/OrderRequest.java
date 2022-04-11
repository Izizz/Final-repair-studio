package com.example.finalrepairstudio.model.entity;

import java.sql.Date;

public class OrderRequest {
     Long requestId;
     int  user_id;
     String requestDescr;
     int master_id;
     double price;
     Date requestDate;
     Boolean isDenied;
     String status;
    public double getPrice() {
        return price;
    }



    public String getStatus() {
        return status;
    }

    public Long getRequestId() {
        return requestId;
    }
    public int getUser() {
        return user_id;
    }
    public int getMaster() {
        return master_id;
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
