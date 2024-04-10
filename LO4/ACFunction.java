package lo4;

/**
 *  Abstract class for functions to be used for finding zeros, etc.<br>
 *
 * @author     MATH 282
 * @created    August 30, 2017
 */

public abstract class ACFunction implements IFunction
{
    /**
     *  Returns the value of the function at a chosen point - must implement<br>
     *  specific calculations in any function class extending ACFunction<br>
     *
     * @param  x  Value to evaluate function at
     * @return    Value of function at argument
     */
    public abstract double calculate( double x );


    /**
     *  Prints table of function values over specified range<br>
     *  by specified step - can paste into Excel and graph<br>
     *
     * @param  dStart  Starting value of x for table of function values
     * @param  dEnd    Ending value of x for table of function values
     * @param  dStep   Amount to increment x for table of function values
     * @return         Nothing
     * @throws         Starting value of range greater than ending value
     * @throws         Increment not positive
     */
    public void printTable( double dStart, double dEnd, double dStep )
            throws IllegalArgumentException
    {
        if ( dStart > dEnd )
        {
            throw new IllegalArgumentException( "Start must be <= End" );
        }
        if ( dStep <= 0 )
        {
            throw new IllegalArgumentException( "Step must be > 0" );
        }
        System.out.println( " x \t f(x) " );
        System.out.println( "===\t======" );
        for ( double x = dStart; x <= dEnd; x += dStep )
        {
            System.out.println( x + "\t" + this.calculate( x ) );
        }
        System.out.println( );
    }


    /**
     * ...add appropriate comments...
     * 
     * @param left
     * @param right
     * @param precision
     * @param iMaxLoops
     * @return
     */
    public double leftRectangleSimple( double left, double right,
    		double precision, int iMaxLoops )
    {
    	// start with an initial approximation of one rectangle
    	long numRectangles = 1;
    	double totalWidth = right - left;
    	double height = this.calculate(left);
    	double estimate = height * totalWidth;
    	
    	// set up loop
    	int numLoops = 0;
    	boolean keepGoing = true;
    	
    	while (keepGoing)
    	{
    		numLoops++;
    		double oldEstimate = estimate;
    		
    		// Find a better approximation using twice as many rectangles
    		numRectangles *= 2;
    		double currentWidth = totalWidth / numRectangles;
    		estimate = 0;
    		
    		for (long i = 0; i < numRectangles; i++)
    		{
    			// calculate the area of the current rectangle and add it to the total
    			double currentLeft = left + i * currentWidth;
    			double currentHeight = this.calculate(currentLeft);
    			double currentArea = currentHeight * currentWidth;
    			estimate += currentArea;
    		}
    		
    		System.out.println(numLoops + "\t" + numRectangles + "\t" + estimate);
    		
    		// Check if we are "close enough"
    		double error = Math.abs(estimate - oldEstimate);
    		double relError = Math.abs(error / estimate);
    		if (relError <= precision)
    		{
    			keepGoing = false;
    		}
    		else if (numLoops >= iMaxLoops)
    		{
    			System.out.println("Did not converge within " + numLoops + " loops");
    			keepGoing = false;
    		}
    	}
    	
    	return estimate;
    }


    /**
     * ...add appropriate comments...
     * 
     * @param left
     * @param right
     * @param precision
     * @param iMaxLoops
     * @return
     */
    public double leftRectangleEfficient( double left, double right,
    		double precision, int iMaxLoops )
    {
    	// start with an initial approximation of one rectangle
    	long numRectangles = 1;
    	double totalWidth = right - left;
    	double heights = this.calculate(left);
    	double estimate = heights * totalWidth;
    	
    	// set up loop
    	int numLoops = 0;
    	boolean keepGoing = true;
    	
    	while (keepGoing)
    	{
    		numLoops++;
    		double oldEstimate = estimate;
    		
    		// Find a better approximation using twice as many rectangles
    		numRectangles *= 2;
    		double currentWidth = totalWidth / numRectangles;
    		
    		// calculate heights of new rectangles (odd-numbered rectangles) only
    		for (long i = 1; i < numRectangles; i += 2)
    		{
    			heights += this.calculate(left + i * currentWidth);
    		}
    		estimate = heights * currentWidth;
    		
//    		System.out.println(numLoops + "\t" + numRectangles + "\t" + estimate);
    		
    		// Check if we are "close enough"
    		double relError = Math.abs((estimate - oldEstimate) / estimate);
    		if (relError <= precision)
    		{
    			keepGoing = false;
    		}
    		else if (numLoops >= iMaxLoops)
    		{
    			System.out.println("Did not converge within " + numLoops + " loops");
    			keepGoing = false;
    		}
    	}
    	
    	return estimate;
    }
}
