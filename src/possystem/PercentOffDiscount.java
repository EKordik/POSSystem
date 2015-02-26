
package possystem;

/**
 *
 * @author ekordik
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate;
    
    public PercentOffDiscount(){
        
    }
    public PercentOffDiscount(final double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public final double getDiscountAmt(final double price, final int qty){
        return price * qty * discountRate;
    }
    
    
    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(final double discountRate) {
        this.discountRate = discountRate;
    }
    
}
