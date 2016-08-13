# Լամբդա լեզվի իրականացում

__jlambda__։ _ինքնուրույն աշխատանքի նախատիպ 
«Ծրագրավորման լեզուների իրականացում» դասընթացի համար։_

Պահանջվում է իրականացնել պարզագույն _լամբդա_ լեզու, և դրանով 
իրականացնել մի քանի ալգորիթմներ։ 

Շարահյուսությունը.
````
Expr = PrimaryExpr { Oper PrimaryExpr }.
PrimaryExpr = Constant
     | Ident
     | '(' Expr ')'
     | Oper Expr
     | 'if' Expr 'then' Expr 'else' Expr
     | 'lambda' Ident '.' Expr
     | 'apply' Expr 'to' Expr
     | '#' Ident '.' Expr
     | '{' Expr '?' Expr ':' Expr '}'
     | '[' Expr '|' Expr ']'.
````

1. Լեզվի նկարագրությունը։ 
2. Վերլուծիչի նկարագրությունը։
3. Y-combinator. https://www.dreamsongs.com/Files/WhyOfY.pdf։

----

Ավելացնել `let`-ը. 
````
'let' Ident '=' Expression 'in' Expression
````

