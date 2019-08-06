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
		
	}

	public static void main(String[] args) 
	{
		int arr[] = {9,78,52,2,15,0,32, 2, 100, 11, 71};
		System.out.println("Given array is: " + Arrays.toString(arr));	

		quickSort(arr, 0, arr.length-1);
		System.out.println("Sorted array is: " + Arrays.toString(arr));	
	}
}