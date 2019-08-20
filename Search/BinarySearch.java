import java.io.*;
import java.util.*;

public class BinarySearch
{
//binary search using recursion
	public static boolean bs_recursion(int array[], int left, int right, int to_find)
	{
		if(left>right)
		{
			return false;
		}

		int mid = left+ ((right-left)/2);

		if(array[mid] == to_find)
		{
			return true;
		}
		else if(to_find < array[mid])
		{
			return bs_recursion(array, left, mid-1, to_find);
		}
		else
		{
			return bs_recursion(array, mid+1, right, to_find);
		}
	}

//binary search using iteration
	public static int bs_iteration(int array[], int to_find)
	{
		int left =0;
		int right = array.length-1;

		while(left <=right)
		{
			int mid = left+ ((right-left)/2);

			if(array[mid] == to_find)
			{
				return mid;
			}
			else if(to_find < array[mid])
			{
				right = mid -1;
			}	
			else
			{
				left = mid +1;
			}
		}

		return -1;
	}

	public static void main(String args[])
	{
		int arr[] = {10,40,20};

		Arrays.sort(arr);		
	
		System.out.println(bs_iteration(arr, 20));
	}
}