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
public class Withdrawal extends Transaction {
    private int amount; 
    private Keypad keypad; 
    private CashDispenser cashDispenser; 

 // constant corresponding to menu option to cancel
    private final static int CANCELED = 6;

 
 public Withdrawal( int userAccountNumber, Screen atmScreen,
 BankDatabase atmBankDatabase, Keypad atmKeypad,
 CashDispenser atmCashDispenser )
 {
 
 super( userAccountNumber, atmScreen, atmBankDatabase );

 keypad = atmKeypad;
 cashDispenser = atmCashDispenser;
 } 
 @Override
 public void execute()
 {
 boolean cashDispensed = false; 
 double availableBalance; 

 
 BankDatabase bankDatabase = getBankDatabase();
 Screen screen = getScreen();

 do
 {
 
 amount = displayMenuOfAmounts();

 
 if ( amount != CANCELED )
 {
    availableBalance =
    bankDatabase.getAvailableBalance( getAccountNumber() );
    if ( amount <= availableBalance ){
        if ( cashDispenser.isSufficientCashAvailable( amount ) ){
            bankDatabase.debit( getAccountNumber(), amount );

             cashDispenser.dispenseCash( amount ); 
             cashDispensed = true;
             screen.displayMessageLine( "\nYour cash has been" +
                         " dispensed. Please take your cash now." );
        }else // cash dispenser does not have enough cash
             screen.displayMessageLine(
                     "\nInsufficient cash available in the ATM." +
                                 "\n\nPlease choose a smaller amount." );
    }else{
      screen.displayMessageLine(
        "\nInsufficient cash available in the ATM." +
             "\n\nPlease choose a smaller amount." );  
        
    }
  }else{
     screen.displayMessageLine( "\nCanceling transaction..." );
             return;
 }
 }while ( !cashDispensed);
 }
 // display a menu of withdrawal amounts and the option to cancel;
 // return the chosen amount or 0 if the user chooses to cancel
 private int displayMenuOfAmounts(){
     int userChoice = 0; // local variable to store return value

 Screen screen = getScreen(); // get screen reference

 // array of amounts to correspond to menu numbers
 int[] amounts = { 0, 20, 40, 60, 100, 200 };

 // loop while no valid choice has been made
 while ( userChoice == 0 )
 {
 // display the withdrawal menu
 screen.displayMessageLine( "\nWithdrawal Menu:" );
 screen.displayMessageLine( "1 - $20" );
 screen.displayMessageLine( "2 - $40" );
 screen.displayMessageLine( "3 - $60" );
 screen.displayMessageLine( "4 - $100" );
 screen.displayMessageLine( "5 - $200" );
 screen.displayMessageLine( "6 - Cancel transaction" );
 screen.displayMessage( "\nChoose a withdrawal amount: " );

 int input = keypad.getInput(); // get user input through keypad

 // determine how to proceed based on the input value
 switch ( input )
 {
 case 1: // if the user chose a withdrawal amount
 case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
 case 3: // corresponding amount from amounts array
 case 4:
 case 5:
 userChoice = amounts[ input ]; // save user's choice
 break;
 case CANCELED: // the user chose to cancel
 userChoice = CANCELED; // save user's choice
 break;
 default: // the user did not enter a value from 1-6
 screen.displayMessageLine(
 "\nInvalid selection. Try again." );
 }
}
 return userChoice;
}
}