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

package Task2;

import Task1.GeometricObject;

class Triangle2 extends GeometricObject 
{
    public double s1 = 1.0;
    public double s2 = 1.0;
    public double s3 = 1.0;

    public Triangle2() { }

    public Triangle2(double s1, double s2, double s3) throws TriangleException 
    {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        isValidTriangle();
    }

    private void isValidTriangle() throws TriangleException
    {
        if (!isTriangle(s1, s2, s3)) {
            throw new TriangleException(s1, s2, s3);
        }
    }

    public double GetS1() 
    {
        return s1;
    }
    public double GetS2() 
    {
        return s2;
    }
    public double GetS3() 
    {
        return s3;
    }

    public void GetS1(double m_side1) throws TriangleException 
    {
        this.s1 = m_side1;
        isValidTriangle();
    }

    public void GetS2(double m_side2) throws TriangleException
    {
        this.s2 = m_side2;
        isValidTriangle();
    }

    public void GetS3(double m_side3) throws TriangleException 
    {
        this.s3 = m_side3;
        isValidTriangle();
    }

    @Override
    public double getArea() 
    {
        double s = (s1 + s2 + s3) / 2.0;
        return Math.pow(s * (s - s1) * (s - s2) * (s - s3), 0.5);
    }
    
    @Override
    public double getPerimeter() 
    {
        return s1 + s2 + s3;
    }    

    @Override
    public String toString() 
    {
        return "Triangle { " + "side1 = " + s1 + ", side2 = " + s2 + ", side3 = " + s3 + " }";
    }
    
    public static boolean isTriangle(double m_side1, double m_side2, double m_side3) 
    {
        return  ((m_side1 + m_side2 > m_side3) &&
                (m_side1 + m_side3 > m_side2) &&
                (m_side3 + m_side2 > m_side1));
    }
    public class TriangleException extends Exception 
    {
        private double s1;
        private double s2;
        private double s3;
        public TriangleException(double s1, double s2, double s3) 
        {
            super("The sides of the Triangle violates the rules:" + " side1 = " + s1 + " side2 = " + s2 + " side3 = " + s3);
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
        public double getS1() 
        {
            return s1;
        }
        public double getS2() 
        {
            return s2;
        }
        public double getS3()
        {
            return s3;
        }
    }
}