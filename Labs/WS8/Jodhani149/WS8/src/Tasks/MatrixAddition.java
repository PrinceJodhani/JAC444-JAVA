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


public class MatrixAddition 
{
	
    private static double[][] res;	

    public static double[][] parallelAddMatrix(double[][] valA, double[][] valB) 
    {
        res = new double[valA.length][valB.length];
        addMatrix(valA, valB);
        return res;
    }

    public static void addMatrix(double[][] a, double[][] b) 
    {
        for(int i = 0; i < a.length; i++) 
        {
            for(int j = 0; j < b.length; j++) 
            {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
    }

    public static double[][] sequentialAddMatrix(double[][] c, double[][] d) 
    {
        res = new double[c.length][d.length];
        addMatrix(c, d);
        return res;
    }
   
}