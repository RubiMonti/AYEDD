import edu.princeton.cs.algs4.*;
public class FibonacciMemo
{
  public static long fibonacci(int n, int[] memo)
  {
    if(n == 0)
    {
      memo[n] = 0;
      return 0;
    }
    if(n == 1)
    {
      memo[n] = 1;
      return 1;
    }
    memo[n] = memo[n-1] + memo[n-2];
    return memo[n];
  }
  public static void main(String[] args)
  {
    memo = new long[90];
    for(int n = 0; n < 90; n++)
    {
      StdOut.println(n + " " + fibonacci(n, memo));
      memo[n] = fibonacci(n, memo);
    }
  }
}
