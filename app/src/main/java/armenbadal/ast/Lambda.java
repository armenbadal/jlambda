package armenbadal.ast;

public record Lambda(String parameter, Expression body) implements Expression {
    //public Environment captures = null;

//    @Override
//    public Set<String> freeVariables()
//    {
//        Set<String> vars = body.freeVariables();
//        vars.remove(parameter);
//        if( captures != null )
//            vars.removeAll(captures.names());
//        return vars;
//    }
}
