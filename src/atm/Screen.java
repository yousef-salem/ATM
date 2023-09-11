/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Yousuf
 */
public class Screen {
   // display a message without a carriage return 
    public void displayMessage( String message ){
       System.out.print( message ); 
     }
    // display a message with a carriage return
    public void displayMessageLine( String message ){
        System.out.println( message );
    }
   // displays a dollar amount 
    public void displayDollarAmount( double amount ){
        
        System.out.printf( "$%,.2f", amount );
    }
}
