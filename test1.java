class test0
{
	static
	{
		System.out.println("h1");
	}
}

class test2 extends test0
{
	static
	{
		System.out.println("h2");
	}
}

class test3 extends test2
{
	static
	{
		System.out.println("h3");
	}
}

public class test1
{
	public static void main(String[] args) {
		test3 a = new test3();
	}
}