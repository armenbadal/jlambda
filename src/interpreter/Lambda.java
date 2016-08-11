package interpreter;

/**/
public class Lambda implements Expression {
    private Variable parameter = null;
    private Expression body = null;

    public Lambda( Variable s, Expression e )
    {
        parameter = s;
        body = e;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        return this;
    }
}
