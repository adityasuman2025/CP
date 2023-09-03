import java.util.*;
import java.io.*;

/*
Number of Unique Paths
Given a M X N matrix with your initial position at top-left cell, find the number of possible unique paths to reach the bottom right cell of the matrix from the initial position.

Note: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].

Input: 
The first line contains an integer T, depicting total number of test cases. Then following T lines contains an two integers A and B depicting the size of the grid.

Output:
Print the number of unique paths to reach bottom-right cell from the top-left cell.

Constraints:
1 ≤ T ≤ 30
1 ≤ M ≤ 15
1 ≤ N ≤ 15

Example:
Input:
2
2 2
3 4

Output:
2
10

Example:
Testcase 1: 
There are only two unique paths to reach end of the matrix of size two from starting cell of the matrix.
*/

class CountUniquePath
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String input[] = bf.readLine().split(" ");
	        int M = Integer.parseInt(input[0]);
	        int N = Integer.parseInt(input[1]);
	     
	        int dp[][] = new int[M][N];
	        
	        for(int i=0; i<M; i++)
	            dp[i][0] = 1;
	            
	        for(int i=0; i<N; i++)
	            dp[0][i] = 1;
	            
	        for(int i=1;i<M;i++)
    	    {
    	        for(int j=1;j<N;j++)
    	        {
    	            dp[i][j]=dp[i][j-1]+dp[i-1][j];
    	        }
    	    }
	        
	        for(int arr[]: dp)
	            System.out.println(Arrays.toString(arr));
	        
	        System.out.println(dp[M-1][N-1]);
	    }
	}

}