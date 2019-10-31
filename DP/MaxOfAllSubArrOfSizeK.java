import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0

Maximum of all subarrays of size k
Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.
*/

class MaxOfAllSubArrOfSizeK
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String input[] = bf.readLine().split(" ");
	        int N = Integer.parseInt(input[0]);
	        int K = Integer.parseInt(input[1]);
	        
	        String str[] = bf.readLine().split(" ");
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
            }
            
            int left[] = new int[N];
            for(int i=0; i<N; i++)
	        {
	            if(i % K == 0) // that means START of a block
                    left[i] = arr[i];
                else
                    left[i] = Math.max(left[i - 1], arr[i]);        
            }
            
            int right[] = new int[N];
            for(int i=N-1; i>=0; i--)
	        {
	            if(i == N-1) // Maybe the last block is not of size 'W'. 
                    right[i] = arr[i]; 
	            else if(i % K == K-1) // that means END of a block
                    right[i] = arr[i];
                else
                    right[i] = Math.max(right[i + 1], arr[i]);        
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< N-K+1; i++)
            {
                int max = Math.max(right[i], left[i+K-1]);
                sb.append(max + " ");
            }
            
            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));
            
            System.out.println(sb.toString());
	    }
	}
}