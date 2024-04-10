/*
 *  Date submitted:  August 31, 2017
 *  Assignment number:  N/A
 *  Course name:  MATH 282
 *  Instructor:  Michael Grzesina
 */

import java.math.BigInteger;

/**
 *  Purpose: Programming practice (if, loops, methods) for MATH 282 showing that
 *  results of mathematical calculations don't always work out as we think they should 
 *
 * @author MATH 282 class
 * @version 1.0
 */
public class Math282Intro
{
    /**
     * Purpose: Main method runs when program starts, carries out various tests
     * 
     * @param args  Commmand-line arguments (not used)
     */
	public static void main(String[] args) 
	{
		double dSum = 0.1 + 0.1 + 0.1;
		double dTarget = 0.3;
		
		if (dSum == dTarget)
		{
		    System.out.println( dSum + " and " + dTarget + " are equal");
		}
		else
		{
		    System.out.println( dSum + " does not equal " + dTarget);
		}

		System.out.println( "\nInteger loop:");
		for (int i = 0; i < 10; i++)
		{
		    System.out.println( i / 10.0 );
		}
		
		System.out.println( "\nDouble loop" );
        for (double x = 0.0; x < 1.0; x += 0.1)
        {
            System.out.println( x );
        }
		
        System.out.println( "\nFactorials:" );
        System.out.println( iFact( 7 ) );
        System.out.println( lFact( 7 ) );
        System.out.println( dFact( 7 ) );
        System.out.println( biFact( 7 ));
        
        System.out.println("\nTruncation error");
        double eulerEstimate = 0.0;
        
        for(int n = 0; n <30; n++)
        {
            eulerEstimate += 1.0/ dFact(n);
            System.out.println(n + "\t" + eulerEstimate);
        }
        
        //We get a better estimate if we start from the biggest number and work our way down to 0
        //The order of calculations can affect how many errors occur in our calculations
        eulerEstimate = 0.0;
        for(int n =20; n >=0; n--)
        {
            eulerEstimate += 1.0 / dFact(n);
            
        }
        
        System.out.println(eulerEstimate);
        System.out.println(Math.E);
        System.out.println("Error: " + (Math.E - eulerEstimate));
        
	}
	
	
    /**
     * Purpose: Calculates n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1
     * Using an int data type, it is only correct up to ???
     * 
     * @param n Number for which the factorial is to be calculated
     * @return  The factorial n! of the given number
     */
    public static int iFact( int n )
    {
        int result = 1;
     
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        
        return result;
    }


    /**
     * Purpose: Calculates n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1
     * Using a long data type, it is only correct up to ???
     * 
     * @param n Number for which the factorial is to be calculated
     * @return  The factorial n! of the given number
     */
    public static long lFact( int n )
    {
        long result = 1;
     
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        
        return result;
    }


    /**
     * Purpose: Calculates n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1
     * Using an double data type, it is only completely accurate (no
     * rounding) up to ???, and it is only correct with rounding up to ???
     * 
     * @param n Number for which the factorial is to be calculated
     * @return  The factorial n! of the given number
     */
    public static double dFact( int n )
    {
        double result = 1.0;
     
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        
        return result;
    }


    /**
     * Purpose: Calculates n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1
     * Using a BigInteger data type, it is correct for arbitrarily precise
     * values, but only displays values on the console up to about ???
     * and starts being noticeably slower in its calculations at about ???
     * 
     * @param n Number for which the factorial is to be calculated
     * @return  The factorial n! of the given number
     */
    public static BigInteger biFact( int n )
    {
        BigInteger result = BigInteger.ONE;
     
        for (int i = 2; i <= n; i++)
        {
            BigInteger value = new BigInteger( "" + i );
            result = result.multiply( value );
        }
        
        return result;
    }
}
