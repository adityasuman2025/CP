import java.util.*;

public class longestPalindSubSeq
{
	static void LPS(String s)
	{
		int n = s.length();

		int L[][] = new int[n][n];

	//diagonals of the matrix or single letters are always a palindrome
		for(int i =0; i<n; i++)
		{
			L[i][i] = 1;
		}

	//finding palindrome of len greater than or equal to 2
		for(int len =2; len<=n; len++)
		{
			for(int i=0; i<n-len+1; i++)
			{
				int j = i+len-1;
				if(s.charAt(i) == s.charAt(j)) //trim if last characters match and add 2
				{
					L[i][j] = L[i+1][j-1] + 2;
				}
				else
				{
					L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
				}
			}
		}

		System.out.println(L[0][n-1]);
	}

	public static void main(String[] args) 
	{
		LPS("LPASL");
	}
}