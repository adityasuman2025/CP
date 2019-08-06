import java.util.*;

class MergeSortNew
{
	static void mergeSort(int arr[])
	{
		int n = arr.length;

		if(n<2)
			return;

		int mid = n/2;
		int left[] = new int[mid];
		int right[] = new int[n-mid];

		for(int i=0; i<mid; i++)
		{
			left[i] = arr[i];
		}

		for(int i=mid; i<n; i++)
		{
			right[i-mid] = arr[i];
		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}

	static void merge(int left[], int right[], int arr[])
	{
		int l=0,r=0,a=0;

		int left_size = left.length;
		int right_size = right.length;

		while(l<left_size && r<right_size)
		{
			if(left[l]<right[r])
			{
				arr[a] = left[l];
				l++;
			}
			else
			{
				arr[a] = right[r];
				r++;
			}
			a++;
		}

		while(l<left_size)
		{
			arr[a] = left[l];
			l++;
			a++;
		}

		while(r<right_size)
		{
			arr[a] = right[r];
			r++;
			a++;
		}
	}

	public static void main(String[] args) 
	{
		int arr[] = {9,78,52,2,15,0,32, 2, 100, 11, 71};
		System.out.println("Given array is: " + Arrays.toString(arr));	

		mergeSort(arr);
		System.out.println("Sorted array is: " + Arrays.toString(arr));
	}
}