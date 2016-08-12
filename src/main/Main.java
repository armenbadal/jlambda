package main;

import interpreter.*;
import parser.Parser;
import parser.Scanner;
import parser.Token;

/**/
public class Main {

    private static Environment global = new Environment();

    private static void test_a()
    {


        Expression ex0 = new Constant(3.14);
        Expression ex1 = new Variable("r");
        Expression ex2 = new Binary("*", ex1, ex1);
        Expression ex3 = new Binary("*", ex0, ex2);
        Expression ex4 = new Lambda("r", ex3);

        Expression res = ex4.evaluate(global);
        System.out.println(res);

//        Expression ex5 = new Constant(2);
//
//        Expression ex6 = new Apply(ex4, ex5);
//
//        System.out.println(ex6);
//        // System.out.println(ex6.freeVariables());
//        Expression res = ex6.evaluate(global);
//        System.out.println(res);
    }

    private static void test_b()
    {
        Expression ex0 = new Variable("x");
        Expression ex1 = new Variable("y");
        Expression ex2 = new Binary("+", ex0, ex1);
        Expression ex3 = new Lambda("y", ex2);
        Expression ex4 = new Lambda("x", ex3);
        Expression ex5 = new Constant(2);
        Expression ex6 = new Apply(ex4, ex5);
        Expression ex7 = new Constant(4);
        Expression ex8 = new Apply(ex6, ex7);
        System.out.println(ex8);

        Expression res = ex8.evaluate(global);
        System.out.println(res);
    }

    private static void test_c()
    {
        Expression ex0 = new Variable("x");
        Expression ex1 = new Variable("y");
        Expression ex2 = new Binary("+", ex0, ex1);
        Expression ex3 = new Lambda("y", ex2);

        Environment local = new Environment();
        local.bind("x", new Constant(7));

//        Expression res0 = ex3.evaluate(local);
//        System.out.println(res0);

        Expression c0 = new Constant(2);
        Expression ex4 = new Apply(ex3, c0);
        Expression res1 = ex4.evaluate(local);
        System.out.println(res1);
    }

    private static void test_d()
    {
        Scanner sc = new Scanner("apply lambda r . 2 * 3.14 * r to 1");
        Token look = sc.nextToken();
        while( look != Token.xEos ) {
            System.out.printf("%s -> %s\n", look.toString(), sc.lexeme);
            look = sc.nextToken();
        }
    }

    private static void test_e()
    {
        Parser parser = new Parser("(b * b) - ((4 * a) * c)");
        Expression ex0 = parser.parse();
        System.out.println(ex0);

        parser = new Parser("apply lambda r . 2 * 3.14 * r to 7");
        ex0 = parser.parse();
        System.out.println(ex0);
    }

    public static void main( String[] args )
    {
        //test_a();
        //test_b();
        //test_c();

        //test_d();

        test_e();
    }
}
