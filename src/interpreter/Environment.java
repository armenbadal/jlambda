package interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**/
public class Environment {
    private Map<String,Expression> bindings = null;

    public Environment()
    {
        bindings = new HashMap<>();
    }

    public Environment( Environment env )
    {
        bindings = new HashMap<>();
        bindings.putAll(env.bindings);
    }

    public void bind( String nm, Expression vl )
    {
        bindings.put( nm, vl );
    }

    public Expression lookup( String nm )
    {
        return bindings.get(nm);
    }

    public Set<String> names()
    {
        return bindings.keySet();
    }

    @Override
    public String toString()
    {
        String res = "";
        for( String k : bindings.keySet() )
            res = res + String.format("[%s->%s]", k, bindings.get(k));
        return res;
    }
}
