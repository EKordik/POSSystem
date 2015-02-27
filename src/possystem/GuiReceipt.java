/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import javax.swing.JOptionPane;

/**
 *
 * @author emmakordik
 */
public class GuiReceipt implements ReceiptOutputStrategy {

    @Override
    public void outputReceipt(Receipt receipt) {
        JOptionPane.showMessageDialog(null, receipt.generateCompleteReceipt());
    }
    
}
