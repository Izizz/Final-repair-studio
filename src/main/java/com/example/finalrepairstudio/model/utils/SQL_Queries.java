package com.example.finalrepairstudio.model.utils;

/**
 * SQL Queries constants for DAO classes.
 *
 * @author Ostap Semotiuk.
 */

public class SQL_Queries {
    //masters
    public static final String FIND_MASTER = "SELECT * FROM users WHERE lastname = ? AND firstname = ? and role = 'master'";
    //users
    public static final String ADD_USER = "INSERT INTO users (firstname,lastname,password,email,phone,role) VALUES(?,?,?,?,?,'user')";
    public static final String FIND_LOGIN = "SELECT * FROM users WHERE email = ? AND password = ? ";
    public static final String GET_BALANCE = "select users.user_id,balance from users right join wallet on  users.user_id = wallet.user_id where users.user_id =?";
    public static final String GET_NEW_BALANCE = "select balance from wallet where user_id= ?";
    public static final String UPDATE_BALANCE = "UPDATE wallet SET balance = ? where user_id =?";
    public static final String CHECK_BALANCE = "select wallet.user_id,price,balance from orders right join wallet on orders.user_id = wallet.user_id where id = ? ";
    public static final String GET_BALANCE_LIST = "select SQL_CALC_FOUND_ROWS users.user_id,firstname,lastname,balance  from users right join wallet on users.user_id = wallet.user_id where users.role ='user' limit ";

    //orders
    public static final String SHOW_ORDERS = "select   * from orders ORDER BY ";
    public static final String SHOW_FILTERED_ORDERS = "select  * FROM orders WHERE ";
    public static final String UPDATE_ORDER = "UPDATE orders SET price = ?, master = ?, status = ? WHERE id = ?";
    public static final String SHOW_USERS_ORDERS = "select  * from orders where user_id =";
    public static final String SHOW_MASTER_ORDERS = "SELECT  * FROM orders right join feedbacks on feedbacks.order_id=orders.id WHERE master=";
    public static final String UPDATE_STATUS = "UPDATE orders SET status = ? WHERE id = ?";
    public static final String ADD_ORDER = "insert into orders (user_id,description,price,master,status,date) values (?,?,?,?,?,?)";
    public static final String ADD_FEEDBACK = "update feedbacks set feedback = ? where order_id = ?";
    public static final String GET_ORDER = "select * from orders where description = ?";

    public static String getSql(String s){
        return s;
    }

}
