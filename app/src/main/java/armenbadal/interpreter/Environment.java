package armenbadal.interpreter;

import java.util.HashMap;
import java.util.Set;

/**/
public class Environment extends HashMap<String,Expression> {

    public void bind( String nm, Expression vl )
    {
        put(nm, vl);
    }

    public Expression lookup( String nm )
    {
        return get(nm);
    }

    public Set<String> names()
    {
        return keySet();
    }

    @Override
    public String toString()
    {
        String res = "";
        for( String k : keySet() )
            res = res + String.format("[%s->%s]", k, get(k));
        return res;
    }
}
