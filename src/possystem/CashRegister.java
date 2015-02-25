
package possystem;

/**
 *
 * @author ekordik
 */
public class CashRegister {
    private CustomerStrategy customer;
    private LineItemStrategy[] lineItems = new LineItem[0];
    private DataAccessStrategy database;
    private InvoiceGeneratorStrategy invoice;

    private int index;

    public CashRegister(DataAccessStrategy database, InvoiceGeneratorStrategy invoice) {
        this.database = database;
        this.invoice = invoice;
    }

    public CashRegister() {
    }

    public CashRegister(DataAccessStrategy database) {
        this.database = database;
    }

    public void setInvoice(InvoiceGeneratorStrategy invoice) {
        this.invoice = invoice;
    }
    
    
    public void setDatabase(DataAccessStrategy database) {
        this.database = database;
    }
    
    public void startSale(String customerID){
        customer = database.findCustomer(customerID);
        index = 0;
    }
    
    public void addProduct(String productID, String Qty){
        LineItemStrategy[] lineItemsCopy = new LineItem[lineItems.length + 1];

        //Creates a larger Array so more items can be added
        for(int i = 0; i<lineItems.length; i++){
            lineItemsCopy[i] = lineItems[i];
        }
        lineItems = lineItemsCopy;
        
        //Adds an item to the Array
        lineItems[index] = new LineItem(database.findProduct(productID), Qty);
        index++;
        
    }
    
    public void generateInvoice(){ 
        invoice.setCustomer(customer);
        invoice.setLineItems(lineItems);
        invoice.generateInvoice();
    }
    
   
}
