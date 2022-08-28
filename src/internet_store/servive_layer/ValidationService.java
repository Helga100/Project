package internet_store.servive_layer;

import internet_store.dao_layer.DB;
import internet_store.view_layer.View;

public interface ValidationService {

    void signingIn(DB database, View view, Logics logics);
}
