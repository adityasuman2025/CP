import java.util.*;
import java.io.*;

class searchInCircularArray
{
	static int searchElement(int arr[], int to_find)
	{
		int N = arr.length;

		int low = 0;
		int high = N-1;

		while(low<=high)
		{
			
		}
	}

	public static void main(String[] args) 
	{
		int arr[] = {45,57,61,74,8,10,29,33}; //the array must be sorted before rotating
		System.out.println("Given array is: " + Arrays.toString(arr));

		int to_find = 10;
		int index = searchElement(arr, to_find);
		System.out.println(index + " is present in the array at index: " + index);	
	}
}