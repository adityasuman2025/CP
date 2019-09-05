import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/total-decoding-messages/0/?ref=self

Practice
Explore  Courses  Get Hired
    
LIVE   BATCHES
Total Decoding Messages
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example :
Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
So total ways are 3.

Input:
First line contains the test cases T.  1<=T<=1000
Each test case have two lines
First is length of string N.  1<=N<=40
Second line is string S of digits from '0' to '9' of N length.

Example:
Input:
2
3
123
4
2563
Output:
3
2

*/

class WaysToDecodeString
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String num = bf.readLine().trim();
	        
	        int dp[] = new int[N];
	        Arrays.fill(dp, 0);
	        
	        int ways = decodeWays(num, 0, dp);
	        System.out.println(ways);
	    }
	}
	
	static int decodeWays(String s, int pointer, int dp[])
	{
	    int n = s.length();
	    
	    if(pointer >= n)
	        return 1;
	        
	    if(dp[pointer] > 0)
	        return dp[pointer];
	    
	//decoding one character
	    if(pointer+1 <= n)
	    {
	        String oneChar = s.substring(pointer, pointer+1);
	        
	        if(isValid(oneChar))
	            dp[pointer] += decodeWays(s, pointer+1, dp);
	    }
	    
    //decoding two characters
	    if(pointer+2 <= n)
	    {
	        String twoChar = s.substring(pointer, pointer+2);
	        
	        if(isValid(twoChar))
	            dp[pointer] += decodeWays(s, pointer+2, dp);
	    }
	    
	    return dp[pointer];
	}
	
	static boolean isValid(String s)
	{
	    if(s.length() == 0)
	        return false;
	        
	    if(s.charAt(0) == '0')
	        return false;
	        
	    int num = Integer.parseInt(s);
	    
	    if(num>=1 && num<=26)
	        return true;
	        
	    return false;
	}
}