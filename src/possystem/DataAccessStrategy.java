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

    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    public abstract CustomerStrategy findCustomer(final String custId);

    /**
     * Tries to find a Product by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    public abstract Product findProduct(final String prodId);
    
}
