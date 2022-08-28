package internet_store;

import internet_store.dao_layer.DB;
import internet_store.dao_layer.OrderStatus;
import internet_store.dao_layer.Product;
import internet_store.dao_layer.User;
import internet_store.view_layer.View;

import java.util.ArrayList;

public class InternetStore {
    View view;

    DB database;


    public InternetStore() {
        view = new View();
        database = new DB();
        database.completeTestData();
    }

    public void main() {

        view.greeting();

        start(database);

    }


    private void start(DB database) {
        final int SIGN_IN = 1, REGISTRATION = 2;

        while (true) {
            view.mainMenu();

            int intResultFromConsole = view.getIntFromConsole();

            if (intResultFromConsole == SIGN_IN) {
                signingIn(database);

            }
            if (intResultFromConsole == REGISTRATION) {
                registration(database);

            }
        }
    }

    private void registration(DB database) {
        System.out.println("Register page: ");
        System.out.println("Create login: ");
        String login = view.getStringFromConsole();
        System.out.println("Create password: ");
        String password = view.getStringFromConsole();

        if (database.isUserExists(login, password)) {
            System.out.println("User exists, try to log in");
        } else {
            database.addNewUser(login, password);
            System.out.println("Your registration is successful");
        }
    }

    



    /*
          Login as user:

       System.out.println("Login menu: ");
       System.out.println("1. Login");

     */

    private void signingIn(DB database) {
        System.out.println("Input login: ");
        final String loginFromConcole = view.getStringFromConsole();
        System.out.println("Input password: ");
        final String passwordFromConcole = view.getStringFromConsole();


        if (database.isUserExists(loginFromConcole, passwordFromConcole)) {
            if (database.isAdmin(loginFromConcole)) {
                adminMenu(database);
            } else {
                if (database.isUserBlocked(loginFromConcole)) {
                    System.out.println("Sorry you are blocked");
                } else {
                    userMenu(database);
                }
            }

        } else {
            System.out.println("Please check Login or Password");
        }

//            PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//            writer.println("The first line");
//            writer.println("The second line");
//            writer.close();
    }

    private void adminMenu(DB database) {

        view.showAdminMenu();
        final String choceAdmin1 = view.getStringFromConsole();
        final String USER_MENU_BLOCK_AND_UNBLOCK = "1";
        final String ORDER_MENU_CONFIRM_AND_UNCONFIRM_ORDER = "2";
        final String PRODUCT_MENU_EDIT_ADD = "3";
        final String LOG_OUT = "4";


        if (choceAdmin1.equals(USER_MENU_BLOCK_AND_UNBLOCK)) {
            final String BLOCK_USER = "1", UNBLOCK_USER = "2";
            System.out.println("List of users: ");
            System.out.println(database.getDbUsers());
            System.out.println("Input id user");
            String scannerIdUser = view.getStringFromConsole();
            final User userById = database.getUserById(scannerIdUser);
            System.out.println(userById);
            System.out.println("Block / Unblock Status User: " + userById.isBlocked());
            System.out.println("1. Block this User");
            System.out.println("2. Unblock this User");
            final String blockChoice = view.getStringFromConsole();
            if (blockChoice.equals(BLOCK_USER)) {
//                User userByIdWithBlockStatus = new User(userById.login, userById.password,"100");
                database.setUserBlockStatus(scannerIdUser, true);
                System.out.println("User is blocked");

            } else if (blockChoice.equals(UNBLOCK_USER)) {
                database.setUserBlockStatus(scannerIdUser, false);

                System.out.println("User is unblocked");
            }
        } else if (choceAdmin1.equals(ORDER_MENU_CONFIRM_AND_UNCONFIRM_ORDER)) {
            System.out.println("Welcome to order menu");
            System.out.println("List of Orders: " + database.getDbOrders());
            System.out.println("Please input order ID");
            String orderId = view.getStringFromConsole();
            System.out.println("1.Confirm order");
            System.out.println("2.Unconfirm order");
            final String s = view.getStringFromConsole();
            if (s.equals("1")) {
                database.setOrderStatusById(orderId, OrderStatus.CONFIRM);
                System.out.println("Order confirmed");
            } else if (s.equals("2")) {
                database.setOrderStatusById(orderId, OrderStatus.UNCONFIRM);
                System.out.println("Order unconfirmed");
            }

        } else if (choceAdmin1.equals(PRODUCT_MENU_EDIT_ADD)) {
            System.out.println("Products menu (Admin)");
            System.out.println("a. Edit existing product details");
            System.out.println("b. Add new product");
            final String choiceAdminInProductMenu = view.getStringFromConsole();
            if (choiceAdminInProductMenu.equals("a")) {
                System.out.println("Input product ID ");
                final String idProduct = view.getStringFromConsole();
                System.out.println("Input colorProduct ");
                final String newColorProduct = view.getStringFromConsole();
                database.setProductColor(idProduct, newColorProduct);
                System.out.println(database.getProductById(idProduct));
            } else if (choiceAdminInProductMenu.equals("b")) {
                System.out.println("Please input name of the product");
                String newProductName = view.getStringFromConsole();

                System.out.println("Please input size of the product");
                String newProductSize = view.getStringFromConsole();

                System.out.println("Please input color of the product");
                String newProductColor = view.getStringFromConsole();

                System.out.println("Please input sex of the product");
                String newProductSex = view.getStringFromConsole();

                System.out.println("Please input age of the product");
                int age = view.getIntFromConsole();

                System.out.println("Please input category of the product");
                String newProductCategory = view.getStringFromConsole();

                System.out.println("Please input id of the product");
                int id = view.getIntFromConsole();

                database.addNewProductFromConcole(newProductName, newProductSize, newProductColor, newProductSex, age, newProductCategory, id);
            }
        } else if (choceAdmin1.equals(LOG_OUT)) {
            start(database);

        }
        adminMenu(database);
    }


    private void userMenu(DB database) {
        view.showUserMenu();
        int USER_PRODUCT_MENU = 1;
        int USER_ORDER_MENU = 2;

        final int choice2 = view.getIntFromConsole();

        if (choice2 == USER_PRODUCT_MENU) {

            while (true) {
                productMenu(database);
            }

        }
        if (choice2 == USER_ORDER_MENU) {
            System.out.println("Your orders: " + database.getDbOrders());
        }
    }

    private void productMenu(DB database) {
        view.showProductMenu();
        // System.out.println("a. List of all products: ");
        //        System.out.println("b. Search for specific product: ");
        //        System.out.println("c. Order checkout: ");
        //        System.out.println("d. Return to User Menu: ");
        //        System.out.println("e. Log Out ");
        String LIST_OF_ALL_PRODUCTS = "a";
        String SEARCH_FOR_SPECIFIC_PRODUCT = "b";
        String ORDER_CHECKOUT = "c";
        String RETURN_TO_USER_MENU = "d";
        String LOG_OUT = "e";
        final String choice3 = view.getStringFromConsole();
        if (choice3.equalsIgnoreCase(LIST_OF_ALL_PRODUCTS)) {
            System.out.println(database.getDbProducts());
        }
        if (choice3.equalsIgnoreCase(SEARCH_FOR_SPECIFIC_PRODUCT)) {
            genderMenu(database);
        }
        if (choice3.equalsIgnoreCase(ORDER_CHECKOUT)) {
            System.out.println("Please input an ID of your choice");
            String idChoice = view.getStringFromConsole();
            database.addNewOrderByProductId(idChoice);
            System.out.println("Your order is completed");
            System.out.println(database.getDbOrders());


        }
        if (choice3.equalsIgnoreCase(RETURN_TO_USER_MENU)) {
            userMenu(database);
        }
        if (choice3.equalsIgnoreCase(LOG_OUT)) {
            start(database);
        }
    }


    private void genderMenu(DB database) {
        view.showGenderMenu();
        final int genderChoice = view.getIntFromConsole();
        int FILTER_ONLY_BOYS_PRODUCTS = 1;
        int FILTER_ONLY_GIRLS_PRODUCTS = 2;

        if (genderChoice == FILTER_ONLY_BOYS_PRODUCTS) {
            ArrayList<Product> boyProduct = database.getProductsBySex("boy");
            System.out.println(boyProduct);
            System.out.println("Products categories: ");
            System.out.println("1. Outwear");
            System.out.println("2. Trousers");
            System.out.println("3. Shirts");
            System.out.println("4. Suits");
            System.out.println("5. Shoes");
            String choiceBoyCategory = view.getStringFromConsole();
            ArrayList<Product> categoryProducts = new ArrayList<>();

            switch (choiceBoyCategory) {
                case "1":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("OUTWEAR", "boy"));
                    break;
                case "2":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("TROUSERS", "boy"));
                    break;
                case "3":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("SHIRTS", "boy"));
                    break;
                case "4":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("SUITS", "boy"));
                    break;
                case "5":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("SHOES", "boy"));
                    break;
                default:
                    System.out.println("No such clothes");
                    break;
            }

            System.out.println(categoryProducts);


        } else if (genderChoice == FILTER_ONLY_GIRLS_PRODUCTS) {
            ArrayList<Product> girlProduct = database.getProductsBySex("girl");
            System.out.println(girlProduct);
            System.out.println("Products categories: ");
            System.out.println("1. Outwear");
            System.out.println("2. Trousers");
            System.out.println("3. Blouses");
            System.out.println("4. Suits");
            System.out.println("5. Shoes");
            System.out.println("6. Dresses");
            System.out.println("7. Skirts");
            String choiceGirlCategory = view.getStringFromConsole();
            ArrayList<Product> categoryProducts = new ArrayList<>();

            switch (choiceGirlCategory) {
                case "1":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("OUTWEAR", "girl"));
                    break;
                case "2":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("TROUSERS", "girl"));
                    break;
                case "3":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("BLOUSES", "girl"));
                    break;
                case "4":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("SUITS", "girl"));
                    break;
                case "5":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("SHOES", "girl"));
                    break;
                case "6":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("DRESSES", "girl"));
                    break;
                case "7":
                    categoryProducts.addAll(database.getProductsByCategoryAndSex("SKIRTS", "girl"));
                    break;
                default:
                    System.out.println("No such clothes");

                    break;
            }

            System.out.println(categoryProducts);
        }
        {

        }
    }
}




