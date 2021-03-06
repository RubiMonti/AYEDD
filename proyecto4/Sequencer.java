/*
Proyecto 4 ejercicio 4

Este ejercicio consiste en utilizar una circlist creada anteriormente 
para realizar una secuencia musical. El apartado obligatorio sera 
imprimiendo los sonidos en texto mientras que la parte opcional sera 
sacando los sonidos del ordenador.
*/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import java.util.concurrent.TimeUnit;


public class Sequencer
{
    static private String[] str_split(String s, char c)
    {
        // Esta funcion nos devuelve dos strings que son sacados de partir en dos el String pasado como parámetro por el carácter pasado como parametro.
        // El carácter pasado como parámetro se encuentra en el segundo string. En caso de no encontrar el carácter devolverá dos Strings con Error.
        String[] toreturn = new String[2];
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c)
            {
                toreturn[0] = s.substring(0,i);
                toreturn[1] = s.substring(++i);
                return (toreturn);
            }
        }
        toreturn[0] = s;
        toreturn[1] = "Error";
        return (toreturn);
    }

    static private int strToInt(String integer)
    {
        int toreturn = 0;
        int sign = 1;
        if (integer.charAt(0) == '-')
            sign = -1;
        else
            toreturn = integer.codePointAt(0) - 48;
        for (int i = 1; i < integer.length(); i++)
        {
            if (integer.codePointAt(i) >= 48 && integer.codePointAt(i) <= 57)
            {
                toreturn *= 10;
                toreturn += integer.codePointAt(i) - 48;
            }
            else
            {
                System.err.println("El número introducido no es válido");
                System.exit(1);
            }
        }
        toreturn *= sign;
        return (toreturn);
    }

    public static void sleep(int milliseconds)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.err.println("No se han introducido los suficientes parámetros.");
            System.exit(1);
        }
        In in = new In(args[1]);
        int wait = strToInt(args[0]);
        Loop loop = new Loop();
        String line;
        while (in.hasNextLine())
        {
            line = in.readLine();
            if (line.equalsIgnoreCase("nop"))
            {
                System.out.println(loop.nop());
            }
            else if (line.equalsIgnoreCase("del"))
            {
                System.out.println(loop.delete());
            }
            else
            {
                String order = str_split(line, ' ')[0];
                String complement = str_split(line, ' ')[1];
                if (order.equalsIgnoreCase("add"))
                {
                    System.out.println(loop.add(complement));
                }
                else
                {
                    System.err.println("No se pudo reconocer la orden");
                    System.exit(1);
                }
            }
            sleep(wait);
        }
    }
}