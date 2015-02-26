/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author emmakordik
 */
public class QtyDiscount implements DiscountStrategy {
    private double discountRate;
    private int minQty;

    public QtyDiscount(final double discountRate, final int minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }

    public QtyDiscount(final int minQty) {
        this.minQty = minQty;
    }
    
    
    @Override
    public final double getDiscountAmt(final double price, final int qty) {
        if(qty < minQty){
            return 0;
        }else{
            return price * qty * discountRate;
        }
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        this.discountRate=discountRate;
    }
    
    
}
