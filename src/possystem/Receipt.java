/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * Receipt class.
 * Holds information regarding lineItems, the customer, calculates the total and
 * has the information for the receipt
 * @author emmakordik
 * @version 1.00
 */
public class Receipt {
    private CustomerStrategy customer;
    private LineItemStrategy[] lineItems;
    private DataAccessStrategy database;
    private double total; //Stores the total of the sale
    private double subtotal; //Stores a subtotal for the sale
    private double totalSaved; //stores the total amount saved via discounts
    private double tax; //Stores the amount of tax for a sale
    private final double SALES_TAX = .05;//Stores the local sales tax
    private Date receiptDate;
    private DecimalFormat formatNum = new DecimalFormat("$###,###,##0.00");
        
    public Receipt(DataAccessStrategy database, String customerID){
        this.database = database;
        lineItems = new LineItem[0];
        customer = database.findCustomer(customerID);
        receiptDate = new Date();

    }
    
    //Adds a new Line Item
    public final void addLineItem(String productID, String qty){
        LineItem lineItem = new LineItem(productID, qty, database);
        addToLineItemArray(lineItem);
    }
    
    //Adds Item to Aray by increasing the size of the array by one
    private void addToLineItemArray(LineItem li){
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        lineItems = temp;
        temp = null;

        lineItems[lineItems.length-1] = li;
    }
    
    public final void removeLineItem(String prodID){
            removeLineItemFromArray(prodID);
       
    }
    
    public final void removeLineItemQty(String prodID, String qty){
        int index = findLineItemIndex(prodID);
        Integer qtyKeep = lineItems[index].getQuantity() - Integer.parseInt(qty);
        
        lineItems[index].setQuantity(qtyKeep.toString());
    }
    
    private void removeLineItemFromArray(String prodID){
        int index = findLineItemIndex(prodID);
        
        if(index < 0){
            //Error Message for testing. Code needs replaced
            System.out.println("No Item Found");
        }else{
            LineItemStrategy[] temp = new LineItem[lineItems.length-1];
            
            if(index == 0){
                System.arraycopy(lineItems, 1, temp, 0, lineItems.length-1);
            }else{
                System.arraycopy(lineItems, 0, temp, 0, index);
                if(index+1 < temp.length){
                    System.arraycopy(lineItems, index+1, temp, index, lineItems.length);
                }
            }
            
            lineItems = temp;
            temp = null;
        }
    }
    
    private int findLineItemIndex(String prodID){
        int index = -1;

        for(int i = 0; i<lineItems.length; i++){
            if(lineItems[i].getProductID().equals(prodID)){
                index=i;
                break;
            }
        }
        
        return index;
    }
    
    //Generates receipt to a String that contains all the information
    public final String generateCompleteReceipt(){
        calculateTotals();
        return receiptDate + "\n" + customer.getCustomerID() + " " + 
                customer.getName() + "\n" + "---------------------------------" +
                "\n" + outputLineItems() + 
                "---------------------------------\nSubtotal: " + 
                formatNum.format(subtotal) + "\nTax: " + formatNum.format(tax) + 
                "\nTotal: " + formatNum.format(total) + "\n\nYou Saved: " + 
                formatNum.format(totalSaved);
    }
    
    //Generates the lineItems as a String value for use in the generateCompleteReceipt method
    private String outputLineItems(){
        String lineItemsString = "";
        
        for(LineItemStrategy li: lineItems){
            lineItemsString += li.toString();
            lineItemsString += "\n";
    }
        
        return lineItemsString;
    }
    
    //Calculates the subtotal, tax, total, and total amount saved
    private void calculateTotals(){
        for(LineItemStrategy l: lineItems){
            subtotal+= l.getLineTotal();
            totalSaved += l.getDiscountAmt();
        }
        
        tax = subtotal*SALES_TAX;
        total = subtotal + tax;
    }
   
    public static void main(String[] args) {
        Receipt receipt = new Receipt(new FakeDatabase(), "100");
        receipt.addLineItem("A101", "1");
        receipt.addLineItem("B205", "1");
        receipt.addLineItem("C222", "3");
        System.out.println(receipt.outputLineItems());
        
        receipt.removeLineItemQty("C222", "2");
        
        System.out.println(receipt.outputLineItems());
        
    
    }
}
