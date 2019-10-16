import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence/0

Longest consecutive subsequence
Given an array arr[] of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Input:
The first line of input contains T, number of test cases. First line of line each test case contains a single integer N.
Next line contains N integer array.

Output:
Print the output of each test case in a seprate line.

Constraints:
1 <= T <= 100
1 <= N <= 105
0 <= a[i] <= 105

Example:
Input:
2
7
2 6 1 9 4 5 3
7
1 9 3 10 4 20 2

Output:
6
4

Explanation:
Testcase 1:  The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.

Testcase2: 1, 2, 3, 4 is the longest consecutive subsequence.
*/

class LongestConsecSubSeq
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = Integer.parseInt(bf.readLine());
	        String str[] = bf.readLine().split(" ");
	        
	        HashSet<Integer> set = new HashSet<>();
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
	            set.add(arr[i]);
            }
            
            int ans = 1;
            for(int i=0; i<N; i++)
	        {
	            if(!set.contains(arr[i]-1))
	            {
	                int j = arr[i];
	                while(set.contains(j))
	                    j++;
	               
	                ans = Math.max(ans, j-arr[i]);
	            }
	        }
            System.out.println(ans);
	    }
	}
}