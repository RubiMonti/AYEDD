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
    public Rational (int number)
    {
        num = number;
        den = 1;
    }

    /*
    En un primer lugar tenemos las funciones que nos ayudaran con las operaciones matemáticas y que 
    el cliente no tiene porque utilizar en su programa
    */

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

    private String[] str_split(String s, char c)
    {
        // Esta funcion nos devuelve dos strings que son sacados de partir en dos el String pasado como parámetro por el carácter pasado como parametro.
        // El carácter pasado como parámetro se encuentra en el segundo string. En caso de no encontrar el carácter devolverá dos Strings con Error.
        String[] toreturn = new String[2];
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c)
            {
                toreturn[0] = s.substring(0,i);
                toreturn[1] = s.substring(i);
                return (toreturn);
            }
        }
        toreturn[0] = s;
        toreturn[1] = "Error";
        return (toreturn);
    }

    /*
    Aquí vienen definidos los metodos que el cliente va a ser capaz de ejecutar cuando 
    utilize esta clase
    */

    public Rational reduce()
    {
        Rational swap = new Rational(num, den);
        num /= MCD(swap.numerator(), swap.denominator());
        den /= MCD(swap.numerator(), swap.denominator());
        if (den < 0)
        {
            num *= -1;
            den *= -1;
        }
        return (this);
    }

    public int numerator()
        {return num;}
    
    public int denominator()
        {return den;}

    public Rational plus(Rational b)
    {
        int n, d;
        n = ((this.numerator() * b.denominator()) + (b.numerator() * this.denominator()));
        d = (this.denominator() * b.denominator());
        Rational toreturn = new Rational(n, d);
        toreturn.reduce();
        return (toreturn);
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
        if (den != 1)
            fraction = "(" + num + "/" + den + ")";
        else
            fraction = "(" + num + ")";
        return (fraction);
    }

    public String parseRational(String s)
    {
        int number = 0;
        String t;
        String prefix;
        t = s.trim();
        for (int i = 0; i < 2; i++)
        {
            prefix = str_split(t, ' ')[0];
            t = str_split(t, ' ')[1];
            if (i == 0)
            {
                try {
                    number = Integer.parseInt(prefix);
                    this.num = number;
                } 
                catch (Exception e) {
                    System.err.println("Rational, Error: No se pudo transformar el string a integer.");
                    System.exit(1);
                }
            }
            else
            {
                try {
                    number = Integer.parseInt(prefix);
                    this.den = number;
                } 
                catch (Exception e) {
                    if (prefix.equals("+") || prefix.equals("-") || prefix.equals("x") || prefix.equals("/"))
                    {
                        t = prefix + t;
                        this.den = 1;
                    }
                    else
                    {
                        System.err.println("Rational, Error: No se pudo transformar el string a integer.");
                        System.exit(1);
                    }
                } 
            }
            t = t.trim();
        }
        if (s.equals(t))
        {
            System.err.println("Rational, Error: No se encontró ningun Rational en el string.");
            System.exit(1);
        }
        else
            return (t);
        return(t);
    }
}