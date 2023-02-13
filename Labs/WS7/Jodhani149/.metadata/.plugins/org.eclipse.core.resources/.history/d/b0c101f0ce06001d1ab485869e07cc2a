/**********************************************
Workshop 7
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 18/07/2022
**********************************************/

package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorting 
{
    public static ArrayList<String> boys_arr = new ArrayList<>();
    public static ArrayList<String> girls_arr = new ArrayList<>();
	public static ArrayList<String> commonName = new ArrayList<>();
    public static ArrayList<String> totlines = new ArrayList<>();
    
    public static void main(String[] args) 
    {

        Scanner scn = new Scanner(System.in);

        System.out.print("\nEnter the file name: ");
        String file = scn.next();

        try (BufferedReader br = new BufferedReader(new FileReader(file));) 
        {
            String strData;
            
            while ((strData = br.readLine()) != null) 
            {
                totlines.add(strData);
            }
        } 
        catch (Exception error) 
        {
            error.printStackTrace();
        }

        for (String str : totlines) 
        {
            String[] arr = str.split("\t");
            
            for (String item : arr) 
            {
                item.trim();
            }

            boys_arr.add(arr[1]);
            girls_arr.add(arr[3].substring(0, arr[3].length() - 1));
        }

        for (String boy : boys_arr) 
        {
            for (String girl : girls_arr) 
            {
                if (boy.equals(girl)) commonName.add(boy);
            }
        }

        System.out.printf("\nTotal %d names are used for both genders:\n", commonName.size());
        
        for (String name : commonName) 
        {
            System.out.printf("%s\t", name);
        }
        System.out.println("");

        Collections.sort(boys_arr);
        Collections.sort(girls_arr);

        for (String name : commonName) 
        {
            boys_arr.remove(name);
            girls_arr.remove(name);
        }

        System.out.println("\n\nThe sorted list of names without duplication:");
        System.out.println("\nBoys names: ");
        
        System.out.println(boys_arr);
        
        System.out.println("\nGirls names: ");
        
        System.out.println(girls_arr);

        scn.close();
    }
}