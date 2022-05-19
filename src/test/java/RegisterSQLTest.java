import com.example.finalrepairstudio.model.DAO.UserDAO;
import com.example.finalrepairstudio.model.entity.BuilderUser;
import com.example.finalrepairstudio.model.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class RegisterSQLTest {
    @Test
    public  void registerTest(){
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
