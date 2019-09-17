simport java.util.*;

public class knapsack 
{
	static void knapsack(int W, int wt[], int val[])
	{
		int n = wt.length;
		int L[][] = new int[n+1][W+1];

		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=W; j++)
			{			
				if(i==0 || j==0) // base condition
				{
					L[i][j] = 0;
				}
				else if(j< wt[i-1])
				{
					L[i][j] = L[i-1][j];
				}
				else //calculating values from previously stored values
				{
					L[i][j] = Math.max(val[i-1] + L[i-1][j-wt[i-1]], L[i-1][j]);
				}
			}
		}

		System.out.println(L[n][W]);
	}

	public static void main(String[] args) 
	{
		int wt[] = {1,3,4,5};
		int val[] = {1,4,5,7};
		int W = 7;

		knapsack(W, wt, val);		
	}	
}