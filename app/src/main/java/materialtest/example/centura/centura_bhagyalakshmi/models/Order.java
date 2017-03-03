package materialtest.example.centura.centura_bhagyalakshmi.models;


import java.math.BigInteger;
import java.util.ArrayList;



public class Order {
    private String Id;
    private ArrayList<OrderProduct> Products;
    private OrderRole User;
    private OrderRole Client;
    private Double TotalAmount;

    public ArrayList<OrderProduct> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<OrderProduct> products) {
        Products = products;
    }

    private String Status;
    private String OrderNumber;
    private String OrderDate;
    private BigInteger TimeStamp;
    private String Company;

    public static boolean LoadOrders = true;

    public Order() {
        Id = "";
        User = new OrderRole();
        Client = new OrderRole();
        TotalAmount = 0.0;
        Status = "";
        OrderNumber = "";
        TimeStamp = BigInteger.valueOf(0);
        OrderDate = "";
        Company = "";
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public static boolean isLoadOrders() {
        return LoadOrders;
    }

    public static void setLoadOrders(boolean loadOrders) {
        LoadOrders = loadOrders;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public OrderRole getUser() {
        return User;
    }

    public void setUser(OrderRole user) {
        User = user;
    }

    public OrderRole getClient() {
        return Client;
    }

    public void setClient(OrderRole client) {
        Client = client;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public BigInteger getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(BigInteger timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }
}
