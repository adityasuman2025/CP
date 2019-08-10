import java.util.*;

class randomisedQuickSort
{
	static void iterativeQuickSort(int arr[], int l, int h)
	{
		if(l>=h)
			return;

	// Create an auxiliary stack and initialize top of stack 
		int stack[] = new int[h-l+1];
		int top = -1;

	// push initial values of l and h to stack 	
		stack[++top] = l;
		stack[++top] = h;

		while(top >= 0)
		{
			h = stack[top--];
			l = stack[top--];

			int p = randomPartition(arr, l, h);

		// If there are elements on left side of pivot, 
        // then push left side to stack 
			if(p-1>l)
			{
				stack[++top] = l;
				stack[++top] = p-1;
			}


        // If there are elements on right side of pivot, 
        // then push right side to stack 
	        if (p + 1 < h)
	        { 
	            stack[++top] = p + 1; 
	            stack[++top] = h; 
	        } 
		}
	}

	static void quickSort(int arr[], int start, int end)
	{
		if(start>=end)
			return;

		int pIndex = randomPartition(arr, start, end);

		quickSort(arr, start, pIndex-1);
		quickSort(arr, pIndex+1, end);
	}

	static int randomPartition(int arr[], int start, int end) //to avoid worst case of quick sort (n square)
	{
		int pivotIndex = (int)(Math.random()*(end - start + 1)) + start;
		int temp = arr[end];
		arr[end] = arr[pivotIndex];
		arr[pivotIndex] = temp;

		return partition(arr, start, end);
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

		iterativeQuickSort(arr, 0, arr.length-1);
		System.out.println("Sorted array is: " + Arrays.toString(arr));	
	}
}