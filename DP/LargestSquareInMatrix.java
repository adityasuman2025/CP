import java.util.*;
import java.io.*;

/*
Largest square formed in a matrix
Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is n and m,n is the number of rows and m is the number of columns.
The second line of each test case contains array C[n][m] in row major form.

Output:

Print maximum size square sub-matrix.

Constraints:

1 ≤ T ≤ 100
1 ≤ n,m ≤ 50
0 ≤ C[n][m] ≤ 1

Example:

Input:
3
5 6
0 1 0 1 0 1 1 0 1 0 1 0 0 1 1 1 1 0 0 0 1 1 1 0 1 1 1 1 1 1
2 2
1 1 1 1
2 2
0 0 0 0

Output:
3
2
0
*/

class LargestSquareInMatrix
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String input[] = bf.readLine().split(" ");
	        int R = Integer.parseInt(input[0]);
	        int C = Integer.parseInt(input[1]);
	        
	        String str[] = bf.readLine().split(" ");
	        
	        int dp[][] = new int[R][C];
	        int max = dp[0][0];
	        
	        for(int i=0; i<R; i++)
	        {
	            dp[i][0] = Integer.parseInt(str[C*i]);
	            max = Math.max(max, dp[i][0]);
            }
            
	        for(int i=0; i<C; i++)
	        {
	            dp[0][i] = Integer.parseInt(str[i]);
	            max = Math.max(max, dp[0][i]);
            }
            
            for(int i=1; i<R; i++)
            {
                for(int j=1; j<C; j++)
    	        {
    	            if(str[(C*i)+j].equals("1"))
    	            {
    	                int min = Math.min(dp[i][j-1],dp[i-1][j]);
    	                
    	                dp[i][j] = Math.min(min,dp[i-1][j-1]) + 1;
    	            }
    	            else
    	            {
    	                dp[i][j] = Integer.parseInt(str[(C*i)+j]);
    	            }
    	            
    	            max = Math.max(max, dp[i][j]);
                }
            }
            
            System.out.println(max);
            
            // for(int item[]: dp)
            // {
            //     System.out.println(Arrays.toString(item));
            // }
	    }
	}
}