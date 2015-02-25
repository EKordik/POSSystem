/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author emmakordik
 */
public interface ProductStrategy {

    public abstract String getDescription();

    public abstract double getDiscountAmt(int qty);

    public abstract double getPrice();

    public abstract String getProductID();

    public abstract void setDescription(String description);

    public abstract void setDiscount(DiscountStrategy discount);

    public abstract void setPrice(double price);

    public abstract void setProductID(String productID);
    
}
