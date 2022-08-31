package internet_store.servive_layer;

import internet_store.dao_layer.DB;
import internet_store.dao_layer.OrderStatus;
import internet_store.dao_layer.models.*;
import internet_store.view_layer.View;

import java.util.ArrayList;

public class DBService implements DBServiceInterface{
    String CONFIRM_ORGER = "1", UNCONFIRM_ORDER = "2";
    final String BLOCK_USER = "1", UNBLOCK_USER = "2";
    final String OUTWEAR = "OUTWEAR";
    final String TROUSERS = "TROUSERS";
    final String SKIRTS = "SKIRTS";
    final String SUITS = "SUITS";
    final String SHOES = "SHOES";
    final String DRESSES = "DRESSES";
    final String BLOUSES = "BLOUSES";

    private DB db;

    public DBService(DB db) {
        this.db = db;
    }


    public void editExistingProduct(DB database, View view) {
        System.out.println("Input product ID ");
        final String idProduct = view.getStringFromConsole();
        System.out.println("Input colorProduct ");
        final Color newColorProduct = Color.of(view.getStringFromConsole());
        database.getProductDB().setProductColor(idProduct, newColorProduct);
        System.out.println(database.getProductDB().getProductById(idProduct));
    }

    public void addNewProduct(DB database, View view) {
        System.out.println("Please input name of the product");
        String newProductName = view.getStringFromConsole();

        System.out.println("Please input size of the product");
        ProductSize newProductSize = ProductSize.of(view.getStringFromConsole());

        System.out.println("Please input color of the product");
        Color newProductColor = Color.of(view.getStringFromConsole());

        System.out.println("Please input sex of the product");
        String newProductSex = view.getStringFromConsole();

        System.out.println("Please input age of the product");
        int age = view.getIntFromConsole();

        System.out.println("Please input category of the product");
        String newProductCategory = view.getStringFromConsole();

        System.out.println("Please input id of the product");
        int id = view.getIntFromConsole();

        database.getProductDB().addNewProductFromConcole(newProductName, newProductSize, newProductColor, newProductSex, age, newProductCategory, id);
    }

    public void orderCheckout(DB database, View view) {
        System.out.println("Please input an ID of your choice");
        String idChoice = view.getStringFromConsole();
        addNewOrderByProductId(idChoice);
        System.out.println("Your order is completed");
        System.out.println(database.getOrderDB().getDbOrders());
    }

    public void adminOrderMenuConfirmAndUncomfirmOrder(DB database, View view) {
        System.out.println("Welcome to order menu");
        System.out.println("List of Orders: " + database.getOrderDB().getDbOrders());
        System.out.println("Please input order ID");
        String orderId = view.getStringFromConsole();
        System.out.println("1.Confirm order");
        System.out.println("2.Unconfirm order");
        final String s = view.getStringFromConsole();
        if (s.equals(CONFIRM_ORGER)) {
            database.getOrderDB().setOrderStatusById(orderId, OrderStatus.CONFIRM);
            System.out.println("Order confirmed");
        } else if (s.equals(UNCONFIRM_ORDER)) {
            database.getOrderDB().setOrderStatusById(orderId, OrderStatus.UNCONFIRM);
            System.out.println("Order unconfirmed");
        }
    }

    public void adminUserMenuBlockAndUnblockUser(DB database, View view) {
        System.out.println("List of users: ");
        System.out.println(database.getUserDB().getDbUsers());
        System.out.println("Input id user");
        String scannerIdUser = view.getStringFromConsole();
        final User userById = database.getUserDB().getUserById(scannerIdUser);
        System.out.println(userById);
        System.out.println("Block / Unblock Status User: " + userById.isBlocked());
        System.out.println("1. Block this User");
        System.out.println("2. Unblock this User");
        final String blockChoice = view.getStringFromConsole();
        if (blockChoice.equals(BLOCK_USER)) {
//                User userByIdWithBlockStatus = new User(userById.login, userById.password,"100");
            database.getUserDB().setUserBlockStatus(scannerIdUser, true);
            System.out.println("User is blocked");

        } else if (blockChoice.equals(UNBLOCK_USER)) {
            database.getUserDB().setUserBlockStatus(scannerIdUser, false);

            System.out.println("User is unblocked");
        }
    }

    public void genderMenuFilterByGirls(DB database, View view) {

        ArrayList<Product> girlProduct = database.getProductDB().getProductsBySex("girl");
        System.out.println(girlProduct);
        view.showCategoriesForGirls();
        String choiceGirlCategory = view.getStringFromConsole();
        ArrayList<Product> categoryProducts = new ArrayList<>();

        switch (choiceGirlCategory) {
            case OUTWEAR:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(OUTWEAR, "girl"));
                break;
            case TROUSERS:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(TROUSERS, "girl"));
                break;
            case SKIRTS:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(SKIRTS, "girl"));
                break;
            case SUITS:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(SUITS, "girl"));
                break;
            case SHOES:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(SHOES, "girl"));
                break;
            case DRESSES:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(DRESSES, "girl"));
                break;
            case BLOUSES:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(BLOUSES, "girl"));
                break;
            default:
                System.out.println("No such clothes");
                break;
        }

        System.out.println(categoryProducts);
    }

    public void genderMenuFilterByBoys(DB database, View view) {
        ArrayList<Product> boyProduct = database.getProductDB().getProductsBySex("boy");
        System.out.println(boyProduct);
        view.showCategoriesForBoys();
        String choiceBoyCategory = view.getStringFromConsole();
        ArrayList<Product> categoryProducts = new ArrayList<>();

        switch (choiceBoyCategory) {
            case OUTWEAR:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(OUTWEAR, "boy"));
                break;
            case TROUSERS:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(TROUSERS, "boy"));
                break;
            case SKIRTS:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(SKIRTS, "boy"));
                break;
            case SUITS:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(SUITS, "boy"));
                break;
            case SHOES:
                categoryProducts.addAll(database.getProductDB().getProductsByCategoryAndSex(SHOES, "boy"));
                break;
            default:
                System.out.println("No such clothes");
                break;
        }

        System.out.println(categoryProducts);
    }

    public void registration(DB database, View view) {
        System.out.println("Register page: ");
        System.out.println("Create login: ");
        String login = view.getStringFromConsole();
        System.out.println("Create password: ");
        String password = view.getStringFromConsole();

        if (database.getUserDB().isUserExists(login, password)) {
            System.out.println("User exists, try to log in");
        } else {
            database.getUserDB().addNewUser(login, password);
            System.out.println("Your registration is successful");
        }
    }

    public void addNewOrderByProductId(String idChoice) {
        Product product = db.getProductDB().getProductById(idChoice);
        Order order = new Order(product, "1");
        db.getOrderDB().addNewOrder(order);

    }
}
