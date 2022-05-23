import com.example.finalrepairstudio.model.DAO.DBManager;
import com.example.finalrepairstudio.model.DAO.UserDAO;
import com.example.finalrepairstudio.model.entity.BuilderUser;
import com.example.finalrepairstudio.model.entity.User;
import org.junit.Assert;
import org.junit.Test;


import java.sql.Connection;
import java.sql.SQLException;

public class UserSQLTest {
    @Test
    public  void TestConnection(){
        try {
            Connection connection = DBManager.getInstance().getConnection();
            Assert.assertNotNull(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void registerTest() {
        UserDAO userDAO = new UserDAO();

        try{

            String firstname = "TestFirst";
            String lastname = "TestLast";
            String email = "Test@gmail.com";
            String phone = "+3801234567";
            String password = "testPas";

            User user = new BuilderUser()
                    .setPassword(password)
                    .setEmail(email)
                    .setFirstname(firstname)
                    .setLastname(lastname)
                    .setPhonenumber(phone)
                    .setRole("user")
                    .build();

            userDAO.insert(user);

            User NewUSer = userDAO.findUser(user);

            Assert.assertEquals(firstname, NewUSer.getFirstname());
            Assert.assertEquals(lastname, NewUSer.getLastname());
            Assert.assertEquals(email, NewUSer.getEmail());

            userDAO.deleteUser(NewUSer.getId());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getBalanceTest (){
        UserDAO userDAO = new UserDAO();

        double balance = 0;

        String firstname = "TestFirst";
        String lastname = "TestLast";
        String email = "Test@gmail.com";
        String phone = "+3801234567";
        String password = "testPas";

        User user = new BuilderUser()
                .setPassword(password)
                .setEmail(email)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setPhonenumber(phone)
                .setRole("user")
                .build();

        userDAO.insert(user);

        User NewUSer = null;
        try {
            NewUSer = userDAO.findUser(user);

            userDAO.deleteUser(NewUSer.getId());
            Assert.assertEquals(balance,NewUSer.getBalance(),0.00004);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Test
    public  void TopUpTest(){
        UserDAO userDAO = new UserDAO();
        double balance = 100;

        String firstname = "TestFirst";
        String lastname = "TestLast";
        String email = "Test@gmail.com";
        String phone = "+3801234567";
        String password = "testPas";

        User user = new BuilderUser()
                .setPassword(password)
                .setEmail(email)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setPhonenumber(phone)
                .setRole("user")
                .build();

        userDAO.insert(user);

        User NewUSer = null;
        try {
            NewUSer = userDAO.findUser(user);

            userDAO.TopupBalance(NewUSer.getId(),balance);
            Assert.assertEquals(balance,userDAO.getBalance(NewUSer.getId()),0.00004);
            userDAO.deleteUser(NewUSer.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
