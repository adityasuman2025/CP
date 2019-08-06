import java.util.*;
import java.io.*;

public class SelectionSortNew
{
	public static void main(String args[])
	{
		int arr[] = {9,78,52,2,15,0,32, 2, 100, 11, 71};

		System.out.println("Given array is: " + Arrays.toString(arr));

		for(int i = 0; i < arr.length - 1; i++)
		{
			int min_index = i;
			int min = arr[i];

			for(int j = i+1; j< arr.length; j++)
			{
				if(arr[j]<min)
				{
					min_index = j;
					min = arr[j];
				}
			}

		//swapping
			int temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
		}

		System.out.println("Sorted array is: " + Arrays.toString(arr));
	}
}