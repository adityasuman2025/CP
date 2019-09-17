import java.util.*;
import java.io.*;

class SquareSumPair
{
	public static void main(String[] args)
	{
		int arr[] = {0, 3, 4, 5, 9, 12, 6};
		int N = arr.length;

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++)
		{
			arr[i] *= arr[i];			
		}

		int flag = 1;
		for(int i=0; i<N; i++)
		{
			for(int j=i+1; j<N; j++)
			{
				int num = arr[i]+arr[j];
				if(map.containsKey(num))
				{
					flag = 0;				
					System.out.println(num);

					break;
				}
				else
					map.put(num, 1);
			}

			if(flag == 0)
				break;
		}

		// System.out.println(map);
		// System.out.println(Arrays.toString(arr));
	}
}