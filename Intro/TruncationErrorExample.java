/*
 *  Date submitted:  September 2017
 *  Assignment number:  N/A
 *  Course name:  MATH 282
 *  Instructor:  Michael Grzesina
 */

/**
 *  Purpose: Show examples of truncation error in calculating e,
 *  Euler's number, a special irrational number that shows up in
 *  various mathematical situations (such as calculus)
 *
 * @author MATH 282 class
 * @version 1.0
 */
public class TruncationErrorExample
{
    /**
     * Calculate e using various numbers of terms and compare
     * to the best value possible
     * 
     * @param args  Command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        double dEuler, dEulerReverse;
        
        for ( int i = 4; i < 20; i+= 5 )
        {
            dEuler = calculateEuler( i );
            System.out.println( "\nWith " + i + " terms, e is:" );
            System.out.println( dEuler );
            System.out.println( "Compared to best possible value:" );
            System.out.println( Math.E );
            System.out.println( "Truncation error is: ");
            System.out.println( Math.E - dEuler );
        }
        
        System.out.println( "\nBut note that if we add the terms smallest to largest," );
        System.out.println( "We get a different result: ");

        dEulerReverse = 0.0;
        for ( int i = 19; i >= 0; i-- )
        {
            dEulerReverse += 1.0 / dFact(i);
        }
        System.out.println( "With 19 terms in reverse order, e is:" );
        System.out.println( dEulerReverse );
        System.out.println( "Truncation error is: " );
        System.out.println( Math.E - dEulerReverse );
        System.out.println( "So even the order of calculations can be important" );
        System.out.println( "(Adding smallest to largest avoids some round-off error)" );
    }

    
    /**
     * Purpose: Calculates e = 1/0! + 1/1! + 1/2! + ...
     * to the given number of terms
     * 
     * @param n Number of terms of infinite series to calculate
     * @return  The approximation of e to that number of terms
     */
    public static double calculateEuler( int numTerms )
    {
        double dApproximateE = 0.0;
        
        for ( int i = 0; i < numTerms; i++ )
        {
            dApproximateE += 1.0 / dFact( i );
        }
        
        return dApproximateE;
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
}
