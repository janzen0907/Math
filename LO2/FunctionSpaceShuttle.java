
public class FunctionSpaceShuttle extends ACFunction
{
    public FunctionSpaceShuttle()
    {
        //defautlt constructor
    }

    @Override
    public double calculate( double x )
    {
        // TODO Auto-generated method stub
        return 2.0 / 3.0 * Math.pow(x, x) - 4.0 / 5.0 * Math.sqrt(x) - 6.0 / 7.0;
    }

}
