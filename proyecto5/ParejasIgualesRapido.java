import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ParejasIgualesRapido {
    public static int countPairs(int[] a){
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++){
            if (a[i] == a[i+1])
                count++;
                i++;
        }
        return count;
    }
    public static void main (String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(countPairs(a));
    }
}