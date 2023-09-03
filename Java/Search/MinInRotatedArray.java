import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array/0

Minimum element in a sorted and rotated array
A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

Expected Time Complexity: O(Log n)

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines. The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements.

Output:
Corresponding to each test case, in a new line, print the minimum element in the array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 500
1 ≤ A[i] ≤ 1000

Example:

Input
2
5
4 5 1 2 3
6
10 20 30 40 50 5 7

Output
1
5
*/

class MinInRotatedArray
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = Integer.parseInt(bf.readLine());
	        String str[] = bf.readLine().split(" ");
	        
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
            }
            
            System.out.println(findMin(arr));
	    }
	}
	
	static int findMin(int arr[])
	{
	    int N = arr.length;
	    
	    int low = 0;
	    int high = N-1;
	    
	    while(low<=high)
	    {
	        int mid = (low+high)/2;
	        
	        int prev = (mid-1+N)%N;
	        int next = (mid+1)%N;
	        
	        if(arr[low]<=arr[high])
	            return arr[low];
	        else if(arr[mid]<=arr[prev] && arr[mid]<=arr[next])
	            return arr[mid];
	        else if(arr[mid]<=arr[high])
    	        high = mid-1;
    	    else if(arr[mid]>=arr[low])
    	        low = mid+1;
	    }
	    
	    return arr[0];
	}
}