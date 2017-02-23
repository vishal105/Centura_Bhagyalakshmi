package materialtest.example.centura.centura_bhagyalakshmi.models;

/**
 * Created by Centura User1 on 08-12-2016.
 */

public class CurrentUser {
    private String Id;
    private String Name;
    private String Usertype;
    private String Token;
    private String Employee;
    private String ACL;

    public CurrentUser() {
        Id = "";
        Name = "";
        Usertype = "";
        Token = "";
        ACL = "";
        Employee = "";
    }

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String employee) {
        Employee = employee;
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

    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String usertype) {
        Usertype = usertype;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getACL() {
        return ACL;
    }

    public void setACL(String ACL) {
        this.ACL = ACL;
    }
}
