package interpreter;

import java.util.Set;

/**/
public class Apply implements Expression {
    public Expression function = null;
    public Expression argument = null;

    public Apply(Expression fu, Expression ag )
    {
        function = fu;
        argument = ag;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        Expression oper = function.evaluate(env);
        if( !(oper instanceof Lambda) )
            return null;

        Lambda func = (Lambda)oper;
        Environment capt = new Environment(func.captures);
        Set<String> vars = func.freeVariables();
        for( String vr : vars )
            capt.bind(vr, env.lookup(vr));

        Expression ev0 = argument.evaluate(env);
        capt.bind(func.parameter, ev0);

        return func.body.evaluate(capt);
    }

    @Override
    public Set<String> freeVariables()
    {
        Set<String> vars = function.freeVariables();
        vars.addAll(argument.freeVariables());
        return vars;
    }

    @Override
    public String toString()
    {
        return String.format("apply %s to %s",
                function.toString(),
                argument.toString());
    }
}
