import java.util.*;

public class longestComSubSeq
{
	static void LCS(String arr1, String arr2)
	{
		int L[][] = new int[arr1.length()+1][arr2.length()+1];

		for(int i=0; i<=arr1.length(); i++)
		{
			for(int j=0; j<=arr2.length(); j++)
			{
				if(i == 0 || j ==0)
				{
					L[i][j] = 0;
				}
				else if(arr1.charAt(i-1) == arr2.charAt(j-1))
				{
					L[i][j] = L[i-1][j-1] +1;
				}
				else
				{
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}

		System.out.println(Arrays.toString(L));
		System.out.println(L[arr1.length()][arr2.length()]);
	}

	public static void main(String[] args) 
	{
		LCS("abcgdf", "gaebcfdk");
	}	
}