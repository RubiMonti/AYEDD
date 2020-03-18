/*
Ejercicio 3 del proyecto 4

Este ejercicio consiste en simular el resultado de un juego reversi en el cual se ponen y se voltean fichas 
en un tablero de 8x8. Para ello tendremos cuatro órdenes: put, turn, undo y count, introducidas en un 
archivo pasado como argumento.
Entregarmeos dos archivos, el TAD del tablero y el TAD de la partida.
*/

public class Tablero
{
    private String[][] tablero;
    private int size;

    public Tablero(int n)
    {
        size = n;
        tablero = new String[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
                tablero[i][j] = "N";
        }
    }

    public void Put(int i, int j, String color)
    {
        if (i < 0 || i > size || j < 0 || j > size)
        {
            System.err.println("Los numeros introducidos no son validos");
            System.exit(1);
        }
        else if (!color.equals("W") && !color.equals("B"))
        {
            System.err.println("El color introducido no es ni blanco ni negro");
            System.exit(1);
        }
        else if (tablero[i][j].equals("N"))
            tablero[i][j] = color;
        else
        {
            System.err.println("Ya hay una ficha en esa posición");
            System.exit(1);
        }
    }

    public void PutUndo(int i, int j)
    {
        tablero[i][j] = "N";
    }

    public void Turn(int i, int j)
    {
        if (i < 0 || i > size || j < 0 || j > size)
        {
            System.err.println("Los numeros introducidos no son validos");
            System.exit(1);
        }
        else if (tablero[i][j].equals("W"))
            tablero[i][j] = "B";
        else if (tablero[i][j].equals("B"))
            tablero[i][j] = "W";
        else
        {
            System.err.println("No hay una ficha en esa posición");
            System.exit(1);
        }
    }

    public String Count()
    {
        int white = 0;
        int black = 0;
        String toreturn;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (tablero[i][j].equals("B"))
                    black++;
                else if (tablero[i][j].equals("W"))
                    white++;
            }
        }
        toreturn = "B " + black + " W " + white;
        return (toreturn);
    }
}