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
public class Customer implements CustomerStrategy {
    private String customerID;
    private String name;

    public Customer() {
    }

    public Customer(final String customerID, final String name) {
        this.customerID = customerID;
        this.name = name;
    }

    @Override
    public final String getCustomerID() {
        return customerID;
    }

    @Override
    public final void setCustomerID(final String customerID) {
        this.customerID = customerID;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final void setName(final String name) {
        this.name = name;
    }
    
    
}
