package materialtest.example.centura.centura_bhagyalakshmi.models;

/**
 * Created by Centura on 2/24/2017.
 */
public class OrderObject {
    private String OrderNumber,Status,Id;

    public OrderObject() {
        OrderNumber = "";
        Status = "";
        Id = "";
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
