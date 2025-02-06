package armenbadal.ast;

import armenbadal.interpreter.Environment;

import java.util.Set;

/**/
public record Binary(String operation, Expression left, Expression right) implements Expression {
//    @Override
//    public Set<String> freeVariables()
//    {
//        Set<String> vars = subexpro.freeVariables();
//        vars.addAll(subexpri.freeVariables());
//        return vars;
//    }
}
