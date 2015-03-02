
package possystem;

/**
 * CashRegister high level class.
 * This class starts the sale, add products and generates a receipt by delegating
 * to low level classes.
 * 
 * @author ekordik
 * @version 1.00
 */
public class CashRegister {
    private Receipt receipt;
    private ReceiptOutputStrategy output;
    
    public CashRegister() {
        
    }
    
    /**
     * Starts the sale. 
     * Needs the customerID and Database to create a new receipt. Also determines
     * how you want that receipt outputted.
     * @param database
     * @param customerID
     * @param output 
     */
    public final void startSale(final DataAccessStrategy database, final String customerID, 
            ReceiptOutputStrategy output){
        receipt = new Receipt(database, customerID);
        this.output = output;
    }
    
    /**
     * Tells the receipt to add a product to the sale
     * @param productID
     * @param qty 
     */
    public final void addProducttoSale(final String productID, final String qty){
        receipt.addLineItem(productID, qty);
        
    }
    
    /**
     * Removes a product from the sale
     * @param productID
     * @param qty 
     */
    public final void removeProductfromSale(final String productID, final String qty){
        if(qty == null || qty.length() == 0){
            receipt.removeLineItem(productID);
        }else{
            receipt.removeLineItemQty(productID, qty);
        }
    }
    
    /**
     * Outputs the receipt
     */
    public final void generateReceipt(){ 
        output.outputReceipt(receipt);
    }
    
   
}
