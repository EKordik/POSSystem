
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
    
    public final void addProducttoSale(final String productID, final String qty){
        receipt.addLineItem(productID, qty);
        
    }
    
    public final void removeProductfromSale(final String productID, final String qty){
        if(qty == null || qty.length() == 0){
            receipt.removeLineItem(productID);
        }else{
            receipt.removeLineItemQty(productID, qty);
        }
    }
    
    public final void generateReceipt(){ 
        output.outputReceipt(receipt);
    }
    
   
}
