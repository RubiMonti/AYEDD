/*
Ejercicio 3 Proyecto 2.

Este ejercicio nos pide implementar una nueva clase que represente los números
fraccionarios. En el enunciado viene el API de la clase y todo lo necesario para
hacerlo.

Para ejecutarlo correctamente, aparte del programa definido arriba, haremos
una nueva clase aparte para ejecutar operaciones e imprimirlas en la salida 
del terminal o la salida estandar.
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RationalClient
{
    public static void main(String[] args)
    {
        String arg = new String();
        for (int i = 0; i<args.length; i++)
        {
            arg += args[i] + " ";
        }
        Rational num1 = new Rational(0);
        Rational num2 = new Rational(0);
        Rational toprint;
        String operator = "Error";
        if (arg.startsWith("+") || arg.startsWith("-") || arg.startsWith("x") || arg.startsWith("/"))
        {
            System.err.println("No se recibieron suficientes argumentos");
            System.exit(1);
        }
        arg = num1.parseRational(arg);
        toprint = new Rational(num1.numerator(), num1.denominator());
        if (arg.contains(" "))
        {
            while (arg.contains(" "))
            {
                if (arg.startsWith("+"))
                {
                    operator = " + ";
                    arg = arg.substring(arg.indexOf(" "));
                    arg = num2.parseRational(arg);
                    toprint = toprint.plus(num2);
                }
                else if (arg.startsWith("-"))
                {
                    operator = " - ";
                    arg = arg.substring(arg.indexOf(" "));
                    arg = num2.parseRational(arg);
                    num2.minus();
                    toprint = toprint.plus(num2);
                    if (toprint.denominator() < 0)
                        toprint.reduce();
                    num2.minus();
                }
                else if (arg.startsWith("x"))
                {
                    operator = " x ";
                    arg = arg.substring(arg.indexOf(" "));
                    arg = num2.parseRational(arg);
                    toprint = toprint.times(num2);
                }
                else if (arg.startsWith("/"))
                {
                    operator = " / ";
                    arg = arg.substring(arg.indexOf(" "));
                    arg = num2.parseRational(arg);
                    num2.invert();
                    toprint = toprint.times(num2);
                    num2.invert();
                }
                else
                {
                    System.err.println("Algo ocurrio, revisa el bucle while de recibir argumentos");
                    System.exit(1);
                }
            }
        }
        else
        {
            System.err.println("No se recibieron suficientes argumentos");
            System.exit(1);
        }
        StdOut.println(num1.toString() + operator + num2.toString() + " = " + toprint);
    }
}
