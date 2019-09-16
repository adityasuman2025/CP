import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array/0/?ref=self

Move all zeroes to end of array
Given an array A of positive integers. Push all the zero’s of a given array to the end of the array.

Input:
The first line contains an integer T denoting the total number of test cases. In each test cases, first line is number of elements in array N and next line contains array elements.

Output:
Print the array after shifting all 0's at the end.​

Constraints:
1 <= T <= 100
1 <= N <= 103
0 <= Ai <=103

Example:
Input:
1
5
3 5 0 0 4

Output:
3 5 4 0 0

Explanation:
Testcase 1: All the zeros are moved to last and then array is as shown in the output.
*/

class Shift0ToEnd
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
            
            int count = 0;
            for(int i=0; i<N; i++)
            {
                if(arr[i] != 0)
                {
                    arr[count] = arr[i];
                    count++;
                }
            }
            
            while(count<N)
            {
                arr[count] = 0;
                count++;
            }
            
            for(int i=0; i<N; i++)
	        {
	            System.out.print(arr[i] + " ");    
	        }
	        System.out.println();
	    }
	}
}