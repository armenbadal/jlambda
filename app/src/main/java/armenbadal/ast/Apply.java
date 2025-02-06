package armenbadal.ast;

public record Apply(Expression function, Expression argument) implements Expression {
//    @Override
//    public Set<String> freeVariables()
//    {
//        Set<String> vars = function.freeVariables();
//        vars.addAll(argument.freeVariables());
//        return vars;
//    }
}
