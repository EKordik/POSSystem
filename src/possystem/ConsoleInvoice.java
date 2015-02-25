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
public class ConsoleInvoice implements InvoiceGeneratorStrategy {
    private LineItemStrategy[] lineItems;
    private CustomerStrategy customer;
    private double total;
    private double subTotal;
    private double discountTotal;
    private Date today = new Date();
    private DecimalFormat formatNum = new DecimalFormat("$###,##0.00");
    
    public ConsoleInvoice(LineItemStrategy[] lineItems, CustomerStrategy customer) {
        this.lineItems = lineItems;
        this.customer = customer;
    }

    public ConsoleInvoice() {
    }

    @Override
    public LineItemStrategy[] getLineItems() {
        return lineItems;
    }

    @Override
    public void setLineItems(LineItemStrategy[] lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public CustomerStrategy getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(CustomerStrategy customer) {
        this.customer = customer;
    }
    
    @Override
    public void generateInvoice(){
        calculateTotals();
        
        System.out.println(today);
        System.out.println(customer.getCustomerID() + " " + customer.getName());
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("");
        for(LineItemStrategy line: lineItems){
            System.out.println(line.toString());
        }
        System.out.println("-------------------------------------");
        System.out.println("Subtotal: " + formatNum.format(subTotal));
        System.out.println("Total: " + formatNum.format(total));
        System.out.println("");
        System.out.println("You Saved: " + formatNum.format(discountTotal));
    }
    
    private void calculateTotals(){
        for(LineItemStrategy line: lineItems ){
           subTotal += line.getLineTotal();
           discountTotal += line.getDiscountAmt();
        }
        total = subTotal;
    }
    
    
}
