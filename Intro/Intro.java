/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  MATH 282
 *  Instructor:  Michael Grzesina
 */

/**
 * Purpose: Starting template for a new program. Replace these comments with
 * your own. Briefly describe the purpose of the class, how the class is used in
 * the program and how it interacts with other classes.
 *
 * @author YOUR NAME AND SASKPOLYTECH USERNAME GO HERE
 * @version 1.0
 */

public class Intro
{

    /**
     * Purpose:
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        double value1 = 0.3;
        double value2 = 0.1 + 0.1 + 0.1;

        System.out.println("Hello World!");

        if ( value1 == value2 )
        {
            System.out.println("Values are equal");
        }
        else
        {
            System.out.println(value1 + "is not equal to " + value2);
        }

        for ( int i = 1; i < 10; i++ )
        {
            System.out.println("The value of i is: " + i);
        }

        for ( double d = 0.1; d < 0.95; d += 0.1 )
        {
            System.out.println("The value of d is: " + d);
        }
        
        for(int i =0; i < 200; i++)
        {
            
           // System.out.println(i + "! is equal to " + iFact(i));
            //System.out.println(i + "! is equal to " + lFact(i));
            System.out.println(i + "! is equal to " + dFact(i));
            
        }
            

    }
    
    /**
     * Calculate the factorial of a given value
     * n! = 1 * 2 * 3 * ... * n
     * 0! = 1
     * Only works for 0! to 12!
     * Purpose:
     * @param n The number to find the factorial of
     * @return n!
     */
    public static int iFact(int n)
    {
        int iResult = 1;
        
        for(int i= 2; i <= n; i++)
        {
            iResult *= i;
        }
        
        return iResult;
    }
    
    /**
     * Calculate the factorial of a given value
     * n! = 1 * 2 * 3 * ... * n
     * 0! = 1
     * This one only works from 0! up to 20!
     * Purpose:
     * @param n The number to find the factorial of
     * @return n!
     */
    public static long lFact(long n)
    {
        long lResult = 1;
        
        for(int i= 2; i <= n; i++)
        {
            lResult *= i;
        }
        
        return lResult;
    }
    
    /**
     * Calculate the factorial of a given value
     * n! = 1 * 2 * 3 * ... * n
     * 0! = 1
     * 
     * Purpose:
     * @param n The number to find the factorial of
     * @return n!
     */
    public static double dFact(double n)
    {
        double dResult = 1;
        
        for(int i= 2; i <= n; i++)
        {
            dResult *= i;
        }
        
        return dResult;
    }
    
    
}
