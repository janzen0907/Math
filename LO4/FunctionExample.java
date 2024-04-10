package lo4;

/**
 *  Sample function implementing abstract function class<br>
 *  Implements function f(x) = 1/3 x^2 - 1/300 x^4<br>
 *
 * @author     MATH 282
 * @created    August 30, 2017
 */

public class FunctionExample extends ACFunction
{
    /**
     *  Default constructor for the FunctionExample object<br>
     */
    public FunctionExample()
    {
    }


    /**
     *  Returns the value of the function f(x) = 1/3 x^2 - 1/300 x^4<br>
     *  for a given x, implementing the abstract method from ACFunction<br>
     *
     * @param  x  Value to evaluate function at
     * @return    Value of function f(x) = 1/3 x^2 - 1/300 x^4 at argument
     */
    public double calculate( double x )
    {
        return 1.0 / 3.0 * Math.pow(x, 2.0) - 1.0 / 300.0 * Math.pow(x, 4.0);
    }
}
