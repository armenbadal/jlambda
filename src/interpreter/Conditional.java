package interpreter;

/**/
public class Conditional implements Expression {
    public Expression condition = null;
    public Expression decision = null;
    public Expression alternative = null;

    public Conditional( Expression co, Expression de, Expression al )
    {
        condition = co;
        decision = de;
        alternative = al;
    }

    @Override
    public Expression evaluate( Environment env )
    {
        Expression cov = condition.evaluate(env);
        if( cov instanceof Constant ) {
            double reco = ((Constant)cov).value;
            if( reco != 0 )
                return decision.evaluate(env);
            return alternative.evaluate(env);
        }
        return null;
    }
}
