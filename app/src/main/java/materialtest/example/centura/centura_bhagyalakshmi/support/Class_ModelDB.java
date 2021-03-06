package materialtest.example.centura.centura_bhagyalakshmi.support;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderProduct;
import materialtest.example.centura.centura_bhagyalakshmi.models.Product;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class Class_ModelDB {

    public static CurrentUser currentuserModel;
    private static ArrayList<Order> orderList ;
    private static ArrayList<distributor> distributormodel;
    private static ArrayList<OrderProduct> productList ;

    public Class_ModelDB() {

        currentuserModel = new CurrentUser();
        orderList = new ArrayList<Order>();
        distributormodel = new ArrayList<distributor>();
        productList = new ArrayList<OrderProduct>();


    }

    public static ArrayList<OrderProduct> getProductList() {
        return productList;
    }

    public static void setProductList(ArrayList<OrderProduct> productList) {
        Class_ModelDB.productList = productList;
    }

    public static ArrayList<distributor> getDistributormodel() {
        return distributormodel;
    }

    public static void setDistributormodel(ArrayList<distributor> distributormodel) {
        Class_ModelDB.distributormodel = distributormodel;
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
