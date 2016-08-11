package interpreter;

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
}
