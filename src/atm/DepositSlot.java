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
public class DepositSlot {
    // indicates whether envelope was received (always returns true,
    // because this is only a software simulation of a real deposit slot)
    public boolean isEnvelopeReceived(){
      return true;  
    }
    
}
