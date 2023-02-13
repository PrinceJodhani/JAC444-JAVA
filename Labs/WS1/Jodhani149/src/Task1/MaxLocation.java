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

package Task1;

import java.util.Scanner;

public class MaxLocation {
    public int row;
    public int column;
    public double maxValue;

    public MaxLocation() {
        row = 0;
        column = 0;
    }

    public static MaxLocation findLargest(double[][] pdata) {
        MaxLocation mLocation = new MaxLocation();
        mLocation.row = 0; 
        mLocation.column = 0;
        mLocation.maxValue = pdata[0][0];
        
        for (int i = 0; i < pdata.length; ++i) 
        {
            for (int j = 0; j < pdata[i].length; ++j)
            {
                if (pdata[i][j] > mLocation.maxValue)
                {
                	mLocation.maxValue = pdata[i][j];
                	mLocation.row = i;
                	mLocation.column = j;
                }
            }
        }
        return mLocation;
    }

    public static void main(String[] args) 
    {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");
        int rows = scnr.nextInt();
        int columns = scnr.nextInt();
        System.out.println("\nEnter the array:");
        
        double[][] arrdata = new double[rows][columns];
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++) {
                arrdata[i][j] = scnr.nextDouble();
            }
        }
        MaxLocation location = findLargest(arrdata);
        System.out.println("The location of the largest element " + location.maxValue + " at (" + location.row + ", " + location.column + ")");
    }
}