package interpreter;

import java.util.Set;

/**/
public interface Expression {
    Expression evaluate( Environment env );
}
