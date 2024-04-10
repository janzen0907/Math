
import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalSquareRoot
{

    public static void main( String[] args )
    {
        BigDecimal x = new BigDecimal("50000000000000000000000");
        BigDecimal bdPrecision = new BigDecimal("0.00000000000000000000000001");
        System.out.println(bdSqrt(x, bdPrecision));

    }
    
    //implement the method from the notes, algorithm for finding square roots using the Babylonian method
    
    //Will have to make changes to this to handle negative numbers
    public static BigDecimal bdSqrt(BigDecimal bdValue, BigDecimal bdPrecision)
    
    {
        final BigDecimal BIG_DECIMAL_TWO = new BigDecimal("2");
        BigDecimal bdGuess = BigDecimal.ZERO;
        
        //Negative is less, positve if greater, zero if the same
        if(bdValue.compareTo(BigDecimal.ZERO) <  0)
        {
            throw new ArithmeticException("Cannot find square root of a negative number");
            
        }
        else if (bdValue.compareTo(BigDecimal.ZERO) > 0 )
        {
            MathContext mcPrecisionDigits = new MathContext(bdPrecision.scale()
                    + bdPrecision.precision() + bdValue.precision());
            
            BigDecimal bdLower = BigDecimal.ONE;
            BigDecimal bdUpper = bdValue;
            boolean bKeepGoing = true;
            
            while(bKeepGoing)
            {
                bdGuess = bdLower.add(bdUpper).divide(BIG_DECIMAL_TWO);
                BigDecimal bdTest = bdGuess.multiply(bdGuess);
                
                if(bdTest.compareTo(bdValue) == 0)
                {
                    bKeepGoing = false;
                }
                //Calculate a better guess by finding new upper or lower boundry
                else if(bdTest.compareTo(bdValue) > 0)
                {
                    bdUpper = bdGuess;
                }
                else
                {
                    bdLower = bdGuess;
                }
                //Check if we are "close enough"
                BigDecimal bdError = bdUpper.subtract(bdLower); //amount of error
                bdError = bdError.divide(bdGuess, mcPrecisionDigits); //relative error
                if(bdError.compareTo(bdPrecision) <= 0)
                {
                    bKeepGoing = false;
                }
            }
        }
        return bdGuess;
    }

}
