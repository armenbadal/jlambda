package interpreter;

/**/
public class Lambda implements Expression {
    private String parameter = null;
    private Expression body = null;

    public Lambda( String s, Expression e )
    {
        parameter = s;
        body = e;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        return this;
    }

    @Override
    public String toString()
    {
        return String.format("lambda %s . %s", parameter, body.toString());
    }
}
