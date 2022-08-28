package internet_store.servive_layer;

import internet_store.dao_layer.DB;
import internet_store.view_layer.View;

public class Logics {

    DBService dbService;
    ValidationImpl validationImpl;

    public Logics(DB db) {
        this.dbService = new DBService(db);
        this.validationImpl = new ValidationImpl();
    }



    public void startMenu(DB database, View view) {
        final int SIGN_IN = 1, REGISTRATION = 2, EXIT = 0;

        while (true) {
            view.mainMenu();

            int intResultFromConsole = view.getIntFromConsole();

            if (intResultFromConsole == EXIT) {
                return;

            }

            if (intResultFromConsole == SIGN_IN) {
                validationImpl.signingIn(database, view, this);

            }
            if (intResultFromConsole == REGISTRATION) {
                dbService.registration(database, view);

            }
        }
    }



    public void productMenu(DB database, View view) {
        view.showProductMenu();
        String LIST_OF_ALL_PRODUCTS = "a";
        String SEARCH_FOR_SPECIFIC_PRODUCT = "b";
        String ORDER_CHECKOUT = "c";
        String RETURN_TO_USER_MENU = "d";
        String LOG_OUT = "e";
        final String choice3 = view.getStringFromConsole();
        if (choice3.equalsIgnoreCase(LIST_OF_ALL_PRODUCTS)) {
            System.out.println(database.getProductDB().getDbProducts());
        }
        if (choice3.equalsIgnoreCase(SEARCH_FOR_SPECIFIC_PRODUCT)) {
            genderMenu(database, view);
        }
        if (choice3.equalsIgnoreCase(ORDER_CHECKOUT)) {
            dbService.orderCheckout(database, view);
        }
        if (choice3.equalsIgnoreCase(RETURN_TO_USER_MENU)) {
            userMenu(database, view);
        }
        if (choice3.equalsIgnoreCase(LOG_OUT)) {
            startMenu(database, view);
        }
    }

    public void genderMenu(DB database, View view) {
        view.showGenderMenu();
        final int genderChoice = view.getIntFromConsole();
        int FILTER_ONLY_BOYS_PRODUCTS = 1;
        int FILTER_ONLY_GIRLS_PRODUCTS = 2;

        if (genderChoice == FILTER_ONLY_BOYS_PRODUCTS) {
            dbService.genderMenuFilterByBoys(database, view);


        } else if (genderChoice == FILTER_ONLY_GIRLS_PRODUCTS) {
            dbService.genderMenuFilterByGirls(database, view);
        }
    }

    public void userMenu(DB database, View view) {
        view.showUserMenu();
        int USER_PRODUCT_MENU = 1;
        int USER_ORDER_MENU = 2;

        final int choice2 = view.getIntFromConsole();

        if (choice2 == USER_PRODUCT_MENU) {

            while (true) {
                productMenu(database, view);
            }

        }
        if (choice2 == USER_ORDER_MENU) {
            view.showAllUserOrders(database);
        }
    }


    public void adminMenu(DB database, View view) {

        view.showAdminMenu();
        final String choceAdmin1 = view.getStringFromConsole();
        final String USER_MENU_BLOCK_AND_UNBLOCK = "1";
        final String ORDER_MENU_CONFIRM_AND_UNCONFIRM_ORDER = "2";
        final String PRODUCT_MENU_EDIT_ADD = "3";
        final String LOG_OUT = "4";


        if (choceAdmin1.equals(USER_MENU_BLOCK_AND_UNBLOCK)) {
            dbService.adminUserMenuBlockAndUnblockUser(database, view);
        } else if (choceAdmin1.equals(ORDER_MENU_CONFIRM_AND_UNCONFIRM_ORDER)) {
            dbService.adminOrderMenuConfirmAndUncomfirmOrder(database, view);

        } else if (choceAdmin1.equals(PRODUCT_MENU_EDIT_ADD)) {
            view.adminShowProductMenu();
            final String choiceAdminInProductMenu = view.getStringFromConsole();
            if (choiceAdminInProductMenu.equals("a")) {
                dbService.editExistingProduct(database, view);
            } else if (choiceAdminInProductMenu.equals("b")) {
                dbService.addNewProduct(database, view);
            }
        } else if (choceAdmin1.equals(LOG_OUT)) {
            startMenu(database, view);

        }
        adminMenu(database, view);
    }
}
