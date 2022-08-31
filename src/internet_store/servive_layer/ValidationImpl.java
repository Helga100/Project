package internet_store.servive_layer;

import internet_store.dao_layer.DB;
import internet_store.view_layer.View;

public class ValidationImpl implements ValidationService{


    public void signingIn(DB database, View view, Logics logics) {
        System.out.println("Input login: ");
        final String loginFromConcole = view.getStringFromConsole();
        System.out.println("Input password: ");
        final String passwordFromConcole = view.getStringFromConsole();

        if (database.getUserDB().isUserExists(loginFromConcole, passwordFromConcole)) {
            if (database.getUserDB().isAdmin(loginFromConcole)) {
                logics.adminMenu(database, view);
            } else {
                if (database.getUserDB().isUserBlocked(loginFromConcole)) {
                    System.out.println("Sorry you are blocked");
                } else {
                    logics.userMenu(database, view);
                }
            }
        } else {
            System.out.println("Please check Login or Password");
        }
    }
}
