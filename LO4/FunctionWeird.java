package lo4;

/**
 *  Sample function implementing abstract function class<br>
 *  Implements function f(x) = -1/5 (x + 2)(x - 8)<br>
 *
 * @author     MATH 282
 * @created    August 30, 2017
 */

public class FunctionWeird extends ACFunction
{
    /**
     *  Default constructor for the FunctionWeird object<br>
     */
    public FunctionWeird()
    {
    }


    /**
     *  Returns the value of the function f(x) = -1/5 (x + 2)(x - 8)<br>
     *  for a given x, implementing the abstract method from ACFunction<br>
     *
     * @param  x  Value to evaluate function at
     * @return    Value of function f(x) = -1/5 (x + 2)(x - 8) at argument
     */
    public double calculate( double x )
    {
        return -1.0 / 5.0 * (x + 2.0) * (x - 8.0);
    }
}
