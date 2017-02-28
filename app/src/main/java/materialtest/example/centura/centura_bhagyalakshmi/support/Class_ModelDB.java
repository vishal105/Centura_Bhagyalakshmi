package materialtest.example.centura.centura_bhagyalakshmi.support;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class Class_ModelDB {

    public static CurrentUser currentuserModel;
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private static ArrayList<distributor> distributerlist = new ArrayList<distributor>();

    public Class_ModelDB() {

        currentuserModel = new CurrentUser();
        orderList = new ArrayList<Order>();
        distributerlist = new ArrayList<distributor>();

    }

    public static ArrayList<distributor> getDistributerlist() {
        return distributerlist;
    }

    public static void setDistributerlist(ArrayList<distributor> distributerlist) {
        Class_ModelDB.distributerlist = distributerlist;
    }

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(ArrayList<Order> orderList) {
        Class_ModelDB.orderList = orderList;
    }

    public static CurrentUser getCurrentuserModel() {
        return currentuserModel;
    }

    public static void setCurrentuserModel(CurrentUser currentuserModel) {
        Class_ModelDB.currentuserModel = currentuserModel;
    }


}
