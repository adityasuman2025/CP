class hello
{
	public static void hello()
	{
		System.out.println("HELlo world");
	}
}

public class static_test
{

	static int hello = 85;
	
	
	public void display()
	{
		System.out.println(hello);
	}
	
	static
	{
		hello = 9;
	} 

	public static void main(String args[])
	{
		static_test obj = new static_test();
		obj.display();

		hello = 50;

		obj.hello = 10;
		obj.display();

		System.out.println(hello);


		
		static_test obj2 = new static_test();
		obj2.display();

		hello obj_ = new hello();

		obj_.hello();
	}
}