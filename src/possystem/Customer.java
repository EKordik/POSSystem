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

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    @Override
    public String getCustomerID() {
        return customerID;
    }

    @Override
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    
}
