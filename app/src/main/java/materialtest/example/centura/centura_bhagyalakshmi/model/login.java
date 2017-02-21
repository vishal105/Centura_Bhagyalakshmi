package materialtest.example.centura.centura_bhagyalakshmi.model;

/**
 * Created by vishal on 2/20/2017.
 */

public class login {
    private String UserName, Password;

    public login(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
