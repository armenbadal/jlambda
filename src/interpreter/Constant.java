package interpreter;

import java.util.Set;
import java.util.TreeSet;

/**/
public class Constant implements Expression {
    public double value = 0.0;

    public Constant( double vl )
    {
        value = vl;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        return this;
    }

    @Override
    public Set<String> freeVariables()
    {
        return new TreeSet<>();
    }

    @Override
    public String toString()
    {
        return Double.toString(value);
    }
}
