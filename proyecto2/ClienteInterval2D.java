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
import edu.princeton.cs.algs4.StdDraw;

public class ClienteInterval2D 
{
    private double[] next_rect(double[] rectaungulos)
    {
        // creamos un punto con rectangulos[0-3]
        double[] new_rectagulos = new double[rectaungulos.length - 4];
        for (int i = 4; i < rectaungulos.length; i++)
            new_rectagulos[i - 4] = rectaungulos[i];
            return (new_rectagulos);
    }
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        double[] rectangulos = in.readAllDoubles();
        // Aqui creamos las variables que almacenaran los puntos de los retangulos.
        StdOut.println(Arrays.toString(rectangulos));

        next_rect(rectangulos);
    }
}