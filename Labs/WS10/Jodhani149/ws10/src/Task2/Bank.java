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

package Task2;


import java.util.Locale;
import java.util.Scanner;

public class Bank {
	
	public static void main(String[] args) 
	{
		
		int BID, b_limit;
		double Loan_amt;
		boolean TF = false;
		
		Scanner scnr = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.print("Enter number of banks: ");
		int nn = scnr.nextInt();
		
		double[] bal = new double[nn];
		double[][] b_borrowers = new double[nn][nn];
		
		System.out.print("Minimum asset limit: ");
		b_limit = scnr.nextInt();
		
		for (int i = 0; i < nn; i++) 
		{
			System.out.println("For Bank #" + i + " :");
			System.out.print("\tBalance: ");
			bal[i] = scnr.nextDouble();
			
			System.out.print("\tNumber of banks Loaned: ");
			int tot_banksLoaned = scnr.nextInt();
			
			for (int j = 0; j < tot_banksLoaned; j++)
			{
				System.out.print("\t\tBank ID who gets the loan: ");
				BID = scnr.nextInt();
				
				System.out.print("\t\tLoaned Amount: ");
				Loan_amt = scnr.nextDouble();
				b_borrowers[i][BID] = Loan_amt;
			}
			
		}
		
		boolean[] verify = new boolean[nn];
		do 
		{
			TF = false;
			
			for (int i = 0; i < nn; i++) 
			{
				double b_asset = bal[i];
				for (int j = 0; j < b_borrowers[i].length; j++) 
					b_asset += b_borrowers[i][j];
		
				if (b_asset < b_limit) 
				{
					verify[i] = true;
					
					for (int j = 0; j < b_borrowers.length; j++) 
					{
						if (b_borrowers[j][i] != 0)
						{
							b_borrowers[j][i] = 0;
							TF = true;
						}
					}
				}
			}
		} while (TF);
		
		System.out.println("\n\n");
		System.out.print("Unsafe banks are:");
		for (int i = 0; i < verify.length; i++) 
		{
			if (verify[i]) 
			{
				  System.out.print("Bank " + i + " ");
			}
		}
		 
		scnr.close();
	}
}