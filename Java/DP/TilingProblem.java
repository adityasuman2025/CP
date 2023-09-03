import java.util.*;

public class TilingProblem 
{
	static int ways(int n)
	{
		if(n ==1)
			return 1;
		if(n==2)
			return 2;

		return ways(n-2) + ways(n-1);
	}

	static int waysDP(int n) //modified fibonacci series //here first number of series is considered 1 but not 0
	{
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;

		for(int i=3; i<=n; i++)
		{
			dp[i] = dp[i-1]+dp[i-2];
		}

		return dp[n];
	}

	public static void main(String[] args) 
	{
		int ans = waysDP(4);
		System.out.println(ans);
	}	
}