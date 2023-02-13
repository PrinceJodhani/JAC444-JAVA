/**********************************************
Workshop 8
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 25/07/2022
**********************************************/

package Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test 
{
	
    private static int twT = 2000;
    private static double[][] matx1 = new double[twT][twT];;
    private static double[][] matx2 = new double[twT][twT];;

    public static void main(String[] args) throws InterruptedException {
    	
    	long startT, endT ;
    	int select = 0;
    	Scanner sc = new Scanner(System.in);
    	boolean TF = true;
    	
	    	do 
	    	{
	    	   	try 
	    	   	{
	    		System.out.println("Please Choose an option");
		    	System.out.println("1 - Matrix Addition");
		    	System.out.println("2 - Reverse Thread");
		    	System.out.print("I want to select: ");
		    	select = sc.nextInt();
		    	System.out.print("\n");
		    	
		    	if (select == 1) 
		    	{
		    		startT = System.currentTimeMillis();
		            for(int i = 0; i < matx1.length; i++) 
		            {
		                for(int j = 0; j < matx2[i].length; j++) {
		                    matx1[i][j] = Math.random();
		                    matx2[i][j] = Math.random();
		                }
		            }

		            Thread thrd1 = new Thread(String.valueOf(MatrixAddition.parallelAddMatrix(matx1, matx2)));
		            Thread thrd2 = new Thread(String.valueOf(MatrixAddition.parallelAddMatrix(matx1, matx2)));
		            Thread thrd3 = new Thread(String.valueOf(MatrixAddition.parallelAddMatrix(matx1, matx2)));
		            Thread thrd4 = new Thread(String.valueOf(MatrixAddition.parallelAddMatrix(matx1, matx2)));
		            thrd1.start();
		            thrd2.start();
		            thrd3.start();
		            thrd4.start();
		            thrd1.join();
		            thrd2.join();
		            thrd3.join();
		            thrd4.join();
		            endT = System.currentTimeMillis();
		            System.out.println("It passed: " + (endT - startT) + " milliseconds using parallelAddMatrix");
		            
		            startT = System.currentTimeMillis();
		            MatrixAddition.sequentialAddMatrix(matx1, matx2);
		            
		            endT = System.currentTimeMillis();
		            System.out.println("It passed: " + (endT - startT) + " milliseconds using sequentialAddMatrix");
		           
		            TF = false;
		    		
		    	} 
		    	else if (select == 2) 
		    	{
		    		TF = false;
		            ReverseThread thread = new ReverseThread(1);
		            thread.start();
		    	}
		    	else 
		    	{
		    		System.out.println("Please choose a valid option");
		    		TF = true;
		    	}
		    	
		   		
		    	}
	    	   	catch(InputMismatchException err) 
	    	   	{
		    		System.out.println("Please choose a number\n");
		    		sc.next();
		    		
		    	}
	    	   	catch(Exception e) 
	    	   	{
		    		e.printStackTrace();
		    	}
	    		
	    	} while(TF);

        sc.close();
        
    }
}