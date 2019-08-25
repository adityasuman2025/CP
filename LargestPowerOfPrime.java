import java.util.*;
import java.io.*;

/*
Largest power of prime
Given a positive integer N and a prime p, the task is to print the largest power of prime p that divides N!. Here N! means the factorial of N = 1 x 2 x 3 . . (N-1) x N.
Note that the largest power may be 0 too.


Input: 
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line containing a positive integer N and a prime p.


Output:
Corresponding to each test case, in a new line, print the largest power of prime p that divides N .


Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100000
2 ≤5000 ≤p

Example:
Input
3
62 7
76 2
3 5

Output
9
73
0
*/

class LargestPowerOfPrime
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String input[] = bf.readLine().split(" ");
	        int N = Integer.parseInt(input[0]);
	        int P = Integer.parseInt(input[1]);
	        
	        int c=0;
	        for(int i=1; i<=N; i++)
	        {
	            if(i%P ==0)
	            {
	                int num = i;
	                while(num%P == 0)
	                {
	                    c++;
	                    num = num/P;
	                }
	            }
	        }
	        System.out.println(c);
	    }
	}
}