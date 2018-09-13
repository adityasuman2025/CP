import java.util.*;

public class largestSumSubArray
{
	public static void LSSA(int arr[])
	{
		int max = arr[0];
		int temp_max = arr[0];

		for(int i =1; i<arr.length; i++)
		{
			temp_max = Math.max(arr[i], temp_max+arr[i]);
			max = Math.max(max, temp_max);
		}

		System.out.println(max);
	}

	public static void main(String[] args) {
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};		
		LSSA(arr);	
	}	
}