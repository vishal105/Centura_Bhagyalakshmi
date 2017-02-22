package materialtest.example.centura.centura_bhagyalakshmi.models;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class CurrentUser {
    private String Id;
    private String Name;

    public CurrentUser() {
        Id = "";
        Name = "";
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
}
