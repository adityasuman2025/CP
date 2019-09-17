class A
{
	
}
class Test
{
	static int a;
	Test()
	{
		System.out.println(a++);
	}

	public static void main(String[] args) 
	{
		a = 1;
		Test a[] = new Test[100];
		a[0] = new Test();
		//A ab = new A();
	}
}