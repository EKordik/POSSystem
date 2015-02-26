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
public class Product implements ProductStrategy {
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

    @Override
    public final void setDiscount(final DiscountStrategy discount) {
        this.discount = discount;
    }
    
    
    @Override
    public final String getProductID() {
        return productID;
    }

    @Override
    public final  void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public final void setDescription(String description) {
        this.description = description;
    }

    @Override
    public final double getPrice() {
        return price;
    }

    @Override
    public final void setPrice(final double price) {
        this.price = price;
    }
    
    @Override
    public final double getDiscountAmt(int qty){
        return discount.getDiscountAmt(price, qty);
    }

}
