import java.util.*;
import java.io.*;

/*
Shortest Common Supersequence
Given two strings str1 and str2, find the length of the smallest string which has both, str1 and str2 as its sub-sequences.
Note: str1 and str2 can have both uppercase and lowercase letters.

Input:
The first line of input contains an integer T denoting the number of test cases.Each test case contains two space separated strings.

Output:
For each testcase, in a new line, output the length of the required string.

Constraints:
1 <= T <= 100
1<= |str1|, |str2| <= 100

Example:
Input:
2
abcd xycd
efgh jghi
Output:
6
6
*/

class ShortestCommonSupersequence
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String str[] = bf.readLine().split(" ");
	        
	        String s1 = str[0];
	        String s2 = str[1];
	        
	        int n = s1.length();
	        int m = s2.length();
	        
	        int dp[][] = new int[n+1][m+1];
	        
	        for(int i=0; i<=n; i++)
	        {
	            for(int j=0; j<=m; j++)
    	        {
    	            if(i==0 || j==0)
    	                dp[i][j] = 0;
    	            else if(s1.charAt(i-1)==s2.charAt(j-1))
    	                dp[i][j] = dp[i-1][j-1] +1;
    	            else
    	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    	        }
	        }
	        
	        System.out.println(m+n-dp[n][m]);
	    }
	}
}