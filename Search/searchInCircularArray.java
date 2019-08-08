import java.util.*;
import java.io.*;

class searchInCircularArray
{
	static int searchElement(int arr[], int to_find)
	{
		int N = arr.length;

		int low = 0;
		int high = N-1;

		while(low<=high)
		{
			int mid = low + (high-low)/2;

			if(to_find == arr[mid])
			{
				return mid;
			}
			else if(arr[mid] >= arr[low]) //array is sorted from low to mid
			{
				if(to_find>=arr[low] && to_find <=arr[mid])
				{
					high = mid -1;
				}
				else
				{
					low = mid +1;
				}
			}
			else if(arr[mid] <= arr[high]) //array is sorted from mid to high
			{
				if(to_find>=arr[mid] && to_find<=arr[high])
				{
					low = mid +1;
				}
				else
				{
					high = mid -1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) 
	{
		int arr[] = {45,57,61,74,8,10,29,33}; //the array must be sorted before rotating
		System.out.println("Given array is: " + Arrays.toString(arr));

		int to_find = 33;
		int index = searchElement(arr, to_find);
		System.out.println(to_find + " is present in the array at index: " + index);	
	}
}