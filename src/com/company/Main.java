package com.company;

import internet_store.InternetStore;
import internet_store.dao_layer.DB;
import internet_store.dao_layer.models.Color;
import internet_store.servive_layer.DBService;

public class Main {

    public static void main(String[] args) {
        InternetStore internetStore = new InternetStore();
        internetStore.run();

    }
}
