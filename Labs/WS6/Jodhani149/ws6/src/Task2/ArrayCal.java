/**********************************************
Workshop 6
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 10/07/2022
**********************************************/

package Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ArrayCal {

    public static void main(String[] args) 
    {
    	
        System.out.println("\nEnter the values for calculation.(Enter 0 to submit.)");

        Vector<Double> vec_values = new Vector<>();
        double isval = 1;

        while (isval != 0) 
        {
            System.out.print("Enter the value for array: ");
            isval = readDouble();
            
            if (isval != 0) 
            {
                vec_values.add(isval);
            }
        }

        double[] arrval = new double[vec_values.size()];
        
        for (int i = 0; i < vec_values.size(); i++) 
        {
            arrval[i] = vec_values.get(i);
        }

        System.out.println("\n\nArray Calculations:");
        System.out.println("Maximum value of the array: " + Max.apply(arrval));
        System.out.println("Minimum value of the array: " + Min.apply(arrval));
        System.out.println("Addition of all the values: " + Add.apply(arrval));
        System.out.println("Average of the values: " + Avg.apply(arrval));
        System.out.print("\nEnter the value from your array to count it: ");
        double searchVal = readDouble();
        ArrayProcessor find_Function = counter(searchVal);
        System.out.println(searchVal + " was entered " + find_Function.apply(arrval) + " times.\n");
        System.out.println("Thank You!!, Goodbye.");
    }

    public static final ArrayProcessor Min = (arr) -> 
    {
        Arrays.sort(arr);
        return arr[0];
    };
    
    public static final ArrayProcessor Max = (arr) -> 
    {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    };
    
    public static final ArrayProcessor Add = (arr) -> 
    {
        double sum = 0;
        
        for (double num : arr)
        {
            sum += num;
        }
        
        return sum;
    };

    public static final ArrayProcessor Avg = (arr) -> 
    {
        return (Add.apply(arr) / arr.length);
    };
    
    public static ArrayProcessor counter(double value)
    {
        ArrayProcessor cnt = (arr) -> 
        {
            int count = 0;
            
            for (double num : arr) 
            {
                if (num == value) 
                {
                    count++;
                }
            }
            
            return count;
        };
        
        return cnt;
    }

    private static double readDouble() 
    {
        @SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
        double isval = 1;
        boolean TF = false;
        
        while (!TF) 
        {
            try 
            {
                isval = scn.nextDouble();
                TF = true;
            } 
            catch (Exception ignored) 
            {
                scn.next();
                System.out.print("Please Try again: ");
                TF = false;
            }
        }
        return isval;
    }
}