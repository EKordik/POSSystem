/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author ekordik
 */
public class StartUp {
    public static void main(String[] args) {
        CashRegister register = new CashRegister(new FakeDatabase(), new ConsoleInvoice());
       
        register.startSale("100");
        register.addProduct("A101", "1");
        register.addProduct("B205", "2");
        
        register.generateInvoice();
    }
}
