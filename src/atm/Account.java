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
public class Account {
  private int accountNumber; 
  private int pin; 
  private double availableBalance; // funds available for withdrawal
  private double totalBalance;     // funds available + pending deposits
  public Account( int theAccountNumber, int thePIN,  
          double theAvailableBalance, double theTotalBalance )
    {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
    }
  // determines whether a user-specified PIN matches PIN in Account
  public boolean validatePIN( int userPIN )
    {
      if (userPIN==pin)
          return true ;
       else 
          return false ;
    }
  // returns available balance
  public double getAvailableBalance()
    {
    return availableBalance;
    }
  // returns the total balance
  public double getTotalBalance()
    {
     return totalBalance;
    }
  // credits an amount to the account
  public void credit( double amount )
     {
     totalBalance += amount; // add to total balance
     }
  // debits an amount from the account
  public void debit( double amount )
    {
    availableBalance -= amount; // subtract from available balance
     totalBalance -= amount; // subtract from total balance
    }
  // returns account number
  public int getAccountNumber()
    {
        return accountNumber;
    }
}
