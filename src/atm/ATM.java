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
public class ATM {
    private boolean userAuthenticated ;// whether user is authenticated
    private int currentAccountNumber;
    private Screen screen;
    private Keypad keypad ; 
    private CashDispenser cashdispenser;
    private DepositSlot depositSlot ; 
    private BankDatabase bankDatabase;
   
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
   
    public ATM(){
    userAuthenticated = false ;
    currentAccountNumber = 0;
    screen = new Screen ();
    keypad =new Keypad ();
    cashdispenser =new CashDispenser ();
    depositSlot = new DepositSlot();
    bankDatabase = new BankDatabase();
             }
    public void run()
    {
        while(true){
            while(!userAuthenticated){
                screen.displayMessageLine( "\nWelcome!" );
                authenticateUser();
            }
            performTransactions();
            userAuthenticated = false;
            currentAccountNumber = 0;
            screen.displayMessageLine( "\nThank you! Goodbye!" );
        }
    }
    // attempts to authenticate user against database
    private void authenticateUser(){
      screen.displayMessage( "\nPlease enter your account number: " );
      int accountNumber = keypad.getInput();
      screen.displayMessage( "\nEnter your PIN: " );
      int pin = keypad.getInput();
     // set userAuthenticated to boolean value returned by database
      userAuthenticated =
             bankDatabase.authenticateUser( accountNumber, pin );
      // check whether authentication succeeded
      if ( userAuthenticated ){
      currentAccountNumber = accountNumber;
      }else
         screen.displayMessageLine( "Invalid account number or PIN. Please try again." );
    }
// display the main menu and perform transactions
    private void performTransactions(){
        
        Transaction currentTransaction = null;
        boolean userExited = false;
        while ( !userExited ){
            int mainMenuSelection = displayMainMenu();
            switch ( mainMenuSelection ){
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                 case DEPOSIT:
                     currentTransaction =
                             createTransaction( mainMenuSelection );
                     currentTransaction.execute();
                     break;
                 case EXIT:     
                     screen.displayMessageLine( "\nExiting the system..." );
                     userExited = true;
                     break;
                     default:
                     screen.displayMessageLine(
                             "\nYou did not enter a valid selection. Try again." );
                    break; 
            }
        }
    }
    // display the main menu and return an input selection
    private int displayMainMenu(){
        screen.displayMessageLine( "\nMain menu:" );
        screen.displayMessageLine( "1 - View my balance" );
        screen.displayMessageLine( "2 - Withdraw cash" );
        screen.displayMessageLine( "3 - Deposit funds" );
        screen.displayMessageLine( "4 - Exit\n" );
        screen.displayMessage( "Enter a choice: " );
            return keypad.getInput();
        
        
    }
    // return object of specified Transaction subclass
    private Transaction createTransaction( int type ){
      Transaction temp = null;
      switch ( type ){
          case BALANCE_INQUIRY:
          temp = new BalanceInquiry(
                  currentAccountNumber, screen, bankDatabase );
              break;
          case WITHDRAWAL:
              temp = new Withdrawal( currentAccountNumber, screen,
                 bankDatabase, keypad, cashdispenser );
              break;
          case DEPOSIT:
              temp = new Deposit( currentAccountNumber, screen,
                     bankDatabase, keypad, depositSlot ); 
              break;
      }
      return temp ;
       }
}
