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

    public abstract Product getProduct();

    public abstract int getQuantity();

    public abstract void setProduct(Product product);

    public abstract void setQuantity(int quantity);
    
}
