import java.util.*;
import java.io.*;

class EditDistanceNew
{
	static void editDistance(String a, String b)
	{
		int N = a.length();
		int M = b.length();

		int dp[][] = new int[N+1][M+1];

		for(int i=0; i<=N; i++)
		{
			for(int j=0; j<=M; j++)
			{
				if(i==0)
				{
					dp[i][j] = j;
				}
				else if(j==0)
				{
					dp[i][j] = i;
				}
				else if(a.charAt(i-1) == b.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
					dp[i][j] = Math.min(min, dp[i][j-1]) + 1;
				}
			}	
		}

		System.out.println(dp[N][M]);
	}

	public static void main(String[] args) 
	{
		editDistance("abcgdf", "gaebcdk");
	}
}