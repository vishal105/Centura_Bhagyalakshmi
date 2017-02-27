package materialtest.example.centura.centura_bhagyalakshmi.models;

import java.math.BigInteger;
import java.util.ArrayList;


public class Order {
    private String Id;
    private String Name;
    private BigInteger TimeStamp;
    public static boolean LoadOrders = true;
    private String Status;

    public Order() {
        Id = "";
        Name = new String();
        Status = "";

        TimeStamp = BigInteger.valueOf(0);

    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public BigInteger getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(BigInteger timeStamp) {
        TimeStamp = timeStamp;
    }


}
