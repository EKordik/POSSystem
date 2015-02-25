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
public interface LineItemStrategy {

    public abstract ProductStrategy getProduct();

    public abstract int getQuantity();

    public abstract double getDiscountAmt();
    
    public abstract void setProduct(Product product);

    public abstract void setQuantity(String quantity);
    
    public abstract double getLineTotal();
    
    public abstract String toString();
}
