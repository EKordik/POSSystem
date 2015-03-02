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
public class ConsoleReceipt implements ReceiptOutputStrategy {

    
    public final void outputReceipt(final Receipt receipt){
        System.out.println(receipt.generateCompleteReceipt());
        System.out.println("");
    }
    
    
}
