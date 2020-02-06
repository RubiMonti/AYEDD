import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
El código del método A ha quedado demasiado extenso y lioso a pesar de los comentarios.
No encontré un algoritmo mas simple para lograr el objetivo
*/
public class SunsetBoulevard
{
  public static int distance(int point_A, int point_B)
  {
    // Esta función determina la distancia entre dos puntos.
    int distance;
    distance = point_A - point_B;
    if (distance < 1)
      distance = distance * (-1);
    return distance;
  }
  public static int[] nearest_distance(int position, int[] dist, int[] done)
  {
    // Esta función nos ayuda a encontrar el punto mas cercano desde la posición actual.
    int index = 0;
    int minimum = 100000;
    for (int i = 0;i < dist.length; i++)
    {
      // El array done nos dice que portales han sido entregados ya
      if (done[i] == 0)
      {
        if (distance(position,dist[i]) < minimum)
        {
          index = i;
          minimum = distance(position, dist[i]);
        }
      }
    }
    position = dist[index];
    done[index] = 1;
    // Esta variable se crea simplemente para devolver ambos valores.
    int[] to_return = new int[2];
    to_return[0] = position;
    to_return[1] = minimum;
    return to_return;
  }
  public static int check_finish(int[] done)
  {
    // Esta función nos sirve para determinar si ha acabado de realizarse la tarea.
    for (int i = 0; i<done.length; i++)
    {
      if (done[i] == 0)
        return 0;
    }
    return 1;
  }
  public static int method_A(int[] dist, int[] done)
  {
    int travelled = 0;
    int position = 0;
    int[] new_list = new int[2];
    while (check_finish(done) == 0)
    {
      new_list = nearest_distance(position, dist, done);
      position = new_list[0];
      travelled += new_list[1];
    }
    travelled += distance(position, 0);
    return travelled;
  }
  public static int method_B(int[] dist)
  {
    int travelled = distance(0,dist[0]);
    for (int i = 1;i < dist.length; i++)
      travelled += distance(dist[i-1], dist[i]);
    travelled += distance(dist[dist.length - 1], 0);
    return travelled;
  }
  public static void main(String[] args)
  {
    In in = new In(args[1]);
    int[] dist = in.readAllInts();
    int[] done = new int[dist.length];
    for (int i = 0; i < dist.length; i++)
      done[i] = 0;
    Arrays.sort(dist);
    if (args[0].equals("-A"))
      StdOut.println("La distancia recorrida es: " + method_A(dist, done));
    if (args[0].equals("-B"))
      StdOut.println("La distancia recorrida es: " + method_B(dist));
  }
}
