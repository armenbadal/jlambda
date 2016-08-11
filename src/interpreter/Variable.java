package interpreter;

import java.util.Set;
import java.util.TreeSet;

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
    public Set<String> freeVariables()
    {
        Set<String> vars = new TreeSet<>();
        vars.add(name);
        return vars;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
