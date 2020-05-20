import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class IntersectArrays {
    public static int[] intersect(int[] a, int[] b){
        int i = 0;
        int j = 0;
        int k = 0;
        int n = a.length;
        int[] toreturn = new int[2*n];
        while (i < n && j < n){
            if (a[i] < b[j]){
                toreturn[k] = a[i];
                i++;
            }
            else{
                toreturn[k] = b[j];
                j++;
            }
            k++;
        }
        if (i == n){
            while (j < n){
                toreturn[k] = b[j];
                j++;
                k++;
            }
        }
        else if (j == n){
            while (i < n){
                toreturn[k] = a[i];
                i++;
                k++;
            }
        }
        else
            System.err.println("Algo ocurrio revisa el bucle");
        return(toreturn);
    }

    public static void main(String[] args) {
        int n = 5;
        int MAXIMUM_INTEGER = 1000000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Arrays.sort(a);
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Arrays.sort(b);
        StdOut.println(Arrays.toString(intersect(a, b)));
    }
}