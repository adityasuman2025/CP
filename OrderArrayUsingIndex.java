import java.util.*;

class OrderArrayUsingIndex
{
	public static void main(String[] args) 
	{
		int arr[] = {50, 40, 70, 60, 90};
		int index[] = {3,  0,  4,  1,  2};

		int N = index.length;

		int res[] = new int[N];
		for(int i=0; i<N; i++)
		{
			int j = index[i];
			index[j] = j;
			int temp = arr[j];

			//res[j] = temp;
			arr[j] = arr[i];
			arr[i] = temp;
		}

		System.out.println(Arrays.toString(arr));
	}

}