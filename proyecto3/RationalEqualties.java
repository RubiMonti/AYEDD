/*
Problema 2 del Proyecto 3.

Este programa recibe una expresión matemática que contenga números racionales
seguida de una comparacion ya sea a un número racional como a otra expresión racional.
El programa tiene que asimilar la ecuacion y decir si la sentencia es verdadera o falsa.
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RationalEqualties
{
    public static void main (String[] args)
    {
        Rational[] operands = new Rational[1];
        String[] operators = new String[0];
        Rational r = new Rational(5);
        String[] expressions = new String[2];
        operands[0] = r;
        RationalExpression exp1 = new RationalExpression(operands,operators);
        RationalExpression exp2 = new RationalExpression(operands,operators);
        String equals;
        while (StdIn.hasNextLine())
        {
            equals = " != ";
            String line = StdIn.readLine();
            expressions = line.split("==");
            exp1.parseRationalExpressions(expressions[0]);
            exp2.parseRationalExpressions(expressions[1]);
            if (exp1.getResult().equals(exp2.getResult()))
                equals = " == ";
            StdOut.println(exp1.toString() + equals + exp2.toString());
        }
    }
}