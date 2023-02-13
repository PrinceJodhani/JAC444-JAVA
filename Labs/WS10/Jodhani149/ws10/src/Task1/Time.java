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

package Task1;

public class Time implements Comparable<Time>, Cloneable
{
	private long ela_Time;
	
	public Time() 
	{
		
	}
	
	public Time(int hr, int minutes, int sec) 
	{
		this.ela_Time = (hr * 3600) + (minutes * 60) + sec;
	}

	public Time(long ela_t)
	{
		this.ela_Time = ela_t;
	}
	
	public long getSeconds()
	{
		return  ela_Time;
	} 
	
	public int getSecond() 
	{
		return (int) this.ela_Time % 60;
	}
	
	public int getMinute() 
	{
		return (int) (this.ela_Time / 60) % 60;
	}

	public int getHour()
	{
		return (int) (this.ela_Time / 3600) % 24;
	}



	   
	@Override
	public int compareTo(Time time) 
	{
		return (int) (this.ela_Time - time.ela_Time);
	}
	  
	public Time clone()
	{
		Time newTime = new Time(ela_Time);
		return newTime;
	}
	  
	   
	public String toString() 
	{
		return String.format(this.getHour()%24 + " hours " + this.getMinute() + " minutes "+ this.getSecond() +" seconds");
	}
	   
}