public class MergeSort
{
	public static int[] merge_sort(int arr[])
	{
		int arr_length = arr.length;

		if(arr_length <2) //if array is too short then doing nothing
		{
			return arr;
		}	
	
		int mid = (arr_length)/2;
		int left[] = new int[mid];
		int right[] = new int[arr_length-mid];

		for(int i=0; i<mid; i++)
		{
			left[i] = arr[i];
		}

		for(int i=mid; i<arr_length; i++)
		{
			right[i-mid] = arr[i];
		}

		merge_sort(left);
		merge_sort(right);
		merge(left, right, arr);			

		return arr;
	}

	public static void merge(int left[], int right[], int arr[])
	{
		int left_length = left.length;
		int right_length = right.length;
		int arr_length = arr.length;

		int i=0, j=0, k=0;

		while(i<left_length && j<right_length)
		{
			if(left[i]<=right[j])
			{
				arr[k] = left[i];
				i++;
			}
			else
			{
				arr[k] = right[j];
				j++;
			}

			k++;
		}

		while(i< left_length)
		{
			arr[k] = left[i];
			i++;
			k++;
		}

		while(j< right_length)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
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
        int arr2[] = merge_sort(arr);

        for(int k: arr2)
        {
            System.out.print(k + ", ");
        }
        
	}
}