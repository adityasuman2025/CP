import java.util.*;
import java.io.*;

/*
Subarray with given sum
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation : 
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15
*/

class SlidingWindowTechnique
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        String input[] = (bf.readLine().split(" "));
	        int N = Integer.parseInt(input[0]);
	        int S = Integer.parseInt(input[1]);
	        
	        String str[] = bf.readLine().split(" ");
	        
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
            }
            
            solve(arr, S);
	    }
	}
	
	static void solve(int arr[], int S)
	{
	    int N = arr.length;
	    
	    int ptr1=0, ptr2 = 0;
	   
        int sum = 0;
        for(int i=0; i<N; i++)
        {
            if(sum+arr[i]==S)
            {
                ptr2++;
                System.out.println((ptr1+1) + " " + (ptr2));
                return;
            }
            else if(sum+arr[i] < S)
            {
                ptr2++;
                sum+=arr[i];
            }
            else //(sum+arr[i] > S)
            {
                ptr2++;
                sum+=arr[i];
                
                while(sum>S && ptr1<i)
                {
                    sum-=arr[ptr1];
                    ptr1++;
                }
                
                if(sum==S)
                {
                    System.out.println((ptr1+1) + " " + ptr2);
                    return;
                }
            }
        }
        
        System.out.println("-1");
	}
}