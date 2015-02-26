package possystem;

/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmakordik
 */
public class FakeDatabase implements DataAccessStrategy {
    private CustomerStrategy[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };
    

    
    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(.50,2)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };

    @Override
    public final CustomerStrategy findCustomer(String customerID) {
        CustomerStrategy customer = new Customer();
        if(customerID == null || customerID.length() == 0){
            //Replace with exception error message
            return null;
        }
        
        for(CustomerStrategy c: customers){
            if(customerID.equals(c.getCustomerID())){
                customer = c;
                break;
            }
        }
        
        return customer;
    }

    @Override
    public final Product findProduct(String productId) {
        Product product = new Product();
        
        if(productId == null || productId.length() == 0){
            //Add code to throw except/give error message
            return null;
        }
       
        for(Product p: products){
            if(productId.equals(p.getProductID())){
                product = p;
                break;
            }
        }
        
        return product;
    }
    
}
