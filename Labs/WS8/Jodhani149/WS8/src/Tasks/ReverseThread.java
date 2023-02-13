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


public class ReverseThread extends Thread 
{
    private static int cnt;

    public ReverseThread(int val) 
    {
        cnt = val;
        this.setName(String.valueOf(val));

    }

    public void run() 
    {
        cnt++;
        if (cnt <= 51) 
        {
            ReverseThread thread = new ReverseThread(cnt);
            thread.start();

            try 
            {
                thread.join();
                System.out.println("Hi from Thread! " + this.getName());
                
            }
            catch (Exception thErr)
            {
            	thErr.printStackTrace();
            }
        }
        else
        {
        	return;
        }
    }
    
    
}