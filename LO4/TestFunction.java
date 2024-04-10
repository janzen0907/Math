package lo4;

/**
 *  Class with main method for testing functions implementing ACFunction<br>
 *
 * @author     MATH 282
 * @created    August 30, 2017
 */

public class TestFunction
{
    /**
     *  The main program for the TestFunction class<br>
     *
     * @param  args  the command line arguments
     */
    public static void main(String[] args)
    {
        IFunction f1 = new FunctionSpeed();  // instantiate specific function
        System.out.println( "Table of function 1, f(x) = 1/4 x" );
        f1.printTable( 0.0, 8.0, 1.0 );  // test function by printing values
        System.out.println(f1.leftRectangleSimple(0.0, 8.0, 0.000001, 35));
        //System.out.println(f1.leftRectangleEfficient(0.0, 8.0, 0.000001, 35));
        System.out.println(f1.leftRectangleSimple(6.0, 8.0, 0.000001, 30));
        //System.out.println(f1.leftRectangleEfficient(6.0, 8.0, 0.000001, 30));
        System.out.println();
        
        IFunction f2 = new FunctionExample();
        System.out.println( "Table of function 2, f(x) = 1/3 x^2 - 1/300 x^4" );
        f2.printTable( 0.0, 10.0, 1.0 );
        System.out.println(f2.leftRectangleSimple(3.0, 9.0, 0.000001, 30));
        //System.out.println(f2.leftRectangleEfficient(3.0, 9.0, 0.000001, 30));
        System.out.println(f2.leftRectangleSimple(0.0, 10.0, 0.000001, 30));
        //System.out.println(f2.leftRectangleEfficient(0.0, 10.0, 0.00000, 35));
        
        IFunction f3 = new FunctionWeird();
        System.out.println( "Table of function 3, f(x) = -1/5 (x + 2)(x - 8)" );
        f3.printTable(0.0, 8.0, 1.0);
        System.out.println(f3.leftRectangleSimple(0.0, 8.0, 0.000001, 30));
        //System.out.println(f3.leftRectangleEfficient(0.0, 8.0, 0.000001, 30));
    }
}
