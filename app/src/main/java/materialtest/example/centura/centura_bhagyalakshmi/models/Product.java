package materialtest.example.centura.centura_bhagyalakshmi.models;

import java.math.BigInteger;

/**
 * Created by Centura User1 on 07-12-2016.
 */

public class Product {

    private String Id;
    private String SectionId;
    private String Category;
    private String SectionName;
    private String CatagoryName;
    private String Units;
    private Double Price;
    private int Quantity;
    private int Stock;
    private int Aliasflag;
    private Double Amount;
    private String Description;
    private String Code;
    private BigInteger TimeStamp;
    private Double Tax;

    public Product(){
        Id="";
        Units="";
        Price=0.0;
        Quantity=0;
        Stock=0;
        Amount=0.0;
        Description="";
        SectionId="";
        Category="";
        Code="";
        SectionName="";
        CatagoryName="";
        Tax=0.0;
        Aliasflag=-1;
        TimeStamp= BigInteger.valueOf(0);
    }

    public int getAliasflag() {
        return Aliasflag;
    }

    public void setAliasflag(int aliasflag) {
        Aliasflag = aliasflag;
    }

    public BigInteger getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(BigInteger timeStamp) {
        TimeStamp = timeStamp;
    }

    public void setProductDetais(Product tempPtoduct){
       // Id=tempPtoduct.getId();
        Units=tempPtoduct.getUnits();
        Price=tempPtoduct.getPrice();
        Quantity=tempPtoduct.getQuantity();
        Stock=tempPtoduct.getStock();
        Tax=tempPtoduct.getTax();
        Amount=tempPtoduct.getAmount();
        Description=tempPtoduct.getDescription();
        SectionId=tempPtoduct.getSectionId();
        Category=tempPtoduct.getCategoryId();
        Code=tempPtoduct.getCode();
        Aliasflag=tempPtoduct.getAliasflag();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Double getTax() {
        return Tax;
    }

    public void setTax(Double tax) {
        Tax = tax;
    }

    public String getSectionId() {
        return SectionId;
    }

    public void setSectionId(String sectionId) {
        SectionId = sectionId;
    }

    public String getCategoryId() {
        return Category;
    }

    public void setCategoryId(String categoryId) {
        Category = categoryId;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String sectionName) {
        SectionName = sectionName;
    }

    public String getCatagoryName() {
        return CatagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        CatagoryName = catagoryName;
    }

    public Product(Product tempProduct) {
       // Id=tempProduct.getId();
        Units=tempProduct.getUnits();
        Price=tempProduct.getPrice();
        Quantity=tempProduct.getQuantity();
        Stock=tempProduct.getStock();
        Amount=tempProduct.getAmount();
        Description=tempProduct.getDescription();
        CatagoryName= tempProduct.getCatagoryName();
        Category= tempProduct.getCategoryId();
        SectionName= tempProduct.getSectionName();
        SectionId= tempProduct.getSectionId();
        Code=tempProduct.getCode();
        Tax=tempProduct.getTax();
        Aliasflag=tempProduct.getAliasflag();
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

   /* public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }*/

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}
