package internet_store.dao_layer.tables;

import internet_store.dao_layer.OrderStatus;
import internet_store.dao_layer.models.Color;
import internet_store.dao_layer.models.Order;
import internet_store.dao_layer.models.Product;
import internet_store.dao_layer.models.ProductSize;

import java.util.ArrayList;

public class OrderDB {
    private ArrayList<Order> dbOrders = new ArrayList<>();

    public OrderDB() {

        init();
    }

    public void init() {
        dbOrders.add(new Order(new Product("Shoes", ProductSize.s36, Color.GREY, "boy", 7, "SHOES", 11), "2"));
    }





    public void setOrderStatusById(String idOrderFromConcole, OrderStatus newOrderStatus) {
        dbOrders.stream().filter(it -> it.getId().equals(idOrderFromConcole))
                .forEach(it -> it.setOrderStatus(newOrderStatus));

    }

    public Order getOrderByID(String orderIDFromConcole) {
        return dbOrders.stream()
                .filter(it -> orderIDFromConcole.equals(it.getId()))
                .findFirst().orElse(null);
    }

    public ArrayList<Order> getDbOrders() {
        return dbOrders;
    }

    public void addNewOrder(Order order) {
        dbOrders.add(order);
    }


}
