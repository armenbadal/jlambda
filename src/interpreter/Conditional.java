package interpreter;

import java.util.Set;

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

    @Override
    public Set<String> freeVariables()
    {
        Set<String> vars = condition.freeVariables();
        vars.addAll(decision.freeVariables());
        vars.addAll(alternative.freeVariables());
        return vars;
    }

    @Override
    public String toString()
    {
        return String.format("if %s then %s else %s",
                condition.toString(),
                decision.toString(),
                alternative.toString());
    }
}
