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
    /*
    private static Rational[] get_num (String arg)
    {
        //Hay que cambiar toda esta función por parseRational
        Rational[] toreturn = new Rational[2];
        char[] numbers = arg.toCharArray();
        if (arg.length() == 5)
        {
            Rational num1 = new Rational(numbers[0] - '0', numbers[1] - '0');
            Rational num2 = new Rational(numbers[3] - '0', numbers[4] - '0');
            toreturn[0] = num1;
            toreturn[1] = num2;
            return(toreturn);
        }
        else if (arg.length() == 4)
        {
            if (!(numbers[1] < '0' || numbers[1] > '9'))
            {
                Rational num1 = new Rational(numbers[0] - '0', numbers[1] - '0');
                Rational num2 = new Rational(numbers[3] - '0');
                toreturn[0] = num1;
                toreturn[1] = num2;
                return(toreturn);
            }
            else if (!(numbers[2] < '0' || numbers[2] > '9'))
            {
                Rational num1 = new Rational(numbers[0] - '0');
                Rational num2 = new Rational(numbers[2] - '0', numbers[3] - '0');
                toreturn[0] = num1;
                toreturn[1] = num2;
                return(toreturn);
            }
            else
            {
                System.err.println("Error: Los números proporcionados no son Rational");
                System.exit(1);
            }
        }
        else
        {
            System.err.println("Error: Los números proporcionados no son Rational");
            System.exit(1);
        }
        return toreturn;
    }
    */
    public static void main(String[] args)
    {
        String arg = new String();
        for (int i = 0; i<args.length; i++)
        {
            arg += args[i];
        }
        Rational num1 = new Rational(0);
        arg = num1.parseRational(arg);
        Rational toreturn;
        while (/* No se que poner aqui para que pare */)
        {
            if (arg.startsWith("x") || arg.startsWith("") || arg.startsWith("x") || arg.startsWith("x"))
            {
                arg.split(" ");
                Rational num2 = new Rational(0);
                arg = num2.parseRational(arg);
            }
        }
        /*
        if (arg.contains("+"))
        {
            toreturn = toreturn.plus(num1);
            StdOut.println(num1.toString() + " + " + num2.toString() + " = " + toreturn.toString());
        }
        if (arg.contains("-"))
        {
            toreturn = toreturn.minus();
            toreturn = toreturn.plus(num1);
            StdOut.println(num1.toString() + " - " + num2.toString() + " = " + toreturn.toString());
        }
        if (arg.contains("x"))
        {
            toreturn = toreturn.times(num1);
            StdOut.println(num1.toString() + " x " + num2.toString() + " = " + toreturn.toString());
        }
        if (arg.contains("/"))
        {
            toreturn = toreturn.invert();
            toreturn = toreturn.times(num1);
            StdOut.println(num1.toString() + " / " + num2.toString() + " = " + toreturn.toString());
        }
        */
    }
}
