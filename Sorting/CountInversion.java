import java.util.Scanner;

public class CountInversion
{
	public long count = 0;

	public long countInversions()
    {
        return count;
    }

//method 1 O(nlogn)
	public void merge_sort(int arr[])
	{
		int arr_length = arr.length;

		if(arr_length <2) //if array is too short then doing nothing
		{
			return;
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
	}

	public void merge(int left[], int right[], int arr[])
	{
		int left_length = left.length;
		int right_length = right.length;
		int arr_length = arr.length;

		int i=0, j=0, k=0;

		int mid = left_length;
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

				count += left_length - i;
			}

			k++;
		}

		while(i< left_length)
		{
			arr[k] = left[i];
			i++;
			k++;

			//count++;
		}

		while(j< right_length)
		{
			arr[k] = right[j];
			j++;
			k++;

			//count++;
		}
	}

//method 2 O(n2)
	int bubbleSort(int arr[])
	{
		count = 0;

		for(int i=0; i<N; i++)
        {
            int flag = 0;
            for(int j = 0; j<N-i-1; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    flag = 1;
                //swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }
            }
            
            if(flag == 0)
			    break;
        }

        return count;
	}

	public static void main(String[] args) 
    {
       	int arr[] = {87, 78, 16, 94};
        
        CountInversion c = new CountInversion();

        c.merge_sort(arr);
        System.out.println(c.countInversions());
    }
}