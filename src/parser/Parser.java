package parser;

import interpreter.*;

/**/
public class Parser {
    private Scanner scanner = null;

    private Token lookahead = null;

    public Parser( String text )
    {
        scanner = new Scanner(text);
        lookahead = scanner.nextToken();
    }

    public Expression parse()
    {
        return parseExpression();
    }

    private Expression parseExpression()
    {
        Expression result = parsePrimary();
        while( lookahead == Token.xAdd ||
                lookahead == Token.xSub ||
                lookahead == Token.xMul ||
                lookahead == Token.xDiv ) {
            String oper = scanner.lexeme;
            lookahead = scanner.nextToken();
            Expression ex0 = parsePrimary();
            result = new Binary(oper, result, ex0);
        }
        return result;
    }

    private Expression parsePrimary()
    {
        if( lookahead == Token.xConstant ) {
            double value = Double.valueOf(scanner.lexeme);
            match(Token.xConstant);
            return new Constant(value);
        }

        if( lookahead == Token.xIdentifier ) {
            String var = scanner.lexeme;
            match(Token.xIdentifier);
            return new Variable(var);
        }

        if( lookahead == Token.xSub ) {
            match(Token.xSub);
            Expression ex0 = parsePrimary();
            return new Unary("-", ex0);
        }

        if( lookahead == Token.xLeftPar ) {
            match(Token.xLeftPar);
            Expression ex0 = parseExpression();
            match(Token.xRightPar);
            return ex0;
        }

        if( lookahead == Token.xIf ) {
            match(Token.xIf);
            Expression co = parseExpression();
            match(Token.xThen);
            Expression de = parseExpression();
            match(Token.xElse);
            Expression al = parseExpression();
            return new Conditional(co, de, al);
        }

        if( lookahead == Token.xLambda ) {
            match(Token.xLambda);
            String par = scanner.lexeme;
            match(Token.xIdentifier);
            match(Token.xPeriod);
            Expression bo = parseExpression();
            return new Lambda(par, bo);
        }

        if( lookahead == Token.xApplly ) {
            match(Token.xApplly);
            Expression fu = parseExpression();
            match(Token.xTo);
            Expression ar = parseExpression();
            return new Apply(fu, ar);
        }

        return null;
    }

    private void match( Token k )
    {
        if( lookahead == k )
            lookahead = scanner.nextToken();
    }
}
