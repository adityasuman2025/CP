import java.util.*;

public class editDistance
{
	static void distance(String a, String b)
	{
		int m = a.length();
		int n = b.length();

		int L[][] = new int[m+1][n+1];

		for(int i =0; i<=m; i++)
		{
			for(int j = 0; j<=n; j++)
			{
				if(i ==0)
				{
					L[i][j] = j;
				}
				else if(j ==0)
				{
					L[i][j] = i;
				}
				else if(a.charAt(i-1) == b.charAt(j-1))
				{
					L[i][j] = L[i-1][j-1];
				}
				else
				{
					int min = Math.min(L[i-1][j], L[i][j-1]);
					L[i][j] = Math.min(min, L[i-1][j-1]) + 1;
								 //min(L[i-1][j], L[i][j-1], L[i-1][j-1])
									//	remove		//insert	//replace
				}
			}
		}

		System.out.println(L[m][n]);
	}

	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
        
        for(int i =0; i<T; i++)
        {
            String size = scanner.nextLine();
            String string[] = scanner.nextLine().split(" ");

            distance(string[0], string[1]);
        }
	}	
}