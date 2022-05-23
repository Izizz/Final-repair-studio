import com.example.finalrepairstudio.model.utils.Pages;
import com.example.finalrepairstudio.model.utils.SQL_Queries;
import org.junit.Assert;
import org.junit.Test;

public class ConstantTest {
    @Test
    public void  constantSQLTest(){
        String FIND_MASTER = "SELECT * FROM users WHERE lastname = ? AND firstname = ? and role = 'master'";
        String ADD_USER = "INSERT INTO users (firstname,lastname,password,email,phone,role) VALUES(?,?,?,?,?,'user')";
        String FIND_LOGIN = "SELECT * FROM users WHERE email = ? AND password = ? ";
        String GET_BALANCE = "select users.user_id,balance from users right join wallet on  users.user_id = wallet.user_id where users.user_id =?";
        String GET_NEW_BALANCE = "select balance from wallet where user_id= ?";
        String UPDATE_BALANCE = "UPDATE wallet SET balance = ? where user_id =?";
        String CHECK_BALANCE = "select wallet.user_id,price,balance from orders right join wallet on orders.user_id = wallet.user_id where id = ? ";
        String GET_BALANCE_LIST = "select SQL_CALC_FOUND_ROWS users.user_id,firstname,lastname,balance  from users right join wallet on users.user_id = wallet.user_id where users.role ='user' limit ";


        String SHOW_ORDERS = "select   * from orders ORDER BY ";
        String SHOW_FILTERED_ORDERS = "select  * FROM orders WHERE ";
        String UPDATE_ORDER = "UPDATE orders SET price = ?, master = ?, status = ? WHERE id = ?";
        String SHOW_USERS_ORDERS = "select  * from orders where user_id =";
        String SHOW_MASTER_ORDERS = "SELECT S * FROM orders right join feedbacks on feedbacks.order_id=orders.id WHERE master=";
        String UPDATE_STATUS = "UPDATE orders SET status = ? WHERE id = ?";
        String ADD_ORDER = "insert into orders (user_id,description,price,master,status,date) values (?,?,?,?,?,?)";
        String ADD_FEEDBACK = "update feedbacks set feedback = ? where order_id = ?";
        String GET_ORDER = "select * from orders where description = ?";

        Assert.assertEquals(FIND_MASTER, SQL_Queries.getSql(FIND_MASTER));
        Assert.assertEquals(FIND_LOGIN, SQL_Queries.getSql(FIND_LOGIN));
        Assert.assertEquals(ADD_FEEDBACK, SQL_Queries.getSql(ADD_FEEDBACK));
        Assert.assertEquals(ADD_ORDER, SQL_Queries.getSql(ADD_ORDER));
        Assert.assertEquals(ADD_USER, SQL_Queries.getSql(ADD_USER));
        Assert.assertEquals(GET_BALANCE,SQL_Queries.getSql(GET_BALANCE));
        Assert.assertEquals(GET_NEW_BALANCE,SQL_Queries.getSql(GET_NEW_BALANCE));
        Assert.assertEquals(UPDATE_BALANCE,SQL_Queries.getSql(UPDATE_BALANCE));
        Assert.assertEquals(CHECK_BALANCE,SQL_Queries.getSql(CHECK_BALANCE));
        Assert.assertEquals(GET_BALANCE_LIST,SQL_Queries.getSql(GET_BALANCE_LIST));
        Assert.assertEquals(SHOW_ORDERS,SQL_Queries.getSql(SHOW_ORDERS));
        Assert.assertEquals(SHOW_FILTERED_ORDERS,SQL_Queries.getSql(SHOW_FILTERED_ORDERS));
        Assert.assertEquals(SHOW_USERS_ORDERS,SQL_Queries.getSql(SHOW_USERS_ORDERS));
        Assert.assertEquals(SHOW_MASTER_ORDERS,SQL_Queries.getSql(SHOW_MASTER_ORDERS));
        Assert.assertEquals(UPDATE_ORDER,SQL_Queries.getSql(UPDATE_ORDER));
        Assert.assertEquals(UPDATE_STATUS,SQL_Queries.getSql(UPDATE_STATUS));
        Assert.assertEquals(GET_ORDER,SQL_Queries.getSql(GET_ORDER));
    }

    @Test
    public void constantPathTest(){

        String ADMINPAGE = "/WEB-INF/view/admin/admin-menu.jsp";
        String MASTERLIST = "/WEB-INF/view/admin/masters.jsp";
        String REQUESTLIST = "/WEB-INF/view/admin/orders.jsp";
        String MANAGEORDER = "/WEB-INF/view/admin/edit-order.jsp";
        String USERBALANCE = "/WEB-INF/view/admin/user-balance.jsp";

        String MAKEORDER = "/WEB-INF/view/user/makeorder.jsp";
        String USERPAGE = "/WEB-INF/view/user/user-menu.jsp";
        String ORDERPAGE = "/WEB-INF/view/user/orders.jsp";
        String FEEDBACKPAGE = "/WEB-INF/view/user/feedback.jsp";

        String MASTERPAGE = "/WEB-INF/view/master/master-menu.jsp";
        String MASTERORDERPAGE = "/WEB-INF/view/master/orders.jsp";
        String EDITORDER = "/WEB-INF/view/master/edit-order.jsp";

        String HOMEPAGE ="index.jsp";
        String loginPage = "/WEB-INF/view/login.jsp";
        String REGISTERPAGE = "/WEB-INF/view/register.jsp";


        Assert.assertEquals(ADMINPAGE, Pages.getPath(ADMINPAGE));
        Assert.assertEquals(USERPAGE, Pages.getPath(USERPAGE));
        Assert.assertEquals(USERBALANCE, Pages.getPath(USERBALANCE));
        Assert.assertEquals(MASTERPAGE, Pages.getPath(MASTERPAGE));
        Assert.assertEquals(REQUESTLIST, Pages.getPath(REQUESTLIST));
        Assert.assertEquals(MASTERLIST, Pages.getPath(MASTERLIST));
        Assert.assertEquals(MANAGEORDER, Pages.getPath(MANAGEORDER));
        Assert.assertEquals(MAKEORDER, Pages.getPath(MAKEORDER));
        Assert.assertEquals(ORDERPAGE, Pages.getPath(ORDERPAGE));
        Assert.assertEquals(FEEDBACKPAGE, Pages.getPath(FEEDBACKPAGE));
        Assert.assertEquals(MASTERORDERPAGE, Pages.getPath(MASTERORDERPAGE));
        Assert.assertEquals(EDITORDER, Pages.getPath(EDITORDER));
        Assert.assertEquals(HOMEPAGE, Pages.getPath(HOMEPAGE));
        Assert.assertEquals(loginPage, Pages.getPath(loginPage));
        Assert.assertEquals(REGISTERPAGE, Pages.getPath(REGISTERPAGE));



    }

    @Test
    public void commandFactoryTest(){

    }
}
