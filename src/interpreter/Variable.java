package interpreter;

/**/
public class Variable implements Expression {
    private String name = null;

    public Variable( String nm )
    {
        name = nm;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        return env.lookup(name);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
