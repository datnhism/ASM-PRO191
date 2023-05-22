package ASM;

import java.io.Serializable;
public class Manager implements Serializable {
    private String ProductName;
    private int ProductID;
    private int Amount;
    private int Price;
    private String Category;

    public Manager(String productName, int productID, int amount, int price, String category) {
        this.ProductName = productName;
        this.ProductID = productID;
        this.Amount = amount;
        this.Price = price;
        this.Category = category;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
