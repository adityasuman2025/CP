import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game/0

Optimal Strategy For A Game
You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.

You need to determine the maximum possible amouint of money you can win if you go first.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains N denoting the size of the array. The second line contains N elements of the array.

Output:
For each testcase, in a new line, print the maximum amout.

Constraints:
1 <= T <= 100
2 <= N <= 100
1 <= Ai <= 106

Examples:
Input:
2
4
5 3 7 10
4
8 15 3 7
Output:
15
22

Explanation:
Testcase1: The user collects maximum value as 15(10 + 5)
Testcase2: The user collects maximum value as 22(7 + 15)
*/

class Score
{
	int P1, P2;	
}

class OptimalStrategyForGame
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
            
        //initializing the dp array    
            Score dp[][] = new Score[N][N];
            for(int i=0; i < N; i++)
            {
	        	for(int j=0; j < N; j++)
	                dp[i][j] = new Score();
            }
        
        //if only one(1) element i.e diagonal is available then always player 1 picks that element only
            for(int i=0; i < N; i++)
            {
	            dp[i][i].P1 = arr[i];
	        }

	    //if more than 1 i.e 2 or more elements are available to pick
	        for(int len = 2; len<=N; len++)
	        {
	        	for(int i=0; i<N-len+1; i++)
	        	{
	        		int j = i+len-1; // array from i to j, game will happen between array element b/w i & j

	        		if(arr[i] + dp[i+1][j].P2 > arr[j] + dp[i][j-1].P2)
	        		{
	        			dp[i][j].P1 = arr[i] + dp[i+1][j].P2;
	        			dp[i][j].P2 = dp[i+1][j].P1;
	        		}
	        		else
	        		{
	        			dp[i][j].P1 = arr[j] + dp[i][j-1].P2;
	        			dp[i][j].P2 = dp[i][j-1].P1;
	        		}
	        	}
	        }

	        System.out.prinltn(dp[0][N-1]);
	    }
	}
}