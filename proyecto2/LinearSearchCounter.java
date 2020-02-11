/*
Problema 2 del Proyecto 2.

Este problema consta de tres partes que consisten en añladir un contador que cuenta
el número de comparaciones que han sido realizadasa la hora de ejecutar las funciones
ya definidas previamente. Estas funciones son LinearSearch, SortedLinearSearch y BinarySearch.
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinearSearchCounter
{
    public static int indexOf(int key,int[] a, Counter count)
    {
        for(int i = 0; i < a.length; i++)
        {
            count.increment();
            if(a[i] == key) return i;
        }
        return-1;
    }
    public static void main(String[] args)
    {
        In      in = new In(args[0]);
        int[]   whitelist = in.readAllInts();
        Counter count = new Counter("count");
        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(indexOf(key, whitelist, count) == -1)
                StdOut.println(key);        
        }
        StdOut.println("Número de comparaciones: " + count.tally());
    }
}