package interpreter;

import java.util.HashMap;
import java.util.Map;

/**/
public class Environment {
    private Map<String,Expression> bindings = null;

    public Environment()
    {
        bindings = new HashMap<>();
    }

    public void bind( String nm, Expression vl )
    {
        bindings.put( nm, vl );
    }

    public Expression lookup( String nm )
    {
        return bindings.get(nm);
    }
}
