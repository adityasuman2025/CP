import java.util.*;

class removeKInArray
{
	public static void main(String[] args) 
	{
		int arr[] = {1,2,2,6,8,5,2,3,10,2};
		int N = arr.length;

		int K = 2;

		int count = 0; // to record count of K
		for(int i=0; i<N; i++)
		{
			if(arr[i] == 2)
			{
				count++;

				int shift = 1;
				for(int j=i; j<N-shift-1; j++)
				{
					if(arr[j+shift]==2)
					{
						count++;
						shift++;
					}
					arr[j]  = arr[j+shift];
				}
				//i=0;
			}
		}

		System.out.println(count);
		for(int i = N-1; count>0; i--, count--)
		{
			arr[i] = 1;
		}
		System.out.println(Arrays.toString(arr));
	}
}