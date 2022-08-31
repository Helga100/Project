package internet_store.dao_layer.models;

import internet_store.dao_layer.OrderStatus;

public class Order {

    private OrderStatus orderStatus;
    private Product product;
    private String id;

    public Order(Product product, String id) {
        this.product = product;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderStatus=" + orderStatus +
                ", product=" + product +
                ", id='" + id + '\'' +
                '}';
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

}
