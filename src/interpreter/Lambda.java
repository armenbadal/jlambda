package interpreter;

import java.util.Set;
import java.util.StringJoiner;

/**/
public class Lambda implements Expression {
    public String parameter = null;
    public Expression body = null;
    public Environment captures = null;

    public Lambda( String p, Expression b )
    {
        this(p, b, null);
    }

    public Lambda( String p, Expression b, Environment c )
    {
        parameter = p;
        body = b;
        captures = c;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        Environment cap = new Environment();
        for( String vr : freeVariables() )
            cap.bind(vr, env.lookup(vr));

        if( cap.isEmpty() )
            return this;

        return new Lambda(parameter, body, cap);
    }

    @Override
    public Set<String> freeVariables()
    {
        Set<String> vars = body.freeVariables();
        vars.remove(parameter);
        if( captures != null )
            vars.removeAll(captures.names());
        return vars;
    }

    @Override
    public String toString()
    {
        if( captures == null )
            return String.format("lambda %s . %s",
                    parameter, body);

        return String.format("(lambda %s . %s){%s}",
                parameter,
                body.toString(),
                captures.toString());
    }
}
