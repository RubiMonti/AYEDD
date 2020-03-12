import javax.lang.model.util.ElementScanner6;

/*
Ejercicio 3 del proyecto 4

Este ejercicio consiste en simular el resultado de un juego reversi en el cual se ponen y se voltean fichas 
en un tablero de 8x8. Para ello tendremos cuatro órdenes: put, turn, undo y count, introducidas en un 
archivo pasado como argumento.
Entregarmeos dos archivos, el TAD del tablero y el TAD de la partida.
*/

public class tablero
{
    private String[][] tablero;
    private int size;

    public tablero(int n)
    {
        size = n;
        tablero = new String[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
                tablero[i][j] = "N";
        }
    }

    public void put(int i, int j, String color)
    {
        if (tablero[i][j] == "N")
            tablero[i][j] = color;
        else
            {
                System.err.println("Ya hay una ficha en esa posición");
                System.exit(1);
            }
    }

    public void Turn(int i, int j)
    {
        if (tablero[i][j] == "W")
            tablero[i][j] = "B";
        else if (tablero[i][j] == "B")
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
                if (tablero[i][j] == "B")
                    black++;
                else if (tablero[i][j] == "W")
                    white++;
            }
        }
        toreturn = "B " + black + " W " + white;
    }
}