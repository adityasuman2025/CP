import java.util.*;
import java.io.*;

/*
Longest alternating subsequence
A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the following relations :

x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....

Your task is to find the longest such sequence.

 

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the size array A.

The second line of each test case contains N space separated integers denoting elements of the array A[ ].


Output:

Print the length of the longest alternating subsequence for each testcase in a new line.


Constraints:

1<= T <=100

1<= N <=1000

1<= A[ ] <=1000


Example:

Input:

2

3

1 5 4

8

10 22 9 33 49 50 31 60

Output:

3

6
*/

class LongestAlterSubseq
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        String str[] = bf.readLine().split(" ");
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
            }
            
	        int inc[] = new int[N];
	        int dec[] = new int[N];
	        
	        inc[0] = 1;
	        dec[0] = 1;
	            
	        for(int i=1; i<N; i++)
	        {
                if(arr[i]>arr[i-1])
                {
    	           inc[i] = dec[i-1]+1;
    	           dec[i] = dec[i-1];
    	        }
    	        else if(arr[i]<arr[i-1])
    	        {
    	           dec[i] = inc[i-1]+1;
    	           inc[i] = inc[i-1];
    	        }
    	        else
    	        {
    	           dec[i] = dec[i-1];
    	           inc[i] = inc[i-1];
    	        }
	        }
	        
	        System.out.println(Math.max(dec[N-1], inc[N-1]));
	    }
	}
}