import java.util.*;
import java.io.*;

/*
Longest Bitonic subsequence
Given an array of positive integers. The task is to print the maximum length of Bitonic subsequence. 
a subsequenceof array is called Bitonic if it is first increasing, then decreasing.

Input:
First line contains T test cases. First line of every test case consists of N , denoting number of elements in an array. Second line of every test consists of elements in array.

Output:
For each testcase, in a new line, print the length of longest bitonic sequence.

Constraints:
1<=T<=100
1<=N<=100
1<=Ai<=200

Example:
Input:
2
5
1 2 5 3 2
8
1 11 2 10 4 5 2 1
Output:
5
6
*/

class LongestBitonicSubsequence
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
            
            int ans = LBS(arr);
            System.out.println(ans);
	    }
	}
	
	static int LBS(int arr[])
	{
	    int n = arr.length;
	    
	    int dp1[] = new int[n];
	    int dp2[] = new int[n];
	    for(int i=0; i<n; i++)
	    {
	        dp1[i] = 1;
	        dp2[i] = 1;
	    }
	    
	    for(int i=0; i<n; i++)
	    {
	        for(int j=0; j<i; j++)
	        {
	            if(arr[i]>arr[j])
	                dp1[i] = Math.max(dp1[i], dp1[j]+1);
	        }
	    }
	    
	    for(int i=n-2; i>=0; i--)
	    {
	        for(int j=n-1; j>i; j--)
	        {
	            if(arr[i]>arr[j])
	                dp2[i] = Math.max(dp2[i], dp2[j]+1);
	        }
	    }
	    
	    int res[] = new int[n];
	    for(int i=0; i<n; i++)
	    {
	        res[i] = dp1[i]+dp2[i]-1;
	    }
	    
	   // System.out.println(Arrays.toString(dp1));
	   // System.out.println(Arrays.toString(dp2));
	   // System.out.println(Arrays.toString(res));
	    
	    Arrays.sort(res);
	    
	    return res[n-1];
	}
}