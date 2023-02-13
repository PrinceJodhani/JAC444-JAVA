/**********************************************
Workshop 1
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 29/05/2022
**********************************************/

package Task2;

import java.util.Random;
import java.util.Scanner;

public class diceGame
{

	
	static int rollingDice() 
	{
        Random randomNo = new Random();
        
        return (1 + randomNo.nextInt(6));
    }

    static boolean rollWithPoint(int point) 
    {
        System.out.println("point is (established) set to " + point);
        
        int d, d1, d2;
        while (true) {
        	
            d1 = rollingDice();
            d2 = rollingDice();
            
            d = d1+d2;
            
            System.out.println("You rolled " + d1 + " + " + d2 + " = " + (d1+d2));
            
            if(d == 7 || d == 11) 
            {
                return false;
            } 
            else if(d == point)
            {
                return true;
            }
            
        }
    }

    public static void main(String[] args) 
    {
    	boolean wins;
    	
        int d1 = rollingDice();
        int d2 = rollingDice();
        
        System.out.println("You rolled " + d1 + " + " + d2 + " = " + (d1+d2));
        
        int d = d1 + d2;
        if(d == 7 || d == 11) 
        {
            wins = true;
            
        } 
        else if(d == 2 || d == 3 || d == 12) 
        {
            wins = false;
        }
        else 
        {
            wins = rollWithPoint(d);
        }
        
        if(wins) 
        {
            System.out.println("Congratulations, You win");
        }
        else 
        {
            System.out.println("Craps, Better Luck Next Time, You lose");
        }
        
    }
	
	
}
