package com.example.finalrepairstudio.model.utils;




public class SQL_Queries {
    //masters table
    public static final String ADD_MASTER = "INSERT INTO users (firstname,lastname,email,phone,password,role) VALUES (?,?,?,?,?,'master')" ;
    public static final String FIND_MASTER = "SELECT * FROM users WHERE lastname = ? AND firstname = ? and role = 'master'";
    public static final String SELECT_MASTER_BY_ID = "SELECT firstname,lastname,email,phone,status FROM masters WHERE user_id = ? AND role = 'master'";
    public static final String SHOW_MASTERS = "SELECT * FROM users WHERE role = 'master' ";
    public static final String UPDATE_MASTERS = "UPDATE users SET  firstname = ?,lastname = ?,email= ?,phone =?,password = ? where user_id = ? AND role = 'master'";
    public static final String DELETE_MASTER = "DELETE FROM users WHERE  user_id = ? AND role = 'master'";
    public static final String SHOW_SERVICES = "SELECT name,price FROM services";
    //users
    public static final String ADD_USER = "INSERT INTO users (firstname,lastname,password,email,phone,role) VALUES(?,?,?,?,?,'user')";
    public static final String FIND_LOGIN = "SELECT * FROM users WHERE email = ? AND password = ? ";
    public static final String FIND_USER = "SELECT users.user_id,firstname,lastname,email,password,phone,role,balance FROM users right join wallet on users.user_id = wallet.user_id WHERE email = ? AND password = ? ";
    public static final String DELETE_USER = "DELETE FROM users";
    public static final String GET_BALANCE = "select users.user_id,balance from users right join wallet on  users.user_id = wallet.user_id where users.user_id =?";
    public static final String GET_NEW_BALANCE = "select balance from wallet where user_id= ?";
    public static final String UPDATE_BALANCE = "UPDATE wallet SET balance = ? where user_id =?";
    public static final String CHECK_BALANCE = "select wallet.user_id,price,balance from orders right join wallet on orders.user_id = wallet.user_id where id = ? ";
//    public static final String SHOW_USER = "SELECT firstname,lastname,email,phone FROM users WHERE user_id= ";
    public static final String ADD_USER_BALANCE = "INSERT INTO wallet (user_id) VALUES (?)";
    public static final String GET_USER_ID = "SELECT user_id FROM users WHERE email = ?";
    public static final String GET_BALANCE_LIST = "select SQL_CALC_FOUND_ROWS users.user_id,firstname,lastname,balance  from users right join wallet on users.user_id = wallet.user_id where users.role ='user' limit ";
    //services


    //orders
    public static final String SHOW_ORDERS = "select   * from orders ORDER BY ";
    public static final String SHOW_FILTERED_ORDERS = "select  * FROM orders WHERE ";
    public static final String UPDATE_ORDER = "UPDATE orders SET price = ?, master = ?, status = ? WHERE id = ?";
    public static final String SHOW_USERS_ORDERS = "select  * from orders where user_id =";
    public static final String SHOW_MASTER_ORDERS = "SELECT S * FROM orders right join feedbacks on feedbacks.order_id=orders.id WHERE master=";
    public static final String UPDATE_STATUS = "UPDATE orders SET status = ? WHERE id = ?";
    public static final String ADD_ORDER = "insert into orders (user_id,description,price,master,status,date) values (?,?,?,?,?,?)";
    public static final String ADD_FEEDBACK = "update feedbacks set feedback = ? where order_id = ?";
}
