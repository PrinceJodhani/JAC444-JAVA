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

package Task2;

public class TestingProg2 
{
	 public static void main(String[] args) 
	 {
	        System.out.println("\nTriangle\n");
	        
	        try {
	            Triangle2 tt1 = new Triangle2(5, 5, 5);
	            
	            System.out.println("Area = " + tt1.getArea());
	            System.out.println("Perimeter = " + tt1.getPerimeter());
	            
	            Triangle2 tt2 = new Triangle2(0, 9, 10);
	            
	            System.out.println("Area = " + tt2.getArea());
	            System.out.println("Perimeter = " + tt2.getPerimeter());
	        }
	        catch (Triangle2.TriangleException except) 
	        {
	            System.out.println("\nIllegal triangle\n");
	            System.out.println("Side1: " + except.getS1());
	            System.out.println("Side2: " + except.getS2());
	            System.out.println("Side3: " + except.getS3());
	            except.printStackTrace();
	        }
	    }
}
