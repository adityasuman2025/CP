

public class Recursion
{
	public static int Summation(int n)
	{
		//base case: We are at the end
		if(n<=0)
		{
			return 0;
		}
		//recursive case: keep going
		else
		{
			return n + Summation(n-1);
		}
	}

	public static int Factorial(int n)
	{
		//base case: We are at the end
		if(n<=1)
		{
			return 1;
		}
		//recursive case: keep going
		else
		{
			return n * Factorial(n-1);
		}
	}

	public static int Expo(int n, int p)
	{
		//base case: We are at the end
		if(p<=0)
		{
			return 1;
		}
		//recursive case: keep going
		else
		{
			return n * Expo(n, p-1);
		}
	}

	//multiply n*k
	// n+n+n..(k times)
	//eg. 3*4
	//3+3+3+3
	public static int Mult(int n, int k)
	{
		if(k>1)
		{
			return n + Mult(n, k-1);
		}
		else
		{
			return n;
		}
	}

	public static void main(String args[])
	{
		System.out.println(Summation(3));
		System.out.println(Factorial(5));
		System.out.println(Expo(5, 3));

		System.out.println(Mult(4, 3));
	}
}