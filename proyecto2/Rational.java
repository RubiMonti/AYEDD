/*
Ejercicio 3 Proyecto 2.

Este ejercicio nos pide implementar una nueva clase que represente los números
fraccionarios. En el enunciado viene el API de la clase y todo lo necesario para
hacerlo.

Para ejecutarlo correctamente, aparte del programa definido arriba, haremos
una nueva clase aparte para ejecutar operaciones e imprimirlas en la salida 
del terminal o la salida estandar.
*/

public class Rational
{
    private int num;
    private int den;

    public Rational (int numerator, int denominator)
    {
        // Con esto, nos quitamos los números partidos entre 0 y los de denominador negativo.
        if (denominator == 0)
        {
            System.err.println("Error: El denominador no puede ser 0.");
            System.exit(1);
        }
        else if (denominator < 0)
        {
            num = numerator * -1;
            den = denominator * -1;
        }
        else
        {
            num = numerator;
            den = denominator;
        }
    }
    /*
    En un primer lugar tenemos las funciones que nos ayudaran con las operaciones matemáticas y que 
    el cliente no tiene porque utilizar en su programa
    */

    private Rational Common_Denominator (Rational b)
    {
        num *= b.denominator();
        den *= b.denominator();
        return (this);
    }

    private int MCD(int a, int b) 
    {
        int resto;
        resto = a % b;
        while (resto != 0)
        {
            a = b;
            b = resto;
            resto = a % b;
        }
        return (b);
    }

    /*
    Aquí vienen definidos los metodos que el cliente va a ser capaz de ejecutar cuando 
    utilize esta clase
    */

    public Rational reduce()
    {
        num /= MCD(num, den);
        den /= MCD(num, den);
        return (this);
    }

    public int numerator()
        {return num;}
    
    public int denominator()
        {return den;}

    public Rational plus(Rational b)
    {
        Rational sumando;
        sumando = new Rational (b.numerator(), b.denominator());
        this.Common_Denominator(sumando);
        sumando.Common_Denominator(this);
        num += sumando.numerator();
        this.reduce();
        return (this);
    }

    public Rational minus()
    {
        num *= -1;
        return (this);
    }

    public Rational times(Rational b)
    {
        num *= b.numerator();
        den *= b.denominator();
        this.reduce();
        return (this);
    }

    public Rational invert()
    {
        int swap = den;
        den = num;
        num = swap;
        return (this);
    }

    public boolean equals(Object b)
    {
        if (this.getClass() != b.getClass()) 
            return false;
        else
        {
            Rational that;
            that = (Rational) b;
            if (this.numerator() != that.numerator())
                return false;
            else if (this.denominator() != that.denominator())
                return false;
            else
                return (true);
        }
    }

    public String toString()
    {
        String fraction;
        fraction = num + "/" + den;
        return (fraction);
    }
}