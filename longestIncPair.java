import java.util.*;

public class longestIncPair 
{
	public static void incPair(int arr[][])
	{
		int n = arr.length;

		int L[] = new int[n];

		for(int i=0; i<n; i++)
		{
			L[i] = 1;
		}

		for(int i=0; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[i][0]>arr[j][1] && L[j]+1 > L[i])
				{
					L[i] = L[j] + 1;
				}
			}
		}

		System.out.println(Arrays.toString(L));
		Arrays.sort(L);
		int max_count = L[n -1];

		System.out.println("Maximum length of increasing pair subsequence: " + max_count);
	}

	public static void main(String[] args) 
	{
		int pair[][] = {{5,24}, {15, 25}, {27, 40}, {50,60}};

		incPair(pair);
	}	
}