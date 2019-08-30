import java.util.*;

class LongestPalindSubStringNew
{
	public static void main(String[] args) {
		longest("geek");
	}

	static void longest(String input)
	{
		int n = input.length();

		if(n<=0)
			return;

		boolean dp[][] = new boolean[n][n];

		for(int i=0; i<n; i++)
			dp[i][i] = true;

		int start = 0;
		int maxLen = 1;

	//checking palindrome of length 2	
		for(int i=0; i<n-1; i++)
		{
			int j = i+1;
			if(input.charAt(i)==input.charAt(j))
			{
				dp[i][j] = true;
				start = i;
				maxLen = 2;
			}
		}

	//checking palindrome of length greater than 2
		for(int k=3; k<=n; k++)
		{
			for(int i=0; i<n-k+1; i++)
			{
				int j = i+k-1;
				if(input.charAt(i)==input.charAt(j) && dp[i+1][j-1])
				{
					dp[i][j] = true;

					if(k>maxLen)
					{
						start = i;
						maxLen = k;
					}					
				}
			}
		}

		for(boolean item[]: dp)
			System.out.println(Arrays.toString(item));

		System.out.println(input.substring(start, start+maxLen));
	}
}