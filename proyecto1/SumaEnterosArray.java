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
        System.err.println("Error: El número proporcionado no existe");
        System.exit(1);
      }
  }
  public static int[] suma (int[] num_1, int[] num_2, int[] result)
  {
    int i = num_1.length - 1;
    int j = num_2.length - 1;
    for (int k = result.length - 1; k >= 0; k--)
    {
      if (i < 0 && j < 0)
      {
        result[k] = 0;
      }
      else if (j < 0)
      {
        result[k] = num_1[i];
        i--;
      }
      else if (i < 0)
      {
        result[k] = num_2[j];
        j--;
      }
      else
      {
        result[k] = num_1[i] + num_2[j];
        i--;
        j--;
      }
    }
    return result;
  }
  public static int[] fix(int[] result)
  {
    for (int i = result.length - 1; i > 0; i--)
    {
      if (result[i] > 9)
      {
        result[i] -= 10;
        result[i - 1]++;
      }
    }
    int skip = 0;
    while (result[skip] == 0)
      skip++;
    int[] end = new int[result.length - skip];
    for (int i = 0; i < end.length; i++)
        end[i] = result[i + skip];
    return end;
  }
  public static void main (String[] args)
  {
    In n1 = new In(args[0]);
    In n2 = new In(args[1]);
    int[] num_1 = n1.readAllInts();
    int[] num_2 = n2.readAllInts();
    int[] result;
    if (num_1 == null || num_2 == null)
    {
      System.err.println("Error: No se han proporcionado suficientes números.");
      System.exit(1);
    }
    if (num_1.length <= num_2.length)
      result = new int[num_2.length + 1];
    else
      result = new int[num_1.length + 1];
    check(num_1);
    check(num_2);
    //StdOut.println("Sumando; " + Arrays.toString(num_1) + Arrays.toString(num_2));
    result = suma(num_1, num_2, result);
    result = fix(result);
    StdOut.println(Arrays.toString(result));
  }
}
