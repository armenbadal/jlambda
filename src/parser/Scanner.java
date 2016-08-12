package parser;

import java.util.HashMap;
import java.util.Map;

/**/
public class Scanner {
    private Map<String,Token> keywords = null;
    private Map<String,Token> operations = null;

    private String source = null;
    private int pos = 0;
    private char ch = '\0';

    public String lexeme = null;

    public Scanner( String text )
    {
        keywords = new HashMap<>();
        keywords.put("if", Token.xIf);
        keywords.put("then", Token.xThen);
        keywords.put("else", Token.xElse);
        keywords.put("lambda", Token.xLambda);
        keywords.put("apply", Token.xApplly);
        keywords.put("to", Token.xTo);

        operations = new HashMap<>();
        operations.put(".", Token.xPeriod);
        operations.put("(", Token.xLeftPar);
        operations.put(")", Token.xRightPar);
        operations.put("+", Token.xAdd);
        operations.put("-", Token.xSub);
        operations.put("*", Token.xMul);
        operations.put("/", Token.xDiv);
        operations.put("!", Token.xEos);
//        operations.put("", Token.);
//        operations.put("", Token.);

        source = text + "!";
        ch = source.charAt(0);
        pos = 1;
    }

    public Token nextToken()
    {
        // բացատանիշեր
        while( Character.isWhitespace(ch) )
            ch = source.charAt(pos++);

        // տեքստի ավարտը
        if( pos == source.length() )
            return Token.xEos;

        lexeme = "";

        // ծառայողական բառ կամ իդենտիֆիկատոր
        if( Character.isLetter(ch) )
            return scanKeyword();

        // իրական թիվ
        if( Character.isDigit(ch) )
            return scanNumber();

        // գործողություններ կամ կետադրական նշաններ
        lexeme = String.valueOf(ch);
        Token kind = operations.get(lexeme);
        ch = source.charAt(pos++);

        return kind;
    }

    // ծառայողական բառեր և իդենտիֆիկատորներ
    private Token scanKeyword()
    {
        int begin = pos - 1;
        while( Character.isLetterOrDigit(ch) )
            ch = source.charAt(pos++);
        lexeme = source.substring(begin,pos - 1);
        Token kind = keywords.get(lexeme);
        return kind == null ? Token.xIdentifier : kind;
    }

    // իրական թվեր
    private Token scanNumber()
    {
        int begin = pos - 1;
        while( Character.isDigit(ch) )
            ch = source.charAt(pos++);
        if( ch == '.' ) {
            ch = source.charAt(pos++);
            while (Character.isDigit(ch))
                ch = source.charAt(pos++);
        }
        lexeme = source.substring(begin, pos - 1);
        return Token.xConstant;
    }
}
