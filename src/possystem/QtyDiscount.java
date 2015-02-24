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

    public QtyDiscount(double discountRate, int minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }

    public QtyDiscount(int minQty) {
        this.minQty = minQty;
    }
    
    
    @Override
    public double getDiscountAmt(double price, int qty) {
        if(qty < minQty){
            return 0;
        }else{
            return price * qty * discountRate;
        }
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate=discountRate;
    }
    
    
}
