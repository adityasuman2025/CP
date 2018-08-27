public class QuickSort
{
	public static void quick_sort(int arr[], int start, int end)
	{
		if(start < end)
		{
			int pIndex = partition(arr, start, end);
			quick_sort(arr, start, pIndex-1);
			quick_sort(arr, pIndex+1, end);
		}
	}

	public static int partition(int arr[], int start, int end)
	{	
		int pivot = arr[end];
		int pIndex = start;

		for(int i= start; i<end; i++)
		{
			if(arr[i]<=pivot)
			{
				int temp = arr[pIndex];
				arr[pIndex] = arr[i];
				arr[i] = temp;

				pIndex++;
			}
		}

		int temp_end = arr[end];
		arr[end] = arr[pIndex];
		arr[pIndex] = temp_end;

		return pIndex;
	}	

	public static void main(String args[])
	{
	//creating and printing the initial array
		int arr[] = {1,9,5,0,4,8,11,89,6,7,500,3,13};

        for(int k: arr)
        {
            System.out.print(k + ", ");
        }
        System.out.println("");

    //sorting the array and displaying it
       quick_sort(arr, 0, 12);

        for(int k: arr)
        {
            System.out.print(k + ", ");
        }
	}
}