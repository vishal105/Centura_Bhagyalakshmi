package materialtest.example.centura.centura_bhagyalakshmi.models;

import java.math.BigInteger;

public class distributor {
    private String Id;
    private String Name;
    private BigInteger TimeStamp;

    public distributor(){
        Id="";
        Name="";
        TimeStamp= BigInteger.valueOf(0);
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
