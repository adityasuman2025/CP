import java.util.*;
import java.io.*;

class LongestIncSubSeqNew
{
	static void LIS(int arr[])
	{
		int n = arr.length;

		int dp[] = new int[n];
		for(int i =0; i<n; i++)
		{
			dp[i] =1;
		}

		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[i]>arr[j])
				{
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(dp));

		int maxCount = dp[0];
		int maxCountIndex = 0;
		for(int i=n-1; i>=0; i--)
		{
			if(dp[i]>maxCount)
			{
				maxCount = dp[i];
				maxCountIndex = i;
			}
		}
		System.out.println("length of longest subsequence: " + maxCount);

		ArrayList<Integer> subSeq = new ArrayList<>();
		int max = maxCount;
		int prevMax = arr[maxCountIndex];
		for(int i = maxCountIndex; i>=0; i--)
		{
			if(dp[i]==max && arr[i]<=prevMax)
			{
				prevMax = arr[i];
				subSeq.add(arr[i]);
				max--;
			}
		}
		Collections.reverse(subSeq);

		System.out.println(subSeq);
	}

	public static void main(String[] args) 
	{
		int arr[] = {10,1,9,15,2,35,40,7,11,3,8,4,51,5};
		LIS(arr);	
	}
}