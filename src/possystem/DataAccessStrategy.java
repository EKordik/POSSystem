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
public interface DataAccessStrategy {

   
    public abstract CustomerStrategy findCustomer(final String customerID);

    public abstract Product findProduct(final String productID);
    
}
