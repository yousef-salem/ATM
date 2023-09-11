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
public class BankDatabase {
    private Account[] accounts;
    public BankDatabase(){
        accounts = new Account[ 2 ]; // just  accounts for testing
        accounts[ 0 ] = new Account( 12345, 54321, 1000.0, 1200.0 );
         accounts[ 1 ] = new Account( 98765, 56789, 200.0, 200.0 );  
    }
    // retrieve Account object containing specified account number
    private Account getAccount( int accountNumber ){
        // loop through accounts searching for matching account number
        for ( Account currentAccount : accounts ){
            if ( currentAccount.getAccountNumber() == accountNumber )
                return currentAccount;     
        }
        return null;
    }
    // determine whether user-specified account number and PIN match
    // those of an account in the database
    public boolean authenticateUser( int userAccountNumber, int userPIN ){
        Account userAccount = getAccount( userAccountNumber );
        if ( userAccount != null )
             return userAccount.validatePIN( userPIN );
        else
             return false;
    }
    // return available balance of Account with specified account number
     public double getAvailableBalance( int userAccountNumber ){
         return getAccount( userAccountNumber ).getAvailableBalance();
     }
     // return total balance of Account with specified account number
     public double getTotalBalance( int userAccountNumber ){
       return getAccount( userAccountNumber ).getTotalBalance();  
     }
     // credit an amount to Account with specified account number
     public void credit( int userAccountNumber, double amount ){
         getAccount( userAccountNumber ).credit( amount );
     }
     // debit an amount from Account with specified account number
    public void debit( int userAccountNumber, double amount ){
        getAccount( userAccountNumber ).debit( amount );
    }
}
