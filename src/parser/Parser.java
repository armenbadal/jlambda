package parser;

import interpreter.Expression;

/**
 * Grammar:
 *
 * Expr = Constant
 *      | Ident
 *      | '(' Expr ')'
 *      | Oper Expr
 *      | Expr Oper Expr
 *      | 'if' Expr 'then' Expr 'else' Expr
 *      | '{' Expr '?' Expr ':' Expr '}'
 *      | 'lambda' Ident '.' Expr
 *      | '#' Ident '.' Expr
 *      | 'apply' Expr 'to' Expr
 *      | '[' Expr '|' Expr ']'.
 */

/**/
public class Parser {
    private String source = null;
    private int pos = 0;

    private static final int xConst = 260;
    private static final int xIdent = 261;
    private static final int xAdd = 262;
    private static final int xSub = 263;
    private static final int xMul = 264;
    private static final int xDiv = 265;
    private static final int xIf = 266;
    private static final int xThen = 267;
    private static final int xElse = 268;
    private static final int xLambda = 269;
    private static final int xApplly = 270;

    public Parser( String text )
    {
        source = text;
    }

    public Expression parse()
    {
        return null;
    }

    private int scan()
    {
        char ch = source.charAt(pos++);

        while( Character.isWhitespace(ch) )
            ch = source.charAt(pos++);

        if( Character.isLetter(ch) ) {
            while( Character.isLetterOrDigit(ch) ) {
                ch = source.charAt(pos++);
            }
            return xIdent;
        }

        if( Character.isDigit(ch) ) {
            while( Character.isDigit(ch) ) {
                ch = source.charAt(pos++);
            }
            return xConst;
        }

        return 0;
    }
}
