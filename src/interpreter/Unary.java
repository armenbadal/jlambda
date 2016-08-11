package interpreter;

/**/
public class Unary implements Expression {
    private String operation = null;
    private Expression subexpr = null;

    public Unary( String op, Expression ex )
    {
        operation = op;
        subexpr = ex;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        Expression res = subexpr.evaluate(env);

        if( res instanceof Constant ) {
            double val = ((Constant)res).value;
            if( operation == "-" )
                res = new Constant(-val);
        }

        return res;
    }
}
