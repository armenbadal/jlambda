package interpreter;

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
        boolean isFunc = function instanceof Lambda;
        if( !isFunc ) return null;

        Expression ev0 = argument.evaluate(env);

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("apply %s to %s",
                function.toString(),
                argument.toString());
    }
}
