package main;

import interpreter.*;

/**
 * Created by abadalian on 8/11/16.
 */
public class Main {
    public static void main( String[] args )
    {
        Expression ex0 = new Constant(3.14);
        Expression ex1 = new Variable("r");
        Expression ex2 = new Binary("*", ex1, ex1);
        Expression ex3 = new Binary("*", ex0, ex2);
        Expression ex4 = new Lambda("r", ex3);
    }
}
