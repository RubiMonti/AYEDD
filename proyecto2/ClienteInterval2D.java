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
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        Double[] rectangulos = new Double[4];
        String line;
        System.err.println("KLK");
        int i = 0;
        Interval1D xInterval;
        Interval1D yInterval;
        Interval2D rect;
        while (in.hasNextLine())
        {
            line = in.readLine();
            rectangulos = new Double[4];
            System.err.println(i + " " + line);
            rectangulos = next_rect(line);
            System.err.println(Arrays.toString(rectangulos));
            xInterval = new Interval1D(rectangulos[0], rectangulos[2]);
            yInterval = new Interval1D(rectangulos[1], rectangulos[3]);
            rect = new Interval2D(xInterval, yInterval);
            rect.draw();
            i++;
        }
    }
}