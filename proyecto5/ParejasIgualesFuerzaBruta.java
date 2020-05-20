import edu.princeton.cs.algs4.*;

public class ParejasIgualesFuerzaBruta {

    public static int countPairs(int[] a){
        int count = 0;
        for (int i = 0; i < a.length - 1; i++){
            for (int j = i+1; j < a.length; j++){
                if (a[i] == a[j])
                    count++;
            }
        }
        return count;
    }
    public static void main (String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(countPairs(a));
    }

}