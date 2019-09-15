import java.util.*;
import java.io.*;

/*
Trapping Rain Water
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.



Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains an integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.
*/

class TrappingRainWater
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
            int result = 0; 
        
        //method 1   
            // maximum element on left and right 
            int left_max = 0, right_max = 0; 
               
            // indices to traverse the array 
            int lo = 0, hi = N-1; 
               
            while(lo <= hi)  
            { 
                if(arr[lo] < arr[hi]) 
                { 
                    if(arr[lo] > left_max)           
                        left_max = arr[lo]; // update max in left 
                    else          
                        result += left_max - arr[lo];                     
                    lo++; 
                } 
                else
                { 
                    if(arr[hi] > right_max)                       
                        right_max = arr[hi]; // update right maximum                       
                    else
                        result += right_max - arr[hi]; 
                    hi--; 
                } 
            } 
               
            System.out.println(result);
	    }
	}
}