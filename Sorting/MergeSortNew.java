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

	static void iterativeMergeSort(int arr[])
	{
		int n = arr.length;

		for(int curr_size = 1; curr_size <n; curr_size = 2*curr_size)
		{
			for(int left = 0; left<n-1; left += 2*curr_size)
			{
				int mid = Math.min(left + curr_size - 1, n-1);

				int right = Math.min(left + 2*curr_size - 1, n-1);

				int n1 = mid-left+1; 
        		int n2 = right-mid; 
				int l[] = new int[n1];
				int r[] = new int[n2];

				for(int i=0; i<n1; i++)
				{
					l[i] = arr[left + i];
				}

				for(int i=0; i<n2; i++)
				{
					r[i] = arr[mid+1+i];
				}

				merge(l, r, arr);
			}
		}
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

		iterativeMergeSort(arr);
		System.out.println("Sorted array is: " + Arrays.toString(arr));
	}
}