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
abstract class Transaction {
 private int accountNumber; 
 private Screen screen; 
 private BankDatabase bankDatabase; 
 public Transaction( int userAccountNumber, Screen atmScreen,
 BankDatabase atmBankDatabase )
 {
 accountNumber = userAccountNumber;
 screen = atmScreen;
 bankDatabase = atmBankDatabase;
 } 

 // return account number
 public int getAccountNumber()
 {
 return accountNumber;
 } 

 // return reference to screen
 public Screen getScreen()
 {
 return screen;
 }
 // return reference to bank database
    public BankDatabase getBankDatabase()
     {
     return bankDatabase;
     }
    // perform the transaction (overridden by each subclass)
     abstract public void execute();
}
