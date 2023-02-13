/**********************************************
Workshop 4
Course: JAC444 - 4th
Last Name: Jodhani
First Name: Prince
ID: 149455206
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature : Prince
Date: 19/06/2022
**********************************************/

package Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class hangman 
{
	 public static void main(String[] args) throws Exception 
	 {
	        Scanner scn = new Scanner(System.in);
	        BufferedReader read;
	        BufferedWriter write;
	        Vector<String> m_vec = new Vector<>();
	        Random ran = new Random();
	        
	        int m_guess = 0;
	        char ch;
	        
	        System.out.println("\nGame starts\n");

	        do 
	        {
	            String str = "";
	            String fname = "Hangman.txt";
	            String m_line;
	            
	            read = new BufferedReader(new FileReader(fname));
	            
	            Vector<String> m_word = new Vector<>();
	            
	            while ((m_line = read.readLine()) != null) 
	            {
	                m_word.add(m_line);
	            }
	            
	            read.close();
	            
	            String m_res = m_word.get(ran.nextInt(m_word.size()));
	            String m_hstr = new String();

	            for (int i = 0; i < m_res.length(); i++) 
	            {
	                m_hstr += '*';
	            }

	            while (m_hstr.indexOf("*") != -1) 
	            {
	                System.out.printf("(Guess) Enter a letter in word %s > ", m_hstr);
	                
	                String m_choose = scn.next();

	                for (int i = 0; i < m_res.length(); i++) 
	                {
	                    if (m_hstr.charAt(i) == m_choose.charAt(0)) 
	                    {
	                        System.out.println("        " + m_choose + " is already in the word" );
	                    }
	                }
	                
	                m_vec.add(m_choose);
	                
	                if (m_res.indexOf(m_choose) != -1)
	                {
	                    String m_cp = m_hstr;
	                    m_hstr = "";
	                    
	                    for (int i = 0; i < m_res.length(); i++)
	                    {
	                        if (m_res.charAt(i) == m_choose.charAt(0)) 
	                        {
	                            m_hstr += m_res.charAt(i);
	                        }
	                        else 
	                        {
	                            m_hstr += m_cp.charAt(i);
	                        }
	                    }
	                }
	                else 
	                {
	                    System.out.println("        " + m_choose + " is not in the word");
	                    m_guess++;
	                }
	            }
	            
	            System.out.printf("The word is %s. You missed %s %s\n", m_res, m_guess, (m_guess == 1 ? "time" : "times"));
	            System.out.print("Enter a new word to be added in the memory> ");
	           
	            String m_words = "";
	            
	            m_words += scn.nextLine();
	            m_words += scn.nextLine();
	            
	            write = new BufferedWriter(new FileWriter(fname, true));
	            write.write(m_words + "\n");
	            write.close();

	            do 
	            {
	                System.out.print("Do you want to guess another word? Enter y or n> ");
	                str = scn.next();
	                ch = str.charAt(0);
	            }
	            while((ch != 'Y' && ch != 'y' && ch != 'N' && ch != 'n') || str.length() > 1);
	        }
	        while(ch == 'Y' || ch == 'y');
	        
	        scn.close();
	        
	        System.out.println("\nThanks.");
	    }
}
