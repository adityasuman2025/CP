import java.util.*;

public class largestSumSubArray
{
	public static void LSSA(int arr[])
	{
		int maxSoFar = arr[0];
		int currMax = arr[0];

		for(int i =1; i<arr.length; i++)
		{
			currMax = Math.max(arr[i], currMax+arr[i]);
			maxSoFar = Math.max(maxSoFar, currMax);
		}

		System.out.println(maxSoFar);
	}

	public static void main(String[] args) {
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};		
		LSSA(arr);	
	}	
}