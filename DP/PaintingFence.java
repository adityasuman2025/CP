class PaintingFence
{
	static long countWays(int n, int k) // n = no of posts to paint, // k = no of different colors
	{
		long dp[] = new long[n+1];
		dp[1] = (long)k;

		long same = 0, diff = k;

		for(int i=2; i<=n; i++)
		{
			same = diff;
			diff = dp[i-1]*(k-1);
			dp[i] = same + diff;
		}

		return dp[n];
	}

	public static void main(String[] args)
	{		
		System.out.println(countWays(2, 2));
	}	
}