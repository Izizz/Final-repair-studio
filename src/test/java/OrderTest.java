import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.entity.BuilderMaster;

import com.example.finalrepairstudio.model.entity.BuilderOrderRequest;
import com.example.finalrepairstudio.model.entity.OrderRequest;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class OrderTest {

    @Test
    public void CreateOrderTest() {
        OrderDAO orderDAO = new OrderDAO();
        try{
            String descr = "AAAAA";
            double price = 0;
            String master = "Prydyn";
            String status = "Pending.to.approve";
            try {
                OrderRequest order =  new BuilderOrderRequest()
                        .setUserId(25)
                        .setRequestDescr(descr)
                        .setStatus(status)
                        .setMaster(master)
                        .build();

                orderDAO.addOrder(order);
                OrderRequest newOrder = orderDAO.getOrder(order.getRequestDescr());

                Assert.assertEquals(descr, newOrder.getRequestDescr());
                Assert.assertEquals(price, newOrder.getPrice(),0.00005);
                Assert.assertEquals(master,  newOrder.getMaster());
                Assert.assertEquals(status,  newOrder.getStatus());
                orderDAO.DeleteOrder(newOrder.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e){

        }

    }
    @Test
    public void UpdateOrderTest(){

        String master = "Radyy";
        String status = "Wainting.to.pay";
        int price = 1000;
        OrderDAO orderDAO = new OrderDAO();
        try {
            OrderRequest order =  new BuilderOrderRequest()
                    .setUserId(25)
                    .setRequestDescr("--")
                    .setStatus("--")
                    .setMaster("--")
                    .build();

            orderDAO.addOrder(order);
            OrderRequest newOrder = orderDAO.getOrder(order.getRequestDescr());
            orderDAO.updateOrder(new BuilderMaster().setLastname(master).build(),price,status, newOrder.getRequestId());
            OrderRequest or = orderDAO.getOrder("--");
            Assert.assertEquals(master,  or.getMaster());
            Assert.assertEquals(status,  or.getStatus());

            orderDAO.DeleteOrder(newOrder.getRequestId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
