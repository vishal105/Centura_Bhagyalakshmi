package materialtest.example.centura.centura_bhagyalakshmi.support;

import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class Class_ModelDB {

    private static CurrentUser currentuserModel = new CurrentUser();

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
