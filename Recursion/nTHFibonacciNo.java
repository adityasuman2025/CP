class nTHFibonacciNo
{
//recursive in this case in not much benefitial as the recursion become too long
	static int fibonacci(int n)
	{
		if(n<2)
		{
			return n;
		}
		else
		{
			int k = fibonacci(n-1) + fibonacci(n-2);
			return k;
		}
	}

//so trying a itterative solution for fibonacci problems
	static int itr_fib(int n)
	{
		int f1 = 1;
		int f0  =0;
		int f =0 ;

		for(int i=2; i<=n; i++)
		{
			f = f1+f0;
			f0 = f1;
			f1 = f; 
		}

		return f;
	}

	public static void main(String[] args) 
	{
		int ans = fibonacci(6-1);

		System.out.print(ans);
	}

}