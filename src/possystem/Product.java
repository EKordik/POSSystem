/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author ekordik
 */
public class Product {
    private String productID;
    private String description;
    private double price;
    private DiscountStrategy discount;
    
    public Product() {
    }

    
    public Product(String productID, String description, double price, 
            DiscountStrategy discount) {
        this.productID = productID;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getDiscountAmt(int qty){
        return discount.getDiscountAmt(price, qty);
    }

    public static void main(String[] args) {
        Product prod = new Product();
        prod.setDescription("Hat");
        prod.setDiscount(new PercentOffDiscount(.10));
        prod.setPrice(100.00);
        prod.setProductID("A101");
        
        System.out.println(prod.getProductID() + " " + prod.getDescription());
        System.out.println(prod.getPrice() + " " + prod.getDiscountAmt(1));
    }
}
