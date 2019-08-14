import java.util.*;
import java.lang.*;
import java.io.*;

class minRopeCost
{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
      {
          int T = Integer.parseInt(scanner.nextLine());
          for(int a=0; a<T; a++)
          {
              int N = scanner.nextInt();
              
              PriorityQueue<Integer> q = new PriorityQueue<>();
              int arr[] = new int[N];
              for(int i=0; i<N; i++)
              {
                  arr[i] = scanner.nextInt();
                  q.add(arr[i]);
              }
              
              long res = 0;
              while(q.size()>1)
              {
                  int f = q.poll();
                  int s = q.poll();
                  
                  int sum = f+s;
                  res += sum;
                  q.add(sum);
              }
              
              System.out.println(res);
          }
      }
}