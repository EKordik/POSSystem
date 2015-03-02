/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 * Product class to create various products for purchase and calculate their
 * discounts.
 * 
 * @author ekordik
 * @version 1.00
 */
public class Product implements ProductStrategy {
    private String productID;
    private String description;
    private double price;
    private DiscountStrategy discount;
    
    public Product() {
    }

    
    public Product(final String productID, final String description, 
            final double price, final DiscountStrategy discount) {
        setProductID(productID);
        setDescription(description);
        setPrice(price);
        setDiscount(discount);
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
    public final  void setProductID(final String productID) {
        this.productID = productID;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public final void setDescription(final String description) {
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
    public final double getDiscountAmt(final int qty){
        return discount.getDiscountAmt(price, qty);
    }

}
