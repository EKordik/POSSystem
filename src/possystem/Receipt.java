/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author emmakordik
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
    
    public final String generateCompleteReceipt(){
        calculateTotals();
        return receiptDate + "\n" + customer.getCustomerID() + " " + 
                customer.getName() + "\n" + "---------------------------------" +
                "\n" + outputLineItems() + "\n" + 
                "---------------------------------\nSubtotal: " + 
                formatNum.format(subtotal) + "\nTax: " + formatNum.format(tax) + 
                "\nTotal: " + formatNum.format(total) + "\nYou Saved: " + 
                formatNum.format(totalSaved);
    }
    
    private String outputLineItems(){
        String lineItemsString = "";
        for(LineItemStrategy li: lineItems){
            lineItemsString += li.toString();
            lineItemsString += "\n";
    }
        
        return lineItemsString;
    }
    
    private void calculateTotals(){
        for(LineItemStrategy l: lineItems){
            subtotal+= l.getLineTotal();
            totalSaved += l.getDiscountAmt();
        }
        
        tax = subtotal*SALES_TAX;
        total = subtotal + tax;
    }
    
   
}
