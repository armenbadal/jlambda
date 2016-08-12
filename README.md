# jlambda

Լամբդա լեզվի իրականացում։

````
Expr = Constant
     | Ident
     | '(' Expr ')'
     | Oper Expr
     | Expr Oper Expr
     | 'if' Expr 'then' Expr 'else' Expr
     | 'lambda' Ident '.' Expr
     | 'apply' Expr 'to' Expr
     | '#' Ident '.' Expr
     | '{' Expr '?' Expr ':' Expr '}'
     | '[' Expr '|' Expr ']'.
````
