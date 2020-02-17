/*
Problema 1 del Proyecto 3.

Este programa nos ayuda a recibir una expresión matemática que contenga números racionales
y a dar una solución de dicho tipo. Para ello usaremos el TAD del proyecto anterior: "Rational"
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ParseRationalExpressions
{
    public static void main(String args[])
    {
        Rational[] operands = new Rational[1];
        String[] operators = new String[0];
        Rational r = new Rational(5);
        operands[0] = r;
        RationalExpression aux = new RationalExpression(operands, operators);
        while (StdIn.hasNextLine())
        {
            String line = StdIn.readLine();
            StdOut.println(aux.parseRationalExpressions(line));
        }
    }
}
