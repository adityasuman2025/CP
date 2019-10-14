import java.util.*;
import java.io.*;

/*

https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number/0

Smallest Positive missing number
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.

Output:
Single line output, print the smallest positive number missing.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
*/

class SmallestPositiveMissingNum
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
            
            int nextval;
            for(int i=0; i<N; i++)
	        {
	            int val = arr[i];
	            if(val<=0 || val>N)
	                continue;
	                
	        //making arr val at index i equal to  i+1 (0 base indexing)
	        //We make the value at index corresponding to given array element equal to array element.    
	            while (arr[val - 1] != val) 
	            { 
                    nextval = arr[val - 1]; 
                    arr[val - 1] = val; 
                    val = nextval; 
                    if (val <= 0 || val > N) 
                        break; 
                } 
	        }
	        
	        int flag = 0;
	        for (int i = 0; i < N; i++) 
	        { 
                if (arr[i] != i + 1) 
                { 
                    System.out.println(i + 1); 
                    flag = 1;
                    break;
                } 
            } 
            
            if(flag == 0)
	            System.out.println(N+1);
	    }
	}
}