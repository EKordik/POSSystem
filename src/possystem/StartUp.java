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
        CashRegister register = new CashRegister();
       
        register.startSale(new FakeDatabase(), "100", new ConsoleReceipt());
        register.addProducttoSale("A101", "1");
        register.addProducttoSale("B205", "2");
        
        register.generateReceipt();
        
        register.startSale(new FakeDatabase(), "200", new ConsoleReceipt());
        register.addProducttoSale("C222", "3");
        register.generateReceipt();
    }
}
