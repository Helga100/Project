package internet_store.dao_layer;

import internet_store.dao_layer.models.Order;
import internet_store.dao_layer.models.Product;
import internet_store.dao_layer.tables.OrderDB;
import internet_store.dao_layer.tables.ProductDB;
import internet_store.dao_layer.tables.UserDB;

public class DB  {
    private UserDB userDB;
    private ProductDB productDB;
    private OrderDB orderDB;

    public DB() {
        this.userDB = new UserDB();
        this.productDB = new ProductDB();
        this.orderDB = new OrderDB();
    }

    public UserDB getUserDB() {
        return userDB;
    }

    public ProductDB getProductDB() {
        return productDB;
    }

    public OrderDB getOrderDB() {
        return orderDB;
    }

}
