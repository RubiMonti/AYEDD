/*
Problema 1 del Proyecto 2.

Este  programa consiste en realizar un dibujo de rectángulos a partir de
números reales introducidos como parámetros. Además hay que hayar si entre
ellos son secantes o si hay alguno contenido en otro.
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ClienteInterval2D 
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        double[] rectangulos = in.readAllDoubles();
        StdOut.println(Arrays.toString(rectangulos));

        /*
        Una vez metidos los datos del fichero 
        */
        if (rectangulos.length % 4 != 0)
        {
            System.err.println("Error: El archivo proporcionado no cumple el formato establecido.");
            System.exit(1);
        }
    }
}