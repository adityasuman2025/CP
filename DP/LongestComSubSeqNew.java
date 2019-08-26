import java.util.*;
import java.io.*;

class LongestComSubSeqNew
{
	public static void main(String[] args) 
	{
		LCS("abcgdf", "gaebcdk");
	}

	static void LCS(String a, String b)
	{
	//to find max length of common sub sequence
		int M = a.length();
		int N = b.length();

		int L[][] = new int[M+1][N+1];

		for(int i=0; i<=M; i++)
		{
			for(int j=0; j<=N; j++)
			{
				if(i==0 || j==0)
					L[i][j] = 0;
				else if(a.charAt(i-1) == b.charAt(j-1))
					L[i][j] = L[i-1][j-1] +1;
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}

		System.out.println("Longest length of common sub-sequence: " + L[M][N]);

	//to find longest common sub-sequence sting
		String ans = "";
		int i = M;
		int j = N;

		while(i>0)
		{
			int flag = 0;
			while(j>0)
			{
				if(L[i][j] > Math.max(L[i][j-1], L[i-1][j]))
				{
					ans = b.charAt(j-1) + ans;

					flag = 1;
					i--;
					j--;
					break;
				}
				else if(L[i][j] == L[i][j-1])
				{
					j--;
				}	
				else if(L[i][j] == L[i-1][j])
				{
					i--;
				}					
			}

			if(flag==0)
				i--;
		}
		
		System.out.println("Longest common sub-sequence: " + ans);		
	}
}