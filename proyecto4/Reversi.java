import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/*
Ejercicio 3 del proyecto 4

Este ejercicio consiste en simular el resultado de un juego reversi en el cual se ponen y se voltean fichas 
en un tablero de 8x8. Para ello tendremos cuatro órdenes: put, turn, undo y count, introducidas en un 
archivo pasado como argumento.
Entregarmeos dos archivos, el TAD del tablero y el TAD de la partida.
*/

public class Reversi
{
    static Tablero reversi = new Tablero(8);
    static Stack<String> actions = new Stack();

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
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        // A pesar de que podriamos meter todas las ordenes en un array e irlas procesando 
        // una a una, creo que es mas eficiente ir leyendo y ejecutando una a una.
        while (in.hasNextLine())
        {
            String line = in.readLine();
            String order = str_split(line, ' ')[0];
            String complements = str_split(line, ' ')[1];

            if (order.equalsIgnoreCase("put"))
            {
                String[] arguments = complements.split(" ");
                reversi.Put(strToInt(arguments[0]), strToInt(arguments[1]), arguments[2]);
            }
            else if (order.equalsIgnoreCase("turn"))
            {
                String[] arguments = complements.split(" ");
                reversi.Turn(strToInt(arguments[0]), strToInt(arguments[1]));
            }
            else if (order.equalsIgnoreCase("count"))
            {
                System.out.println(reversi.Count());
            }
            else if (order.equalsIgnoreCase("undo"))
            {
                line = actions.peek();
                order = str_split(line, ' ')[0];
                complements = str_split(line, ' ')[1];
                if (order.equalsIgnoreCase("put"))
                {
                    String[] arguments = complements.split(" ");
                    reversi.PutUndo(strToInt(arguments[0]), strToInt(arguments[1]));
                }
                else if (order.equalsIgnoreCase("turn"))
                {
                    String[] arguments = complements.split(" ");
                    reversi.Turn(strToInt(arguments[0]), strToInt(arguments[1]));
                }
                line = "Undo";
            }
            else
            {
                System.err.println("Acción no conocida");
                System.exit(1);
            }
            actions.push(line);
        }
    }
}