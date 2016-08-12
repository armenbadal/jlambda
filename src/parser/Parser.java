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
        Expression result = null;
        if( lookahead == Token.xConstant ) {
            double value = Double.valueOf(scanner.lexeme);
            match(Token.xConstant);
            result = new Constant(value);
        }
        else if( lookahead == Token.xIdentifier ) {
            result = new Variable(scanner.lexeme);
            match(Token.xIdentifier);
        }
        else if( lookahead == Token.xSub ) {
            match(Token.xSub);
            Expression ex0 = parseExpression();
            result = new Unary("-", ex0);
        }
        else if( lookahead == Token.xLeftPar ) {
            match(Token.xLeftPar);
            result = parseExpression();
            match(Token.xRightPar);
        }
        else if( lookahead == Token.xIf ) {
            match(Token.xIf);
            Expression co = parseExpression();
            match(Token.xThen);
            Expression de = parseExpression();
            match(Token.xElse);
            Expression al = parseExpression();
            result = new Conditional(co, de, al);
        }
        else if( lookahead == Token.xLambda ) {
            match(Token.xLambda);
            String par = scanner.lexeme;
            match(Token.xIdentifier);
            match(Token.xPeriod);
            Expression bo = parseExpression();
            result = new Lambda(par, bo);
        }
        else if( lookahead == Token.xApplly ) {
            match(Token.xApplly);
            Expression fu = parseExpression();
            match(Token.xTo);
            Expression ar = parseExpression();
            result = new Apply(fu, ar);
        }

        if( lookahead == Token.xAdd ||
            lookahead == Token.xSub ||
            lookahead == Token.xMul ||
            lookahead == Token.xDiv ) {
            String oper = scanner.lexeme;
            lookahead = scanner.nextToken();
            Expression ex0 = parseExpression();
            result = new Binary(oper, result, ex0);
        }

        return result;
    }

    private void match( Token k )
    {
        if( lookahead == k )
            lookahead = scanner.nextToken();
    }
}
