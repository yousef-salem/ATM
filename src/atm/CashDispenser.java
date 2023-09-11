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
public class CashDispenser {
    // the default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 500;
    private int count;
    // no-argument CashDispenser constructor initializes count to default
    public CashDispenser(){
    count = INITIAL_COUNT;
    }
  // simulates dispensing of specified amount of cash
    public void dispenseCash( int amount ){
      int billsRequired = amount / 20;  
      count -= billsRequired;
    }
    // indicates whether cash dispenser can dispense desired amount
 public boolean isSufficientCashAvailable( int amount ){
     int billsRequired = amount / 20;
     if ( count >= billsRequired )
         return true; // enough bills available
    else
        return false; // not enough bills available
 }
}
