import java.util.*;
import java.io.*;

class countRotation
{
	public int count(int arr[])
	{
		int N = arr.length;

		int low = 0;
		int high = N -1;

		while(low <= high)
		{
			int mid = low + (high-low)/2;
			int next = (mid+1)%N;
			int prev = (mid+N-1)%N;

			if(arr[low]<=arr[high])
			{
				return low;
			}
			else if(arr[mid]<=arr[next] && arr[mid]<=arr[prev])
			{
				return mid;
			}
			else if(arr[mid] <= arr[high]) //array is sorted from mid to high
			{
				high = mid-1;
			}
			else if(arr[mid] >= arr[low]) //array is sorted from low to mid
			{
				low = mid + 1;
			}			
		}

		return 0;
	}

	public static void main(String[] args) 
	{
		int arr[] = {45,57,61,74,8,10,29,33}; //the array must be sorted before rotating
		System.out.println("Given array is: " + Arrays.toString(arr));

		countRotation cr = new countRotation();
		int countofRotation = cr.count(arr);
		System.out.println("The number of times array is rotated is: " + countofRotation);
	}
}