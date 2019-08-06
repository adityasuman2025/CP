import java.io.*;
import java.util.*;

class BubbleSortNew
{
	public int[] bubbleSort(int arr[])
	{
		int n = arr.length;

		for(int i=0; i<n; i++)
		{
			int flag = 0;

			for(int j=0; j<n-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

					flag = 1;
				}
			}

			if(flag == 0)
				break;
		}

		return arr;
	}

	public static void main(String[] args) 
	{
		int arr[] = {9,78,52,2,15,0,32, 2, 100, 11, 71};
		System.out.println("Given array is: " + Arrays.toString(arr));

		BubbleSortNew b = new BubbleSortNew();

		int res[] = b.bubbleSort(arr);
		System.out.println("Sorted array is: " + Arrays.toString(res));
	}
}