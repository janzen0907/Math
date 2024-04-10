package lo4;

/**
 *  Sample function implementing abstract function class<br>
 *  Implements function f(x) = 1/4 x<br>
 *
 * @author     MATH 282
 * @created    August 30, 2017
 */

public class FunctionSpeed extends ACFunction
{
    /**
     *  Default constructor for the FunctionSpeed object<br>
     */
    public FunctionSpeed()
    {
    }


    /**
     *  Returns the value of the function f(x) = 1/4 x<br>
     *  for a given x, implementing the abstract method from ACFunction<br>
     *
     * @param  x  Value to evaluate function at
     * @return    Value of function f(x) = 1/4 x at argument
     */
    public double calculate( double x )
    {
        return 0.25 * x;
    }
}
