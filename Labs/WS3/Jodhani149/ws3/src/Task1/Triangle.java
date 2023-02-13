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

class Triangle extends GeometricObject 
{
    public double m_side1 = 1.0;
    public double m_side2 = 1.0;
    public double m_side3 = 1.0;

    public Triangle() 
    { }

    public Triangle(double s1, double s2, double s3) 
    {
        this.m_side1 = s1;
        this.m_side2 = s2;
        this.m_side3 = s3;
    }

    public double getS1() 
    {
        return m_side1;
    }
    
    public double getS2() 
    {
        return m_side2;
    }
    
    public double getS3() 
    {
        return m_side3;
    }

    public void setS1(double s1) 
    {
        this.m_side1 = s1;
    }
    
    public void setS2(double s2) 
    {
        this.m_side2 = s2;
    }
    
    public void setS3(double s3)  
    {
        this.m_side3 = s3;
    }

    @Override
    public double getArea() 
    {
        double tot_s = (m_side1 + m_side2 + m_side3) / 2.0;
		double tot_area = Math.pow(tot_s * (tot_s - m_side1) * (tot_s - m_side2) * (tot_s - m_side3), 0.5);
        return tot_area;
    }

    @Override
    public double getPerimeter() 
    {
		double total = m_side1 + m_side2 + m_side3;
        return total;
    }
	
	@Override
    public String toString() 
	{
        return "Triangle { " + "All sides of triangle: " + m_side1 + ", " + m_side2 + ", " + m_side3 + " }";
    }    
}
