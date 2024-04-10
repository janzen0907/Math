/**
 *  Sample function implementing abstract function class<br>
 *  Implements function f(x) = 3x^2 - x - 2
 *
 * @author     MATH 282
 * @created    August 30, 2017
 */

public class Function4 extends ACFunction
{
    /**
     *  Default constructor for the Function2 object<br>
     */
    public Function4()
    {
    }


    /**
     *  Returns the value of the function f(x) = 3x^2 - x - 2
     *  for a given x, implementing the abstract method from ACFunction<br>
     *
     * @param  x  Value to evaluate function at
     * @return    Value of function f(x) = 3x^2 - x - 2 at argument
     */
    public double calculate( double x )
    {
        return 3.0 * Math.pow(x,  2.0) - x - 2.0;
       
    }
    
    public String toString()
    {
        return "f(x) = 3x^2 - x - 2";
    }
}
