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
        try{
        register.startSale(new FakeDatabase(), "100", new ConsoleReceipt());
        register.addProducttoSale("A101", "1");
        register.addProducttoSale("B205", "2");
        
        register.generateReceipt();
        
        }catch(IllegalArgumentException e1){
            System.out.println(e1.getMessage());
        }
        
        register.startSale(new FakeDatabase(), "200", new ConsoleReceipt());
        register.addProducttoSale("C222", "3");
        register.generateReceipt();
        
        register.startSale(new FakeDatabase(), "300", new ConsoleReceipt());
        register.addProducttoSale("A101", "1");
        register.addProducttoSale("C222","1");
        register.addProducttoSale("B205", "5");
        
        register.removeProductfromSale("A101", null);
        register.removeProductfromSale("B205", "1");
        register.generateReceipt();
    }
}
