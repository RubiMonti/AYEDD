/*
Problema 2 del Proyecto 2.

Este problema consta de tres partes que consisten en añladir un contador que cuenta
el número de comparaciones que han sido realizadasa la hora de ejecutar las funciones
ya definidas previamente. Estas funciones son LinearSearch, SortedLinearSearch y BinarySearch.
*/

import java.util.Arrays;
import org.w3c.dom.css.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinearSearchCounter
{
    public static int indexOf(int key,int[] a, ft_counter count)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.err.println("Traza: count = " + count.toString());
            if(a[i] == key) return i;
            count.increment();
        }
        return-1;
    }
    public static void main(String[] args)
    {
        In      in = new In(args[0]);
        int[]   whitelist = in.readAllInts();
        ft_counter count = new ft_counter();
        System.err.println("Traza: count = " + count.toString());
        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(indexOf(key, whitelist, count) == -1)
                StdOut.println(key);        }
        StdOut.println("Número de comparaciones: " + count.toString());
    }
}