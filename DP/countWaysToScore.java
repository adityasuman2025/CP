public class countWaysToScore
{
	static void countWays(int n)
	{
		int table[] = new int[n+1];

	//base condition //way to score 0 is only one
		table[0] = 1;

	//performing our required operations
		for(int i =3; i<=n; i++)
		{
			table[i] += table[i-3];
		}

		for(int i =5; i<=n; i++)
		{
			table[i] += table[i-5];
		}

		for(int i =10; i<=n; i++)
		{
			table[i] += table[i-10];
		}

		System.out.println(table[n]);
	}

	public static void main(String[] args) 
	{
		//ways tp score a value by using points of 3, 5 and 10 only
		countWays(15);
	}	
}