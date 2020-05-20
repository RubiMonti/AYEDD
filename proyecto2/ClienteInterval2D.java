/*
Problema 1 del Proyecto 2.

Este  programa consiste en realizar un dibujo de rectángulos a partir de
números reales introducidos como parámetros. Además hay que hayar si entre
ellos son secantes o si hay alguno contenido en otro.
*/

import java.util.Arrays;
import java.util.TooManyListenersException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;


public class ClienteInterval2D 
{
    private static Double[] next_rect(String line)
    {
        Double[] toreturn = new Double[4];
        String[] points_s;
        points_s = line.split(" ");
        for (int i = 0; i < points_s.length ; i++)
            System.err.println(points_s[i]);
        if (points_s.length != 4)
        {
            System.err.println("El formato introducido no es válido, revisa los números");
            System.exit(1);
        }
        Double number;
        Double min = 0d;
        Double max = 1d;
        for (int i = 0; i < points_s.length; i++)
        {
            System.err.println(i);
            try
            {
                number = Double.parseDouble(points_s[i]);
                System.err.println(number);
                if (Double.compare(number, min) >= 1 && Double.compare(number, max) <= 1)
                    toreturn[i] = number;
                else 
                {
                    System.err.println("El formato introducido no es válido, revisa los números");
                    System.exit(1);
                }
            }
            catch (Exception e)
            {
                System.err.println("El formato introducido no es válido, revisa los números");
                System.exit(1);
            }
        }
        return (toreturn);
    }

    public static Interval2D[] new_rectangle(Interval2D[] rects)
    {
        Interval2D[] toreturn = new Interval2D[rects.length + 1];
        for (int i = 0; i < rects.length; i++)
            toreturn[i] = rects[i];
        return (toreturn);
    }
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        Double[] points = new Double[4];
        String line;
        int i = 0;
        Interval1D xInterval;
        Interval1D yInterval;
        Interval2D rect;
        Interval2D[] rectangulos = new Interval2D[0];
        while (in.hasNextLine())
        {
            line = in.readLine();
            points = new Double[4];
            System.err.println(i + " " + line);
            points = next_rect(line);
            for (int j = 0; j < points.length ; j++)
                System.err.println(points[j]);
            xInterval = new Interval1D(points[0], points[2]);
            yInterval = new Interval1D(points[1], points[3]);
            rect = new Interval2D(xInterval, yInterval);
            rectangulos = new_rectangle(rectangulos);
            rectangulos[i] = rect;
            rect.draw();
            i++;
        }
        System.err.println(rectangulos.length);
        int intersects = 0;
        int inside = 0;
        for (int j = 0; j < rectangulos.length - 1; j++)
        {
            for (int k = j + 1; k < rectangulos.length ; k++)
            {
                if (rectangulos[j].intersects(rectangulos[k]))
                    intersects++;
                else
                    inside++;
            }
        }
        StdOut.println("Cuadrados que intersectan: " + intersects);
        StdOut.println("Cuadrados contenidos en otros: " + inside);
    }
}