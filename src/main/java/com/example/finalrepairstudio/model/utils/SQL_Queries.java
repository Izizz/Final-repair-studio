package com.example.finalrepairstudio.model.utils;






public class SQL_Queries {
    //masters table
    public static final String ADD_MASTER = "INSERT INTO users (firstname,lastname,email,phone,password,role) VALUES (?,?,?,?,?,'master')" ;
    public static final String FIND_MASTER = "SELECT * FROM users WHERE lastname = ? AND email = ? AND phone  = ? and role = 'master'";
    public static final String SELECT_MASTER_BY_ID = "SELECT firstname,lastname,email,phone,status FROM masters WHERE user_id = ? AND role = 'master'";
    public static final String SHOW_MASTERS = "SELECT * FROM users WHERE role = 'master' ";
    public static final String UPDATE_MASTERS = "UPDATE users SET  firstname = ?,lastname = ?,email= ?,phone =?,password = ? where user_id = ? AND role = 'master'";
    public static final String DELETE_MASTER = "DELETE FROM users WHERE  user_id = ? AND role = 'master'";
    public static final String SHOW_SERVICES = "SELECT name,price FROM services";
    //users

    public static final String ADD_USER = "INSERT INTO users (firstname,lastname,password,email,phone,role) VALUES(?,?,?,?,?,'user')";
    public static final String FIND_USER = "SELECT * FROM users WHERE email = ? AND password = ? ";

//    public static final String SHOW_USER = "SELECT firstname,lastname,email,phone FROM users WHERE user_id= ";
    public static final String ADD_USER_BALANCE = "INSERT INTO wallet (user_id) VALUES =(?)";
    public static final String GET_USER_ID = "SELECT user_id FROM users WHERE email = ?";

    //services
    public static final String SHOW_SERVICE_NAME = "select name from services ";

    //orders
    public static final String SHOW_ORDERS = "select * from orders";
    public  static final String SHOW_USERS_ORDERS = "select * from orders where user_id =";
    public static final String ADD_ORDER ="insert into orders (user_id,description,price,master_id,status,date) values (?,?,?,?,?,?)";

}
