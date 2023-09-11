/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author Yousuf
 */
public class Keypad {
    private Scanner input;
    public Keypad(){
        input = new Scanner (System.in);
    }
    // return an integer value entered by user
    public int getInput(){
        return input.nextInt();
    }
}
