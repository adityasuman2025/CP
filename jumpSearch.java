import java.util.*;

public class jumpSearch
{
	public static void main(String[] args) 
	{
		int ans = -1;

		int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
		int n = arr.length;
		int step = (int)Math.floor(Math.sqrt(n));
		int prev = 0;

		int x = 8;
		
	//searching for the block just greater than the the given number
		while(x > arr[Math.min(step, n)-1])
		{
			prev = step;
			step += (int)Math.floor(Math.sqrt(n));

			if(prev >=n)
			{
				ans = -1;
			}
		}	

	//doing linear search in that block area
		while(x > arr[prev])
		{
			prev++;

			if(prev == Math.min(step, n))
			{
				ans = -1;
			}
		}

	// if that element is found
		if(arr[prev] == x)
		{
			ans =  prev;
		}

		System.out.println(ans);
	}
}