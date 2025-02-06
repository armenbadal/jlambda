package armenbadal.interpreter;

import java.util.HashMap;
import java.util.Set;

/**/
public class Environment extends HashMap<String, Value> {
    public void bind(String name, Value value) {
        put(name, value);
    }

    public Value lookup(String name) {
        return get(name);
    }

    public Set<String> names() {
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
