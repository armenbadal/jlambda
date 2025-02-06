package armenbadal.interpreter;

import armenbadal.ast.*;

import java.util.Set;

public class Interpreter {
    private Environment environment = new Environment();

    private Value evaluate(Expression expression) {
        return null;
    }

    private Value evaluate(Constant constant) {
        return new Value(constant.value());
    }

    private Value evaluate(Variable variable) {
        return environment.lookup(variable.name());
    }

    private Value evaluate(Unary unary) {
        var result = evaluate(unary.expression());
        if(unary.operation() == "-")
            result = new Value(-result.value());

        return result;
    }

    private Value evaluate(Binary binary) {
        var left = evaluate(binary.left());
        var right = evaluate(binary.right());

        return switch(binary.operation()) {
            case "+" -> new Value(left.value() + right.value());
            case "-" -> new Value(left.value() - right.value());
            case "*" -> new Value(left.value() * right.value());
            case "/" -> new Value(left.value() / right.value());
            default -> null;
        };
    }

    private Value evaluate(Conditional conditional) {
        var condition = evaluate(conditional.condition());
        if(condition.value() == 0.0)
            return evaluate(conditional.decision());
        else
            return evaluate(conditional.alternative());
    }

    private Value evaluate(Lambda lambda) {
//        Environment cap = new Environment();
//        for( String vr : freeVariables() )
//            cap.bind(vr, env.lookup(vr));
//
//        if( cap.isEmpty() )
//            return this;
//
//        return new Lambda(parameter, body, cap);
        return null;
    }

    private Value evaluate(Apply apply) {
//        Expression oper = function.evaluate(env);
//        if( !(oper instanceof Lambda) )
//            return null;
//
//        Lambda func = (Lambda)oper;
//        Environment capt = new Environment();
//        if( func.captures != null )
//            capt.putAll(func.captures);
//        Set<String> vars = func.freeVariables();
//        for( String vr : vars )
//            capt.bind(vr, env.lookup(vr));
//
//        Expression ev0 = argument.evaluate(env);
//        capt.bind(func.parameter, ev0);
//
//        return func.body.evaluate(capt);
        return null;
    }
}
