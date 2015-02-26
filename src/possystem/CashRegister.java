
package possystem;

/**
 *
 * @author ekordik
 */
public class CashRegister {
    private Receipt receipt;
    private ReceiptOutputStrategy output;
    
    public CashRegister() {
        
    }

    public final void startSale(final DataAccessStrategy database, final String customerID, 
            ReceiptOutputStrategy output){
        receipt = new Receipt(database, customerID);
        this.output = output;
    }
    
    public final void addProducttoSale(final String productID, final String Qty){
        receipt.addLineItem(productID, Qty);
        
    }
    
    public final void generateReceipt(){ 
        output.outputReceipt(receipt);
    }
    
   
}
