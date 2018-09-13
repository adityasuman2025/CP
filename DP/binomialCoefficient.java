import java.util.*;

public class binomialCoefficient 
{
	static void binaryCoff(int n, int k)
	{
		int L[][] = new int[n+1][k+1];

		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=Math.min(i,k); j++)
			{			
				if(i==j || j==0) // base condition
				{
					L[i][j] = 1;
				}
				else //calculating values from previously stored values
				{
					L[i][j] = L[i-1][j-1] + L[i-1][j];
				}
			}
		}

		for(int[] a : L)
		{
			System.out.println(Arrays.toString(a));

		}
		System.out.println(L[n][k]);
	}

	public static void main(String[] args) 
	{
		binaryCoff(2,1);		
	}	
}