public class FriendPairPrblm
{
	public static void countPair(int n)
	{
		int dp[] = new int[n+1];

		for(int i=0; i<=n; i++)
		{
			if(i<=2)
			{
				dp[i] = i;
			}
			else
			{
				dp[i] = dp[i-1] + (i-1)*dp[i-2];
			}
		}

		System.out.println(dp[n]);
	}

	public static void main(String[] args) 
	{
		countPair(3);
	}
}