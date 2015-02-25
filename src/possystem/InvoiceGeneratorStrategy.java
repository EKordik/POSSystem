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
public interface InvoiceGeneratorStrategy {

    public abstract void generateInvoice();

    public abstract CustomerStrategy getCustomer();

    public abstract LineItemStrategy[] getLineItems();

    public abstract void setCustomer(CustomerStrategy customer);

    public abstract void setLineItems(LineItemStrategy[] lineItems);
    
}
