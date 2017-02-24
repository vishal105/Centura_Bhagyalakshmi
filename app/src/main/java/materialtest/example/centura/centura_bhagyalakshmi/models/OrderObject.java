package materialtest.example.centura.centura_bhagyalakshmi.models;

/**
 * Created by Centura on 2/24/2017.
 */
public class OrderObject {
    public Integer Id;
    public String OrderNumber,Status;

    public OrderObject(int i, String s, String s1) {
        Id = 0;
        OrderNumber="";
        Status="";

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
