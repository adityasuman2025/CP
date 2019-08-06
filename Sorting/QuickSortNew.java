import java.util.*;

class QuickSortNew
{
	static void quickSort(int arr[], int start, int end)
	{
		if(start>=end)
			return;

		int pIndex = partition(arr, start, end);

		quickSort(arr, start, pIndex-1);
		quickSort(arr, pIndex+1, end);
	}

	static int partition(int arr[], int start, int end)
	{
		int pivot = arr[end];
		int pIndex = start;

		for(int i=start; i<end; i++)
		{
			if(arr[i]<pivot)
			{
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;

				pIndex++;
			}
		}

	//swapping pivot & element at pInedx
		int temp = arr[end]; //pivot
		arr[end] = arr[pIndex];
		arr[pIndex] = temp;

		return pIndex;
	}

	public static void main(String[] args) 
	{
		int arr[] = {9,78,52,15,23,0,32, 2, 100, 81, 23};
		System.out.println("Given array is: " + Arrays.toString(arr));	

		quickSort(arr, 0, arr.length-1);
		System.out.println("Sorted array is: " + Arrays.toString(arr));	
	}
}