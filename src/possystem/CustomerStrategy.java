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
public interface CustomerStrategy {

    public abstract String getCustomerID();

    public abstract String getName();

    public abstract void setCustomerID(String customerID);

    public abstract void setName(String name);
    
}
