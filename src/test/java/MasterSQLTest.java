import com.example.finalrepairstudio.model.DAO.MasterDAO;
import com.example.finalrepairstudio.model.entity.Master;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class MasterSQLTest {
    @Test
    public  void findMasterTest(){
        String firstname = "Roman";
        String lastname = "Prydyn";
        String email = "master3@gmail.com";
        String password = "master3456";
        String phone = "+380776634299";

        MasterDAO masterDAO =  new MasterDAO();
        try {
            Master master = masterDAO.findMaster(firstname,lastname);
            Assert.assertEquals(master.getFirstname(),firstname);
            Assert.assertEquals(master.getLastname(),lastname);
            Assert.assertEquals(master.getEmail(),email);
            Assert.assertEquals(master.getPassword(),password);
            Assert.assertEquals(master.getPhone(),phone);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
