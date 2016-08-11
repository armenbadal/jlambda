package interpreter;

import java.util.Set;

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

    @Override
    public Set<String> freeVariables()
    {
        return subexpr.freeVariables();
    }

    @Override
    public String toString()
    {
        return String.format("%s(%s)", operation, subexpr.toString());
    }
}
