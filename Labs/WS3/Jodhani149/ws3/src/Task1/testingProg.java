/**********************************************
Workshop 3
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 12/06/2022
**********************************************/

package Task1;

import java.util.Scanner;

public class testingProg 
{
	 public static void main(String[] args) 
	 {

	        @SuppressWarnings("resource")
			Scanner scnr = new Scanner(System.in);
	   
	        System.out.print("\nEnter the three sides of a triangle: ");
	        
	        double[] t_sides = new double[3];
	        
	        for (int i= 0; i < t_sides.length; i++) 
	        {
	            t_sides[i] = scnr.nextDouble();
	        }

	        if (t_sides[0] <= 0 || t_sides[1] <= 0 || t_sides[2] <= 0)
	        {
	            System.out.print("Invalid values, please enter positive values");
	        }
	        else 
	        {
	            System.out.print("Enter the colour of a Triangle: ");
	            String color = scnr.next();
	            System.out.print("Is the Triangle filled? true/false: ");
	            String strn = scnr.next();
	            
	            boolean filled = strn.equals("true");
	            Triangle tt1 = new Triangle(t_sides[0], t_sides[1], t_sides[2]);
	            
	            tt1.setColor(color);
	            tt1.setFilled(filled);
	            
	            System.out.println("\nThe Area of a traingle = " + tt1.getArea());
	            System.out.println("The Perimeter of a triangle = " + tt1.getPerimeter());
	            System.out.println("Colour of a triangle = " + tt1.getColor());
	            System.out.println("Is the triangle filled? " + tt1.isFilled());
	        }
	    }
}
