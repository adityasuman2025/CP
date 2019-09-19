import java.util.*;
import java.io.*;
/*
https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix/0

Median In a Row-Wise sorted Matrix
We are given a row wise sorted matrix of size r*c, we need to find the median of the matrix given. It is assumed that r*c is always odd.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains two integers r and c, where r is the number of rows and c is the number of columns in the array a[]. Next r line contains space separated c elements each in the array a[].​

Output:
Print an integer which is the median of the matrix.

Constraints:
1<= T <=100
1<= r,c <=150
1<= a[i][j] <=1000

Example:
Input:
1
3 3
1 3 5
2 6 9
3 6 9

Output:
5

Solution:

1. First we find the minimum and maximum elements in the matrix. Minimum element can be easily found by comparing the first element of each row, and similarly the maximum element can be found by comparing the last element of each row.
2. Then we use binary search on our range of numbers from minimum to maximum, we find the mid of the min and max, and get count of numbers less than our mid. And accordingly change the min or max.
3. For a number to be median, there should be (r*c)/2 numbers smaller than that number. So for every number, we get the count of numbers less than that by using upper_bound() in each row of matrix, if it is less than the required count, the median must be greater than the selected number, else the median must be less than or equal to the selected number.

*/

class MedianInSortedMatrix
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) throws Exception
	{
	    int T = sc.nextInt();
	    for(int t=0; t<T; t++)
	    {
	        //String input[] = bf.readLine().split(" ");
	        int R = sc.nextInt();
	        int C = sc.nextInt();
	        
	        int arr[][] = new int[R][C];
	        for(int i=0; i<R; i++)
	        {
	            for(int j=0; j<C; j++)
	            {
	                arr[i][j] = (sc.nextInt());   
	            }
            }
            
            int ans = getMedian(arr, R, C);
            System.out.println(ans);
	    }
	}
	
	static int getMedian(int arr[][], int R, int C)
	{
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    
	    for(int i=0; i<R; i++)
	    {
	        min = Math.min(min, arr[i][0]);
	        max = Math.max(max, arr[i][C-1]);
	    }
	    
	    int desiredCount = (R*C+1)/2; //median should have desiredCount no of elements less than it
	    // +1 becoz given R*C is odd
	    
	    while(min < max) //biary search
	    {
	        int mid = min + (max-min)/2;
	        
	        int count = 0; //to store count of elements having value less than mid
	        for(int i=0; i<R; i++)
	        {
	            int index = Arrays.binarySearch(arr[i], mid);
	            
	            //If element is not found in the array the binarySearch() method returns  
                // (-(insertion_point) - 1). So once we know  
                // the insertion point we can find elements 
                // Smaller than the searched element by the  
                // following calculation 
	            if(index<0)
	                index = Math.abs(index) -1;
	            else //if element found then we will go to last index of that elemeent in case if its duplicate exits
	            {
	                while(index<C && arr[i][index]==mid)
	                {
	                    index++;
	                }
	            }
	            
	            count += index;
	        }
	        
	        if(count<desiredCount)
	            min = mid+1;
	        else
	            max=mid;
	    }
	    
	    return min;
	}
}