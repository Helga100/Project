package internet_store.dao_layer;

public class Order {

    OrderStatus orderStatus;
    Product product;
    String id;

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

}
