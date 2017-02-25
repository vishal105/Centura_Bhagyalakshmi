package materialtest.example.centura.centura_bhagyalakshmi.support;

import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderObject;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class Class_ModelDB {

    public static CurrentUser currentuserModel;
    public Class_ModelDB() {

        currentuserModel = new CurrentUser();
    }

    public static CurrentUser getCurrentuserModel() {
        return currentuserModel;
    }

    public static void setCurrentuserModel(CurrentUser currentuserModel) {
        Class_ModelDB.currentuserModel = currentuserModel;
    }


}
