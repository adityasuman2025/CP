import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/max-rope-cutting/0

Max rope cutting
Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. You must make at least one cut.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is length of rope denoted by N.

Output:

Print the maximizes product of lengths of all parts.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 100

Example:

Input:
2
2
5

Output:
1
6
*/

class MaxRopeCutting
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	       
	        long ans = 1;
	        if(N==3)
	        {
	            ans = 2;
	        }
	        else if(N>3)
	        {
	            int divi = N/3;
	            int rem = N%3;
	          
	            if(rem<2)
	            {
	                divi--;
	                rem +=3;
	            }
	            while(divi>0)
	            {
	                ans*=3;
	                divi--;
	            }
	            
	            if(rem>0)
	                ans *=rem;
	        }
	        
	        System.out.println(ans);
	    }
	}
}