import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SumaEnterosArray
{
  public static void check (int[] num)
  {
    for (int i = 0; i < num.length; i++)
      if (num[i] > 9 || num[i] < 0)
      {
        System.err.println("Error: el número proporcionado no existe");
        System.exit(1);
      }
  }
  public static int[] suma (int[] num_1, int[] num_2)
  {
    if (num_1.lenght <= num_2.length)
      int[] result = new [num_2.length + 1];
    if (num_1.lenght > num_2.length)
      int[] result = new [num_1.length + 1];

    int i = num_1.length - 1;
    int j = num_2.length - 1;
    int k = result.length - 1;
    while (num_1[i] && num_2[j])
    {
      result[k] = num_1[i] + num_2[j];
      i--;
      j--;
      k--; 
    }
  }
  public static void main (String[] args)
  {
    In n1 = new In(args[0]);
    In n2 = new In(args[1]);
    int[] num_1 = n1.readAllInts();
    int[] num_2 = n2.readAllInts();

    check(num_1);
    check(num_2);
    StdOut.println("Sumando; " + Arrays.toString(num_1) + Arrays.toString(num_2));
  }
}
