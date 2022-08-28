package internet_store.dao_layer.tables;

import internet_store.dao_layer.OrderStatus;
import internet_store.dao_layer.models.Order;
import internet_store.dao_layer.models.Product;

import java.util.ArrayList;

public class OrderDB {
    ArrayList<Order> dbOrders;

    public OrderDB() {
        this.dbOrders = new ArrayList<>();
        init();
    }

    public void init() {
        dbOrders.add(new Order(new Product("Shoes", "36", "Grey", "boy", 7, "SHOES", 11), "2"));
    }





    public void setOrderStatusById(String idOrderFromConcole, OrderStatus newOrderStatus) {

        dbOrders.stream().filter(it -> it.getId().equals(idOrderFromConcole))
                .forEach(it -> it.setOrderStatus(newOrderStatus));

    }

    public Order getOrderByID(String orderIDFromConcole) {
        final Order orderFoundedById = dbOrders.stream()
                .filter(it -> orderIDFromConcole.equals(it.getId()))
                .findFirst().orElse(null);
        return orderFoundedById;
    }

    public ArrayList<Order> getDbOrders() {
        return dbOrders;
    }

    public void addNewOrder(Order order) {
        dbOrders.add(order);
    }


}
