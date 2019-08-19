import java.io.*;
import java.util.*;

class countOfElement
{
	public static int bs(int arr[], int start, int end, int to_find, boolean searchFirst)
	{
		int result = -1;		

		while(start<=end)
		{
			int mid = start + (end-start)/2;

			if(to_find == arr[mid])
			{
				result = mid;

				if(searchFirst) //searching for first index;
				{
					end = mid-1;
				}
				else
				{
					start = mid+1;
				}			
			}
			else if(to_find<arr[mid])
			{
				end = mid-1;
			}
			else
			{
				start = mid+1;
			}
		}		

		return result;
	}

	public static int count(int arr[], int to_find)
	{
		int n = arr.length;

		int firstIndex = bs(arr, 0, n-1, to_find, true);
        int lastIndex = bs(arr, 0, n-1, to_find, false);	
    
		if(firstIndex != -1 && lastIndex != -1)
		{
		    return lastIndex-firstIndex+1;
		}
		else
		{
		    return -1;
		}
	}

	public static void main(String[] args) 
	{
		int arr[] = {9,52,52,52,2,0,52, 2, 100, 71, 71};
		Arrays.sort(arr);
		System.out.println("Given array is: " + Arrays.toString(arr));	

		int to_find = 10;
		System.out.println("Count of " + to_find +" is: " + count(arr, to_find));	
	}
}