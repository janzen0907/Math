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
        IFunction f1 = new Function1();  // instantiate specific function
        System.out.println( "Table of function 1, " + f1.toString() );
        f1.printTable( -1.0, 2.0, 0.5 );  // test function by printing values
        System.out.println("Zero of function 1 is : " + f1.findZero(0.0, -1.0, 0.0001));

        IFunction f2 = new Function2();
        System.out.println( "Table of function 2, " + f2.toString() );
        f2.printTable( -2.0, 3.0, 1.0 );
        f2.printTable( -2.5, 3.5, 0.5 );
        System.out.println("First zero of f2 is: " + f2.findZero(-1.0, 0.0, 0.0001));
        System.out.println("Second zero of f2 is: " + f2.findZero(3.0, 2.0, 0.0001));
        
        IFunction f3 = new FunctionSpaceShuttle();
        f3.printTable(0.0, 4.5, 0.5);
        System.out.println("Zero of function is: " + f3.findZero(2.0, 1.5, 0.00001));
        
        IFunction f4 = new Function4();
        System.out.println( "Table of function , " + f4.toString() );
        f4.printTable( -10.0, 10.0, 1.0 );  
        System.out.println("Zero of function 4 is : " + f4.findZero(-1.0, 0.0, 0.0001));
    } 
}
