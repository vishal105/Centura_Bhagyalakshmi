package materialtest.example.centura.centura_bhagyalakshmi.models;

/**
 * Created by Centura User1 on 07-12-2016.
 */

public class OrderProduct {

    private String Id;
    private String Code;
    private int Quantity;
    private Double Price;
    private String Description;
    private String Units;
    private int Aliasflag;
    private Double Taxamount;
   // private String SectionId;
    //private String CategoryId;
   // private String SectionName;
   // private String CatagoryName;
    //private String Description;
   // private String Code;

    public OrderProduct(){
        Id="";
        Code="";
        Quantity=0;
        Price=0.0;
        Description="";
        Units="";
        Taxamount=0.0;
        Aliasflag=-1;
       // Description="";
       // SectionId="";
       // CategoryId="";
       // Code="";
      //  SectionName="";
      //  CatagoryName="";
    }

    public int getAliasflag() {
        return Aliasflag;
    }

    public void setAliasflag(int aliasflag) {
        Aliasflag = aliasflag;
    }

    public Double getTaxamount() {
        return Taxamount;
    }

    public void setTaxamount(Double taxamount) {
        Taxamount = taxamount;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductId() {
        return Code;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public void setProductId(String productId) {
        Code = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getUnit() {
        return Units;
    }

    public void setUnit(String unit) {
        Units = unit;
    }


}
