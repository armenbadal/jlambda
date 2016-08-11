package interpreter;

import java.util.Set;

/**/
public class Binary implements Expression {
    private String operation = null;
    private Expression subexpro = null;
    private Expression subexpri = null;

    public Binary( String op, Expression eo, Expression ei )
    {
        operation = op;
        subexpro = eo;
        subexpri = ei;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        Expression reo = subexpro.evaluate(env);
        Expression rei = subexpri.evaluate(env);

        if( (reo instanceof Constant) && (rei instanceof Constant) ) {
            double valo = ((Constant)reo).value;
            double vali = ((Constant)rei).value;
            if( operation == "+" )
                return new Constant(valo + vali);
            if( operation == "-" )
                return new Constant(valo - vali);
            if( operation == "*" )
                return new Constant(valo * vali);
            if( operation == "/" )
                return new Constant(valo / vali);
        }

        return null;
    }

    @Override
    public Set<String> freeVariables()
    {
        Set<String> vars = subexpro.freeVariables();
        vars.addAll(subexpri.freeVariables());
        return vars;
    }

    @Override
    public String toString()
    {
        return String.format("(%s %s %s)", subexpro.toString(),
                operation, subexpri.toString());
    }
}
