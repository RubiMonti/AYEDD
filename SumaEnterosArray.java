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
      result = new int[num_2.length + 1];
    if (num_1.lenght > num_2.length)
      result = new int[num_1.length + 1];

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
    while (!num_1[i] && num_2[i])
    {
      result[k] = num_2[j];
      i--;
      j--;
      k--;
    }
    while  (num_1[i] && !num_2[i])
    {
      result[k] = num_1[i];
      i--;
      j--;
      k--;
    }
    return result[];
  }
  public static int[] fix(int[] result)
  {
    int i = result.length;
    while (i > 0)
    {
      if (result[i] > 9)
      {
        result[i] -= 10;
        result[i - 1]++;
      }
      i--;
    }
  }
  public static void main (String[] args)
  {
    In n1 = new In(args[0]);
    In n2 = new In(args[1]);
    int[] num_1 = n1.readAllInts();
    int[] num_2 = n2.readAllInts();
    if (num_1.lenght <= num_2.length)
      result = new int[num_2.length + 1];
    if (num_1.lenght > num_2.length)
      result = new int[num_1.length + 1];
    check(num_1);
    check(num_2);
    StdOut.println("Sumando; " + Arrays.toString(num_1) + Arrays.toString(num_2));
    result = suma(num_1, num_2);
    StdOut.println("Resultado de la suma: " + Arrays.toString(result));
    result = fix(result);
    StdOut.println("Resultado final: " + Arrays.toString(result));
  }
}
