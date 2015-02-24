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
public class NoDiscount implements DiscountStrategy {
    private double discountRate = 0.00;
    
    @Override
    public double getDiscountAmt(double price, int qty) {
        return 0.00;
    }

    @Override
    public double getDiscountRate() {
         return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        //Rate is zero. It cannot be set
    }
    
}
