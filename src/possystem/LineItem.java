/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.text.DecimalFormat;

/**
 *
 * @author emmakordik
 */
public class LineItem implements LineItemStrategy {
    private ProductStrategy product;
    private int quantity;

    public LineItem() {
    }

    public LineItem(Product product, String quantity) {
        this.product = product;
        this.quantity = Integer.parseInt(quantity);
    }

    @Override
    public ProductStrategy getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }
    
    @Override
    public double getLineTotal(){
        return (product.getPrice() * quantity) - product.getDiscountAmt(quantity);
    }
    
    @Override
    public double getDiscountAmt(){
        return product.getDiscountAmt(quantity);
    }
    
    @Override
    public String toString(){
        DecimalFormat formatNum = new DecimalFormat("###,##0.00");
                
        return product.getProductID() + " " + product.getDescription() + "   " +
                formatNum.format(product.getPrice()-product.getDiscountAmt(1)) + "   " + quantity +
                "   " + formatNum.format(getLineTotal()) + "\n Item Price " + formatNum.format(product.getPrice()) + 
                " You Save " + formatNum.format(product.getDiscountAmt(quantity));
    }
    
}
