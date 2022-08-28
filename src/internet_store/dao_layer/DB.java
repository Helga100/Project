package internet_store.dao_layer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DB {
    ArrayList<User> dbUsers = new ArrayList<>();
    ArrayList<Product> dbProducts = new ArrayList<Product>();
    ArrayList<Order> dbOrders = new ArrayList<>();


    public ArrayList<Product> getProductsByCategoryAndSex(String categoryFromScanner, String sexFromConcole) {
        final List<Product> listOfProcustsByCategoryAndSex = dbProducts.stream()
                .filter(it -> it.category.equals(categoryFromScanner) && it.sex.equals(sexFromConcole))
                .collect(Collectors.toList());
        return (ArrayList<Product>) listOfProcustsByCategoryAndSex;

    }

    public ArrayList<Product> getProductsBySex(String sexFromScanner) {
        final ArrayList<Product> listOfProductBySex = (ArrayList<Product>) dbProducts.stream().
                filter(currentProduct -> currentProduct.sex.equals(sexFromScanner))
                .collect(Collectors.toList());
        return listOfProductBySex;

    }


    public void addNewOrderByProductId(String idChoice) {

        Product product = getProductById(idChoice);
        Order order = new Order(product, "1");
        dbOrders.add(order);

    }

    public ArrayList<Product> getDbProducts() {
        return dbProducts;
    }

    public void addNewProductFromConcole(String newProductName, String newProductSize, String newProductColor,
                                         String newProductSex, int age, String newProductCategory, int id) {
        dbProducts.add(new Product(newProductName, newProductSize, newProductColor, newProductSex, age,
                newProductCategory, id));
    }

    public Product getProductById(String idChoice) {
        return dbProducts.stream()
                .filter(it -> String.valueOf(it.id).equals(idChoice))
                .findFirst()
                .get();
    }

    public void setProductColor(String idProductFromConcole, String newColorFromConcole) {
        dbProducts.stream()
                .filter(it -> it.id == Integer.parseInt(idProductFromConcole))
                .forEach(it -> it.color = newColorFromConcole);
    }


    public void setOrderStatusById(String idOrderFromConcole, OrderStatus newOrderStatus) {

        dbOrders.stream().filter(it -> it.id.equals(idOrderFromConcole))
                .forEach(it -> it.orderStatus = newOrderStatus);

    }

    public Order getOrderByID(String orderIDFromConcole) {
        final Order orderFoundedById = dbOrders.stream()
                .filter(it -> orderIDFromConcole.equals(it.id))
                .findFirst().orElse(null);
        return orderFoundedById;
    }

    public ArrayList<Order> getDbOrders() {
        return dbOrders;
    }

    public void setUserBlockStatus(String idUserFromConcole, boolean blockedStatus) {

        dbUsers.stream().filter(it -> it.ID.equals(idUserFromConcole))
                .forEach(it -> it.isBlocked = blockedStatus);
    }

    public User getUserById(String idUserFromConcole) {
        final User userFoundById = dbUsers.stream().filter(it -> it.ID.equals(idUserFromConcole))
                .findFirst()
                .get();
        return userFoundById;
    }

    public ArrayList<User> getDbUsers() {
        return dbUsers;
    }

    public boolean isUserBlocked(String login) {
        final User foundedUser = dbUsers.stream().filter(it -> it.login.equals(login))
                .findFirst()
                .get();

        return foundedUser.isBlocked;
    }

    public boolean isAdmin(String login) {
        final User foundedUser = dbUsers.stream().filter(it -> it.login.equals(login))
                .findFirst()
                .get();

        return foundedUser.isAdmin;
    }

    public void addNewUser(String login, String password) {

        User tempUser = new User(login, password, "3");  //TODO Increment ID
        dbUsers.add(tempUser);  //TODO Increment ID

    }

    public boolean isUserExists(String login, String password) {
        return findUserByLoginAndPassword(login, password) != null;
    }

    public User findUserByLoginAndPassword(String loginFromConcole1, String passwordFromConcole1) {
        final User foundUser = dbUsers.stream()
                .filter(it -> it.login.equals(loginFromConcole1) && it.password.equals(passwordFromConcole1))
                .findFirst().orElse(null);
        return foundUser;
    }

    public void completeTestData() {
        dbUsers.add(new User("1", "1", "1"));
        dbUsers.add(new User("2", "2", true, "2"));   // admin
        dbOrders.add(new Order(new Product("Shoes", "36", "Grey", "boy", 7, "SHOES", 11), "2"));
        dbProducts.add(new Product("Jacket", "M", "Blue", "boy", 10, "OUTWEAR", 1));
        dbProducts.add(new Product("Coat", "M", "Black", "boy", 9, "OUTWEAR", 2));
        dbProducts.add(new Product("Trousers", "S", "White", "boy", 10, "TROUSERS", 3));
        dbProducts.add(new Product("Trousers", "M", "Brown", "boy", 7, "TROUSERS", 4));
        dbProducts.add(new Product("Shirt", "M", "White", "boy", 9, "SHIRTS", 5));
        dbProducts.add(new Product("Shirt", "S", "Blue", "boy", 10, "SHIRTS", 6));
        dbProducts.add(new Product("Shirt", "S", "Green", "boy", 20, "SHIRTS", 7));
        dbProducts.add(new Product("Suit", "S", "Blue", "boy", 10, "SUITS", 8));
        dbProducts.add(new Product("Suit", "L", "Brown", "boy", 7, "SUITS", 9));
        dbProducts.add(new Product("Shoes", "40", "Brown", "boy", 12, "SHOES", 10));
        dbProducts.add(new Product("Shoes", "36", "Grey", "boy", 7, "SHOES", 11));
        dbProducts.add(new Product("Dress", "S", "yellow", "girl", 5, "DRESSES", 12));
        dbProducts.add(new Product("Dress", "L", "Blue", "girl", 10, "DRESSES", 13));
        dbProducts.add(new Product("Coat", "S", "Blue", "girl", 12, "OUTWEAR", 14));
        dbProducts.add(new Product("Jacket", "M", "Grey", "girl", 9, "OUTWEAR", 15));
        dbProducts.add(new Product("Jacket", "L", "Black", "girl", 15, "OUTWEAR", 16));
        dbProducts.add(new Product("Trousers", "S", "Black", "girl", 12, "TROUSERS", 17));
        dbProducts.add(new Product("Trousers", "L", "White", "girl", 8, "TROUSERS", 18));
        dbProducts.add(new Product("Blouse", "S", "White", "girl", 10, "BLOUSES", 19));
        dbProducts.add(new Product("Blouse", "M", "Yellow", "girl", 7, "BLOUSES", 20));
        dbProducts.add(new Product("Suits", "L", "Green", "girl", 9, "SUITS", 21));
        dbProducts.add(new Product("Suits", "S", "White", "girl", 14, "SUITS", 22));
        dbProducts.add(new Product("Shoes", "37", "Black", "girl", 10, "SHOES", 23));
        dbProducts.add(new Product("Shoes", "39", "Blue", "girl", 14, "SHOES", 24));
        dbProducts.add(new Product("Skirt", "M", "Blue", "girl", 9, "SKIRTS", 25));
        dbProducts.add(new Product("Skirt", "S", "Black", "girl", 12, "SKIRTS", 26));


    }

}
