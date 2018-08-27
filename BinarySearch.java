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
	public static boolean bs_iteration(int array[], int to_find)
	{
		int left =0;
		int right = array.length-1;

		while(left <=right)
		{
			int mid = left+ ((right-left)/2);

			if(array[mid] == to_find)
			{
				return true;
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

		return false;
	}

	public static void main(String args[])
	{
		int arr[] = {1,3,4,8,9,12,15};

		Arrays.sort(arr);
		int i = 0;
		// if(bs_recursion(arr, 0, arr.length-1, 15))
		// {
		// 	i =1;
		// }

		if(bs_iteration(arr, 115))
		{
			i =1;
		}

		System.out.println(i);
	}
}