package materialtest.example.centura.centura_bhagyalakshmi.models;

/**
 * Created by VISHAL on 2/28/2017.
 */
public class OrderRole {
    private String Id;
    private String Name;
    private String Address;
    private String UserType;
    private String Employee;



    public OrderRole() {
        Id = "";
        Name = "";
        Employee="";
        Address = "";
        UserType = "";
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUsertype() {
        return UserType;
    }

    public void setUsertype(String usertype) {
        UserType = usertype;
    }
    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String employee) {
        Employee = employee;
    }
}
