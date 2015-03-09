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
    private DataAccessStrategy database;
    private ProductStrategy product;
    private int quantity;

    public LineItem() {
    }

    public LineItem(final String product, final String qty, final DataAccessStrategy database) 
            throws IllegalArgumentException {
        if(database == null){
            throw new IllegalArgumentException("Database Required");
        }
        this.database = database;
        setProduct(product);
        setQuantity(qty);
    }

    @Override
    public final String getProductID() {
        return product.getProductID();
    }

    @Override
    public final void setProduct(final String productID) throws IllegalArgumentException {
        this.product = database.findProduct(productID);
    }

    @Override
    public final int getQuantity() {
        return quantity;
    }

    @Override
    public final void setQuantity(final String quantity) {
        if(quantity == null || quantity.isEmpty() ){
            
        }
        this.quantity = Integer.parseInt(quantity);
    }
    
    @Override
    public final double getLineTotal(){
        return (product.getPrice() * quantity) - product.getDiscountAmt(quantity);
    }
    
    @Override
    public final double getDiscountAmt(){
        return product.getDiscountAmt(quantity);
    }
    
    public final double getPriceAfterDiscount(){
        return product.getPrice() - product.getDiscountAmt(1);
    }
    
    @Override
    public final String toString(){
        DecimalFormat formatNum = new DecimalFormat("###,##0.00");
                
        return product.getProductID() + " " + product.getDescription() + "   " +
                formatNum.format(getPriceAfterDiscount()) + "   " + quantity +
                "   " + formatNum.format(getLineTotal()) + "\n Item Price " + formatNum.format(product.getPrice()) + 
                " You Save " + formatNum.format(product.getDiscountAmt(quantity));
    }
    
}
