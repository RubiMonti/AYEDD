import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class suma
{
  public static void main (String[] args)
  {
    In n1 = new In(args[0]);
    In n2 = new In(args[1]);
    int[] num_1 = n1.readAllInts();
    int[] num_2 = n2.readAllInts();

    for (int i = 0; i < num_1.length; i++)
      if (num_1[i] > 9 && num_1[i] < 0)
      {
        System.err.println("Error: el número proporcionado no existe");
        System.exit(1);
      }
    for (int i = 0; i < num_2.length; i++)
      if (num_2[i] > 9 && num_2[i] < 0)
      {
        System.err.println("Error: el número proporcionado no existe");
        System.exit(1);
      }
    StdOut.println("Sumando; " + Arrays.toString(num_1) + Arrays.toString(num_2));
  }
}
