
package possystem;

/**
 *
 * @author ekordik
 */
public class CashRegister {
    private CustomerStrategy customer = new Customer();
    private LineItemStrategy[] lineItems = new LineItem[0];
    private DataAccessStrategy database = new FakeDatabase();
    private int index;
    
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
        lineItems[index] = new LineItem(database.findProduct(productID), Integer.parseInt(Qty));
        index++;
        
        //For testing Purposes
        for(int i = 0; i<index; i++){
            System.out.println(lineItems[i].getQuantity());
        }
    }
    
    public void generateInvoice(){
        
    }
    
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        register.startSale("100");
        register.addProduct("A101", "1");
        register.addProduct("B205", "2");
            
       
 
    }
}
