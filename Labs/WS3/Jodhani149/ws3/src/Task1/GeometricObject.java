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

package Task1;

public abstract class GeometricObject 
{
    private String m_color = "white";
    
    private boolean filled;
    protected GeometricObject() 
    {
    }

    protected GeometricObject(String color, boolean filled) 
    {
        this.m_color = color;
        this.filled = filled;
    }
    
    public String getColor() 
    {
        return m_color;
    }
    
    public void setColor(String color) 
    {
        this.m_color = color;
    }
    
    public boolean isFilled() 
    {
        return filled;
    }
    
    public void setFilled(boolean filled) 
    {
        this.filled = filled;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
}
