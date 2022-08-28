package internet_store.servive_layer;

import internet_store.dao_layer.DB;
import internet_store.view_layer.View;

public interface DBServiceInterface {
    void editExistingProduct(DB database, View view);

    void addNewProduct(DB database, View view);

    void orderCheckout(DB database, View view);

    void adminOrderMenuConfirmAndUncomfirmOrder(DB database, View view);

    void genderMenuFilterByGirls(DB database, View view);

    void genderMenuFilterByBoys(DB database, View view);

    void registration(DB database, View view);

    void addNewOrderByProductId(String idChoice);
}



