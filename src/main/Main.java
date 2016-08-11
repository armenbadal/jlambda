package main;

import interpreter.*;

/**/
public class Main {
    public static void main( String[] args )
    {
        Expression ex0 = new Constant(3.14);
        Expression ex1 = new Variable("r");
        Expression ex2 = new Binary("*", ex1, ex1);
        Expression ex3 = new Binary("*", ex0, ex2);
        Expression ex4 = new Lambda("r", ex3);

        Expression ex5 = new Constant(1);

        Expression ex6 = new Apply(ex4, ex5);

        System.out.println(ex6.toString());
        // System.out.println(ex6.freeVariables());
    }
}
