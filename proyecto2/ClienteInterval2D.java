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
        // Hay que probar este código para ver como lee los numeros y como los almacena. Dependiendo de la forma de estructurarlo habra que crear una funcion para que los separe en los rectangulos.
        In in = new In(args[0]);
        float[] rectangulos = in.readAllInts();
        StdOut.println(Arrays.toString(rectangulos));
    }
}