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

public class SortedBinarySearchCounter
{
    public static int indexOf(int key,int[] a, Counter count)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            count.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) 
            {
                hi = mid - 1;
                count.increment();
            }
            else if (key > a[mid])
            {
                lo = mid + 1;
                count.increment();
                count.increment();
            }
            else
            {
                count.increment();
                count.increment();
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        In      in = new In(args[0]);
        int[]   whitelist = in.readAllInts();
        Counter count = new Counter("count");
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(indexOf(key, whitelist, count) == -1)
                StdOut.println(key);        
        }
        StdOut.println("Número de comparaciones: " + count.tally());
    }
}