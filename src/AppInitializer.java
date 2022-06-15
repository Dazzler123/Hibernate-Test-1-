import entity.Customer;
import entity.Item;
import entity.Order_Detail;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppInitializer {
    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.setCId("C002");
        c1.setName("Dasindu");
        c1.setMobile("0762093858");
        c1.setAddress("Wattala");

        Item i1 = new Item();
        i1.setItemCode("I001");
        i1.setItemName("Maliban Cream Cracker");
        i1.setUnitPrice(170.0);
        i1.setQty_on_hand(40);

        Orders o1 = new Orders();
        o1.setDate(String.valueOf(LocalDate.now()));
        o1.setOId("O001");

        Order_Detail order_detail = new Order_Detail();
        order_detail.setId("O00-001");
        order_detail.setItem(i1);
        order_detail.setQty(2);

        //=====================================================================

        ArrayList<Order_Detail> order_detailList = new ArrayList<>();
        order_detailList.add(order_detail);

        o1.setOrder_detailList(order_detailList);
        order_detail.setOrders(o1);


        //========================================================================

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ///////SAVE/////////////////////////////////////////
        session.save(c1);  //save customer
        session.save(i1);  //save item
        session.save(o1);  //save order
        session.save(order_detail); //save order details


        ///////UPDATE//////////////////////////////////////
        session.update(c1); //update customer
        session.update(i1);  //update item
        session.update(o1);  //update order
        session.update(order_detail); //update order details


        ///////DELETE//////////////////////////////////////
        session.delete(c1); //delete customer
        session.delete(i1);  //delete item
        session.delete(o1);  //delete order
        session.delete(order_detail); //delete order details


        transaction.commit();
        session.close();
    }
}
