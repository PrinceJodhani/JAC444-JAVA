/**********************************************
Workshop 10
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 05/08/2022
**********************************************/

package Task1;

import java.util.Scanner;

public class Tester {
	
   public static void main(String args[]) 
   {
	   
       Scanner sc = new Scanner(System.in);
       
       System.out.print("Enter time 1 (hour minute second): ");
       Time Time1 = new Time(sc.nextInt(), sc.nextInt(), sc.nextInt());
       System.out.println(Time1);
       
       System.out.println("Elapsed seconds in time1: " + Time1.getSeconds());
       
       System.out.print("\nEnter time 2 (elapsed time in seconds): ");
       long newTime = sc.nextLong();
       Time Time2 = new Time(newTime);
       System.out.println(Time2);
       
       System.out.println("Elapsed seconds in time2: " + Time2.getSeconds());

       System.out.println();
       System.out.println("time1.compareTo(time2)? " + Time1.compareTo(Time2));
       
       Time Time3 = Time1.clone();
       
       System.out.println("time3 is created as a clone of time1");
       System.out.println("time1.compareTo(time3)? " + Time1.compareTo(Time3));
       
       sc.close();
   }
   
}