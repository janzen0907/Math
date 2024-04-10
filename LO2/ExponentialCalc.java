
public class ExponentialCalc
{

    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
        double x = -20.0;
        double dPrecision = 0.00000001;
        
        System.out.println(myExponentialFunction(x, dPrecision));
        System.out.println(myImprovedExp(x, dPrecision));
        System.out.println(Math.exp(x));
        
        double dAngleDegrees = -300.0;
        double dAngleRadians = Math.toRadians(dAngleDegrees);
        System.out.println("Sine function examples: ");
        System.out.println(myNaiveSin(dAngleRadians, dPrecision));
        System.out.println(myImprovedSin(dAngleRadians, dPrecision));
        System.out.println(Math.sin(dAngleRadians));

    }
    
   
    
    public static double myImprovedSin(double dAngle, double dPrecision)
    {
        dAngle = dAngle % (2.0 * Math.PI); //covert angle to between 0 and 2*pi radians
        double dResult = dAngle; //first approximation is x^1 / 1! = x
        int k = 0; //term number
        double dTerm = dAngle; //first term is x
        
        do {
            k++; //increase our term
            //new term = -1 * old term * x * x / (2k(2k+1))
            dTerm = -1.0 * dTerm * dAngle * dAngle / ((2.0 * k) * (2.0 * k + 1.0));
            dResult += dTerm;
        } while(Math.abs(dTerm / dResult) > dPrecision);
        //while the term we are adding affects the precision, continue
        
        return dResult; //return last approximation
    }
    
    /**
     * Calculate sine of angle to desired precision
     * Purpose:
     * @param dAngle        angle in radians
     * @param dPrecision    desired precision for result    
     * @return              sine of angle in radians
     */
    public static double myNaiveSin(double dAngle, double dPrecision)
    {
        double dResult = dAngle; // first approximation is x^1 / 1! = x 
        int k = 0; //term #
        double dOldResult;
        
        do {
            dOldResult = dResult;
            k++;
            //add another term
            dResult += Math.pow(-1,  k) * Math.pow(dAngle,  2 * k + 1) / dFact(2 * k + 1);
            
        } while (Math.abs((dResult - dOldResult) / dResult) > dPrecision);
        //"close enough"
        
        return dResult;
    }
    
    
    /**
     * Calculate e^x to desired precision
     * Purpose:
     * @param x
     * @return
     */
    public static double myExponentialFunction (double x, double dPrecision)
    {
        double dResult = 1.0; //initial approx
        double dOldResult = 1.0;
        int iTerm = 0;
        
        do {
            dOldResult = dResult;
            iTerm++;
            //add next term x^k / k! for better approximation
            dResult += Math.pow(x, iTerm) / dFact(iTerm);
            
        } while(Math.abs((dResult - dOldResult) /dResult) > dPrecision);
        //"close enough" using relative error
        
        return dResult;
    }
    
    public static double myImprovedExp(double x, double dPrecision)
    {
        double dResult = 1.0; //inital approximation
        double dTerm = 1.0; //the current term of the series being added
        int k = 0; //the number of the current term
        
        if (x < 0) //for negative x, calculate 1 / e^x to avoid subtractions
        {
            return 1.0 / myImprovedExp(-x, dPrecision);
        }
        
        do {
            k++;
            //new term is just old term *x / iCount
            dTerm = dTerm * x / k;
            dResult += dTerm; //add new term to get better approximation
            
        } while(Math.abs(dTerm / dResult) > dPrecision);
        //use relative error (error is just the last term, divide by result)
        
        return dResult;
        
            
        
        
        
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
