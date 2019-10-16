import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/zero-sum-subarrays/0/?ref=self

Zero Sum Subarrays
You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0

Input:
First line of the input contains an integer T denoting the number of test cases. Each test case consists of two lines. First line of each test case contains an Integer N denoting the size of the array, and the second line contains N space separated integers.

Output:
For each test case, in a new line, print the total number of subarrays whose sum is equal to 0.

Constraints:    
1 <= T <= 100
1<= N <= 107
-1010 <= Ai <= 1010

Example:
Input:
2
6
0 0 5 5 0 0
10
6  -1 -3 4 -2 2 4 6 -12 -7

Output:
6
4
*/

class CountZeroSumSubarrays
{
    static Scanner scanner = new Scanner(System.in);
    
    public static void main (String[] args) throws Exception
	{
	    int T = scanner.nextInt();
	    for(int t=0; t<T; t++)
	    {
	        int N = scanner.nextInt();
	        
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = scanner.nextInt();
            }
            
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            
            int sum = 0;
            int c = 0;
            for(int i=0; i<N; i++)
            {
                sum+=arr[i];
                
                if(sum == 0)
                    c++;
                if(map.containsKey(sum)) //if that sum has already been found that means elements after that sums to zero thats why again that sum is reached
                {
                    int val = map.get(sum);
                    c+=val;
                    
                    map.put(sum, val+1);
                }
                else
                {
                    map.put(sum, 1);
                }
            }
            
           // System.out.println(map);
            System.out.println(c);
	    }
	}
}