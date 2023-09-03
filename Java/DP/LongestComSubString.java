import java.util.*;
import java.io.*;

/*

https://practice.geeksforgeeks.org/problems/longest-common-substring/0/?ref=self

Longest Common Substring
Given two strings X and Y. The task is to find the length of the longest common substring.

Input:
First line of the input contains number of test cases T. Each test case consist of three lines, first of which contains 2 space separated integers N and M denoting the size of string X and Y strings respectively. The next two lines contains the string X and Y.

Output:
For each test case print the length of longest  common substring of the two strings .

Constraints:
1 <= T <= 200
1 <= N, M <= 100

Example:
Input:
2
6 6
ABCDGH
ACDGHR
3 2
ABC
AC

Output:
4
1

Example:
Testcase 1: CDGH is the longest substring present in both of the strings.
*/

class LongestComSubString
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String fucku[] = bf.readLine().split(" ");
	        
	        char str1[] = (bf.readLine()).toCharArray();
	        char str2[] = (bf.readLine()).toCharArray();
	        
	        int dp[][] = new int[str1.length+1][str2.length+1];
	        
	        int max = 0;
	        for(int i=1; i<=str1.length; i++)
	        {
	            for(int j=1; j<=str2.length; j++)
	            {
	                if(str1[i-1]==str2[j-1])
	                {
	                    //int t = Math.max()
	                    dp[i][j] = dp[i-1][j-1]+1;
	                    max = Math.max(max, dp[i][j]);
	                }
	            }
            }
            
            System.out.println(max);
	    }
	}
}