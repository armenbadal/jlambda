package armenbadal.ast;

public record Conditional(Expression condition, Expression decision, Expression alternative) implements Expression {
//    @Override
//    public Set<String> freeVariables()
//    {
//        Set<String> vars = condition.freeVariables();
//        vars.addAll(decision.freeVariables());
//        vars.addAll(alternative.freeVariables());
//        return vars;
//    }
}
