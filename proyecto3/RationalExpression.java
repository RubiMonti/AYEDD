/*
Problema 1 del Proyecto 3

Este programa nos ayuda a recibir una expresión matemática que contenga números racionales
y a dar una solución de dicho tipo. Para ello usaremos el TAD del proyecto anterior: "Rational"
*/

import java.lang.annotation.Retention;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Arrays;
import java.util.TooManyListenersException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RationalExpression
{
    private Rational[] operands;
    private String[] operators;
    
    public RationalExpression(Rational[] operan, String[] operat)
    {
        if (!(operan.length == operat.length + 1))
        {
            System.err.println("Error: Los datos introducidos no son un RationalExpression");
            System.exit(1);
        }
        operands = new Rational[operan.length];
        operators = new String[operat.length];
        operands[0] = operan[0];
        for (int i = 0; i < operat.length; i++)
        {
            operators[i] = operat[i];
            operands[i + 1] = operan[i + 1];
        }
    }

    public String toString()
    {
        String toreturn =  operands[0].toString();
        for (int i = 0; i < operators.length; i++)
            toreturn += operators[i] + operands[i + 1];
        return (toreturn);
    }

    public boolean equals(Object b)
    {
        if (this.getClass() != b.getClass()) 
            return false;
        else
        {
            RationalExpression that;
            that = (RationalExpression) b;
            if (!(Arrays.toString(this.operands).equals(Arrays.toString(that.operands))))
                return false;
            else if (!(Arrays.toString(this.operators).equals(Arrays.toString(that.operators))))
                return false;
            else
                return (true);
        }
    }

    public Rational getResult()
    {
        if (operators.length == 0)
            return(operands[0]);
        // Vamos a crear copias de operands y operator para no cambiarlas durante el proceso.
        Rational[] c_operands = new Rational[operands.length];
        for (int i = 0; i < operands.length ; i++)
            c_operands[i] = operands[i];
        String[] c_operators = new String[operators.length];
        for (int i = 0; i < operators.length ; i++)
            c_operators[i] = operators[i];
        Boolean found = false;
        Boolean found2 = false;

        while (c_operators.length > 0)
        {
            Rational[] auxR = new Rational[c_operands.length - 1];
            String[] auxS = new String[c_operators.length - 1];
            // Ir recorriendo el array de operadoires comparande
            for (int i = 0; i < c_operators.length; i++)
            {
                if (!found)
                {
                    if (c_operators[i].equals(" x "))
                    {
                        auxR[i] = c_operands[i].times(c_operands[i + 1]);
                        found = true;
                    }
                    else if (c_operators[i].equals(" / "))
                    {
                        c_operands[i + 1] = c_operands[i + 1].invert();
                        auxR[i] = c_operands[i].times(c_operands[i + 1]);
                        found = true;
                    }
                    else
                    {
                        if (i == auxS.length)
                            break;
                        else 
                        {
                            auxR[i] = c_operands[i];
                            auxS[i] = c_operators[i];    
                        }
                    }
                }
                else
                {
                    auxR[i] = c_operands[i + 1];
                    auxS[i - 1] = c_operators[i];   
                }
            }
            for (int i = 0; i < c_operators.length; i++)
            {
                if (!found)
                {
                    if (!found2)
                    {
                        if (c_operators[i].equals(" + "))
                        {
                            auxR[i] = c_operands[i].plus(c_operands[i + 1]);
                            found2 = true;
                        }
                        else if (c_operators[i].equals(" - "))
                        {
                            c_operands[i + 1] = c_operands[i + 1].minus();
                            auxR[i] = c_operands[i].plus(c_operands[i + 1]);
                            found2 = true;
                        }
                        else
                        {
                            auxR[i] = c_operands[i];
                            auxS[i] = c_operators[i];    
                        }
                    }
                    else
                    {
                        auxR[i] = c_operands[i + 1];
                        auxS[i - 1] = c_operators[i];
                    }
                }
            }
            c_operands = new Rational[c_operands.length - 1];
            for (int i = 0; i < c_operands.length ; i++)
                c_operands[i] = auxR[i];
            c_operators = new String[c_operators.length - 1];
            for (int i = 0; i < c_operators.length ; i++)
                c_operators[i] = auxS[i];
            found = false;
            found2 = false;
        }
        return (c_operands[0]);
    }

    public String parseRationalExpressions(String s)
    {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == 'x' || s.charAt(i) == '/')
                count ++;
            else if(s.charAt(i) == '-')
            {
                if (s.charAt(i + 1) == ' ')
                    count++;
            }
        }
        int i = 0;
        operands = new Rational[count + 1];
        operators = new String[count];
        Rational aux = new Rational(0);
        s = aux.parseRational(s);
        operands[0] = new Rational(aux.numerator(), aux.denominator());
        if (s.contains(" "))
        {
            while (s.contains(" "))
            {
                if (s.startsWith("+"))
                {
                    operators[i] = " + ";
                    s = s.substring(s.indexOf(" "));
                    s = aux.parseRational(s);
                    operands[i + 1] = new Rational(aux.numerator(), aux.denominator());
                }
                else if (s.startsWith("-"))
                {
                    operators[i] = " - ";
                    s = s.substring(s.indexOf(" "));
                    s = aux.parseRational(s);
                    operands[i + 1] = new Rational(aux.numerator(), aux.denominator());
                }
                else if (s.startsWith("x"))
                {
                    operators[i] = " x ";
                    s = s.substring(s.indexOf(" "));
                    s = aux.parseRational(s);
                    operands[i + 1] = new Rational(aux.numerator(), aux.denominator());
                }
                else if (s.startsWith("/"))
                {
                    operators[i] = " / ";
                    s = s.substring(s.indexOf(" "));
                    s = aux.parseRational(s);
                    operands[i + 1] = new Rational(aux.numerator(), aux.denominator());
                }
                else
                {
                    System.err.println("Algo ocurrio, revisa el bucle while de recibir argumentos");
                    System.exit(1);
                }
                i++;
            }
            s = s.trim();
            if (!(s.equals("Error")))
            {
                System.err.println("Error: Los numeros racionales introducidos no son correctos.");
                System.exit(1);
            }
        }
        return (this.toString());
    }

    public static void main(String[] args)
    {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(6, 4);
        Rational c = new Rational(11, 6);
        Rational d = new Rational(-9, 5);
        Rational e = new Rational(1);
        Rational f = new Rational(-1, 2);
        Rational g = new Rational(1, 2);
        Rational h = new Rational(10, 2);
        Rational i = new Rational(3, 2);
        Rational j = new Rational(1, 6);
        String sum = " + ";
        String sub = " - ";
        String tim = " x ";
        String div = " / ";

        Rational[] exp1s = new Rational[10];
        exp1s[0] = a;
        exp1s[1] = b;
        exp1s[2] = c;
        exp1s[3] = d;
        exp1s[4] = e;
        exp1s[5] = f;
        exp1s[6] = g;
        exp1s[7] = h;
        exp1s[8] = i;
        exp1s[9] = j;
        String[] exp1t = new String[9];
        exp1t[0] = sum;
        exp1t[1] = sum;
        exp1t[2] = tim;
        exp1t[3] = div;
        exp1t[4] = sum;
        exp1t[5] = tim;
        exp1t[6] = sub;
        exp1t[7] = sub;
        exp1t[8] = sub;

        Rational[] exp2s = new Rational[10];
        exp2s[0] = a;
        exp2s[1] = b;
        exp2s[2] = c;
        exp2s[3] = d;
        exp2s[4] = e;
        exp2s[5] = f;
        exp2s[6] = g;
        exp2s[7] = h;
        exp2s[8] = i;
        exp2s[9] = j;
        String[] exp2t = new String[9];
        exp2t[0] = sum;
        exp2t[1] = sum;
        exp2t[2] = tim;
        exp2t[3] = div;
        exp2t[4] = sum;
        exp2t[5] = tim;
        exp2t[6] = sub;
        exp2t[7] = sub;
        exp2t[8] = sub;

        Rational[] exp3s = new Rational[5];
        exp3s[0] = a;
        exp3s[1] = b;
        exp3s[2] = d;
        exp3s[3] = d;
        exp3s[4] = i;
        String[] exp3t = new String[4];
        exp3t[0] = sum;
        exp3t[1] = sum;
        exp3t[2] = tim;
        exp3t[3] = div;

        Rational[] exp4s = new Rational[10];
        exp4s[0] = a;
        exp4s[1] = b;
        exp4s[2] = c;
        exp4s[3] = d;
        exp4s[4] = g;
        exp4s[5] = f;
        exp4s[6] = g;
        exp4s[7] = h;
        exp4s[8] = i;
        exp4s[9] = j;
        String[] exp4t = new String[9];
        exp4t[0] = sum;
        exp4t[1] = sum;
        exp4t[2] = tim;
        exp4t[3] = div;
        exp4t[4] = sum;
        exp4t[5] = tim;
        exp4t[6] = sub;
        exp4t[7] = sub;
        exp4t[8] = sub;

        RationalExpression exp1 = new RationalExpression(exp1s, exp1t);
        RationalExpression exp2 = new RationalExpression(exp2s, exp2t);
        RationalExpression exp3 = new RationalExpression(exp3s, exp3t);
        RationalExpression exp4 = new RationalExpression(exp4s, exp4t);
        StdOut.println("expresion 3 = " + exp3.toString());
        StdOut.println("expresion 1 = " + exp1.toString() + "es igual a : " + exp1.getResult().toString());
        StdOut.println("expresion 2 = " + exp2.toString() + "es igual a : " + exp2.getResult().toString());
        StdOut.println("expresion 3 = " + exp3.toString() + "es igual a : " + exp3.getResult().toString());
        StdOut.println("expresion 4 = " + exp4.toString() + "es igual a : " + exp4.getResult().toString());

    }
}