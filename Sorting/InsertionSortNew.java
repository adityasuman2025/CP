import java.io.*;
import java.util.*;

class InsertionSortNew
{
	static int[] insertionSort(int arr[])
	{
		int n = arr.length;

		for(int i=1; i<n; i++)
		{
			int val = arr[i];
			int hole_index = i;

			// for(int j=hole_index-1; j>=0; j--)
			// {
			// 	if(val<arr[j])
			// 	{
			// 		int temp = arr[j];
			// 		arr[j] = val;
			// 		arr[j+1] = temp;
			// 	}
			// }

			while(hole_index>0 && val<arr[hole_index - 1])
			{
				int temp = arr[hole_index -1];
				arr[hole_index-1] = arr[hole_index];
				arr[hole_index] = temp;

				hole_index--;
			}
		}

		return arr;
	}

	public static void main(String[] args) 
	{
		int arr[] = {9,78,52,2,15,0,1, 2, 100, 11, 71};
		System.out.println("Given array is: " + Arrays.toString(arr));	

		int res[] = insertionSort(arr);
		System.out.println("Sorted array is: " + Arrays.toString(res));
	}
}