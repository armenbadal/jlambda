package armenbadal.ast;

public record Unary(String operation, Expression expression) implements Expression {
//    @Override
//    public Set<String> freeVariables() {
//        return expression.freeVariables();
//    }
}
