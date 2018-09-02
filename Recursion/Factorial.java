class world
{
	int a = 0;

	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}

class Factorial
{
	static int factorial(int n)
	{
		if(n == 0) //base case
		{
			return 1;
		}
		return n * factorial(n-1);
	}

	public static void main(String[] args) 
	{
		System.out.println(factorial(5));			
		System.out.println(factorial(7));			
	}
}