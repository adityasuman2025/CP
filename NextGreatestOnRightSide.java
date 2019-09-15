import java.util.*;

class NextGreatestOnRightSide
{
	public static void main(String[] args) 
	{
		int arr[] = {4, 10, 7}; 
        int N = arr.length; 

        solve(arr, N);
	}

	static void solve(int arr[], int N)
	{
		TreeSet<Integer> set = new TreeSet<>();

		for(int i=0; i<N; i++)
			set.add(arr[i]);

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++)
		{
			int temp = arr[i];

			//higher function of treeset returns next greater element to an element
			if(set.higher(arr[i]) == null) //no element greater than arr[i] find in the set
				sb.append("-1 ");
			else
				sb.append(set.higher(arr[i]) + " "); //printing next greatest element present in right side of arr[i]

			set.remove(arr[i]);
		}

		System.out.println(sb.toString());
	}
}