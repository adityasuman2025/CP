import java.util.*;

public class jumpSearch
{
	static int JS(int arr[], int x)
	{
		int n = arr.length;

		int step = (int)Math.floor(Math.sqrt(n));
		int prev = 0;
		int next = step;

	//searching for the block just greater than the the given number
		while(x>arr[Math.min(next, n) -1])
		{
			prev = next;
			next += step;

			if(prev>=n)
			{
				return -1;
			}
		}

	//searching for x in that block
		while(x>arr[prev])
		{
			prev++;

			if(prev>= Math.min(next,n))
			{
				return -1;
			}
		}

	// if that element is found
		if(arr[prev] == x)
			return prev;
		else
			return -1;
	}

	public static void main(String[] args) 
	{
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
		int x = 11;

		System.out.println(JS(arr,x));
	}
}