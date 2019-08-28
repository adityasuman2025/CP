import java.util.*;
import java.io.*;

/*
Maximum Sum Bitonic Subsequence
Given an array of integers A. A subsequence of A is called Bitonic if it is first increasing then decreasing.

Input:
The first line contains an integer T denoting the no of test cases. Each test case consist of two lines. The first line contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line print the max sum bitonic subsequence.

Constraints:
1<=T<=100
1<=N<=50
1<=A[]<=100

Example:
Input:
2
6
80 60 30 40 20 10
9
1 15 51 45 33 100 12 18 9

Output:
210
194

Explanation:
Testcase2:
Input : A[] = {1, 15, 51, 45, 33, 100, 12, 18, 9}
Output : 194
 Bi-tonic Sub-sequence are :
{1, 51, 9} 
{1, 50, 100, 18, 9}
{1, 15, 51, 100, 18, 9}
{1, 15, 45, 100, 12, 9}
{1, 15, 45, 100, 18, 9} .. so on           
Maximum sum Bi-tonic sub-sequence is 1 + 15 + 51 + 100 + 18 + 9 = 194  
*/

class MaximumSumBitonicSubsequence
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
            
            int ans = MSBS(arr);
            System.out.println(ans);
	    }
	}
	
	static int MSBS(int arr[])
	{
	    int n = arr.length;
	     
	    int dp1[] = new int[n];
	    int dp2[] = new int[n];
	    for(int i=0; i<n; i++)
	    {
	        dp1[i] = arr[i];
	        dp2[i] = arr[i];
	    }
	    
	    for(int i=0; i<n; i++)
	    {
	        for(int j=0; j<i; j++)
	        {
	            if(arr[i]>arr[j])
	                dp1[i] = Math.max(arr[i] + dp1[j], dp1[i]);
	        }
	    }
	   
	    for(int i=n-2; i>=0; i--)
	    {
	        for(int j=n-1; j>i; j--)
	        {
	            if(arr[i]>arr[j])
	                dp2[i] = Math.max(arr[i] + dp2[j], dp2[i]);
	        }
	    }
	    
	    int res[] = new int[n];
	    for(int i=0; i<n; i++)
	    {
	        res[i] = dp1[i]+dp2[i]-arr[i];
	    }
	    Arrays.sort(res);
	   
	    return res[n-1];
	}
}