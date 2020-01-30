import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SunsetBoulevard
{
  public static int distance(int point_A, int point_B)
  {
    int distance;
    distance = point_A - point_B;
    if (distance < 1)
      distance = distance * (-1);
    return distance;
  }
  public static int nearest_distance(int point_A, int[] distances)
  {
    int minimum_distance = 100000
    int index = -1
    for (int i = 0; i < distances.length; i++)
    {
      if (distance(point_A, distances[i]) < minimum_distance)
      {
        minimum_distance = distance(point_A, distances[i]);
        index = i;
    }
    if (minimum_distance == 100000)
      return -1;
    else
    {
      distances[index] = 100001
      return minimum_distance
    }
  }
  public static int method_A(int[] dist)
  {
    int position = 0;
    if nearest_distance(position)
  }
  public static int method_B(int[] dist)
  {
    int travelled = distance(0,dist[0]);
    int position = dist[0];
    for (int i = 1;i < dist.length; i++)
      travelled += distance(dist[i-1], dist[i]);
    travelled += distance(dist[dist.length - 1], 0);
    return travelled;
  }
  public static void main(String[] args)
  {
    In in = new In(args[1]);
    int[] dist = in.readAllInts();
    Arrays.sort(dist);
    if (args[0].equals("-A"))
      StdOut.println("La distancia recorrida es: " + method_A(dist));
    if (args[0].equals("-B"))
      StdOut.println("La distancia recorrida es: " + method_B(dist));
  }
}
