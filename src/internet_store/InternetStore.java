package internet_store;

import internet_store.dao_layer.DB;
import internet_store.servive_layer.Logics;
import internet_store.view_layer.View;

public class InternetStore {
    private View view;
    private DB database;
    private Logics logics;

    public InternetStore() {
        view = new View();
        database = new DB();
        logics = new Logics(database);
    }

    public void run() {
        view.greeting();
        logics.startMenu(database, view);

    }

}




