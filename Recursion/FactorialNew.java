class FactorialNew
{
	static int mult(int n)
	{
		if(n>1)
		{
			return n*mult(n-1);
		}
		else
		{
			return 1;
		}
	}

	public static void main(String[] args) 
	{
		int n = 0;
		System.out.println(mult(n));
	}
}